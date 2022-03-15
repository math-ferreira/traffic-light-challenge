package br.com.bank.c6.entities.dto

import br.com.bank.c6.entities.constants.TrafficLightConstants.ANSI_RESET_COLOR
import br.com.bank.c6.entities.enum.ColorEnum
import br.com.bank.c6.entities.enum.TrafficLightEnum
import br.com.bank.c6.entities.utils.getLocalTimeNow

data class StreetTrafficDTO(
    val streetName: String,
    val trafficLightEnum: TrafficLightEnum = TrafficLightEnum.GREEN
) {

    fun displaysCurrentColor() {
        if (this.trafficLightEnum.color == ColorEnum.GREEN) {
            println("-----------------------------")
        }

        val currentFontColor = this.trafficLightEnum.color.fontAnsiColor
        val currentBackgroundColor = this.trafficLightEnum.color.backgroundAnsiColor

        val trafficLightName = this.streetName
        val lightName = this.trafficLightEnum.color.lightName

        println("$currentBackgroundColor   $ANSI_RESET_COLOR  $currentFontColor $lightName Light > $trafficLightName$ANSI_RESET_COLOR - time: ${getLocalTimeNow()}")
    }
}
