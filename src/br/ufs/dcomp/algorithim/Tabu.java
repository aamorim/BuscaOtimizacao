/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufs.dcomp.algorithim;

import java.util.Arrays;

/**
 * @version 1.0
 * @author Alex de Santana Amorim <alex.santana.amorim@gmail.com>
 * @date   07/05/2018 21:23:47
 */
public abstract class Tabu extends Generic{

    private int listLength;               //Comprimento máximo da lista tabu desejado
    private int n;                        //número de ajustes desejados para amostrar o gradiente
    private int controlLengthTabuList;   //controle das posições da lista tabu

    //Constutor da classe
    public Tabu(int lengthVector, int minValueArray, int maxValueArray, Tweak tweak, int tabuListLength, int nTweaks) {
        super(lengthVector, minValueArray, maxValueArray, tweak);
        this.listLength = tabuListLength;
        this.n = nTweaks;
        this.controlLengthTabuList = 0;
    }

    @Override
    public double[] exe(int interaction) {
        int cont = 0;
        double[] S = initSolution(); //alguma solução candidata inicial
        double[] Best = S;           //Melhor solução
        double[] R;
        double[] W;
        double[][] L = new double[listLength][1]; //uma lista tabu de tamanho máximo listLength
        
        //Enfileirar S em L
        push(S, L);
        
        do {
            
            if (this.controlLengthTabuList + 1 > listLength) {
                pull(L);
            }
            R = tweak(S.clone());

            //número de ajustes desejados para amostrar o gradiente
            for (int j = 0; j < n; j++) {
                W = tweak(S.clone());
                if (!belongsTo(W, L) && (quality(W) < quality(R) || belongsTo(R, L))) {
                    R = W;
                }
            }
            if (!belongsTo(R, L)) {
                S = R;
                push(R, L);
            }
            if (quality(S) < quality(Best)) {
                Best = S;
            }
            cont ++;
            printQuality(quality(Best), cont);
        } while (cont < interaction || quality(Best) == 0);

       // System.out.println(Arrays.toString(L[L.length-1]));
        //System.out.println(Arrays.toString(Best));
        return Best;
    }

    //Enfileira o vetor S no vetor L
    private void push(double[] vectorS, double[][] vectorL){     
        vectorL[incrementLengthQueue()] = convert(vectorS);
        //vectorL[incrementLengthQueue()] = vectorS;
    }
    
    //Remover o objeto mais antigo da fila
    private void pull(double[][] vectorL){
        for (int i = 0; i < vectorL.length-1; i++) {
            vectorL[i] = vectorL[i+1];
        }
        vectorL[vectorL.length-1] = new double[100];
        decreasetLengthQueue();
    }
    
    
    //Convereter valores em inteiros
    private double[] convert(double[] vector) {
        double[] v = vector.clone();
        for (int i = 0; i < v.length; i++) {
            v[i] = (int) v[i];
        }        
        return v;
    }
    
   //Verifica se o vetor pertence ao vetor solução
    private boolean belongsTo(double[] vectorS, double[][] vectorL){        
        boolean belongsTo  = false;
        vectorS = convert(vectorS);
        for (double[] vectorL1 : vectorL) {
            if (Arrays.equals(vectorS, vectorL1)) {
                return true;
            }
        }
        return belongsTo;
    }


    //incrementar
    private int incrementLengthQueue(){
        return controlLengthTabuList++;
    }

     private int decreasetLengthQueue(){
        return controlLengthTabuList--;
    }
    
}
