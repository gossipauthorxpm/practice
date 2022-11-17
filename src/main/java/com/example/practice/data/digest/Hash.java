package com.example.practice.data.digest;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    /**
     * @param hash принимает строку хеша в md5
     * @param data принимает строку данных для преобразования и сравнения в md5
     */
    public static Boolean verifyHash(String hash, String data) {
        try {
            MessageDigest md5_hash = MessageDigest.getInstance("MD5");
            byte[] message_digest = md5_hash.digest(data.getBytes());
            BigInteger pre_hash = new BigInteger(1, message_digest);
            String hash_data = pre_hash.toString(16);

            while (hash_data.length() < 32) {
                hash_data = "0" + hash_data;
            }
            return hash_data.equals(hash);
        } catch (NoSuchAlgorithmException error) {
            System.out.println("Ошибка алгоритма преопразования строки в md5 hash\nHash.verifyHash()\n" + error.toString());
            return null;
        }

    }

    /**
     * @param data принимает строку данных для преобразования и возврата данных в md5
     */
    public static String getHash(String data) {
//      Получение хеша из переменной
        try {
            MessageDigest md5_hash = MessageDigest.getInstance("MD5");
            byte[] message_digest = md5_hash.digest(data.getBytes());
            BigInteger pre_hash = new BigInteger(1, message_digest);
            String hash_data = pre_hash.toString(16);

            while (hash_data.length() < 32) {
                hash_data = "0" + hash_data;
            }
            return hash_data;
        } catch (NoSuchAlgorithmException error) {
            System.out.println("Ошибка алгоритма преопразования строки в md5 hash\nHash.getHash()\n" + error.toString());
            return null;
        }

    }
}
