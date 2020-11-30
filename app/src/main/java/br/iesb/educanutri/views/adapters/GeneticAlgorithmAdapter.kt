package br.iesb.educanutri.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.iesb.educanutri.R
import br.iesb.educanutri.repository.DayMenuDTO
import kotlinx.android.synthetic.main.genetic_algorithm_result.view.*

class GeneticAlgorithmAdapter(var geneticResult: MutableList<DayMenuDTO>) :
    RecyclerView.Adapter<GeneticAlgorithmAdapter.GeneticAlgorithmViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GeneticAlgorithmViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.genetic_algorithm_result, parent, false)

        return GeneticAlgorithmViewHolder(view)
    }

    override fun getItemCount(): Int {
        return geneticResult.size
    }

    override fun onBindViewHolder(holder: GeneticAlgorithmViewHolder, position: Int) {
        val dayResult = geneticResult[position]

        holder.firstBreakfast.text = dayResult.breakfast?.get(0)?.nome
        holder.secondBreakfast.text = dayResult.breakfast?.get(1)?.nome
        holder.thirdBreakfast.text = dayResult.breakfast?.get(2)?.nome

        holder.firstLunch.text = dayResult.lunch?.get(0)?.nome
        holder.secondLunch.text = dayResult.lunch?.get(1)?.nome
        holder.thirdLunch.text = dayResult.lunch?.get(2)?.nome
        holder.fourthLunch.text = dayResult.lunch?.get(3)?.nome
        holder.fifthLunch.text = dayResult.lunch?.get(4)?.nome
        holder.sixthLunch.text = dayResult.lunch?.get(5)?.nome
        holder.seventhLunch.text = dayResult.lunch?.get(6)?.nome

        holder.firstSnack.text = dayResult.snack?.get(0)?.nome
        holder.secondSnack.text = dayResult.snack?.get(1)?.nome
        holder.thirdSnack.text = dayResult.snack?.get(2)?.nome
    }

    class GeneticAlgorithmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val firstBreakfast: TextView = itemView.firstBreakfast
        val secondBreakfast: TextView = itemView.secondBreakfast
        val thirdBreakfast: TextView = itemView.thirdBreakfast

        val firstLunch: TextView = itemView.firstLunch
        val secondLunch: TextView = itemView.secondLunch
        val thirdLunch: TextView = itemView.thirdLunch
        val fourthLunch: TextView = itemView.fourthLunch
        val fifthLunch: TextView = itemView.fifthLunch
        val sixthLunch: TextView = itemView.sixthLunch
        val seventhLunch: TextView = itemView.seventhLunch

        val firstSnack: TextView = itemView.firstSnack
        val secondSnack: TextView = itemView.secondSnack
        val thirdSnack: TextView = itemView.thirdSnack
    }
}