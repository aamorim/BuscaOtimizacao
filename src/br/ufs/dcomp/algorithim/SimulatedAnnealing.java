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
 * @date   07/05/2018 21:24:15
 */
public abstract class SimulatedAnnealing extends Generic{

    private int temperature;
    
    public SimulatedAnnealing(int lengthVector, int min, int max, int temperature) {
        super(lengthVector, min, max);
        this.temperature = temperature;
    }

    @Override
    public double[] exe(int num_int) {
        double S[] = initSolution();
        double Best[] = S;
        double[] vectorEvolution = new double[num_int];
        for (int i = 0; i < num_int || temperature == 0; i++) {
           vectorEvolution[i] = quality(Best);
            double R[] = tweak(S.clone());
            if(quality(S)> quality(R) || 
                    Math.random() < Math.pow(Math.E, (quality(R)- quality(S))/temperature)){
                S = R;
            }
            temperature --;
            
            if(quality(S) > quality(Best)){
                Best = S;
            }           
           // System.out.println(vectorEvolution[i]);
        }
       // System.out.println(Arrays.toString(Best));
        return Best;
    }
    
    

}
