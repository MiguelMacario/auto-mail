# 📧 AutoEmail - Sistema de Envio Automático de E-mails

> Projeto desenvolvido em Spring Boot com o objetivo de automatizar o envio de e-mails personalizados, armazenando o histórico de mensagens enviadas.
> 

---

## 🚀 Funcionalidades

- Envio automático de e-mails com base em mensagens cadastradas.
- Registro de histórico de envios (data, tipo, destinatário, conteúdo).
- Integração com SMTP configurado via `application.properties`.
- Persistência em banco de dados usando Spring Data JPA.

---

## ⚙️ Tecnologias

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- Spring Mail
- PostgreSQL
- Maven

---

## 🧰 Pré-requisitos

- JDK 17 instalado
- Maven configurado
- Acesso a um servidor SMTP (ex: Gmail)
- Variáveis de ambiente ou `application.properties` configuradas:
    
    ```
    spring.mail.host=smtp.gmail.com
    spring.mail.port=587
    spring.mail.username=seu_email@gmail.com
    spring.mail.password=sua_senha_de_aplicativo
    spring.mail.properties.mail.smtp.auth=true
    spring.mail.properties.mail.smtp.starttls.enable=true
    
    ```
    

---

## 📫 Como usar

Exemplo de requisição para enviar um e-mail:

```json
POST /email/send
{
  "email": "destinatario@exemplo.com",
  "messageId": 1
}
```

Resposta esperada:

```json
{
  "status": "success",
  "message": "E-mail enviado com sucesso!"
}
```

---

## 👨‍💻 Autor

**Miguel Macario dos Santos**

📧 miguel251028@gmail.com

💼 https://www.linkedin.com/in/miguel-macario/

---

## 🪪 Licença

Este projeto está sob a licença MIT — veja o arquivo LICENSE para detalhes.
