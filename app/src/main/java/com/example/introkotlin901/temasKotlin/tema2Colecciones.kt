fun main () {
    /*
    list, MutableList
    Set, MutableSet
    Map, MutableMap
     */

    var readonlyList: List<String> = listOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes")
    println(readonlyList)
    println("El primer dia de la semana es: ${readonlyList[0]}")
    println("El primer dia de la semana es: ${readonlyList.first()}")
    println("El numero de dias es: ${readonlyList.count()}")
    println("El numero de dias es: ${readonlyList.size}")
    println("Martes" in readonlyList)

    var figuras:MutableList<String> = mutableListOf("Circulo", "Cuadrado", "Triangulo")
    println(figuras)
    figuras.add("Pentagono")
    println(figuras)
    figuras.removeAt(0)
    println(figuras)
    figuras.remove("Cuadrado")

    // ----------------------------------------------------------------------------------
    val readOnlyFrutas= mapOf("manzana" to 1500, "platano" to 2000, "sandia" to 2500)
    println(readOnlyFrutas)
    println(readOnlyFrutas["manzana"])
    println(readOnlyFrutas.keys)
    println(readOnlyFrutas.values)
}