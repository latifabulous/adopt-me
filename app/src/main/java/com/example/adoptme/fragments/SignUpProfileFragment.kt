package com.example.adoptme.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import com.example.adoptme.R

class SignUpProfileFragment : Fragment() {
    lateinit var tvName: TextView
    lateinit var tvMessage: TextView

    var message: String? = null

    companion object {
        var EXTRA_NAME = "extra_name"
        var EXTRA_MESSAGE = "extra_message"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvName = view.findViewById(R.id.tv_name)
        tvMessage = view.findViewById(R.id.tv_message)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (savedInstanceState != null) {
            val messFromBundle = savedInstanceState.getString(EXTRA_MESSAGE)
            message = messFromBundle
        }
        if (arguments != null) {
            val uname = arguments?.getString(EXTRA_NAME)
            tvName.text = uname
            tvMessage.text = message
        }
    }
}