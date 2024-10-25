package com.example.appauthenticator

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.appauthenticator.ui.theme.AppAuthenticatorTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val auth = Firebase.auth
        Log.i(TAG, "onCreate usuario atual: ${auth.currentUser}")

        auth.createUserWithEmailAndPassword(
            "james.francis.byrnes@example-pet-store.com",
            "123456"
        ).addOnCompleteListener { task ->
            if(task.isSuccessful){
                Log.i(TAG, "onCreate: Sucesso")
            }else{
                Log.i(TAG, "onCreate: Falha -> ${task.exception}")
            }
        }

        enableEdgeToEdge()
        setContent {
            AppAuthenticatorTheme {

            }
        }
    }
}

