/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufs.dcomp.algorithim;


/*
*
*/
public abstract class HillClimbing extends Generic{

    /**
     * @param lengthVector Tamanho do vetor solução
     * @param minValueArray mínimo valor a ser preenchido no vetor solução
     * @param maxValueArray máximo valor a ser preenchido no vetor solução
     */
    public HillClimbing(int lengthVector, int minValueArray, int maxValueArray, Tweak tweak) {
        super(lengthVector, minValueArray, maxValueArray, tweak);
    }  
    
    /**
     * @return
     */    
    public double[] exe(int interaction){
        int cont = 0;
        double[] S = initSolution();
        double[] R ; 
       
        do {  
            R = tweak(S.clone());
            if (quality(R) < quality(S)) {
                S = R;                
            }
            System.out.println("Qualy: " + quality(S) + " Count: " + cont);
            cont ++;
        } while (cont < interaction );
        
        return S;
    }



}