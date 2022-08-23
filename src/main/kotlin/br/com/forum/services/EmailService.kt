package br.com.forum.services

import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailService(
    private val javaMailSender: JavaMailSender
) {

    fun notificar(emailAutor: String){
        val message = SimpleMailMessage()

        message.setSubject("[FORUM] Seu topico foi respondido!")
        message.setText("Oi! Equipe do Forum passando para avisar que o seu email foi respondido.")
        message.setTo(emailAutor)

        javaMailSender.send(message)
    }

}