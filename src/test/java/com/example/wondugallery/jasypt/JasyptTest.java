package com.example.wondugallery.jasypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class JasyptTest {

    public static void main(String[] args) {

        String url = "jdbc:mysql://141.164.53.210:3305/test";
        String userId = "testUser";
        String password = "goodcen21$";

        StandardPBEStringEncryptor jasypt = new StandardPBEStringEncryptor();
        jasypt.setPassword("MyPrivateKey");
        jasypt.setAlgorithm("PBEWITHMD5ANDDES");

        String encryptedText = jasypt.encrypt(url);
        String encryptedText1 = jasypt.encrypt(userId);
        String encryptedText2 = jasypt.encrypt(password);
        String decryptedText = jasypt.decrypt(encryptedText);

        System.out.println("encryptedText = " + encryptedText);
        System.out.println("encryptedText = " + encryptedText1);
        System.out.println("encryptedText = " + encryptedText2);
        System.out.println("decryptedText = " + decryptedText);

    }
}
