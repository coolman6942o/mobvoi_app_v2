package a5;

import android.graphics.Bitmap;
import com.bumptech.glide.load.resource.bitmap.o;
import java.security.MessageDigest;
import q4.b;
import u4.e;
/* compiled from: CircleCrop.java */
/* loaded from: classes.dex */
public class g extends d {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f96b = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1".getBytes(b.f32922a);

    @Override // q4.b
    public void b(MessageDigest messageDigest) {
        messageDigest.update(f96b);
    }

    @Override // a5.d
    protected Bitmap c(e eVar, Bitmap bitmap, int i10, int i11) {
        return o.d(eVar, bitmap, i10, i11);
    }

    @Override // q4.b
    public boolean equals(Object obj) {
        return obj instanceof g;
    }

    @Override // q4.b
    public int hashCode() {
        return 1101716364;
    }
}
