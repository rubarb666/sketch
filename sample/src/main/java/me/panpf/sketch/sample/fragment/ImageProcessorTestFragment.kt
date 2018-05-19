package me.panpf.sketch.sample.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.fragment_pager_tab.*
import me.panpf.adapter.pager.FragmentArrayPagerAdapter
import me.panpf.sketch.sample.BaseFragment
import me.panpf.sketch.sample.BindContentView
import me.panpf.sketch.sample.R
import me.panpf.sketch.sample.activity.MainActivity

@BindContentView(R.layout.fragment_pager_tab)
class ImageProcessorTestFragment : BaseFragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = activity ?: return

        pager_pagerTabFragment_content.adapter = FragmentArrayPagerAdapter(childFragmentManager, arrayOf<Fragment>(
                ReflectionImageProcessorTestFragment(),
                GaussianBlurImageProcessorTestFragment(),
                RotateImageProcessorTestFragment(),
                RoundRectImageProcessorTestFragment(),
                CircleImageProcessorTestFragment(),
                ResizeImageProcessorTestFragment(),
                MaskImageProcessorTestFragment(),
                WrappedImageProcessorTestFragment()))

        tab_pagerTabFragment_tabs.setTabViewFactory(MainActivity.TitleTabFactory(arrayOf(
                "REFLECTION",
                "GAUSSIAN_BLUR",
                "ROTATE",
                "ROUND_RECT",
                "CIRCLE",
                "RESIZE",
                "MASK",
                "WRAPPED"), activity))
        tab_pagerTabFragment_tabs.setViewPager(pager_pagerTabFragment_content)
    }
}
