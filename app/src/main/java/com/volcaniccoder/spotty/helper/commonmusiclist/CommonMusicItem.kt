package com.volcaniccoder.spotty.helper.commonmusiclist

data class CommonMusicItem(var icon: Int, val title : String , val body : String){
    var isDelete : Boolean = false
    var showDownloadIcon : Boolean = false
}