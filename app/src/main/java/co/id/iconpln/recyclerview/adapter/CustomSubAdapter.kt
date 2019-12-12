package co.id.iconpln.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.id.iconpln.recyclerview.R
import co.id.iconpln.recyclerview.model.MemberSub

class CustomSubAdapter(private val context: Context, private val memberSubs: List<MemberSub>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return memberSubs.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val footer = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout_view_sub, parent, false)
        return CustomSubViewHolder(footer)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val (status) = memberSubs[position]
    }

    class CustomSubViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

}