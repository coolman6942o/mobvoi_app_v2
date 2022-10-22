package v4;

import java.io.File;
import v4.a;
/* compiled from: DiskLruCacheFactory.java */
/* loaded from: classes.dex */
public class d implements a.AbstractC0513a {

    /* renamed from: a  reason: collision with root package name */
    private final long f35592a;

    /* renamed from: b  reason: collision with root package name */
    private final a f35593b;

    /* compiled from: DiskLruCacheFactory.java */
    /* loaded from: classes.dex */
    public interface a {
        File a();
    }

    public d(a aVar, long j10) {
        this.f35592a = j10;
        this.f35593b = aVar;
    }

    @Override // v4.a.AbstractC0513a
    public v4.a build() {
        File a10 = this.f35593b.a();
        if (a10 == null) {
            return null;
        }
        if (a10.mkdirs() || (a10.exists() && a10.isDirectory())) {
            return e.c(a10, this.f35592a);
        }
        return null;
    }
}
