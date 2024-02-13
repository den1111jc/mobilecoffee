package com.example.mycoffee.presentation.Tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.example.mycoffee.R
import com.example.mycoffee.databinding.HomeBinding
import com.example.mycoffee.presentation.Proposal.ProposalAdapter
import com.google.android.material.tabs.TabLayoutMediator

class Home : Fragment() {

    private var binding:HomeBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.home, container, false)

        binding?.slider?.adapter = ProposalAdapter(context as FragmentActivity)

        val tabLayoutMediator = binding?.tabSlider?.let {
            binding?.slider?.let { it1 ->
                TabLayoutMediator(it,
                    it1,
                    TabLayoutMediator.TabConfigurationStrategy { tab, position -> })
            }
        }
        tabLayoutMediator?.attach()

        return binding?.root
    }


}