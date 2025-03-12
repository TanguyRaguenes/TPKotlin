package com.example.tp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp.ui.theme.DesignButton
import com.example.tp.ui.theme.DesignPage
import com.example.tp.ui.theme.DesignTextField

class ForgottenPasswordActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ForgottenPasswordPage()
        }
    }
}

@Composable
fun ForgottenPasswordPage() {


    DesignPage {

        Column {
            Spacer(modifier=Modifier.size(200.dp))
            Text(
                text= stringResource(R.string.app_text_password_recovery),
                color= Color(255,255,255,255),
                fontSize=30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier=Modifier.size(100.dp))
            DesignTextField(text= stringResource(R.string.app_field_email_hint),icon =Icons.Default.Email)
            DesignButton(text= stringResource(R.string.app_btn_send_recovery_link), modifier = Modifier.fillMaxWidth(  ))
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text= stringResource(R.string.app_text_password_recovery_advice),
                color= Color(255,255,255,255),
                fontSize=25.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
            )
        }

    }

}


@Preview(showBackground = true)
@Composable
fun ForgottenPasswordPagePreview() {
    ForgottenPasswordPage()
}