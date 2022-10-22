package y2;

import cn.com.fmsh.FM_Exception;
import com.realsil.sdk.dfu.DfuException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import x2.c;
import x2.e;
import x2.h;
import z2.b;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static /* synthetic */ z2.a f36732a = b.a().b();

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, c.i("W\t\u0016", 60, 25));
        try {
            Cipher cipher = Cipher.getInstance(e.a(5, "\u001e\u0018S,CJN \\zHzzemim"));
            cipher.init(2, secretKeySpec);
            return cipher.doFinal(bArr2);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e10) {
            f36732a.b(a.class.getName(), h.f(e10));
            return null;
        }
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            f36732a.b(a.class.getName(), FM_Exception.insert(DfuException.ERROR_ENTER_OTA_MODE_FAILED, 16, "寥敼捲辗蠐\u007f\u0018IO觯寚斺ｐ佬儹皈WIE扚聙忉勼寊皘敼捲乶290`"));
            return null;
        }
        if (bArr.length % 8 != 0) {
            f36732a.b(a.class.getName(), e.a(2, "宮攪挳进衏5MI\\觱寓旮７伾兤皀LOT皔散捸镦庺丒告沐"));
        }
        byte[] k10 = c.k(bArr, 8);
        return a(k10, c(c.l(bArr, 8, bArr.length), a(k10, bArr2)));
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length > 8) {
            bArr = c.k(bArr, 8);
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, h.e("FM]", 5, 6));
        try {
            Cipher cipher = Cipher.getInstance(FM_Exception.insert(3, 46, "CP\u0010>Z\u000eYf\u0019j\u0003`k9bw "));
            cipher.init(1, secretKeySpec);
            return cipher.doFinal(bArr2);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e10) {
            f36732a.b(a.class.getName(), h.f(e10));
            return null;
        }
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            f36732a.b(a.class.getName(), e.a(6, "客攮捯迟衋9IU@劶察旪３伢兠皌@KH戂耒徟劽宆盇收挧乶!'94"));
            return null;
        }
        if (bArr.length % 8 != 0) {
            f36732a.b(a.class.getName(), h.e("对敶换迉衔-@OC劶寚斴ｄ佮儱盞\u000b\u0003\u0015盖攨挰镻庬丝吞泉", 3, 6));
        }
        byte[] k10 = c.k(bArr, 8);
        return c(k10, a(c.l(bArr, 8, bArr.length), c(k10, bArr2)));
    }
}
