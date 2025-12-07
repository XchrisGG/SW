package com.example.appstresswatch.ui.theme

import androidx.compose.ui.graphics.Color
// Paleta base (ajústala si cambian los hex de Figma)
val StressDarkBlue   = Color(0xFF011E3D) // fondo principal
val StressMint       = Color(0xFF60B9A1) // acciones primarias
val StressWhite      = Color(0xFFFFFFFF) // texto sobre fondo oscuro
val StressBlack      = Color(0xFF0F172A) // texto oscuro sobre superficies claras
val StressGrayLight  = Color(0xFFF5F5F5) // superficies claras
val StressGray       = Color(0xFFFFFDD0) // texto secundario
val StressError      = Color(0xFFB3261E)

// Derivados para Material3 (puedes afinarlos con Figma)
val Primary             = StressDarkBlue
val OnPrimaryLight      = StressWhite
val OnPrimaryDark       = StressWhite

val PrimaryContainer    = Color(0xFFAEE4D6)
val OnPrimaryContainer  = StressBlack

val Secondary           = Color(0xFF68A0E3)      // si usas un acento secundario
val OnSecondary         = StressWhite
val SecondaryContainer  = Color(0xFFD7E9FD)
val OnSecondaryContainer= StressBlack

val Tertiary            = Color(0xFF3CBCC3)
val OnTertiary          = StressWhite
val TertiaryContainer   = Color(0xFFCDEFF1)
val OnTertiaryContainer = StressBlack

val BackgroundLight     = StressGrayLight
val OnBackgroundLight   = StressBlack
val SurfaceLight        = Color(0xFFFFFFFF)
val OnSurfaceLight      = StressBlack

val BackgroundDark      = StressDarkBlue
val OnBackgroundDark    = StressWhite
val SurfaceDark         = Color(0xFF0B1A30)
val OnSurfaceDark       = StressWhite