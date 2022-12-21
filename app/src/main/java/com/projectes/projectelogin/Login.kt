package com.projectes.projectelogin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

//This is the first page it appears when you open the app, it contains a form to log in
class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        val sharedPreference = getSharedPreferences("APP_CONFIG", Context.MODE_PRIVATE)
        val intent = Intent(this, MainActivity::class.java)

        //This validates if you have already logged and directs you to the application
        if(sharedPreference.getBoolean("login", false)){
            startActivity(intent)
        }

        var btnSignIn:Button = findViewById(R.id.btnSignIn)
        var txtUsername:EditText = findViewById(R.id.txtUsername)
        var txtPassword:EditText = findViewById(R.id.txtPassword)
        var ibnLoginResult:TextView = findViewById(R.id.IbLoginResult)


        //When you click the Login button, if your fields correspond with the correct information you will log in
        btnSignIn.setOnClickListener {
            var username:String = txtUsername.getText().toString()
            var password:String = txtPassword.getText().toString()
            Log.i("Test2", username)
            if(username == "admin" && password == "admin"){
                sharedPreference.edit().putBoolean("login", true).commit();
                startActivity(intent)
                ibnLoginResult.text = "Login correcte"
                Log.i("Test", "Login correcte")
            } else {
                Toast.makeText(this, "Log in incorrecto", Toast.LENGTH_SHORT).show()
            }
        }
    }
}