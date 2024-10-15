package com.example.calculator_linearlayout

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var textReuslt: TextView

    var state: Int = 1
    var op: Int = 0
    var op1: Int = 0
    var op2: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textReuslt = findViewById(R.id.result)

        findViewById<Button>(R.id.bnt0).setOnClickListener(this)
        findViewById<Button>(R.id.bnt1).setOnClickListener(this)
        findViewById<Button>(R.id.bnt2).setOnClickListener(this)
        findViewById<Button>(R.id.bnt3).setOnClickListener(this)
        findViewById<Button>(R.id.bnt4).setOnClickListener(this)
        findViewById<Button>(R.id.bnt5).setOnClickListener(this)
        findViewById<Button>(R.id.bnt6).setOnClickListener(this)
        findViewById<Button>(R.id.bnt7).setOnClickListener(this)
        findViewById<Button>(R.id.bnt8).setOnClickListener(this)
        findViewById<Button>(R.id.bnt9).setOnClickListener(this)
        findViewById<Button>(R.id.bnt_ce).setOnClickListener(this)
        findViewById<Button>(R.id.bnt_c).setOnClickListener(this)
        findViewById<Button>(R.id.bnt_ab).setOnClickListener(this)
        findViewById<Button>(R.id.bnt_bs).setOnClickListener(this)
        findViewById<Button>(R.id.bnt_div).setOnClickListener(this)
        findViewById<Button>(R.id.bnt_x).setOnClickListener(this)
        findViewById<Button>(R.id.bnt_sub).setOnClickListener(this)
        findViewById<Button>(R.id.bnt_plus).setOnClickListener(this)
        findViewById<Button>(R.id.bnt_equal).setOnClickListener(this)
        findViewById<Button>(R.id.bnt_dot).setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val id = p0?.id
        if (id == R.id.bnt0) {
            addDigit(0)
        } else if (id == R.id.bnt1) {
            addDigit(1)
        } else if (id == R.id.bnt2) {
            addDigit(2)
        } else if (id == R.id.bnt3) {
            addDigit(3)
        } else if (id == R.id.bnt4) {
            addDigit(4)
        } else if (id == R.id.bnt5) {
            addDigit(5)
        } else if (id == R.id.bnt6) {
            addDigit(6)
        } else if (id == R.id.bnt7) {
            addDigit(7)
        } else if (id == R.id.bnt8) {
            addDigit(8)
        } else if (id == R.id.bnt9) {
            addDigit(9)
        } else if (id == R.id.bnt_plus) {
            op = 1
            state = 2
        } else if (id == R.id.bnt_sub) {
            op = 2 // Trừ
            state = 2
        } else if (id == R.id.bnt_x) {
            op = 3 // Nhân
            state = 2
        } else if (id == R.id.bnt_div) {
            op = 4 // Chia
            state = 2

        } else if (id == R.id.bnt_equal) {
            var result = 0
            if (op == 1) {
                result = op1 + op2
            } else if (op == 2) {
                result = op1 - op2
            } else if (op == 3) {
                result = op1 * op2
            } else if (op == 4) {
                if (op2 != 0) {
                    result = op1 / op2
                } else {
                    textReuslt.text = "Error"
                    return
                }
            }

            textReuslt.text = "$result"
            state = 1
            op1 = 0
            op2 = 0
            op = 0
        } else if (id == R.id.bnt_bs){
            if (state == 1) {
                op1 = op1 / 10
                textReuslt.text = "$op1"
            } else {
                op2 = op2 / 10
                textReuslt.text = "$op2"
            }
        } else if (id == R.id.bnt_ce){
            op1 = 0
            op2 = 0
            op = 0
            state = 1
            textReuslt.text = "0"
        } else if (id == R.id.bnt_c) {
            // Xóa số hiện tại (Clear)
            if (state == 1) {
                op1 = 0
                textReuslt.text = "0"
            } else {
                op2 = 0
                textReuslt.text = "0"
            }
        }

    }

    fun addDigit(c: Int) {
        if (state == 1) {
            op1 = op1 * 10 + c
            textReuslt.text = "$op1"
        } else {
            op2 = op2 * 10 + c
            textReuslt.text = "$op2"
        }
    }
}