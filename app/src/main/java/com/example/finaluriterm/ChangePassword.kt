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
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth


class ChangePassword : Fragment(R.layout.fragment_change_password) {
    private lateinit var changebutton: Button
    private lateinit var currentpass: EditText
    private lateinit var newpass1: EditText
    private lateinit var newpass2: EditText
    private lateinit var textView : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view =  inflater.inflate(R.layout.fragment_change_password, container, false)
        changebutton = view.findViewById(R.id.changeButton)
        currentpass = view.findViewById(R.id.old_password)
        newpass1 = view.findViewById(R.id.new_password)
        newpass2 = view.findViewById(R.id.confirm_new_password)
        textView = view.findViewById(R.id.helloText)
        textView.text = "Hello ${FirebaseAuth.getInstance().currentUser?.email.toString().substring(0,FirebaseAuth.getInstance().currentUser?.email.toString().indexOf('@'))}"

        changebutton.setOnClickListener {


            val newpassw1 = newpass1.text.toString()
            val newpassw2 = newpass2.text.toString()
            val currentpassw = currentpass.text.toString()
            if (newpassw1.isNotEmpty()&&newpassw2.isNotEmpty()&&currentpassw.isNotEmpty()) {
                val user = FirebaseAuth.getInstance().currentUser
                val credential = EmailAuthProvider.getCredential(user?.email!!, currentpassw)

                user.reauthenticateAndRetrieveData(credential)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {


                            if (newpassw1==newpassw2 && newpassw1.length>=6){

                                user?.updatePassword(newpassw1)
                                    ?.addOnCompleteListener { task ->
                                        if (task.isSuccessful) {
                                            Toast.makeText(context, "password changed", Toast.LENGTH_SHORT).show()

                                        } else {
                                            Toast.makeText(context,"error",Toast.LENGTH_SHORT).show()
                                        }
                                    }
                            }
                        }
                    }
            }




        }



        return view
    }


}