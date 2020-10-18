package br.iesb.educanutri.views.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import br.iesb.educanutri.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        changetoLogin()
    }

    private fun changetoLogin() {
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
