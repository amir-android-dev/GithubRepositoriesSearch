package com.amir.githubrepositoriessearche.view
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.amir.githubrepositoriessearche.databinding.ActivityMainBinding
import com.amir.githubrepositoriessearche.model.GithubService
import com.amir.githubrepositoriessearche.model.data.Item

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var repoList: MutableList<Item>
    private lateinit var repoAdapter: RepositoryListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fetchingDataAndPassingToRecyclerView()
    }


    private fun fetchingDataAndPassingToRecyclerView(){

        binding.search.setOnClickListener {
            val q = binding.keyword.text.toString()

            // To show a new result every time you search
            repoList = mutableListOf()
            binding.tvNothingFound.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
            // LiveData use
            val response = GithubService().getRepository(q)
            response.observe(this) { response ->
                response.items.let {
                    for (item in it) {
                        repoList.add(item)
                    }
                }
                //setting up the recyclerView
                binding.progressBar.visibility = View.GONE
                repoAdapter = RepositoryListAdapter(repoList)
                binding.viewResult.apply {
                    layoutManager =
                        LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    adapter = repoAdapter
                }
                if (repoAdapter.itemCount == 0) {
                    binding.tvNothingFound.visibility = View.VISIBLE
                }
            }
            // EditText clear
            binding.keyword.text?.clear()
        }
    }
}