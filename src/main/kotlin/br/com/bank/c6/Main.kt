import br.com.bank.c6.web.controller.impl.TrafficLightControllerImpl

fun main(args: Array<String>) {

    val trafficLightController = TrafficLightControllerImpl()

    trafficLightController.initializeTrafficLights(
        "Alameda Barros",
        "Avenida Angélica"
    )


}