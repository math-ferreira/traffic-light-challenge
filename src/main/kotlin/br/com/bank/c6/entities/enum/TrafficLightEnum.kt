package br.com.bank.c6.entities.enum

import br.com.bank.c6.entities.exceptions.TrafficLightsException

enum class TrafficLightEnum(
    val color: ColorEnum,
    val timeSeconds: Int,
    val currentPosition: Int,
    val nextPosition: Int
) {

    GREEN(
        color = ColorEnum.GREEN,
        timeSeconds = 6,
        currentPosition = 1,
        nextPosition = 2
    ),
    YELLOW(
        color = ColorEnum.YELLOW,
        timeSeconds = 2,
        currentPosition = 2,
        nextPosition = 3
    ),
    RED(
        color = ColorEnum.RED,
        timeSeconds = 1,
        currentPosition = 3,
        nextPosition = 1
    );

    companion object {

        fun getNextLight(trafficLight: TrafficLightEnum) =
            values().find { trafficLight.nextPosition == it.currentPosition }
                ?: throw TrafficLightsException("Next light not found, current light is: ${trafficLight.name} and the next position is: ${trafficLight.nextPosition}")

    }

}