package com.astashin.bookvoed.components.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment

import com.astashin.bookvoed.R
import com.astashin.bookvoed.bookvoedApp
import com.astashin.bookvoed.databinding.FragmentLoginBinding
import javax.inject.Inject

class LoginFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: LoginViewModel

    private val loggedIn = Observer<Boolean> {
        goNext(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bookvoedApp().appComponent.inject(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory)[LoginViewModel::class.java]

        viewModel.loggedIn.observe(this, loggedIn)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {
        val binding: FragmentLoginBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.viewmodel = viewModel
        return binding.root
    }

    private fun goNext(loggedIn: Boolean) {
        if(loggedIn)
            NavHostFragment.findNavController(this).navigate(R.id.login_finish)
    }
}
