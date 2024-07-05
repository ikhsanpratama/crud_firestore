package com.example.listandgrid

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var binding: AdapterList
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Inisialisasi RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val floatingActionButton = findViewById<FloatingActionButton>(R.id.floatAddNews);

        floatingActionButton.setOnClickListener{
            val toAddPage = Intent(this@MainActivity, NewsAdd::class.java)
            startActivity(toAddPage)
        }

        recyclerView.layoutManager = GridLayoutManager(this,1)
        recyclerView.setHasFixedSize(true)
        val itemList = listOf(
            ItemList("Judul 1", "Deskripsi 1", "https://maukuliah.ap-south-1.linodeobjects.com/gallery/043059/Gedung%201%20STTB-thumbnail.jpg"),
            ItemList("Judul 2", "Deskripsi 2", "https://maukuliah.ap-south-1.linodeobjects.com/gallery/043059/Gedung%201%20STTB-thumbnail.jpg"),
            ItemList("Judul 3", "Deskripsi 3", "https://maukuliah.ap-south-1.linodeobjects.com/gallery/043059/Gedung%201%20STTB-thumbnail.jpg")
        )
        val adapter = AdapterList(itemList)
        recyclerView.adapter = adapter
    }
}