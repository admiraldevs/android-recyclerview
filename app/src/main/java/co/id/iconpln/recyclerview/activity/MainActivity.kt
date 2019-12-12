package co.id.iconpln.recyclerview.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import co.id.iconpln.recyclerview.R
import co.id.iconpln.recyclerview.adapter.CustomAdapter
import co.id.iconpln.recyclerview.model.Member
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        val members = prepareMemerList()
        refreshAdapter(members)
    }

    private fun refreshAdapter(members: List<Member>) {
        val adapter = CustomAdapter(members)
        recyclerView.adapter = adapter
    }

    private fun initViews() {
        recyclerView.layoutManager = GridLayoutManager(this,1)
        //recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun prepareMemerList(): List<Member> {
        val members = ArrayList<Member>()

        for(i in 0..29){
            if(i == 0 || i == 5 || i == 16 || i == 25){
                members.add(Member("Rahmat" + i, "Kurniawan" + i, false))
            } else {
                members.add(Member("Rahmat" + i, "Kurniawan" + i, true))
            }
        }
        return members
    }
}
