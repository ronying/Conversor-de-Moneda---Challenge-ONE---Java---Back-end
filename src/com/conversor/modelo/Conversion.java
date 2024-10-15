package com.conversor.modelo;

import java.time.LocalDateTime;

public class Conversion {
    private String monedaOrigen;
    private String monedaDestino;
    private double cantidadOriginal;
    private double cantidadConvertida;
    private double tasaCambio;
    private LocalDateTime fechaHora;

    public Conversion(String monedaOrigen, String monedaDestino, double cantidadOriginal, double cantidadConvertida, double tasaCambio) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.cantidadOriginal = cantidadOriginal;
        this.cantidadConvertida = cantidadConvertida;
        this.tasaCambio = tasaCambio;
        this.fechaHora = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Conversión: " + cantidadOriginal + " " + monedaOrigen + " -> " + cantidadConvertida + " " + monedaDestino +
                " a tasa de cambio: " + tasaCambio + " (Fecha y hora: " + fechaHora + ")";
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
}
