package com.example.dmindtrip

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

data class DiaryData(var year:String, var month:String,
                     var day:String, var title:String="",
                     var Content:String="", var frequency:Int=0): Parcelable {

}
