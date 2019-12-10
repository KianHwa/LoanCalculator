package com.example.loancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val completeBtn:Button = findViewById(R.id.buttonCalculate)
        completeBtn.setOnClickListener{calculateLoan()}

        val resetButton = findViewById<Button>(R.id.buttonReset)
        resetButton.setOnClickListener{reset()}

    }

    private fun calculateLoan(){
        //Edit Text
        val carPriceText = findViewById<EditText>(R.id.editTextCarPrice)
        val downPaymentText = findViewById<EditText>(R.id.editTextDownPayment)
        val loanPeriodText = findViewById<EditText>(R.id.editTextLoanPeriod)
        val interestRateText = findViewById<EditText>(R.id.editTextInterestRate)

        //Text View
        val loan = findViewById<TextView>(R.id.textViewLoan)
        val interest = findViewById<TextView>(R.id.textViewInterest)
        val monthlyRepayment = findViewById<TextView>(R.id.textViewMonthlyRepayment)


            var loanCalc =
                carPriceText.text.toString().toFloat() - downPaymentText.text.toString().toFloat()
            var interestCalc =
                loanCalc.toFloat() * interestRateText.text.toString().toFloat()/100 * loanPeriodText.text.toString().toFloat()
            var monthlyRepayCalc =
                (loanCalc.toFloat() + interestCalc.toFloat()) / loanPeriodText.text.toString().toFloat() / 12

            loan.text = "Loan : RM " + String.format("%.2f", loanCalc.toString().toFloat())
            interest.text = "Interest : RM " + String.format("%.2f",interestCalc.toString().toFloat())
            monthlyRepayment.text = "Monthly Repayment : RM " + String.format("%.2f",monthlyRepayCalc.toString().toFloat())

    }

    private fun reset(){
        val carPriceText = findViewById<EditText>(R.id.editTextCarPrice)
        val downPaymentText = findViewById<EditText>(R.id.editTextDownPayment)
        val loanPeriodText = findViewById<EditText>(R.id.editTextLoanPeriod)
        val interestRateText = findViewById<EditText>(R.id.editTextInterestRate)

        carPriceText.text = null;
        downPaymentText.text = null;
        loanPeriodText.text = null;
        interestRateText.text = null;

        val loan = findViewById<TextView>(R.id.textViewLoan)
        val interest = findViewById<TextView>(R.id.textViewInterest)
        val monthlyRepayment = findViewById<TextView>(R.id.textViewMonthlyRepayment)

        loan.setText(R.string.loan)
        interest.setText(R.string.interest)
        monthlyRepayment.setText(R.string.monthly_repayment)

        Toast.makeText(this, "All valued cleared",
            Toast.LENGTH_SHORT).show()
    }
}
