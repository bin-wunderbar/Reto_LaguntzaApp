package com.example.reto

import android.content.SharedPreferences
import android.os.Bundle
import com.google.android.material.navigation.NavigationView

import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.reto.databinding.ActivityPrencipalBinding
import com.google.firebase.firestore.FirebaseFirestore
import io.grpc.okhttp.internal.framed.Header

class Prencipal : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityPrencipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityPrencipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarPrencipal.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_prencipal)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.chatFragment, R.id.ofertasFragment, R.id.Ejemplo
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)



    }

    override fun onResume() {
        super.onResume()
        // llamar a publicidad
        //activarPublicidad(this)
    }



    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_prencipal)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun cargarperfil(){
        val sharedPreferences: SharedPreferences = getSharedPreferences("Currentuser",0)
        val currentuser = sharedPreferences.getString("CurrentUser","Usuario")
        val db = FirebaseFirestore.getInstance()
        db.collection("Usuarios")
            .whereEqualTo("email","$currentuser")
            .get()
            .addOnSuccessListener { resultado ->
                val usuario = resultado.documents.get(0)
                val nombre = usuario.get("nombre")
                val apellidos = usuario.get("apellidos")
                val saldo = usuario.get("saldo")
                val descripcion = usuario.get("descripcion")
                val localidad = usuario.get("localidad")
                val id = usuario.get("id")
                binding.appBarPrencipal.toolbar.title = localidad.toString()
            }
    }
}