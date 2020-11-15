package com.android.shawnclisby.androidauth.utils

import java.text.DateFormat
import java.util.*

fun Long.convertStampToMediumDate(): String =
    DateFormat.getDateInstance(DateFormat.MEDIUM).format(Date(this))