package com.company;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        String language;
        String parameters;

        Scanner sc = new Scanner(System.in);
        language = sc.nextLine();
        parameters = sc.nextLine();

        // p-2-s-5-7-w-7-9
        RandomTxtGenerator generator = new RandomTxtGenerator(language,parameters);
        System.out.println(generator.generateArticle());
    }
}
