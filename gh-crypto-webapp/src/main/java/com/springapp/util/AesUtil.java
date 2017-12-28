package com.springapp.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by songlinwei on 17/12/26.
 */
public class AesUtil {
    private static final Logger logger = LoggerFactory.getLogger(AesUtil.class);

    //算法名称
    private static final String KEY_ALGORITHM = "AES";
    //密钥大小
    private static final int KEY_SIZE = 128;
    //算法名称/加密模式/填充方式
    private static final String CIPHER_ALGORITHM = "SHA1PRNG";
    //加密密钥
    private static final String KEY = "Ajklandlk.6400271qaz";
    private static final String CHARSET = "utf-8";

    private AesUtil() {

    }

    /**
     * AES加密为base 64 code
     *
     * @param data 待加密的内容
     * @return 加密后的base 64 code
     * @throws Exception
     */
    public static String aesEncrypt(String data) {
        return aesEncrypt(data, KEY);
    }

    /**
     * AES加密为base 64 code
     *
     * @param data       待加密的内容
     * @param encryptKey 加密密钥
     * @return 加密后的base 64 code
     * @throws Exception
     */
    public static String aesEncrypt(String data, String encryptKey) {
        byte[] aetb = aesEncryptToBytes(data, encryptKey);
        return aetb != null ? Base64Util.encode(aesEncryptToBytes(data, encryptKey)) : null;
    }

    /**
     * AES加密
     *
     * @param data       待加密的内容
     * @param encryptKey 加密密钥
     * @return 加密后的byte[]
     * @throws Exception
     */
    public static byte[] aesEncryptToBytes(String data, String encryptKey) {
        KeyGenerator kgen = null;
        try {
            kgen = keyGenerator(encryptKey);
        } catch (Exception e) {
            logger.error("aesEncryptToBytes keyGenerator Exception {}:{}", e.getClass().getName(), e);
        }
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            logger.error("aesEncryptToBytes cipher NoSuchAlgorithmException {}:{}", e.getClass().getName(), e);
        } catch (NoSuchPaddingException e) {
            logger.error("aesEncryptToBytes cipher NoSuchPaddingException {}:{}", e.getClass().getName(), e);
        }
        if (null != kgen && null != cipher) {
            try {
                cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), KEY_ALGORITHM));
            } catch (InvalidKeyException e) {
                logger.error("aesEncryptToBytes cipher InvalidKeyException {}:{}", e.getClass().getName(), e);
            }
            try {
                return cipher.doFinal(data.getBytes(CHARSET));
            } catch (IllegalBlockSizeException e) {
                logger.error("aesEncryptToBytes cipher IllegalBlockSizeException {}:{}", e.getClass().getName(), e);
            } catch (BadPaddingException e) {
                logger.error("aesEncryptToBytes cipher BadPaddingException {}:{}", e.getClass().getName(), e);
            } catch (UnsupportedEncodingException e) {
                logger.error("aesEncryptToBytes cipher UnsupportedEncodingException {}:{}", e.getClass().getName(), e);
            }
        }
        return null;
    }


    /**
     * 将base 64 code AES解密
     *
     * @param data 待解密的base 64 code
     * @return 解密后的string
     * @throws Exception
     */
    public static String aesDecrypt(String data) {
        return aesDecrypt(data, KEY);
    }

    /**
     * 将base 64 code AES解密
     *
     * @param data       待解密的base 64 code
     * @param decryptKey 解密密钥
     * @return 解密后的string
     * @throws Exception
     */
    public static String aesDecrypt(String data, String decryptKey) {
        String ae = aesDecryptByBytes(Base64Util.decode(data), decryptKey);
        return ae != null ? ae : null;
    }


    /**
     * AES解密
     *
     * @param encryptBytes 待解密的byte[]
     * @param decryptKey   解密密钥
     * @return 解密后的String
     * @throws Exception
     */
    public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) {
        KeyGenerator kgen = null;
        try {
            kgen = keyGenerator(decryptKey);
        } catch (Exception e) {
            logger.error("aesDecryptByBytes keyGenerator Exception {}:{}", e.getClass().getName(), e);
        }
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            logger.error("aesDecryptByBytes Cipher NoSuchAlgorithmException {}:{}", e.getClass().getName(), e);
        } catch (NoSuchPaddingException e) {
            logger.error("aesDecryptByBytes Cipher NoSuchPaddingException {}:{}", e.getClass().getName(), e);
        }
        if (null != kgen && null != cipher) {
            try {
                cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), KEY_ALGORITHM));
            } catch (InvalidKeyException e) {
                logger.error("aesDecryptByBytes Cipher InvalidKeyException {}:{}", e.getClass().getName(), e);
            }
            try {
                byte[] decryptBytes = cipher.doFinal(encryptBytes);
                return new String(decryptBytes);
            } catch (IllegalBlockSizeException e) {
                logger.error("aesDecryptByBytes Cipher IllegalBlockSizeException {}:{}", e.getClass().getName(), e);
            } catch (BadPaddingException e) {
                logger.error("aesDecryptByBytes Cipher BadPaddingException {}:{}", e.getClass().getName(), e);
            }
        }
        return null;
    }


    /**
     * 生成密钥key对象
     *
     * @param keyStr 密钥字符串
     * @return 密钥对象
     */
    private static KeyGenerator keyGenerator(String keyStr) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance(KEY_ALGORITHM);
        SecureRandom random = SecureRandom.getInstance(CIPHER_ALGORITHM);//需要自己手动设置
        random.setSeed(keyStr.getBytes());
        kgen.init(KEY_SIZE, random);
        return kgen;
    }


    public static void main(String[] args) throws Exception {
        String decryptData = "wo加密21e1edefwda32r9t48rqghflabnvjlkasbu89238unfjdnb@@!#!##*$U%$&%*(%!@#$%^&*()_+-=密钥和解密密w加密密钥和解密密加密密钥和解密密加密密钥和解密密加密密钥和解密密加密密钥和解密密o";
        long start = System.currentTimeMillis();
        System.out.println("加密密钥和解密密钥：" + KEY + "加密前：" + decryptData);
        String encryptData = aesEncrypt(decryptData);
        System.out.println("加密耗时 " + (System.currentTimeMillis() - start) + " ms");
        System.out.println(encryptData);

        start = System.currentTimeMillis();
        System.out.println("加密密钥和解密密钥：" + KEY + "解密前：" + encryptData);
        decryptData = aesDecrypt(encryptData);
        System.out.println("解密耗时 " + (System.currentTimeMillis() - start) + " ms");
        System.out.println(decryptData);
    }

}
