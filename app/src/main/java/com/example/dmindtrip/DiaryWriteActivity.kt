package com.example.dmindtrip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dmindtrip.databinding.ActivityDiaryWriteBinding

class DiaryWriteActivity : AppCompatActivity() {
    lateinit var binding: ActivityDiaryWriteBinding
    var diaryData:ArrayList<DiaryData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiaryWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initData()
    }

    private fun initData() {
        binding.diaryTitle.text

    }
    companion object{
        var diaryData:DiaryData? = null
    }
}