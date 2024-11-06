package com.example.ucp1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun PlayAct(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {
        HeaderSection()

        var nama by remember { mutableStateOf("") }
        var noTelpon by remember { mutableStateOf("") }
        var memilihJk by remember { mutableStateOf("") }

        var namasv by remember { mutableStateOf("") }
        var noTelponsv by remember { mutableStateOf("") }
        var memilihJksv by remember { mutableStateOf("") }

        val listJk = listOf("Laki-laki", "Perempuan")

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Yuk Lengkapi data dirimu !",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)

            Spacer(Modifier.padding(12.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                value = nama,
                onValueChange = { nama = it },
                label = { Text("Nama") },
                placeholder = { Text("Masukkan Nama Anda") }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                value = noTelpon,
                onValueChange = { noTelpon = it },
                label = { Text("No Telp") },
                placeholder = { Text("Masukkan No Telpon Anda") }
            )

            Text(
                "Jenis Kelamin",
                fontSize = 15.sp)

            Row {
                listJk.forEach { item ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = memilihJk == item,
                            onClick = {
                                memilihJk = item
                            }
                        )
                        Text(item)
                    }
                }
            }

            Button(onClick = {
                namasv = nama
                noTelponsv = noTelpon
                memilihJksv = memilihJk
            }, ) {
                Text("Simpan")
            }
            ElevatedCard(
                colors = CardDefaults.cardColors(containerColor = Color.LightGray),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
            ) {
                DetailForm(judul = "NoTelpon", isinya = noTelponsv)
                DetailForm(judul = "Jenis Kelamin", isinya = memilihJksv)

            }
        }
    }
}

@Composable
fun HeaderSection(){
    Box (modifier = Modifier
        .background(color = Color.Blue)
        .padding(15.dp))
    {
        Row (modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween){
            Column {
                Icon(imageVector = Icons.Filled.Menu,
                    contentDescription = "")



                Spacer(Modifier.padding(12.dp))

                Text(text = "Halo,",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White)

            }
            Box(
                contentAlignment = Alignment.BottomStart
            ){
                Image(
                    painter = painterResource(id = R.drawable.spongebob),
                    contentDescription = "",
                    modifier = Modifier.size(100.dp)
                    .clip(RoundedCornerShape(100.dp)
                ))
            }
        }
    }
}

@Composable
fun DetailForm(
    judul:String,isinya:String
){
    Column (modifier = Modifier.fillMaxWidth().padding(16.dp),
    ){

    }

    Row (
        modifier = Modifier.fillMaxWidth().padding(top = 2.dp)
    ){
        Text(text = judul,
            modifier = Modifier.weight(0.8f))
        Text(text = ":",
            modifier = Modifier.weight(0.2f))
        Text(text = isinya,
            modifier = Modifier.weight(2f))}
}