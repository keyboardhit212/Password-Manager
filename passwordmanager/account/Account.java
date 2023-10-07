package passwordmanager.account;

import passwordmanager.decryption.SystemDecryptor;
import passwordmanager.encryption.SystemEncryptor;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Account implements Storable {

    private final String DATE_FORMAT = "MM/dd/yyyy";
    private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
    private String name;
    private String username;
    private String password;
    private LocalDate date;
    private String accountInText;

    public Account(String name, String username, String password) {
        this.name = name.replaceAll("\\s", "");
        this.password = password;
        this.username = username;
        this.date = LocalDate.now();
        this.accountInText = "";
    }

    public Account(String accountInText) throws DateTimeException{
        if (!accountInText.contains("/"))
            throw new DateTimeException("Invalid Date Format");
        this.accountInText = accountInText;
        Scanner console = new Scanner(accountInText);
        this.name = console.next();
        this.username = decryptText(console.next());
        this.password = decryptText(console.next());
        String dateInText = console.next();
        this.date = LocalDate.of(getYear(dateInText), getMonth(dateInText), getDay(dateInText));
    }

    public String getName() {
        return this.name;
    }

    public String getEncryptedUsername() {
        return new SystemEncryptor(this.username).encrypt();
    }

    public String getDecryptedUsername() {
        return new SystemDecryptor(getEncryptedUsername()).decrypt();
    }

    public String getEncryptedPassword() {return new SystemEncryptor(this.password).encrypt();}

    public String getDecryptedPassword() {return new SystemDecryptor(getEncryptedPassword()).decrypt();}

    public String getFormattedDate() {
        return this.date.format(FORMATTER);
    }

    @Override
    public String getWriteState() {
        return this.name + " " + getEncryptedUsername() + " " + getEncryptedPassword() + " " + getFormattedDate();
    }

    @Override
    public String getReadState() {
        return this.name + " " + getDecryptedUsername() + " " + getDecryptedPassword() + " " + getFormattedDate();
    }

    @Override
    public String toString() {
        return getReadState();
    }

    private String decryptText(String text) {
        return new SystemDecryptor(text).decrypt();
    }

    private int getMonth(String text) {
        String month = splitText(text)[0];
        return Integer.parseInt(month);
    }

    private int getDay(String text) {
        String day = splitText(text)[1];
        return Integer.parseInt(day);
    }

    private int getYear(String text) {
        String year = splitText(text)[2];
        return Integer.parseInt(year);
    }

    private String[] splitText(String text) {
        return text.split("/");
    }
}
