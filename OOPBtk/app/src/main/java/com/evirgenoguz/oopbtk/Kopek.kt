package com.evirgenoguz.oopbtk

class Kopek: Hayvan() {

    fun kopekFonk(){
        super.sesCikar()

    }

    override fun sesCikar(){
        println("Kopek Sesi")
        super.sesCikar()
    }

}