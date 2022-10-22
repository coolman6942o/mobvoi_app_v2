package com.mobvoi.companion.aw.watchfacecenter.glide;

import io.d;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Objects;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import q4.b;
/* compiled from: BluetoothWfImageReq.kt */
/* loaded from: classes2.dex */
public final class f implements b {

    /* renamed from: b  reason: collision with root package name */
    private final String f16446b;

    /* renamed from: c  reason: collision with root package name */
    private final d f16447c;

    /* compiled from: BluetoothWfImageReq.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements qo.a<byte[]> {
        a() {
            super(0);
        }

        /* renamed from: a */
        public final byte[] invoke() {
            String e10 = f.this.e();
            Charset CHARSET = b.f32922a;
            i.e(CHARSET, "CHARSET");
            Objects.requireNonNull(e10, "null cannot be cast to non-null type java.lang.String");
            byte[] bytes = e10.getBytes(CHARSET);
            i.e(bytes, "(this as java.lang.String).getBytes(charset)");
            return bytes;
        }
    }

    public f(String watchFaceClassName) {
        d a10;
        i.f(watchFaceClassName, "watchFaceClassName");
        this.f16446b = watchFaceClassName;
        a10 = io.f.a(new a());
        this.f16447c = a10;
    }

    private final byte[] d() {
        return (byte[]) this.f16447c.getValue();
    }

    @Override // q4.b
    public void b(MessageDigest messageDigest) {
        i.f(messageDigest, "messageDigest");
        messageDigest.update(d());
    }

    public final String c() {
        return this.f16446b;
    }

    public final String e() {
        return this.f16446b;
    }

    @Override // q4.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f) && i.b(this.f16446b, ((f) obj).f16446b);
    }

    @Override // q4.b
    public int hashCode() {
        return this.f16446b.hashCode();
    }

    public String toString() {
        return "BluetoothWfImageReq(watchFaceClassName=" + this.f16446b + ')';
    }
}
