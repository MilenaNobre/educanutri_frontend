package br.iesb.educanutri.views.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import br.iesb.educanutri.R
import br.iesb.educanutri.view_model.PrincipalViewModel
import br.iesb.educanutri.views.activities.PrivateAreaActivity
import kotlinx.android.synthetic.main.fragment_check_password_dialog.*

class CheckPasswordDialogFragment : DialogFragment() {
    private val pViewModel: PrincipalViewModel by lazy {
        ViewModelProvider(this).get(PrincipalViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_check_password_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        closeCheckPassword.setOnClickListener { this.dismiss() }
        verifyCheckPassword.setOnClickListener { verifyPassword() }
    }

    private fun verifyPassword() {
        val password = passwordCheckPassword.text.toString()

        pViewModel.checkPassword(password) { response ->
            Toast.makeText(context, response[1], Toast.LENGTH_SHORT).show()

            if (response[0] == "OK") {
                val intent = Intent(context, PrivateAreaActivity::class.java)

                startActivity(intent)

                this.dismiss()
            }
        }
    }
}