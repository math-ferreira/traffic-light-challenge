package br.com.bank.c6.service

import br.com.bank.c6.entities.dto.TrafficLightRequestDTO

interface TrafficLightService {

    fun runTrafficLights(trafficLightRequestDTO: TrafficLightRequestDTO)
}