package com.example.ManagerShoers.service;

import com.example.ManagerShoers.dao.model.DataMailDTO;

import javax.mail.MessagingException;

public interface MailService {
    void sendHtmlMail(DataMailDTO dataMail) throws MessagingException;
}
