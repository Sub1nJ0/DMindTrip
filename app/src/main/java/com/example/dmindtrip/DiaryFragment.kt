package com.example.dmindtrip

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dmindtrip.databinding.FragmentDiaryBinding
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.row_diary.*

class DiaryFragment : Fragment() {
    lateinit var binding: FragmentDiaryBinding
    lateinit var adapter: DiaryAdapter
    lateinit var layoutManager: LinearLayoutManager
    lateinit var rdb: DatabaseReference
    val key = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDiaryBinding.inflate(inflater,container,false)
        initRecyclerview()
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //write new diary
        binding.writebtn.setOnClickListener {
            val intent = Intent(this.requireContext(), DiaryWriteActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initRecyclerview() {
        layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        rdb = Firebase.database.getReference("Diary/Contents")
        val query = rdb.limitToLast(50)
        val option = FirebaseRecyclerOptions.Builder<DiaryData>()
            .setQuery(query, DiaryData::class.java).build()

        //edit diary
        adapter = DiaryAdapter(option)
        adapter.itemClickListener = object : DiaryAdapter.OnItemClickListener {
            override fun onItemClick(position: Int, titlekey:String) {
                val intent = Intent(requireContext(), DiaryEditActivity::class.java)
                //intent.putExtra("titlekey",titlekey)
                intent.putExtra("position", position)
                startActivity(intent)
            }
        }
        binding.apply {
            diaryRecyclerview.layoutManager = layoutManager
            diaryRecyclerview.adapter = adapter
        }
        adapter.startListening()

    }



}