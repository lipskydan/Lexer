package com.company;

public class Main {

    public static void main(String[] args) {

        Lexer lexer = new Lexer("/Users/danial/Documents/GitHub/Lexer/input.txt");

        System.out.println("Lexical Analysis");
        System.out.println("-----------------");
        while (!lexer.isExausthed()) {
            System.out.printf("%-18s :  %s \n",lexer.currentLexema() , lexer.currentToken());
            lexer.moveAhead();
        }

        if (lexer.isSuccessful()) {
            System.out.println("Ok!");
        } else {
            System.out.println(lexer.errorMessage());
        }
    }
}