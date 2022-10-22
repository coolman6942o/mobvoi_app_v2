package x4;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import r4.d;
import x4.n;
/* compiled from: FileLoader.java */
/* loaded from: classes.dex */
public class f<Data> implements n<File, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final d<Data> f36373a;

    /* compiled from: FileLoader.java */
    /* loaded from: classes.dex */
    public static class a<Data> implements o<File, Data> {

        /* renamed from: a  reason: collision with root package name */
        private final d<Data> f36374a;

        public a(d<Data> dVar) {
            this.f36374a = dVar;
        }

        @Override // x4.o
        public final n<File, Data> b(r rVar) {
            return new f(this.f36374a);
        }
    }

    /* compiled from: FileLoader.java */
    /* loaded from: classes.dex */
    public static class b extends a<ParcelFileDescriptor> {

        /* compiled from: FileLoader.java */
        /* loaded from: classes.dex */
        class a implements d<ParcelFileDescriptor> {
            a() {
            }

            @Override // x4.f.d
            public Class<ParcelFileDescriptor> a() {
                return ParcelFileDescriptor.class;
            }

            /* renamed from: d */
            public void b(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                parcelFileDescriptor.close();
            }

            /* renamed from: e */
            public ParcelFileDescriptor c(File file) throws FileNotFoundException {
                return ParcelFileDescriptor.open(file, 268435456);
            }
        }

        public b() {
            super(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileLoader.java */
    /* loaded from: classes.dex */
    public static final class c<Data> implements r4.d<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final File f36375a;

        /* renamed from: b  reason: collision with root package name */
        private final d<Data> f36376b;

        /* renamed from: c  reason: collision with root package name */
        private Data f36377c;

        c(File file, d<Data> dVar) {
            this.f36375a = file;
            this.f36376b = dVar;
        }

        @Override // r4.d
        public Class<Data> a() {
            return this.f36376b.a();
        }

        @Override // r4.d
        public DataSource b() {
            return DataSource.LOCAL;
        }

        @Override // r4.d
        public void c() {
            Data data = this.f36377c;
            if (data != null) {
                try {
                    this.f36376b.b(data);
                } catch (IOException unused) {
                }
            }
        }

        @Override // r4.d
        public void cancel() {
        }

        /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, Data] */
        @Override // r4.d
        public void e(Priority priority, d.a<? super Data> aVar) {
            try {
                Data c10 = this.f36376b.c(this.f36375a);
                this.f36377c = c10;
                aVar.f(c10);
            } catch (FileNotFoundException e10) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e10);
                }
                aVar.d(e10);
            }
        }
    }

    /* compiled from: FileLoader.java */
    /* loaded from: classes.dex */
    public interface d<Data> {
        Class<Data> a();

        void b(Data data) throws IOException;

        Data c(File file) throws FileNotFoundException;
    }

    /* compiled from: FileLoader.java */
    /* loaded from: classes.dex */
    public static class e extends a<InputStream> {

        /* compiled from: FileLoader.java */
        /* loaded from: classes.dex */
        class a implements d<InputStream> {
            a() {
            }

            @Override // x4.f.d
            public Class<InputStream> a() {
                return InputStream.class;
            }

            /* renamed from: d */
            public void b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            /* renamed from: e */
            public InputStream c(File file) throws FileNotFoundException {
                return new FileInputStream(file);
            }
        }

        public e() {
            super(new a());
        }
    }

    public f(d<Data> dVar) {
        this.f36373a = dVar;
    }

    /* renamed from: c */
    public n.a<Data> b(File file, int i10, int i11, q4.e eVar) {
        return new n.a<>(new m5.b(file), new c(file, this.f36373a));
    }

    /* renamed from: d */
    public boolean a(File file) {
        return true;
    }
}
