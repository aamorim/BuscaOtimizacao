/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufs.dcomp.main;

import br.ufs.dcomp.algorithim.Tweak;
import br.ufs.dcomp.function.RastriginHillClimbing;
import br.ufs.dcomp.function.RastriginILS;
import br.ufs.dcomp.function.RastriginSimulatedAnnealing;
import br.ufs.dcomp.function.RastriginTabu;
import br.ufs.dcomp.function.RosenbrockHillClimbing;
import br.ufs.dcomp.function.RosenbrockILS;
import br.ufs.dcomp.function.RosenbrockSimulatedAnnealing;
import br.ufs.dcomp.function.RosenbrockTabu;
import br.ufs.dcomp.function.SchwefelHillClimbing;
import br.ufs.dcomp.function.SchwefelILS;
import br.ufs.dcomp.function.SchwefelSimulatedAnnealing;
import br.ufs.dcomp.function.SchwefelTabu;
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
       int interaction = 100000;
       int algoritimo;
       System.out.println("Escolha o algoritimo:");
       System.out.println("1 - Hill-Climbing        [Sphere]");
       System.out.println("2 - Simulated Annealing  [Sphere]");
       System.out.println("3 - Tabu                 [Sphere]");
       System.out.println("4 - ILS                  [Sphere]");
       System.out.println("5 - Hill-Climbing        [Schwefel]");
       System.out.println("6 - Simulated Annealing  [Schwefel]");
       System.out.println("7 - Tabu                 [Schwefel]");
       System.out.println("8 - ILS                  [Schwefel]");
       System.out.println("5 - Hill-Climbing        [Schwefel]");
       System.out.println("6 - Simulated Annealing  [Schwefel]");
       System.out.println("7 - Tabu                 [Schwefel]");
       System.out.println("8 - ILS                  [Schwefel]");
       System.out.println("9 - Hill-Climbing        [Rosenbrock]");
       System.out.println("10 - Simulated Annealing [Rosenbrock]");
       System.out.println("11 - Tabu                [Rosenbrock]");
       System.out.println("12 - ILS                 [Rosenbrock]");
       System.out.println("13 - Hill-Climbing       [Rastrigin]");
       System.out.println("14 - Simulated Annealing [Rastrigin]");
       System.out.println("15 - Tabu                [Rastrigin]");
       System.out.println("16 - ILS                 [Rastrigin]");
       algoritimo = in.nextInt();
       
        switch (algoritimo) {
            case 1:
                tweak = new Tweak(0.01, -1, 1);
                SphereHillClimbing alg1 = new SphereHillClimbing(100, -100, 100, tweak);
                alg1.exe(interaction);
                break;
            case 2:
                tweak = new Tweak(0.01, -1, 1);
                SphereSimulatedAnnealing alg2 = new SphereSimulatedAnnealing(100, -100, 100, tweak, 100);
                alg2.exe(interaction);
                break;
            case 3:
                tweak = new Tweak(0.01, -1, 1);
                SphereTabu alg3 = new SphereTabu(100, -100, 100, tweak, 100, 30);
                alg3.exe(interaction);
                break;
            case 4:
                tweak = new Tweak(0.01, -1, 1);
                SphereILS alg4 = new SphereILS(100, -100, 100, tweak);
                alg4.exe(interaction);
                break;
            case 5:
                tweak = new Tweak(0.1,  -5, 4);
                SchwefelHillClimbing alg5 = new SchwefelHillClimbing(100, -100, 100, tweak);
                alg5.exe(interaction);
                break;
            case 6:
                tweak = new Tweak(0.2,  -4, 4);
                SchwefelSimulatedAnnealing alg6 = new SchwefelSimulatedAnnealing(100, -100, 100, tweak, 100);
                alg6.exe(interaction);
                break;
            case 7:
                tweak = new Tweak(0.01, -1, 1);
                SchwefelTabu alg7 = new SchwefelTabu(100, -100, 100, tweak, 100, 30);
                alg7.exe(interaction);
                break;
            case 8:
                tweak = new Tweak(0.01,  -1, 1);
                SchwefelILS alg8 = new SchwefelILS(100, -100, 100, tweak);
                alg8.exe(interaction);
                break;
            case 9:
                tweak = new Tweak(0.01,  -1, 1);
                RosenbrockHillClimbing alg9 = new RosenbrockHillClimbing(100, -100, 100, tweak);
                alg9.exe(interaction);
                break;
            case 10:
                tweak = new Tweak(0.01,  -1, 1);
                RosenbrockSimulatedAnnealing alg10 = new RosenbrockSimulatedAnnealing(100, -100, 100, tweak, 100);
                alg10.exe(interaction);
                break;
            case 11:
                tweak = new Tweak(0.01,  -1, 1);
                RosenbrockTabu alg11 = new RosenbrockTabu(100, -100, 100, tweak, 100, 30);
                alg11.exe(interaction);
                break;
            case 12:
                tweak = new Tweak(0.01,  -1, 1);
                RosenbrockILS alg12 = new RosenbrockILS(100, -100, 100, tweak);
                alg12.exe(interaction);
                break;
            case 13:
                tweak = new Tweak(0.01, -1, 1);
                RastriginHillClimbing alg13 = new RastriginHillClimbing(100, -100, 100, tweak);
                alg13.exe(interaction);
                break;
            case 14:
                tweak = new Tweak(0.01, -1, 1);
                RastriginSimulatedAnnealing alg14 = new RastriginSimulatedAnnealing(100, -100, 100, tweak, 100);
                alg14.exe(interaction);
                break;
            case 15:
                tweak = new Tweak(0.01, -1, 1);
                RastriginTabu alg15 = new RastriginTabu(100, -100, 100, tweak, 100, 30);
                alg15.exe(interaction);
                break;
            case 16:
                tweak = new Tweak(0.01, -1, 1);
                RastriginILS alg16 = new RastriginILS(100, -100, 100, tweak);
                alg16.exe(interaction);
                break;
        }
       
       
       
    }
    
    
    
    
}
