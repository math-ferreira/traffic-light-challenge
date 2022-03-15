package br.com.bank.c6.web.controller.impl

import br.com.bank.c6.entities.dto.toTrafficLightRequestDTO
import br.com.bank.c6.service.TrafficLightService
import br.com.bank.c6.service.impl.TrafficLightServiceImpl
import br.com.bank.c6.web.controller.TrafficLightController

class TrafficLightControllerImpl : TrafficLightController {

    private lateinit var trafficLightService: TrafficLightService

    override fun initializeTrafficLights(vararg trafficLightNames: String) {

        val trafficLightRequestDTO = trafficLightNames.toList()
            .toTrafficLightRequestDTO()

        this.trafficLightService = TrafficLightServiceImpl()

        this.trafficLightService.runTrafficLights(trafficLightRequestDTO)

    }
}