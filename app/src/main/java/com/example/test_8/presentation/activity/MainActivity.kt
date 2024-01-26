package com.example.test_8.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test_8.R
import com.example.test_8.databinding.ActivityMainBinding
import com.example.test_8.presentation.adapter.DrawerItemRecyclerAdapter
import com.example.test_8.presentation.model.DrawerItem
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupDrawer()
    }

    private fun setupDrawer() {
        val items = listOf(
            DrawerItem(1, R.drawable.ic_bell, "Notifications", 20),
            DrawerItem(2, R.drawable.ic_calendar, "Calendar", 30),
            DrawerItem(3, R.drawable.ic_chat, "Chat", null),
            DrawerItem(4, R.drawable.ic_profile, "Profile", null),
            DrawerItem(5, R.drawable.ic_settings, "Settings", null),
            DrawerItem(6, R.drawable.ic_weird_boxes, "DashBoard", null)
        )

        val adapter = DrawerItemRecyclerAdapter()

        val recyclerView = binding.navView.getHeaderView(0).findViewById<RecyclerView>(R.id.settings_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        adapter.submitList(items)
    }
}
