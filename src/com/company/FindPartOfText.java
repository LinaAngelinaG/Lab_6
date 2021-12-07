package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FindPartOfText {
    public static void findText(String filename){
    if(filename.length() < 2){
            System.out.println("Invalid name of file.");
            System.exit(-1);
        }
        try(FileReader reader = new FileReader(filename)){
            System.out.print("Enter the string ::  ");
            Scanner input = new Scanner(System.in);
            String name = input.nextLine();
            String[] find = name.split(" ");
            int counter = 0;
            int i = 0, indicator = 0;
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                var line = scanner.nextLine();
                String[] lines = line.split(" ");
                for(var word: lines) {
                    if (word.compareTo(find[i]) == 0) {
                        indicator = 1;
                        ++i;
                    } else {
                        i = 0;
                        indicator = 0;
                    }
                    if (find.length == i && indicator == 1) {
                        ++counter;
                        i = 0;
                        indicator = 0;
                    }
                }
            }
            System.out.println("There are  " + counter + " srtings in a file.");
        }
        catch(IOException exc){
            System.out.println(exc.getMessage());
        }

    }
}
