/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.upskill.mypairlist.model;

import java.io.Serializable;

/**
 *
 * @author DEI ISEP
 * @param <T>
 * @param <S>
 */
public class Pair<T extends Comparable<T> & Serializable, S extends Comparable<S> & Serializable> implements Comparable<Pair<T,S>>, Serializable{
    /**
     * the first attribute of the pair
     */
    private T first;
    /**
     * the second attribute of the pair
     */
    private S second;

    /**
     * the constructor of the Pair class
     * 
     * @param first
     * @param second 
     */
    public Pair(T first, S second){
        this.first = first;
        this.second = second;
    }    

    /**
     * returns the first attribute
     * 
     * @return T
     */
    public T getFirst(){
        return first;
    }
    /**
     * returns the second attribute
     * 
     * @return S
     */
    public S getSecond(){
        return second;
    }

    /**
     * sets the first attribute
     *
     * @param first
     */
    public void setFirst(T first){
        this.first=first;
    }
    /**
     * sets the second attribute
     *
     * @param second
     */
    public void setSecond(S second){
        this.second=second;
    }

    /**
     *
     * @return the result string
     */
    public String toString(){
        return "<"+first+","+second+">";
    }

    /**
     * compares two Pair objects. The first attribute is used.
     * In case of equality the second attribute is used.
     *
     * @param otherPair
     * @return an integer number meaning:
     *              negative - this Pair is less than otherPair;
     *              zero - this Pair is equal than otherPair;
     *              positive - this Pair is greater than otherPair;
     */
    @Override
    public int compareTo(Pair<T, S> otherPair) {
        if(first.compareTo(otherPair.getFirst()) != 0)
            return first.compareTo(otherPair.getFirst());
        return second.compareTo(otherPair.getSecond());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if(obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Pair<T,S> objPair= (Pair<T,S>) obj;
        
        return first.equals(objPair.first) && second.equals(objPair.second);
    }
}
