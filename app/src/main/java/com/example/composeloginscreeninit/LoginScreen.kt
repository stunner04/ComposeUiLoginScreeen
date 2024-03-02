package com.example.composeloginscreeninit

import android.content.res.Configuration
import android.widget.Space
import androidx.compose.material3.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeloginscreeninit.ui.theme.Black
import com.example.composeloginscreeninit.ui.theme.BlueGray
import com.example.composeloginscreeninit.ui.theme.ComposeLoginScreenInitTheme
import com.example.composeloginscreeninit.ui.theme.Roboto

@Composable
fun LoginScreen() {
    Surface {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TopSection()
            Spacer(modifier = Modifier.height(36.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
            ) {
                LoginSection()
                Spacer(modifier = Modifier.height(30.dp))
                SocialMediaSection()
                BottomSection()
            }
        }
    }
}

@Composable
private fun BottomSection() {
    val uiColorTheme = if (isSystemInDarkTheme()) Color.White else Black
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(fraction = 0.8f),
        contentAlignment = Alignment.BottomCenter
    ) {

        val annotatedString = buildAnnotatedString {
            DontHaveAccountText()
            append(" ")
            CreateAccount(uiColorTheme)
        }
        Text(
            text = annotatedString,
        )
    }
}

@Composable
private fun AnnotatedString.Builder.CreateAccount(uiColorTheme: Color) {
    withStyle(
        style = SpanStyle(
            color = uiColorTheme,
            fontSize = 14.sp,
            fontFamily = Roboto,
            fontWeight = FontWeight.Medium
        )
    ) {
        append("Create new account")
    }
}

@Composable
private fun AnnotatedString.Builder.DontHaveAccountText() {
    withStyle(
        style = SpanStyle(
            color = Color(0xFF94A38B),
            fontSize = 14.sp,
            fontFamily = Roboto,
            fontWeight = FontWeight.Normal
        ),

        ) {
        append("Don't have account?")
    }
}

@Composable
private fun SocialMediaSection() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = "Or continue with",
            style = MaterialTheme.typography.labelMedium.copy(color = Color(0xFF64748B))
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SocialMediaLogin(
                icon = R.drawable.google,
                text = "Google",
                modifier = Modifier.weight(1f)
            ) {

            }
            Spacer(modifier = Modifier.width(20.dp))

            SocialMediaLogin(
                icon = R.drawable.facebook,
                text = "Facebook",
                modifier = Modifier.weight(1f)
            ) {

            }
        }
    }
}

@Composable
private fun LoginSection() {
    LoginTextField(
        label = "Email",
        trailing = "",
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(15.dp))
    LoginTextField(
        label = "Password",
        trailing = "Forgot",
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(20.dp))
    ElevatedButton(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSystemInDarkTheme()) BlueGray else Black,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(size = 4.dp),
        elevation = ButtonDefaults.buttonElevation(6.dp)
    ) {
        Text(
            text = "Log in",
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium)
        )
    }
}

@Composable
private fun TopSection() {
    val uiColorTheme = if (isSystemInDarkTheme()) Color.White else Black

    Box(contentAlignment = Alignment.TopCenter) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.46f),
            painter = painterResource(id = R.drawable.shape),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        Row(
            modifier = Modifier.padding(top = 80.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                modifier = Modifier
                    .size(45.dp)
                    .align(Alignment.Top)
                    .padding(top = 1.dp),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = stringResource(id = R.string.app_logo),
                tint = uiColorTheme
            )

            Spacer(modifier = Modifier.width(15.dp))

            Column {
                Text(
                    text = stringResource(id = R.string.the_tolet),
                    style = MaterialTheme.typography.headlineMedium,
                    color = uiColorTheme
                )

                Text(
                    text = stringResource(id = R.string.find_house),
                    style = MaterialTheme.typography.titleMedium,
                    color = uiColorTheme
                )
            }

        }

        Text(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .align(alignment = Alignment.BottomCenter),
            text = stringResource(id = R.string.login),
            style = MaterialTheme.typography.headlineLarge,
            color = uiColorTheme
        )
    }
}


@Preview(
    name = "Login Screen",
    showSystemUi = false,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Composable
fun LoginScreenPreview() {
    ComposeLoginScreenInitTheme {
        LoginScreen()
    }
}