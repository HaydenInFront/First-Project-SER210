package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class CalcActivity : AppCompatActivity(), OnItemSelectedListener {

    var input1: EditText? = null
    var input2: EditText? = null
    var res: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        input1 = findViewById<EditText>(R.id.input1);
        input2 = findViewById<EditText>(R.id.input2);
        res = findViewById<TextView>(R.id.result_label);

        findViewById<Button>(R.id.addition).setOnClickListener{
            performOp('+')
        }

        findViewById<Spinner>(R.id.spinner).onItemSelectedListener = this
    }

    private fun performOp(op: Char){

        if (input1 != null && input2 != null) {
            //read from input1 and input2
            val num1: Double = input1?.text.toString().toDouble();
            val num2: Double = input1?.text.toString().toDouble();

            Log.v("Debug", "num 1 $num1 num2 $num2")

            var result = 0.0
            when (op) {
                '+' -> result = num1 + num2
                '-' -> result = num1 - num2
                '*' -> result = num1 * num2
                '/' -> result = num1 / num2
            }

            res?.text = result.toString();
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val op = parent?.getItemAtPosition(position).toString();

        if (op != "none")
            this.performOp(op[0])
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

}