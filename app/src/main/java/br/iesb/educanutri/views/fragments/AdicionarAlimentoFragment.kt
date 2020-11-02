package br.iesb.educanutri.views.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.iesb.educanutri.R
import br.iesb.educanutri.aux_class.Masks
import br.iesb.educanutri.view_model.PrincipalViewModel
import br.iesb.educanutri.views.activities.MainActivity
import kotlinx.android.synthetic.main.fragment_adicionar_alimento.*

class AdicionarAlimentoFragment(context: Context, private val principalView: MainActivity) :
    Fragment() {

    private lateinit var group: String

    private val pViewModel: PrincipalViewModel by lazy {
        ViewModelProvider(this).get(PrincipalViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_adicionar_alimento, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Masks(getString(R.string.maskPreco), priceAddFood)

        spinnerFill()

        addFood.setOnClickListener { addFood() }

        backAddFood.setOnTouchListener { _, _ ->
            val inputMethodManager: InputMethodManager =
                requireActivity().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(activity?.currentFocus?.windowToken, 0)
        }
    }

    private fun spinnerFill() {
        //Acha o spinner pelo id
        val spinner: Spinner = spinnerGrupo

        //Cria um array adapter com o array que está no xml de strings
        context?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.arraySpinner,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                //Seta o meio de abertura do spinner: dropdown
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                //Coloca o adaptador no spinner
                spinner.adapter = adapter
            }
        }

        //Adiciona um listener no spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            //Se nada for selecionado, não faz nada
            override fun onNothingSelected(parent: AdapterView<*>?) {
                //
            }

            //Se algo for selecionado, alguns campos vão aparecer. Essa função recebe 4 parametros.
            //Os que mais importam pra gente são parent que é o adapterview com os itens do spinner
            // e a posição que é a que o usuário selecionou
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //Variável que pega o item que o usuário selecionou
                group = parent?.getItemAtPosition(position).toString()
            }
        }
    }

    private fun addFood() {
        val name = foodAddFood.text.toString()
        val price = priceAddFood.text.toString()
        val energy = energyFood.text.toString()
        val protein = proteinAddFood.text.toString()
        val fiber = fiberAddFood.text.toString()
        val lipids = lipidsAddFood.text.toString()
        val zinc = zincAddFood.text.toString()
        val magnesium = magnesiumAddFood.text.toString()
        val carbohydrate = carbohydrateAddFood.text.toString()
        val iron = ironAddFood.text.toString()
        val calcium = calciumAddFood.text.toString()

        pViewModel.saveNewFood(
            name,
            group,
            price,
            energy,
            protein,
            fiber,
            lipids,
            zinc,
            magnesium,
            carbohydrate,
            iron,
            calcium
        ) { response ->
            Toast.makeText(context, response[1], Toast.LENGTH_SHORT).show()

            if (response[0] == "OK") {
                foodAddFood.text.clear()
                priceAddFood.text.clear()
                energyFood.text.clear()
                proteinAddFood.text.clear()
                fiberAddFood.text.clear()
                lipidsAddFood.text.clear()
                zincAddFood.text.clear()
                magnesiumAddFood.text.clear()
                carbohydrateAddFood.text.clear()
                ironAddFood.text.clear()
                calciumAddFood.text.clear()
            }
        }
    }
}
