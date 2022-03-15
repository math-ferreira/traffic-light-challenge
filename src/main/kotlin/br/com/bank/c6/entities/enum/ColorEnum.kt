package br.com.bank.c6.entities.enum

import br.com.bank.c6.entities.constants.TrafficLightConstants.ANSI_BACKGROUND_RED_COLOR
import br.com.bank.c6.entities.constants.TrafficLightConstants.ANSI_BACKGROUND_YELLOW_COLOR
import br.com.bank.c6.entities.constants.TrafficLightConstants.ANSI_BACKGROUNG_GREEN_COLOR
import br.com.bank.c6.entities.constants.TrafficLightConstants.ANSI_GREEN_COLOR
import br.com.bank.c6.entities.constants.TrafficLightConstants.ANSI_RED_COLOR
import br.com.bank.c6.entities.constants.TrafficLightConstants.ANSI_YELLOW_COLOR
import br.com.bank.c6.entities.constants.TrafficLightConstants.GREEN_NAME
import br.com.bank.c6.entities.constants.TrafficLightConstants.RED_NAME
import br.com.bank.c6.entities.constants.TrafficLightConstants.YELLOW_NAME

enum class ColorEnum(
    val lightName: String,
    val fontAnsiColor: String,
    val backgroundAnsiColor: String
) {
    
    GREEN(
        lightName = GREEN_NAME,
        fontAnsiColor = ANSI_GREEN_COLOR,
        backgroundAnsiColor = ANSI_BACKGROUNG_GREEN_COLOR
    ),
    YELLOW(
        lightName = YELLOW_NAME,
        fontAnsiColor = ANSI_YELLOW_COLOR,
        backgroundAnsiColor = ANSI_BACKGROUND_YELLOW_COLOR
    ),
    RED(
        lightName = RED_NAME,
        fontAnsiColor = ANSI_RED_COLOR,
        backgroundAnsiColor = ANSI_BACKGROUND_RED_COLOR
    );

}