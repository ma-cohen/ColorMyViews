package com.example.colormyviews

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }


    private fun setListeners() {
        val clickableViews: List<View> =
            listOf(
                box_one_text,
                box_two_text,
                box_three_text,
                box_four_text,
                box_five_text,
                contraintLayout,
                red_button,
                yellow_button,
                green_button
            )
        clickableViews.forEach { item ->
            item.setOnClickListener { makeColored(it) }
        }
    }


    private fun getColor(view: View, newColor: Int): Int {
        var backgroundColor: Int = android.R.color.transparent
        val background = view.background

        if (background is ColorDrawable) {
            backgroundColor = background.color
            return if (backgroundColor == newColor) {
                android.R.color.transparent
            } else {
                newColor
            }
        }
        return backgroundColor

    }

    private fun makeColored(view: View) {
        when (view.id) {

            // Boxes using Color class colors for background
            R.id.box_one_text -> view.setBackgroundColor(getColor(view, Color.DKGRAY))
            R.id.box_two_text -> view.setBackgroundColor(getColor(view, Color.GRAY))


            R.id.box_three_text -> view.setBackgroundColor(getColor(view,Color.RED))
            R.id.box_four_text -> view.setBackgroundColor(getColor(view,Color.YELLOW))
            R.id.box_five_text -> view.setBackgroundColor(getColor(view,Color.GREEN))


            R.id.red_button -> box_three_text.setBackgroundColor(Color.RED)
            R.id.yellow_button -> box_four_text.setBackgroundColor(Color.YELLOW)
            R.id.green_button -> box_five_text.setBackgroundColor(Color.GREEN)

            else -> view.setBackgroundColor(getColor(view,Color.LTGRAY))
        }
    }


}