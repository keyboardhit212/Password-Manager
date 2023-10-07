package passwordmanager.encryption;

import passwordmanager.utils.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class SystemEncryptor implements Encryptable {

    private String text;
    private byte[] key;
    private SecretKeySpec secretKeySpec;

    public SystemEncryptor(String text) {
        this.text = text;
        init();
    }

    private void init() {
        MessageDigest sha = null;
        try {
            key = SecretKey.KEY.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKeySpec = new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String encrypt() {
        String encryptedString = "";
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            encryptedString = Base64.getEncoder().encodeToString(cipher.doFinal(this.text.getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedString;
    }
}
