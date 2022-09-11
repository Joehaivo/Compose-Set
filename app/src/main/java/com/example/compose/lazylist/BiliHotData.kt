package com.example.compose.lazylist

import com.google.gson.annotations.SerializedName

data class BiliHotData(

	@field:SerializedName("BiliHotData")
	val biliHotData: List<BiliHotDataItem?>? = null
)

data class Rights(

	@field:SerializedName("movie")
	val movie: Int? = null,

	@field:SerializedName("is_cooperation")
	val isCooperation: Int? = null,

	@field:SerializedName("ugc_pay")
	val ugcPay: Int? = null,

	@field:SerializedName("no_background")
	val noBackground: Int? = null,

	@field:SerializedName("pay")
	val pay: Int? = null,

	@field:SerializedName("elec")
	val elec: Int? = null,

	@field:SerializedName("ugc_pay_preview")
	val ugcPayPreview: Int? = null,

	@field:SerializedName("bp")
	val bp: Int? = null,

	@field:SerializedName("autoplay")
	val autoplay: Int? = null,

	@field:SerializedName("pay_free_watch")
	val payFreeWatch: Int? = null,

	@field:SerializedName("download")
	val download: Int? = null,

	@field:SerializedName("no_reprint")
	val noReprint: Int? = null,

	@field:SerializedName("hd5")
	val hd5: Int? = null,

	@field:SerializedName("arc_pay")
	val arcPay: Int? = null
)

data class Owner(

	@field:SerializedName("face")
	val face: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("mid")
	val mid: Long? = null
)

data class Stat(

	@field:SerializedName("now_rank")
	val nowRank: Int? = null,

	@field:SerializedName("view")
	val view: Long? = null,

	@field:SerializedName("like")
	val like: Int? = null,

	@field:SerializedName("dislike")
	val dislike: Int? = null,

	@field:SerializedName("danmaku")
	val danmaku: Int? = null,

	@field:SerializedName("share")
	val share: Int? = null,

	@field:SerializedName("reply")
	val reply: Int? = null,

	@field:SerializedName("his_rank")
	val hisRank: Int? = null,

	@field:SerializedName("aid")
	val aid: Int? = null,

	@field:SerializedName("favorite")
	val favorite: Int? = null,

	@field:SerializedName("coin")
	val coin: Int? = null
)

data class Dimension(

	@field:SerializedName("rotate")
	val rotate: Int? = null,

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("height")
	val height: Int? = null
)

data class RcmdReason(

	@field:SerializedName("corner_mark")
	val cornerMark: Int? = null,

	@field:SerializedName("content")
	val content: String? = null
)

data class BiliHotDataItem(

	@field:SerializedName("bvid")
	val bvid: String? = null,

	@field:SerializedName("copyright")
	val copyright: Int? = null,

	@field:SerializedName("videos")
	val videos: Int? = null,

	@field:SerializedName("pic")
	val pic: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("tid")
	val tid: Int? = null,

	@field:SerializedName("short_link")
	val shortLink: String? = null,

	@field:SerializedName("duration")
	val duration: Long? = null,

	@field:SerializedName("season_type")
	val seasonType: Int? = null,

	@field:SerializedName("rights")
	val rights: Rights? = null,

	@field:SerializedName("rcmd_reason")
	val rcmdReason: RcmdReason? = null,

	@field:SerializedName("ctime")
	val ctime: Int? = null,

	@field:SerializedName("dynamic")
	val dynamic: String? = null,

	@field:SerializedName("short_link_v2")
	val shortLinkV2: String? = null,

	@field:SerializedName("state")
	val state: Int? = null,

	@field:SerializedName("dimension")
	val dimension: Dimension? = null,

	@field:SerializedName("pubdate")
	val pubdate: Int? = null,

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
	val upFromV2: Int? = null,

	@field:SerializedName("aid")
	val aid: Int? = null,

	@field:SerializedName("desc")
	val desc: String? = null,

	@field:SerializedName("cid")
	val cid: Int? = null,

	@field:SerializedName("first_frame")
	val firstFrame: String? = null,

	@field:SerializedName("mission_id")
	val missionId: Int? = null,

	@field:SerializedName("season_id")
	val seasonId: Int? = null
)
