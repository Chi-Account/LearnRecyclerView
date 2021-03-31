package chi.learnrecyclerview.bean

import androidx.annotation.DrawableRes

data class ImageWrapper(
    @DrawableRes val resourceId: Int,
    val text: String
)