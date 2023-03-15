package com.example.DataClass

import android.media.SubtitleData
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemPost(
    val imgUrl: String,
    val txtTitle: String,
    val txtSubtitle: String,
    val txtDetail: String,

    //for trend fragment
    val isTrend : Boolean,
    val insight : String

) : Parcelable