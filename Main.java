package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        double x1 = readPointCoordinates("X1=");
        double y1 = readPointCoordinates("Y1=");
        double x2 = readPointCoordinates("X2=");
        double y2 = readPointCoordinates("Y2=");
        double x3 = readPointCoordinates("X3=");
        double y3 = readPointCoordinates("Y3=");

        double a = calculateTriangleSide(x1,x2,y1,y2);
        double b = calculateTriangleSide(x2,x3,y2,y3);
        double c = calculateTriangleSide(x1,x3,y1,y3);

        boolean flag = doesTriangleExists(a,b,c);
        if(!flag) {
            System.out.println("Треугольник c такими координатами вершин не существует");
            System.exit(0);
        }

        String typeSides = typeTriangleSides(a,b,c);
        printSidesAnswer(typeSides);

        double alpha = calculateTriangleCorner(b,c,a);
        double betta = calculateTriangleCorner(a,c,b);
        double gamma = calculateTriangleCorner(a,b,c);

        String typeCorner = typeTriangleCorner(alpha,betta,gamma);
        printCornersAnswer(typeCorner);
    }

    private static double readPointCoordinates(String pointName) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите координату вершины " + pointName);
        return scanner.nextDouble();
    }

    private static double calculateTriangleSide(double x, double xx, double y, double yy) {
        return Math.sqrt(Math.pow(xx - x, 2) + Math.pow(yy - y, 2));
    }

    private static boolean doesTriangleExists(double a, double b, double c) {
        return (a < (b + c) && b < (a + c) && c < (a + b));
    }

    private static double calculateTriangleCorner(double sideA, double sideB,double sideC) {
        return (Math.acos((Math.pow(sideA, 2) + Math.pow(sideB, 2) - Math.pow(sideC, 2)) / (2 * sideA * sideB)) * 180)/Math.PI;
    }

    private static String typeTriangleSides(double a,double b,double c) {
        if (a == b && a == c && c == b) {
             return "equilateral";
        } else {
            if (a == b || a == c || b == c) {
                return "isosceles";
            } else {
                return "versatile";
            }
        }
    }

    private static void printSidesAnswer(String typeSides) {
        switch (typeSides) {
            case "equilateral":
                System.out.println("Треугольник равносторонний");
                break;
            case "isosceles":
                System.out.println("Треугольник равнобедренный");
                break;
            case "versatile":
                System.out.println("Треугольник разносторонний");
                break;
        }
    }

    private static String typeTriangleCorner(double alpha,double betta,double gamma) {
        if (alpha == 90 || betta == 90 || gamma == 90) {
            return "right";
        }else {
            if (alpha > 90 || betta > 90 || gamma > 90) {
                return "obtuse";
            } else {
                return "acute";
            }
        }
    }

    private static void printCornersAnswer(String typeCorner) {
        switch (typeCorner) {
            case "right":
                System.out.println("Треугольник прямоугольный");
                break;
            case "obtuse":
                System.out.println("Треугольник тупоугольный");
                break;
            case "acute":
                System.out.println("Треугольник остроугольный");
                break;
        }
    }
}

