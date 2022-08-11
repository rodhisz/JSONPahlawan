package com.rsz.pahlawan

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PahlawanItem (
    var nama : String = "",
    var nama2 : String = "",
    var kategori : String = "",
    var asal : String = "",
    var lahir : String = "",
    var usia : String = "",
    var gugur : String = "",
    var lokasimakam : String = "",
    var history : String = "",
    var img : String = "",
) : Parcelable