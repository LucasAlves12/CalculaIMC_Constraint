package com.example.calculaimcconstraint

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
    class ExampleUnitTest {
        @Test
        fun testar_intervalo_imc() {
            val calculo = Calculo()
            assertEquals("24,9", calculo.calculaIMC( 90.0 , 1.9) )
        }
    }
