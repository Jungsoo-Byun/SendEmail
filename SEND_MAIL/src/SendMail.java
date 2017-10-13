import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;








public class SendMail {
	
	
	private String EMAIL_LIST_PATH ;
	private String EMAIL_SERVER ;
	private String EMAIL_PORT ;
	private String EMAIL_ACCOUNT ;
	private String EMAIL_PASSWORD;
	private String EMAIL_TITLE;
	
	
	private String EMAIL_CONTENT = "여기에 내용을적으세요ㅌㅌㅌㅌㅌ가나다라";
	
	/*
	private String EMAIL_CONTENT="Gene2Me(www.gene2.me) 를 이용해주시는 회원님께 감사드립니다.\n\n"
			                              +"2016년 11월3일 부터 Gene2Me 서비스주문 및 회원가입(서비스등록) 시, 회원님께 보다 다양한 정보를 제공하고자 개인정보 제3자 마케팅 정보활용에 대한 약관 동의 항목이 신설 됨에 따라 이에 공지 합니다.\n"
			                              +"본 내용은 2016년 11월3일 이전 회원가입하신 고객님은 해당 되지 않으며, 회원님의 개인정보는 제3자 마케팅 활용 동의에 거부 한 것으로 일괄 처리 됩니다.\n\n"
			                              +"[변경일자]\n"
			                              +"2016년 11월 3일 \n\n"
			                              +"[Gene2Me 서비스 주문 및 회원가입(서비스등록) 시 변경 약관 내용] \n\n"
			                              +"[회원가입(서비스 등록) 시] \n\n"
			                              +"개인정보 제3자 마케팅 활용 동의 (선택)\n\n" 
			                              +"이 약관은 ‘Gene2Me’ (이하 '회사'라 함)가 고객님들에게 보다 다양한 정보를 제공하고, 서비스의 질을 향상시키기 위하여 당사의 비즈니스 파트너에게 본 활용 동의서에 동의한 회원의 개인정보를 제공합니다. \n\n"
			                              +"1. 개인정보가 제공되는 비지니스 파트너 사와 제공 정보, 제공된 정보의 이용목적은 아래와 같습니다. \n\n"             
			                              +"    1) 제공대상자 : 제노힐(주) (www.genoheal.com) \n"
			                              +"    2) 제공정보 : 이름, 이메일, 휴대 전화번호 \n"
			                              +"    3) 이용목적 : 유전자 검사 결과 유형에 따른 마케팅 \n"
			                              +"    4) 이용기간 : 제공동의일로 부터 회원탈퇴 또는 제3자 마케팅 활용 동의 철회 시 까지 \n\n"                   
			                              +"2. 제3자 정보제공의 동의 철회 \n"
			                              +"  - 본 동의서에 동의하고 가입하신 신규회원 중 제3자 정보제공을 철회하고 같은 회원은 이미 제3자에게 제공된 개인정보라 하더라고, 언제든지 열람, 정정, 삭제를 요구할 수 있습니다. "
			                              +"열람, 정정, 삭제 및 정보제공 동의 철회는 전화와 팩스등을 통하여 본인 확인 후 요청할 수 있습니다.  \n\n\n"
			                              +"[서비스 주문 시] \n\n"
			                              +"개인정보 제3자 마케팅 활용 동의 (선택)\n\n" 
			                              +"이 약관은 ‘Gene2Me’ (이하 '회사'라 함)가 고객님들에게 보다 다양한 정보를 제공하고, 서비스의 질을 향상시키기 위하여 당사의 비즈니스 파트너에게 본 활용 동의서에 동의한 회원의 개인정보를 제공합니다. \n\n"
			                              +"1. 개인정보가 제공되는 비지니스 파트너 사와 제공 정보, 제공된 정보의 이용목적은 아래와 같습니다. \n\n"             
			                              +"    1) 제공대상자 : 제노힐(주) (www.genoheal.com) \n"
			                              +"    2) 제공정보 : 주문자 이름, 주문자 이메일, 주문자 휴대 전화번호, 배송지 주소 \n"
			                              +"    3) 이용목적 : 유전자 검사 결과 유형에 따른 마케팅 \n"
			                              +"    4) 이용기간 : 제공동의일로 부터 회원탈퇴 또는 제3자 마케팅 활용 동의 철회 시 까지 \n\n"                   
			                              +"2. 제3자 정보제공의 동의 철회 \n"
			                              +"  - 본 동의서에 동의하고 가입하신 신규회원 중 제3자 정보제공을 철회하고 같은 회원은 이미 제3자에게 제공된 개인정보라 하더라고, 언제든지 열람, 정정, 삭제를 요구할 수 있습니다. "
			                              +"열람, 정정, 삭제 및 정보제공 동의 철회는 전화와 팩스등을 통하여 본인 확인 후 요청할 수 있습니다.  \n\n\n"
			                              +"본 메일은 Gene2Me 발신전용 메일입니다. 관련문의 사항은 대표 이메일 주소(info@gene2.me) 로 문의하거나 TEL 032-210-2360 으로 연락주시기 바랍니다.\n\n\n\n\n" ; 
			                             
    */

			                            
	
