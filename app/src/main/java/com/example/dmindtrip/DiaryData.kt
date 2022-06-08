package com.example.dmindtrip

import java.io.Serializable

data class DiaryData(var year:String, var month:String, var day:String, var title:String="", var Content:String=""): Serializable{

}
