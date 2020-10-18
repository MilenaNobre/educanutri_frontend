package br.iesb.educanutri.views.activities

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import br.iesb.educanutri.views.activities.MainActivity
import br.iesb.educanutri.views.fragments.ConsultaFragment
import br.iesb.educanutri.views.fragments.AdicionarAlimentoFragment
import br.iesb.educanutri.views.fragments.SobreNosFragment
internal class PagerViewAdapter(
    fm: FragmentManager,
    private val context: Context,
    private val view: MainActivity
) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                ConsultaFragment(
                    context,
                    view
                )
            }
            1 -> {
                AdicionarAlimentoFragment(
                    context,
                    view
                )
            }
            2 -> {
                SobreNosFragment(
                    context,
                    view
                )
            }
            else -> ConsultaFragment(
                context,
                view
            )
        }
    }

    override fun getCount(): Int {
        return 3;
    }


}