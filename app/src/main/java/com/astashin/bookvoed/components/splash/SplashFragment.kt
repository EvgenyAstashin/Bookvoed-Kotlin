package com.astashin.bookvoed.components.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment

import com.astashin.bookvoed.R
import com.astashin.bookvoed.bookvoedApp
import com.astashin.bookvoed.databinding.FragmentSplashBinding
import javax.inject.Inject

class SplashFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: SplashViewModel

    private val loggedInObserver = Observer<Boolean> { loggedIn ->
        goNext(loggedIn)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        bookvoedApp().appComponent.inject(this)
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[SplashViewModel::class.java]

        viewModel.userLoggedIn.observe(this, loggedInObserver)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentSplashBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_splash, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.checkUser()
    }

    private fun goNext(loggedIn: Boolean) {
        if(loggedIn)
            NavHostFragment.findNavController(this).navigate(R.id.go_to_main)
        else
            NavHostFragment.findNavController(this).navigate(R.id.go_to_login)
    }


}
