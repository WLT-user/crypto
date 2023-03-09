package RSA;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.io.File;
import java.io.IOException;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * RSA �����ࣨ����/������Կ�ԡ����ܡ����ܣ�
 */
public class RSAUtils {

    /** �㷨���� */
    private static final String ALGORITHM = "RSA";

    /** ��Կ���� */
    private static final int KEY_SIZE = 2048;

    /**
     * ���������Կ�ԣ�������Կ��˽Կ��
     */
    public static KeyPair generateKeyPair() throws Exception {
        // ��ȡָ���㷨����Կ��������
        KeyPairGenerator gen = KeyPairGenerator.getInstance(ALGORITHM);

        // ��ʼ����Կ����������ָ����Կ����, ʹ��Ĭ�ϵİ�ȫ�����Դ��
        gen.initialize(KEY_SIZE);

        // �������һ����Կ��������Կ��˽Կ��
        return gen.generateKeyPair();
    }

    /**
     * �� ��Կ/˽Կ ������� Base64 �ĸ�ʽ���浽ָ���ļ�
     */
    public static void saveKeyForEncodedBase64(Key key, File keyFile) throws IOException {
        // ��ȡ��Կ�����ĸ�ʽ
        byte[] encBytes = key.getEncoded();
        // ת��Ϊ Base64 �ı�
        String encBase64 = new BASE64Encoder().encode(encBytes);
        // ���浽�ļ�
        IOUtils.writeFile(encBase64, keyFile);
    }

    /**
     * ���ݹ�Կ�� Base64 �ı�������Կ����
     */
    public static PublicKey getPublicKey(String pubKeyBase64) throws Exception {
        // �� ��Կ��Base64�ı� ת��Ϊ�ѱ���� ��Կbytes
        byte[] encPubKey = new BASE64Decoder().decodeBuffer(pubKeyBase64);
        // ���� �ѱ���Ĺ�Կ���
        X509EncodedKeySpec encPubKeySpec = new X509EncodedKeySpec(encPubKey);
        // ��ȡָ���㷨����Կ����, ���� �ѱ���Ĺ�Կ���, ���ɹ�Կ����
        return KeyFactory.getInstance(ALGORITHM).generatePublic(encPubKeySpec);
    }

    /**
     * ����˽Կ�� Base64 �ı�����˽Կ����
     */
    public static PrivateKey getPrivateKey(String priKeyBase64) throws Exception {
        // �� ˽Կ��Base64�ı� ת��Ϊ�ѱ���� ˽Կbytes
        byte[] encPriKey = new BASE64Decoder().decodeBuffer(priKeyBase64);

        // ���� �ѱ����˽Կ���
        PKCS8EncodedKeySpec encPriKeySpec = new PKCS8EncodedKeySpec(encPriKey);

        // ��ȡָ���㷨����Կ����, ���� �ѱ����˽Կ���, ����˽Կ����
        return KeyFactory.getInstance(ALGORITHM).generatePrivate(encPriKeySpec);
    }

    /**
     * ��Կ��������
     */
    public static byte[] encrypt(byte[] plainData, PublicKey pubKey) throws Exception {
        // ��ȡָ���㷨��������
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        // ��ʼ������������Կ����ģ�ͣ�
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        // ��������, ���ؼ��ܺ������
        return cipher.doFinal(plainData);
    }

    /**
     * ˽Կ��������
     */
    public static byte[] decrypt(byte[] cipherData, PrivateKey priKey) throws Exception {
        // ��ȡָ���㷨��������
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        // ��ʼ����������˽Կ����ģ�ͣ�
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        // ��������, ���ؽ��ܺ������
        return cipher.doFinal(cipherData);
    }
}