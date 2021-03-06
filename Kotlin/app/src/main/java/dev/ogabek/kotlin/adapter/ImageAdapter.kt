package dev.ogabek.kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.kotlin.R
import dev.ogabek.kotlin.activity.MainActivity
import dev.ogabek.kotlin.model.Image

class ImageAdapter(var mainActivity: MainActivity, var images: List<Image>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val image: Image = images[position]
        if (holder is ImageViewHolder) {
            holder.picture.setImageResource(image.image)
            mainActivity.setImageHeight(holder.picture)
        }
    }

    override fun getItemCount(): Int {
        return images.size
    }

    private inner class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var picture: ImageView = view.findViewById(R.id.ll_image)

    }

}
