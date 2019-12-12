package co.id.iconpln.recyclerview.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import co.id.iconpln.recyclerview.R
import co.id.iconpln.recyclerview.adapter.CustomAdapter
import co.id.iconpln.recyclerview.model.Member
import co.id.iconpln.recyclerview.model.MemberSub
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        val members = prepareMemerList()
        refreshAdapter(members)
    }

    private fun initViews() {
        recyclerView.layoutManager = GridLayoutManager(this,1)
        //recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun refreshAdapter(members: List<Member>) {
        val adapter = CustomAdapter(this, members)
        recyclerView.adapter = adapter
    }

    private fun prepareMemerList(): List<Member> {
        val members = ArrayList<Member>()

        for(i in 0..29){
            if(i == 1 || i == 10){
                members.add(Member("Rahmat" + i, "Kurniawan" + i, prepareSubMemers()))
            } else {
                members.add(Member("Rahmat" + i, "Kurniawan" + i, ArrayList<MemberSub>()))
            }
        }

        return members
    }

    private fun prepareSubMemers(): List<MemberSub> {
        val members = ArrayList<MemberSub>()

        for(i in 0..4){
            members.add(MemberSub("Offline"))
        }

        return members
    }
}
