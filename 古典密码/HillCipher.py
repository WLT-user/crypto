import copy
import random

MOD = 65521 
# as the biggest prime lower than 2^16

def exgcd(a, b):
    if not b:
        return a, 1, 0
    g, x, y = exgcd(b, a%b)
    x, y = y, (x-(a//b)*y)
    return g, x, y

def mtxDet(mtx, n):
    if n == 1:
        return mtx[0][0]
    res = 0
    for i in range(n):
        # sub = np.empty((n-1, n-1))
        sub = [[0 for i in range(n)] for i in range(n)]
        for r in range(n-1):
            for c in range(n-1):
                nr = (r+1, r)[r < i]
                nc = c+1
                sub[r][c] = mtx[nr][nc]
        res += (-1, 1)[i % 2 == 0] * mtx[i][0] * mtxDet(sub, n-1) % MOD
    return res % MOD

def mtxMul(a, b):
    n = len(a)
    m = len(b[0])
    cl = len(b)
    # res = np.empty((n, m)).astype(np.int64)
    res = [[0 for i in range(m)] for i in range(n)]
    for k in range(cl):
        for i in range(n):
            if not a[i][k]:
                continue
            for j in range(m):
                res[i][j] = (res[i][j] + int(a[i][k]) * int(b[k][j]) % MOD) % MOD
    return res

def calcuInvMtx(mtx, n):
    mtx = copy.deepcopy(mtx)
    pos_i = [-1 for i in range(n)]
    pos_j = [-1 for i in range(n)]
    for k in range(n):
        for i in range(k, n):
            for j in range(k, n):
                if mtx[i][j]:
                    pos_i[k] = i
                    pos_j[k] = j
                    break
        if(pos_i[k] == -1):
            # print("f1")
            return None 
        for i in range(n):
            mtx[pos_i[k]][i], mtx[k][i] = mtx[k][i], mtx[pos_i[k]][i]
        for i in range(n):
            mtx[i][pos_j[k]], mtx[i][k] = mtx[i][k], mtx[i][pos_j[k]]
        g, mtx[k][k], y = exgcd(mtx[k][k], MOD)
        mtx[k][k] = (mtx[k][k]%MOD + MOD) % MOD
        if g != 1:
            # print("f2")
            return None
        for i in range(n):
            if not i == k:
                mtx[k][i] = mtx[k][i] * mtx[k][k] % MOD
        for i in range(n):
            if not i == k:
                for j in range(n):
                    if not j == k:
                        mtx[i][j] = (mtx[i][j] - mtx[i][k] * mtx[k][j] % MOD + MOD) % MOD
        for i in range(n):
            if not i == k:
                mtx[i][k] = (- mtx[i][k] * mtx[k][k] % MOD + MOD) % MOD
        # print(mtx)
    for k in range(n)[::-1]:
        # print(k)
        for i in range(n):
            mtx[pos_j[k]][i], mtx[k][i] = mtx[k][i], mtx[pos_j[k]][i]
        for i in range(n):
            mtx[i][pos_i[k]], mtx[i][k] = mtx[i][k], mtx[i][pos_i[k]]
    return mtx

def buildExpertMtx(n, mod):
    k = [i for i in range(2, mod) if exgcd(i, mod)[0] == 1]
    lk = len(k)
    # print(k)
    res = [[0 for i in range(n)] for i in range(n)]
    for i in range(n):
        res[i][i] = k[random.randint(0, lk-1)]
    for i in range(n):
        for j in range(n):
            if not i == j:
                res[i][j] = random.randint(0, mod-1)
    return res

def buildRandomMtx(n, m, ub):
    return [[random.randint(0, ub-1) for i in range(m)] for i in range(n)]

def buildMtx(val, n, m, d = 0):
    return [[val+d*(m*i+j) for j in range(m)] for i in range(n)]
    
def generateKeyMtx(n):
    while True:
        # key = np.random.randint(0, MOD-1, (n, n)).astype(np.int64)
        # key = buildExpertMtx(n, MOD)
        key = buildRandomMtx(n, n, MOD)
        inv_key =  calcuInvMtx(key, n)
        if not type(inv_key) == type(None):
            return key, inv_key

def generateMsgMtx(msg, m):
    msg = list(msg)
    l = len(msg)
    n = l//m + (0, 1)[l % m != 0]
    return [[msg[i*m+j] if i*m+j < l else '~' for j in range(m)] for i in range(n)]

def parseMsg(mtx, n):
    msg = ""
    for i in mtx:
        for j in i:
            msg += j
    return msg

def printCryptedMsg(encMsg):
    for ch in encMsg:
        try:
            ch = ch.encode('utf-8').decode('utf-8')
        except:
            ch = "0x%04x" % ord(ch)
        print(ch, end = '')
    print()

def getValueMtx(mtx):
    return [[ord(j) for j in i] for i in mtx]

def getChrMtx(mtx):
    return [[chr(j) for j in i] for i in mtx]

def encryptMtx(mtx, key):
    val_msgMtx = getValueMtx(msgMtx)
    val_enc = mtxMul(val_msgMtx, key)
    enc = getChrMtx(val_enc)
    return enc

def decryptMtx(dec, inv_key):
    val_dec = getValueMtx(dec)
    val_ddec = mtxMul(val_dec, inv_key)
    ddec = getChrMtx(val_ddec)
    return ddec;

def encodeMtx(msgMtx):
    # n = len(msgMtx)
    # m = len(msgMtx[0])
    return [[hex(ord(ch)) for ch in line] for line in msgMtx]

def decodeMtx(encMtx):
    return [[chr(int(j, 16)) for j in i] for i in encMtx]

def encode(msg):
    res = ""
    for ch in msg:
        res += hex(ord(ch))
    return res

def decode(msg):
    res = ""
    for x in msg.split("0x"):
        if not x == '':
            res += chr(int(x, 16));
    return res

print("testing generate message matrix...")
msg = input("msg =")
n = int(input("n ="))
msgMtx = generateMsgMtx(msg, n)
for i in msgMtx:
    print(i)


print("testing generate key matrix...")
key, inv_key = generateKeyMtx(n)
print("encrypt key matrix:")
for i in key:
    print(i)
print("decrypt key matrix:")
for i in inv_key:
    print(i)


print("testing encrypt message...")
enc = encryptMtx(msgMtx, key)
print("encrypted msg matrix: ")
for i in enc:
    print(i)
print("encrypted msg: ")
printCryptedMsg(parseMsg(enc, n))
# ----------------------
eenc = encodeMtx(enc)
print('encoded encrypted msg matrix: ')
for i in eenc:
    print(i)
print("encoded encrypted msg:")
print(parseMsg(eenc, n))


print("testing decrypt message:")
dec = decodeMtx(eenc)
print("decoded msg matrix:")
for i in dec:
    print(i)
print("decoded msg:")
printCryptedMsg(parseMsg(dec, n))
# -----------------------
ddec = decryptMtx(dec, inv_key)
print("decrypted decoded msg matrix:")
for i in ddec:
    print(i)
print("decrypted decoded msg:")
print(parseMsg(ddec, n))