package com.example.dmindtrip

import java.io.Serializable

data class DiaryData(var year:Int, var month:Int, var day:Int, var title:String="", var Content:String=""): Serializable{

}
