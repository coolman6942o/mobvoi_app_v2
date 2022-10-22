package v4;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import o4.a;
import q4.b;
import v4.a;
/* compiled from: DiskLruCacheWrapper.java */
/* loaded from: classes.dex */
public class e implements a {

    /* renamed from: b  reason: collision with root package name */
    private final File f35595b;

    /* renamed from: c  reason: collision with root package name */
    private final long f35596c;

    /* renamed from: e  reason: collision with root package name */
    private a f35598e;

    /* renamed from: d  reason: collision with root package name */
    private final c f35597d = new c();

    /* renamed from: a  reason: collision with root package name */
    private final j f35594a = new j();

    @Deprecated
    protected e(File file, long j10) {
        this.f35595b = file;
        this.f35596c = j10;
    }

    public static a c(File file, long j10) {
        return new e(file, j10);
    }

    private synchronized a d() throws IOException {
        if (this.f35598e == null) {
            this.f35598e = a.g0(this.f35595b, 1, 1, this.f35596c);
        }
        return this.f35598e;
    }

    /* JADX WARN: Finally extract failed */
    @Override // v4.a
    public void a(b bVar, a.b bVar2) {
        o4.a d10;
        String b10 = this.f35594a.b(bVar);
        this.f35597d.a(b10);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + b10 + " for for Key: " + bVar);
            }
            try {
                d10 = d();
            } catch (IOException e10) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e10);
                }
            }
            if (d10.V(b10) == null) {
                a.c O = d10.O(b10);
                if (O != null) {
                    try {
                        if (bVar2.a(O.f(0))) {
                            O.e();
                        }
                        O.b();
                    } catch (Throwable th2) {
                        O.b();
                        throw th2;
                    }
                } else {
                    throw new IllegalStateException("Had two simultaneous puts for: " + b10);
                }
            }
        } finally {
            this.f35597d.b(b10);
        }
    }

    @Override // v4.a
    public File b(b bVar) {
        String b10 = this.f35594a.b(bVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + b10 + " for for Key: " + bVar);
        }
        try {
            a.e V = d().V(b10);
            if (V != null) {
                return V.a(0);
            }
            return null;
        } catch (IOException e10) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e10);
            return null;
        }
    }
}
