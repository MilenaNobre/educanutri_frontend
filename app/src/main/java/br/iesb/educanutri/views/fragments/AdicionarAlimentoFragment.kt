package br.iesb.educanutri.views.fragments

//import br.iesb.educanutri.view_model.PlaylistViewModel
//import br.iesb.educanutri.views.adapter.MusicAdapter
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.iesb.educanutri.R
import br.iesb.educanutri.aux_class.Masks
import br.iesb.educanutri.views.activities.MainActivity
import kotlinx.android.synthetic.main.fragment_adicionar_alimento.*

class AdicionarAlimentoFragment (context: Context, private val principalView: MainActivity) : Fragment() {

    private lateinit var grupo: String
//    private val viewModelP: PlaylistViewModel by lazy {
//        ViewModelProvider(this).get(PlaylistViewModel::class.java)
//    }

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

        Masks(getString(R.string.maskPreco), inpPreco)

        spinnerFill()

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
                grupo = parent?.getItemAtPosition(position).toString()


            }
        }
    }

}
