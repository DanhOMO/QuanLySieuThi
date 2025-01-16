package com.quanlysieuthi.quanlysieuthimini.enumClass

public enum class TrangThaiTaiKhoan {
    KHONG_HOAT_DONG, HOAT_DONG ;

    public fun getTrangThaiTaiKhoan(): String {
        return when(this) {
            KHONG_HOAT_DONG -> "Khóa"
            HOAT_DONG -> "Hoạt động"
        }
    }
    public fun getTrangThaiTaiKHONG_HOAT_DONGn(trangThaiTaiKHONG_HOAT_DONGn: String): TrangThaiTaiKhoan {
        return when(trangThaiTaiKHONG_HOAT_DONGn) {
            "Khóa" -> KHONG_HOAT_DONG
            "Hoạt động" -> HOAT_DONG
            else -> throw IllegalArgumentException("Không hợp lệ")
        }
    }
}