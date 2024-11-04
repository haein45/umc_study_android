package com.tori.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val countryList = ArrayList<CountryModel>()

        countryList.add(CountryModel("ic1",R.drawable.ic1))
        countryList.add(CountryModel("ic2",R.drawable.ic2))
        countryList.add(CountryModel("ic3",R.drawable.ic3))
        countryList.add(CountryModel("ic4",R.drawable.ic4))
        countryList.add(CountryModel("ic5",R.drawable.ic5))
        countryList.add(CountryModel("ic6",R.drawable.ic6))
        countryList.add(CountryModel("ic7",R.drawable.ic1))
        countryList.add(CountryModel("ic8",R.drawable.ic2))
        countryList.add(CountryModel("ic9",R.drawable.ic3))
        countryList.add(CountryModel("ic10",R.drawable.ic4))
        countryList.add(CountryModel("ic11",R.drawable.ic5))
        countryList.add(CountryModel("ic12",R.drawable.ic6))
        countryList.add(CountryModel("ic13",R.drawable.ic1))
        countryList.add(CountryModel("ic14",R.drawable.ic2))
        countryList.add(CountryModel("ic15",R.drawable.ic3))
        countryList.add(CountryModel("ic16",R.drawable.ic4))
        countryList.add(CountryModel("ic17",R.drawable.ic5))

        val adapter = CountryAdapter(countryList)

        recyclerView.adapter = adapter


    }
}