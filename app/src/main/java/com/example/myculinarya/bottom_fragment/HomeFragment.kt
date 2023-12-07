package com.example.myculinarya.bottom_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myculinarya.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view =  inflater.inflate(R.layout.fragment_home, container, false)

        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.bottom_home -> {
                    replaceFragment(HomeFragment())
                    activity?.title = "Home"
                }
                R.id.bottom_add -> {
                    replaceFragment(AddResepFragment())
                    activity?.title = "Add Resep"
                }
                R.id.bottom_resep -> {
                    replaceFragment(ResepFragment())
                    activity?.title = "Resep"
                }
            }
            true
        }

        replaceFragment(HomeFragment())
        activity?.title = "Home"
        bottomNavigationView.selectedItemId = R.id.bottom_home

        return view
    }

    private fun replaceFragment(fragment: Fragment){
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.bottomFragment,fragment)
            .commit()
    }

}