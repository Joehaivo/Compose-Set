package com.example.compose.ui.lazylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.Pager
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import coil.compose.AsyncImage
import com.blankj.utilcode.util.TimeUtils
import com.example.compose.ui.theme.ComposeTheme
import java.lang.StringBuilder

/**
 * 哔哩哔哩-热门视频列表-compose版本
 */
class BiliLazyListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    Column {
                        LazyList()
                    }
                }
            }
        }
    }
}

@Composable
fun LazyList() {
    val viewModel = viewModel<LazyListViewModel>()
    val pagingItems = viewModel.biliHotData.collectAsLazyPagingItems()
    LazyColumn {
        itemsIndexed(
            items = pagingItems,
            key = { index, item -> item.aid ?: 0 }
        ) { index, item ->
            if (item !=  null) {
                BiliItem(item)
            }
        }
    }
}

@Composable
fun BiliItem(itemData: PopularItem) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(6.dp)
    ) {
        // 封面
        ConstraintLayout(
            modifier = Modifier
                .padding(6.dp)
                .weight(0.45f)
                .fillMaxHeight()
        ) {
            val (asyncImage, durationText) = createRefs()
            AsyncImage(
                model = itemData.pic,
                contentDescription = "album",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .constrainAs(asyncImage) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    }
                    .clip(RoundedCornerShape(6.dp))
            )
            Text(
                text = formatDuration(itemData.duration?.times(1000) ?: 0L),
                style = TextStyle(color = Color.White, fontSize = 10.sp),
                modifier = Modifier
                    .constrainAs(durationText) {
                        bottom.linkTo(parent.bottom, margin = 4.dp)
                        end.linkTo(parent.end, margin = 4.dp)
                    }
                    .background(
                        color = Color.Black.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(3.dp)
                    )
                    .padding(horizontal = 5.dp)
            )
        }
        // 右侧：视频信息
        ConstraintLayout(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.55f)
        ) {
            val (tvTitle, tvTag, tvName, tvPlay) = createRefs()
            Text(
                text = itemData.title ?: "",
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontSize = 14.sp,
                modifier = Modifier.constrainAs(tvTitle) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top, margin = 6.dp)
                }
            )
            if (itemData.rcmdReason?.content?.isNotBlank() == true) {
                Text(
                    text = itemData.rcmdReason.content,
                    style = TextStyle(color = Color(0xffea8461), fontSize = 12.sp),
                    modifier = Modifier
                        .constrainAs(tvTag) {
                            start.linkTo(parent.start)
                            bottom.linkTo(tvName.top)
                        }
                        .border(
                            border = BorderStroke(
                                width = 1.dp,
                                color = Color(0xffea8461)
                            ), shape = RoundedCornerShape(3.dp)
                        )
                        .padding(horizontal = 4.dp, vertical = 2.dp)
                )
            }
            Text(
                text = itemData.owner?.name ?: "",
                color = Color.Gray,
                fontSize = 13.sp,
                modifier = Modifier.constrainAs(tvName) {
                    start.linkTo(parent.start)
                    bottom.linkTo(tvPlay.top)
                })
            val pubTime =
                TimeUtils.getFriendlyTimeSpanByNow((itemData.pubdate?.toLong())?.times(1000) ?: 0L)
            val count = itemData.stat?.view?.toFloat()?.div(10000) ?: 0f
            Text(
                text = "${String.format("%.1f", count)}万观看 · $pubTime",
                color = Color.Gray,
                fontSize = 13.sp,
                modifier = Modifier.constrainAs(tvPlay) {
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom, margin = 6.dp)
                }
            )
        }
    }
}

/** 2_000 => 00:02
 * 61_000 => 1:01
 * 6100_000 => 101:40 */
private fun formatDuration(durationMillis: Long): String {
    val ONE_SECOND = 1000
    val ONE_MINUTE = 60000
    val durationLegal = if (durationMillis <= ONE_SECOND) 1000 else durationMillis
    val d = StringBuilder()
    val min = (durationLegal / ONE_MINUTE).toInt()
    val sec = ((durationLegal - (min * ONE_MINUTE)) / ONE_SECOND).toInt()
    if (min > 0) {
        d.append("$min:")
    } else {
        d.append("00:")
    }
    d.append(String.format("%02d", sec))
    return d.toString()
}

@Preview
@Composable
fun BiliItemPreView() {
    BiliItem(itemData = mockBiliHotList.first())
}