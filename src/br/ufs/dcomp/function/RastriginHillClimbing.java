/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufs.dcomp.function;

import br.ufs.dcomp.algorithim.HillClimbing;
import br.ufs.dcomp.algorithim.Tweak;

/**
 * @version 
 * @author Alex de Santana Amorim <alex.santana.amorim@gmail.com>
 * @date   20/05/2018 14:43:08
 */
public class RastriginHillClimbing  extends HillClimbing{

    public RastriginHillClimbing(int lengthVector, int minValueArray, int maxValueArray, Tweak tweak) {
        super(lengthVector, minValueArray, maxValueArray, tweak);
    }

    @Override
       public double quality(double[] z) {
        double  F = 0.0;
        
        for (int i = 0; i < z.length; i++) {
            F += (Math.pow(z[i],2) - 10 * Math.cos(2 * Math.PI * z[i])+10);
            
        }
        return F;
    }

}
