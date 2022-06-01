package com.example.dmovroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.dmovroom.database.User

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.saveUser(User(
            "Userid0001",
            "name001b",
            1.72,
            72.2,
            "user001@email.com",
            "passworduser001"

        ))

        mainViewModel.getUsers()

        //Si es Fragment es con viewLifecycleOwner en vez de this
        mainViewModel.savedUsers.observe(this, {usersList ->
         if(!usersList.isNullOrEmpty()){
             for(user in usersList){
                 Log.d("EstosSonLosUsuarios", user.user_name)
             }
         }else{
             Log.d("EstosSonLosUsuarios", "null or empty")
         }
        })

    }
}