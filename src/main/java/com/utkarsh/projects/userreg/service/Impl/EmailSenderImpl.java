package com.utkarsh.projects.userreg.service.Impl;

import com.utkarsh.projects.userreg.service.EmailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class EmailSenderImpl implements EmailSender {
    private final JavaMailSender mailSender;

    public EmailSenderImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    private final Logger log = LoggerFactory.getLogger(EmailSenderImpl.class);

    @Override
    @Async
    public void sendMail(String to, String email) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, "utf-8");
            messageHelper.setText(email, true);
            messageHelper.setTo(to);
            messageHelper.setFrom("utkarshkumar@testmail.com");
            messageHelper.setSubject("Confirm You Email");
            mailSender.send(message);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("error while sending email :: {}", ex.getMessage());
        }
    }
}
