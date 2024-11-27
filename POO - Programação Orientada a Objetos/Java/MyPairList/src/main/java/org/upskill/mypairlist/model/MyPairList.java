/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.upskill.mypairlist.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author DEI ISEP
 * @param <T>
 * @param <S>
 */
public class MyPairList<T extends Comparable<T> & Serializable, S extends Comparable<S> & Serializable> implements Serializable {

    private final List<Pair<T, S>> pairList;

    public MyPairList() {
        pairList = new ArrayList();
    }

    public List<Pair<T, S>> getPairList() {
        return new ArrayList(pairList);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (Pair<T, S> pair : pairList) {
            s.append(pair.toString());
            s.append("\n");
        }
        return s.toString();
    }

    public void add(T t, S s) {
        pairList.add(new Pair(t, s));
    }

    /**
     * sorts and eliminates repetitions
     *
     * use compareTo() instead of equals() to make generic
     */
    public void arrange() {
        Collections.sort(pairList);
        Pair<T, S> actualPair = pairList.get(0);
        for (int idx = 1; idx < pairList.size();) {
            if (actualPair.compareTo(pairList.get(idx)) == 0) {
                pairList.remove(idx);
            } else {
                actualPair = pairList.get(idx);
                idx++;
            }
        }
    }

    /**
     * return a list of pairs greater than a given pair
     *
     * @param t
     * @param s
     * @return
     */
    public MyPairList<T, S> pairsGreaterThan(T t, S s) {
        MyPairList<T, S> result = new MyPairList();
        Pair<T, S> param = new Pair(t, s);
        for (Pair<T, S> pair : pairList) {
            if (pair.compareTo(param) > 0) {
                result.add(pair.getFirst(), pair.getSecond());
            }
        }
        return result;
    }

    /**
     * get all the second elements paired with a given first element
     *
     * @param t
     * @return
     */
    public List<S> elementsPairedWith(T t) {
        List<S> result = new ArrayList();
        for (Pair<T, S> pair : pairList) {
            if (t.compareTo(pair.getFirst()) == 0) {
                result.add(pair.getSecond());
            }
        }
        return result;
    }

    public MyPairList<T, S> allUniqueCombinations() {
        MyPairList<T, S> result = new MyPairList<>();

        for (Pair<T, S> pair : pairList) {
            for (Pair<T, S> pair1 : pairList) {
                Pair<T, S> candidatePair = pair;
                if (pair != pair1) {
                    candidatePair = new Pair<>(pair.getFirst(), pair1.getSecond());
                }
                if (!result.contains(candidatePair)) {
                    result.add(pair.getFirst(), pair1.getSecond());
                }
            }
        }

        Comparator<Pair<T,S>> criterioFirst = new Comparator<Pair<T,S>>() {
            public int compare(Pair<T,S> pair1, Pair<T,S> pair2) {
                return pair1.getFirst().compareTo(pair2.getFirst());
            }
        };
        
        Collections.sort(result.pairList, criterioFirst);
        
        return result;
    }

    private boolean contains(Pair<T, S> pair) {
        return pairList.contains(pair);
    }
}
