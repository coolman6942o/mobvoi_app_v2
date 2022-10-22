package com.huawei.hms.scankit;

import android.graphics.Bitmap;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.p.AbstractC0619pb;
import com.huawei.hms.scankit.p.Ta;
import java.nio.ByteBuffer;
/* compiled from: RemoteDecoderWork.java */
/* loaded from: classes2.dex */
public class D {

    /* renamed from: a  reason: collision with root package name */
    private static volatile D f14071a;

    public static D a() {
        if (f14071a == null) {
            synchronized (D.class) {
                if (f14071a == null) {
                    f14071a = new D();
                }
            }
        }
        return f14071a;
    }

    public HmsScan[] b(Bitmap bitmap, int i10, boolean z10, Ta ta2) {
        Ta.a aVar;
        if (ta2 != null) {
            ta2.a("single");
            aVar = ta2.a(z10, bitmap.getHeight() * bitmap.getWidth());
            if (bitmap.getHeight() < 30 || bitmap.getWidth() < 30) {
                aVar.a(-1005);
            }
        } else {
            aVar = null;
        }
        HmsScan[] a10 = AbstractC0619pb.a(k.b(bitmap, new E(i10, z10)));
        if (ta2 != null) {
            ta2.a(a10, aVar);
        }
        return a10;
    }

    public HmsScan[] a(Bitmap bitmap, int i10, boolean z10, Ta ta2) {
        Ta.a aVar;
        if (ta2 != null) {
            ta2.a("multi");
            aVar = ta2.a(z10, bitmap.getHeight() * bitmap.getWidth());
            if (bitmap.getHeight() < 30 || bitmap.getWidth() < 30) {
                aVar.a(-1005);
            }
        } else {
            aVar = null;
        }
        HmsScan[] a10 = AbstractC0619pb.a(k.a(bitmap, new E(i10, z10)));
        if (ta2 != null) {
            ta2.a(a10, aVar);
        }
        return a10;
    }

    public HmsScan[] a(ByteBuffer byteBuffer, int i10, int i11, int i12, boolean z10, Ta ta2) {
        Ta.a aVar;
        if (ta2 != null) {
            ta2.a("multi");
            int i13 = i11 * i10;
            aVar = ta2.a(z10, i13);
            if (i10 < 30 || i11 < 30) {
                aVar.a(-1007);
            } else if (byteBuffer.array().length < i13) {
                aVar.a(-1008);
            }
        } else {
            aVar = null;
        }
        HmsScan[] a10 = AbstractC0619pb.a(k.a(byteBuffer, new E(i10, i11, i12, true, z10)));
        if (ta2 != null) {
            ta2.a(a10, aVar);
        }
        return a10;
    }
}
