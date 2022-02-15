package com.example.notas

import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.notas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener {
            promedio()
        }

    }

    fun promedio(){

        var sis1 =  Integer.parseInt(binding.txtSistematico1.text.toString())
        var sis2 =  Integer.parseInt(binding.txtSistematico2.text.toString())
        var exam =  Integer.parseInt(binding.txtExamen.text.toString())

         var total = sis1 + sis2 + exam / 3
        var res1 = "su nota final ha sido ${total}, usted a Aprobado"
        var res2 = "su nota final ha sido ${total}, usted a Reprobado"
        var res: String
        if(total >= 85){

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



//Calcular la nota final de un estudiante que posee 2 sistemáticos de 20 puntos cada uno y un
//examen de 60. Mostrar un mensaje al usuario que permita ver si aprobó o reprobó (aprobado
//mayor a 85 pts.)//