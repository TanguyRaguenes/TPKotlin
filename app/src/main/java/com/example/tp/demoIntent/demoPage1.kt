package com.example.tp.demoIntent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.tp.AppViewHelper
import com.example.tp.auth.LoginActivity
import com.example.tp.ui.theme.DesignButton
import com.example.tp.ui.theme.DesignPage

class DemoPage1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoPage1()
        }
    }
}

@Composable
fun DemoPage1() {


    DesignPage {

        //Récupérer le contexte de l'application
        val context = LocalContext.current

        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            DesignButton(
                text="Ouvir page 2",
                onClick ={
                    AppViewHelper.openActivity(context,LoginActivity::class.java )
                },

            )

        } }

}


@Preview(showBackground = true)
@Composable
fun DemoPage1Preview() {
    DemoPage1()
}