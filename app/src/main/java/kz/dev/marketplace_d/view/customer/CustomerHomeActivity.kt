package kz.dev.marketplace_d.view.customer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kz.dev.marketplace_d.R
import kz.dev.marketplace_d.databinding.ActivityCustomerHomeBinding
import kz.dev.marketplace_d.view.customer.main_customer_fragment.MainCustomerFragment

class CustomerHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomerHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomerHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val bottomNavigationView = binding.bottomNav
        val navController = findNavController(R.id.fragment)


        bottomNavigationView.setupWithNavController(navController)

    }
}