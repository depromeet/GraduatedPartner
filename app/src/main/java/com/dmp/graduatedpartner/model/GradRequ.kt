package com.dmp.graduatedpartner.model

import android.os.Parcel
import android.os.Parcelable

data class GradRequ(val type: String?, val title: String?, val isComplete: Boolean = false) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type)
        parcel.writeString(title)
        parcel.writeByte(if (isComplete) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GradRequ> {
        override fun createFromParcel(parcel: Parcel): GradRequ {
            return GradRequ(parcel)
        }

        override fun newArray(size: Int): Array<GradRequ?> {
            return arrayOfNulls(size)
        }
    }

}