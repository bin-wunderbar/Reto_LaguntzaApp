package com.example.reto.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.reto.R
import com.example.reto.databinding.ItemMessageBinding
import com.example.reto.modelo.Message


class MessageAdapter(private val user: String): RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {




    private var messages: List<Message> = emptyList()

    fun setData (list: List<Message>){
        messages= list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_message,
                parent,
                false
            )
        )


    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messages[position]
        holder.bind(message,user)
    }

    override fun getItemCount(): Int = messages.size

    class MessageViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemMessageBinding.bind(view)
        fun bind(message: Message,user:String) {
            if(user == message.from) {
                binding.miMenssage.visibility = View.VISIBLE
                binding.otroMenssage.visibility = View.GONE
                binding.myMessageTextView.text = message.message


            }else{
                binding.miMenssage.visibility = View.GONE
                binding.otroMenssage.visibility = View.VISIBLE

                binding.othersMessageTextView.text = message.message
            }
        }
    }
}