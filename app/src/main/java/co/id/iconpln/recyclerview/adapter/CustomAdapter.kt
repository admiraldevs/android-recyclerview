package co.id.iconpln.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.id.iconpln.recyclerview.R
import co.id.iconpln.recyclerview.model.Member
import co.id.iconpln.recyclerview.model.MemberSub
import kotlinx.android.synthetic.main.item_custom_layout.view.*

class CustomAdapter(val context: Context, val members: List<Member>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ITEM_VIEW = 0
    private val TYPE_ITEM_LIST = 1

    override fun getItemCount(): Int {
        return members.size
    }

    override fun getItemViewType(position: Int): Int {
        val member = members[position]
        return if (member.memberSubs.size > 0) TYPE_ITEM_LIST else TYPE_ITEM_VIEW
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == TYPE_ITEM_LIST){
            val header = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout_list, parent, false)
            return CustomListHolder(header)
        }

        val footer = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout_view, parent, false)
        return  CustomViewHolder(footer)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val member = members.get(position)

        if(holder is CustomViewHolder){

        }

        if(holder is CustomListHolder){
            val recyclerView = holder.recyclerView
            recyclerView.layoutManager = GridLayoutManager(context, 1)

            val memberSubs = member.memberSubs
            refreshSubAdapter(recyclerView, memberSubs)
        }
    }

    private fun refreshSubAdapter(recyclerView: RecyclerView, memberSubs: List<MemberSub>) {
        val adapter = CustomSubAdapter(context, memberSubs)
        recyclerView.adapter = adapter
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    class CustomListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var recyclerView: RecyclerView

        init {
            // add your UI Component here
            recyclerView = itemView.findViewById(R.id.recyclerView)
        }
    }

}