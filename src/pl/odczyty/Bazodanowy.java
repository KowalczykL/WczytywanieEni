/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.odczyty;

/**
 *
 * @author Łukasz Kowalczyk
 */
public interface Bazodanowy {
    
    void zapisz();
    void czyIstnieje();
    int zwrocId();
    
    
    
}
