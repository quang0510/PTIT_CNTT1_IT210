package org.example.BaiTap.Bai4;

public class Bai4 {
   // Cách 1: Constructor Injection
//   @Service
//   public class NotificationService {
//
//       private final EmailSender emailSender;
//       private final SmsSender smsSender;
//
//       public NotificationService(EmailSender emailSender, SmsSender smsSender) {
//           this.emailSender = emailSender;
//           this.smsSender = smsSender;
//       }
//
//       public void notifyUser(String message) {
//           emailSender.send(message);
//
//           try {
//               smsSender.send(message);
//           } catch (Exception e) {
//               System.out.println("SMS lỗi, fallback sang Email");
//           }
//       }
//   }



    // Cách 2: Field Injection
//    @Service
//    public class NotificationService {
//
//        @Autowired
//        private EmailSender emailSender;
//
//        @Autowired
//        private SmsSender smsSender;
//
//        public void notifyUser(String message) {
//            emailSender.send(message);
//            smsSender.send(message);
//        }
//    }


    /*
    *   Tiêu chí	    Constructor Injection	       Field Injection
    *
        Tính rõ ràng	  Rõ dependency	                Ẩn dependency
        Test	            Dễ mock	                    Khó test
        Immutable	       Có thể dùng final	           Không
        Null safety	        An toàn	                     Dễ null
        Best Practice      Chuẩn Spring	              Không khuyến khích
* */
}
