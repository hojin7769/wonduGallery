package com.example.wondugallery.jasypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class JasyptTest {

    public static void main(String[] args) {

        String password = "jdbc:mysql://112.169.9.183:3305/board";

        StandardPBEStringEncryptor jasypt = new StandardPBEStringEncryptor();
        jasypt.setPassword("MyPrivateKey");
        jasypt.setAlgorithm("PBEWITHMD5ANDDES");

        String encryptedText = jasypt.encrypt(password);
        String decryptedText = jasypt.decrypt(encryptedText);

        System.out.println("encryptedText = " + encryptedText);
        System.out.println("decryptedText = " + decryptedText);

    }
}
