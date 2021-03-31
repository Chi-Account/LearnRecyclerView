package chi.learnrecyclerview.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import chi.learnrecyclerview.R
import chi.learnrecyclerview.adapter.RecyclerViewAdapter3
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RecyclerViewAdapter3(getDataList())
    }

    private fun getDataList(): List<String> {
        val totalCount = 128
        val skipCount = 65
        return List(totalCount - skipCount) {
            (it + skipCount).toChar().toString()
        }
    }
}