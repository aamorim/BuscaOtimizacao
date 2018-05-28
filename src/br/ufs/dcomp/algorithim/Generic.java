/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufs.dcomp.algorithim;

import java.util.Random;

/**
 * @version 1.0
 * @author Alex de Santana Amorim <alex.santana.amorim@gmail.com>
 * @date   07/05/2018 22:16:37
 * 
 * Classe Generica para implementação dos algoritimos do 
 * livro Essentials of Metaheuristics.
 */
public abstract class Generic {

    private int lengthVector;  // tamanho do vetor solução;
    private int minValueArray; // valor minimo a ser preenchido no array 
    private int maxValueArray; // valor maximo a ser preenchido no vetor
    private Tweak tweak;       // parametros do Tweak
    private boolean printQuality;
    
    
    public Generic(int lengthVector, int minValueArray, int maxValueArray, Tweak tweak) {
        this.lengthVector = lengthVector;
        this.minValueArray = minValueArray;
        this.maxValueArray = maxValueArray;
        this.tweak = tweak;
        this.printQuality = false;
    }
   
    //Inicio da solução com valores aleatorios
    public double[] initSolution(){
        double[] vector = new double[this.lengthVector];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = random();  
        }
        return vector;
    }
    
    /*
    * Gera valores aleatorios baseado em valores minimos e máximos
    * definidos no construtor da classe
    */
    public double random() {
        double aleatorio = 0;
        double inicial = Math.random(); // Gera valores aleatorios entre 0 e 1
        
        if (inicial < 0.5 && this.minValueArray < 0) {
            aleatorio = Math.random() * this.maxValueArray * -1;
        } else {
            aleatorio = Math.random() * this.maxValueArray * 1;
        }
        return aleatorio;
    }
    
    /*
    * Gera valores aleatorios baseado em valores minimos e máximos
    * definidos nos parametros
    * @minValue valor mínimo
    * @rValue valor máximo
    */
    public double random(double rValue) {
        double aleatorio = 0;
        double inicial = Math.random(); // Gera valores aleatorios entre 0 e 1
        
        if (inicial < 0.5) {
            aleatorio = Math.random() * rValue * -1;
        } else {
            aleatorio = Math.random() * rValue * 1;
        }
        return aleatorio;
    }
    
    
    /*
    * Implementação do Algorithm 8 Bounded Uniform Convolution
    * @vector a ser alterado
    * @p probabilidade de alterar a posição do vetor
    * @minRange Valor mínimo do range
    * @maxRange Valor máximo do range
    */
    public double[] tweak(double[] vector) {
        double n = 0.0;
        for (int i = 0; i < vector.length; i++) {
            if (tweak.getP() >= Math.random()) {
                do {
                    n = random(tweak.getR());
                } while (((vector[i] + n) < this.minValueArray) || ((vector[i] + n) > this.maxValueArray));
                
                double soma = (vector[i] + n);
                
                //trunc entre os valores do vetor
                if(soma <= this.maxValueArray || soma >= this.minValueArray){
                    vector[i] = soma;
                }
                                 
            }

        }
        return vector;
    }

    /**
     * @param x Valor a ser comparado com Y
     * @param y Valor a ser comparado com X
     * @return o maior valor
     */
    public double max(double x, double y){
        return x>=y?x:y;
    }
    
    public void printQuality(double quality, int cont){
        if(isPrintQuality()){
           // System.out.println("Quality: " + quality + " Count: " + cont);
             System.out.println(quality);
        } 
    }
    
    public void writeFile(){
        
    }

    public boolean isPrintQuality() {
        return printQuality;
    }

    public void setPrintQuality(boolean printQuality) {
        this.printQuality = printQuality;
    }

    public int getMinValueArray() {
        return minValueArray;
    }

    public int getMaxValueArray() {
        return maxValueArray;
    } 
    
        
    public abstract double quality(double[] s);
    
    public abstract double[] exe(int interaction);
    
    
}