	private boolean sendEmail() {
		
		File email_list = new File(EMAIL_LIST_PATH) ;
		
		if(email_list.exists()) {
			
			BufferedReader br = null;
    		
    		try {
    			
    			     String sCurrentLine;
    			     
    			     br = new BufferedReader(new FileReader(email_list));

    			     while ((sCurrentLine = br.readLine()) != null) {
   
    			    		 
    			    	    String email_addr =  sCurrentLine ;
    			    	    
    			    	    System.out.println("Send Email : " +email_addr) ;
    			    	    
    			    	    sendEmail(EMAIL_TITLE, EMAIL_CONTENT, email_addr);

    			     }
    			     
    			     br.close();

    		} catch (IOException e) {
    			e.printStackTrace();

    		} finally {
    			try {
    				if (br != null) br.close();
    				
    			} catch (IOException ex) {
    				ex.printStackTrace();
    			}
    		}
			
		}else{
			
			System.out.println("Email address list file doesn't exist......") ;
		}
		
		
		return true ;
	}
	
	
	
	
	


	private  void sendEmail(String title, String content, String to_mail){

  			
           String subject = title ; 

		   try{
			   
				 // System.out.println("EMAIL Start >>>>>" );

				  Properties props = new Properties();
				  
				  /*
				  props.put("mail.smtp.host", EMAIL_SERVER);
                  props.put("mail.smtp.port", EMAIL_PORT);
				  props.put("mail.transport.protocol", "smtp");
                  props.put("mail.smtp.auth", "true");
                  props.put("mail.smtp.ssl.enable", "true");
                  props.put("mail.smtp.ssl.trust", EMAIL_SERVER);
                  */
                  
                  props.put("mail.smtp.host", EMAIL_SERVER); //SMTP Host
                  props.put("mail.smtp.socketFactory.port", EMAIL_PORT); //SSL Port
                  props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
                  props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
                  props.put("mail.smtp.port", EMAIL_PORT); //SMTP Port
                  
                  // TLS 사용하는 경우
                  props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

/*
                  Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                      protected PasswordAuthentication getPasswordAuthentication() {
                           return new PasswordAuthentication(EMAIL_ACCOUNT, EMAIL_PASSWORD);
                      }
                  });
*/
                  Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                      protected PasswordAuthentication getPasswordAuthentication() {
                           return new PasswordAuthentication(EMAIL_ACCOUNT, EMAIL_PASSWORD);
                      }
                  });
                  
                  session.setDebug(true); //for debug
                  
                  System.out.println(session);

				  String[] ToMailData = to_mail.split("[,]") ;

				  InternetAddress[] to_mail_address = new InternetAddress[ToMailData.length];  

				  for(int i=0;i<ToMailData.length;i++)
					 to_mail_address[i] = new InternetAddress(ToMailData[i]);
                  /*
                  Message mimeMessage = new MimeMessage(session);
                  mimeMessage.setFrom(new InternetAddress(EMAIL_ACCOUNT));
                  mimeMessage.setRecipients(Message.RecipientType.TO, to_mail_address);
                  mimeMessage.setSubject(subject);
                  mimeMessage.setText(content);
                  */
				  
				  MimeMessage mimeMessage = new MimeMessage(session);
			        //set message headers
				  mimeMessage.addHeader("Content-type", "text/HTML; charset=UTF-8");
				  mimeMessage.addHeader("format", "flowed");
				  mimeMessage.addHeader("Content-Transfer-Encoding", "8bit");
			         
				  mimeMessage.setFrom(new InternetAddress(EMAIL_ACCOUNT, "관리자"));
				  mimeMessage.setReplyTo(InternetAddress.parse("no_reply@gene2.me", false));
				  mimeMessage.setRecipients(Message.RecipientType.TO, to_mail_address);
			     
				  mimeMessage.setSubject(subject, "UTF-8");
				  mimeMessage.setText(content, "UTF-8");
				  mimeMessage.setSentDate(new Date());
			 
				  mimeMessage.setRecipients(Message.RecipientType.TO, to_mail_address );
			     
				  
                  System.out.println("test!!!");
                  
                  Transport.send(mimeMessage);
                  
                  System.out.println("test 2222");
                  


			  } 
			  catch(Exception m1)
			  {
				  System.out.println("FAIL..EMAIL :"+m1.getMessage() );
			  }


	}
	
	
	
	
	private String getPropertyName(String key) {
		
        Properties properties = new Properties();
        
        String data = "";
        
        try {
                properties.load(new FileInputStream("app.properties"));
                
                data = new String( properties.getProperty(key).getBytes("8859_1"),"UTF-8" ) ;
                
                System.out.println(key+":"+data) ;
                
                
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        return data ;
    }
	



	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		  System.out.println("Send Mail Utility ver 1.0 created by JS.Byun ");
		  System.out.println("=============================================================================");


		  SendMail app = new  SendMail();
		
		  app.EMAIL_LIST_PATH = app.getPropertyName("email.list") ;
		  app.EMAIL_SERVER = app.getPropertyName("email.server");
		  app.EMAIL_PORT = app.getPropertyName("email.port") ;
		  app.EMAIL_ACCOUNT = app.getPropertyName("email.from.account");
		  app.EMAIL_PASSWORD = app.getPropertyName("email.from.account.passwd");
		  app.EMAIL_TITLE = app.getPropertyName("email.title");
	
		  
          app.sendEmail() ;

	}

}
