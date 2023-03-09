package ¹ÅµäÃÜÂë;

import java.util.Scanner;
import java.util.Vector;

public class FangShe {

	private static  int n = 26;
	static  int k1;
	static  int k0;
	private static  int k2;	//kµÄÄæÔª
	private static  int i;
	private static  int j;
	static  Vector num = new Vector();;
	static  StringBuffer enstr;
	static  StringBuffer destr;
	
	static StringBuffer encode(String str) {
		enstr = new StringBuffer();
		for(int index=0;index<str.length();index++) {
			i = str.charAt(index)-97;
			j = (i*k1+k0)%n;
			enstr.append((char)(j+97));
		}
			
		return enstr;
	}
	
	
	static  StringBuffer decode(String encode_str) {
		destr = new StringBuffer();
		for(int index=0;index<encode_str.length();index++) {
		j = encode_str.charAt(index)-97;
		i = (((k2*(j-k0))%n)+n)%n;
		destr.append((char)(i+97));
		}		
		
		return destr;			
	}
	
	static void niyuan(int nn,int k1k1) {		
		n = nn;
		k1 = k1k1;
		int j=0;
		for(int i=2;i<n;i++) {
			if(gcd(i)) {
				num.add(i);			
				j++;
			}
		}
		
		for(int i=0;i<j;i++) {		
			if(((int)num.get(i)*k1-1)%n==0) {
				k2 = (int)num.get(i);
				return;
			}
		}
		System.out.println("k1 has no k2!");
		System.exit(0);
		
	}
	
	static boolean gcd(int k1) {
		for(int i=2;i<n;i++) {
			if(n%i==0) {
				if(k1%i==0)return false;			
			}
		}
		return true;
		
	}
}
