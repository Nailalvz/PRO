package com.company;

import java.util.Scanner;

public class Main {

    public static Scanner scan = new Scanner(System.in);

    public static int random(int n) {
        double toret = Math.random() * n;
        return (int) toret;
    }

    public static int[] randomVector(int n) {
        int entrada[] = new int[n];
        for (int i = 0; i < entrada.length; i++) {
            entrada[i] = random(101);
        }
        return entrada;
    }

    public static void leerVector(int vector[]) {
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
    }

    public static int buscador(int vector[], int num) {
        int pos = -1;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == num) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public static int[][] matrizRandom(int dim) {
        int entrada[][] = new int[dim][dim];
        for (int fil = 0; fil < entrada.length; fil++) {
            for (int col = 0; col < entrada[fil].length; col++) {
                entrada[fil][col] = random(100);
            }
        }
        return entrada;
    }

    public static void leerMariz(int entrada[][]) {
        for (int fil = 0; fil < entrada.length; fil++) {
            System.out.println();
            for (int col = 0; col < entrada[fil].length; col++) {
                System.out.print(entrada[fil][col] + " ");
            }
        }
    }

    public static boolean mayorFila(int entrada[][], int fila, int columna) {
        for (int j = 0; j < entrada[0].length; j++) {
            if (entrada[fila][columna] < entrada[fila][j]) return false;
        }
        return true;
    }

    public static boolean menorColumna(int entrada[][], int fila, int columna) {
        for (int i = 0; i < entrada.length; i++) {
            if (entrada[fila][columna] > entrada[i][columna]) return false;
        }
        return true;
    }

    public static boolean puntoSilla(int entrada[][], int fila, int columna) {
        if (mayorFila(entrada, fila, columna) && menorColumna(entrada, fila, columna)) return true;
        else return false;
    }

    public static void leerCol(int entrada[][], int col) {
        for (int fil = 0; fil < entrada.length; fil++) {
            System.out.println(entrada[fil][col]);
        }
    }

    public static void name() {
        String name;
        String toret = "";
        do {
            System.out.println("\nIntroduzca su nombre de pila, la inicial de su sobrenombre seguida de un punto y su " +
                    "apellido (Juan C. Lago) o si no tiene segundo nombre obvie la inicial (Juan Lago):");
            name = scan.nextLine();
        } while (!comprobaciónNombre(name));
        String nombre[] = name.split("[ ]+");
        String aux[] = new String[name.length()];
        if (nombre.length == 2) {
            aux[0] = nombre[1];
            aux[1] = String.valueOf(Character.toUpperCase(nombre[0].charAt(0)));
            for (int i = 0; i < nombre.length; i++) {
                if (i == nombre.length - 1) {
                    toret += aux[i] + ".";
                } else {
                    aux[i] = firstCap(aux[i]);
                    toret += aux[i] + ", ";
                }
            }
            System.out.println(toret + "\n");
        } else if (nombre.length == 3) {
            aux[0] = nombre[2];
            aux[1] = String.valueOf(Character.toUpperCase(nombre[0].charAt(0)));
            aux[2] = String.valueOf(Character.toUpperCase(nombre[1].charAt(0)));
            for (int i = 0; i < nombre.length; i++) {
                if (i == 1 || i == 2) {
                    toret += aux[i] + ". ";
                } else {
                    aux[i] = firstCap(aux[i]);
                    toret += aux[i] + ", ";
                }
            }
            System.out.println(toret + "\n");
        }
        else System.out.println("Error en la introducción del nombre siguiendo cualquiera de las anteriores estructuras.");
    }

    public static boolean comprobaciónNombre(String nombre) {
        String name[] = nombre.split("[ ]+");
        if (name.length == 2) {
            if (!name[0].matches("[a-zA-ZÑñáéíóúÁÉÍÓÚ]*") || !name[1].matches("[a-zA-ZÑñáéíóúÁÉÍÓÚ]*")) {
                System.out.println("\nDebe introducir solo caracteres válidos");
                return false;
            }
        } else if (name.length == 3) {
            if (!name[0].matches("[a-zA-ZÑñáéíóúÁÉÍÓÚ]*") || !name[2].matches("[a-zA-ZÑñáéíóúÁÉÍÓÚ]*")) {
                System.out.println("\nDebe introducir solo caracteres válidos: ");
                return false;
            }
            if (name[1].length() != 2) {
                System.out.println("\nLa introducción de la inicial ha sido errónea, debe " +
                        "seguir el siguiente formato: A.");
                return false;
            }
            if (!Character.isLetter(name[1].charAt(0))) {
                System.out.println("\nLa introducción de la inicial ha sido errónea, debe " +
                        "ser un caracter válido.");
                return false;
            } else if (name[1].charAt(1) != '.') {
                System.out.println("\nLa inicial debe estar seguida de un punto");
                return false;
            }
        }
        return true;
    }

