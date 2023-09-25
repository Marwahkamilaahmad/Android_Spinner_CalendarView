package com.example.myapplication

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.NumberPicker
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val kehadiran = arrayOf(
        "klik kehadiran","Hadir tepat waktu", "Sakit", "Terlambat", "Izin"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            val adapterKehadiran =
                ArrayAdapter(this@MainActivity, R.layout.simple_spinner_item, kehadiran)

            adapterKehadiran.setDropDownViewResource(com.google.android.material.R.layout.support_simple_spinner_dropdown_item)
            spinnerKehadiran.adapter = adapterKehadiran

            numberPickerMin.minValue = 1
            numberPickerMin.maxValue = 12

            numberPickerSec.minValue = 0
            numberPickerSec.maxValue = 59

            val str = arrayOf("AM", "PM")

            numberPickerAm.minValue = 0
            numberPickerAm.maxValue = str.size - 1
            numberPickerAm.displayedValues = str

            numberPickerAm.value = 0

            spinnerKehadiran.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    val ketKehadiran = kehadiran[position]
                    if (ketKehadiran == "Sakit") {
                        keteranganSakit.visibility = View.VISIBLE
                    } else {
                        keteranganSakit.visibility = View.GONE
                    }
                    Toast.makeText(this@MainActivity,ketKehadiran,Toast.LENGTH_SHORT).show()
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }

        }
        }



    }
