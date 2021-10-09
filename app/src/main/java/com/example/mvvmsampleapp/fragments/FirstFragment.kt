package com.example.mvvmsampleapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmsampleapp.adapters.ItemAdapter
import com.example.mvvmsampleapp.constants.Status
import com.example.mvvmsampleapp.databinding.FragmentFirstBinding
import com.example.mvvmsampleapp.viewModels.MainViewModel

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    lateinit var adapter: ItemAdapter
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)

        val layoutManager = LinearLayoutManager(requireContext())
        adapter = ItemAdapter(layoutManager)
        binding.linearRecyclerView.layoutManager = layoutManager

        binding.linearRecyclerView.adapter = adapter

        mainViewModel.itemList.observe(viewLifecycleOwner, {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    it.data?.let { items -> adapter.submitList(items) }
                    binding.linearRecyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.linearRecyclerView.visibility = View.GONE
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