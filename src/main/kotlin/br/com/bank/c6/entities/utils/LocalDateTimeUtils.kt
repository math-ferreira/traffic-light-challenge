package br.com.bank.c6.entities.utils

import java.time.LocalTime
import java.time.format.DateTimeFormatter

fun getLocalTimeNow() = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))