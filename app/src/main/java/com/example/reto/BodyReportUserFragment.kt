package com.example.reto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class BodyReportUserFragment : Fragment(R.layout.fragment_body_report_user) {
    lateinit var UsersList : ArrayList<Users>
    private lateinit var rvAdapter: RvAdapter
    private lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_body_report_user, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rvListUserReportes)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        UsersList = arrayListOf()

        //conecction BD
        val db: FirebaseFirestore
        db = FirebaseFirestore.getInstance()
        db.collection("Usuarios")
            .whereGreaterThanOrEqualTo("reportes",  1)
            .get()
            .addOnSuccessListener {
                if(!it.isEmpty){
                    for (data in it.documents){
                        val user: Users? =data.toObject(Users::class.java)
                        if(user !=null){
                            UsersList.add(user)
                        }
                    }
                    rvAdapter = RvAdapter(UsersList){
                        navegar(it)
                    }
                    recyclerView.adapter = rvAdapter
                }

            }

        ///rvAdapter = RvAdapter(userProvide.UsersList)

    }

    fun navegar(user : Users){
        val detail = DetailUserReportFragment()
        detail.arguments = bundleOf(DetailUserReportFragment.EXTRA_USER to user)
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.remplazable, detail)
            .setReorderingAllowed(true)
            .addToBackStack(null)
            .commit()

    }



}