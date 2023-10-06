package com.example.wondugallery.jasypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class JasyptTest {

    public static void main(String[] args) {

        String url = "jdbc:mysql://112.169.9.183/WONDU";
        String asskey = "root";
        String secretKey = "goodcen21$";

        StandardPBEStringEncryptor jasypt = new StandardPBEStringEncryptor();
        jasypt.setPassword("MyprivateKeyIsS3Buket#@HojinUseKeyEncoding");
        jasypt.setAlgorithm("PBEWITHMD5ANDDES");

        String encryptedText = jasypt.encrypt(url);
        String encryptedText1 = jasypt.encrypt(asskey);
        String encryptedText2 = jasypt.encrypt(secretKey);
        String decryptedText = jasypt.decrypt(encryptedText);

        System.out.println("encryptedText = " + encryptedText);
        System.out.println("assKey = " + encryptedText1);
        System.out.println("secretKey = " + encryptedText2);
        System.out.println("decryptedText = " + decryptedText);

    }
}
