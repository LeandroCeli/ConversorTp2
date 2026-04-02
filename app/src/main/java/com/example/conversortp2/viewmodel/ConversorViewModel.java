package com.example.conversortp2.viewmodel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.conversortp2.model.Conversor;

public class ConversorViewModel extends ViewModel {

    private Conversor conversor = new Conversor();
    private MutableLiveData<String> resultado = new MutableLiveData<>();
    private MutableLiveData<String> tipoCambioTexto = new MutableLiveData<>();

    public ConversorViewModel() {
        actualizarTipoCambio();
    }

    public LiveData<String> getResultado() {
        return resultado;
    }

    public LiveData<String> getTipoCambioTexto() {
        return tipoCambioTexto;
    }

    // Método principal de conversión
    public void convertir(double valor, boolean aUsd) {

        double res;

        if (aUsd) {
            res = conversor.convertirEurAUsd(valor);
            resultado.setValue("Resultado: " + res + " USD");
        } else {
            res = conversor.convertirUsdAEur(valor);
            resultado.setValue("Resultado: " + res + " EUR");
        }
    }

    // Actualiza el texto del tipo de cambio
    public void actualizarTipoCambio() {
        tipoCambioTexto.setValue("1 USD = " + conversor.getTipoCambio() + " EUR");
    }

    // Permite cambiar el tipo de cambio
    public void cambiarTipoCambio(double nuevoValor) {
        conversor.setTipoCambio(nuevoValor);
        actualizarTipoCambio();
    }
}