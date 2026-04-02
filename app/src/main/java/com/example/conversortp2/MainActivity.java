package com.example.conversortp2;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
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

        // 🔹 Binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 🔹 ViewModel
        viewModel = new ViewModelProvider(this).get(ConversorViewModel.class);

        // 🔹 Observers
        viewModel.getResultado().observe(this, resultado -> {
            binding.tvResultado.setText(resultado);
        });

        viewModel.getTipoCambioTexto().observe(this, cambio -> {
            binding.tvCambio.setText(cambio);
        });

        // 🔹 Botón Convertir
        binding.btnConvertir.setOnClickListener(v -> {

            String valorTexto = binding.etValor.getText().toString();

            // Validar vacío
            if (TextUtils.isEmpty(valorTexto)) {
                Toast.makeText(this, "Ingrese un valor", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validar número
            double valor;
            try {
                valor = Double.parseDouble(valorTexto);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Ingrese un número válido", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validar selección
            if (!binding.rbUSD.isChecked() && !binding.rbEUR.isChecked()) {
                Toast.makeText(this, "Seleccione tipo de conversión", Toast.LENGTH_SHORT).show();
                return;
            }

            // Ejecutar conversión
            if (binding.rbUSD.isChecked()) {
                viewModel.convertir(valor, true);
            } else {
                viewModel.convertir(valor, false);
            }

            // Limpiar input (mejora UX)
            binding.etValor.setText("");
        });

        // 🔹 Botón Cambiar tipo de cambio (con diálogo)
        binding.btnCambiar.setOnClickListener(v -> {

            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle("Nuevo tipo de cambio");

            final EditText input = new EditText(this);
            input.setHint("Ej: 0.95");
            builder.setView(input);

            builder.setPositiveButton("Aceptar", (dialog, which) -> {

                String valorTexto = input.getText().toString();

                if (TextUtils.isEmpty(valorTexto)) {
                    Toast.makeText(this, "Ingrese un valor", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    double nuevoValor = Double.parseDouble(valorTexto);
                    viewModel.cambiarTipoCambio(nuevoValor);
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Número inválido", Toast.LENGTH_SHORT).show();
                }
            });

            builder.setNegativeButton("Cancelar", null);
            builder.show();
        });
    }
}