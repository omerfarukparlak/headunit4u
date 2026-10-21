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
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.parlaktech.headunit4u.ui.theme.NeoCard
import com.parlaktech.headunit4u.ui.theme.NeoCardBorder
import com.parlaktech.headunit4u.ui.theme.NeoCardSoft

/**
 * Neo stili cam efektli kart: yarı saydam yüzey, gradient kenarlık,
 * dikey gradient iç dolgu, yumuşak gölge. HeadUnit4u'nun ana kart tipi.
 */
@Composable
fun NeoGlassCard(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(28.dp),
        color = NeoCard.copy(alpha = 0.82f),
        border = BorderStroke(
            width = 1.dp,
            brush = Brush.linearGradient(
                colors = listOf(
                    NeoCardBorder.copy(alpha = 0.9f),
                    NeoCardSoft.copy(alpha = 0.35f)
                )
            )
        ),
        tonalElevation = 0.dp,
        shadowElevation = 10.dp
    ) {
        Column(
            modifier = Modifier
                .background(
                    Brush.verticalGradient(
                        listOf(
                            NeoCardSoft.copy(alpha = 0.46f),
                            NeoCard.copy(alpha = 0.92f)
                        )
                    )
                )
                .padding(18.dp),
            content = content
        )
    }
}
