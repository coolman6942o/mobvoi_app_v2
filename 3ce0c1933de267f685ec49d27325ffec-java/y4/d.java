package y4;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.resource.bitmap.q;
import java.io.InputStream;
import q4.e;
import s4.b;
import s4.c;
import x4.n;
import x4.o;
import x4.r;
/* compiled from: MediaStoreVideoThumbLoader.java */
/* loaded from: classes.dex */
public class d implements n<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f36755a;

    /* compiled from: MediaStoreVideoThumbLoader.java */
    /* loaded from: classes.dex */
    public static class a implements o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f36756a;

        public a(Context context) {
            this.f36756a = context;
        }

        @Override // x4.o
        public n<Uri, InputStream> b(r rVar) {
            return new d(this.f36756a);
        }
    }

    public d(Context context) {
        this.f36755a = context.getApplicationContext();
    }

    private boolean e(e eVar) {
        Long l10 = (Long) eVar.c(q.f8123d);
        return l10 != null && l10.longValue() == -1;
    }

    /* renamed from: c */
    public n.a<InputStream> b(Uri uri, int i10, int i11, e eVar) {
        if (!b.d(i10, i11) || !e(eVar)) {
            return null;
        }
        return new n.a<>(new m5.b(uri), c.g(this.f36755a, uri));
    }

    /* renamed from: d */
    public boolean a(Uri uri) {
        return b.c(uri);
    }
}
