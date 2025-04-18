/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.ManageGroup.Handle.SanPhamHandle;

import Entity.SanPham;


public class SanPhamValidate {
    private SanPham validatedsanPham ;

    public SanPham getValidatedsanPham() {
        return validatedsanPham;
    }

    public void setValidatedsanPham(SanPham validatedsanPham) {
        this.validatedsanPham = validatedsanPham;
    }
  
    private boolean CheckGia(String Gia){
        try{
            long gia = Long.valueOf(Gia);
        } catch (NumberFormatException e){
           return false;
        }
         return true;
      
}
    private boolean CheckHinhAnh (String url){
        if(url ==null) return false;
         return url.length()>0;
     }
     private boolean CheckTen (String Ten){
         return Ten.length()>0;
     }

  
     private boolean CheckMota (String Mota){
         return Mota.length()>20;
     }

    public boolean AllValidate(String Gia, String Ten, String Mota, String url) {
        boolean isValid = true;

        if (!CheckGia(Gia)) {
            System.out.println("❌ Giá không hợp lệ");
            isValid = false;
        }

        if (!CheckTen(Ten)) {
            System.out.println("❌ Tên sản phẩm không hợp lệ");
            isValid = false;
        }

        if (!CheckMota(Mota)) {
            System.out.println("❌ Mô tả không hợp lệ");
            isValid = false;
        }

        if (!CheckHinhAnh(url)) {
            System.out.println("❌ URL hình ảnh không hợp lệ");
            isValid = false;
        }

        return isValid;
    }



}
