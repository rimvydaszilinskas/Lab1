package com.company;

import java.util.Scanner;

public class Interactions {
    private Scanner scan = new Scanner(System.in);

    public void mainMenu(){
        println("---Pagrindinis meniu---");
        println("1. Rasti marsruta");
        println("2. Kitas pasirinkimas");
        print("Iveskite pasirinkima:");
        takeInt();
    }

    private void println(String line){
        System.out.println(line);
    }

    private void print(String text){
        System.out.print(text + " ");
    }

    private void error(String text){
        System.err.println(text);
    }

    private int takeInt(){
        try{
            int a = scan.nextInt();
            scan.nextLine();
            return a;
        } catch (Exception e){
            error("Iveskite skaiciu!");
        }
        return -1;
    }

    private String takeString(){
        return scan.nextLine();
    }

    public String takeFilename(){
        String filename = scan.nextLine();
        if(!filename.matches("(\\w+)[.](\\w+)")){
            filename += ".txt";
        }
        return filename;
    }
}
