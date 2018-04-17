package edu.washington.wynhsu.tipcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.text.Editable
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
                value.removeTextChangedListener(this)
                if (s.toString().isNotEmpty() && !s.toString().startsWith("$")) {
                    val concat = "$" + s.toString()
                    value.setText(concat)
                    value.setSelection(value.text.length)
                }
                tip.isClickable = value.text.toString().isNotEmpty()
                value.addTextChangedListener(this)
            }
            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
            }
        })
    }

    override fun onResume() {
        super.onResume()
        val tip = findViewById<Button>(R.id.btnTip)
        val value = findViewById<EditText>(R.id.txtAmount)

        tip.setOnClickListener {
            var curr = value.text.toString()
            if (!curr.contains('.')) {
                curr += ".00"
            }
            value.setText(curr)
            value.setSelection(value.text.length)

            val sub = value.text.substring(1, value.text.length)
            val dub = sub.toDouble()
            val taxed = dub * .15
            val str = "%.2f".format(taxed)
            val strTax = "%.2f".format(dub)
            value.setText(strTax)
            val result = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, str, result)
            toast.show()
        }
    }
}