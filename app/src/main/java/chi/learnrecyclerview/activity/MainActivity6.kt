package chi.learnrecyclerview.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import chi.learnrecyclerview.R
import chi.learnrecyclerview.adapter.RecyclerViewAdapter6
import chi.learnrecyclerview.bean.ImageWrapper
import chi.library.view.recyclerview.snaphelper.GallerySnapHelper
import kotlinx.android.synthetic.main.activity_main6.*

class MainActivity6 : AppCompatActivity() {

    private val adapter: RecyclerViewAdapter6 = RecyclerViewAdapter6(getDataList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        GallerySnapHelper().attachToRecyclerView(recyclerView)
        recyclerView.adapter = adapter
    }

    private fun getDataList(): List<ImageWrapper> =
        listOf(
            ImageWrapper(R.drawable.ereshkigal700, "700"),
            ImageWrapper(R.drawable.ereshkigal829, "829"),
            ImageWrapper(R.drawable.ereshkigal1048, "1048"),
            ImageWrapper(R.drawable.ereshkigal1229, "1229"),
            ImageWrapper(R.drawable.romani076, "076"),
            ImageWrapper(R.drawable.romani179, "179"),
            ImageWrapper(R.drawable.romani280, "280"),
            ImageWrapper(R.drawable.romani346, "346"),
            ImageWrapper(R.drawable.romani590, "590"),
            ImageWrapper(R.drawable.romani893, "893")
        )
}