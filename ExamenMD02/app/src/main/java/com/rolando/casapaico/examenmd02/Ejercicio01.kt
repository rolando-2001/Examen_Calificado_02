package com.rolando.casapaico.examenmd02



import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.rolando.casapaico.examenmd02.databinding.ActivityDetailBinding
import com.rolando.casapaico.examenmd02.databinding.ActivityEjercicio01Binding


class Ejercicio01 : AppCompatActivity() {
    private lateinit var cardView: CardView
   private lateinit var binding: ActivityEjercicio01Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityEjercicio01Binding.inflate(layoutInflater)
        setContentView(binding.root)

        cardView = findViewById(R.id.cardView)

        val btnShow = findViewById<Button>(R.id.btnMostrar)
        val btnHide = findViewById<Button>(R.id.btnOcultar)

        btnShow.setOnClickListener { showCardView() }
        btnHide.setOnClickListener { hideCardView() }
    }

    private fun showCardView() {
        cardView.visibility = View.VISIBLE
    }

    private fun hideCardView() {
        cardView.visibility = View.GONE
    }

}