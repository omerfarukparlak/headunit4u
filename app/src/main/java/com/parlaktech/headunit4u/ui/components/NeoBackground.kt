/*
 * Copyright (C) 2026 Omer Faruk Parlak
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 */
package com.parlaktech.headunit4u.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.parlaktech.headunit4u.ui.theme.NeoBackgroundBottom
import com.parlaktech.headunit4u.ui.theme.NeoBackgroundMid
import com.parlaktech.headunit4u.ui.theme.NeoBackgroundTop
import com.parlaktech.headunit4u.ui.theme.NeoPink
import com.parlaktech.headunit4u.ui.theme.NeoPrimary

/**
 * Her Compose ekranının altında yatan 3-stop dikey gradient zemin.
 * Normalde `DecorativeGlowLayer` ile birlikte kullanılır.
 */
@Composable
fun NeoGradientBackground(
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        NeoBackgroundTop,
                        NeoBackgroundMid,
                        NeoBackgroundBottom
                    )
                )
            ),
        content = content
    )
}

/**
 * Dekoratif atmosfer katmanı: iki büyük bulanık renk topu. İçeriğin arkasına,
 * `NeoGradientBackground` ile ekran içeriği arasına yerleştirin.
 */
@Composable
fun DecorativeGlowLayer() {
    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .size(240.dp)
                .align(Alignment.TopEnd)
                .padding(top = 40.dp)
                .background(NeoPrimary.copy(alpha = 0.22f), CircleShape)
                .blur(80.dp)
        )
        Box(
            modifier = Modifier
                .size(260.dp)
                .align(Alignment.BottomStart)
                .background(NeoPink.copy(alpha = 0.18f), CircleShape)
                .blur(90.dp)
        )
    }
}
