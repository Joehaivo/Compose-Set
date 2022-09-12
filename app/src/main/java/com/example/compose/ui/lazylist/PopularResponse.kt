package com.example.compose.ui.lazylist

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class PopularResponse(

	@field:SerializedName("code")
	val code: Long? = null,

	@field:SerializedName("data")
	val data: PopularData? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("ttl")
	val ttl: Long? = null
)

@Keep
data class Dimension(

	@field:SerializedName("rotate")
	val rotate: Long? = null,

	@field:SerializedName("width")
	val width: Long? = null,

	@field:SerializedName("height")
	val height: Long? = null
)

@Keep
data class Rights(

	@field:SerializedName("movie")
	val movie: Long? = null,

	@field:SerializedName("is_cooperation")
	val isCooperation: Long? = null,

	@field:SerializedName("ugc_pay")
	val ugcPay: Long? = null,

	@field:SerializedName("no_background")
	val noBackground: Long? = null,

	@field:SerializedName("pay")
	val pay: Long? = null,

	@field:SerializedName("elec")
	val elec: Long? = null,

	@field:SerializedName("ugc_pay_preview")
	val ugcPayPreview: Long? = null,

	@field:SerializedName("bp")
	val bp: Long? = null,

	@field:SerializedName("autoplay")
	val autoplay: Long? = null,

	@field:SerializedName("pay_free_watch")
	val payFreeWatch: Long? = null,

	@field:SerializedName("download")
	val download: Long? = null,

	@field:SerializedName("no_reprLong")
	val noReprLong: Long? = null,

	@field:SerializedName("hd5")
	val hd5: Long? = null,

	@field:SerializedName("arc_pay")
	val arcPay: Long? = null
)

@Keep
data class PopularItem(

	@field:SerializedName("bvid")
	val bvid: String? = null,

	@field:SerializedName("copyright")
	val copyright: Long? = null,

	@field:SerializedName("mission_id")
	val missionId: Long? = null,

	@field:SerializedName("videos")
	val videos: Long? = null,

	@field:SerializedName("pic")
	val pic: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("tid")
	val tid: Long? = null,

	@field:SerializedName("short_link")
	val shortLink: String? = null,

	@field:SerializedName("duration")
	val duration: Long? = null,

	@field:SerializedName("season_type")
	val seasonType: Long? = null,

	@field:SerializedName("rights")
	val rights: Rights? = null,

	@field:SerializedName("rcmd_reason")
	val rcmdReason: RcmdReason? = null,

	@field:SerializedName("ctime")
	val ctime: Long? = null,

	@field:SerializedName("dynamic")
	val dynamic: String? = null,

	@field:SerializedName("short_link_v2")
	val shortLinkV2: String? = null,

	@field:SerializedName("state")
	val state: Long? = null,

	@field:SerializedName("dimension")
	val dimension: Dimension? = null,

	@field:SerializedName("pubdate")
	val pubdate: Long? = null,

	@field:SerializedName("owner")
	val owner: Owner? = null,

	@field:SerializedName("stat")
	val stat: Stat? = null,

	@field:SerializedName("ogv_info")
	val ogvInfo: Any? = null,

	@field:SerializedName("pub_location")
	val pubLocation: String? = null,

	@field:SerializedName("is_ogv")
	val isOgv: Boolean? = null,

	@field:SerializedName("tname")
	val tname: String? = null,

	@field:SerializedName("up_from_v2")
	val upFromV2: Long? = null,

	@field:SerializedName("aid")
	val aid: Long? = null,

	@field:SerializedName("desc")
	val desc: String? = null,

	@field:SerializedName("cid")
	val cid: Long? = null,

	@field:SerializedName("first_frame")
	val firstFrame: String? = null,

	@field:SerializedName("season_id")
	val seasonId: Long? = null
)

@Keep
data class PopularData(

	@field:SerializedName("no_more")
	val noMore: Boolean? = null,

	@field:SerializedName("list")
	val list: List<PopularItem>? = null
)

@Keep
data class RcmdReason(

	@field:SerializedName("corner_mark")
	val cornerMark: Long? = null,

	@field:SerializedName("content")
	val content: String? = null
)

@Keep
data class Stat(

	@field:SerializedName("now_rank")
	val nowRank: Long? = null,

	@field:SerializedName("view")
	val view: Long? = null,

	@field:SerializedName("like")
	val like: Long? = null,

	@field:SerializedName("dislike")
	val dislike: Long? = null,

	@field:SerializedName("danmaku")
	val danmaku: Long? = null,

	@field:SerializedName("share")
	val share: Long? = null,

	@field:SerializedName("reply")
	val reply: Long? = null,

	@field:SerializedName("his_rank")
	val hisRank: Long? = null,

	@field:SerializedName("aid")
	val aid: Long? = null,

	@field:SerializedName("favorite")
	val favorite: Long? = null,

	@field:SerializedName("coin")
	val coin: Long? = null
)

@Keep
data class Owner(

	@field:SerializedName("face")
	val face: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("mid")
	val mid: Long? = null
)
