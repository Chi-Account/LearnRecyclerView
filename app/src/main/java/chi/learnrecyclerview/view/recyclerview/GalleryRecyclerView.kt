package chi.learnrecyclerview.view.recyclerview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GalleryRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RecyclerView(
    context,
    attrs,
    defStyleAttr
) {

    interface OnItemChangeListener {
        fun onItemChange(view: View, position: Int)
    }

    var onItemChangeListener: OnItemChangeListener? = null

    private val currentChildView: View? = null

    private val onScrollListener = object : OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            getChildAt(0)?.let {
                val position = getChildAdapterPosition(it)
                if (position != NO_POSITION && it != currentChildView) {
                    onItemChangeListener?.onItemChange(it, position)
                }
            }
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        addOnScrollListener(onScrollListener)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        removeOnScrollListener(onScrollListener)
    }
}