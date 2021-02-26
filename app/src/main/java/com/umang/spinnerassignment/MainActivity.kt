package com.umang.spinnerassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var countryName = ""
        var stateName = ""
        var cityName = ""
        spCountry.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                countryName = parent?.getItemAtPosition(position).toString()
                val countryID = parent?.getItemIdAtPosition(position).toString()
                Log.d("Main", countryID)
                var adapterCountry: ArrayAdapter<*>
                if(countryID == "0") {
                    val usa: Array<*>
                    usa = resources.getStringArray(R.array.USA)
                    adapterCountry = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, usa)
                    spStates.adapter = adapterCountry
                }
                if(countryID == "1") {
                    val ind: Array<*>
                    ind = resources.getStringArray(R.array.India)
                    adapterCountry = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, ind)
                    spStates.adapter = adapterCountry

                    spStates.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long)
                        {
                            stateName = parent?.getItemAtPosition(position).toString()
                            val stateID = parent?.getItemIdAtPosition(position).toString()
                            Log.d("Main", stateID)
                            var adapterState: ArrayAdapter<*>
                            if (stateID == "0") {
                                var ap: Array<*>
                                ap = resources.getStringArray(R.array.AndhraPradesh)
                                adapterState = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, ap)
                                spCity.adapter = adapterState

                            }
                            if (stateID == "1") {
                                var arp: Array<*>
                                arp = resources.getStringArray(R.array.ArunachalPradesh)
                                adapterState = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, arp)
                                spCity.adapter = adapterState

                            }
                            if (stateID == "2") {
                                var ass: Array<*>
                                ass = resources.getStringArray(R.array.Assam)
                                adapterState = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, ass)
                                spCity.adapter = adapterState

                            }
                            if (stateID == "3") {
                                var br: Array<*>
                                br = resources.getStringArray(R.array.Bihar)
                                adapterState = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, br)
                                spCity.adapter = adapterState

                            }
                            spCity.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                                    cityName = parent?.getItemAtPosition(position).toString()
                                }

                                override fun onNothingSelected(parent: AdapterView<*>?) {
                                    TODO("Not yet implemented")
                                }

                            }

                        }

                        override fun onNothingSelected(parent: AdapterView<*>?) {

                        }

                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        btnSubmit.setOnClickListener {
            Toast.makeText(this, "Country: $countryName \nState: $stateName \nCity: $cityName", Toast.LENGTH_LONG).show()
        }
    }
}