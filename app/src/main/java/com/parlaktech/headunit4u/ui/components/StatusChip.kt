/*
 * Copyright (C) 2026 Omer Faruk Parlak
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 */
package com.parlaktech.headunit4u.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.parlaktech.headunit4u.ui.theme.NeoTextPrimary

/**
 * HeadUnit4u'nun bağlantı/durum rozeti. MoodMap'in streak rozetinin eşdeğeri.
 *
 * `tint` hem dolgu (alpha 0.22) hem de kenarlık (alpha 0.65) rengini sağlar;
 * duruma göre `NeoGreen` (bağlı), `NeoOrange` (bekliyor), `NeoPink` (hata) vb.
 */
@Composable
fun StatusChip(
    text: String,
    tint: Color,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(999.dp),
        color = tint.copy(alpha = 0.22f),
        border = BorderStroke(1.dp, tint.copy(alpha = 0.65f))
    ) {
        Box(modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)) {
            Text(
                text = text,
                color = NeoTextPrimary,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}
