/*
 * Copyright (C) 2026 Omer Faruk Parlak
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 */
package com.parlaktech.headunit4u.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * Uygulamanin "Neo" renk kumesi. Iki takim var: koyu (varsayilan) ve acik.
 *
 * Renkler dogrudan sabit degil; HeadUnit4uTheme'in sagladigi takimdan okunuyor.
 * Bir ekrandaki yuzlerce `NeoTextPrimary` benzeri kullanim boylece sabit kalirken
 * tema degisince hepsi birden donuyor.
 */
data class HeadUnitRenkleri(
    /** Saydamlik gibi tema-bagimli kararlar icin. */
    val koyuMu: Boolean,
    val backgroundTop: Color,
    val backgroundMid: Color,
    val backgroundBottom: Color,
    val card: Color,
    val cardSoft: Color,
    val cardBorder: Color,
    val primary: Color,
    val primarySoft: Color,
    val pink: Color,
    val orange: Color,
    val green: Color,
    val blue: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val textMuted: Color
)

val KOYU_RENKLER = HeadUnitRenkleri(
    koyuMu = true,
    backgroundTop = Color(0xFF070B1A),
    backgroundMid = Color(0xFF101426),
    backgroundBottom = Color(0xFF19122B),
    card = Color(0xFF171B2F),
    cardSoft = Color(0xFF20243A),
    cardBorder = Color(0xFF343A5A),
    primary = Color(0xFF7C5CFF),
    primarySoft = Color(0xFF9B6CFF),
    pink = Color(0xFFFF5BA8),
    orange = Color(0xFFFF8A3D),
    green = Color(0xFF4ADE80),
    blue = Color(0xFF38BDF8),
    textPrimary = Color(0xFFF7F7FF),
    textSecondary = Color(0xFFB8BCD5),
    textMuted = Color(0xFF7E849F)
)

/**
 * Acik takim koyu takimin aynasi degil: zemin beyazlasinca canlı tonlar
 * (ornegin #4ADE80) yetersiz kontrast veriyordu; bu takim derin tonlara cekildi.
 */
val ACIK_RENKLER = HeadUnitRenkleri(
    koyuMu = false,
    backgroundTop = Color(0xFFF7F8FC),
    backgroundMid = Color(0xFFEEF1F8),
    backgroundBottom = Color(0xFFF3EFFA),
    card = Color(0xFFFFFFFF),
    cardSoft = Color(0xFFF4F6FB),
    cardBorder = Color(0xFFD8DEEC),
    primary = Color(0xFF6D28D9),
    primarySoft = Color(0xFF8B5CF6),
    pink = Color(0xFFDB2777),
    orange = Color(0xFFEA580C),
    green = Color(0xFF16A34A),
    blue = Color(0xFF0284C7),
    textPrimary = Color(0xFF12162A),
    textSecondary = Color(0xFF4A5170),
    textMuted = Color(0xFF7A8199)
)

val LocalHeadUnitRenkleri = compositionLocalOf { KOYU_RENKLER }

// Compose dışından okunan sabit (widget sağlayıcı vb.) — her zaman koyu takim.
val SabitKartCizgisi = KOYU_RENKLER.cardBorder

val NeoBackgroundTop: Color
    @Composable @ReadOnlyComposable get() = LocalHeadUnitRenkleri.current.backgroundTop

val NeoBackgroundMid: Color
    @Composable @ReadOnlyComposable get() = LocalHeadUnitRenkleri.current.backgroundMid

val NeoBackgroundBottom: Color
    @Composable @ReadOnlyComposable get() = LocalHeadUnitRenkleri.current.backgroundBottom

val NeoCard: Color
    @Composable @ReadOnlyComposable get() = LocalHeadUnitRenkleri.current.card

val NeoCardSoft: Color
    @Composable @ReadOnlyComposable get() = LocalHeadUnitRenkleri.current.cardSoft

val NeoCardBorder: Color
    @Composable @ReadOnlyComposable get() = LocalHeadUnitRenkleri.current.cardBorder

val NeoPrimary: Color
    @Composable @ReadOnlyComposable get() = LocalHeadUnitRenkleri.current.primary

val NeoPrimarySoft: Color
    @Composable @ReadOnlyComposable get() = LocalHeadUnitRenkleri.current.primarySoft

val NeoPink: Color
    @Composable @ReadOnlyComposable get() = LocalHeadUnitRenkleri.current.pink

val NeoOrange: Color
    @Composable @ReadOnlyComposable get() = LocalHeadUnitRenkleri.current.orange

val NeoGreen: Color
    @Composable @ReadOnlyComposable get() = LocalHeadUnitRenkleri.current.green

val NeoBlue: Color
    @Composable @ReadOnlyComposable get() = LocalHeadUnitRenkleri.current.blue

val NeoTextPrimary: Color
    @Composable @ReadOnlyComposable get() = LocalHeadUnitRenkleri.current.textPrimary

val NeoTextSecondary: Color
    @Composable @ReadOnlyComposable get() = LocalHeadUnitRenkleri.current.textSecondary

val NeoTextMuted: Color
    @Composable @ReadOnlyComposable get() = LocalHeadUnitRenkleri.current.textMuted
