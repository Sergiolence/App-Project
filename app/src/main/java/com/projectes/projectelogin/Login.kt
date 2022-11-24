package com.projectes.projectelogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        var btnSignIn:Button = findViewById(R.id.btnSignIn)
        var txtUsername:EditText = findViewById(R.id.txtUsername)
        var txtPassword:EditText = findViewById(R.id.txtPassword)
        var ibnLoginResult:TextView = findViewById(R.id.IbLoginResult)

        btnSignIn.setOnClickListener {
               /* Toast.makeText(this@MainActivity, "Login correcte", Toast.LENGTH_SHORT).show() */
            ibnLoginResult.text = "Login correcte"
            Log.i("Test", "Login correcte")
            var x:String = txtUsername.getText().toString()
            Log.i("Test2", x)

            /*if(x == "admin" &&){

            }*/
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
}