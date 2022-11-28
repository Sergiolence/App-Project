package com.projectes.projectelogin

class Clase(val id:Int?,tit:String, subt:String, desc:String) {
    var titol = tit
    var subtitol = subt
    var descripcio = desc

    @JvmName("getTitol1")
    fun getTitol():String{
        return titol;
    }
    @JvmName("setTitol1")
    fun setTitol(esm: String) {
        titol = esm;
    }
    @JvmName("getSubtitol1")
    fun getSubtitol():String{
        return subtitol;
    }
    @JvmName("setSubtitol1")
    fun setSubtitol(esm: String) {
        subtitol = esm;
    }
    @JvmName("getDescripcio1")
    fun getDescripcio():String{
        return descripcio;
    }
    @JvmName("setDescripcio1")
    fun setDescripcio(esm: String) {
        descripcio = esm;
    }
}