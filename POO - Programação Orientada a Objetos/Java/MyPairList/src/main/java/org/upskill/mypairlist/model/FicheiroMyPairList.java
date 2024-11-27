package org.upskill.mypairlist.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FicheiroMyPairList {
    private static final String nomeFicheiro = "mypairlistfile.dat";
    
    public FicheiroMyPairList() {
        
    }
    
    public boolean serializar(MyPairList myPairList) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(new File(nomeFicheiro)));
            try {
                out.writeObject(myPairList);
                
                return true;
            } finally {
                out.close();
            }
        } catch (IOException ex) {
            return false;
        }
    }
    
    public MyPairList desserializar() {
        MyPairList myPairList;
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(new File(nomeFicheiro)));
            try {
                myPairList = (MyPairList) in.readObject();
                
                return myPairList;
            } finally {
                in.close();
            }
        } catch (IOException | ClassNotFoundException ex) {
            return new MyPairList();
        }
    }
}
