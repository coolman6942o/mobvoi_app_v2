package x2;

import cn.com.fmsh.FM_Exception;
import java.util.Arrays;
import z2.a;
import z2.b;
/* loaded from: classes.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    private static /* synthetic */ a f36351b = b.a().b();

    /* renamed from: c  reason: collision with root package name */
    private static /* synthetic */ String f36352c = d.c("gyky/9+9gi\u0000\u0010\u0000P@P", 4);

    /* renamed from: d  reason: collision with root package name */
    private static /* synthetic */ String f36353d = c.class.getName();

    /* renamed from: a  reason: collision with root package name */
    public byte[] f36354a = new byte[0];

    public static byte[] a(byte[] bArr) {
        int i10 = 8;
        byte[] bArr2 = new byte[8];
        bArr2[0] = Byte.MIN_VALUE;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length % 8;
        if (length != 0) {
            i10 = 8 - length;
        }
        return s(bArr, k(bArr2, i10));
    }

    public static byte[] b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        while (true) {
            length--;
            if (length <= bArr.length - 9) {
                return bArr;
            }
            if (Byte.MIN_VALUE == bArr[length]) {
                return Arrays.copyOf(bArr, length);
            }
        }
    }

    public static String c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return d(bArr, "", "");
    }

    public static String d(byte[] bArr, String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                hexString = String.valueOf('0') + hexString;
            }
            if (str != null && !"".equals(str)) {
                sb2.append(str);
            }
            sb2.append(hexString.toUpperCase());
            if (str2 != null && !"".equals(str2)) {
                sb2.append(str2);
            }
        }
        return sb2.toString();
    }

    public static int e(byte[] bArr) {
        return f(bArr, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int f(byte[] bArr, boolean z10) {
        int i10;
        if (bArr == 0) {
            a aVar = f36351b;
            if (aVar != null) {
                aVar.b(f36353d, a.b("嬆芆攧绎轱所卂辍刿敨政旴ｙ數统乴o!kv", 1, 51));
            }
            return -1;
        } else if (bArr.length < 1) {
            a aVar2 = f36351b;
            if (aVar2 != null) {
                aVar2.b(f36353d, d.c("嬃苇攦纃轴戙卛运剪改攮方ｌ敡细镬庢乯v", 1));
            }
            return -1;
        } else if (bArr.length == 1) {
            return bArr[0] & 255;
        } else {
            if (z10) {
                i10 = bArr[0];
                for (int i11 = 1; i11 < bArr.length; i11++) {
                    i10 = (i10 << 8) | (bArr[i11] & 255);
                }
            } else {
                i10 = bArr[bArr.length - 1];
                for (int length = bArr.length - 2; length >= 0; length--) {
                    i10 = (i10 << 8) | (bArr[length] & 255);
                }
            }
            return i10;
        }
    }

    public static long g(byte[] bArr) {
        return h(bArr, true);
    }

    public static long h(byte[] bArr, boolean z10) {
        long j10;
        if (bArr == null) {
            a aVar = f36351b;
            if (aVar != null) {
                aVar.b(f36353d, g.a(230, 88, "嬁芌敶纚轺戞匇迅删攺收旨ｚ放绂乤8{j2"));
            }
            return -1L;
        }
        if (bArr.length < 1) {
            a aVar2 = f36351b;
            if (aVar2 != null) {
                aVar2.b(f36353d, d.c("嬏苋攪纏轰戝卟返制攥攲斥ｈ敥绂镨庮乣z", 5));
            }
            return -1L;
        } else if (bArr.length == 1) {
            return bArr[0] & 255;
        } else {
            if (z10) {
                j10 = bArr[0] & 255;
                for (int i10 = 1; i10 < bArr.length; i10++) {
                    j10 = (j10 << 8) | (bArr[i10] & 255);
                }
            } else {
                j10 = bArr[bArr.length - 1];
                for (int length = bArr.length - 2; length >= 0; length--) {
                    j10 = (j10 << 8) | (bArr[length] & 255);
                }
            }
            return j10;
        }
    }

    public static String i(String str, int i10, int i11) {
        int i12 = i10 - 9;
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i13 = 0;
        while (i13 != length) {
            i12 += i11;
            i13++;
            charArray[i13] = (char) (charArray[i13] ^ (i12 & 95));
        }
        return String.valueOf(charArray, 0, length).intern();
    }

    public static byte[] j(byte[] bArr, byte[]... bArr2) {
        int length = bArr.length;
        for (byte[] bArr3 : bArr2) {
            length += bArr3.length;
        }
        byte[] copyOf = Arrays.copyOf(bArr, length);
        int length2 = bArr.length;
        for (byte[] bArr4 : bArr2) {
            System.arraycopy(bArr4, 0, copyOf, length2, bArr4.length);
            length2 += bArr4.length;
        }
        return copyOf;
    }

    public static byte[] k(byte[] bArr, int i10) {
        if (bArr != null) {
            byte[] bArr2 = new byte[i10];
            int i11 = 0;
            if (bArr.length < i10) {
                while (i11 < bArr.length) {
                    bArr2[i11] = bArr[i11];
                    i11++;
                }
            } else {
                while (i11 < i10) {
                    bArr2[i11] = bArr[i11];
                    i11++;
                }
            }
            return bArr2;
        }
        throw new NullPointerException(b.b(5, "2rzzy :>&uAyd`udb$+c ,hc"));
    }

    public static byte[] l(byte[] bArr, int i10, int i11) {
        if (bArr != null) {
            int i12 = i11 - i10;
            if (i12 <= 0) {
                throw new IllegalArgumentException(e.a(3, "x=,ni\\") + i10 + f.a("I/zdS", 300) + i11 + "]");
            } else if (bArr.length < i11 || bArr.length < i10) {
                throw new IllegalArgumentException(" ");
            } else {
                byte[] bArr2 = new byte[i12];
                for (int i13 = 0; i13 < i12; i13++) {
                    bArr2[i13] = bArr[i10 + i13];
                }
                return bArr2;
            }
        } else {
            throw new NullPointerException(f.a("+gwk8577?p\f85%8-{1&r!9%*", 3));
        }
    }

    public static byte[] m(String str) {
        int i10;
        if (str == null || str.length() < 1) {
            return null;
        }
        int length = (str.length() + 1) / 2;
        if (length > 0) {
            byte[] bArr = new byte[length];
            String upperCase = str.toUpperCase();
            int i11 = 0;
            int i12 = 0;
            byte b10 = 0;
            for (int i13 = 0; i13 < upperCase.length(); i13++) {
                int indexOf = f36352c.indexOf(upperCase.charAt(i13));
                if (indexOf != -1) {
                    i11++;
                    if (i11 % 2 == 1) {
                        b10 = (byte) (b10 | (indexOf << 4));
                    } else {
                        i12++;
                        bArr[i12] = (byte) (b10 | indexOf);
                        b10 = 0;
                    }
                }
            }
            if (i11 % 2 == 1) {
                i10 = i12 + 1;
                bArr[i12] = b10;
            } else {
                i10 = i12;
            }
            if (i10 == length) {
                return bArr;
            }
            if (i10 != 0) {
                byte[] bArr2 = new byte[i10];
                for (int i14 = 0; i14 < i10; i14++) {
                    bArr2[i14] = bArr[i14];
                }
                return bArr2;
            }
        }
        return new byte[0];
    }

    public static byte[] n(int i10, int i11) {
        return o(i10, i11, true);
    }

    public static byte[] o(int i10, int i11, boolean z10) {
        if (i11 < 1) {
            a aVar = f36351b;
            if (aVar == null) {
                return null;
            }
            aVar.b(f36353d, a.b("匙迒剬\"r9敪敿輬戁孕苑整纑新；捏它皎攫终锢廨靁欳", 232, 81));
            return null;
        }
        byte[] bArr = new byte[i11];
        if (z10) {
            for (int i12 = i11 - 1; i12 > -1; i12--) {
                bArr[i12] = Integer.valueOf(i10 & 255).byteValue();
                i10 >>= 8;
            }
        } else {
            for (int i13 = 0; i13 < i11; i13++) {
                bArr[i13] = Integer.valueOf(i10 & 255).byteValue();
                i10 >>= 8;
            }
        }
        return bArr;
    }

    public static boolean p(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        int length = bArr.length;
        for (int length2 = bArr2.length - 1; length2 >= 0; length2--) {
            length--;
            if (bArr2[length2] != bArr[length]) {
                return false;
            }
        }
        return true;
    }

    public static boolean q(byte[] bArr) {
        return p(bArr, new byte[]{-112});
    }

    public static boolean r(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (int length = bArr.length - 1; length > bArr.length - 9; length--) {
            if (Byte.MIN_VALUE == bArr[length]) {
                return true;
            }
        }
        return false;
    }

    public static byte[] s(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            a aVar = f36351b;
            if (aVar != null) {
                aVar.b(f36353d, e.a(208, "嬒苊攻纊呙帢斡ｖ攭纄乹(< #"));
            }
            return bArr;
        }
        int length = bArr.length;
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        for (int i10 = 0; i10 < length; i10++) {
            bArr3[i10] = bArr[i10];
        }
        for (int i11 = 0; i11 < bArr2.length; i11++) {
            bArr3[length + i11] = bArr2[i11];
        }
        return bArr3;
    }

    public static byte[] t(long j10, int i10) {
        return u(j10, i10, true);
    }

    public static byte[] u(long j10, int i10, boolean z10) {
        if (i10 < 1) {
            a aVar = f36351b;
            if (aVar == null) {
                return null;
            }
            aVar.b(f36353d, d.c("博迗别b0>&攦攳轸戕孁芅攨纍斬ｇ挛宗皚敿组键廤霍欧", 72));
            return null;
        }
        byte[] bArr = new byte[i10];
        if (z10) {
            for (int i11 = i10 - 1; i11 > -1; i11--) {
                bArr[i11] = Long.valueOf(j10 & 255).byteValue();
                j10 >>= 8;
            }
        } else {
            for (int i12 = 0; i12 < i10; i12++) {
                bArr[i12] = Long.valueOf(j10 & 255).byteValue();
                j10 >>= 8;
            }
        }
        return bArr;
    }

    public static byte[] w(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            a aVar = f36351b;
            if (aVar != null) {
                aVar.b(f36353d, a.b("彖扜时ｚ攼细乢 q6<", 4, 86));
            }
            return null;
        } else if (bArr.length != bArr2.length) {
            a aVar2 = f36351b;
            if (aVar2 != null) {
                aVar2.b(f36353d, FM_Exception.insert(4, 65, "弊扟旼ｇn4z*敠纕镭廵丙笜"));
            }
            return null;
        } else {
            byte[] bArr3 = (byte[]) bArr.clone();
            for (int i10 = 0; i10 < bArr3.length; i10++) {
                bArr3[i10] = (byte) (bArr3[i10] ^ bArr2[i10]);
            }
            return bArr3;
        }
    }

    public int hashCode() {
        return Arrays.hashCode(this.f36354a);
    }

    public String toString() {
        return v(' ');
    }

    public String v(char c10) {
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        while (true) {
            byte[] bArr = this.f36354a;
            if (i10 >= bArr.length) {
                return sb2.toString();
            }
            byte b10 = bArr[i10];
            sb2.append(f36352c.charAt((b10 & 240) >> 4));
            sb2.append(f36352c.charAt(b10 & 15));
            if (c10 != 0) {
                sb2.append(c10);
            }
            i10++;
        }
    }
}
