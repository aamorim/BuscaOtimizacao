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
 * @date   07/05/2018 21:24:15
 */
public abstract class SimulatedAnnealing extends Generic{

    private double temperature; // Variável para controle da Temperatura
    
    public SimulatedAnnealing(int lengthVector, int minValueArray, int maxValueArray, Tweak tweak, int temperature) {
        super(lengthVector, minValueArray, maxValueArray, tweak);
        this.temperature = temperature;
    }

    @Override
    public double[] exe(int interaction) {
        int cont = 0;
        double S[] = initSolution();
        double Best[] = S;
        
        do {            
            double R[] = tweak(S.clone());
            //System.out.println("Exponencial: " + Math.pow(Math.E, (quality(S) - quality(R)) / temperature) + " Temperatura: " + temperature);
           // System.out.println("Quality R: "+ quality(R) +" Quality S: " + quality(S));
           // System.out.println("----");
            if (quality(R) < quality(S) 
                    || Math.random() < Math.pow(Math.E, (quality(S) - quality(R)) / temperature)) {
                S = R;
            }
            
            
            temperature = temperature > 0 ? temperature-0.01 : 0;
            
            if(quality(S) < quality(Best)){
                Best = S;
            }
            
            cont ++;
            System.out.println("Qualy: " + quality(Best) + " Count: " + cont);
        } while (cont < interaction || quality(S) == 0);

        return Best;
    }
    
    

}
