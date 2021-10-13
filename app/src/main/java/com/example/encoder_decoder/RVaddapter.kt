package com.example.encoder_decoder

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class RVaddapter  (val phrases: ArrayList<String>):
RecyclerView.Adapter<RVaddapter.MessageViewHolder>() {
    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val phrase = phrases[position]

        holder.itemView.apply {
            if(position % 2 == 1){
                text.setTextColor(Color.BLUE)
            }else {
                text.setTextColor(Color.BLACK)
            }
            text.text = phrase
        }
    }

    override fun getItemCount()= phrases.size
}