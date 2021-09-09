package com.example.calculator

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        with(binding) {
            btn0.setOnClickListener { setTextField("0") }
            btn1.setOnClickListener { setTextField("1") }
            btn2.setOnClickListener { setTextField("2") }
            btn3.setOnClickListener { setTextField("3") }
            btn4.setOnClickListener { setTextField("4") }
            btn5.setOnClickListener { setTextField("5") }
            btn6.setOnClickListener { setTextField("6") }
            btn7.setOnClickListener { setTextField("7") }
            btn8.setOnClickListener { setTextField("8") }
            btn9.setOnClickListener { setTextField("9") }
            openBtn.setOnClickListener { setTextField("(") }
            closeBtn.setOnClickListener { setTextField(")") }
            plusBtn.setOnClickListener { setTextField("+") }
            minusBtn.setOnClickListener { setTextField("-") }
            multiplicationBtn.setOnClickListener { setTextField("*") }
            divisionBtn.setOnClickListener { setTextField("/") }
            acBtn.setOnClickListener {
                mathOperation.text = ""
                resultText.text = ""
            }
            backBtn.setOnClickListener {
                val str = mathOperation.text.toString()
                if (str.isNotEmpty())
                    mathOperation.text = str.substring(0, str.length - 1)
                resultText.text = ""
            }
            equalsBtn.setOnClickListener {
                try {
                    val str = binding.mathOperation.text.toString()
                    val plus = str.indexOf('+')
                    val minus = str.indexOf('-')
                    val multiple = str.indexOf('*')
                    val divide = str.indexOf('/')

                    var arr = listOf<Int>(plus, minus, multiple, divide)
                    var indexOfOperator: Int = 0
                    var operator = ""
                    for (i in arr){
                        if (i != -1) indexOfOperator = i
                        operator = str.get(indexOfOperator).toString()

                    }

                    val firstNumber = str.substringBefore(operator).toInt()
                    val secondNumber = str.substringAfter(operator).toInt()

                    var result = 0
                    if(operator == "+"){
                        result = firstNumber + secondNumber
                    }
                    if (operator == "-"){
                        result = firstNumber - secondNumber
                    }
                    if (operator == "*")
                    {
                        result = firstNumber * secondNumber
                    }
                    if (operator == "/")
                    {
                        result = firstNumber / secondNumber
                    }

                    var res = result
                    binding.resultText.text = res.toString()



                } catch (e: Exception) {
                    Log.d("Ошибка", "сообщение: ${e.message}")

                }
            }

        }

    }

    fun setTextField(str: String) {
        binding.mathOperation.append(str)


    }

}