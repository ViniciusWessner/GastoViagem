package com.viniciuswessner.gastosviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.viniciuswessner.gastosviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

   private lateinit var binding: ActivityMainBinding


    //View binding = conexao entre partes (conectar layout no codigo)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.butonCalculate.setOnClickListener(this)
    }


    private fun isvalid(): Boolean{
       return (binding.editDistancia.text.toString() != ""
               && binding.editPreco.text.toString() != ""
               && binding.editAutonomia.text.toString() !=""
               && binding.editAutonomia.text.toString().toFloat() != 0f
               )
    }

    fun calculate(){

        if (isvalid()){

            val distancia = binding.editDistancia.text.toString().toFloat()
            val preco = binding.editPreco.text.toString().toFloat()
            val autonomia = binding.editAutonomia.text.toString().toFloat()

            val valortotal = (distancia*preco)/autonomia

            binding.txtTotalvalor.text = "RS ${"%.2f".format(valortotal)}"
            //toast notification
            //Toast.makeText(this,valortotalstr, Toast.LENGTH_SHORT).show()

        }else{
            Toast.makeText(this,R.string.aviso, Toast.LENGTH_SHORT).show()
        }



    }

    override fun onClick(view: View) {
        if (view.id == R.id.buton_calculate){
            calculate()
        }
    }
}