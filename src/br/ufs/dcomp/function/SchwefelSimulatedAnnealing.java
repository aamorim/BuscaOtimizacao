/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufs.dcomp.function;

import br.ufs.dcomp.algorithim.SimulatedAnnealing;
import br.ufs.dcomp.algorithim.Tweak;

/**
 * @version 
 * @author Alex de Santana Amorim <alex.santana.amorim@gmail.com>
 * @date   19/05/2018 18:05:08
 */
public class SchwefelSimulatedAnnealing extends SimulatedAnnealing{

    public SchwefelSimulatedAnnealing(int lengthVector, int minValueArray, int maxValueArray, Tweak tweak, int temperature) {
        super(lengthVector, minValueArray, maxValueArray, tweak, temperature);
    }

 

    @Override
    public double quality(double[] vector) {
        double F = Math.abs(vector[0]);
        double z;
        for (int i = 1; i < vector.length; i++) {
            z = Math.abs(vector[i]);
            F = max(F, z);            
        }
        return F;
    }

}
