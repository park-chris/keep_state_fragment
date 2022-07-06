package com.crystal.keepstatefragment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.crystal.keepstatefragment.R

class BookAdapter(
    private val context: Context,
    private val list: Array<String>,
): RecyclerView.Adapter<BookAdapter.ViewHolder>(){

    // FirstFragment에서 처리하기 위해 인터페이스 생성
    interface OnItemClickListener {
        fun onItemClick(book: String)
    }

    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val bookTextView: TextView = itemView.findViewById(R.id.book_text_view)

        fun bind(book: String) {
            bookTextView.text = book

            // 아이템 클릭 시 listener로 클릭된 아이템(book: String) 전달
            itemView.setOnClickListener {
                listener?.onItemClick(book)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.book_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = list[position]
        holder.bind(book)
    }

    override fun getItemCount() = list.size
}