package com.amir.githubrepositoriessearche.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.amir.githubrepositoriessearche.R
import com.amir.githubrepositoriessearche.databinding.ActivityMainBinding
import com.amir.githubrepositoriessearche.model.GithubService
import com.amir.githubrepositoriessearche.model.data.GithubResponse
import com.amir.githubrepositoriessearche.model.data.Item
import com.amir.githubrepositoriessearche.viewModel.ListViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var repoList: MutableList<Item>
    private lateinit var repoAdapter: RepositoryListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()

        binding.search.setOnClickListener {
            val q = binding.keyword.text.toString()

            // To show a new result every time you search
            repoList = mutableListOf()

            // LiveData use
            val response = GithubService().getRepository(q)
            response.observe(this) { response ->
                response.items.let {
                    for (item in it) {
                        repoList.add(item)
                    }
                }

                repoAdapter = RepositoryListAdapter(repoList)
                binding.viewResult.apply {
                    layoutManager =
                        LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    adapter = repoAdapter
                }

                if (repoAdapter.itemCount == 0) {
                    Toast.makeText(this, "Nothing Found.", Toast.LENGTH_SHORT).show()
                }
            }

            // EditText clear
            binding.keyword.text?.clear()
        }
    }
}