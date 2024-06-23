package com.example.calculatorkt

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var txtResult: TextInputEditText
    private var operand: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtResult = findViewById(R.id.txtResult)

        val btnsNum = arrayOf(
            findViewById<Button>(R.id.btnZero),
            findViewById<Button>(R.id.btnOne),
            findViewById<Button>(R.id.btnTwo),
            findViewById<Button>(R.id.btnThree),
            findViewById<Button>(R.id.btnFour),
            findViewById<Button>(R.id.btnFive),
            findViewById<Button>(R.id.btnSix),
            findViewById<Button>(R.id.btnSeven),
            findViewById<Button>(R.id.btnEight),
            findViewById<Button>(R.id.btnNine)
        )

        val btnsOp = arrayOf(
            findViewById<Button>(R.id.btnSoma),
            findViewById<Button>(R.id.btnSub),
            findViewById<Button>(R.id.btnMult),
            findViewById<Button>(R.id.btnDivide)
        )

        for (i in btnsNum.indices) {
            btnsNum[i].setOnClickListener {
                txtResult.setText("${txtResult.text}${i}")
            }
        }

        for (btn in btnsOp) {
            btn.setOnClickListener {
                operand = txtResult.text.toString().toDouble()
                operation = (it as Button).text.toString()
                txtResult.setText("")
            }
        }

        findViewById<Button>(R.id.btnEqual).setOnClickListener {
            val secondOperand = txtResult.text.toString().toDouble()
            when (operation) {
                "+" -> txtResult.setText("${operand + secondOperand}")
                "-" -> txtResult.setText("${operand - secondOperand}")
                "x" -> txtResult.setText("${operand * secondOperand}")
                "÷" -> txtResult.setText("${operand / secondOperand}")
            }
        }

        findViewById<Button>(R.id.btnClean).setOnClickListener {
            txtResult.setText("")
            operand = 0.0
            operation = ""
        }
    }
}