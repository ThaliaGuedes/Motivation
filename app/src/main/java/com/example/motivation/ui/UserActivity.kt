package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.R
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)

        binding.buttonSave.setOnClickListener(this)

        //verifyUsername()
        setContentView(binding.root)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_save){

            handoleSave()
        }

    }
    private fun handoleSave(){
        val name = binding.editName.text.toString()
        if (name != "" ){
            SecurityPreferences(this).storeString(MotivationConstants.KEY.USER_NAME, name)
            // fazendo a navegacao entre as telas
           startActivity(Intent(this, MainActivity::class.java))
            finish()
            //se a minha variavel nome for diferente de vazio,
        }else{
            Toast.makeText(this, R.string.validation_mandatory_name, Toast.LENGTH_LONG ).show()
        }
    }

    private fun verifyUsername(){
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)

        if (name != ""){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }else{

        }
    }
}