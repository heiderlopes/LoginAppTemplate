package br.com.heiderlopes.loginapptemplate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var animacaoDoMascote : Animation
    private lateinit var animacaoDoFormulario : Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        iniciarListener()
        iniciarAnimacao()
    }

    private fun iniciarListener() {
        btLogin.setOnClickListener {

        }

        etPassword.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                ivLogin.speed = 2f
                ivLogin.setMinAndMaxProgress(0.0f, 0.65f)
            } else {
                ivLogin.speed = 1f
                ivLogin.setMinAndMaxProgress(0.65f, 1.0f)
            }
            ivLogin.playAnimation()
        }
    }

    private fun iniciarAnimacao() {
        animacaoDoMascote = AnimationUtils.loadAnimation(this,
            R.anim.frombottom
        )
        animacaoDoFormulario = AnimationUtils.loadAnimation(this,
            R.anim.frombottom2
        )

        containerLogin.startAnimation(animacaoDoMascote)
        ivLogin.startAnimation(animacaoDoFormulario)
    }

    private fun shake() {
        val animShake = AnimationUtils.loadAnimation(this, R.anim.shake)
        containerLogin.startAnimation(animShake)
    }

}