package com.eyehail.profilecardlayout.ui.theme

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    //changing medium from RoundedCornerShape(4.dp) to CutCornerShape(topRight = 24.dp)
    medium = CutCornerShape(topEnd = 24.dp),
    large = RoundedCornerShape(0.dp)
)