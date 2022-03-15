package br.com.bank.c6.entities.dto

data class TrafficLightRequestDTO(
    val trafficLights: List<TrafficLightDTO>
)

fun List<String>.toTrafficLightRequestDTO(): TrafficLightRequestDTO {
    val listOfTrafficLights = this.mapIndexed { index, s ->
        TrafficLightDTO(position = index, streetName = s)
    }
    return TrafficLightRequestDTO(listOfTrafficLights)
}


