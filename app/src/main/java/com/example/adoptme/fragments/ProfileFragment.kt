package com.example.adoptme.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.adoptme.R

class ProfileFragment : Fragment(), View.OnClickListener {

    lateinit var etUname : EditText
    lateinit var etEmail : EditText
    lateinit var btnSignIn : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        etUname = view.findViewById(R.id.et_uname)
        etEmail = view.findViewById(R.id.et_email)

        btnSignIn = view.findViewById(R.id.btn_sign_in)
        btnSignIn.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_sign_in) {
            val signUpProfileFragment = SignUpProfileFragment()
            val bundle = Bundle()

            bundle.putString(SignUpProfileFragment.EXTRA_NAME, "Halo " + etUname.text.toString())

            val message = "Sungguh sebuah anugerah kepadamu yang luar biasa ini. " + etUname.text.toString() + ", email verifikasi telah dikirim ya! ke " + etEmail.text.toString()

            signUpProfileFragment.arguments = bundle
            signUpProfileFragment.message = message

            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fl_wrapper, signUpProfileFragment, SignUpProfileFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }
}