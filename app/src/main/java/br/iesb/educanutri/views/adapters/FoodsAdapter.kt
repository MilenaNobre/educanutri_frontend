package br.iesb.educanutri.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import br.iesb.educanutri.R
import br.iesb.educanutri.data_class.Food
import br.iesb.educanutri.views.fragments.FoodFragment
import kotlinx.android.synthetic.main.foods_adapter.view.*

class FoodsAdapter(var foodSet: MutableList<Food>, private val activity: FragmentActivity?) :
    RecyclerView.Adapter<FoodsAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.foods_adapter, parent, false)

        return FoodViewHolder(view)
    }

    override fun getItemCount(): Int {
        return foodSet.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.name.text = foodSet[position].name
        holder.price.text = activity?.getString(R.string.value, foodSet[position].price.toString())
        holder.group.text = foodSet[position].group

        holder.itemView.setOnClickListener {
            val manager = activity?.supportFragmentManager

            val fragment = FoodFragment(foodSet[position], this)

            manager?.beginTransaction()?.add(R.id.backPrivateArea, fragment, "foodFragment")
                ?.commit()
        }
    }

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.nameFood
        val price: TextView = itemView.priceFood
        val group: TextView = itemView.groupFood
    }
}