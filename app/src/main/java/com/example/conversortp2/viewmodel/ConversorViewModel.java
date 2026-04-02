package com.example.conversortp2.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.conversortp2.model.Conversor;

public class ConversorViewModel extends ViewModel {

    private final Conversor conversor = new Conversor();

    private final MutableLiveData<String> resultado = new MutableLiveData<>("");
    private final MutableLiveData<String> tipoCambioTexto = new MutableLiveData<>("");

    public ConversorViewModel() {
        actualizarTipoCambio();
    }

    // 🔹 Getters (exponer como inmutable)
    public LiveData<String> getResultado() {
        return resultado;
    }

    public LiveData<String> getTipoCambioTexto() {
        return tipoCambioTexto;
    }

    // 🔹 Conversión principal
    public void convertir(double valor, boolean aUsd) {

        double res;

        if (aUsd) {
            res = conversor.convertirEurAUsd(valor);
            resultado.setValue(formatearResultado(res, "USD"));
        } else {
            res = conversor.convertirUsdAEur(valor);
            resultado.setValue(formatearResultado(res, "EUR"));
        }
    }

    // 🔹 Actualiza tipo de cambio
    public void actualizarTipoCambio() {
        tipoCambioTexto.setValue(
                String.format("1 USD = %.2f EUR", conversor.getTipoCambio())
        );
    }

    // 🔹 Cambiar tipo de cambio
    public void cambiarTipoCambio(double nuevoValor) {
        conversor.setTipoCambio(nuevoValor);
        actualizarTipoCambio();
    }

    // 🔹 Método auxiliar para formatear
    private String formatearResultado(double valor, String moneda) {
        return String.format("Resultado: %.2f %s", valor, moneda);
    }
}