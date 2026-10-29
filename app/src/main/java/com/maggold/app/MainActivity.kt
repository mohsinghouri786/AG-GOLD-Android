package com.maggold.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MAGGoldApp() }
    }
}

@Composable
fun MAGGoldApp() {
    var apiKey by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("WAITING FOR MARKET DATA") }
    val bg = Color(0xFF090D14)
    val card = Color(0xFF111827)
    val gold = Color(0xFFFFC857)

    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize().background(bg).padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Spacer(Modifier.height(8.dp))
            Text("MAG GOLD", color = gold, fontSize = 30.sp, fontWeight = FontWeight.Black)
            Text("XAU/USD INTELLIGENCE ENGINE", color = Color.LightGray, fontSize = 12.sp)

            Card(colors = CardDefaults.cardColors(containerColor = card), shape = RoundedCornerShape(16.dp)) {
                Column(Modifier.fillMaxWidth().padding(18.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("MASTER SIGNAL", color = Color.Gray, fontSize = 12.sp)
                    Text(status, color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text("Multi-timeframe confirmation • M1 / M5 / M15 / H1", color = Color.LightGray, fontSize = 12.sp)
                }
            }

            Card(colors = CardDefaults.cardColors(containerColor = card), shape = RoundedCornerShape(16.dp)) {
                Column(Modifier.fillMaxWidth().padding(18.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text("MARKET ENGINE", color = gold, fontWeight = FontWeight.Bold)
                    Text("EMA 9/21 • RSI • ATR • Structure • BOS/CHOCH • Divergence • Volume anomaly • Sweep/Reclaim • Order Block/FVG scoring", color = Color.White, fontSize = 13.sp)
                }
            }

            Card(colors = CardDefaults.cardColors(containerColor = card), shape = RoundedCornerShape(16.dp)) {
                Column(Modifier.fillMaxWidth().padding(18.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text("DATA SETTINGS", color = gold, fontWeight = FontWeight.Bold)
                    OutlinedTextField(value = apiKey, onValueChange = { apiKey = it }, label = { Text("Twelve Data API Key") }, modifier = Modifier.fillMaxWidth(), singleLine = true)
                    Button(onClick = { status = if (apiKey.isBlank()) "ENTER API KEY" else "FEED CONFIGURED — SCAN READY" }, modifier = Modifier.fillMaxWidth()) {
                        Text("SAVE & TEST FEED")
                    }
                }
            }

            Card(colors = CardDefaults.cardColors(containerColor = card), shape = RoundedCornerShape(16.dp)) {
                Column(Modifier.fillMaxWidth().padding(18.dp)) {
                    Text("TRADE PLAN", color = gold, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(8.dp))
                    Text("Entry: —     SL: —", color = Color.White)
                    Text("TP1: —     TP2: —     TP3: —", color = Color.White)
                    Text("Confidence: —     Grade: —", color = Color.LightGray)
                }
            }

            Spacer(Modifier.weight(1f))
            Text("Analytical tool only — validate signals and manage risk.", color = Color.Gray, fontSize = 11.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
        }
    }
}
