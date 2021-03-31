package chi.learnrecyclerview.adapter

import android.widget.ImageView
import android.widget.TextView
import chi.learnrecyclerview.R
import chi.learnrecyclerview.bean.ImageWrapper
import chi.library.view.recyclerview.ViewHolder
import chi.library.view.recyclerview.adapter.SectionAdapter
import chi.library.view.recyclerview.listener.OnItemClickListener
import chi.library.view.recyclerview.listener.OnItemLongClickListener

class RecyclerViewAdapter4(
    dataList: List<ImageWrapper>,
    onItemClickListener: OnItemClickListener? = null,
    onItemLongClickListener: OnItemLongClickListener? = null
) : SectionAdapter<ImageWrapper, String>(
    dataList,
    onItemClickListener,
    onItemLongClickListener
) {

    override fun getSectionHeader(rawPosition: Int, item: ImageWrapper): String = item.text

    override fun getSectionHeaderLayoutResource(): Int =
        R.layout.adapter_recycler_view4_section_header

    override fun getItemLayoutResource(itemViewType: Int): Int =
        R.layout.adapter_recycler_view4_item

    override fun onBindSectionHeaderViewHolder(holder: ViewHolder, item: String) {
        holder.getView<TextView>(R.id.textView).text = item
    }

    override fun onBindItemViewHolder(holder: ViewHolder, position: Int, item: ImageWrapper) {
        holder.getView<ImageView>(R.id.imageView).setImageResource(item.resourceId)
    }
}