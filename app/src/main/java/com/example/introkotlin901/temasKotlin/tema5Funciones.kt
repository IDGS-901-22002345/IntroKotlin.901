package com.example.introkotlin901.temasKotlin

fun saludo (){
    return println("Hola Mundo")
}

fun sum(a:Int, b:Int):Int{
    return a+b
}

fun sum2(a:Int, b:Int)=a+b

fun main () {
    saludo()
    println("---------------------------------------------------------------------------")
    println(sum(2,3))
    println(sum2(2,3))
}