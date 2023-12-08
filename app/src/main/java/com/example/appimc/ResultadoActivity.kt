package com.example.appimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
    private lateinit var textPeso: TextView
    private lateinit var textAltura: TextView
    private lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        textPeso= findViewById(R.id.text_peso)
        textAltura= findViewById(R.id.text_altura)
        textResultado= findViewById(R.id.text_resultado)

        val bundle =intent.extras

        if (bundle != null){
            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")

            textPeso.text="Peso informado $peso KG"
            textAltura.text="Altura informada $altura M"

            val imc = peso / (altura * altura)

            textResultado.text = if(imc < 18.5 ){
                 "Baixo"
            }else if(imc in 18.0..24.9){
                "Normal"
            }else if (imc in 25.0 .. 29.9){
                "Sobrepeso"
            } else{
                 "Obeso"
            }


        }

    }
}