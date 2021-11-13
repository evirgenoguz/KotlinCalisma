package com.evirgenoguz.oopbtk

open class Sanatci(isim: String, yas: Int, meslek: String) {

    //Encapsulation

    private var cinsiyet: String? = null


    var isim: String? = isim
        private set
        get

    var yas: Int? = yas
        private set
        get


    private var meslek: String? = meslek
}