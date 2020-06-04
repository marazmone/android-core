package com.marazmone.core

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.marazmone.core.databinding.ActivityMainBinding
import com.marazmone.core.toast.ToastActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
    }

    private fun initListeners() {
        binding.toast.setOnClickListener {
            startActivity(Intent(this, ToastActivity::class.java))
        }
    }
}