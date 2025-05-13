package com.example.introkotlin901.temasKotlin

import kotlin.math.PI

class Circulo(val radio: Double) {
    fun calcularArea(): Double {
        return PI * radio * radio
    }
}

class Cuadrado(val lado: Double) {
    fun calcularArea(): Double {
        return lado * lado
    }
}

class Triangulo(val base: Double, val altura: Double) {
    fun calcularArea(): Double {
        return (base * altura) / 2
    }
}

class Pentagono(val lado: Double, val apotema: Double) {
    fun calcularArea(): Double {
        val perimetro = 5 * lado
        return (perimetro * apotema) / 2
    }
}

fun main() {
    var opcion: Int

    do {
        println("\nQue figura deseas calcular el area?")
        println("1. Circulo")
        println("2. Cuadrado")
        println("3. Triangulo")
        println("4. Pentagono")
        println("5. Salir")
        print("Selecciona una opcion (1-5): ")
        opcion = readln().toInt()

        when (opcion) {
            1 -> {
                print("Ingresa el radio del circulo: ")
                val radio = readln().toDouble()

                if (radio > 0) {
                    val figura = Circulo(radio)
                    val area = figura.calcularArea()
                    println("El area del circulo es: ${"%.2f".format(area)}")
                } else {
                    println("Error: Radio circulo")
                }
            }
            2 -> {
                print("Ingresa el lado del cuadrado: ")
                val lado = readln().toDouble()

                if (lado > 0) {
                    val figura = Cuadrado(lado)
                    val area = figura.calcularArea()
                    println("El area del cuadrado es: ${"%.2f".format(area)}")
                } else {
                    println("Error: Lado invalido")
                }
            }
            3 -> {
                print("Ingresa la base del triangulo: ")
                val base = readln().toDouble()

                print("Ingresa la altura del triangulo: ")
                val altura = readln().toDouble()

                if (base > 0 && altura > 0) {
                    val figura = Triangulo(base, altura)
                    val area = figura.calcularArea()
                    println("El area del triangulo es: ${"%.2f".format(area)}")
                } else {
                    println("Error: Base o altura invalidas")
                }
            }
            4 -> {
                print("Ingresa la longitud de un lado: ")
                val lado = readln().toDouble()

                print("Ingresa la apotema: ")
                val apotema = readln().toDouble()

                if (lado > 0 && apotema > 0) {
                    val figura = Pentagono(lado, apotema)
                    val area = figura.calcularArea()
                    println("El área del pentagono es: ${"%.2f".format(area)}")
                } else {
                    println("Error: Lado o apotema invalidos")
                }
            }
            5 -> println("Saliendo del programa...")
            else -> println("Opcion no valida")
        }

    } while (opcion != 5)
}
