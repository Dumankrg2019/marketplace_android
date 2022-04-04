package kz.dev.marketplace_d

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kz.dev.marketplace_d.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.apply {
            ivCustomerBlock.setOnClickListener {
                Log.e("Error", "it's work")
            }
            ivSellerBlock.setOnClickListener {
                Log.e("Error", "from seller")
            }
        }
    }
}