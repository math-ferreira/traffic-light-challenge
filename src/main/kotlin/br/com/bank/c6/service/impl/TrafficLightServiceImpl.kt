package br.com.bank.c6.service.impl

import br.com.bank.c6.entities.dto.StreetTrafficDTO
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
        var currentTraffic = trafficLightRequestDTO.pairOfStreetTraffics.first

        while (true) {
            currentTraffic = displayAndTurnNextLight(currentTraffic, trafficLightRequestDTO)
        }
    }

    private fun displayAndTurnNextLight(currentTraffic: StreetTrafficDTO, trafficsLightDTO: TrafficLightRequestDTO): StreetTrafficDTO {
        displaysCurrentColor(currentTraffic)
        return getNextColorOrTrafficLight(currentTraffic, trafficsLightDTO)
    }

    private fun displaysCurrentColor(currentTraffic: StreetTrafficDTO) {
        currentTraffic.displaysCurrentColor()
        waitForDuration(currentTraffic.trafficLightEnum.timeSeconds)
    }

    private fun waitForDuration(timeSeconds: Int) = Thread.sleep((timeSeconds * 1000).toLong())

    private fun getNextColorOrTrafficLight(currentTraffic: StreetTrafficDTO, trafficLightRequest: TrafficLightRequestDTO): StreetTrafficDTO {
        val currentColor = currentTraffic.trafficLightEnum.color

        if (currentColor != ColorEnum.RED) {
            return getNextColor(currentTraffic)
        }

        return getNextTrafficLight(currentTraffic, trafficLightRequest)
    }

    private fun getNextColor(currentTraffic: StreetTrafficDTO): StreetTrafficDTO {
        val nextLightEnum = TrafficLightEnum.getNextLight(currentTraffic.trafficLightEnum)
        return currentTraffic.copy(trafficLightEnum = nextLightEnum)
    }

    private fun getNextTrafficLight(currentTraffic: StreetTrafficDTO, trafficLightRequest: TrafficLightRequestDTO): StreetTrafficDTO {
        return when (currentTraffic.streetName) {
            trafficLightRequest.pairOfStreetTraffics.first.streetName -> trafficLightRequest.pairOfStreetTraffics.second
            else -> trafficLightRequest.pairOfStreetTraffics.first
        }
    }
}
