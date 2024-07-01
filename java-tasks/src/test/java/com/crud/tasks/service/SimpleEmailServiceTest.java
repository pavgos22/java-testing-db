package com.crud.tasks.service;

import com.crud.tasks.domain.Mail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SimpleEmailServiceTest {

    @InjectMocks
    private SimpleEmailService simpleEmailService;

    @Mock
    private JavaMailSender javaMailSender;

    @Test
    public void shouldSendEmail() {
        //Given
        Mail mail = Mail.builder()
                .mailTo("test@test.com")
                .toCc("cc@test.com")
                .subject("Subject of email")
                .message("Message of email")
                .build();

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setCc(mail.getToCc());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());

        //When
        simpleEmailService.send(mail);

        //Then
        verify(javaMailSender, times(1)).send(mailMessage);
    }

    @Test
    void shouldSendEmailWithCc() {
        // Given
        Mail mail = new Mail("test@example.com", "cc@example.com", "Test subject", "Test message");

        // When
        simpleEmailService.send(mail);

        // Then
        ArgumentCaptor<SimpleMailMessage> mailMessageCaptor = ArgumentCaptor.forClass(SimpleMailMessage.class);
        verify(javaMailSender, times(1)).send(mailMessageCaptor.capture());
        SimpleMailMessage capturedMail = mailMessageCaptor.getValue();
        assertEquals("cc@example.com", capturedMail.getCc()[0]);
    }

    @Test
    void shouldNotSendEmailWhenMailToIsNull() {
        // Given
        Mail mail = new Mail(null, "cc@example.com", "Test subject", "Test message");

        // When
        simpleEmailService.send(mail);

        // Then
        verify(javaMailSender, never()).send(any(SimpleMailMessage.class));
    }

    @Test
    public void shouldSendEmailWithoutCcWhenCcIsNull() {
        //Given
        Mail mail = Mail.builder()
                .mailTo("test@test.com")
                .toCc(null)
                .subject("Subject of email")
                .message("Message of email")
                .build();

        SimpleMailMessage expectedMailMessage = new SimpleMailMessage();
        expectedMailMessage.setTo(mail.getMailTo());
        expectedMailMessage.setSubject(mail.getSubject());
        expectedMailMessage.setText(mail.getMessage());

        //When
        simpleEmailService.send(mail);

        //Then
        verify(javaMailSender, times(1)).send(expectedMailMessage);
    }


}