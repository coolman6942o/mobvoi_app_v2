package a5;

import android.graphics.Bitmap;
import com.bumptech.glide.load.resource.bitmap.o;
import java.security.MessageDigest;
import q4.b;
import u4.e;
/* compiled from: FitCenter.java */
/* loaded from: classes.dex */
public class h extends d {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f97b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(b.f32922a);

    @Override // q4.b
    public void b(MessageDigest messageDigest) {
        messageDigest.update(f97b);
    }

    @Override // a5.d
    protected Bitmap c(e eVar, Bitmap bitmap, int i10, int i11) {
        return o.f(eVar, bitmap, i10, i11);
    }

    @Override // q4.b
    public boolean equals(Object obj) {
        return obj instanceof h;
    }

    @Override // q4.b
    public int hashCode() {
        return 1572326941;
    }
}
