package com.example.randomquote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.randomquote.databinding.FragmentFirstBinding
import com.example.randomquote.model.OrderViewModel


class FirstFragment : Fragment() {

    private val viewModel: OrderViewModel by viewModels()

    private var _binding: FragmentFirstBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.quoteStatus.observe(viewLifecycleOwner){
            binding.quote.text = it.quote
            binding.author.text = it.author
        }

        binding.next.setOnClickListener{
            viewModel.getQuoteData()

        }
    }


}