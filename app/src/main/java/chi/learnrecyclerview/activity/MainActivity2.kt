package chi.learnrecyclerview.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import chi.learnrecyclerview.R
import chi.learnrecyclerview.adapter.RecyclerViewAdapter2
import chi.learnrecyclerview.bean.ImageWrapper
import chi.learnrecyclerview.view.recyclerview.GalleryRecyclerView
import chi.library.view.recyclerview.listener.OnItemClickListener
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity(), OnItemClickListener,
    GalleryRecyclerView.OnItemChangeListener {

    private val adapter: RecyclerViewAdapter2 = RecyclerViewAdapter2(
        getDataList(),
        onItemClickListener = this
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        recyclerView.onItemChangeListener = this
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        recyclerView.adapter = adapter
    }

    override fun onItemClick(view: View, position: Int) {
        onItemChange(view, position)
    }

    override fun onItemChange(view: View, position: Int) {
        imageView.setImageResource(adapter.getItem(position).resourceId)
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
