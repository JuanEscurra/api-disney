package com.challenge.apidisney.services;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private SendGrid sendGrid;

    @Value("${app.sendgrid.email.main}")
    private String emailMain;

    @Value("${app.sendgrid.template.register}")
    private String templateRegister;

    public boolean sendEmail(String email) {
        Mail mail = prepareMail(email);
        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        try {
            request.setBody(mail.build());
            Response response = sendGrid.api(request);
            return response != null;
        } catch (Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
            return false;
        }
    }

    public Mail prepareMail(String email) {
        Mail mail = new Mail();
        Email fromEmail = new Email(emailMain);
        Email toEmail = new Email(email);

        Personalization personalization = new Personalization();
        personalization.addTo(toEmail);

        mail.setFrom(fromEmail);
        mail.addPersonalization(personalization);
        mail.setTemplateId(templateRegister);
        return mail;
    }
}
