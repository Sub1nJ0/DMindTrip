package com.example.dmindtrip

import java.io.Serializable

data class ContactData(var name: String, var tel: String):Serializable {
    constructor():this("noinfo","noinfo")
}