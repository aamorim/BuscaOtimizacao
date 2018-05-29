/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufs.dcomp.main;

import br.ufs.dcomp.algorithim.Tweak;
import br.ufs.dcomp.function.RastriginHillClimbing;
import br.ufs.dcomp.function.RastriginSimulatedAnnealing;
import br.ufs.dcomp.function.RastriginTabu;
import br.ufs.dcomp.function.RosenbrockHillClimbing;
import br.ufs.dcomp.function.RosenbrockSimulatedAnnealing;
import br.ufs.dcomp.function.RosenbrockTabu;
import br.ufs.dcomp.function.SchwefelHillClimbing;
import br.ufs.dcomp.function.SchwefelSimulatedAnnealing;
import br.ufs.dcomp.function.SchwefelTabu;
import br.ufs.dcomp.function.SphereHillClimbing;
import br.ufs.dcomp.function.SphereSimulatedAnnealing;
import br.ufs.dcomp.function.SphereTabu;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * @version 
 * @author Alex de Santana Amorim <alex.santana.amorim@gmail.com>
 * @date   25/05/2018 21:44:12
 */
public class MainFile {
    
    
    public static void main(String[] args) throws IOException {      
        
        //hillClimbingWriteFile();
       // simulatedAnnealingWriteFile();
        TabuWriteFile();
        
    }
    
    
     public static void ILSWriteFile() throws IOException{
        double [] pValues = {0.01, 0.1, 0.5, 1.0}; //Parametros p - probavilidade
        double [] rValues = {1, 2, 4, 6};  //Parametro r - Range
        int [] nValues = {5,20,100,1000}; //Número de Tweak
        int [] tValues = {50,100,1000,10000}; //Tamanho da Lista Tabu
        
        int interaction = 100000; 
        File file = new File("tabu.txt");
        file.createNewFile();
        // Prepara para escrever no arquivo
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        Locale localeBR = new Locale( "pt", "BR" );
        NumberFormat numeroBR = NumberFormat.getNumberInstance(localeBR);
        numeroBR.setMinimumFractionDigits(10);
        numeroBR.setMaximumFractionDigits(10);
        bw.write("Combinacao;Sphere;Schwefel;Rosenbrock;Rastrigin \r\n");
        
         for (int i = 0; i < pValues.length; i++) {
             
             for (int j = 0; j < rValues.length; j++) {
                 for (int k = 0; k < nValues.length; k++) {
                     for (int l = 0; l < tValues.length; l++) {
                         bw.write("p= " + pValues[i] + ", r= " + rValues[j] + ", n= " + nValues[k] + ", t= " + tValues[l] + ";");

                         Tweak tweak = new Tweak(pValues[i], rValues[j]);

                         SphereTabu alg1 = new SphereTabu(100, -100, 100, tweak, tValues[l], nValues[k]);
                         double valg1[] = alg1.exe(interaction/nValues[k]);
                         bw.write(numeroBR.format(alg1.quality(valg1)) + ";");

                         SchwefelTabu alg5 = new SchwefelTabu(100, -100, 100, tweak, tValues[l], nValues[k]);
                         double valg5[] = alg5.exe(interaction/nValues[k]);
                         bw.write(numeroBR.format(alg5.quality(valg5)) + ";");

                        RosenbrockTabu alg9 = new RosenbrockTabu(100, -100, 100, tweak,  tValues[l], nValues[k]);
                         double valg9[] = alg9.exe(interaction/nValues[k]);
                         bw.write(numeroBR.format(alg9.quality(valg9)) + ";");

                         RastriginTabu alg13 = new RastriginTabu(100, -100, 100, tweak, tValues[l], nValues[k]);
                         double valg13[] = alg13.exe(interaction/nValues[k]);
                         bw.write(numeroBR.format(alg13.quality(valg13)) + " \r\n");

                     }
                     
                 }
             }
         }
         bw.close();
    }
    
    public static void TabuWriteFile() throws IOException{
        double [] pValues = {0.01, 0.1, 0.5, 1.0}; //Parametros p - probavilidade
        double [] rValues = {1, 2, 4, 6};  //Parametro r - Range
        int [] nValues = {5,20,100,1000}; //Número de Tweak
        int [] tValues = {50,100,1000,10000}; //Tamanho da Lista Tabu
        
        int interaction = 100000; 
        File file = new File("tabu.txt");
        file.createNewFile();
        // Prepara para escrever no arquivo
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        Locale localeBR = new Locale( "pt", "BR" );
        NumberFormat numeroBR = NumberFormat.getNumberInstance(localeBR);
        numeroBR.setMinimumFractionDigits(10);
        numeroBR.setMaximumFractionDigits(10);
        bw.write("Combinacao;Sphere;Schwefel;Rosenbrock;Rastrigin \r\n");
        
         for (int i = 0; i < pValues.length; i++) {
             System.out.println("i:"+i);
             for (int j = 0; j < rValues.length; j++) {
                  System.out.println("j:"+j);
                 for (int k = 0; k < nValues.length; k++) {
                      System.out.println("k:"+k);
                     for (int l = 0; l < tValues.length; l++) {
                         System.out.println("l:"+l);
                         bw.write("p= " + pValues[i] + ", r= " + rValues[j] + ", n= " + nValues[k] + ", t= " + tValues[l] + ";");

                         Tweak tweak = new Tweak(pValues[i], rValues[j]);

                         SphereTabu alg1 = new SphereTabu(100, -100, 100, tweak, tValues[l], nValues[k]);
                         double valg1[] = alg1.exe(interaction/nValues[k]);
                         bw.write(numeroBR.format(alg1.quality(valg1)) + ";");

                         SchwefelTabu alg5 = new SchwefelTabu(100, -100, 100, tweak, tValues[l], nValues[k]);
                         double valg5[] = alg5.exe(interaction/nValues[k]);
                         bw.write(numeroBR.format(alg5.quality(valg5)) + ";");

                        RosenbrockTabu alg9 = new RosenbrockTabu(100, -100, 100, tweak,  tValues[l], nValues[k]);
                         double valg9[] = alg9.exe(interaction/nValues[k]);
                         bw.write(numeroBR.format(alg9.quality(valg9)) + ";");

                         RastriginTabu alg13 = new RastriginTabu(100, -100, 100, tweak, tValues[l], nValues[k]);
                         double valg13[] = alg13.exe(interaction/nValues[k]);
                         bw.write(numeroBR.format(alg13.quality(valg13)) + " \r\n");

                     }
                     
                 }
             }
         }
         bw.close();
    }
    
