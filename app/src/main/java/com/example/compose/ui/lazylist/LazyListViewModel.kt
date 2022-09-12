package com.example.compose.ui.lazylist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils

class LazyListViewModel : ViewModel() {
    companion object {
        const val PAGE_SIZE = 40
    }

    val biliHotData = Pager(PagingConfig(pageSize = PAGE_SIZE)) {
        BiliHotSource()
    }.flow.cachedIn(viewModelScope)
}

class BiliHotSource : PagingSource<Int, PopularItem>() {
    override fun getRefreshKey(state: PagingState<Int, PopularItem>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PopularItem> {
        val currPage = params.key ?: 1
        val popularResponse = try {
            BiliService.impl.popularVideos(currPage, LazyListViewModel.PAGE_SIZE)
        } catch (e: Exception) {
            LogUtils.d("api exception=${e.message}, curr=$currPage")
            return if (currPage == 1) {
                ToastUtils.showLong("没有获取到网络数据, 采用本地数据")
                LoadResult.Page(
                    data = mockBiliHotList,
                    prevKey = null,
                    nextKey = null
                )
            } else {
                ToastUtils.showShort("网络异常")
                LoadResult.Error(Exception())
            }
        }

        val popularItemList = popularResponse?.data?.list
        LogUtils.d("curr=$currPage, size=${popularItemList?.size}, popularItemList=$popularItemList")
        return if (!popularItemList.isNullOrEmpty()) {
            LoadResult.Page(
                popularItemList,
                prevKey = if (currPage == 1) null else currPage - 1,
                nextKey = currPage + 1
            )
        } else {
            LoadResult.Error(Exception())
        }
    }
}