package com.quanlysieuthi.quanlysieuthimini.enumClass

public enum class TrangThaiTaiKhoan {
    KHONG_HOAT_DONG, HOAT_DONG

    public fun getTrangThaiTaiKhoan(): String {
        return when(this) {
            KHOA -> "Khóa"
            HOAT_DONG -> "Hoạt động"
        }
    }
    public fun getTrangThaiTaiKhoan(trangThaiTaiKhoan: String): TrangThaiTaiKhoan {
        return when(trangThaiTaiKhoan) {
            "Khóa" -> KHOA
            "Hoạt động" -> HOAT_DONG
            else -> throw IllegalArgumentException("Không hợp lệ")
        }
    }
}