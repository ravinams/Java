
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class Encryptor {

    private byte[] key;
    
    private static final String ALGORITHM = "AES";

    public Encryptor(byte[] key)
    {
        this.key = key;
        
        
    }

     /**
     * Encrypts the given plain text
     *
     * @param plainText The plain text to encrypt
     */
    public byte[] encrypt(byte[] plainText) throws Exception
    {
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        return cipher.doFinal(plainText);
    }

    
    /**
     * Decrypts the given byte array
     *
     * @param cipherText The data to decrypt
     */
    public byte[] decrypt(byte[] cipherText) throws Exception
    {
        SecretKeySpec sKey = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, sKey);

        return cipher.doFinal(cipherText);
    }


public static void main(String[] args) throws Exception{
byte[] key = "MZygpewJsCpRrfOr".getBytes(StandardCharsets.UTF_8);
String inputString="hyedlajrgje";
byte[] plainText = inputString.getBytes(StandardCharsets.UTF_8);

Encryptor advancedEncryptionStandard = new Encryptor(
        key);
byte[] cipherText = advancedEncryptionStandard.encrypt(plainText);
byte[] decryptedCipherText = advancedEncryptionStandard.decrypt(cipherText);
System.out.println("input text ==>" + inputString);
System.out.println("cipher text ==>" +new String(cipherText));
System.out.println("Plain  text ==>" +new String(decryptedCipherText));

}
    
}
