package br.iesb.educanutri.views.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.iesb.educanutri.R
import br.iesb.educanutri.data_class.Food
import br.iesb.educanutri.view_model.PrincipalViewModel
import br.iesb.educanutri.views.adapters.FoodsAdapter
import kotlinx.android.synthetic.main.fragment_food.*

class FoodFragment(private val food: Food, private val adapter: FoodsAdapter) : Fragment() {
    private val pViewModel: PrincipalViewModel by lazy {
        ViewModelProvider(this).get(PrincipalViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameFood.text = food.name
        group.text = food.group
        price.text = food.price.toString()
        calcium.text = food.calcium.toString()
        carbohydrate.text = food.carbohydrate.toString()
        energy.text = food.energy.toString()
        fiber.text = food.fiber.toString()
        iron.text = food.iron.toString()
        lipids.text = food.lipids.toString()
        magnesium.text = food.magnesium.toString()
        protein.text = food.protein.toString()
        zinc.text = food.zinc.toString()

        closeFood.setOnClickListener { this.dismiss() }
        deleteFood.setOnClickListener { delete() }
    }

    private fun dismiss() {
        val manager = activity?.supportFragmentManager

        manager?.findFragmentByTag("foodFragment")?.let {
            manager.beginTransaction().remove(it).commit()
        }
    }

    private fun delete() {
        food.id?.let {
            pViewModel.deleteFood(it) { response ->
                Toast.makeText(context, response[1], Toast.LENGTH_SHORT).show()

                if (response[0] == "OK") {
                    adapter.foodSet.remove(food)
                    adapter.notifyDataSetChanged()
                }

                dismiss()
            }
        }
    }
}