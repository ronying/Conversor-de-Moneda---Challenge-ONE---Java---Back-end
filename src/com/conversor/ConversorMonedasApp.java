package com.conversor;

import com.conversor.servicio.ConversorServicio;
import com.conversor.modelo.Conversion;
import com.conversor.util.Historial;

import java.util.Scanner;

public class ConversorMonedasApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorServicio conversorServicio = new ConversorServicio();
        Historial historial = new Historial();

        System.out.println("Bienvenido al conversor de monedas");

        while (true) {
            System.out.println("Ingrese el código de la moneda origen (ej: USD): ");
            String monedaOrigen = scanner.nextLine();
            System.out.println("Ingrese el código de la moneda destino (ej: EUR): ");
            String monedaDestino = scanner.nextLine();
            System.out.println("Ingrese la cantidad a convertir: ");
            double cantidad = scanner.nextDouble();
            scanner.nextLine(); // Consumir nueva línea

            try {
                Conversion conversion = conversorServicio.convertirMoneda(monedaOrigen, monedaDestino, cantidad);
                System.out.println(conversion);

                // Guardar en el historial
                historial.registrarConversion(conversion);

                // Mostrar historial
                System.out.println("Historial de conversiones:");
                historial.mostrarHistorial();
            } catch (Exception e) {
                System.err.println("Error en la conversión: " + e.getMessage());
            }

            System.out.println("¿Desea realizar otra conversión? (s/n)");
            if (scanner.nextLine().equalsIgnoreCase("n")) {
                break;
            }
        }

        scanner.close();
    }
}