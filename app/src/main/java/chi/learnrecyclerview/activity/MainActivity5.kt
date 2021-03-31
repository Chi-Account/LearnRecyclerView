package chi.learnrecyclerview.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import chi.learnrecyclerview.R
import chi.learnrecyclerview.adapter.RecyclerViewAdapter
import chi.library.base.BaseActivity
import chi.library.util.LogUtil
import chi.library.view.recyclerview.adapter.HeaderFooterAdapter
import chi.library.view.recyclerview.listener.OnItemClickListener
import chi.library.view.recyclerview.listener.OnItemLongClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity5 : BaseActivity(), OnItemClickListener, OnItemLongClickListener {

    private val adapter = HeaderFooterAdapter(
        RecyclerViewAdapter(
            getDataList(),
            onItemClickListener = this,
            onItemLongClickListener = this
        )
    )

    @DrawableRes
    private val resources: Array<Int> = arrayOf(
        R.drawable.ereshkigal700,
        R.drawable.ereshkigal829,
        R.drawable.ereshkigal1048,
        R.drawable.ereshkigal1229,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        recyclerView.layoutManager = StaggeredGridLayoutManager(
            3,
            StaggeredGridLayoutManager.VERTICAL
        )
        recyclerView.adapter = adapter

        adapter.addHeader(inflateImageView(resources[resources.indices.random()]))
        adapter.addFooter(inflateImageView(resources[resources.indices.random()]))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main5, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            R.id.item_addHeader -> {
                addHeader()
                true
            }
            R.id.item_addFooter -> {
                addFooter()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    override fun onItemClick(view: View, position: Int) {
        LogUtil.i(TAG, "onItemClick: ${adapter.getItemInRawAdapter(position)}")
    }

    override fun onItemLongClick(view: View, position: Int): Boolean {
        LogUtil.i(TAG, "onItemLongClick: ${adapter.getItemInRawAdapter(position)}")
        return true
    }

    private fun getDataList(): List<String> {
        val totalCount = 128
        val skipCount = 65
        return List(totalCount - skipCount) {
            (it + skipCount).toChar().toString()
        }
    }

    private fun addHeader() {
        adapter.addHeader(inflateImageView(resources[resources.indices.random()]))
        recyclerView.scrollToPosition(adapter.getHeaderCount() - 1)
    }

    private fun addFooter() {
        adapter.addFooter(inflateImageView(resources[resources.indices.random()]))
        recyclerView.scrollToPosition(adapter.itemCount - 1)
    }

    private fun inflateImageView(@DrawableRes resource: Int): View {
        return LayoutInflater.from(this).inflate(
            R.layout.header_footer_recycler_view5,
            recyclerView,
            false
        ).apply {
            findViewById<ImageView>(R.id.imageView).setImageResource(resource)
        }
    }
}