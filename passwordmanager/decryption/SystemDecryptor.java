package passwordmanager.decryption;

import passwordmanager.utils.SecretKey;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class SystemDecryptor implements Decryptable {

    private String text;
    private byte[] key;
    private SecretKeySpec secretKeySpec;

    public SystemDecryptor(String text) {
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
    public String decrypt() {
        String decryptedString = "";
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            decryptedString = new String(cipher.doFinal(Base64.getDecoder().decode(this.text)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedString;
    }
}
