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
 * @date   19/05/2018 14:26:02
 */
public class SchwefelHillClimbing  extends HillClimbing{

    public SchwefelHillClimbing(int lengthVector, int minValueArray, int maxValueArray, Tweak tweak) {
        super(lengthVector, minValueArray, maxValueArray, tweak);
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

    /**
     * @param x Valor a ser comparado com Y
     * @param y Valor a ser comparado com X
     * @return o maior valor
     */
    private double max(double x, double y){
        return x>=y?x:y;
    }
}
