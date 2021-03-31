package chi.learnrecyclerview.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import chi.learnrecyclerview.R
import chi.learnrecyclerview.adapter.RecyclerViewAdapter
import chi.library.base.BaseActivity
import chi.library.util.LogUtil
import chi.library.view.recyclerview.listener.OnItemClickListener
import chi.library.view.recyclerview.listener.OnItemLongClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), OnItemClickListener, OnItemLongClickListener {

    private val dataList = getDataList()

    private val adapter = RecyclerViewAdapter(
        dataList,
        onItemClickListener = this,
        onItemLongClickListener = this
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.itemAnimator = DefaultItemAnimator()
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
        LogUtil.i(TAG, "onItemClick: ${adapter.getItem(position)}")
    }

    override fun onItemLongClick(view: View, position: Int): Boolean {
        LogUtil.i(TAG, "onItemLongClick: ${adapter.getItem(position)}")
        return true
    }

    private fun getDataList(): MutableList<String> {
        val totalCount = 128
        val skipCount = 65
        return MutableList(totalCount - skipCount) {
            (it + skipCount).toChar().toString()
        }
    }

    private fun add() {
        val index = 0
        val item = "你好！"
        dataList.add(index, item)
        adapter.notifyItemInserted(index)
        recyclerView.scrollToPosition(index)
    }

    private fun remove() {
        if (dataList.isNotEmpty()) {
            val index = 0
            dataList.removeAt(index)
            adapter.notifyItemRemoved(index)
        }
    }
}