package Playfir;

import java.util.Scanner;
import java.util.*;

public class Playfir {
 static char ch[][]=new char[5][5];//存储矩阵
 static int x[]=new int[26];//根据字母表顺序，存储各个字母的纵坐标
 static int y[]=new int[26];//根据字母表顺序，存储各个字母的横坐标
 static int count=0;//计数器，累计密钥的个数
 static int wz=0;//将密钥填充完后将剩余字母填入时计数
 static void build(String str) {
	 for(int i=0;i<5;i++) {//构造矩阵
     	for(int j=0;j<5;j++) {
     		int num=0;
             if(count<str.length()) {//先将密钥填入
             	while(num==0) {
             		if(count>=str.length()) break;
             	if(x[str.charAt(count)-97]==0&&y[str.charAt(count)-97]==0) {//排除密钥中重复的字母
     			ch[i][j]=str.charAt(count);x[str.charAt(count)-97]=i;y[str.charAt(count)-97]=j;count++;num++;}
     		else count++;}
             	}
     		else {
     			int sum=0;
     			while(sum==0) {//若sum=0则尝试填入下一个字母而不是使该格为空
     			if(x[wz]==0&&y[wz]==0&&wz!=str.charAt(0)-97) {
     				if(wz+97!='j') {ch[i][j]=(char) (wz+97);x[wz]=i;y[wz]=j;wz++;sum++;}//约定i，j位于同一格中
     				else wz++;
     			}
     			else wz++;
     			}
     		}
     	}
     }
 }
 static String encrypt(Vector ch_mw) {
	 for(int i=0;i<ch_mw.size()-1;i++) {
     	if(ch_mw.get(i)==ch_mw.get(i+1)) {ch_mw.add(i+1, 'q');i++;}
     	else {};
     }
     if(ch_mw.size()%2!=0)ch_mw.add('q');
     String str=new String();
     for(int t=0;t<ch_mw.size();t++) {//通过字母调用x,y数组来获取字母在矩阵中的位置进行加密
     	int m=ch_mw.get(t).toString().charAt(0)-97;
     	int k=ch_mw.get(t+1).toString().charAt(0)-97;
     	if(x[m]==x[k]) {
     		str=str+ch[x[m]][(y[m]+1)%5]+ch[x[k]][(y[k]+1)%5]+" ";
     	}
     	else if(y[m]==y[k]) {str=str+ch[x[m]+1%5][y[m]]+ch[x[k]+1%5][y[k]]+" ";}
     	else if(x[m]<x[k])str=str+ch[x[m]][y[k]]+ch[x[k]][y[m]]+" ";
     	t++;
     } 
     return str;
 }
 static String decrypt(Vector ch_mw) {
	 String str1=new String();
     for(int t=0;t<ch_mw.size();t++) {
     	int m=ch_mw.get(t).toString().charAt(0)-97;
     	int k=ch_mw.get(t+1).toString().charAt(0)-97;
     	if(x[m]==x[k]) {
     		str1=str1+ch[x[m]][(y[m]-1+5)%5]+ch[x[k]][(y[k]-1+5)%5]+" ";
     	}
     	else if(y[m]==y[k]) {str1=str1+ch[(x[m]-1+5)%5][y[m]]+ch[(x[k]-1+5)%5][y[k]]+" ";}
     	else {
     		if(x[m]>x[k])str1=str1+ch[x[k]][y[m]]+ch[x[m]][y[k]]+" ";
     		else str1=str1+ch[x[m]][y[k]]+ch[x[k]][y[m]]+" ";
     	}
     	t++;
     } 
     return str1;
 }
}
