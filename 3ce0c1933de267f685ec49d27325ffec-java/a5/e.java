package a5;

import android.graphics.Bitmap;
import com.bumptech.glide.load.resource.bitmap.o;
import java.security.MessageDigest;
import q4.b;
/* compiled from: CenterCrop.java */
/* loaded from: classes.dex */
public class e extends d {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f94b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(b.f32922a);

    @Override // q4.b
    public void b(MessageDigest messageDigest) {
        messageDigest.update(f94b);
    }

    @Override // a5.d
    protected Bitmap c(u4.e eVar, Bitmap bitmap, int i10, int i11) {
        return o.b(eVar, bitmap, i10, i11);
    }

    @Override // q4.b
    public boolean equals(Object obj) {
        return obj instanceof e;
    }

    @Override // q4.b
    public int hashCode() {
        return -599754482;
    }
}
