package com.example.mvvmsampleapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mvvmsampleapp.adapters.ItemAdapter
import com.example.mvvmsampleapp.databinding.FragmentSecondBinding
import com.example.mvvmsampleapp.viewModels.MainViewModel

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private lateinit var adapter: ItemAdapter
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(layoutInflater, container, false)

        val layoutManager = GridLayoutManager(requireContext(), 3)
        binding.gridRecyclerView.layoutManager = layoutManager
        adapter = ItemAdapter(layoutManager)
        binding.gridRecyclerView.adapter = adapter

        mainViewModel.itemList.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })

        return binding.root
    }
}