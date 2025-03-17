package com.example.tp

import android.content.Context
import android.content.Intent

class AppViewHelper {

    companion object{

        fun openActivity(context: Context, kClass:Class<*>){
            val intent = Intent(context, kClass)
            context.startActivity(intent)
        }

    }

}