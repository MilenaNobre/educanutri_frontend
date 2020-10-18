package br.iesb.educanutri.views.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import br.iesb.educanutri.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mPagerAdapter: PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        consultaBtn.setOnClickListener {
            dismissFragments()
            mViewPager.currentItem = 0
        }
        adicionarAlimentoBtn.setOnClickListener {
            dismissFragments()
            mViewPager.currentItem = 1
        }
        SobreNosBtn.setOnClickListener {
            dismissFragments()
            mViewPager.currentItem = 2
        }

        mPagerAdapter = PagerViewAdapter(supportFragmentManager, applicationContext, this)
        mViewPager.adapter = mPagerAdapter
        mViewPager.offscreenPageLimit = 3

        mViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                dismissFragments()
                changingTabs(position)
            }
        })
        //default
        mViewPager.currentItem = 0
        consultaBtn.setImageResource(R.drawable.ic_talher_c)
    }
    private fun dismissFragments() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)

        val manager = supportFragmentManager

        manager.findFragmentByTag("newFood")?.let { it1 ->
            manager.beginTransaction().remove(
                it1
            ).commit()
        }

        manager.findFragmentByTag("sharedFragment")?.let { it1 ->
            manager.beginTransaction().remove(
                it1
            ).commit()
        }
    }

    private fun changingTabs(position: Int) {
        if (position == 0) {
            consultaBtn.setImageResource(R.drawable.ic_talher_c)
            adicionarAlimentoBtn.setImageResource(R.drawable.ic_add_menu)
            SobreNosBtn.setImageResource(R.drawable.ic_menu_book_24)

        } else if (position == 1) {
            consultaBtn.setImageResource(R.drawable.ic_talher_24)
            adicionarAlimentoBtn.setImageResource(R.drawable.ic_add_menu_c)
            SobreNosBtn.setImageResource(R.drawable.ic_menu_book_24)

        } else if (position == 2) {
            consultaBtn.setImageResource(R.drawable.ic_talher_24)
            adicionarAlimentoBtn.setImageResource(R.drawable.ic_add_menu)
            SobreNosBtn.setImageResource(R.drawable.ic_menu_book_c)

        }
    }
}