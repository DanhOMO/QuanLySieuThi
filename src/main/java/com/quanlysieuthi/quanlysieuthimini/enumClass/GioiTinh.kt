package com.quanlysieuthi.quanlysieuthimini.enumClass

public enum class GioiTinh {
    NAM, NU;

    public fun getGioiTinh(): String {
        return when(this) {
            NAM -> "Nam"
            NU -> "Nữ"
        }
    }
    public fun getGioiTinh(gioiTinh: String): GioiTinh {
        return when(gioiTinh) {
            "Nam" -> NAM
            "Nữ" -> NU
            else -> throw IllegalArgumentException("Không hợp lệ")
        }
    }

}