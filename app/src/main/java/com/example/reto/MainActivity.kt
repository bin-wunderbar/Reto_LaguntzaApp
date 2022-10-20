package com.example.reto


import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.reto.Clases.OptionsMenuActivity
import com.example.reto.databinding.ActivityMainBinding
import com.example.reto.ui.chat.ChatFragment


class MainActivity :  OptionsMenuActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onDestroy() {
        super.onDestroy()
        finish()
    }
/*
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        R.id.cat -> {
            replaceFragment(ChatFragment(),item.title.toString())
            true
        }

        R.id.cat2-> {
            Toast.makeText(applicationContext,"cat", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.cat3-> {
            Toast.makeText(applicationContext,"cdweewddat", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.cat4-> {
            Toast.makeText(applicationContext,"caddt", Toast.LENGTH_SHORT).show()
            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }*/

    private fun replaceFragment(fragmento: Fragment, title: String) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.drawerLayout, fragmento)
        fragmentTransaction.commit()
        setTitle(title)
    }
}