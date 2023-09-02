package com.bleh.resqmeal.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bleh.resqmeal.R
import com.bleh.resqmeal.ui.theme.Black
import com.bleh.resqmeal.ui.theme.Orange
import com.bleh.resqmeal.viewmodels.ForgotViewModel
import com.bleh.resqmeal.viewmodels.LoginViewModel
import com.bleh.resqmeal.viewmodels.RegisterViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(
    navController: NavController
) {
    val viewModel = viewModel<LoginViewModel>()
    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()
    val passwordVisible by viewModel.passwordVisible.collectAsState()

    Image(
        modifier = Modifier
            .fillMaxWidth(),
        painter = painterResource(id = R.drawable.onboarding_background),
        contentDescription = "splash",
        contentScale = ContentScale.Crop
    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .padding(top = 40.dp),
            painter = painterResource(id = R.drawable.ic_resqmeal),
            contentDescription = "logo"
        )


        Text(
            text = "Selamat Datang",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(vertical = 10.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .padding(top = 10.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    )
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                singleLine = true,
                textStyle = MaterialTheme.typography.bodySmall,
                label = {
                    Text(
                        text = "Email",
                        style = MaterialTheme.typography.bodySmall,
                        color = Orange
                    )
                },
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Orange,
                    containerColor = Color.White,
                    focusedIndicatorColor = Orange,
                    ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                value = email,
                onValueChange = {
                    viewModel.setEmail(it)
                }
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(top = 10.dp)
        ) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .padding(top = 10.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    )
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                singleLine = true,
                textStyle = MaterialTheme.typography.bodySmall,
                label = {
                    Text(
                        text = "Kata Sandi",
                        style = MaterialTheme.typography.bodySmall,
                        color = Orange
                    )
                },
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Orange,
                    containerColor = Color.White,
                    focusedIndicatorColor = Orange,
                    ),
                visualTransformation = if (passwordVisible) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (passwordVisible) {
                        R.drawable.ic_hide_pass
                    } else {
                        R.drawable.ic_show_pass
                    }

                    IconButton(
                        onClick = {
                            viewModel.setPasswordVisible(!passwordVisible)
                        }
                    ){
                        Icon(
                            painter = painterResource(id = image),
                            contentDescription = "password visibility"
                        )
                    }
                },
                value = password,
                onValueChange = {
                    viewModel.setPassword(it)
                }
            )
        }

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                modifier = Modifier
                    .clickable {
                        navController.navigate("forgot")
                    },
                text = "Lupa kata sandi?",
                style = MaterialTheme.typography.bodySmall,
                textDecoration = TextDecoration.Underline
            )
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(top = 30.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Orange,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp),
            onClick = {
                navController.navigate("home") {
                    popUpTo("auth") {
                        inclusive = true
                    }
                }
            }
        ) {
            Text(
                text = "Masuk",
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(top = 40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Divider(
                modifier = Modifier
                    .weight(1f),
                thickness = 1.dp,
                color = Color.Black
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .weight(0.7f),
                text = "atau",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodySmall
            )
            Divider(
                modifier = Modifier
                    .weight(1f),
                thickness = 1.dp,
                color = Color.Black
            )
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(top = 40.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Black,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp),
            onClick = {
                navController.navigate("home") {

                }
            }
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .padding(end = 20.dp),
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = "Google Logo",
                )
                Text(
                    modifier = Modifier
                        .padding(top = 3.dp),
                    text = "Masuk dengan Google",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (row) = createRefs()

        Row (
            modifier = Modifier
                .constrainAs(row) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(bottom = 50.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Belum memiliki akun?",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                modifier = Modifier
                    .clickable {
                        navController.navigate("register")
                    },
                text = " Daftar disini",
                style = MaterialTheme.typography.bodySmall,
                color = Orange,
                textDecoration = TextDecoration.Underline
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterPage(
    navController: NavController
) {
    val viewModel = viewModel<RegisterViewModel>()
    val name by viewModel.name.collectAsState()
    val phone by viewModel.phone.collectAsState()
    val email by viewModel.email.collectAsState()
    val password1 by viewModel.password1.collectAsState()
    val passwordVisible1 by viewModel.passwordVisible1.collectAsState()
    val password2 by viewModel.password2.collectAsState()
    val passwordVisible2 by viewModel.passwordVisible2.collectAsState()

    Image(
        modifier = Modifier
            .fillMaxWidth(),
        painter = painterResource(id = R.drawable.onboarding_background),
        contentDescription = "splash",
        contentScale = ContentScale.Crop
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .padding(top = 40.dp),
            painter = painterResource(id = R.drawable.ic_resqmeal),
            contentDescription = "logo"
        )

        Text(
            text = "Daftar",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(vertical = 10.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .padding(top = 10.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    )
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                singleLine = true,
                textStyle = MaterialTheme.typography.bodySmall,
                label = {
                    Text(
                        text = "Nama Lengkap",
                        style = MaterialTheme.typography.bodySmall,
                        color = Orange
                    )
                },
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Orange,
                    containerColor = Color.White,
                    focusedIndicatorColor = Orange,
                ),
                value = name,
                onValueChange = {
                    viewModel.setName(it)
                }
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(top = 10.dp)
        ) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .padding(top = 10.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    )
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                singleLine = true,
                textStyle = MaterialTheme.typography.bodySmall,
                label = {
                    Text(
                        text = "Nomor Telepon",
                        style = MaterialTheme.typography.bodySmall,
                        color = Orange
                    )
                },
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Orange,
                    containerColor = Color.White,
                    focusedIndicatorColor = Orange,
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                value = phone,
                onValueChange = {
                    viewModel.setPhone(it)
                }
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(top = 10.dp)
        ) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .padding(top = 10.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    )
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                singleLine = true,
                textStyle = MaterialTheme.typography.bodySmall,
                label = {
                    Text(
                        text = "Email",
                        style = MaterialTheme.typography.bodySmall,
                        color = Orange
                    )
                },
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Orange,
                    containerColor = Color.White,
                    focusedIndicatorColor = Orange,
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                value = email,
                onValueChange = {
                    viewModel.setEmail(it)
                }
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(top = 10.dp)
        ) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .padding(top = 10.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    )
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                singleLine = true,
                textStyle = MaterialTheme.typography.bodySmall,
                label = {
                    Text(
                        text = "Kata Sandi Baru",
                        style = MaterialTheme.typography.bodySmall,
                        color = Orange
                    )
                },
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Orange,
                    containerColor = Color.White,
                    focusedIndicatorColor = Orange,
                ),
                visualTransformation = if (passwordVisible1) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (passwordVisible1) {
                        R.drawable.ic_hide_pass
                    } else {
                        R.drawable.ic_show_pass
                    }

                    IconButton(
                        onClick = {
                            viewModel.setPasswordVisible1(!passwordVisible1)
                        }
                    ){
                        Icon(
                            painter = painterResource(id = image),
                            contentDescription = "password visibility"
                        )
                    }
                },
                value = password1,
                onValueChange = {
                    viewModel.setPassword1(it)
                }
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(top = 10.dp)
        ) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .padding(top = 10.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    )
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                singleLine = true,
                textStyle = MaterialTheme.typography.bodySmall,
                label = {
                    Text(
                        text = "Ulangi Kata Sandi Baru",
                        style = MaterialTheme.typography.bodySmall,
                        color = Orange
                    )
                },
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Orange,
                    containerColor = Color.White,
                    focusedIndicatorColor = Orange,
                ),
                visualTransformation = if (passwordVisible2) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (passwordVisible2) {
                        R.drawable.ic_hide_pass
                    } else {
                        R.drawable.ic_show_pass
                    }

                    IconButton(
                        onClick = {
                            viewModel.setPasswordVisible1(!passwordVisible2)
                        }
                    ){
                        Icon(
                            painter = painterResource(id = image),
                            contentDescription = "password visibility"
                        )
                    }
                },
                value = password2,
                onValueChange = {
                    viewModel.setPassword2(it)
                }
            )
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(top = 30.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Orange,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp),
            onClick = {
                navController.navigate("login")
            }
        ) {
            Text(
                text = "Konfirmasi",
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(top = 40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Divider(
                modifier = Modifier
                    .weight(1f),
                thickness = 1.dp,
                color = Color.Black
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .weight(0.7f),
                text = "atau",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodySmall
            )
            Divider(
                modifier = Modifier
                    .weight(1f),
                thickness = 1.dp,
                color = Color.Black
            )
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(vertical = 40.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Black,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp),
            onClick = {

            }
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .padding(end = 20.dp),
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = "Google Logo",
                )
                Text(
                    modifier = Modifier
                        .padding(top = 3.dp),
                    text = "Masuk dengan Google",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPage(
    navController: NavController
) {
    val viewModel = viewModel<ForgotViewModel>()
    val email by viewModel.email.collectAsState()
    val password1 by viewModel.password1.collectAsState()
    val passwordVisible1 by viewModel.passwordVisible1.collectAsState()
    val password2 by viewModel.password2.collectAsState()
    val passwordVisible2 by viewModel.passwordVisible2.collectAsState()

    Image(
        modifier = Modifier
            .fillMaxWidth(),
        painter = painterResource(id = R.drawable.onboarding_background),
        contentDescription = "splash",
        contentScale = ContentScale.Crop
    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .padding(top = 40.dp),
            painter = painterResource(id = R.drawable.ic_resqmeal),
            contentDescription = "logo"
        )


        Text(
            text = "Silahkan Masukkan Kata Sandi Baru",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(vertical = 10.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .padding(top = 10.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    )
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                singleLine = true,
                textStyle = MaterialTheme.typography.bodySmall,
                label = {
                    Text(
                        text = "Email",
                        style = MaterialTheme.typography.bodySmall,
                        color = Orange
                    )
                },
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Orange,
                    containerColor = Color.White,
                    focusedIndicatorColor = Orange,
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                value = email,
                onValueChange = {
                    viewModel.setEmail(it)
                }
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(top = 10.dp)
        ) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .padding(top = 10.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    )
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                singleLine = true,
                textStyle = MaterialTheme.typography.bodySmall,
                label = {
                    Text(
                        text = "Kata Sandi Baru",
                        style = MaterialTheme.typography.bodySmall,
                        color = Orange
                    )
                },
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Orange,
                    containerColor = Color.White,
                    focusedIndicatorColor = Orange,
                ),
                visualTransformation = if (passwordVisible1) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (passwordVisible1) {
                        R.drawable.ic_hide_pass
                    } else {
                        R.drawable.ic_show_pass
                    }

                    IconButton(
                        onClick = {
                            viewModel.setPasswordVisible1(!passwordVisible1)
                        }
                    ){
                        Icon(
                            painter = painterResource(id = image),
                            contentDescription = "password visibility"
                        )
                    }
                },
                value = password1,
                onValueChange = {
                    viewModel.setPassword1(it)
                }
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(top = 10.dp)
        ) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .padding(top = 10.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    )
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                singleLine = true,
                textStyle = MaterialTheme.typography.bodySmall,
                label = {
                    Text(
                        text = "Ulangi Kata Sandi Baru",
                        style = MaterialTheme.typography.bodySmall,
                        color = Orange
                    )
                },
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Orange,
                    containerColor = Color.White,
                    focusedIndicatorColor = Orange,
                ),
                visualTransformation = if (passwordVisible2) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (passwordVisible2) {
                        R.drawable.ic_hide_pass
                    } else {
                        R.drawable.ic_show_pass
                    }

                    IconButton(
                        onClick = {
                            viewModel.setPasswordVisible1(!passwordVisible2)
                        }
                    ){
                        Icon(
                            painter = painterResource(id = image),
                            contentDescription = "password visibility"
                        )
                    }
                },
                value = password2,
                onValueChange = {
                    viewModel.setPassword2(it)
                }
            )
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(top = 30.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Orange,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp),
            onClick = {
                navController.navigate("login")
            }
        ) {
            Text(
                text = "Konfirmasi",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}