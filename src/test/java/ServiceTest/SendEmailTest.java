package ServiceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.service.email.EmailService;

@ContextConfiguration(locations = { "classpath:/mail-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SendEmailTest {
	
	@Autowired
	EmailService emailService;

	@Test
	public void sendEmailTest(){
		String receiver = "klaudia.elblag@gmail.com";
		
		String sender = "florist.project@gmail.com";
		String subject = "Florist";
		String message = "Your order has been registered. Thank you for choosing our Florist's.";
		
		emailService.sendEmail(receiver, sender, subject, message);
	}
}
