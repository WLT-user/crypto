package DES;
import java.io.UnsupportedEncodingException;

public class DESTest {
	
	static String encode(String str1,String str3) {
		String text = stringToBin(str1);
		byte[] textByte = text.getBytes();	
		for (int i = 0; i < textByte.length; i++) 
			textByte[i] -= '0';
		String key = stringToBin(str3);
		byte[] keyByte = key.getBytes();
		for (int i = 0; i < keyByte.length; i++) 
			keyByte[i] -= '0';
		byte[] cipherByte = DES.encrypt(textByte, keyByte);
		String ciphertext = printByteArr(cipherByte);
		return ciphertext;
	}
	
	static String decode(String str1,String str3) {
		byte[] textByte = str1.getBytes();	
		for (int i = 0; i < textByte.length; i++) 
			textByte[i] -= '0';
		String key = stringToBin(str3);
		byte[] keyByte = key.getBytes();
		for (int i = 0; i < keyByte.length; i++) 
			keyByte[i] -= '0';
		byte[] plainByte = DES.decrypt(textByte, keyByte);
		String plainText = byteToString(plainByte);
		return plainText;
	}
	
	
	static String byteToString(byte[] b) {
		String str = "";
		char s[]= {'1','2','3','4','5','6','7','8'};
		for (int i = 0; i < b.length; i++) {
			s[i%8]=(char)(b[i]+48);
			if((i+1)%8==0) {
				str+=(char)covert(s);
			}
		}
		return str;
		
	}
	
	static int power(int a) //计算x的a次幂
	{
		int sum=2;
		if(a==0)
		{
			return 1;
		}
		else
		{
			while(a>1)
			{
				sum=sum*2;
				a--;
			}
			return sum;
		}
	}
	 
	static int covert(char s[]) //实现二进制转为十进制
	{
		
		int i=0,sum=0;
		for(i=8;i>=1;i--)
		{
			if((s[i-1]-'0')==1)
			sum=sum+power(8-i);
		}
		return sum;
	}

	static String printByteArr(byte[] b) {
		String s = "";
		for (int i = 0; i < b.length; i++) {
			s+=b[i];
			System.out.print(b[i]);
			if (i % 8 == 7) 
				System.out.print(" ");
		}
		System.out.println();
		return s;
	}
	
	static String stringToBin(String str) {
		String Hexstr = "";
		String s = "";
		byte[] b = new byte[4];
		for (int i = 0; i < str.length(); i++) {
			
			int ch = (int) str.charAt(i);
			String s4 = Integer.toHexString(ch);
			Hexstr = Hexstr + s4;
			for(int j=0;j<2;j++) {
				switch (s4.charAt(j)){
				case '0' :
				s+="0000";break;
				case '1' :
				s+="0001";break;
				case '2' :
				s+="0010";break;
				case '3' :
				s+="0011";break;
				case '4' :
				s+="0100" ;break;
				case '5' :
				s+="0101";break;
				case '6' :
				s+="0110";break ;
				case '7' :
				s+="0111";break ;
				case '8' :
				s+="1000";break ;
				case '9' :
				s+="1001";break ;
				case 'a' :
				s+="1010";break;
				case 'b' :
				s+="1011";break ;
				case 'c':
				s+="1100";break;
				case 'd' :
				s+="1101";break;
				case 'e' :
				s+="1110";break;
				case 'f' :
				s+="1111";break;
				default :
				System.out.println( "error! ");
				}
			}
		
		}
		
		return s;
	}
	
	
}