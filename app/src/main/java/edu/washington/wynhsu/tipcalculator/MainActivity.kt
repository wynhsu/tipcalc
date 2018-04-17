package edu.washington.wynhsu.tipcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.text.Editable
import android.text.Selection
import android.text.TextWatcher
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tip = findViewById<Button>(R.id.btnTip)
        val value = findViewById<EditText>(R.id.txtAmount)

        value.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if (!s.toString().startsWith("$")) {
                    value.setText("$")
                    Selection.setSelection(value.getText(), value.getText().toString().length)
                }

                if (value.getText().toString().isEmpty()) {
                    tip.isClickable = false
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
                value.setText("$")
                Selection.setSelection(value.getText(), value.getText().toString().length)
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                tip.isClickable = true
            }
        })
    }

    override fun onResume() {
        super.onResume()
        val tip = findViewById<Button>(R.id.btnTip)
        val value = findViewById<EditText>(R.id.txtAmount)

        tip.setOnClickListener {
            val dub = value.getText().toString().toDouble() * .15
            val str = "%.2f".format(dub)
            val result = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, str, result)
            toast.show()
        }

//        value.setOnFocusChangeListener {
//
//        }
    }
}
