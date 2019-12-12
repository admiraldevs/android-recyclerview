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

    private val TYPE_AVAILABLE_YES = 0
    private val TYPE_AVAILABLE_NOT = 1

    override fun getItemCount(): Int {
        return members.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (members[position].available) {
            TYPE_AVAILABLE_YES
        } else {
            TYPE_AVAILABLE_NOT
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == TYPE_AVAILABLE_YES){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout, parent, false)
            return CustomViewHolder(view)
        }

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout_not, parent, false)
        return  CustomViewHolderNot(view)
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

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var first_name = itemView.findViewById<TextView>(R.id.first_name)
        var last_name = itemView.findViewById<TextView>(R.id.last_name)
    }

    class CustomViewHolderNot(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var first_name = itemView.findViewById<TextView>(R.id.first_name)
        var last_name = itemView.findViewById<TextView>(R.id.last_name)
    }

}