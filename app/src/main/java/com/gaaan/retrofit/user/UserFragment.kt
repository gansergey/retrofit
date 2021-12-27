package com.gaaan.retrofit.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.gaaan.retrofit.data.GitHubUserDetail
import com.gaaan.retrofit.data.GitHubUsersRepositoryFactory
import com.gaaan.retrofit.databinding.FragmentUserBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment(login: String) : MvpAppCompatFragment(), UserView {

    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!

    private val presenter by moxyPresenter {
        UserPresenter(login, GitHubUsersRepositoryFactory.create())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun newInstance(login: String) =
            UserFragment(login)
    }

    override fun showUserDetail(user: GitHubUserDetail) {
        binding.fragmentUserSysAdminTextView.text = user.siteAdmin.toString()
    }

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}