package com.evirgenoguz.siniflarvefonksiyonlar

class SuperKahraman {
    var isim = ""
    var yas = 0
    var meslek = ""

    constructor(isimGirdisi : String  , yasGirdisi : Int, meslekGirdisi:String){
        isim = isimGirdisi
        yas = yasGirdisi
        meslek = meslekGirdisi
        println("Ctor çağırıldı")
    }

}