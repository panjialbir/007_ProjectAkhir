package com.example.projekakhir.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_lc")
data class LC(
    @PrimaryKey(autoGenerate = true)
    val lcid: Long = 0,
    val lcname: String
)