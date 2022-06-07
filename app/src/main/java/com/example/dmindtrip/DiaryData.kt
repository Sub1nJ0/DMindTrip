package com.example.dmindtrip

import java.io.Serializable

data class DiaryData(var title:String, var year:Int=2022, var month:Int, var day:Int, var Content:String=""): Serializable{

}
