import kotlin.math.sqrt

fun main() {
    println("Calculadora de la Fórmula General")
    println("Forma: ax² + bx + c = 0")

    var a: Double
    var b: Double
    var c: Double

    do {
        print("Ingrese a : ")
        a = readln().toDouble()
        if (a == 0.0) println("Error: 'a' no puede ser cero.\n")
    } while (a == 0.0)

    print("Ingrese b: ")
    b = readln().toDouble()

    print("Ingrese c: ")
    c = readln().toDouble()
    val discriminante = b * b - 4 * a * c

    if (discriminante < 0) {
        println("\nError: El discriminante es negativo (${"%.2f".format(discriminante)}).")
        println("La ecuación no tiene soluciones reales.")
    } else {
        val x1 = (-b + sqrt(discriminante)) / (2 * a)
        val x2 = (-b - sqrt(discriminante)) / (2 * a)

        println("\nResultados:")
        if (discriminante == 0.0) {
            println("x = ${"%.4f".format(x1)}")
        } else {
            println("x1 = ${"%.4f".format(x1)}")
            println("x2 = ${"%.4f".format(x2)}")
        }
    }
}