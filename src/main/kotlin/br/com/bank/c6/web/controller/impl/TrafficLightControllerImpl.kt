package br.com.bank.c6.web.controller.impl

import br.com.bank.c6.web.controller.TrafficLightController
import br.com.bank.c6.entities.dto.toTrafficLightRequestDTO
import br.com.bank.c6.service.TrafficLightService
import br.com.bank.c6.service.impl.TrafficLightServiceImpl

class TrafficLightControllerImpl : TrafficLightController {

    private lateinit var trafficLightService: TrafficLightService

    override fun initializeTrafficLights(firstStreetName: String, secondStreetName: String) {

        val trafficLightRequestDTO = Pair(firstStreetName, secondStreetName)
            .toTrafficLightRequestDTO()

        this.trafficLightService = TrafficLightServiceImpl()

        trafficLightService.runTrafficLights(trafficLightRequestDTO)

    }
}