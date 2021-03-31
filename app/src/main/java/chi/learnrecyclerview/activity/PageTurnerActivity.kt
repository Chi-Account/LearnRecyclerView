package chi.learnrecyclerview.activity

import android.os.Bundle
import chi.library.base.pageturner.BasePageTurnerActivity
import chi.library.base.pageturner.Page
import chi.library.util.LogUtil

class PageTurnerActivity : BasePageTurnerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtil.init(true)
    }

    override fun getPageList(): List<Page> =
        listOf(
            Page("基本使用", MainActivity::class.java),
            Page("Gallery", MainActivity2::class.java),
            Page("多种 ItemViewType", MainActivity3::class.java),
            Page("分类", MainActivity4::class.java),
            Page("Header 和 Footer", MainActivity5::class.java),
            Page("SnapHelper", MainActivity6::class.java)
        )
}