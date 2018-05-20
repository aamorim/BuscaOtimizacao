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
 * @date   20/05/2018 14:34:31
 */
public class RosenbrockSimulatedAnnealing extends SimulatedAnnealing{

    public RosenbrockSimulatedAnnealing(int lengthVector, int minValueArray, int maxValueArray, Tweak tweak, int temperature) {
        super(lengthVector, minValueArray, maxValueArray, tweak, temperature);
    }

    @Override
    public double quality(double[] z) {
        double F = 0.0;

        for (int i = 0; i < z.length - 1; i++) {
            F += 100 * Math.pow((Math.pow(z[i], 2) - z[i + 1]), 2)
                    + Math.pow((z[i] - 1), 2);
        }

        return F;
    }

}
