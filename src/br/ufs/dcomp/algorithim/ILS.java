/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufs.dcomp.algorithim;

/**
 * @version 
 * @author Alex de Santana Amorim <alex.santana.amorim@gmail.com>
 * @date   07/05/2018 21:23:59
 */
public abstract class ILS extends Generic{

    private int n;
    
    
    public ILS(int lengthVector, int min, int max,int nTweaks) {
        super(lengthVector, min, max);
        this.n = nTweaks;
    }

  
    public double[] exe(int num_int) {
        
        int[] T = timeIntervals(num_int); //distribuição de possíveis intervalos de tempo
        double[] S = initSolution(); //alguma solução candidata inicial 
        double[] H = S;
        double[] Best = S;
        double[] R;
        double a = Math.random()*num_int;
        int times = T[(int)a]; //tempo aleatório no futuro próximo, escolhido de T
       
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < n; j++) {
                R = tweak(S.clone());
                if (quality(R) > quality(S)) {
                    S = R;
                }
            }
            if(quality(S) > quality(Best)){
                Best = S;
            }
            H = newHomeBase(H, S);
            S = perturb(H);
            
           // System.out.println(quality(Best));
        }
        // System.out.println(quality(Best));
        return Best;
    }
    
    
    public double[] perturb(double[] vetor) {
        double n;

        for (int i = 0; i < vetor.length; i++) {
            if (0.7 >= Math.random()) {
                do {
                    n = random();

                } while ((vetor[i] + n < minValueArray) || (vetor[i] + n > maxValueArray));
                vetor[i] = vetor[i] + n;
            }

        }
        return vetor;
    }

    public double[] newHomeBase(double[] h, double[] s) {
        if (quality(s) < quality(h)) {
            return s;
        } else {
            return h;
        }
    }
    
    private int[] timeIntervals(int length){
        int[] T = new int[length];
        
        for (int i = 0; i < T.length; i++) {
            T[i] = (int) Math.random() * 100;
            
        }
        return T;
    }

    

}
