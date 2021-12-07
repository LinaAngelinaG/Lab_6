package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializing {
    public static void serialize(String filename, ShoppingCard object){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object.writeObject());
            objectOutputStream.close();
        }
        catch(IOException exc){
            System.out.println(exc.getMessage());
        }

    }
}
