package y2;

import cn.com.fmsh.FM_Exception;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import x2.d;
import x2.e;
import x2.f;
import x2.h;
import z2.a;
import z2.b;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static /* synthetic */ a f36734a = b.a().b();

    private static /* bridge */ /* synthetic */ byte[] a(int i10, Key key, byte[] bArr, boolean z10) {
        String str;
        String str2;
        a aVar;
        Exception e10;
        byte[] bArr2 = null;
        try {
            Cipher cipher = Cipher.getInstance(z10 ? d.c("\u000f\u001d^?DQA{\u0015\u001d\u0004K8Jj8)7!'", 106) : FM_Exception.insert(3, 59, "U\u0011\u001c7\u0016M\u000b+\u0011u\u0005q/b(2p"));
            cipher.init(i10, key);
            int i11 = 0;
            int i12 = i10 == 2 ? 128 : 0;
            if (i10 == 1) {
                i12 = 117;
            }
            int length = bArr.length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i13 = 0;
            while (true) {
                int i14 = length - i13;
                if (i14 <= 0) {
                    break;
                }
                byte[] doFinal = i14 > i12 ? cipher.doFinal(bArr, i13, i12) : cipher.doFinal(bArr, i13, i14);
                byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                i13 += i12;
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            if (byteArray == null) {
                return byteArray;
            }
            int i15 = 0;
            while (true) {
                if (i15 >= byteArray.length) {
                    break;
                } else if (byteArray[i15] != 0) {
                    i11 = i15;
                    break;
                } else {
                    i15++;
                }
            }
            bArr2 = x2.c.l(byteArray, i11, byteArray.length);
            return bArr2;
        } catch (IOException e11) {
            e10 = e11;
            aVar = f36734a;
            str2 = c.class.getName();
            str = h.e("\u0001BN勭d觪寁斳冹玱彝幥", 214, 94);
            aVar.b(str2, str);
            f36734a.b(c.class.getName(), h.f(e10));
            return bArr2;
        } catch (InvalidKeyException e12) {
            e10 = e12;
            aVar = f36734a;
            str2 = c.class.getName();
            str = e.a(2, "\u0005\t\u001c加,觥寏旺凵玢弗帠");
            aVar.b(str2, str);
            f36734a.b(c.class.getName(), h.f(e10));
            return bArr2;
        } catch (NoSuchAlgorithmException e13) {
            e10 = e13;
            aVar = f36734a;
            str2 = c.class.getName();
            str = d.c("\u0011\u0007\u0004劶(觻寏斬冱珬彏带", 368);
            aVar.b(str2, str);
            f36734a.b(c.class.getName(), h.f(e10));
            return bArr2;
        } catch (BadPaddingException e14) {
            e10 = e14;
            aVar = f36734a;
            str2 = c.class.getName();
            str = FM_Exception.insert(3, 30, "UV\u0002勡p觾寝斯冭玥弑幩");
            aVar.b(str2, str);
            f36734a.b(c.class.getName(), h.f(e10));
            return bArr2;
        } catch (IllegalBlockSizeException e15) {
            e10 = e15;
            aVar = f36734a;
            str2 = c.class.getName();
            str = x2.a.b("\u0007\u0014\u0018勫2觬寇日凿珧彋幣", 5, 114);
            aVar.b(str2, str);
            f36734a.b(c.class.getName(), h.f(e10));
            return bArr2;
        } catch (NoSuchPaddingException e16) {
            e10 = e16;
            aVar = f36734a;
            str2 = c.class.getName();
            str = x2.c.i("\t\u0018Z勫4觨宝旽冡珻弙平", 4, 80);
            aVar.b(str2, str);
            f36734a.b(c.class.getName(), h.f(e10));
            return bArr2;
        }
    }

    public static byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z10) {
        a aVar;
        Exception e10;
        String str;
        String str2;
        PrivateKey privateKey = null;
        if (bArr == null || bArr.length < 1 || bArr2 == null || bArr2.length < 1 || bArr3 == null || bArr3.length < 1) {
            return null;
        }
        try {
            privateKey = KeyFactory.getInstance(h.e("R\tU", 3, 90)).generatePrivate(new RSAPrivateKeySpec(new BigInteger(1, bArr), new BigInteger(1, bArr2)));
        } catch (NoSuchAlgorithmException e11) {
            e10 = e11;
            aVar = f36734a;
            str2 = c.class.getName();
            str = FM_Exception.insert(4, 105, "Z\u0002\u001b禂钩觶官冽珠弛帺");
            aVar.b(str2, str);
            f36734a.b(c.class.getName(), h.f(e10));
            return a(2, privateKey, bArr3, z10);
        } catch (InvalidKeySpecException e12) {
            e10 = e12;
            aVar = f36734a;
            str2 = c.class.getName();
            str = x2.c.i("\n\u0014\u0017禄钱觠寔击珠彝并", 1, 111);
            aVar.b(str2, str);
            f36734a.b(c.class.getName(), h.f(e10));
            return a(2, privateKey, bArr3, z10);
        }
        return a(2, privateKey, bArr3, z10);
    }

    public static byte[] c(byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z10) {
        a aVar;
        Exception e10;
        String str;
        String str2;
        PublicKey publicKey = null;
        if (bArr == null || bArr.length < 1 || bArr2 == null || bArr2.length < 1 || bArr3 == null || bArr3.length < 1) {
            return null;
        }
        try {
            publicKey = KeyFactory.getInstance(f.a("_YF", 5)).generatePublic(new RSAPublicKeySpec(new BigInteger(1, bArr), new BigInteger(1, bArr2)));
        } catch (NoSuchAlgorithmException e11) {
            e10 = e11;
            aVar = f36734a;
            str2 = c.class.getName();
            str = e.a(3, "\n\b\u001f六钡劧富凷玠弑帮");
            aVar.b(str2, str);
            f36734a.b(c.class.getName(), h.f(e10));
            return a(1, publicKey, bArr3, z10);
        } catch (InvalidKeySpecException e12) {
            e10 = e12;
            aVar = f36734a;
            str2 = c.class.getName();
            str = x2.a.b("\u0000K_儨钯劰宐冦玲彊并", 2, 38);
            aVar.b(str2, str);
            f36734a.b(c.class.getName(), h.f(e10));
            return a(1, publicKey, bArr3, z10);
        }
        return a(1, publicKey, bArr3, z10);
    }
}
