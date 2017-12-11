package com.nickkbright.ArrayInit;

import java.io.*;
import java.util.Scanner;

import java.io.*;
import java.util.Scanner;


import java.io.*;
import java.util.Scanner;

public class ArrayInitialization {
    private static File file = new File("array.txt");

    public static void writeFile(int[] arr) {
        try {
            PrintWriter writer =  new PrintWriter(new BufferedWriter(new FileWriter(file)));
            for (int i = 0; i < arr.length; i++) {
                writer.println(arr[i]);
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile(int[] arr) {
        try {
            Scanner scanner = new Scanner(new FileInputStream(file));
            int i = 0;
            while (scanner.hasNextInt()) {
                arr[i] = scanner.nextInt();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}