    public static String firstCap(String apellido) {
        apellido = apellido.toLowerCase();
        char[] aux = apellido.toCharArray();
        aux[0] = Character.toUpperCase(aux[0]);
        return new String(aux);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        char op;
        String aux = "";
        while (!aux.equals("d")) {
            System.out.println("Hola! Has entrado al menú. Elige que programa deseas iniciar (se acepta la introducción " +
                    "tanto de mayúsculas como minúsculas):\n"
                    + "Pulsa 'a' para buscar un valor en un vector de números aleatorios.\n"
                    + "Pulsa 'b' para analizar si un elemento de una matriz aleatoria es o no punto silla.\n"
                    + "Pulsa 'c' para abreviar un nombre, sobre nombre y apellido.\n"
                    + "Pulsa 'd' para terminar el programa.");
            aux = scan.next();
            aux = aux.toLowerCase();
            op = aux.charAt(0);
            if (aux.length() > 1)
                System.out.println("\nError, la introducción debe ser un solo caracter ('a', 'b', 'c', o 'd').\n");
            else {
                switch (op) {
                    case 'a':
                        int dim;
                        int num;
                        System.out.println("\nIntroduzca la dimensión que desea que tenga su vector de números aleatorios:");
                        dim = scan.nextInt();
                        while (dim <= 0) {
                            System.out.println("\nHa habido un error, la dimensión no puede ser ni menor ni igual a cero. \n" +
                                    "Repita la introducción de la dimensión del vector: ");
                            dim = scan.nextInt();
                        }
                        int vector[] = randomVector(dim);
                        System.out.println("\nIntroduzca el número que desea buscar, debe encontrarse entre 0 y 100");
                        num = scan.nextInt();
                        while (num < 0 || num > 101) {
                            System.out.println("\nHa habido un error, el número debe encontrarse entre 0 y 100. \n" +
                                    "Repita la introducción del número: ");
                            num = scan.nextInt();
                        }
                        leerVector(vector);
                        if (buscador(vector, num) == -1)
                            System.out.println("\nNo se ha encontrado el número en el vector\n");
                        else
                            System.out.println("\nEl número " + num + " se encuentra en la posición " + (buscador(vector, num) + 1) + " (Se " +
                                    "entiende que el vector comienza en la posición 1).\n");
                        break;
                    case 'b':
                        int dims;
                        int fila;
                        int col;
                        System.out.println("\nIntroduzca las dimensiones de la matriz. Tenga en cuenta que al ser una matriz cuadrada el " +
                                "número de filas y de columnas.\n" +
                                "Recuerde que las dimensiones de una matriz deben ser mayores que cero.");
                        dims = scan.nextInt();
                        while (dims <= 0) {
                            System.out.println("\nHa habido un error, la dimensión no puede ser ni menor ni igual a cero. \n" +
                                    "Repita la introducción de la dimensión del vector: ");
                            dims = scan.nextInt();
                        }
                        int matriz[][] = matrizRandom(dims);
                        System.out.println("\nIntroduczca los índices (fila y columna) del elemento que desea comprobar si es punto silla:\n" +
                                "Fila:");
                        fila = scan.nextInt();
                        while (fila < 0 || fila >= matriz.length) {
                            System.out.println("\nEsa fila no existe en la matriz generada " + matriz.length + "x" + matriz.length + "\n" +
                                    "Por favor, introduzca una fila valida:");
                            fila = scan.nextInt();
                        }
                        System.out.println("Columna:");
                        col = scan.nextInt();
                        while (col < 0 || col >= matriz.length) {
                            System.out.println("\nEsa columna no existe en la matriz generada " + matriz.length + "x" + matriz.length + "\n" +
                                    "Por favor, introduzca una columna valida:\n");
                            col = scan.nextInt();
                        }
                        do {
                            leerMariz(matriz);
                            if (puntoSilla(matriz, fila, col))
                                System.out.println("\nEl elemnto seleccionado (" + matriz[fila][col] + ") es " +
                                        "punto silla.\n");
                            else
                                System.out.println("\nEl elemento seleccionado (" + matriz[fila][col] + ") no es punto silla.");
                            System.out.println("\nLa fila a la que pertenece es la siguiente(" + fila + "):");
                            leerVector(matriz[fila]);
                            System.out.println("\n\nLa columna a la que pertenece es la siguiente(" + col + "):");
                            leerCol(matriz, col);
                            System.out.println("\nDesea analizar otro elemento? Si es así introduzca fila y columna de nuevo. Sino introduzca -1.\n" +
                                    "Fila:");
                            fila = scan.nextInt();
                            if (fila == -1) break;
                            while (fila < 0 || fila >= matriz.length) {
                                System.out.println("\nEsa fila no existe en la matriz generada " + matriz.length + "x" + matriz.length + "\n" +
                                        "Por favor, introduzca una fila valida:\n");
                                fila = scan.nextInt();
                            }
                            System.out.println("Columna:");
                            col = scan.nextInt();
                            while (col < 0 || col >= matriz.length) {
                                System.out.println("\nEsa columna no existe en la matriz generada " + matriz.length + "x" + matriz.length + "\n" +
                                        "Por favor, introduzca una columna valida:\n");
                                col = scan.nextInt();
                            }
                        } while (fila != -1);
                        break;
                    case 'c':
                        name();
                        break;
                }
                if (!aux.equals("a") && !aux.equals("b") && !aux.equals("c") && !aux.equals("d")) {
                    System.out.println("\nCaracter incorrecto. Debe ser 'a', 'b', 'c' o 'd'.\n");
                }
            }
        }
        System.out.println("\nEl programa ha finalizado. Adiós!");
        scan.close();
    }

}

