package com.example.introkotlin901.temasKotlin
//For
fun main(){
    for(i in 1..5){
        println(i)
    }
val nombres = listOf("Juan", "Pedro", "Maria")
    for(nombre in nombres){
        println(nombre)
    }


    //while do-while
    var i = 1
    while(i <= 5){
        println(i)
        i++
    }
    do {
        println(i)
        i++
    }while(i <= 5)

}
