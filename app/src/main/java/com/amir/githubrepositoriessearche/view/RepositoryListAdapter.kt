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
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.amir.githubrepositoriessearche.R
import com.amir.githubrepositoriessearche.model.data.Item

class RepositoryListAdapter(private val repositoryList: MutableList<Item>) :
    RecyclerView.Adapter<RepositoryListAdapter.ViewHolder>() {

    private val TAG = "RepositoryListAdapter"


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false)

        return ViewHolder(view)
    }

    @SuppressLint("LongLogTag")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "${repositoryList[position]}")

        holder.bind(repositoryList[position])

        if (position % 2 == 0) {
            holder.cvContainer.setCardBackgroundColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.white
                )
            )
        } else {
            holder.cvContainer.setCardBackgroundColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.anti_flash_white
                )
            )
        }
    }

    override fun getItemCount(): Int {

        return repositoryList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val title = itemView.findViewById<TextView>(R.id.tv_title) // Repository title
        private val owner = itemView.findViewById<TextView>(R.id.tv_owner) // repository author
        private val url = itemView.findViewById<TextView>(R.id.tv_url) // HTTP URL
        val cvContainer: CardView = itemView.findViewById(R.id.cv_container) // HTTP URL
        fun bind(data: Item) {


            title.text = data.fullName
            owner.text = data.owner?.login
            url.text = data.htmlUrl
              //opening the clicked repository
            itemView.setOnClickListener {
                Toast.makeText(itemView.context, "${data.fullName} clicked.", Toast.LENGTH_SHORT)
                    .show()

                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(data.htmlUrl))
                ContextCompat.startActivity(itemView.context, intent, null)
            }
        }
    }
}