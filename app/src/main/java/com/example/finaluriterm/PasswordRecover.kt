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

class PasswordRecover : Fragment(R.layout.fragment_password_recover) {

    private lateinit var submit : Button
    private lateinit var resetEmail : EditText
    private lateinit var backTo : TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_password_recover, container, false)

        submit = view.findViewById(R.id.btnReset)
        resetEmail = view.findViewById(R.id.email_reset)
        backTo = view.findViewById(R.id.go_back)

        submit.setOnClickListener {
            if (resetEmail.text.isNotEmpty()){
                FirebaseAuth.getInstance().sendPasswordResetEmail(resetEmail.text.toString())
                    .addOnSuccessListener {
                        Toast.makeText(requireContext(), "Reset email sent, check your email address", Toast.LENGTH_SHORT).show()
                        val fragment1 = LoginFrag()
                        val transaction = fragmentManager?.beginTransaction()
                        transaction?.replace(R.id.mainContainer, fragment1)
                        transaction?.commit()
                    }
            }
        }
    backTo.setOnClickListener {
        val fragment1 = LoginFrag()
        val transaction = fragmentManager?.beginTransaction()
        transaction?.replace(R.id.mainContainer, fragment1)
        transaction?.commit()
    }
        return view
    }
}