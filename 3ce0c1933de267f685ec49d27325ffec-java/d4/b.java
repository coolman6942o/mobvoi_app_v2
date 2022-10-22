package d4;

import c4.a;
import java.security.MessageDigest;
/* loaded from: classes.dex */
public final class b {
    public static String a(String str) {
        try {
            if (a.d(str)) {
                return null;
            }
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] digest = messageDigest.digest();
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < digest.length; i10++) {
                sb2.append(String.format("%02x", Byte.valueOf(digest[i10])));
            }
            return sb2.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