    public static void simulatedAnnealingWriteFile() throws IOException{
        double [] pValues = {0.01, 0.1, 0.5, 1.0}; //Parametros p - probavilidade
        double [] rValues = {1, 2, 4, 6};  //Parametro r - Range
        int [] tValues = {50,100,1000,10000}; //Temperatura
        
        
        int interaction = 100000; 
        File file = new File("simulatedAnnealing.txt");
        file.createNewFile();
        // Prepara para escrever no arquivo
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        Locale localeBR = new Locale( "pt", "BR" );
        NumberFormat numeroBR = NumberFormat.getNumberInstance(localeBR);
        numeroBR.setMinimumFractionDigits(10);
        numeroBR.setMaximumFractionDigits(10);
        bw.write("Combinacao;Sphere;Schwefel;Rosenbrock;Rastrigin \r\n");
        
         for (int i = 0; i < pValues.length; i++) {
             for (int j = 0; j < rValues.length; j++) {
                 for (int k = 0; k < tValues.length; k++) {
                     bw.write("p= " + pValues[i] + ", r= " + rValues[j] + ", t= " + tValues[k] + ";");

                     Tweak tweak = new Tweak(pValues[i], rValues[j]);

                     SphereSimulatedAnnealing alg1 = new SphereSimulatedAnnealing(100, -100, 100, tweak, tValues[k]);
                     double valg1[] = alg1.exe(interaction);
                     bw.write(numeroBR.format(alg1.quality(valg1)) + ";");

                     SchwefelSimulatedAnnealing alg5 = new SchwefelSimulatedAnnealing(100, -100, 100, tweak, tValues[k]);
                     double valg5[] = alg5.exe(interaction);
                     bw.write(numeroBR.format(alg5.quality(valg5)) + ";");

                     RosenbrockSimulatedAnnealing alg9 = new RosenbrockSimulatedAnnealing(100, -100, 100, tweak, tValues[k]);
                     double valg9[] = alg9.exe(interaction);
                     bw.write(numeroBR.format(alg9.quality(valg9)) + ";");

                     RastriginSimulatedAnnealing alg13 = new RastriginSimulatedAnnealing(100, -100, 100, tweak, tValues[k]);
                     double valg13[] = alg13.exe(interaction);
                     bw.write(numeroBR.format(alg13.quality(valg13)) + " \r\n");
                 }
             }
         }
         bw.close();
        
        
        

        
    }
    
    public static void hillClimbingWriteFile() throws IOException{
        double [] pValues = {0.01, 0.1, 0.5, 1.0}; //Parametros p - probavilidade
        double [] rValues = {1, 2, 4, 6};  //Parametro r - Range
        int interaction = 100000; 
        File file = new File("hillClimbing.txt");
        file.createNewFile();
        // Prepara para escrever no arquivo
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        Locale localeBR = new Locale( "pt", "BR" );
        NumberFormat numeroBR = NumberFormat.getNumberInstance(localeBR);
        numeroBR.setMinimumFractionDigits(10);
        numeroBR.setMaximumFractionDigits(10);
        bw.write("Combinacao;Sphere;Schwefel;Rosenbrock;Rastrigin \r\n");
        
        for (int i = 0; i < pValues.length; i++) {
            for (int j = 0; j < rValues.length; j++) {                
                bw.write("p= " + numeroBR.format(pValues[i]) +" e r= "+numeroBR.format(rValues[j]) + ";");
                
                Tweak tweak = new Tweak(pValues[i],  rValues[j]);    
                
                SphereHillClimbing alg1 = new SphereHillClimbing(100, -100, 100, tweak);
                double valg1[] = alg1.exe(interaction);
                bw.write(numeroBR.format(alg1.quality(valg1)) + ";");
                
                
                SchwefelHillClimbing alg5 = new SchwefelHillClimbing(100, -100, 100, tweak);
                double valg5[] = alg5.exe(interaction);
                bw.write(numeroBR.format(alg5.quality(valg5)) + ";");
                
                
                RosenbrockHillClimbing alg9 = new RosenbrockHillClimbing(100, -100, 100, tweak);
                double valg9[] = alg9.exe(interaction);
                bw.write(numeroBR.format(alg9.quality(valg9)) + ";");
                
                
                RastriginHillClimbing alg13 = new RastriginHillClimbing(100, -100, 100, tweak);
                double valg13[] = alg13.exe(interaction);
                bw.write(numeroBR.format(alg13.quality(valg13)) + " \r\n");
                
            }            
        }
         bw.close();
        
        
        

        
    }

}
