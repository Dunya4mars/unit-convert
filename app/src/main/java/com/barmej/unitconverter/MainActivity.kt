package com.barmej.unitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    val TAG ="MainActivity"
    private val iraqDinar =" Iraqi Dinar"
    private val americanDollar ="American Dollar"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonConverter:Button = findViewById(R.id.button_convert)
        val amountEditText:TextInputEditText = findViewById(R.id.from_AutoCompleteTextView3)
        val resultEditText:TextInputEditText = findViewById(R.id.from_AutoCompleteTextView4)
        val listOfUnitConverter = listOf(iraqDinar,americanDollar)

        val toDropDownMenuFrom:AutoCompleteTextView=findViewById(R.id.from_AutoCompleteTextView)
        val toDropDownMenuTO:AutoCompleteTextView = findViewById(R.id.from_AutoCompleteTextView2)

        val adapter = ArrayAdapter(this,R.layout.drop_dawn_list,listOfUnitConverter)
        toDropDownMenuTO.setAdapter(adapter)
        toDropDownMenuFrom.setAdapter(adapter)


        buttonConverter.setOnClickListener {

           val amount = amountEditText.text.toString().toDouble()
            val currencyFromField = toDropDownMenuFrom.text.toString()
            val currencyToField = toDropDownMenuTO.text.toString()
            var result = 0.0

            if(currencyFromField==iraqDinar && currencyToField==americanDollar){
               result= amount.div(1.5)
            }else if (currencyFromField==americanDollar && currencyToField==iraqDinar){
                result= amount.times(1.5)
            } else{
                result=amount.times(1)
                Toast.makeText(this,"لقد اخترت التحويل من نوعية العمله نفسها , قم بيغيير النوعيه",Toast.LENGTH_LONG).show()

            }
            resultEditText.setText(result.toString())

            //            Log.d(TAG,"the result is"+ result )



        }
    }
}