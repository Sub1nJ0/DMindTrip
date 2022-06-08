package com.example.dmindtrip

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dmindtrip.databinding.FragmentDiaryBinding
import java.util.*
import kotlin.collections.ArrayList

class DiaryFragment : Fragment() {
    lateinit var binding: FragmentDiaryBinding
    lateinit var adapter: DiaryListAdapter
    lateinit var layoutManager: RecyclerView.LayoutManager
    val spinnerItems = arrayOf("1","2","3","4","5","6","7","8","9","10","11","12")
    val diaryData:ArrayList<DiaryData> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDiaryBinding.inflate(inflater,container,false)
        diaryData.add(DiaryData("2022","6","7","모바일프로그래밍","TEST"))
        diaryData.add(DiaryData("2022", "6","4","웹","test2"))
        adapter = DiaryListAdapter(diaryData)

        //edit diary
        adapter.itemClickListener = object : DiaryListAdapter.OnItemClickListener {
            override fun onItemClick(data: DiaryData, position:Int) {
                gotoEdit(position)
            }
        }

        //spinner
        val adapter2 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, spinnerItems)
        binding.spinnerDate.adapter = adapter2

        //write new diary
        binding.writebtn.setOnClickListener {
            gotoWrite()
        }
        layoutManager = LinearLayoutManager(this.context)
        binding.diaryRecyclerview.layoutManager = layoutManager
        binding.diaryRecyclerview.adapter = adapter

        return binding!!.root
    }

    private fun gotoEdit(position:Int){
        val intent = Intent(this.context, DiaryWriteActivity::class.java)
        intent.putExtra("position", position)
        startActivity(intent)
    }

    private fun gotoWrite(){
        val intent = Intent(this.context, DiaryWriteActivity::class.java)
        startActivity(intent)
    }


}
