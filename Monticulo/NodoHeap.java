/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Monticulo;

/**
 *
 * @author yocis
 */
public class NodoHeap<T extends Comparable<T>> {
    private T elem;
    private int prioridad;

    public NodoHeap(T elem, int prioridad) {
        this.elem = elem;
        this.prioridad = prioridad;
    }

    public NodoHeap(Object elem) {
        this.elem = (T) elem;        
    }
   

    public T getElem() {
        return elem;
    }

    public void setElem(T elem) {
        this.elem = elem;
    }
    public T getPrioridad(){
        return elem;
    }
    
    public String toString(){
        return "Elem:" + elem.toString();
    }
    
}
