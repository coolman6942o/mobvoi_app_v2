package b5;

import java.nio.ByteBuffer;
import r4.e;
/* compiled from: ByteBufferRewinder.java */
/* loaded from: classes.dex */
public class a implements e<ByteBuffer> {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f5039a;

    /* compiled from: ByteBufferRewinder.java */
    /* renamed from: b5.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0070a implements e.a<ByteBuffer> {
        @Override // r4.e.a
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        /* renamed from: c */
        public e<ByteBuffer> b(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }
    }

    public a(ByteBuffer byteBuffer) {
        this.f5039a = byteBuffer;
    }

    /* renamed from: b */
    public ByteBuffer a() {
        this.f5039a.position(0);
        return this.f5039a;
    }

    @Override // r4.e
    public void c() {
    }
}
