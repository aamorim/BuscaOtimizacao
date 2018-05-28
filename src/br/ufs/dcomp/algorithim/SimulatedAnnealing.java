/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufs.dcomp.algorithim;

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
        double decrement = temperature/interaction;
       // double worseSolution = qualityWorseSolution(S.length);
        
        
        do {            
            double R[] = tweak(S.clone());
            System.out.println("qly S: " + quality(S)+ " qly R: " + quality(R) + " t: "+ temperature + " s-r: " + (quality(S) - quality(R)));
            
            double calculo = Math.exp((quality(S) - quality(R)) / temperature);
            double randon =  Math.random();  
            
            System.out.println("randon: " + randon + " sa: " + calculo);
            if (quality(R) < quality(S) || randon < calculo) {
                S = R;
            }
            temperature = temperature > 0 ? temperature-decrement : 0;
            
            if(quality(S) < quality(Best)){
                Best = S;
            }
            
            cont ++;
            printQuality(quality(Best), cont);
        } while (cont < interaction || quality(S) == 0);

        return Best;
    }
    
    
    public double qualityWorseSolution(int length){
        double[] array = new double[length];
        for (int i = 0; i < length; i++) {
            array[i] = getMaxValueArray();            
        }        
        return quality(array);
    }

}
