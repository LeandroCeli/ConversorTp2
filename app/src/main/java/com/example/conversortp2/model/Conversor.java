package com.example.conversortp2.model;

public class Conversor {

    private double tipoCambio = 0.90; // por defecto




    // Convertir USD a EUR
    public double convertirUsdAEur(double usd) {
        return usd * tipoCambio;
    }

    // Convertir EUR a USD
    public double convertirEurAUsd(double eur) {
        return eur / tipoCambio;
    }

    // Obtener tipo de cambio
    public double getTipoCambio() {
        return tipoCambio;
    }

    // Modificar tipo de cambio
    public void setTipoCambio(double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }
}