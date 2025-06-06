/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.ManageGroup.Handle.VoucherHandle;

import BUS.SaleServices.CheckInfoSale;
import Entity.Voucher;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author MY ACER
 */
public class VoucherValidate {
    private Voucher validatedVoucher;
    private final  CheckInfoSale checkInfoSale;
    
    public VoucherValidate( ) {
       validatedVoucher = new Voucher();
       checkInfoSale = new CheckInfoSale();
    }

    public boolean validateAll(String codeVoucher,
                               String minimizeVoucher,
                               String maxmizeVoucher,
                               String startDay,
                               String endDay,
                               String percent,
                               String numberUser,
                               String describe) {

        boolean isValid = true;

        if (!checkCodeVoucher(codeVoucher)) {
            System.out.println("❌ Mã voucher không hợp lệ");
            isValid = false;
        }

        if (!checkHasVoucher(codeVoucher)) {
            System.out.println("❌ Mã voucher đã tồn tại");
            isValid = false;
        }

        if (!checkMinimizeVoucher(minimizeVoucher)) {
            System.out.println("❌ Giá trị tối thiểu không hợp lệ");
            isValid = false;
        }

        if (!checkMaxmizeVoucher(maxmizeVoucher)) {
            System.out.println("❌ Giá trị tối đa không hợp lệ");
            isValid = false;
        }

        if (!isTimeStampValid(startDay)) {
            System.out.println("❌ Ngày bắt đầu không đúng định dạng Timestamp");
            isValid = false;
        }

        if (!isTimeStampValid(endDay)) {
            System.out.println("❌ Ngày kết thúc không đúng định dạng Timestamp");
            isValid = false;
        }

        if (!isCheckPercent(percent)) {
            System.out.println("❌ Phần trăm giảm giá không hợp lệ (0-100)");
            isValid = false;
        }

        if (!isCheckNumberUser(numberUser)) {
            System.out.println("❌ Số lượng người dùng không hợp lệ");
            isValid = false;
        }

        if (!isCheckDescribe(describe)) {
            System.out.println("❌ Mô tả không hợp lệ");
            isValid = false;
        }

        return isValid;
    }


    public boolean validateAllExpectCodeVoucher(String minimizeVoucher, String maxmizeVoucher, String startDay, String endDay, String percent, String numberUser, String describe){
        return checkMinimizeVoucher(minimizeVoucher) && checkMaxmizeVoucher(maxmizeVoucher) && isTimeStampValid(startDay) && isTimeStampValid(endDay) && isCheckPercent(percent) && isCheckNumberUser(numberUser) && isCheckDescribe(describe);
    }
    
    private boolean checkHasVoucher(String codeVoucher){
        return !checkInfoSale.hasVoucher(codeVoucher);
    }
    
    
    
    private boolean checkCodeVoucher(String codeVoucher){
        if  (codeVoucher.length()  > 11)
            return false;
        this.validatedVoucher.setMaVoucher(codeVoucher);
        return true;
    }
    
    public boolean checkMinimizeVoucher(String minimizeVoucher){  
        Long value = Long.valueOf(minimizeVoucher);
         if ( value <= 0)
             return false;
         this.validatedVoucher.setGiaTriToiThieu(value);
         return true;
    }
    
    public boolean checkMaxmizeVoucher(String maxmizeVoucher){
        Long value = Long.valueOf(maxmizeVoucher);
        if (value <=0)
            return false;
        this.validatedVoucher.setKmToiDa(value);
        return true;
    }
    
    
    public static boolean isTimeStampValid(String inputString){ 
    SimpleDateFormat format = new java.text.SimpleDateFormat("dd-MM-yyyy") ;
    try{
       format.parse(inputString);
       return true;
    }catch(ParseException e){
        e.printStackTrace();
        return false;
    }
}
           
    public boolean isCheckPercent(String percent){
        return Integer.valueOf(percent) > 0; 
    }
    
     public boolean isCheckNumberUser(String numberUser){
        return Integer.valueOf(numberUser) > 0; 
    }
     
     public boolean isCheckDescribe(String describe){
         return describe.length() > 10;
     }

    public Voucher getValidatedVoucher() {
        return validatedVoucher;
    }

    public void setValidatedVoucher(Voucher validatedVoucher) {
        this.validatedVoucher = validatedVoucher;
    }
     
     
    
    
    
    
    
    
    
    //    public Timestamp ConvertDay(String startDay)    {
////       SimpleDateFormat format = new java.text.SimpleDateFormat("dd-MM-yyyy");
//   
//        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//        
//        try {
//            TemporalAccessor temp = formatDateTime.parse(startDay);
//            System.out.println(temp);
//            LocalDateTime localDateTime = LocalDateTime.from(temp);
//                           Timestamp ts = Timestamp.valueOf(localDateTime);
//                      System.out.println(ts);
//        } catch (Exception e){
//            System.out.println("loi");
//        }
//        return null;
//    }
//       Timestamp ts = Timestamp.valueOf(localDateTime);
//        return ts;
//    }

//     public static void main(String[] args){
//         VoucherValidate vv = new VoucherValidate();
//         vv.ConvertDay("1/12/2002 3:05:13");
//         
//         String dateTime = "01/10/2020 06:43:21";
//        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//        try {
//            LocalDateTime localDateTime = LocalDateTime.from(formatDateTime.parse(dateTime));
//               Timestamp ts = Timestamp.valueOf(localDateTime);
//                      System.out.println(ts);
//        } catch(Exception e){
//            System.out.println("Eroor");
//        }
        
//     }
}
