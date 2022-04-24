package com.swancodes.unitconverter

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.swancodes.unitconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var strNumber = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.convertButton.setOnClickListener {
            binding.footResultTxt.text =
                convertMeter(strNumber.toString()).toString()

        }

        val meterResult: TextView = binding.meterResultTxt

        initializeComponents(meterResult)
    }

    private fun initializeComponents(meterResult: TextView) {
        binding.button0.setOnClickListener {
            strNumber.append("0")
            meterResult.text = strNumber
        }
        binding.button00.setOnClickListener {
            strNumber.append("00")
            meterResult.text = strNumber
        }
        binding.button1.setOnClickListener {
            strNumber.append("1")
            meterResult.text = strNumber
        }
        binding.button2.setOnClickListener {
            strNumber.append("2")
            meterResult.text = strNumber
        }
        binding.button3.setOnClickListener {
            strNumber.append("3")
            meterResult.text = strNumber
        }
        binding.button4.setOnClickListener {
            strNumber.append("4")
            meterResult.text = strNumber
        }
        binding.button5.setOnClickListener {
            strNumber.append("5")
            meterResult.text = strNumber
        }
        binding.button6.setOnClickListener {
            strNumber.append("6")
            meterResult.text = strNumber
        }
        binding.button7.setOnClickListener {
            strNumber.append("7")
            meterResult.text = strNumber
        }
        binding.button8.setOnClickListener {
            strNumber.append("8")
            meterResult.text = strNumber
        }
        binding.button9.setOnClickListener {
            strNumber.append("9")
            meterResult.text = strNumber
        }
        binding.point.setOnClickListener {
            if (!strNumber.contains(".")) {
                strNumber.append(".")
                meterResult.text = strNumber
            } else if (strNumber.isNotEmpty()) {
                strNumber.append(".")
            }

        }
        binding.clearAllButton.setOnClickListener {
            meterResult.text = 0.toString()
            binding.footResultTxt.text = 0.toString()
            strNumber.clear()
        }
        binding.backspaceButton.setOnClickListener {
            if (strNumber.isNotEmpty()) {
                strNumber.deleteAt(strNumber.lastIndex)
                binding.meterResultTxt.text = strNumber
            }
        }
    }

    private fun convertMeter(string: String): Double {
        val meterValue = string.toDouble().toInt()
        val feetValue = 3.2808399
        return meterValue * feetValue
    }
}

