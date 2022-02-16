package com.example.aumento

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.aumento.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnCalcular.setOnClickListener {

            var nombre = binding.txtNombre.text
            var cargo = binding.txtCargo.text
            var salario = binding.txtSalario.text.toString().toDouble()
            var n_salario:Double = 0.0

            when{
                salario < 5000.00 -> {
                    n_salario = salario  * 0.20
                }
                salario in 5000.01..10000.00 -> {
                    n_salario = salario * 0.15
                }
                salario >= 10000.01 -> {
                    n_salario = salario * 0.10
                }
            }


            val MENSAJE = AlertDialog.Builder(this)
                .setTitle("Respuesta")
                .setMessage("Datos del empleado \n" +
                        "Nombre: ${nombre} \n" +
                        "Cargo: ${cargo} \n" +
                        "Salario: ${salario}C$ \n " +
                        "Aumento: ${n_salario}C$ ")

            MENSAJE.show()


            binding.txtNombre.setText(" ")
            binding.txtCargo.setText(" ")
            binding.txtSalario.setText(" ")
        }


    }
}