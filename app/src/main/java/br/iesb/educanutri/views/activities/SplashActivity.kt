package br.iesb.educanutri.views.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import br.iesb.educanutri.R
import br.iesb.educanutri.aux_class.LoadingProcess
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    private lateinit var loading: LoadingProcess

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        changeToLogin()
    }

    private fun changeToLogin() {
        loading = LoadingProcess(logoSplash, null)
        loading.startLoading()

        val intent = Intent(this, MainActivity::class.java)

        Handler().postDelayed({
            intent.change()
        }, 2000)
    }

    private fun Intent.change() {
        startActivity(this)
        finish()
    }
}
