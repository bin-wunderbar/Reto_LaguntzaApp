package com.example.reto


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.reto.databinding.FragmentDetailUserReportBinding
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.EmailAuthCredential
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.EmailAuthProvider.getCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class DetailUserReportFragment : Fragment(R.layout.fragment_detail_user_report) {
    val db:FirebaseFirestore= FirebaseFirestore.getInstance()
    lateinit var  btnDelete: Button

    companion object {
        const val EXTRA_USER = "DetailUserReportFragment:extraUser"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val user = arguments?.getParcelable<Users>(EXTRA_USER)

        if (user!= null){
            val binding = FragmentDetailUserReportBinding.bind(view)
            binding.txtUsuario.text = user.nombre
            binding.txtApellidos.text = user.apellidos
            binding.numReportes.setText("${user.reportes}")
            binding.idUser.text = user.id.toString()
        }
        //borrar usuario en el autenticador de firebase
        val email = user?.email.toString()
        val pass = user?.pass.toString()
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, pass)
        val userAuth = FirebaseAuth.getInstance().currentUser

        //borrar un usuario en firestore
        btnDelete = view.findViewById(R.id.textButton)
        btnDelete.setOnClickListener(){
            val binding = FragmentDetailUserReportBinding.bind(view)
            if (binding.idUser.text.isNotBlank()){
                db.collection("Usuarios").document(binding.idUser.text.toString())
                    .delete()
                    //borrar usuario en el autenticador de firebase
                    .addOnSuccessListener {
                        val autenticar = EmailAuthProvider
                                    .getCredential(email, pass)
                        userAuth?.reauthenticate(autenticar)
                            ?.addOnCompleteListener{
                                    userAuth.delete()
                                Toast.makeText(context, "Borrado correctamente", Toast.LENGTH_SHORT).show()
                                FirebaseAuth.getInstance().signInWithEmailAndPassword("administrador@laguntzapp.euz", "LaguntzApp2022")
                                    .addOnSuccessListener {
                                        val intent = Intent (getActivity(), Admin_Activity::class.java)
                                        getActivity()?.startActivity(intent)
                                    }
                            }
                    }

            }
            else{
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
            }

        }


    }

}






