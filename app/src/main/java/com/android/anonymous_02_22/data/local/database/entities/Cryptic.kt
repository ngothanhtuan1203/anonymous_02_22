package com.android.anonymous_02_22.data.local.database.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "cryptic",indices = [Index(value = ["euid"], unique = true)])
data class Cryptic(
    @SerializedName("name") var name: String,
    @SerializedName("symbol") var symbol: String,

    @SerializedName("euid") var euid: String
): Parcelable {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true) var id: Long = 0
}