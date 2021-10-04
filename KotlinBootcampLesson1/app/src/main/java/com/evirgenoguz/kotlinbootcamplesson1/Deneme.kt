package com.evirgenoguz.kotlinbootcamplesson1

fun main(){
    var yas = 25
    val isim = "Serkan"
    var kat = 4

    //var - val farkı var sonradan değişebilir val ise sonradan değişemez

    println("${yas}'inci yaş günün kutlu olsun")
    println("25'inci yaş günün kutlu olsun")
    println("Nice Mutlu Yıllara")


    mumEkle(yas)
    catiEkle(yas)
    katEkle(yas, kat)
    /*
    println(" ''''''''''''''''''''''''' ")
    println(" ||||||||||||||||||||||||| ")
    println("===========================")
    println("@@@@@@@@@@@@@@@@@@@@@@@@@@@")
    println("@@@@@@@@@@@@@@@@@@@@@@@@@@@")
    println("@@@@@@@@@@@@@@@@@@@@@@@@@@@")
    */
}


fun katEkle(yas: Int, kat: Int){
    repeat(kat){
        repeat(yas+2){
            print("@")
        }
        println()
    }
}



fun catiEkle(yas: Int){
    repeat(yas+2){
        print("=")
    }
    println()
}


fun mumEkle(yas: Int){
    print(" ")
    repeat(yas){
        print("'")
    }
    println(" ")

    print(" ")
    repeat(yas){
        print("|")
    }
    println(" ")



}