package com.example.introkotlin901.temasKotlin

// Se le va pedir un numero para poder hacer una piramide de *, donde si ingresa 3, debe ser asi:
//  *
//  **
//  ***
// Solo puede usar un ciclo do while y que solo pueda salir con 0

fun main() {
    var opcion: Int

    do {
        print("Ingrese un numero para la piramide (0 para salir): ")
        opcion = readln().toInt()

        if (opcion != 0) {
            var fila = 1
            var asteriscos = ""

            do {
                asteriscos += "*"
                println(asteriscos)
                fila++
            } while (fila <= opcion)
        }
    } while (opcion != 0)

    println("Programa terminado.")
}