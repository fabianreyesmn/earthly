package com.example.earthly

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast

class BanderasControl : LinearLayout {
    var imageBandera: ImageView? = null
    var btnOp1: Button? = null
    var btnOp2: Button? = null
    var btnOp3: Button? = null
    var btnOp4: Button? = null

    private val banderas = listOf(
        R.drawable.argentina to "Argentina",
        R.drawable.brasil to "Brasil",
        R.drawable.canada to "Canadá",
        R.drawable.chile to "Chile",
        R.drawable.colombia to "Colombia",
        R.drawable.cuba to "Cuba",
        R.drawable.estados_unidos_de_america to "E.U.A.",
        R.drawable.mexico to "México",
        R.drawable.peru to "Perú",
        R.drawable.venezuela to "Venezuela"
    )

    constructor(context: Context?) : super(context){
        inicializar()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        inicializar()
    }

    fun inicializar(){
        val li = LayoutInflater.from(context)
        li.inflate(R.layout.banderas_control, this, true)
        imageBandera = findViewById(R.id.bandera)
        btnOp1 = findViewById(R.id.op1)
        btnOp2 = findViewById(R.id.op2)
        btnOp3 = findViewById(R.id.op3)
        btnOp4 = findViewById(R.id.op4)

        banderaAleatoria()
    }

    private fun banderaAleatoria() {
        val (imagenBandera, nombreCorrecto) = banderas.random()
        imageBandera?.setImageResource(imagenBandera)

        val nombresIncorrectos = banderas.map { it.second }.filter { it != nombreCorrecto }.shuffled().take(3)
        val opciones = (nombresIncorrectos + nombreCorrecto).shuffled()

        btnOp1?.text = opciones[0]
        btnOp2?.text = opciones[1]
        btnOp3?.text = opciones[2]
        btnOp4?.text = opciones[3]

        btnOp1?.setOnClickListener { verificarResp(btnOp1?.text.toString(), nombreCorrecto) }
        btnOp2?.setOnClickListener { verificarResp(btnOp2?.text.toString(), nombreCorrecto) }
        btnOp3?.setOnClickListener { verificarResp(btnOp3?.text.toString(), nombreCorrecto) }
        btnOp4?.setOnClickListener { verificarResp(btnOp4?.text.toString(), nombreCorrecto) }
    }

    private fun verificarResp(respuesta: String, nombreCorrecto: String) {
        if (respuesta == nombreCorrecto) {
            Toast.makeText(context, "Respuesta Correcta", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Incorrecto", Toast.LENGTH_SHORT).show()
        }
    }


}