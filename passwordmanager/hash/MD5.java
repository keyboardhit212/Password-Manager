package passwordmanager.hash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.NoSuchElementException;

public class MD5 implements Hashable {

    private final static String ALGORITHM_TYPE = "MD5";
    private String textToHash;
    private MessageDigest md;

    public MD5(String text) throws NoSuchAlgorithmException {
        textToHash = text;
        md = MessageDigest.getInstance(ALGORITHM_TYPE);
    }

    @Override
    public String getHash() {
        return bytesToHex();
    }

    private byte[] digest() {
        return md.digest(textToHash.getBytes(StandardCharsets.UTF_8));
    }

    private String bytesToHex() {
        StringBuilder stringBuilder = new StringBuilder();
        byte[] results = digest();
        for (byte b : results) {
            stringBuilder.append(String.format("%02x", b));
        }
        return stringBuilder.toString();
    }
}
