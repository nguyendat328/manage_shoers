package com.example.ManagerShoers.service.impl;

import com.example.ManagerShoers.dao.model.DataMailDTO;
import com.example.ManagerShoers.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;

@Service
@Slf4j
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender mailSender;

//    @Autowired
//    private SpringTemplateEngine templateEngine;

    @Override
    public void sendHtmlMail(DataMailDTO dataMail) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");

//        Context context = new Context();
//        context.setVariables(dataMail.getProps());
//
//        String html = templateEngine.process(templateName, context);
//
//        helper.setTo(dataMail.getTo());
//        helper.setSubject(dataMail.getSubject());
//        helper.setText(html, true);
          helper.setTo(dataMail.getTo());
          helper.setSubject(dataMail.getSubject());
          helper.setText("Trạng thái chờ xét duyệt sản phẩm", true);

        mailSender.send(message);
    }
}
