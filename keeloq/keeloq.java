package keeloq;
import java.util.Scanner;


public class keeloq {
private static int NLF[][][][][] = new int[2][2][2][2][2];

static {
NLF[0][0][0][0][0]=0;

NLF[0][0][0][0][1]=1;

NLF[0][0][0][1][0]=1;

NLF[0][0][0][1][1]=1;

NLF[0][0][1][0][0]=0;

NLF[0][0][1][0][1]=1;

NLF[0][0][1][1][0]=0;

NLF[0][0][1][1][1]=0;

NLF[0][1][0][0][0]=0;

NLF[0][1][0][0][1]=0;

NLF[0][1][0][1][0]=1;

NLF[0][1][0][1][1]=0;

NLF[0][1][1][0][0]=1;

NLF[0][1][1][0][1]=1;

NLF[0][1][1][1][0]=1;

NLF[0][1][1][1][1]=0;

NLF[1][0][0][0][0]=0;

NLF[1][0][0][0][1]=0;

NLF[1][0][0][1][0]=1;

NLF[1][0][0][1][1]=1;

NLF[1][0][1][0][0]=1;

NLF[1][0][1][0][1]=0;

NLF[1][0][1][1][0]=1;

NLF[1][0][1][1][1]=0;

NLF[1][1][0][0][0]=0;

NLF[1][1][0][0][1]=1;

NLF[1][1][0][1][0]=0;

NLF[1][1][0][1][1]=1;

NLF[1][1][1][0][0]=1;

NLF[1][1][1][0][1]=1;

NLF[1][1][1][1][0]=0;

NLF[1][1][1][1][1]=0;

}

/*

* 获取source第n个位数

*/

private static int getBit(long source, int n) {
long temp0 = ((long) 1 << n);

long temp1 = source & temp0;

if (temp1 != 0) {
return 1;

}

return 0;

}

/*

* source带进位右移

*/

private static int RRC(int soucre, int c) {
if (c != 0) {
soucre = (soucre >> 1) | 0x80000000;

} else {
soucre = (soucre >> 1) & 0x7fffffff;

}

return soucre;

}

/*

* source带进位左移

*/

private static int RLC(int source, int c) {
if (c != 0) {
source = (source << 1) | 1;

} else {
source = (source << 1) & 0xFFFFFFFE;

}

return source;

}

/**

* 加密

*/

public static int CRYPT(int source, long key) {
int c;

for (int i = 0; i < 528; i++) {
int nlf = NLF[getBit(source, 31)][getBit(source, 26)][getBit(source, 20)][getBit(source, 9)][getBit(source,

1)];

int y16 = getBit(source, 16);

int y0 = getBit(source, 0);

int k = getBit(key, i % 64);

int result = nlf ^ y16 ^ y0 ^ k;

if (result != 0) {
c = 1;

} else {
c = 0;

}

source = RRC(source, c);

}

return source;

}

/**

* 解密

*/

public static int DECRYPT(int source, long key) {
int c;
for (int i = 528; i > 0; i--) {
int nlf = NLF[getBit(source, 30)][getBit(source, 25)][getBit(source, 19)][getBit(source, 8)][getBit(source,

0)];

int y15 = getBit(source, 15);

int y31 = getBit(source, 31);

int k = getBit(key, (i - 1) % 64);

int result = nlf ^ y15 ^ y31 ^ k;
if (result != 0) {
c = 1;

} else {
c = 0;

}

source = RLC(source, c);

}

return source;

}
}
