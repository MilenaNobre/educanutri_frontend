package br.iesb.educanutri.views.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.iesb.educanutri.R
import br.iesb.educanutri.aux_class.LoadingProcess
import br.iesb.educanutri.view_model.PrincipalViewModel
//import br.iesb.educanutri.view_model.PlaylistViewModel
import br.iesb.educanutri.views.activities.MainActivity
import br.iesb.educanutri.views.adapters.GeneticAlgorithmAdapter
//import br.iesb.educanutri.views.adapter.MusicAdapter
import kotlinx.android.synthetic.main.fragment_consulta.*

class ConsultaFragment(context: Context, private val principalView: MainActivity) :
    Fragment() {
    private lateinit var loading: LoadingProcess
    private lateinit var adapter: GeneticAlgorithmAdapter
    private val pViewModel: PrincipalViewModel by lazy {
        ViewModelProvider(this).get(PrincipalViewModel::class.java)
    }

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

        recyclerViewConsulta.visibility = View.GONE
        noMenuFound.visibility = View.GONE
        seeMore.visibility = View.GONE

        initRecyclerView()

        loading = LoadingProcess(loadingSearch, searchMenu)

        bacKConsultaFragment.setOnTouchListener { _, _ ->
            val inputMethodManager: InputMethodManager =
                requireActivity().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(activity?.currentFocus?.windowToken, 0)
        }

        searchMenu.setOnClickListener { searchMenu() }
    }

    private fun initRecyclerView() {
        recyclerViewConsulta.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        adapter = GeneticAlgorithmAdapter(mutableListOf())
        recyclerViewConsulta.adapter = adapter
    }

    private fun searchMenu() {
        val tamPop = qtdPopulationSearch.text.toString()
        val days = amountDaysSearchMenu.text.toString()

        loading.startLoading()

        pViewModel.geneticResults.observe(viewLifecycleOwner, Observer { daysMenu ->
            adapter.geneticResult = daysMenu
            adapter.notifyDataSetChanged()
            loading.stopLoading()

            if (adapter.itemCount == 0) {
                noMenuFound.visibility = View.VISIBLE
                seeMore.visibility = View.GONE

                recyclerViewConsulta.visibility = View.GONE
            } else {
                noMenuFound.visibility = View.GONE
                seeMore.visibility = View.VISIBLE

                recyclerViewConsulta.visibility = View.VISIBLE
            }
        })

        pViewModel.geneticAlgorithm(tamPop, days)
    }
}
