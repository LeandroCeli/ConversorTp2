package com.example.conversortp2;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.conversortp2.databinding.ActivityMainBinding;
import com.example.conversortp2.viewmodel.ConversorViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ConversorViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 🔹 Inicializar binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 🔹 ViewModel
        viewModel = new ViewModelProvider(this).get(ConversorViewModel.class);

        // 🔹 OBSERVAR LiveData
        viewModel.getResultado().observe(this, resultado -> {
            binding.tvResultado.setText(resultado);
        });

        viewModel.getTipoCambioTexto().observe(this, cambio -> {
            binding.tvCambio.setText(cambio);
        });

        // 🔹 Botón Convertir
        binding.btnConvertir.setOnClickListener(v -> {

            String valorTexto = binding.etValor.getText().toString();

            if (TextUtils.isEmpty(valorTexto)) {
                Toast.makeText(this, "Ingrese un valor", Toast.LENGTH_SHORT).show();
                return;
            }

            double valor = Double.parseDouble(valorTexto);

            if (binding.rbUSD.isChecked()) {
                viewModel.convertir(valor, true);
            } else if (binding.rbEUR.isChecked()) {
                viewModel.convertir(valor, false);
            } else {
                Toast.makeText(this, "Seleccione tipo de conversión", Toast.LENGTH_SHORT).show();
            }
        });

        // 🔹 Botón Cambiar valor
        binding.btnCambiar.setOnClickListener(v -> {

            String nuevoValor = binding.etValor.getText().toString();

            if (TextUtils.isEmpty(nuevoValor)) {
                Toast.makeText(this, "Ingrese nuevo tipo de cambio", Toast.LENGTH_SHORT).show();
                return;
            }

            double valor = Double.parseDouble(nuevoValor);
            viewModel.cambiarTipoCambio(valor);
        });
    }
}