package com.example.finaluriterm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginFrag : Fragment() {
    private lateinit var email : EditText
    private lateinit var password: EditText
    private lateinit var register:TextView
    private lateinit var reset : TextView
    private lateinit var login : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_login, container, false)
        email = view.findViewById(R.id.email)
        password = view.findViewById(R.id.password)
        register = view.findViewById(R.id.register_now)
        reset = view.findViewById(R.id.reset_password)
        login = view.findViewById(R.id.signIn)

        register.setOnClickListener(){
            val fragment1 = RegisterFrag()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.mainContainer, fragment1)
            transaction?.commit()
        }


        login.setOnClickListener {
            if (email.text.isNotEmpty() &&password.text.isNotEmpty()){

                FirebaseAuth.getInstance().signInWithEmailAndPassword(email.text.toString(),password.text.toString())
                    .addOnSuccessListener { Toast.makeText(requireContext(), "welcome", Toast.LENGTH_SHORT).show()
                        val fragment1 = MainFragments()
                        val transaction = fragmentManager?.beginTransaction()
                        transaction?.replace(R.id.mainContainer, fragment1)
                        transaction?.commit()

                    }
            }
        }
        return view
    }

}