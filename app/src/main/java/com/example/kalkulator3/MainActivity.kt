package com.example.kalkulator3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlin.math.*

class MainActivity : AppCompatActivity() {

    private lateinit var display: EditText
    private var operator: String = ""
    private var operand1: Double = 0.0
    private var operand2: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.display)
    }

    fun onDigit(view: View) {
        display.append((view as Button).text)
    }

    fun onOperator(view: View) {
        if (display.text.isNotEmpty()) {
            operand1 = display.text.toString().toDouble()
            operator = (view as Button).text.toString()
            display.text.clear()
        }
    }

    fun onDecimalPoint(view: View) {
        if (!display.text.contains(".")) {
            display.append(".")
        }
    }

    fun onEqual(view: View) {
        if (display.text.isNotEmpty()) {
            operand2 = display.text.toString().toDouble()
            val result = when (operator) {
                "+" -> operand1 + operand2
                "-" -> operand1 - operand2
                "*" -> operand1 * operand2
                "/" -> operand1 / operand2
                else -> 0.0
            }
            display.setText(result.toString())
        }
    }

    fun onTrigFunction(view: View) {
        if (display.text.isNotEmpty()) {
            operand1 = display.text.toString().toDouble()
            val result = when ((view as Button).text.toString()) {
                "sin" -> sin(Math.toRadians(operand1))
                "cos" -> cos(Math.toRadians(operand1))
                "tan" -> tan(Math.toRadians(operand1))
                else -> 0.0
            }
            display.setText(result.toString())
        }
    }

    fun onClear(view: View) {
        display.text.clear()
        operand1 = 0.0
        operand2 = 0.0
        operator = ""
    }
}
