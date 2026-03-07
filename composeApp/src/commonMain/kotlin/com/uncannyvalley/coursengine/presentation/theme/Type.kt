package com.uncannyvalley.coursengine.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import courseengine.composeapp.generated.resources.Res
import courseengine.composeapp.generated.resources.inter_semi_bold
import courseengine.composeapp.generated.resources.roboto_mono_light
import courseengine.composeapp.generated.resources.roboto_mono_medium
import org.jetbrains.compose.resources.Font

@Composable
fun typography(): Typography {

    val robotoMono = FontFamily(
        Font(Res.font.roboto_mono_medium, FontWeight.Medium),
        Font(Res.font.roboto_mono_light, FontWeight.Light)
    )

    val inter = FontFamily(
        Font(Res.font.inter_semi_bold, FontWeight.SemiBold)
    )

    return Typography(
        bodyMedium = TextStyle(
            fontFamily = robotoMono,
            fontWeight = FontWeight.Light,
            fontSize = 18.sp,
            letterSpacing = 0.sp
        ),

        titleMedium = TextStyle(
            fontFamily = robotoMono,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            letterSpacing = 0.sp
        ),

        titleLarge = TextStyle(
            fontFamily = robotoMono,
            fontWeight = FontWeight.Medium,
            fontSize = 24.sp,
            letterSpacing = 0.sp
        ),

        labelMedium = TextStyle(
            fontFamily = inter,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            letterSpacing = 0.sp
        ),
    )

}