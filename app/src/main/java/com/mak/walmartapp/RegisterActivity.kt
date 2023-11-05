package com.mak.walmartapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnSignIn = findViewById<AppCompatButton>(R.id.btnSignIn)

        btnSignIn.setOnClickListener {
            val txtFirstName = findViewById<EditText>(R.id.txtFirstName)
            val txtLastName = findViewById<EditText>(R.id.txtLastName)
            val txtEmail = findViewById<EditText>(R.id.txtEmail)
            val txtPassword = findViewById<EditText>(R.id.txtPassword)

            if (txtFirstName.text.isEmpty() || txtLastName.text.isEmpty() || txtEmail.text.isEmpty() || txtPassword.text.isEmpty()) {
                showToastMessage("All fields are mandatory")
                return@setOnClickListener
            }
            val newUser = User(
                txtFirstName.text.toString().trim(),
                txtLastName.text.toString().trim(),
                txtEmail.text.toString().trim(),
                txtPassword.text.toString()
            )

            /*val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)*/

            val resultIntent = Intent()
            resultIntent.putExtra("user_data", newUser as Parcelable)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
        setResult(Activity.RESULT_CANCELED)
        finish()
    }


    private fun showToastMessage(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
    }
}