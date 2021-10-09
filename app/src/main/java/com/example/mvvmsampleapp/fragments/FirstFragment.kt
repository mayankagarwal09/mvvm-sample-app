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
import com.example.mvvmsampleapp.di.qualifiers.LinearAdapter
import com.example.mvvmsampleapp.viewModels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    @Inject
    lateinit var layoutManager: LinearLayoutManager

    @LinearAdapter
    @Inject
    lateinit var adapter: ItemAdapter
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)

        binding.linearRecyclerView.layoutManager = layoutManager

        binding.linearRecyclerView.adapter = adapter

        mainViewModel.itemList.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })

        return binding.root
    }

}