package com.example.wondugallery.jasypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class JasyptTest {

    public static void main(String[] args) {

        String url = "jdbc:mysql://112.169.9.183/WONDU";
        String userId = "root";
        String password = "goodcen21$";

        StandardPBEStringEncryptor jasypt = new StandardPBEStringEncryptor();
        jasypt.setPassword("MyPrivateKey");
        jasypt.setAlgorithm("PBEWITHMD5ANDDES");

        String encryptedText = jasypt.encrypt(url);
        String encryptedText1 = jasypt.encrypt(userId);
        String encryptedText2 = jasypt.encrypt(password);
        String decryptedText = jasypt.decrypt(encryptedText);

        System.out.println("encryptedText = " + encryptedText);
        System.out.println("encryptedText1 = " + encryptedText1);
        System.out.println("encryptedText2 = " + encryptedText2);
        System.out.println("decryptedText = " + decryptedText);

    }
}
