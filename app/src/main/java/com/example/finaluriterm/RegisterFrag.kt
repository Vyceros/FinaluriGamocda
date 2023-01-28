package com.example.finaluriterm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController

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
            val fragment2 = LoginFrag()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.mainContainer, fragment2)
            transaction?.commit()

        register1.setOnClickListener(){
            var password = pass.text.toString()
            var email = email1.text.toString()

            if (password.isNotEmpty() && email.isNotEmpty()){
                //DAAMATE PIROBEBI RO GAIGEB FIREBASE ROGOR CHAAMATO
            }


        }


        }
        return view
    }
}