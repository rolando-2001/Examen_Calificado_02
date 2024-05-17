package com.rolando.casapaico.examenmd02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rolando.casapaico.examenmd02.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding= ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intent.extras?.let { showData(it) }
        listenerComponentsUI()

    }

    private fun showData(paramExtras:  Bundle) {
        val fullName = paramExtras.getString(FULL_NAME_KEY)
        val number = paramExtras.getString(NUMBER_KEY)
        val product = paramExtras.getString(PRODUCT_KEY)
        val address = paramExtras.getString(ADDRESS_KEY)

        binding.tvFullName.text = fullName
        binding.tvNumber.text = number
        binding.tvProducts.text = product
        binding.tvAddress.text = address
    }
    private fun listenerComponentsUI() {
        binding.btnAdres.setOnClickListener {
            openGoogleMaps()
        }

        binding.btnPhone.setOnClickListener {
            Call()
        }
        binding.btnWhatsapp.setOnClickListener {
            WhatsappMessage()
        }



    }
    private fun Call() {
        val phoneNumber = binding.tvNumber.text.toString()
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:+51$phoneNumber")
        startActivity(intent)
    }

    private fun WhatsappMessage() {
        val phoneNumber = binding.tvNumber.text.toString()
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber")
        startActivity(intent)
    }
    private fun openGoogleMaps() {
        val gmmIntentUri = Uri.parse("geo:0,0?q=Googleplex,Mountain+View,California")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        if (mapIntent.resolveActivity(packageManager) != null) {
            startActivity(mapIntent)
        } else {

            val playStoreIntent = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.google.android.apps.maps"))
            startActivity(playStoreIntent)
        }
    }


}