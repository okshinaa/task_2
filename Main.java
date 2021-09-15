package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        read();
    }

    public static void read(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите координаты 1ой точки");
        System.out.print("x1=");
        double x1 = scanner.nextDouble();
        System.out.print("y1=");
        double y1 = scanner.nextDouble();

        System.out.println("Введите координаты 2ой точки");
        System.out.print("x2=");
        double x2 = scanner.nextDouble();
        System.out.print("y2=");
        double y2 = scanner.nextDouble();

        System.out.println("Введите координаты 3ой точки");
        System.out.print("x3=");
        double x3 = scanner.nextDouble();
        System.out.print("y3=");
        double y3 = scanner.nextDouble();

        calculanyions(x1, x2, x3, y1, y2, y3);
    }

    public static  void calculanyions(double x1, double x2, double x3, double y1, double y2, double y3) {
        double a = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double b = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y1, 2));
        double c = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));

        double alpha = (Math.acos((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c)) * 180) / Math.PI;
        double betta = (Math.acos((Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / (2 * a * c)) * 180) / Math.PI;
        double gamma = (Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b)) * 180) / Math.PI;

        write(a,b,c,alpha,betta,gamma);
    }

       public static void write(double a,double b,double c,double alpha, double betta, double gamma){
            if (a < (b + c) && b < (a + c) && c < (a + b)) {
                if (alpha == 90 || betta == 90 || gamma == 90) {
                    System.out.printf("Треугольник со сторонами %1$.2f, %2$.2f, %2$.3f - прямоугольный", a, b, c);
                    System.out.println();
                }
                if (alpha > 90 || betta > 90 || gamma > 90) {
                    System.out.printf("Треугольник со сторонами %1$.2f, %2$.2f, %2$.3f - тупоугольный", a, b, c);
                } else {
                    System.out.printf("Треугольник со сторонами %1$.2f, %2$.2f, %2$.3f - остроугольный", a, b, c);
                }
                System.out.println();

                if (a == b && a == c && c == b) {
                    System.out.printf("Треугольник со сторонами %1$.2f, %2$.2f, %2$.3f - равносторонний", a, b, c);
                    System.out.println();
                }
                if (a == b || a == c || b == c) {
                    System.out.printf("Треугольник со сторонами %1$.2f, %2$.2f, %2$.3f - равнобедренный", a, b, c);
                    System.out.println();
                } else {
                    System.out.printf("Треугольник со сторонами %1$.2f, %2$.2f, %2$.3f - разносторонний", a, b, c);
                }
            } else {
                System.out.printf("Треугольник со сторонами %1$.2f, %2$.2f, %2$.3f не существует", a, b, c);
            }
        }
    }

