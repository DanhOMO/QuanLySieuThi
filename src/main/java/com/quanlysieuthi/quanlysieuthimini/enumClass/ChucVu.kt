package com.quanlysieuthi.quanlysieuthimini.enumClass

public enum class ChucVu {
    QUAN_LY, NHAN_VIEN, NHAN_VIEN_KHO

    public fun getChucVu(): String {
        return when(this) {
            QUAN_LY -> "Quản lý"
            NHAN_VIEN -> "Nhân viên"
            NHAN_VIEN_KHO -> "Nhân viên kho"
        }
    }
    public fun getChucVu(chucVu: String): ChucVu {
        return when(chucVu) {
            "Quản lý" -> QUAN_LY
            "Nhân viên" -> NHAN_VIEN
            "Nhân viên kho" -> NHAN_VIEN_KHO
            else -> throw IllegalArgumentException("Không hợp lệ")
        }
    }

}