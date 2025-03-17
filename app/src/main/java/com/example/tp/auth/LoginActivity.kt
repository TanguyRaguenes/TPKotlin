package com.example.tp.auth

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp.AppViewHelper
import com.example.tp.R
import com.example.tp.ui.theme.DesignButton
import com.example.tp.ui.theme.DesignPage
import com.example.tp.ui.theme.DesignTextField

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                LoginPage()
        }
    }
}

@Composable
fun LoginPage() {


  DesignPage {

      val context = LocalContext.current

      Column (
          modifier = Modifier.verticalScroll(rememberScrollState()),
          horizontalAlignment = Alignment.CenterHorizontally
      ) {


          Icon(imageVector = Icons.Default.AccountCircle, modifier=Modifier.size(116.dp), contentDescription = null, tint = Color(color = 0xffffffff))
          Text(
              text="Login",
              modifier = Modifier.fillMaxWidth().padding(vertical = 100.dp),
              textAlign = TextAlign.Center,
              fontSize = 36.sp

          )
          DesignTextField(text="Email", icon = Icons.Default.Email)
          DesignTextField(text="Password", icon = Icons.Default.Lock)

          DesignButton(
              text= stringResource(R.string.app_btn_forget_password),
              onClick = {
                  AppViewHelper.openActivity(context,ForgottenPasswordActivity::class.java )
              },
              modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)
          )

          DesignButton(
              text= stringResource(R.string.app_title_login),
              modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)
          )

          Spacer(modifier = Modifier.weight(1f))

          Text( text= stringResource(
              R.string.app_btn_dont_have_account
          ),
              textAlign=TextAlign.Center,
              fontStyle = FontStyle.Italic,
              fontSize = 25.sp,
              color = Color(color=0xFFFFFFFF),
              modifier = Modifier.fillMaxWidth()

          )

          DesignButton(
              text= stringResource(R.string.app_btn_register_now),
              onClick = {
                  AppViewHelper.openActivity(context,RegistrationActivity::class.java )
              },
              modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp))


  } }

}


@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    LoginPage()
}