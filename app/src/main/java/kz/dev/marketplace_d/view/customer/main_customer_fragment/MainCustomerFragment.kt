package kz.dev.marketplace_d.view.customer.main_customer_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kz.dev.marketplace_d.databinding.FragmentMainCustomerBinding
import kz.dev.marketplace_d.viewmodel.GoodsViewModel


class MainCustomerFragment : Fragment() {

    private var _binding: FragmentMainCustomerBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: GoodsViewModel
    private val goodAdapter = GoodsMainAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainCustomerBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)
            .get(GoodsViewModel::class.java)
        viewModel.refresh()

        binding.rvGoods.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = goodAdapter
        }
        observeViewModel()
    }

    private fun observeViewModel() {

        viewModel.goods.observe(viewLifecycleOwner, {goods ->

            goods?.let{

                binding.rvGoods.visibility = View.VISIBLE
                goodAdapter.updateGoods(it)
            }
        })

        viewModel.goodsLoadedError.observe(viewLifecycleOwner, { isError ->

            isError?.let{

                binding.tvErrorGoods.visibility =if(it) View.VISIBLE else View.GONE
            }
        })

        viewModel.loading.observe(viewLifecycleOwner, { isLoading ->

            isLoading?.let {

                binding.progressBar.visibility = if(it) View.VISIBLE else View.GONE
                if(it) {
                    binding.tvErrorGoods.visibility = View.GONE
                    binding.rvGoods.visibility = View.GONE
                }
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainCustomerFragment()
    }
}