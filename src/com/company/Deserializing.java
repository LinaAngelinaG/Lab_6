package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserializing {
    public static ShoppingCard deserialize(String filename) {
        try{
            FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            ShoppingCard saved = (ShoppingCard) objectInputStream.readObject();

            saved.readObject();
            System.out.println(saved);
            objectInputStream.close();
            return saved;
        }
        catch(IOException | ClassNotFoundException exc){
            System.out.println(exc.getMessage());
        }
       return null;
    }
}
