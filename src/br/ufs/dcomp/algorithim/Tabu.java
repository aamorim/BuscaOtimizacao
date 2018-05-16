/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufs.dcomp.algorithim;

import java.util.Arrays;

/**
 * @version
 * @author Alex de Santana Amorim <alex.santana.amorim@gmail.com>
 * @date   07/05/2018 21:23:47
 */
public abstract class Tabu extends Generic{

    private int l; //Comprimento máximo da lista tabu desejado
    private int n; //número de ajustes desejados para amostrar o gradiente
    private int cont; //controle das posições da lista tabu

    //Constutor da classe
    public Tabu(int lengthVector, int min, int max, int tabuListLength, int nTweaks) {
        super(lengthVector, min, max);
        this.l = tabuListLength;
        this.n = nTweaks;
        this.cont = 0;
    }

    @Override
    public double[] exe(int num_int) {
        
        double[] S = initSolution(); //alguma solução candidata inicial
        double[] Best = S;
        double[] R;
        double[] W;
        double[][] L = new double[l][1]; //uma lista tabu de tamanho máximo l
        
        //Enfileirar S em L
        push(S, L);

        for (int i = 0; i < num_int; i++) {
            if(this.cont+1 > l){
                pull(L);
            }
            R = tweak(S.clone());
            
            //número de ajustes desejados para amostrar o gradiente
            for (int j = 0; j < n ; j++) {
               W = tweak(S.clone());
               if(!belongsTo(W, L) && (quality(W) > quality(R) || belongsTo(R, L))){                  
                   R = W;
               }               
            }
            if(!belongsTo(R, L)){
                S = R;
                push(R, L);
            }
            if(quality(S) > quality(Best)){
                Best = S;
            }
          //  System.out.println(quality(Best));
        }
       // System.out.println(Arrays.toString(L[L.length-1]));
        //System.out.println(Arrays.toString(Best));
        return Best;
    }

    //Enfileira o vetor S no vetor L
    private void push(double[] vectorS, double[][] vectorL){
        vectorL[incrementLengthQueue()] = vectorS;
    }
    
    //Remover o objeto mais antigo da fila
    private void pull(double[][] vectorL){
        for (int i = 0; i < vectorL.length-1; i++) {
            vectorL[i] = vectorL[i+1];
        }
        vectorL[vectorL.length-1] = new double[100];
        decreasetLengthQueue();
    }
    
   //Verifica se o vetor pertence ao vetor solução
    private boolean belongsTo(double[] vectorS, double[][] vectorL){        
        boolean belongsTo  = true;
        for (int i = 0; i < vectorL.length; i++) {
            double[] tmp = vectorL[i];
            belongsTo  = true;
            for (int j = 0; j < tmp.length; j++) {
                if(tmp[j] != vectorS[j]){
                    belongsTo = false;
                    break;
                }                
            }
        }
        return belongsTo;
    }


    //incrementar
    private int incrementLengthQueue(){
        return cont++;
    }

     private int decreasetLengthQueue(){
        return cont--;
    }
    
}
