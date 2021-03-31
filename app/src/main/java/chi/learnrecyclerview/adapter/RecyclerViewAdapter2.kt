package chi.learnrecyclerview.adapter

import android.widget.ImageView
import android.widget.TextView
import chi.learnrecyclerview.R
import chi.learnrecyclerview.bean.ImageWrapper
import chi.library.view.recyclerview.ViewHolder
import chi.library.view.recyclerview.listener.OnItemClickListener

class RecyclerViewAdapter2(
    dataList: List<ImageWrapper>,
    onItemClickListener: OnItemClickListener? = null
) : chi.library.view.recyclerview.adapter.RecyclerViewAdapter<ImageWrapper>(
    dataList,
    onItemClickListener
) {

    override fun getLayoutResource(itemViewType: Int): Int = R.layout.adapter_recycler_view2

    override fun onBindViewHolder(holder: ViewHolder, position: Int, item: ImageWrapper) {
        holder.getView<ImageView>(R.id.imageView).setImageResource(item.resourceId)
        holder.getView<TextView>(R.id.textView).text = item.text
    }
}