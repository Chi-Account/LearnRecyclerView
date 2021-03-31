package chi.learnrecyclerview.adapter

import android.widget.TextView
import chi.learnrecyclerview.R
import chi.library.view.recyclerview.ViewHolder

class RecyclerViewAdapter3(
    dataList: List<String>
) : chi.library.view.recyclerview.adapter.RecyclerViewAdapter<String>(dataList) {

    companion object {
        private const val ITEM_VIEW_TYPE_1 = 1
        private const val ITEM_VIEW_TYPE_2 = 2
    }

    override fun getItemViewType(position: Int): Int =
        if (position % 2 == 0) {
            ITEM_VIEW_TYPE_1
        } else {
            ITEM_VIEW_TYPE_2
        }

    override fun getLayoutResource(itemViewType: Int): Int =
        when (itemViewType) {
            ITEM_VIEW_TYPE_1 -> R.layout.adapter_recycler_view3_type1
            ITEM_VIEW_TYPE_2 -> R.layout.adapter_recycler_view3_type2
            else -> throw IllegalArgumentException(itemViewType.toString())
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, item: String) {
        holder.getView<TextView>(R.id.textView).text = item
    }
}