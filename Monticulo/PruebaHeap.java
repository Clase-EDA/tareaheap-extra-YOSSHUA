/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Monticulo;

import Monticulo.Heap;
import Monticulo.NodoHeap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author yocis
 */
public class PruebaHeap {
    public static void main(String[] args) throws FileNotFoundException{
        Heap miH = new Heap();
        int tam[] = {1000, 5000, 10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000,90000,100000};        
        for(int j = 0; j < 12; j++){            
            int n = tam[j];
            Object[] a = new Object[n+1];
            int i = 0;        
            Scanner sc = new Scanner(new File("wiki-100k.txt"));
            long miliSI = System.nanoTime();
            while(i < n ){
                String cad = sc.nextLine();
                if(!cad.contains("#")){
                    miH.inserta(cad);
                    i++;
                }    
            }
            i = 0;
            while(i < n ){
                a[i] = miH.eliminaMin();
                i++;
            }
                        
            long miliSF = System.nanoTime();
            System.out.println( (miliSF - miliSI)/1000000000.0000000000);
        }
        
    }
}
