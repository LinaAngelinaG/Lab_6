package com.company;

import java.awt.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //___ Part 1 ___//

        try{
            FindPartOfText.findText(args[0]);
        }
        catch(ArrayIndexOutOfBoundsException exc){
            System.out.println(exc.getMessage());
        }

        //___ Part 2 ___//

        Item item1 = new Item (001, "Pomidoro", 0.25);
        Item item2 = new Item (002, "Apple", 0.3);
        Item item3 = new Item (003, "Orange", 0.32);
        ArrayList<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item1);
        items.add(item2);
        items.add(item3);

        ShoppingCard card = new ShoppingCard(1523, items);

        //Serialize//
        Serializing.serialize("save.ser", card);

        //Deserialize//
        ShoppingCard saved = Deserializing.deserialize("save.ser");

        //___ Homework ___//

        System.out.println("\n\n=== TASK 1 ===");
        System.out.println("\n= 1 =");
        BufferedReader bReader = null;
        try{
            bReader = new BufferedReader(new FileReader("hamlet.txt"));

            System.out.println("\n\n=== Entire File ===");
            String line;
            while((line = bReader.readLine()) != null){
                System.out.println(line);
            }
        }
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            try{
                if(bReader != null){
                    bReader.close();
                }
            }
            catch(IOException exc){
                System.out.println(exc.getMessage());
            }
        }

        System.out.println("\n= 2 =");

        try(BufferedReader bRead = new BufferedReader(new FileReader("hamlet.txt"))){ // Create Try with Resources here

            System.out.println("\n=== Entire File ===");
            String line;
            while((line = bRead.readLine()) != null){
                System.out.println(line);
            }
        }
        catch(IOException exc){
            System.out.println(exc.getMessage());
        }

        System.out.println("\n= 3 =");

        try(BufferedReader bRead = new BufferedReader(new FileReader("hamlet.txt"))){
            // Read file into array here
            List<String> filestrings = new ArrayList<>();
            String line;
            while((line = bRead.readLine()) != null){
                filestrings.add(line);
            }

            System.out.println("\n=== Rosencrantz ===");
            // Filter for Ros. here
            filestrings.stream().filter(x -> x.contains("Ros.")).forEach(System.out::println);
            System.out.println("\n=== Guildenstern ===");
            // Filter for Guil. here
            filestrings.stream().filter(x -> x.contains("Guil.")).forEach(System.out::println);

        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n= 4 =");

        try(BufferedReader bRead = new BufferedReader(new FileReader("hamlet.txt"))){
            // Read fileinto array
            List<String> filestrings = new ArrayList<>();
            String line;
            while((line = bRead.readLine()) != null){
                String[] lines = line.split(" ");
                for(var word : lines){
                    filestrings.add(word);
                }
            }

            System.out.println("\n=== Lord Count ===");
            long wordCount = filestrings.stream().filter(x -> x.contains("lord") | x.contains("Lord")).count(); // Replace with your pipeline

            System.out.println("Word count: " + wordCount);

            System.out.println("\n=== Prison Count ===");
            wordCount = filestrings.stream().filter(x -> x.contains("prison") | x.contains("Prison")).count(); // Replace with your pipeline

            System.out.println("Word count: " + wordCount);

        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n\n=== TASK 2 ===");
        System.out.println("\n= 1 =");

    }
}
