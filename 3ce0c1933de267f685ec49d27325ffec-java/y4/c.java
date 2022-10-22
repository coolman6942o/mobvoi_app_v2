package y4;

import android.content.Context;
import android.net.Uri;
import java.io.InputStream;
import q4.e;
import s4.b;
import x4.n;
import x4.o;
import x4.r;
/* compiled from: MediaStoreImageThumbLoader.java */
/* loaded from: classes.dex */
public class c implements n<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f36753a;

    /* compiled from: MediaStoreImageThumbLoader.java */
    /* loaded from: classes.dex */
    public static class a implements o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f36754a;

        public a(Context context) {
            this.f36754a = context;
        }

        @Override // x4.o
        public n<Uri, InputStream> b(r rVar) {
            return new c(this.f36754a);
        }
    }

    public c(Context context) {
        this.f36753a = context.getApplicationContext();
    }

    /* renamed from: c */
    public n.a<InputStream> b(Uri uri, int i10, int i11, e eVar) {
        if (b.d(i10, i11)) {
            return new n.a<>(new m5.b(uri), s4.c.f(this.f36753a, uri));
        }
        return null;
    }

    /* renamed from: d */
    public boolean a(Uri uri) {
        return b.a(uri);
    }
}
