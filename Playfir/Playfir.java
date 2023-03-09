package Playfir;

import java.util.Scanner;
import java.util.*;

public class Playfir {
 static char ch[][]=new char[5][5];//�洢����
 static int x[]=new int[26];//������ĸ��˳�򣬴洢������ĸ��������
 static int y[]=new int[26];//������ĸ��˳�򣬴洢������ĸ�ĺ�����
 static int count=0;//���������ۼ���Կ�ĸ���
 static int wz=0;//����Կ������ʣ����ĸ����ʱ����
 static void build(String str) {
	 for(int i=0;i<5;i++) {//�������
     	for(int j=0;j<5;j++) {
     		int num=0;
             if(count<str.length()) {//�Ƚ���Կ����
             	while(num==0) {
             		if(count>=str.length()) break;
             	if(x[str.charAt(count)-97]==0&&y[str.charAt(count)-97]==0) {//�ų���Կ���ظ�����ĸ
     			ch[i][j]=str.charAt(count);x[str.charAt(count)-97]=i;y[str.charAt(count)-97]=j;count++;num++;}
     		else count++;}
             	}
     		else {
     			int sum=0;
     			while(sum==0) {//��sum=0����������һ����ĸ������ʹ�ø�Ϊ��
     			if(x[wz]==0&&y[wz]==0&&wz!=str.charAt(0)-97) {
     				if(wz+97!='j') {ch[i][j]=(char) (wz+97);x[wz]=i;y[wz]=j;wz++;sum++;}//Լ��i��jλ��ͬһ����
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
     for(int t=0;t<ch_mw.size();t++) {//ͨ����ĸ����x,y��������ȡ��ĸ�ھ����е�λ�ý��м���
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
