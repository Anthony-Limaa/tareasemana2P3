package matriz.tarea;

import java.util.Arrays;
import java.util.Random;

public class Matriz {
    Random random = new Random();
    int[][] ventas = new int[5][12];

    public Matriz() {
        generarVentasAleatorias();
    }

    private void generarVentasAleatorias() {
        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length; j++) {
                ventas[i][j] = random.nextInt(10000) + 1; // Ventas entre 1 y 10000
            }
        }
    }

    public void imprimirMatrizPorFilas() {
        System.out.println("Matriz de ventas por filas:");
        Arrays.stream(ventas)
                .forEach(row -> {
                    Arrays.stream(row)
                            .forEach(value -> System.out.print(value + "\t"));
                    System.out.println();
                });
    }

    public void ordenarMatrizPorColumna() {
        System.out.println("\nMatriz de ventas ordenada por columna:");
        for (int j = 0; j < ventas[0].length; j++) {
            final int colIndex = j;
            Arrays.stream(ventas)
                    .map(row -> row[colIndex])
                    .sorted()
                    .forEach(value -> System.out.print(value + "\t"));
            System.out.println();
        }
    }

    public void filtrarMatrizPorCriterio(int criterio) {
        System.out.println("\nElementos de la matriz filtrados por criterio (" + criterio + "):");
        Arrays.stream(ventas)
                .flatMapToInt(Arrays::stream)
                .filter(value -> value == criterio)
                .forEach(value -> System.out.print(value + "\t"));
    }


}

