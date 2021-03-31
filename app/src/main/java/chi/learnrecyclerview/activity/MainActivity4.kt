package chi.learnrecyclerview.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import chi.learnrecyclerview.R
import chi.learnrecyclerview.adapter.RecyclerViewAdapter4
import chi.learnrecyclerview.bean.ImageWrapper
import chi.library.base.BaseActivity
import chi.library.util.LogUtil
import chi.library.view.recyclerview.listener.OnItemClickListener
import chi.library.view.recyclerview.listener.OnItemLongClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity4 : BaseActivity(), OnItemClickListener, OnItemLongClickListener {

    private val dataList = getDataList()

    private val adapter = RecyclerViewAdapter4(
        dataList,
        onItemClickListener = this,
        onItemLongClickListener = this
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            R.id.item_add -> {
                add()
                true
            }
            R.id.item_remove -> {
                remove()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    override fun onItemClick(view: View, position: Int) {
        LogUtil.i(TAG, "onItemClick: ${adapter.getItem(position).text}")
    }

    override fun onItemLongClick(view: View, position: Int): Boolean {
        LogUtil.i(TAG, "onItemLongClick: ${adapter.getItem(position).text}")
        return true
    }

    private fun getDataList(): MutableList<ImageWrapper> =
        mutableListOf(
            ImageWrapper(R.drawable.ereshkigal829, "埃列什基伽勒"),
            ImageWrapper(R.drawable.ereshkigal1048, "埃列什基伽勒"),
            ImageWrapper(R.drawable.ereshkigal1229, "埃列什基伽勒"),
            ImageWrapper(R.drawable.romani076, "罗玛尼·阿其曼"),
            ImageWrapper(R.drawable.romani179, "罗玛尼·阿其曼"),
            ImageWrapper(R.drawable.romani280, "罗玛尼·阿其曼"),
            ImageWrapper(R.drawable.romani346, "罗玛尼·阿其曼"),
            ImageWrapper(R.drawable.romani590, "罗玛尼·阿其曼"),
            ImageWrapper(R.drawable.romani893, "罗玛尼·阿其曼")
        )

    private fun add() {
        val index = 0
        val item = ImageWrapper(R.drawable.ereshkigal700, "花开冥界")
        dataList.add(index, item)
        adapter.notifyDataSetChanged()
    }

    private fun remove() {
        if (dataList.isNotEmpty()) {
            val index = 0
            dataList.removeAt(index)
            adapter.notifyDataSetChanged()
        }
    }
}