package com.amir.githubrepositoriessearche.view

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.amir.githubrepositoriessearche.R
import com.amir.githubrepositoriessearche.model.data.Item

class RepositoryListAdapter(private val repositoryList: MutableList<Item>) :
    RecyclerView.Adapter<RepositoryListAdapter.ViewHolder>() {

    private val TAG = "RepositoryListAdapter"
    var repName = ""
    var owner = ""
    var url = ""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false)

        return ViewHolder(view)
    }

    @SuppressLint("LongLogTag")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "${repositoryList[position]}")

        holder.bindInfo(repositoryList[position])
    }

    override fun getItemCount(): Int {

        return repositoryList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindInfo(data: Item) {
            val title = itemView.findViewById<TextView>(R.id.tv_title) // Repository title
            val owner = itemView.findViewById<TextView>(R.id.tv_owner) // repository author
            val url = itemView.findViewById<TextView>(R.id.tv_url) // HTTP URL

            title.text = data.fullName
            owner.text = data.owner?.login
            url.text = data.htmlUrl

            itemView.setOnClickListener {
                Toast.makeText(itemView.context, "${data.fullName} clicked.", Toast.LENGTH_SHORT)
                    .show()

                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(data.htmlUrl))
                ContextCompat.startActivity(itemView.context, intent, null)
            }
        }
    }
}