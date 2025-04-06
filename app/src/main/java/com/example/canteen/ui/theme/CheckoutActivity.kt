package com.example.canteen.ui.theme

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.canteen.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class CheckoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_checkout)

        // Get references to UI elements
        val etTableNumber = findViewById<TextInputEditText>(R.id.etTableNumber)
        val etInstructions = findViewById<TextInputEditText>(R.id.etInstructions)
        val btnConfirmOrder = findViewById<MaterialButton>(R.id.btnConfirmOrder)

        // Set click listener for the confirm button
        btnConfirmOrder.setOnClickListener {
            val tableNumber = etTableNumber.text.toString().trim()
            val instructions = etInstructions.text.toString().trim()

            if (tableNumber.isEmpty()) {
                etTableNumber.error = "Table number is required"
                return@setOnClickListener
            }

            // Process order confirmation
            Toast.makeText(this, "Order confirmed for Table $tableNumber", Toast.LENGTH_SHORT).show()
        }
    }
}
