package br.iesb.educanutri.views.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.iesb.educanutri.R
//import br.iesb.educanutri.view_model.PlaylistViewModel
import br.iesb.educanutri.views.activities.MainActivity
//import br.iesb.educanutri.views.adapter.MusicAdapter
import kotlinx.android.synthetic.main.fragment_consulta.*

class ConsultaFragment(context: Context, private val principalView: MainActivity) :
    Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_consulta, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initRecyclerView()

        favoritesList()
    }

    private fun initRecyclerView() {
        ConsultaRecyclerViewList.layoutManager = LinearLayoutManager(context)
    }

    private fun favoritesList() {
//        viewModelP.playlist("favorites")
    }
}
