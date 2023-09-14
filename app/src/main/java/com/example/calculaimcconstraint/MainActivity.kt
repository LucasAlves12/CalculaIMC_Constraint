package com.example.calculaimcconstraint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var etPeso:EditText
    private lateinit var etAltura:EditText
    private lateinit var tvResultado:TextView
    private lateinit var btCalcular:Button
    private lateinit var btLimpar:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etPeso = findViewById(R.id.etPeso)
        etAltura = findViewById(R.id.etAltura)
        tvResultado = findViewById(R.id.tvResultado)
        btCalcular = findViewById(R.id.btCalcular)
        btLimpar = findViewById(R.id.btLimpar)

        btCalcular.setOnClickListener{
            btCalcularOnClick()
        }

        btLimpar.setOnClickListener{
            btLimparOnClick()
        }

        btLimpar.setOnLongClickListener{
            Toast.makeText(this,"Botão que limpa",Toast.LENGTH_SHORT).show()
            return@setOnLongClickListener false
        }
        Log.d( "ciclo_de_vida", "onCreate() executado" )

        if ( savedInstanceState != null ) {
            val imc = savedInstanceState.getString( "imc" )
            tvResultado.text = imc
        }
    }

    private fun btCalcularOnClick(){
        if ( etPeso.text.toString().isEmpty() ) {
            etPeso.error = getString(R.string.error_peso)
            return
        }

        if ( etAltura.text.toString().isEmpty() ) {
            etAltura.error = getString(R.string.error_altura)
            return
        }

        //entrada
        val peso = etPeso.text.toString().toDouble()
        val altura = etAltura.text.toString().toDouble()

        //processamento
        val calculo = Calculo()
        val imc = calculo.calculaIMC( peso, altura )

        //saída
        tvResultado.setText( imc )

    }
    private fun btLimparOnClick(){
        etPeso.setText("")
        etAltura.setText("")
        tvResultado.text="0.0"
        etPeso.requestFocus()
    }

    override fun onStart() {
        super.onStart()
        Log.d( "ciclo_de_vida", "onStart() executado" )
    }

    override fun onResume() {
        super.onResume()
        Log.d( "ciclo_de_vida", "onResume() executado" )
    }

    override fun onPause() {
        super.onPause()
        Log.d( "ciclo_de_vida", "onPause() executado" )
    }

    override fun onStop() {
        super.onStop()
        Log.d( "ciclo_de_vida", "onStop() executado" )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d( "ciclo_de_vida", "onDestroy() executado" )
    }

    override fun onRestart() {
        super.onRestart()
        Log.d( "ciclo_de_vida", "onRestart() executado" )
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString( "imc", tvResultado.text.toString())
    }

}


class Calculo {
    fun calculaIMC( peso : Double, altura : Double ) : String {
        val imc = peso / altura.pow( 2.0 )
        val df = DecimalFormat( "0.0")
        return df.format( imc )
    }
}