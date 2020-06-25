package io.github.alanrb.concatadapter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.alanrb.concatadapter.R
import kotlinx.android.synthetic.main.item_note.view.*

/**
 * Created by Tuong (Alan) on 6/25/20.
 * Copyright (c) 2020 Buuuk. All rights reserved.
 */

class NoteAdapter(
    private val message: String,
    private val onDismissClicked: () -> Unit
) :
    RecyclerView.Adapter<NoteAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemViewHolder(parent)

    override fun getItemCount() = 1

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
    }

    inner class ItemViewHolder(
        parent: ViewGroup,
        private val rootView: View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_note,
            parent,
            false
        )
    ) : RecyclerView.ViewHolder(rootView) {

        init {
            rootView.apply {
                tvMessage.text = message
                dismiss.setOnClickListener { onDismissClicked() }
            }
        }
    }
}