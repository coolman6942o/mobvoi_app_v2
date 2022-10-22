package a5;

import android.graphics.Bitmap;
import com.bumptech.glide.load.resource.bitmap.o;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import n5.k;
import q4.b;
import u4.e;
/* compiled from: RoundedCorners.java */
/* loaded from: classes.dex */
public final class j extends d {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f100c = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(b.f32922a);

    /* renamed from: b  reason: collision with root package name */
    private final int f101b;

    public j(int i10) {
        n5.j.a(i10 > 0, "roundingRadius must be greater than 0.");
        this.f101b = i10;
    }

    @Override // q4.b
    public void b(MessageDigest messageDigest) {
        messageDigest.update(f100c);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f101b).array());
    }

    @Override // a5.d
    protected Bitmap c(e eVar, Bitmap bitmap, int i10, int i11) {
        return o.o(eVar, bitmap, this.f101b);
    }

    @Override // q4.b
    public boolean equals(Object obj) {
        return (obj instanceof j) && this.f101b == ((j) obj).f101b;
    }

    @Override // q4.b
    public int hashCode() {
        return k.m(-569625254, k.l(this.f101b));
    }
}
