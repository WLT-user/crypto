package ¹ÅµäÃÜÂë;

import java.util.Scanner;
import java.util.Vector;

public class Vigenere {
	
	private static  int n = 26;
	static  String key = new String();
	static  Vector KeyVec = new Vector();
	static  StringBuffer enstr;
	static  StringBuffer destr;
	
	static void Key2Vec() {
		
		for(int index=0;index<key.length();index++) {
			KeyVec.add(key.charAt(index)-97);
		}
	}
	
	static StringBuffer encode(String str) {
		enstr = new StringBuffer();
		for(int i=0;i<str.length();i++) {
			enstr.append((char)((str.charAt(i)-97+(int) KeyVec.get(i%key.length()))%n+97));
		}
		
		return enstr;
		
	}

	static StringBuffer decode(String str) {
		destr = new StringBuffer();
		for(int i=0;i<str.length();i++) {
			destr.append((char)(((str.charAt(i)-97-(int) KeyVec.get(i%key.length()))%n+n)%n+97));
		}
		return destr;
		
	}
}
