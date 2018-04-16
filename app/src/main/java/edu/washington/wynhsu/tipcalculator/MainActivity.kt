package edu.washington.wynhsu.tipcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.text.Editable
import android.text.Selection
import android.text.TextWatcher


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val value = findViewById<EditText>(R.id.txtAmount)
        value.setText("$")
//        Selection.setSelection(value.getText(), value.getText().length())

        value.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                val tip = findViewById<Button>(R.id.btnTip)
                tip.setClickable(true)
            }
        })
    }

    override fun onResume() {
        super.onResume()
        val tip = findViewById<Button>(R.id.btnTip)
        tip.setOnClickListener {

        }
    }
}
