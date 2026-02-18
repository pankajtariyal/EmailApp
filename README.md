# 📧 EmailApp – JavaFX Email Sender
**🚀 Overview**
- EmailApp is a JavaFX-based desktop application that allows users to send emails using Gmail SMTP.

**The application provides two separate pages:**
- 📩 Text Email Page – Send plain text messages
- 📎 File Email Page – Send attachments along with text message

**Built using:**
- Java 8
- JavaFX
- JFoenix (Material Design UI)
-JavaMail (Jakarta Mail API)
- Maven

# 🖥️ Application Features
🔹 1️⃣ Text Email Page

**Allows sending simple text-based emails.**
`Fields:`

- Email From
- Email To
- Message Body
- Buttons:
- Send
- Reset

🔹 2️⃣ File + Message Page

**Allows sending email with attachment and message.**`Fields:`
- Email From
- Email To
- File Path (with Choose File button)
- Message Body
- Buttons:
- Choose File
- Send
- Reset

# 🛠️ Technologies Used
- Java 8
- JavaFX
- JFoenix UI Library
- Jakarta Mail API
- Maven Build Tool

# 📂 Project Structure
```text
EmailApp
├── pom.xml
├── README.md
└── src
    ├── main
    │     ├── java
    │     │   └── com.email
    │     │         ├──────App.java
    │     │         ├──────EmailConfig.java
    │     │         ├──────EmailFilePage.java
    │     │         ├──────EmailTextPage.java
    │     │         ├──────HomeMainPageController.java
    │     └── resources ----- `contains .fxml file`
    └── test
```

# ⚙️ How To Run The Project
Step 1️⃣ – Clone the repository
- git clone https://github.com/pankajtariyal/EmailApp.git
- `cd EmailApp`

Step 2️⃣ – Build using Maven
- `mvn clean package`

Step 3️⃣ – `Run the Application`

- Run the main JavaFX class from your IDE
OR use generated jar from:

- `target/EmailApp-1.0-SNAPSHOT.jar`