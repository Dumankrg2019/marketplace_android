package kz.dev.marketplace_d.view.customer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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


        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, MainCustomerFragment.newInstance())
            .commit()
    }
}