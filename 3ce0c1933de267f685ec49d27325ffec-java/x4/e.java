package x4;

import android.util.Base64;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import r4.d;
import x4.n;
/* compiled from: DataUrlLoader.java */
/* loaded from: classes.dex */
public final class e<Model, Data> implements n<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Data> f36368a;

    /* compiled from: DataUrlLoader.java */
    /* loaded from: classes.dex */
    public interface a<Data> {
        Class<Data> a();

        void b(Data data) throws IOException;

        Data c(String str) throws IllegalArgumentException;
    }

    /* compiled from: DataUrlLoader.java */
    /* loaded from: classes.dex */
    private static final class b<Data> implements d<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final String f36369a;

        /* renamed from: b  reason: collision with root package name */
        private final a<Data> f36370b;

        /* renamed from: c  reason: collision with root package name */
        private Data f36371c;

        b(String str, a<Data> aVar) {
            this.f36369a = str;
            this.f36370b = aVar;
        }

        @Override // r4.d
        public Class<Data> a() {
            return this.f36370b.a();
        }

        @Override // r4.d
        public DataSource b() {
            return DataSource.LOCAL;
        }

        @Override // r4.d
        public void c() {
            try {
                this.f36370b.b(this.f36371c);
            } catch (IOException unused) {
            }
        }

        @Override // r4.d
        public void cancel() {
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, Data] */
        @Override // r4.d
        public void e(Priority priority, d.a<? super Data> aVar) {
            try {
                Data c10 = this.f36370b.c(this.f36369a);
                this.f36371c = c10;
                aVar.f(c10);
            } catch (IllegalArgumentException e10) {
                aVar.d(e10);
            }
        }
    }

    /* compiled from: DataUrlLoader.java */
    /* loaded from: classes.dex */
    public static final class c<Model> implements o<Model, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final a<InputStream> f36372a = new a(this);

        /* compiled from: DataUrlLoader.java */
        /* loaded from: classes.dex */
        class a implements a<InputStream> {
            a(c cVar) {
            }

            @Override // x4.e.a
            public Class<InputStream> a() {
                return InputStream.class;
            }

            /* renamed from: d */
            public void b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            /* renamed from: e */
            public InputStream c(String str) {
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf == -1) {
                        throw new IllegalArgumentException("Missing comma in data URL.");
                    } else if (str.substring(0, indexOf).endsWith(";base64")) {
                        return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                    } else {
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                } else {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
            }
        }

        @Override // x4.o
        public n<Model, InputStream> b(r rVar) {
            return new e(this.f36372a);
        }
    }

    public e(a<Data> aVar) {
        this.f36368a = aVar;
    }

    @Override // x4.n
    public boolean a(Model model) {
        return model.toString().startsWith("data:image");
    }

    @Override // x4.n
    public n.a<Data> b(Model model, int i10, int i11, q4.e eVar) {
        return new n.a<>(new m5.b(model), new b(model.toString(), this.f36368a));
    }
}
