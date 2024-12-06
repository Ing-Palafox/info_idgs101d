package com.example.info_idgs101d

import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referenciar los elementos del XML
        val etNombres = findViewById<EditText>(R.id.etNombres)
        val etPrimerApellido = findViewById<EditText>(R.id.etPrimerApellido)
        val etSegundoApellido = findViewById<EditText>(R.id.etSegundoApellido)
        val etEdad = findViewById<EditText>(R.id.etEdad)
        val dpFechaNacimiento = findViewById<DatePicker>(R.id.dpFechaNacimiento)
        val btnEnviar = findViewById<Button>(R.id.btnEnviar)

        // Configurar el botón de envío
        btnEnviar.setOnClickListener {
            val nombres = etNombres.text.toString()
            val primerApellido = etPrimerApellido.text.toString()
            val segundoApellido = etSegundoApellido.text.toString()
            val edad = etEdad.text.toString().toIntOrNull()

            // Obtener la fecha seleccionada
            val dia = dpFechaNacimiento.dayOfMonth
            val mes = dpFechaNacimiento.month + 1 // Los meses comienzan en 0
            val anio = dpFechaNacimiento.year
            val fechaNacimiento = "$dia/$mes/$anio"

            // Validar los campos
            if (nombres.isEmpty() || primerApellido.isEmpty() || segundoApellido.isEmpty() || edad == null) {
                Toast.makeText(this, "Por favor, completa todos los campos correctamente", Toast.LENGTH_SHORT).show()
            } else {
                // Enviar los datos (aquí puedes implementar tu lógica de envío)
                enviarDatos(nombres, primerApellido, segundoApellido, edad, fechaNacimiento)
            }
        }
    }

    private fun enviarDatos(
        nombres: String,
        primerApellido: String,
        segundoApellido: String,
        edad: Int,
        fechaNacimiento: String
    ) {
        // Simulación de envío de datos
        Toast.makeText(
            this,
            "Datos enviados: $nombres $primerApellido $segundoApellido, Edad: $edad, Fecha: $fechaNacimiento",
            Toast.LENGTH_LONG
        ).show()

        // Aquí puedes implementar la conexión con tu API o base de datos
    }
}
