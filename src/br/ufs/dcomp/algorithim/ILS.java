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
    private Tweak tweak;
    
    
    public ILS(int lengthVector, int minValueArray, int maxValueArray, Tweak tweak) {
        super(lengthVector, minValueArray, maxValueArray, tweak);
        this.tweak = tweak;
    }

  
    @Override
    public double[] exe(int interaction) {
        int cont = 0;  
        int contTime = 0;
        double[] S = initSolution(); //alguma solução candidata inicial 
        double[] H = S;
        double[] Best = S;
        double[] R;
        
       
        do {            
             int times = (int) (Math.random() * S.length); //tempo aleatório no futuro próximo, escolhido de T
             
            do {                
                R = tweak(S.clone());
                if (quality(R) < quality(S)) {
                    S = R;
                }
                contTime ++;
            } while (contTime < times);
            
            contTime = 0;
            
            if(quality(S) < quality(Best)){
                Best = S;
            }
            System.out.println("Qualy: " + quality(Best) + " Count: " + cont);
            H = newHomeBase(H, S);
            S = perturb(H.clone(), tweak.getP());
            
            cont ++;
            
        } while (cont < interaction);
       
        return Best;
    }
    
    
    public double[] perturb(double[] vetor, double p) {
        double n;

        for (int i = 0; i < vetor.length; i++) {
            if (p >= Math.random()) {
                do {
                    n = random();

                } while ((vetor[i] + n < tweak.getMinRange()) || (vetor[i] + n > tweak.getMaxRange()));
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
    


    

}
