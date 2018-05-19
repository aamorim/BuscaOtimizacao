/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufs.dcomp.main;

import br.ufs.dcomp.algorithim.HillClimbing;
import br.ufs.dcomp.algorithim.Tweak;
import br.ufs.dcomp.function.SchwefelHillClimbing;
import br.ufs.dcomp.function.SphereHillClimbing;
import br.ufs.dcomp.function.SphereILS;
import br.ufs.dcomp.function.SphereSimulatedAnnealing;
import br.ufs.dcomp.function.SphereTabu;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Classe principal de execução
 * @author alex.amorim
 * 
 * Implementar a função de bechmarking Sphere. Por enquanto, não precisa 
 * aplicar a translação e o bias. 
 * Isso indica que o valor mínimo da função é 0 e a solução ótima é [0, 0 ,..., 0]
 * Implementar o algoritmo básico do Hill Climbing. Implementar duas funções de tweak.
 * Variar os seguintes parâmetros:
 * Número de iterações do algoritmo
 * Métodos de tweak e os valores dos parâmetros dos métodos implementados.
 * 
 */
public class Main {
    
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       Tweak tweak;
       int interaction = 10000000;
       int algoritimo;
       System.out.println("Escolha o algoritimo:");
       System.out.println("1 - Hill-Climbing       [Sphere]");
       System.out.println("2 - Simulated Annealing [Sphere]");
       System.out.println("3 - Tabu                [Sphere]");
       System.out.println("4 - ILS                 [Sphere]");
       System.out.println("5 - Hill-Climbing       [Schwefel]");
       algoritimo = in.nextInt();
       
       switch(algoritimo){
           case 1:
               tweak = new Tweak(0.01, -100, 100);
               SphereHillClimbing alg1 = new SphereHillClimbing(100, -100, 100, tweak);
               alg1.exe(interaction);
           case 2:
               tweak = new Tweak(0.01, -100, 100);
               SphereSimulatedAnnealing alg2 = new SphereSimulatedAnnealing(100,-100,100,tweak, 100);
               alg2.exe(interaction);
          case 3:
               tweak = new Tweak(0.01, -100, 100);
               SphereTabu alg3 = new SphereTabu(100, -100, 100,tweak, 100, 30);
               alg3.exe(interaction);
          case 4:
               tweak = new Tweak(0.01, -100, 100);
               SphereILS alg4 = new SphereILS(100, -100, 100, tweak);
               alg4.exe(interaction);
          case 5:
              tweak = new Tweak(0.01, -100, 100);
              SchwefelHillClimbing alg5 = new SchwefelHillClimbing(100, -100, 100, tweak);
              alg5.exe(interaction);
       }
       
       
       
    }
    
    
    
    
}
