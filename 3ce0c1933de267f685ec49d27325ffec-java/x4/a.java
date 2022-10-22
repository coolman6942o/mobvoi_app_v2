package x4;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.mobvoi.wear.common.base.WearPath;
import java.io.InputStream;
import q4.e;
import r4.d;
import r4.h;
import r4.m;
import x4.n;
/* compiled from: AssetUriLoader.java */
/* loaded from: classes.dex */
public class a<Data> implements n<Uri, Data> {

    /* renamed from: c  reason: collision with root package name */
    private static final int f36359c = 22;

    /* renamed from: a  reason: collision with root package name */
    private final AssetManager f36360a;

    /* renamed from: b  reason: collision with root package name */
    private final AbstractC0528a<Data> f36361b;

    /* compiled from: AssetUriLoader.java */
    /* renamed from: x4.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface AbstractC0528a<Data> {
        d<Data> a(AssetManager assetManager, String str);
    }

    /* compiled from: AssetUriLoader.java */
    /* loaded from: classes.dex */
    public static class b implements o<Uri, ParcelFileDescriptor>, AbstractC0528a<ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f36362a;

        public b(AssetManager assetManager) {
            this.f36362a = assetManager;
        }

        @Override // x4.a.AbstractC0528a
        public d<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
            return new h(assetManager, str);
        }

        @Override // x4.o
        public n<Uri, ParcelFileDescriptor> b(r rVar) {
            return new a(this.f36362a, this);
        }
    }

    /* compiled from: AssetUriLoader.java */
    /* loaded from: classes.dex */
    public static class c implements o<Uri, InputStream>, AbstractC0528a<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f36363a;

        public c(AssetManager assetManager) {
            this.f36363a = assetManager;
        }

        @Override // x4.a.AbstractC0528a
        public d<InputStream> a(AssetManager assetManager, String str) {
            return new m(assetManager, str);
        }

        @Override // x4.o
        public n<Uri, InputStream> b(r rVar) {
            return new a(this.f36363a, this);
        }
    }

    public a(AssetManager assetManager, AbstractC0528a<Data> aVar) {
        this.f36360a = assetManager;
        this.f36361b = aVar;
    }

    /* renamed from: c */
    public n.a<Data> b(Uri uri, int i10, int i11, e eVar) {
        return new n.a<>(new m5.b(uri), this.f36361b.a(this.f36360a, uri.toString().substring(f36359c)));
    }

    /* renamed from: d */
    public boolean a(Uri uri) {
        return WearPath.RecorderV2.MAP_KEY_FILE.equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }
}
