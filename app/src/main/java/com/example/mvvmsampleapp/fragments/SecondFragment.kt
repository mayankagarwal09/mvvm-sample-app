package com.example.mvvmsampleapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mvvmsampleapp.adapters.ItemAdapter
import com.example.mvvmsampleapp.constants.Status
import com.example.mvvmsampleapp.databinding.FragmentSecondBinding
import com.example.mvvmsampleapp.viewModels.MainViewModel

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    lateinit var adapter: ItemAdapter
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(layoutInflater, container, false)

        val layoutManager = GridLayoutManager(requireContext(), 3)
        adapter = ItemAdapter(layoutManager)
        binding.gridRecyclerView.layoutManager = layoutManager
        binding.gridRecyclerView.adapter = adapter

        mainViewModel.itemList.observe(viewLifecycleOwner, {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    it.data?.let { items -> adapter.submitList(items) }
                    binding.gridRecyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.gridRecyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                }
            }
        })

        return binding.root
    }
}