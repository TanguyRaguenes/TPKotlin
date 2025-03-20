package com.example.tp.auth

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp.AppViewHelper
import com.example.tp.R
import com.example.tp.ui.theme.DesignButton
import com.example.tp.ui.theme.DesignPage
import com.example.tp.ui.theme.DesignTextField

class RegistrationActivity : ComponentActivity() {
    private val viewModel = AuthViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RegistrationPage(viewModel=viewModel)
        }
    }
}

@Composable
fun RegistrationPage(viewModel:AuthViewModel) {

    val context = LocalContext.current
    val registrationRequestDataState by viewModel.registrationRequestData.collectAsState()

    DesignPage(backgroundId =R.drawable.pink_flavour_bg) {

        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Icon(
                imageVector = Icons.Default.AccountBox,
                contentDescription = "",
                tint=Color(255,255,255,255),
                modifier = Modifier.size(150.dp).align(Alignment.CenterHorizontally)

            )
            Text(
                text= stringResource(R.string.app_text_welcome_registration),
                color= Color(255,255,255,255),
                fontSize=15.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),

            )
            DesignTextField(
                text= stringResource(R.string.app_field_pseudo_hint),
                icon = null,
                value=registrationRequestDataState.pseudo,
                onValueChange = {value->viewModel.registrationRequestData.value=viewModel.registrationRequestData.value.copy(pseudo = value)}
            )
            DesignTextField(
                text=stringResource(R.string.app_field_email_hint),
                icon = null,
                value=registrationRequestDataState.email,
                onValueChange = {value->viewModel.registrationRequestData.value=viewModel.registrationRequestData.value.copy(email = value)}
            )
            DesignTextField(
                text=stringResource(R.string.app_field_password_hint),
                icon = null,
                value=registrationRequestDataState.password,
                onValueChange = {value->viewModel.registrationRequestData.value=viewModel.registrationRequestData.value.copy(password = value)}
            )
            DesignTextField(
                text=stringResource(R.string.app_field_password_confirmation_hint),
                icon = null,
                value=registrationRequestDataState.passwordConfirm,
                onValueChange = {value->viewModel.registrationRequestData.value=viewModel.registrationRequestData.value.copy(passwordConfirm = value)}
            )
            DesignTextField(
                text=stringResource(R.string.app_field_city_code_hint),
                icon = null,
                value=registrationRequestDataState.cityCode?:"",
                onValueChange = {value->viewModel.registrationRequestData.value=viewModel.registrationRequestData.value.copy(cityCode = value)}
            )
            DesignTextField(
                text=stringResource(R.string.app_field_city_hint),
                icon = null,
                value=registrationRequestDataState.city?:"",
                onValueChange = {value->viewModel.registrationRequestData.value=viewModel.registrationRequestData.value.copy(city = value)}
            )
            DesignTextField(
                text=stringResource(R.string.app_field_phone_number_hint),
                icon = null,
                value=registrationRequestDataState.phone?:"",
                onValueChange = {value->viewModel.registrationRequestData.value=viewModel.registrationRequestData.value.copy(phone = value)}
            )

            DesignButton(
                text= stringResource(R.string.app_btn_sign_in),
                onClick = {
                   viewModel.registration(onRegistrationSuccess = {
                       AppViewHelper.openActivity(context,LoginActivity::class.java )
                   })
                },
                modifier = Modifier.fillMaxWidth(  )
            )

            Spacer(modifier = Modifier.weight(1f))
            Text(
                text= stringResource(R.string.app_text_accept_terms),
                color= Color(255,255,255,255),
                fontSize=15.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
            )
        }

    }

}


@Preview(showBackground = true)
@Composable
fun RegistrationPagePreview() {
    val viewModel = AuthViewModel()
    RegistrationPage(viewModel=viewModel)
}