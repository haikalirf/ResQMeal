package com.bleh.resqmeal.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuBoxScope
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bleh.resqmeal.R
import com.bleh.resqmeal.ui.theme.DarkGrey
import com.bleh.resqmeal.ui.theme.Grey
import com.bleh.resqmeal.ui.theme.Orange
import com.bleh.resqmeal.viewmodels.AddViewModel
import com.bleh.resqmeal.viewmodels.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPage(
    navController: NavController
) {
    var isExpanded by remember {
        mutableStateOf(false)
    }

    val units = listOf("gram", "kg", "ml", "liter")
    var unit by remember {
        mutableStateOf("gram")
    }

    val viewModel = viewModel<AddViewModel>()
    val namaProduk by viewModel.namaProduk.collectAsState()
    val deskripsi by viewModel.deskripsi.collectAsState()
    val tanggalProduksi by viewModel.tanggalProduksi.collectAsState()
    val tanggalKadaluarsa by viewModel.tanggalKadaluarsa.collectAsState()
    val jumlah by viewModel.jumlah.collectAsState()
    val berat by viewModel.berat.collectAsState()
    val satuan by viewModel.satuan.collectAsState()
    val komposisi by viewModel.komposisi.collectAsState()
    val alamat by viewModel.alamat.collectAsState()
    val waktuPengambilan by viewModel.waktu.collectAsState()
    val kontak by viewModel.kontak.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Unggah Makanan",
            style = MaterialTheme.typography.titleMedium,
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .height(110.dp)
                    .width(110.dp)
                    .clip(RoundedCornerShape(10.dp))
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize(),
                    painter = painterResource(id = R.drawable.baguette),
                    contentDescription = "baguette1",
                    contentScale = ContentScale.Crop
                )
            }

            Box(
                modifier = Modifier
                    .height(110.dp)
                    .width(110.dp)
                    .clip(RoundedCornerShape(10.dp))
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize(),
                    painter = painterResource(id = R.drawable.baguette2),
                    contentDescription = "baguette1",
                    contentScale = ContentScale.Crop
                )
            }

            Box(
                modifier = Modifier
                    .height(110.dp)
                    .width(110.dp)
                    .clip(RoundedCornerShape(10.dp))
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize(),
                    painter = painterResource(id = R.drawable.ic_upload),
                    contentDescription = "baguette1",
                    contentScale = ContentScale.Crop
                )
            }
        }
        
        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = "Nama Produk",
            style = MaterialTheme.typography.titleSmall,
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            singleLine = true,
            textStyle = MaterialTheme.typography.bodySmall,
            placeholder = {
                Text(
                    text = "Isi nama makanan/minuman mu",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF96979C)
                )
            },
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = Orange,
                containerColor = Color(0xFFFAFAFA),
                focusedIndicatorColor = Orange,
            ),
            value = namaProduk,
            onValueChange = {
                viewModel.setNamaProduk(it)
            }
        )

        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = "Deskripsi",
            style = MaterialTheme.typography.titleSmall,
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            textStyle = MaterialTheme.typography.bodySmall,
            placeholder = {
                Text(
                    text = "Keterangan singkat tentang makanan atau minumanmu",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF96979C)
                )
            },
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = Orange,
                containerColor = Color(0xFFFAFAFA),
                focusedIndicatorColor = Orange,
            ),
            value = deskripsi,
            onValueChange = {
                viewModel.setDeskripsi(it)
            }
        )

        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = "Tanggal Produksi",
            style = MaterialTheme.typography.titleSmall,
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            singleLine = true,
            textStyle = MaterialTheme.typography.bodySmall,
            placeholder = {
                Text(
                    text = "DD/MM/YYYY",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF96979C)
                )
            },
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = Orange,
                containerColor = Color(0xFFFAFAFA),
                focusedIndicatorColor = Orange,
            ),
            value = tanggalProduksi,
            onValueChange = {
                viewModel.setTanggalProduksi(it)
            }
        )

        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = "Tanggal Kadaluarsa",
            style = MaterialTheme.typography.titleSmall,
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            singleLine = true,
            textStyle = MaterialTheme.typography.bodySmall,
            placeholder = {
                Text(
                    text = "DD/MM/YYYY",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF96979C)
                )
            },
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = Orange,
                containerColor = Color(0xFFFAFAFA),
                focusedIndicatorColor = Orange,
            ),
            value = tanggalKadaluarsa,
            onValueChange = {
                viewModel.setTanggalKadaluarsa(it)
            }
        )

        Row(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .width(120.dp),
                singleLine = true,
                textStyle = MaterialTheme.typography.bodySmall.copy(textAlign = TextAlign.Center),
                placeholder = {
                    Text(
                        modifier = Modifier
                            .fillMaxSize(),
                        text = "1 Buah",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFF96979C),
                        textAlign = TextAlign.Center
                    )
                },
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Orange,
                    containerColor = Color(0xFFFAFAFA),
                    focusedIndicatorColor = Orange,
                ),
                value = jumlah,
                onValueChange = {
                    viewModel.setJumlah(it)
                }
            )

            OutlinedTextField(
                modifier = Modifier
                    .width(120.dp),
                singleLine = true,
                textStyle = MaterialTheme.typography.bodySmall.copy(textAlign = TextAlign.Center),
                placeholder = {
                    Text(
                        modifier = Modifier
                            .fillMaxSize(),
                        text = "0",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFF96979C),
                        textAlign = TextAlign.Center
                    )
                },
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Orange,
                    containerColor = Color(0xFFFAFAFA),
                    focusedIndicatorColor = Orange,
                ),
                value = berat,
                onValueChange = {
                    viewModel.setBerat(it)
                }
            )

            ExposedDropdownMenuBox(
                expanded = isExpanded,
                onExpandedChange =  {
                    isExpanded = it
                },
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .width(120.dp)
                        .menuAnchor(),
                    readOnly = true,
                    textStyle = MaterialTheme.typography.bodySmall.copy(textAlign = TextAlign.Center),
                    shape = RoundedCornerShape(10.dp),
                    colors = ExposedDropdownMenuDefaults.textFieldColors(
                        cursorColor = Orange,
                        containerColor = Color(0xFFFAFAFA),
                        focusedIndicatorColor = Orange,
                        disabledIndicatorColor = Color(0xFFb3b6b7),
                        disabledTextColor = Color(0xFFb3b6b7),
                        disabledTrailingIconColor = Color(0xFFb3b6b7),
                        disabledPlaceholderColor = Color(0xFFb3b6b7),
                    ),
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(
                            expanded = isExpanded
                        )
                    },
                    placeholder = {
                        Text(
                            modifier = Modifier
                                .fillMaxSize(),
                            text = "satuan",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color(0xFF96979C),
                            textAlign = TextAlign.Center
                        )
                    },
                    value = unit,
                    onValueChange = {},
                    enabled = false
                )

                ExposedDropdownMenu(
                    expanded = isExpanded,
                    onDismissRequest = { isExpanded = false },
                ) {
                    units.forEach {
                        DropdownMenuItem(
                            text = { Text(text = it) },
                            onClick = {
                                unit = it
                                isExpanded = false
                            }
                        )
                    }
                }
            }
        }

        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = "Komposisi",
            style = MaterialTheme.typography.titleSmall,
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            textStyle = MaterialTheme.typography.bodySmall,
            placeholder = {
                Text(
                    text = "Isi dari makanan atau minumanmu",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF96979C)
                )
            },
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = Orange,
                containerColor = Color(0xFFFAFAFA),
                focusedIndicatorColor = Orange,
            ),
            value = komposisi,
            onValueChange = {
                viewModel.setKomposisi(it)
            }
        )

        Text(
            modifier = Modifier.padding(top = 15.dp),
            text = "Lokasi",
            style = MaterialTheme.typography.titleSmall,
        )

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            painter = painterResource(id = R.drawable.map),
            contentDescription = "lokasi",
        )

        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = "Alamat",
            style = MaterialTheme.typography.titleSmall,
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            singleLine = true,
            textStyle = MaterialTheme.typography.bodySmall,
            placeholder = {
                Text(
                    text = "Masukkan alamat mu",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF96979C)
                )
            },
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = Orange,
                containerColor = Color(0xFFFAFAFA),
                focusedIndicatorColor = Orange,
            ),
            value = alamat,
            onValueChange = {
                viewModel.setAlamat(it)
            }
        )

        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = "Waktu Pengambilan",
            style = MaterialTheme.typography.titleSmall,
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            singleLine = true,
            textStyle = MaterialTheme.typography.bodySmall,
            placeholder = {
                Text(
                    text = "DD/MM/YYYY, 00.00",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF96979C)
                )
            },
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = Orange,
                containerColor = Color(0xFFFAFAFA),
                focusedIndicatorColor = Orange,
            ),
            value = waktuPengambilan,
            onValueChange = {
                viewModel.setWaktu(it)
            }
        )

        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = "Kontak",
            style = MaterialTheme.typography.titleSmall,
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            singleLine = true,
            textStyle = MaterialTheme.typography.bodySmall,
            placeholder = {
                Text(
                    text = "Kontak yang dapat dihubungi",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF96979C)
                )
            },
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = Orange,
                containerColor = Color(0xFFFAFAFA),
                focusedIndicatorColor = Orange,
            ),
            value = kontak,
            onValueChange = {
                viewModel.setKontak(it)
            }
        )


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
                text = "Unggah",
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(modifier = Modifier.height(30.dp))
    }
}