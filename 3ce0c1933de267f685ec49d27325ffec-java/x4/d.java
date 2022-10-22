package x4;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import q4.e;
import r4.d;
import x4.n;
/* compiled from: ByteBufferFileLoader.java */
/* loaded from: classes.dex */
public class d implements n<File, ByteBuffer> {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ByteBufferFileLoader.java */
    /* loaded from: classes.dex */
    public static final class a implements r4.d<ByteBuffer> {

        /* renamed from: a  reason: collision with root package name */
        private final File f36367a;

        a(File file) {
            this.f36367a = file;
        }

        @Override // r4.d
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
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
        public void e(Priority priority, d.a<? super ByteBuffer> aVar) {
            try {
                aVar.f(n5.a.a(this.f36367a));
            } catch (IOException e10) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e10);
                }
                aVar.d(e10);
            }
        }
    }

    /* compiled from: ByteBufferFileLoader.java */
    /* loaded from: classes.dex */
    public static class b implements o<File, ByteBuffer> {
        @Override // x4.o
        public n<File, ByteBuffer> b(r rVar) {
            return new d();
        }
    }

    /* renamed from: c */
    public n.a<ByteBuffer> b(File file, int i10, int i11, e eVar) {
        return new n.a<>(new m5.b(file), new a(file));
    }

    /* renamed from: d */
    public boolean a(File file) {
        return true;
    }
}
