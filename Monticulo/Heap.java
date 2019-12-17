/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Monticulo;

import Monticulo.NodoHeap;
import Monticulo.minHeap;

/**
 *
 * @author yocis
 */
public class Heap<T extends Comparable<T>> implements minHeap<T>{
    private NodoHeap<T>[] datos;
    private int cont;

    public Heap() {
        cont = 0;
        datos = new NodoHeap[200005];
    }
    
    @Override
    public  void inserta(T elem) {
        int pos = cont+1;                
        NodoHeap<T> aux = new NodoHeap(elem);
        if(pos > datos.length){
            expande();
        }else if(pos == 1){
            datos[pos] = aux;
            cont++;
        }
        else{            
            boolean termine= false;
            datos[pos] = aux;
            while(pos >1  && !termine){                                    
              if(datos[pos/2].getPrioridad().compareTo(aux.getPrioridad()) > 0){
                    NodoHeap<T> au = datos[pos];
                    datos[pos] = datos[pos/2];
                    datos[pos/2]= au;                
                }else{
                    termine = true;                
                }
                pos = pos >> 1;
            }     
            cont+=1;
        }
        
    }

    @Override
    public T getMin() {
        if(cont> 0)
            return datos[1].getPrioridad();
        else
            return null;
    }

    @Override
    public T eliminaMin() {        
        
        T res = null;
        if(cont == 0)
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        else if(cont == 1){
            res = datos[1].getElem();            
            cont= 0;
            datos[1] = null;
        }else{
            NodoHeap aux;
            int pos = 1;
            boolean termine = false;            
            res = datos[1].getPrioridad();
            datos[1] =  datos[cont];
            datos[cont] = null;            
            cont--;
            while(pos < cont && !termine){
                if(datos[2*pos] != null && datos[2*pos+1] != null){
                    if(datos[2*pos].getPrioridad().compareTo(datos[2*pos+1].getPrioridad())< 0){
                        if(datos[2*pos].getPrioridad().compareTo(datos[pos].getPrioridad()) < 0){
                            aux = datos[pos];
                            datos[pos] = datos[pos*2];
                            datos[pos*2]  = aux;
                            pos*=2;
                        }                        
                        else
                            termine = true;                        
                    }else{
                        if(datos[2*pos+1].getPrioridad().compareTo(datos[pos].getPrioridad()) < 0){
                            aux = datos[pos];
                            datos[pos] = datos[pos*2+1];
                            datos[pos*2+1]  = aux;
                            pos = pos*2 +1;
                        }else
                            termine = true;
                    }                        
                }else if(datos[2*pos] != null){
                    if(datos[2*pos].getPrioridad().compareTo(datos[pos].getPrioridad()) < 0){
                            aux = datos[pos];
                            datos[pos] = datos[pos*2];
                            datos[pos*2]  = aux;
                            pos*=2;
                    }else
                            termine = true;                    
                }else if(datos[2*pos+1] != null){
                    if(datos[2*pos+1].getPrioridad().compareTo(datos[pos].getPrioridad()) < 0){
                            aux = datos[pos];
                            datos[pos] = datos[pos*2+1];
                            datos[pos*2+1]  = aux;
                            pos= pos*2+1;
                    }else
                            termine = true; 
                }else
                    termine = true;
            }            
        }        
        return res;                
    }

    private void expande() {
        
    }
    public String toString(){
        StringBuilder sb= new StringBuilder();
        for(int i = 0; i <= Math.sqrt(cont); i++){
            double ini = Math.pow(2, i);
            double fin = Math.pow(2, i+1);
            sb.append("nivel " + (i+1) + "\n");
            for(int j = (int) ini; j < fin && j <= cont; j++){
                sb.append(datos[j].toString() + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    public boolean estaVacio(){
        return cont == 0;
    }
    
}
