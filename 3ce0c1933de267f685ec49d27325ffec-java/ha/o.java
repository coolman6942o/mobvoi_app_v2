package ha;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.i;
import kotlin.text.d;
/* compiled from: Md5Util.kt */
/* loaded from: classes2.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static final o f27794a = new o();

    private o() {
    }

    public final String a(String content, String key) {
        i.f(content, "content");
        i.f(key, "key");
        try {
            byte[] bytes = key.getBytes(d.f30092a);
            i.e(bytes, "(this as java.lang.String).getBytes(charset)");
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "HmacMD5");
            Mac mac = Mac.getInstance("HmacMD5");
            mac.init(secretKeySpec);
            Charset forName = Charset.forName("ASCII");
            i.e(forName, "Charset.forName(charsetName)");
            byte[] bytes2 = content.getBytes(forName);
            i.e(bytes2, "(this as java.lang.String).getBytes(charset)");
            byte[] doFinal = mac.doFinal(bytes2);
            StringBuffer stringBuffer = new StringBuffer();
            int i10 = 0;
            int length = doFinal.length - 1;
            if (length >= 0) {
                while (true) {
                    int i11 = i10 + 1;
                    String hexString = Integer.toHexString(doFinal[i10] & 255);
                    if (hexString.length() == 1) {
                        stringBuffer.append('0');
                    }
                    stringBuffer.append(hexString);
                    if (i11 > length) {
                        break;
                    }
                    i10 = i11;
                }
            }
            String stringBuffer2 = stringBuffer.toString();
            i.e(stringBuffer2, "hash.toString()");
            return stringBuffer2;
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException unused) {
            return "";
        }
    }
}
