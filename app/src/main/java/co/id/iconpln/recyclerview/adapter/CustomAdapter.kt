package co.id.iconpln.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.id.iconpln.recyclerview.R
import co.id.iconpln.recyclerview.model.Member
import kotlinx.android.synthetic.main.item_custom_layout.view.*

class CustomAdapter(val members: List<Member>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ITEM_HEADER = 0
    private val TYPE_AVAILABLE_YES = 1
    private val TYPE_AVAILABLE_NOT = 2
    private val TYPE_ITEM_FOOTER = 3

    override fun getItemCount(): Int {
        return members.size
    }

    override fun getItemViewType(position: Int): Int {
        if(isHeader(position)) return TYPE_ITEM_HEADER
        if(isFooter(position)) return TYPE_ITEM_FOOTER

        val member = members[position]
        return if (member.available) TYPE_AVAILABLE_YES else TYPE_AVAILABLE_NOT
    }

    fun isHeader(position: Int): Boolean{
        return position == 0
    }

    fun isFooter(position: Int): Boolean {
        return position == members.size - 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == TYPE_ITEM_HEADER){
            val header = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout_header, parent, false)
            return CustomViewHeaderHolder(header)
        } else if(viewType == TYPE_AVAILABLE_YES){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout, parent, false)
            return CustomViewHolder(view)
        } else if(viewType == TYPE_AVAILABLE_NOT) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout_not, parent, false)
            return  CustomViewHolderNot(view)
        }

        val footer = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_footer, parent, false)
        return  CustomViewFooterHolder(footer)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = members.get(position)

        if(holder is CustomViewHolder){
            holder.first_name.setText(member.firstName)
            holder.last_name.setText(member.lastName)
        }

        if(holder is CustomViewHolderNot){
            holder.first_name.setText("This first name is not available")
            holder.last_name.setText("This last name is not available")
        }
    }

    class CustomViewHeaderHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    class CustomViewFooterHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var first_name = itemView.findViewById<TextView>(R.id.first_name)
        var last_name = itemView.findViewById<TextView>(R.id.last_name)
    }

    class CustomViewHolderNot(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var first_name = itemView.findViewById<TextView>(R.id.first_name)
        var last_name = itemView.findViewById<TextView>(R.id.last_name)
    }

}