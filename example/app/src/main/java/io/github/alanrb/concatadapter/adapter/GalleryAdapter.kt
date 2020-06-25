package io.github.alanrb.concatadapter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.github.alanrb.concatadapter.Gallery
import io.github.alanrb.concatadapter.R
import kotlinx.android.synthetic.main.item_gallery.view.*

/**
 * Created by Tuong (Alan) on 6/25/20.
 * Copyright (c) 2020 Buuuk. All rights reserved.
 */

class GalleryAdapter() : RecyclerView.Adapter<GalleryAdapter.ItemViewHolder>() {

    var items: List<Gallery> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemViewHolder(parent)

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ItemViewHolder(
        parent: ViewGroup,
        private val rootView: View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_gallery,
            parent,
            false
        )
    ) : RecyclerView.ViewHolder(rootView) {

        fun bind(item: Gallery) {
            rootView.apply {
                Glide.with(context).load(item.img).into(img)
            }
        }
    }
}