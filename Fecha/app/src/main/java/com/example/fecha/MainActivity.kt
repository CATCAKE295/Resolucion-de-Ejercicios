package com.example.fecha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.fecha.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnResolver.setOnClickListener {

            Edad()
        }

    }

    fun Edad(){

        var fecha = binding.txtdFecha.text
        lateinit var fechaNac:Date

        fechaNac = SimpleDateFormat("dd/MM/yyyy").parse(fecha.toString())

        var fechaActual = Date(System.currentTimeMillis())

        var diferenciaFecha = fechaNac.time-fechaActual.time
        var Segundo = diferenciaFecha/1000
        var minuto = Segundo/60
        var hora = minuto/60
        var dia = hora/24
        var año = -dia/365

        var res1 = "Tu tienes ${año} años, eres menor de edad"
        var res2 = "Tu tienes ${año} años, eres mayor de edad"
        var res: String

        if (año < 18){
            res = res1
        }else{
            res = res2
        }

        val MENSAJE = AlertDialog.Builder(this)
            .setTitle("Respuesta")
            .setMessage(res)

        MENSAJE.show()
    }
}

//Leer la fecha de nacimiento de una persona, calcular su edad. Si es menor de edad mostrar
//la imagen de un juguete y si es menor de edad mostrar la imagen de una factura.//