# Password-Manager
A simple CLI-based application that keeps your account safe

# Instructions
A JAR file is provided and you can simply execute it by typing **java -jar passwordmanager.jar** on your CLI/Terminal.

# Dependencies
You must provide/create a text file named **login.txt** with an MD5 hash of your password inside the folder where you kept the **JAR File**. This file serves as the basis to be able to access the system. If no **login.txt** file is found then the application will display an error message and closes itself.
Likewise the application also creates a text file named **account.txt** where it stores all your account details completely encrypted.
