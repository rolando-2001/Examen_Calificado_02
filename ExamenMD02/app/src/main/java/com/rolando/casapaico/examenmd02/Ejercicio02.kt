package com.rolando.casapaico.examenmd02

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rolando.casapaico.examenmd02.databinding.ActivityEjercicio02Binding

class Ejercicio02 : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio02Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio02Binding.inflate(layoutInflater)
        setContentView(binding.root)
        observeComponents()

    }
    fun observeComponents() {
        binding.btnSave.setOnClickListener {
            if (isEmptyInputs()) {
                Toast.makeText(this, "Hay algún campo vacío", Toast.LENGTH_SHORT).show()
            } else {
                goDetailActivity()
            }
        }
    }

    fun goDetailActivity() {
        val CustomerName= binding.edCustomerName.text.toString()
        val NamberCustomer= binding.edtNamberCustomer.text.toString()
        val Products= binding.edtProducts.text.toString()
        val City= binding.edtCity.text.toString()
        val Address= binding.edtAddress.text.toString()

        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(FULL_NAME_KEY, CustomerName)
        intent.putExtra(NUMBER_KEY, NamberCustomer)
        intent.putExtra(PRODUCT_KEY, Products)
        intent.putExtra(PRODUCT_KEY, City)
        intent.putExtra(ADDRESS_KEY, Address)
        startActivity(intent)
    }

    fun isEmptyInputs(): Boolean {
        return binding.edCustomerName.text.isEmpty() ||
                binding.edtNamberCustomer.text.isEmpty() ||
                binding.edtProducts.text.isEmpty() ||
                binding.edtCity.text.isEmpty() ||
                binding.edtAddress.text.isEmpty()
    }
}