package com.evirgenoguz.oopbtk

class Kullanici: Insan {

    var isim: String? = null
    var yas: Int? = null

    constructor(isim: String, yas: Int){
        this.isim = isim
        this.yas = yas
        println("Kullanici Constructor")
    }

    init {
        println("Init cağrıldı")
        //init methodu constructordan önce çağırılır
    }

}