package r4;

import com.bumptech.glide.load.resource.bitmap.l;
import java.io.IOException;
import java.io.InputStream;
import r4.e;
import u4.b;
/* compiled from: InputStreamRewinder.java */
/* loaded from: classes.dex */
public final class k implements e<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final l f33425a;

    /* compiled from: InputStreamRewinder.java */
    /* loaded from: classes.dex */
    public static final class a implements e.a<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final b f33426a;

        public a(b bVar) {
            this.f33426a = bVar;
        }

        @Override // r4.e.a
        public Class<InputStream> a() {
            return InputStream.class;
        }

        /* renamed from: c */
        public e<InputStream> b(InputStream inputStream) {
            return new k(inputStream, this.f33426a);
        }
    }

    k(InputStream inputStream, b bVar) {
        l lVar = new l(inputStream, bVar);
        this.f33425a = lVar;
        lVar.mark(5242880);
    }

    /* renamed from: b */
    public InputStream a() throws IOException {
        this.f33425a.reset();
        return this.f33425a;
    }

    @Override // r4.e
    public void c() {
        this.f33425a.h();
    }
}
