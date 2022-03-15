package br.com.bank.c6.service.impl

import br.com.bank.c6.entities.dto.TrafficLightDTO
import br.com.bank.c6.entities.dto.TrafficLightRequestDTO
import br.com.bank.c6.entities.enum.ColorEnum
import br.com.bank.c6.entities.enum.TrafficLightEnum
import br.com.bank.c6.entities.exceptions.TrafficLightsException
import br.com.bank.c6.service.TrafficLightService
import br.com.bank.c6.web.handler.ExceptionHandler.Companion.`throw`

class TrafficLightServiceImpl : TrafficLightService {

    override fun runTrafficLights(trafficLightRequestDTO: TrafficLightRequestDTO) {
        runCatching {
            scheduleAllTraffics(trafficLightRequestDTO)
        }.onFailure {
            println("Failure to run Traffic Lights - cause: ${it.cause} and message: ${it.message}")
            `throw`(TrafficLightsException("Traffic light failure, please wait for maintenance staff!"))
        }
    }

    private fun scheduleAllTraffics(trafficLightRequestDTO: TrafficLightRequestDTO) {

        var currentTrafficLight = trafficLightRequestDTO.trafficLights.first()

        while (true) {
            currentTrafficLight = displayAndTurnNext(currentTrafficLight, trafficLightRequestDTO)
        }
    }

    private fun displayAndTurnNext(currentTraffic: TrafficLightDTO, trafficsLightDTO: TrafficLightRequestDTO): TrafficLightDTO {
        displaysCurrentColor(currentTraffic)
        return getNextColorOrTrafficLight(currentTraffic, trafficsLightDTO)
    }

    private fun displaysCurrentColor(currentTraffic: TrafficLightDTO) {
        currentTraffic.displaysCurrentColor()
        waitForDuration(currentTraffic.trafficLightEnum.timeSeconds)
    }

    private fun waitForDuration(timeSeconds: Int) = Thread.sleep((timeSeconds * 1000).toLong())

    private fun getNextColorOrTrafficLight(currentTraffic: TrafficLightDTO, trafficLightRequest: TrafficLightRequestDTO): TrafficLightDTO {
        val currentColor = currentTraffic.trafficLightEnum.color

        if (currentColor != ColorEnum.RED) {
            return getNextColor(currentTraffic)
        }

        return getNextTrafficLight(currentTraffic, trafficLightRequest)
    }

    private fun getNextColor(currentTraffic: TrafficLightDTO): TrafficLightDTO {
        val nextLightEnum = TrafficLightEnum.getNextLight(currentTraffic.trafficLightEnum)
        return currentTraffic.copy(trafficLightEnum = nextLightEnum)
    }

    private fun getNextTrafficLight(currentTraffic: TrafficLightDTO, trafficLightRequest: TrafficLightRequestDTO): TrafficLightDTO {
        val nextPosition = currentTraffic.position.plus(1)
        return trafficLightRequest.trafficLights.find { it.position == nextPosition}
            ?: trafficLightRequest.trafficLights.first()
    }
}
