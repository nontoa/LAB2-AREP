/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.ASE.app;

/**
 * Esta clase representa la implementación de un LinkedList.
 * @author Nicolas Nontoa.
 */
public class LinkedList<T> {

    private Head head;

    /**
     * Constructor de la clase.
     */
    public LinkedList() {
        this.head = new Head(null, null);
    }

    
    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    /**
     * Este metodo se encarga de adicionar elementos al LinkedList.
     * @param dato Es el valor del nodo a ingresar.
     */
    public void add(T dato) {
        Node nodo = new Node(null, null, dato);
        if (head.getPrimero() == null) {
            head.setPrimero(nodo);
            head.setUltimo(nodo);
        } else {
            if (head.getPrimero().getSiguiente() == null) {
                head.getPrimero().setSiguiente(nodo);
            }

            head.getUltimo().setSiguiente(nodo);
            nodo.setAnterior(head.getUltimo());
            head.setUltimo(nodo);

        }
    }

    /**
     * Este método se encarga de devolver el valor de una posicion especifica del nodo.
     * @param pos Es la posicion de la cual yo quiero saber el valor.
     * @return Retorna el valor del LinkedList en esa posicion.
     */
    public T get(int pos) {
        if (pos > size()) {
            throw new IndexOutOfBoundsException();
        }
        int c = 0;
        Node nodo = head.getPrimero();
        while (pos != c) {
            nodo = nodo.getSiguiente();
            c++;
        }
        return (T) nodo.getDatos();
    }

    /**
     * Este metodo se encarga de calcular el tamaño del LinkedList.
     * @return Retorna el tamaño del LinkedList.
     */
    public int size() {
        Node nodo = head.getPrimero();
        int c = 0;
        while (nodo != null) {
            nodo = nodo.getSiguiente();
            c++;
        }
        return c;
    }

}
