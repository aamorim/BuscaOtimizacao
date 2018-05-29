/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufs.dcomp.main;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author alex.amorim
 */
public class Teste {
    
    public static void main(String[] args) {
        
        double a[] = {0.1,0.2};
        double b[] = {0.3,0.2};
 
        if(Arrays.equals(a,b)){
            System.out.println("Igual");
        }else{
            System.out.println("diferente");
        }
    }
    
}
