/*
 * Copyright (C) 2026 Omer Faruk Parlak
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 */
package com.parlaktech.headunit4u.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

private val DarkColorScheme = darkColorScheme(
    primary = KOYU_RENKLER.primary,
    secondary = KOYU_RENKLER.primarySoft,
    tertiary = KOYU_RENKLER.pink,
    background = KOYU_RENKLER.backgroundMid,
    surface = KOYU_RENKLER.card,
    onPrimary = KOYU_RENKLER.textPrimary,
    onSecondary = KOYU_RENKLER.textPrimary,
    onTertiary = KOYU_RENKLER.textPrimary,
    onBackground = KOYU_RENKLER.textPrimary,
    onSurface = KOYU_RENKLER.textPrimary,
    onSurfaceVariant = KOYU_RENKLER.textSecondary,
    primaryContainer = KOYU_RENKLER.primary.copy(alpha = 0.25f)
)

private val LightColorScheme = lightColorScheme(
    primary = ACIK_RENKLER.primary,
    secondary = ACIK_RENKLER.primarySoft,
    tertiary = ACIK_RENKLER.pink,
    background = ACIK_RENKLER.backgroundMid,
    surface = ACIK_RENKLER.card,
    onPrimary = ACIK_RENKLER.card,
    onSecondary = ACIK_RENKLER.card,
    onTertiary = ACIK_RENKLER.card,
    onBackground = ACIK_RENKLER.textPrimary,
    onSurface = ACIK_RENKLER.textPrimary,
    onSurfaceVariant = ACIK_RENKLER.textSecondary,
    primaryContainer = ACIK_RENKLER.primary.copy(alpha = 0.14f)
)

@Composable
fun HeadUnit4uTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val renkler = if (darkTheme) KOYU_RENKLER else ACIK_RENKLER
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    CompositionLocalProvider(LocalHeadUnitRenkleri provides renkler) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = AppTypography,
            content = content
        )
    }
}
