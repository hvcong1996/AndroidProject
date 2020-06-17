package com.example.myproject

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.myproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Aleks Haecky")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = this.myName

        binding.btnDone.setOnClickListener{
            addNickName(it)
        }

        binding.nicknameText.setOnClickListener {
            updateNickname(it)
        }
    }

    // handler button click case 2
    private fun addNickName(view: View){

        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            //invalidateAll()
            nicknameEdit.visibility = View.GONE
            nicknameText.visibility = View.GONE
        }
        view.visibility = View.GONE // GONE item truyen vao, item o day la button

        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname (view: View) {
        binding.apply {
            nicknameEdit.visibility = View.VISIBLE
            btnDone.visibility = View.VISIBLE
            // Set the focus to the edit text.
            nicknameEdit.requestFocus()
        }
        view.visibility = View.GONE

        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.nicknameEdit, 0)
    }

    // handler button click case 1
    private fun clickHandlerFunction(viewThatIsClicked: View) {
        binding.nicknameText.text = binding.nicknameEdit.text
        binding.nicknameEdit.visibility = View.GONE // GONE text input
        viewThatIsClicked.visibility = View.GONE // GONE item truyen vao, item o day la button
        binding.nicknameText.visibility = View.VISIBLE // VISIBLE textView nickname
    }
}
