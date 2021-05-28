package com.fatmasatyani.moca.splashscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.fatmasatyani.moca.R
import com.fatmasatyani.moca.databinding.FragmentSplashScreenBinding


class SplashScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentSplashScreenBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        Handler(Looper.getMainLooper()).postDelayed({
//            findNavController().navigate(R.id.action_splashScreenFragment_to_homeFragment)
//        },2000)
//    }
        lifecycleScope.launchWhenResumed {
            findNavController().navigate(R.id.action_splashScreenFragment_to_homeFragment)
        }
    }
}
