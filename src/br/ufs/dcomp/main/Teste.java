/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufs.dcomp.main;

import java.util.Random;

/**
 *
 * @author alex.amorim
 */
public class Teste {
    
    public static void main(String[] args) {
        Random r = new Random();
        
        for (int i = 0; i < 100; i++) {
           System.out.println(Math.random()); 
        }
    }
    
}
