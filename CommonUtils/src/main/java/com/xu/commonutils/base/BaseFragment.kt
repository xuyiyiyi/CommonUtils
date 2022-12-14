package com.xu.commonutils.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.xu.commonutils.utils.FragmentUtils

/**
 * desc:
 **
 * user: xujj
 * time: 2022/8/10 17:34
 **/
abstract class BaseFragment : Fragment(), OnViewClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected abstract fun init(view: View)

    fun setOnViewClickListener(vararg views: View?) {
        for (view in views) {
            view?.setOnClickListener { v -> onViewClick(v, v.id) }
        }
    }

    override fun onViewClick(view: View, id: Int) {}

    fun add(
        any: Any?,
        @IdRes containerViewId: Int,
        tag: String? = javaClass.simpleName,
        animationType: Int = FragmentUtils.ANIM_TYPE_NONE
    ) {
        FragmentUtils.addFragment(this, any, containerViewId, tag, animationType)
    }

    fun replace(
        any: Any?,
        @IdRes containerViewId: Int,
        tag: String? = javaClass.simpleName
    ) {
        FragmentUtils.replaceFragment(this, any, containerViewId, tag)
    }
}