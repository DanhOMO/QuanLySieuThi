package com.quanlysieuthi.quanlysieuthimini.enumClass

public enum class TrangThaiNhanVien {
    DANG_LAM, NGHI_VIEC;

    public fun getTrangThaiNhanVien(): String {
        return when(this) {
            DANG_LAM -> "Đang làm"
            NGHI_VIEC -> "Nghỉ việc"
        }
    }
    public fun getTrangThaiNhanVien(trangThaiNhanVien: String): TrangThaiNhanVien {
        return when(trangThaiNhanVien) {
            "Đang làm" -> DANG_LAM
            "Nghỉ việc" -> NGHI_VIEC
            else -> throw IllegalArgumentException("Không hợp lệ")
        }
    }
}