package com.conversor.util;

import com.conversor.modelo.Conversion;

import java.util.ArrayList;
import java.util.List;

public class Historial {
    private List<Conversion> conversiones;

    public Historial() {
        this.conversiones = new ArrayList<>();
    }

    public void registrarConversion(Conversion conversion) {
        conversiones.add(conversion);
    }

    public void mostrarHistorial() {
        if (conversiones.isEmpty()) {
            System.out.println("No hay conversiones registradas.");
        } else {
            for (Conversion conversion : conversiones) {
                System.out.println(conversion);
            }
        }
    }
}
