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
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth

class RegisterFrag : Fragment() {
    private lateinit var email1 : EditText
    private lateinit var pass : EditText
    private lateinit var backtoSign : TextView
    private lateinit var register1 : Button

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_register, container, false)

        email1 = view.findViewById(R.id.email_Register)
        pass = view.findViewById(R.id.password_Register)
        backtoSign = view.findViewById(R.id.register_now)
        register1 = view.findViewById(R.id.registerBtn)

        register1.setOnClickListener() {

            if (email1.text.isNotEmpty() && pass.text.isNotEmpty()){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email1.text.toString(),pass.text.toString())
                    .addOnSuccessListener {
                        Toast.makeText(requireContext(), "successfully registered", Toast.LENGTH_SHORT).show()

                        val fragment2 = LoginFrag()
                        val transaction = fragmentManager?.beginTransaction()
                        transaction?.replace(R.id.mainContainer, fragment2)
                        transaction?.commit()

                    }
            }





        }
        return view
    }
}