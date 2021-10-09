package com.example.mvvmsampleapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmsampleapp.adapters.ItemAdapter
import com.example.mvvmsampleapp.databinding.FragmentFirstBinding
import com.example.mvvmsampleapp.viewModels.MainViewModel


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var adapter: ItemAdapter
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)

        val layoutManager = LinearLayoutManager(requireContext())
        binding.linearRecyclerView.layoutManager = layoutManager
        adapter = ItemAdapter(layoutManager)
        binding.linearRecyclerView.adapter = adapter

        mainViewModel.itemList.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })

        return binding.root
    }

}