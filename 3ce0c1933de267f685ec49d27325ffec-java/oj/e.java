package oj;

import android.graphics.Bitmap;
import com.google.zxing.NotFoundException;
import com.google.zxing.b;
import com.google.zxing.common.f;
import com.google.zxing.d;
import com.mobvoi.android.common.utils.k;
/* compiled from: QrcodeUtil.java */
/* loaded from: classes2.dex */
public class e {
    public static String a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        bitmap.recycle();
        try {
            return new d().b(new b(new f(new com.google.zxing.f(width, height, iArr)))).f();
        } catch (NotFoundException e10) {
            k.r("QrcodeUtil", "Parse qrcode fail", e10, new Object[0]);
            return null;
        }
    }
}
