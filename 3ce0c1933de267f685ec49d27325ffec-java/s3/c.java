package s3;

import android.text.TextUtils;
import java.security.SecureRandom;
import javax.crypto.Cipher;
/* loaded from: classes.dex */
public class c {
    public static byte[] a(Cipher cipher, String str) {
        SecureRandom secureRandom = new SecureRandom();
        int blockSize = cipher.getBlockSize();
        if (TextUtils.isEmpty(str)) {
            str = String.valueOf(secureRandom.nextDouble());
        }
        int i10 = blockSize * 2;
        byte[] bArr = new byte[i10];
        byte[] bArr2 = new byte[blockSize];
        secureRandom.nextBytes(bArr2);
        for (int i11 = 1; i11 < i10; i11++) {
            bArr[i11] = (byte) (str.codePointAt(i11 % str.length()) & 127);
            if (i11 >= blockSize) {
                bArr[i11] = (byte) (bArr[0] & bArr[i11]);
            }
        }
        System.arraycopy(bArr, blockSize, bArr2, 0, blockSize);
        return bArr2;
    }
}
