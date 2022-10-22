package x4;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import q4.e;
import r4.d;
import x4.n;
/* compiled from: ByteArrayLoader.java */
/* loaded from: classes.dex */
public class b<Data> implements n<byte[], Data> {

    /* renamed from: a  reason: collision with root package name */
    private final AbstractC0530b<Data> f36364a;

    /* compiled from: ByteArrayLoader.java */
    /* loaded from: classes.dex */
    public static class a implements o<byte[], ByteBuffer> {

        /* compiled from: ByteArrayLoader.java */
        /* renamed from: x4.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0529a implements AbstractC0530b<ByteBuffer> {
            C0529a(a aVar) {
            }

            @Override // x4.b.AbstractC0530b
            public Class<ByteBuffer> a() {
                return ByteBuffer.class;
            }

            /* renamed from: c */
            public ByteBuffer b(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        @Override // x4.o
        public n<byte[], ByteBuffer> b(r rVar) {
            return new b(new C0529a(this));
        }
    }

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: x4.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface AbstractC0530b<Data> {
        Class<Data> a();

        Data b(byte[] bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ByteArrayLoader.java */
    /* loaded from: classes.dex */
    public static class c<Data> implements r4.d<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f36365a;

        /* renamed from: b  reason: collision with root package name */
        private final AbstractC0530b<Data> f36366b;

        c(byte[] bArr, AbstractC0530b<Data> bVar) {
            this.f36365a = bArr;
            this.f36366b = bVar;
        }

        @Override // r4.d
        public Class<Data> a() {
            return this.f36366b.a();
        }

        @Override // r4.d
        public DataSource b() {
            return DataSource.LOCAL;
        }

        @Override // r4.d
        public void c() {
        }

        @Override // r4.d
        public void cancel() {
        }

        @Override // r4.d
        public void e(Priority priority, d.a<? super Data> aVar) {
            aVar.f((Data) this.f36366b.b(this.f36365a));
        }
    }

    /* compiled from: ByteArrayLoader.java */
    /* loaded from: classes.dex */
    public static class d implements o<byte[], InputStream> {

        /* compiled from: ByteArrayLoader.java */
        /* loaded from: classes.dex */
        class a implements AbstractC0530b<InputStream> {
            a(d dVar) {
            }

            @Override // x4.b.AbstractC0530b
            public Class<InputStream> a() {
                return InputStream.class;
            }

            /* renamed from: c */
            public InputStream b(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        @Override // x4.o
        public n<byte[], InputStream> b(r rVar) {
            return new b(new a(this));
        }
    }

    public b(AbstractC0530b<Data> bVar) {
        this.f36364a = bVar;
    }

    /* renamed from: c */
    public n.a<Data> b(byte[] bArr, int i10, int i11, e eVar) {
        return new n.a<>(new m5.b(bArr), new c(bArr, this.f36364a));
    }

    /* renamed from: d */
    public boolean a(byte[] bArr) {
        return true;
    }
}
