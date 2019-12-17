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
public interface minHeap<T>{
    public void inserta(T elem);
    public T getMin();
    public T eliminaMin();
}
