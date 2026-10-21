/*
 * Copyright (C) 2026 Omer Faruk Parlak
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 */
package com.parlaktech.headunit4u.ui.showcase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.parlaktech.headunit4u.ui.components.DecorativeGlowLayer
import com.parlaktech.headunit4u.ui.components.NeoGlassCard
import com.parlaktech.headunit4u.ui.components.NeoGradientBackground
import com.parlaktech.headunit4u.ui.components.StatusChip
import com.parlaktech.headunit4u.ui.theme.HeadUnit4uTheme
import com.parlaktech.headunit4u.ui.theme.NeoBlue
import com.parlaktech.headunit4u.ui.theme.NeoGreen
import com.parlaktech.headunit4u.ui.theme.NeoOrange
import com.parlaktech.headunit4u.ui.theme.NeoPink
import com.parlaktech.headunit4u.ui.theme.NeoPrimary
import com.parlaktech.headunit4u.ui.theme.NeoTextPrimary
import com.parlaktech.headunit4u.ui.theme.NeoTextSecondary

/**
 * MoodMap stili Compose katmanının canlı önizlemesi. Henüz manifestte yok —
 * build sağlığını doğrulamak ve stili kullanıcıya göstermek için var.
 *
 * Gerçek entegrasyon (MainActivity, SettingsActivity vb. dönüşümleri) adım
 * adım yapılacak; bu ekran o yolun ilk referansıdır.
 */
class HeadUnitShowcaseActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HeadUnit4uTheme {
                ShowcaseScreen()
            }
        }
    }
}

@Composable
private fun ShowcaseScreen() {
    Scaffold(containerColor = Color.Transparent) { innerPadding ->
        NeoGradientBackground {
            DecorativeGlowLayer()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .statusBarsPadding()
                    .navigationBarsPadding()
                    .padding(horizontal = 16.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {
                Spacer(Modifier.height(8.dp))
                Header()
                ConnectionCard()
                QuickActionsCard()
                AboutCard()
                Spacer(Modifier.height(16.dp))
            }
        }
    }
}

@Composable
private fun Header() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "HeadUnit4u",
                style = MaterialTheme.typography.headlineLarge,
                color = NeoTextPrimary,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = "Araç ekranına kablosuz Android Auto",
                style = MaterialTheme.typography.bodyMedium,
                color = NeoTextSecondary
            )
        }
        StatusChip(text = "Hazır", tint = NeoGreen)
    }
}

@Composable
private fun ConnectionCard() {
    NeoGlassCard {
        Text(
            text = "Bağlantı",
            style = MaterialTheme.typography.titleLarge,
            color = NeoTextPrimary,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = "USB, Wi-Fi veya kablosuz (nearby) üzerinden telefonu araç ekranı gibi kullan.",
            style = MaterialTheme.typography.bodyMedium,
            color = NeoTextSecondary
        )
        Spacer(Modifier.height(14.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            StatusChip(text = "USB", tint = NeoBlue)
            StatusChip(text = "Wi-Fi", tint = NeoOrange)
            StatusChip(text = "Kablosuz", tint = NeoPink)
        }
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = { /* TODO: bağlantı akışı */ },
            modifier = Modifier.fillMaxWidth().height(54.dp),
            shape = RoundedCornerShape(22.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = NeoPrimary,
                contentColor = Color.White
            )
        ) {
            Text("Bağlan", fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
private fun QuickActionsCard() {
    NeoGlassCard {
        Text(
            "Hızlı eylemler",
            style = MaterialTheme.typography.titleLarge,
            color = NeoTextPrimary,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(10.dp))
        Text(
            "Projeksiyonu yeniden başlat, gece modunu değiştir, sesi sıfırla.",
            style = MaterialTheme.typography.bodyMedium,
            color = NeoTextSecondary
        )
    }
}

@Composable
private fun AboutCard() {
    NeoGlassCard {
        Text(
            "Hakkında",
            style = MaterialTheme.typography.titleLarge,
            color = NeoTextPrimary,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(10.dp))
        Text(
            "andrerinas/open-headunit (AGPLv3) tabanlı, Michael Reid'in HeadUnit Reviver çalışmasına dayanır.",
            style = MaterialTheme.typography.bodyMedium,
            color = NeoTextSecondary
        )
    }
}

