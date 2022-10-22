package x4;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.mobvoi.wear.common.base.WearPath;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import q4.e;
import r4.i;
import r4.n;
import x4.n;
/* compiled from: UriLoader.java */
/* loaded from: classes.dex */
public class w<Data> implements n<Uri, Data> {

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f36438b = Collections.unmodifiableSet(new HashSet(Arrays.asList(WearPath.RecorderV2.MAP_KEY_FILE, "android.resource", "content")));

    /* renamed from: a  reason: collision with root package name */
    private final c<Data> f36439a;

    /* compiled from: UriLoader.java */
    /* loaded from: classes.dex */
    public static final class a implements o<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f36440a;

        public a(ContentResolver contentResolver) {
            this.f36440a = contentResolver;
        }

        @Override // x4.w.c
        public r4.d<AssetFileDescriptor> a(Uri uri) {
            return new r4.a(this.f36440a, uri);
        }

        @Override // x4.o
        public n<Uri, AssetFileDescriptor> b(r rVar) {
            return new w(this);
        }
    }

    /* compiled from: UriLoader.java */
    /* loaded from: classes.dex */
    public static class b implements o<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f36441a;

        public b(ContentResolver contentResolver) {
            this.f36441a = contentResolver;
        }

        @Override // x4.w.c
        public r4.d<ParcelFileDescriptor> a(Uri uri) {
            return new i(this.f36441a, uri);
        }

        @Override // x4.o
        public n<Uri, ParcelFileDescriptor> b(r rVar) {
            return new w(this);
        }
    }

    /* compiled from: UriLoader.java */
    /* loaded from: classes.dex */
    public interface c<Data> {
        r4.d<Data> a(Uri uri);
    }

    /* compiled from: UriLoader.java */
    /* loaded from: classes.dex */
    public static class d implements o<Uri, InputStream>, c<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f36442a;

        public d(ContentResolver contentResolver) {
            this.f36442a = contentResolver;
        }

        @Override // x4.w.c
        public r4.d<InputStream> a(Uri uri) {
            return new n(this.f36442a, uri);
        }

        @Override // x4.o
        public n<Uri, InputStream> b(r rVar) {
            return new w(this);
        }
    }

    public w(c<Data> cVar) {
        this.f36439a = cVar;
    }

    /* renamed from: c */
    public n.a<Data> b(Uri uri, int i10, int i11, e eVar) {
        return new n.a<>(new m5.b(uri), this.f36439a.a(uri));
    }

    /* renamed from: d */
    public boolean a(Uri uri) {
        return f36438b.contains(uri.getScheme());
    }
}
