package br.iesb.educanutri.views.activities

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import br.iesb.educanutri.R
import br.iesb.educanutri.view_model.PrincipalViewModel
import br.iesb.educanutri.views.adapters.FoodsAdapter
import kotlinx.android.synthetic.main.activity_private_area.*

class PrivateAreaActivity : AppCompatActivity() {
    private val pViewModel: PrincipalViewModel by lazy {
        ViewModelProvider(this).get(PrincipalViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_private_area)

        initRecyclerView()

        foodNotFound.visibility = View.GONE
    }

    private fun initRecyclerView() {
        recyclerViewPrivateArea.layoutManager = GridLayoutManager(this, 2)
        val adapter = FoodsAdapter(mutableListOf(), this)
        recyclerViewPrivateArea.adapter = adapter

        pViewModel.foods.observe(this, Observer { foods ->
            adapter.foodSet.clear()
            adapter.foodSet = foods
            adapter.notifyDataSetChanged()

            if (adapter.itemCount == 0) {
                foodNotFound.visibility = View.VISIBLE
            } else {
                foodNotFound.visibility = View.GONE
            }
        })

        pViewModel.getAllFoods()
    }
}