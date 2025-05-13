package com.example.introkotlin901.temasKotlin
class usuarios(){
    val materia: String = ""
}

class usuarios2(val id:Int, val nombre:String){
    val materia: String = ""
    fun hola(){
        println("Hola")
    }
}

fun main (){
    val alumno = usuarios()
    val alumno2 = usuarios2(1, "Juan")
    println(alumno2.id)
    println(alumno2.nombre)
    alumno2.hola()
}