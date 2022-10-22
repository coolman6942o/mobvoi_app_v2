package com.huawei.hms.scankit;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate;
import com.huawei.hms.scankit.aiscan.common.r;
import com.huawei.hms.scankit.aiscan.common.x;
import com.huawei.hms.scankit.util.a;
/* compiled from: IRemoteFrameDecoderDelegateImpl.java */
/* loaded from: classes2.dex */
public class s extends IRemoteFrameDecoderDelegate.Stub {

    /* renamed from: a  reason: collision with root package name */
    private static volatile s f15074a = new s();

    /* renamed from: b  reason: collision with root package name */
    Point f15075b;

    /* renamed from: c  reason: collision with root package name */
    int f15076c = 0;

    /* renamed from: d  reason: collision with root package name */
    Rect f15077d;

    private s() {
    }

    public static s a() {
        return f15074a;
    }

    public synchronized Rect b(int i10, int i11) {
        Rect rect = new Rect(a(i10, i11));
        Point point = new Point(i10, i11);
        Point point2 = this.f15075b;
        if (point2 == null) {
            return null;
        }
        int i12 = point2.x;
        int i13 = point2.y;
        if (i12 < i13) {
            int i14 = rect.left;
            int i15 = point.y;
            rect.left = (i14 * i15) / i12;
            rect.right = (rect.right * i15) / i12;
            int i16 = rect.top;
            int i17 = point.x;
            rect.top = (i16 * i17) / i13;
            rect.bottom = (rect.bottom * i17) / i13;
        } else {
            int i18 = rect.top;
            int i19 = point.y;
            rect.top = (i18 * i19) / i13;
            rect.bottom = (rect.bottom * i19) / i13;
            int i20 = rect.left;
            int i21 = point.x;
            rect.left = (i20 * i21) / i12;
            rect.right = (rect.right * i21) / i12;
        }
        return rect;
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate
    public x[] decode(byte[] bArr, int i10, int i11, int i12, int i13, IObjectWrapper iObjectWrapper) throws RemoteException {
        if (iObjectWrapper != null && (ObjectWrapper.unwrap(iObjectWrapper) instanceof Bundle)) {
            Bundle bundle = (Bundle) ObjectWrapper.unwrap(iObjectWrapper);
            this.f15075b = (Point) bundle.getParcelable("Screen");
            this.f15077d = (Rect) bundle.getParcelable("Rect");
        }
        if (this.f15077d == null) {
            this.f15077d = new Rect(-1, -1, -1, -1);
        }
        if (this.f15075b == null) {
            this.f15075b = new Point(1080, 1920);
        }
        r a10 = a(bArr, i10, i11, i12);
        byte[] b10 = a10.b();
        E e10 = new E(a10.c(), a10.a(), i13);
        int i14 = this.f15076c;
        this.f15076c = i14 + 1;
        return k.b(b10, e10.a(i14));
    }

    private r a(byte[] bArr, int i10, int i11, int i12) {
        if (i12 == 0) {
            byte[] bArr2 = new byte[bArr.length];
            for (int i13 = 0; i13 < i11; i13++) {
                for (int i14 = 0; i14 < i10; i14++) {
                    bArr2[(((i14 * i11) + i11) - i13) - 1] = bArr[(i13 * i10) + i14];
                }
            }
            return a(bArr2, i11, i10);
        } else if (i12 == 2) {
            byte[] bArr3 = new byte[bArr.length];
            for (int i15 = 0; i15 < i11; i15++) {
                for (int i16 = 0; i16 < i10; i16++) {
                    bArr3[(((i10 - 1) - i16) * i11) + i15] = bArr[(i15 * i10) + i16];
                }
            }
            return a(bArr3, i11, i10);
        } else if (i12 != 3) {
            return a(bArr, i10, i11);
        } else {
            byte[] bArr4 = new byte[bArr.length];
            for (int i17 = 0; i17 < i11; i17++) {
                for (int i18 = 0; i18 < i10; i18++) {
                    bArr4[(((((i11 - 1) - i17) * i10) + i10) - 1) - i18] = bArr[(i17 * i10) + i18];
                }
            }
            return a(bArr4, i10, i11);
        }
    }

    public synchronized Rect a(int i10, int i11) {
        int min;
        int i12;
        int i13;
        min = Math.min(i10, i11);
        i12 = (i10 - min) / 2;
        i13 = (i11 - min) / 2;
        return new Rect(i12, i13, i12 + min, min + i13);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public r a(byte[] bArr, int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        if (b(i10, i11) == null) {
            return null;
        }
        int min = (int) (Math.min(i10, i11) * 0.8d);
        int i20 = (i10 - min) / 2;
        int i21 = (i11 - min) / 2;
        Rect rect = this.f15077d;
        if (rect != null) {
            if (rect.left == -1 && rect.right == -1 && rect.top == -1 && rect.bottom == -1) {
                min = (int) (i10 * 0.85d);
                i20 = (i10 - min) / 2;
                double d10 = i11;
                i19 = (int) (0.8d * d10);
                i21 = (int) (d10 * 0.1d);
            } else {
                min = (int) (Math.min(i10, i11) * 0.9d);
                i20 = (i10 - min) / 2;
                Rect rect2 = this.f15077d;
                Rect rect3 = new Rect(rect2.left, rect2.top, rect2.right, rect2.bottom);
                int max = Math.max(i10, i11);
                Point point = this.f15075b;
                if (point != null) {
                    i17 = point.x;
                    i18 = point.y;
                } else {
                    i18 = max;
                    i17 = i18;
                }
                float max2 = max / Math.max(i17, i18);
                Rect rect4 = this.f15077d;
                int i22 = (int) (rect4.top * max2);
                rect3.top = i22;
                int i23 = (int) (rect4.bottom * max2);
                rect3.bottom = i23;
                float f10 = i11 / 14.0f;
                if (i22 > f10) {
                    i22 -= (int) f10;
                }
                i21 = i22 < 0 ? 0 : i22;
                i19 = i23 - i21;
                if (i21 + i19 > i11) {
                    i21 = (i11 - min) / 2;
                }
            }
            i12 = i20;
            i13 = min;
            min = i19;
            a.a("ScanSize", "top:" + i21 + "scanSizeHeight" + min + "mHeight:" + i11);
            if (i11 >= i21 + min) {
                i14 = i11;
                i15 = 0;
            } else {
                i14 = min;
                i15 = i21;
            }
            if (i10 >= i12 + i13) {
                i16 = i10;
                i12 = 0;
            } else {
                i16 = i13;
            }
            return new r(bArr, i10, i11, i12, i15, i16, i14, false);
        }
        i12 = i20;
        i13 = min;
        a.a("ScanSize", "top:" + i21 + "scanSizeHeight" + min + "mHeight:" + i11);
        if (i11 >= i21 + min) {
        }
        if (i10 >= i12 + i13) {
        }
        return new r(bArr, i10, i11, i12, i15, i16, i14, false);
    }
}
