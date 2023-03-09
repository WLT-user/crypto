package RSA;

import java.io.File;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Scanner;

public class RSA {
	static String data;
	static byte[] cipherData;
	static byte[] plainData;
	static KeyPair keyPair; 
	static PublicKey pubKey; 
	static PrivateKey priKey;
		
	static String encode() throws Exception{
		 // �������һ����Կ��������Կ��˽Կ��
        keyPair = RSAUtils.generateKeyPair();
        // ��ȡ ��Կ �� ˽Կ
        pubKey = keyPair.getPublic();
        priKey = keyPair.getPrivate();
        System.out.println("��Կ����:"+pubKey);
        System.out.println("˽Կ����:"+priKey);
        // ���� ��Կ �� ˽Կ
        RSAUtils.saveKeyForEncodedBase64(pubKey, new File("pub.txt"));
        RSAUtils.saveKeyForEncodedBase64(priKey, new File("pri.txt"));
        
        cipherData = clientEncrypt(data.getBytes(), new File("pub.txt"));
        String cipherDataBase64 = Base64.getEncoder().encodeToString(cipherData);
        System.out.println("����Base64:"+cipherDataBase64);
		return cipherDataBase64;
	}
	
	static String decode() throws Exception{
		plainData = serverDecrypt(cipherData, new File("pri.txt"));
        // ����鿴ԭ��
        String plainDataBase64 = Base64.getEncoder().encodeToString(plainData);
        String s = new String(Base64.getDecoder().decode(plainDataBase64));
		return s;
		
	}
	
    public static void main(String[] args) throws Exception {
    	
  
        // ԭ������
        Scanner scan = new Scanner(System.in);
        System.out.print("����Ҫ���ܵ�����:");
        String data = scan.next();
        
        // �������һ����Կ��������Կ��˽Կ��
        KeyPair keyPair = RSAUtils.generateKeyPair();
        // ��ȡ ��Կ �� ˽Կ
        PublicKey pubKey = keyPair.getPublic();
        PrivateKey priKey = keyPair.getPrivate();
        System.out.println("��Կ����:"+pubKey);
        System.out.println("˽Կ����:"+priKey);
        // ���� ��Կ �� ˽Կ
        RSAUtils.saveKeyForEncodedBase64(pubKey, new File("pub.txt"));
        RSAUtils.saveKeyForEncodedBase64(priKey, new File("pri.txt"));


        /*
         * �������������������Կ�Ա���,
         * �����������ʵ��Ӧ����, �ͻ��˺ͷ���˷ֱ����ֳɵĹ�Կ��˽Կ����/�������ݡ�
         */

        // �ͻ���: ����
        cipherData = clientEncrypt(data.getBytes(), new File("pub.txt"));
        String cipherDataBase64 = Base64.getEncoder().encodeToString(cipherData);
        System.out.println("����Base64:"+cipherDataBase64);
        // �����: ����
        byte[] plainData = serverDecrypt(cipherData, new File("pri.txt"));
        // ����鿴ԭ��
        String plainDataBase64 = Base64.getEncoder().encodeToString(plainData);
        String s = new String(Base64.getDecoder().decode(plainDataBase64));
        System.out.println("����Base64:"+plainDataBase64); 
        System.out.println("����:"+s);  // �����ӡ
    }

    /**
     * �ͻ��˼���, ���ؼ��ܺ������
     */
    private static byte[] clientEncrypt(byte[] plainData, File pubFile) throws Exception {
        // ��ȡ��Կ�ļ�, ������Կ����
        PublicKey pubKey = RSAUtils.getPublicKey(IOUtils.readFile(pubFile));
        // �ù�Կ��������
        byte[] cipher = RSAUtils.encrypt(plainData, pubKey);

        return cipher;
    }

    /**
     * ����˽���, ���ؽ��ܺ������
     */
    private static byte[] serverDecrypt(byte[] cipherData, File priFile) throws Exception {
        // ��ȡ˽Կ�ļ�, ����˽Կ����
        PrivateKey priKey = RSAUtils.getPrivateKey(IOUtils.readFile(priFile));
        // ��˽Կ��������
        byte[] plainData = RSAUtils.decrypt(cipherData, priKey);

        return plainData;
    }

}