package com.example.iva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.iva.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var Lista: MutableList<Producto> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGuardar.setOnClickListener {
            Lista.add(Producto(binding.txtProducto.text.toString(),binding.txtPrecio.text.toString().toDouble()))
            val total = Lista.map {
                it.precio
            }.sum()

            binding.txtTotal.text = "Total ${total}"

            binding.swIva.setOnCheckedChangeListener { compoundButton, onSwitch ->
                if (onSwitch){
                    binding.txtTotal.text = "Total ${total * 0.15}"
                }
                else{
                    binding.txtTotal.text = "Total: ${total}"
                }
            }
        }

    }
}