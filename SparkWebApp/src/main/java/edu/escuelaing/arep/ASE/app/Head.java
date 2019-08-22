/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.ASE.app;

/**
 * Esta clase representa la cabeza del LinkedList.
 * @author Nicolas Nontoa.
 */
class Head {
    
    public Node primero;
    public Node ultimo;
    
    /**
     * Constructor de la clase.
     * @param p Valor para el primer nodo.
     * @param u Valor para el ultimo nodo.
     */
    public Head(Node p,Node u){
        this.primero=p;
        this.ultimo=u;
    }

    public Node getPrimero() {
        return primero;
    }

    public void setPrimero(Node primero) {
        this.primero = primero;
    }

    public Node getUltimo() {
        return ultimo;
    }

    public void setUltimo(Node ultimo) {
        this.ultimo = ultimo;
    }
   
    
}
