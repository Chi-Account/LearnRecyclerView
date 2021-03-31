package chi.learnrecyclerview.adapter

import android.widget.TextView
import chi.learnrecyclerview.R
import chi.library.view.recyclerview.ViewHolder
import chi.library.view.recyclerview.listener.OnItemClickListener
import chi.library.view.recyclerview.listener.OnItemLongClickListener

class RecyclerViewAdapter(
    dataList: List<String>,
    onItemClickListener: OnItemClickListener? = null,
    onItemLongClickListener: OnItemLongClickListener? = null
) : chi.library.view.recyclerview.adapter.RecyclerViewAdapter<String>(
    dataList,
    onItemClickListener,
    onItemLongClickListener
) {

    override fun getLayoutResource(itemViewType: Int): Int = R.layout.adapter_recycler_view

    override fun onBindViewHolder(holder: ViewHolder, position: Int, item: String) {
        holder.getView<TextView>(R.id.textView).text = item
    }
}