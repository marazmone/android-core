package com.marazmone.core.toast

import android.annotation.SuppressLint
import android.graphics.Outline
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.marazmone.core.R
import com.marazmone.core.databinding.ActivityToastBinding

private const val GRAVITY_TOAST_Y_OFFSET = 100
private const val CUSTOM_TOAST_CORNER_RADIUS = 200f

class ToastActivity : AppCompatActivity() {

    private lateinit var binding: ActivityToastBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToastBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
    }

    private fun initListeners() {
        binding.toastShort.setOnClickListener {
            showShortToast()
        }
        binding.toastLong.setOnClickListener {
            showLongToast()
        }
        binding.toastCustomGravity.setOnClickListener {
            showCustomGravityToast()
        }
        binding.toastCustom.setOnClickListener {
            showCustomToast()
        }
    }

    private fun showShortToast() {
        Toast.makeText(this, R.string.toast_text, Toast.LENGTH_SHORT).show()
    }

    private fun showLongToast() {
        Toast.makeText(this, R.string.toast_text, Toast.LENGTH_LONG).show()
    }

    private fun showCustomGravityToast() {
        val toast = Toast.makeText(this, R.string.toast_text, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.TOP, 0, GRAVITY_TOAST_Y_OFFSET)
        toast.show()
    }

    @SuppressLint("InflateParams")
    private fun showCustomToast() {
        val toastView = layoutInflater.inflate(R.layout.toast_custom, null)
        roundCorners(toastView)
        val toast = Toast(this)
        toast.duration = Toast.LENGTH_LONG
        toast.view = toastView
        toast.show()
    }

    private fun roundCorners(view: View) {
        view.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View, outline: Outline) {
                outline.setRoundRect(0, 0, view.width, view.height, CUSTOM_TOAST_CORNER_RADIUS)
            }
        }
        view.clipToOutline = true
    }
}