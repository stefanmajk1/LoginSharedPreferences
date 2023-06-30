package com.example.loginsharepreference

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {

        //pokretanje inicijalizacije Activity-ja
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //pronalazenje view-va
        val btnLogin = findViewById<Button>(R.id.btn_login)
        val edUsername = findViewById<EditText>(R.id.ed_username)
        val edPassword = findViewById<EditText>(R.id.ed_password)

        //kreiranje sharedPrefrence, i kreiranje 'MY_PRE' gde ce se cuvati podaci
        //'MODE_PRIVATE' znaci da je privatna fascikla, ogranicen pristup
        val sharedPreferences = getSharedPreferences("MY_PRE", Context.MODE_PRIVATE)
        val getUsername = sharedPreferences.getString("USERNAME", "").toString()
        val getPassword = sharedPreferences.getString("PASSWORD", "").toString()

        //ako sadrzi podatke vec pokrenuce drugi activity sa prikazanim podacima
        if(getUsername.isNotEmpty() && getPassword.isNotEmpty()){
            val i = Intent(this, HomeActivity::class.java)
            startActivity(i)
        }


        //dugme na klik pokrece ovaj kod
        btnLogin.setOnClickListener{

            val username = edUsername.text.toString()
            val password = edPassword.text.toString()

            //omogucavamo editovanje sharedPrefrences
            val editor = sharedPreferences.edit()

            //dodeljujemo podatke
            editor.putString("USERNAME", username)
            editor.putString("PASSWORD", password)

            //cuvamo podatke
            editor.apply()

            //pokrecemo novi activity
            val i = Intent(this, HomeActivity::class.java)
            startActivity(i)

        }


    }
}