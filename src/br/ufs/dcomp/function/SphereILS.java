/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufs.dcomp.function;

import br.ufs.dcomp.algorithim.ILS;
import br.ufs.dcomp.algorithim.Tweak;

/**
 * @version 
 * @author Alex de Santana Amorim <alex.santana.amorim@gmail.com>
 * @date   07/05/2018 23:34:12
 */
public class SphereILS extends ILS{

    public SphereILS(int lengthVector, int minValueArray, int maxValueArray, Tweak tweak) {
        super(lengthVector, minValueArray, maxValueArray, tweak);
    }   
    
    @Override
    public double quality(double[] a) {
        double funcao = 0.0;
        for (int i = 0; i < a.length; i++) {
            funcao += a[i] * a[i];
        }
        return (funcao);
    }   
}
