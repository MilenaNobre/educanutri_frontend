package br.iesb.educanutri.views.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.iesb.educanutri.R
import br.iesb.educanutri.views.activities.MainActivity
import kotlinx.android.synthetic.main.fragment_sobre_nos.*

class SobreNosFragment(context: Context, private val principalView: MainActivity) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sobre_nos, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }


}
