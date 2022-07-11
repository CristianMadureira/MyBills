package com.example.mybills.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mybills.R
import com.example.mybills.data.db.BillEntity
import com.vicmikhailau.maskededittext.MaskedFormatter
import kotlinx.coroutines.flow.Flow

class BillsAdapter : androidx.recyclerview.widget.ListAdapter<BillEntity,
        BillsAdapter.MyViewHolder>(BillsDiffUtils) {

    private var deleteClickListener: ((BillEntity) -> Unit)? = null


    fun setDeleteClickListener(click: (BillEntity) -> Unit){
        this.deleteClickListener = click
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.bills_adapter, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItem(getItem(position))
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.editName)
        val value = itemView.findViewById<TextView>(R.id.editValue)
        val dueDate = itemView.findViewById<TextView>(R.id.editDueDate)
        val deleteButton = itemView.findViewById<ImageView>(R.id.iconDelete)

        fun bindItem(bill: BillEntity) {
            name.text = bill.name
            value.text = "R$ " + bill.value.toString()
            dueDate.text = bill.dueDate

            deleteButton.setOnClickListener{
                deleteClickListener?.invoke(bill)
            }
        }
    }
}

object BillsDiffUtils : DiffUtil.ItemCallback<BillEntity>() {
    override fun areItemsTheSame(oldItem: BillEntity, newItem: BillEntity): Boolean =
        (oldItem.id == newItem.id)

    override fun areContentsTheSame(oldItem: BillEntity, newItem: BillEntity): Boolean =
        oldItem == newItem
}

