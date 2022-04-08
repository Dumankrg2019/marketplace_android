package kz.dev.marketplace_d

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kz.dev.marketplace_d.databinding.ActivityMainBinding
import kz.dev.marketplace_d.view.customer.CustomerHomeActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.apply {
            ivSellerBlock.setOnClickListener {
                Log.e("Error", "from seller")
            }
        }
        binding.ivCustomerBlock.setOnClickListener {
            Log.e("Error", "it's work")
            val i = Intent(this, CustomerHomeActivity::class.java)
            startActivity(i)
        }
    }
}