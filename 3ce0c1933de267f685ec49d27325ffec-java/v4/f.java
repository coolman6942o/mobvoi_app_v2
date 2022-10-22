package v4;

import android.content.Context;
import java.io.File;
import v4.d;
/* compiled from: InternalCacheDiskCacheFactory.java */
/* loaded from: classes.dex */
public final class f extends d {

    /* compiled from: InternalCacheDiskCacheFactory.java */
    /* loaded from: classes.dex */
    class a implements d.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f35599a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f35600b;

        a(Context context, String str) {
            this.f35599a = context;
            this.f35600b = str;
        }

        @Override // v4.d.a
        public File a() {
            File cacheDir = this.f35599a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f35600b != null ? new File(cacheDir, this.f35600b) : cacheDir;
        }
    }

    public f(Context context) {
        this(context, "image_manager_disk_cache", 262144000L);
    }

    public f(Context context, String str, long j10) {
        super(new a(context, str), j10);
    }
}
