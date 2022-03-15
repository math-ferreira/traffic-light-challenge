package br.com.bank.c6.entities.dto

data class TrafficLightRequestDTO(
    val pairOfStreetTraffics: Pair<StreetTrafficDTO, StreetTrafficDTO>
)

fun Pair<String, String>.toTrafficLightRequestDTO(): TrafficLightRequestDTO {

    val firstTrafficLight = StreetTrafficDTO(streetName = this.first)
    val secondTrafficLight = StreetTrafficDTO(streetName = this.second)

    return TrafficLightRequestDTO(pairOfStreetTraffics = Pair(firstTrafficLight, secondTrafficLight))
}

