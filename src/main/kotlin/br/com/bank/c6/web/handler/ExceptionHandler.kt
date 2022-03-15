package br.com.bank.c6.web.handler

import br.com.bank.c6.entities.constants.TrafficLightConstants
import br.com.bank.c6.entities.exceptions.TrafficLightsException

/**
 * Class to simulate the operation of the Exception Handler
 * @author math-ferreira
 */
class ExceptionHandler {

    companion object {

        fun `throw`(ex: Exception) {
            when (ex::class) {
                TrafficLightsException::class -> runTrafficLightsException(ex as TrafficLightsException)
                else -> runGenericException(ex)
            }
        }

        private fun runTrafficLightsException(ex: TrafficLightsException) {
            simulateSystemError(ex.message)
        }

        private fun runGenericException(ex: Exception) {
            println("Do another thing")
            simulateSystemError(ex.message)
        }
    }
}

fun simulateSystemError(message: String?) {
    repeat((1..3).count()) {
        println("${TrafficLightConstants.ANSI_BACKGROUND_YELLOW_COLOR}   ${TrafficLightConstants.ANSI_RESET_COLOR} ${TrafficLightConstants.ANSI_YELLOW_COLOR} $message ${TrafficLightConstants.ANSI_RESET_COLOR}\n")
        Thread.sleep(1000)
    }
}