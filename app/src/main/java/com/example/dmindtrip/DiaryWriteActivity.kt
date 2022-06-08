package com.example.dmindtrip

import android.app.DatePickerDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import com.example.dmindtrip.databinding.ActivityDiaryWriteBinding
import java.util.*
import kotlin.collections.ArrayList

class DiaryWriteActivity : AppCompatActivity() {
    lateinit var binding: ActivityDiaryWriteBinding
    val cal = Calendar.getInstance()
    val newdata:ArrayList<DiaryData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiaryWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initData()

        binding.calendarbtn.setOnClickListener {
            showDatePickerDialog()
        }

        binding.savebtn.setOnClickListener {
            binding.apply {
                newdata.add(DiaryData(year.text.toString(),month.text.toString(),
                day.text.toString(), diaryTitle.text.toString(), diaryText.text.toString()))
            }
            finish()
        }

        binding.backbtn.setOnClickListener {
            finish()
        }
    }

    private fun initData() {

    }

    private fun showDatePickerDialog(){
        var datePicker = DatePickerDialog(
            this, object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    binding.year.text = year.toString()
                    binding.month.text = (month+1).toString()
                    binding.day.text = dayOfMonth.toString()
                }
            },cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH))
        datePicker.show()
    }
}