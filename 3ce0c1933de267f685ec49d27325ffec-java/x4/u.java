package x4;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import java.io.File;
import java.io.InputStream;
import q4.e;
import x4.n;
/* compiled from: StringLoader.java */
/* loaded from: classes.dex */
public class u<Data> implements n<String, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final n<Uri, Data> f36434a;

    /* compiled from: StringLoader.java */
    /* loaded from: classes.dex */
    public static final class a implements o<String, AssetFileDescriptor> {
        @Override // x4.o
        public n<String, AssetFileDescriptor> b(r rVar) {
            return new u(rVar.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* compiled from: StringLoader.java */
    /* loaded from: classes.dex */
    public static class b implements o<String, ParcelFileDescriptor> {
        @Override // x4.o
        public n<String, ParcelFileDescriptor> b(r rVar) {
            return new u(rVar.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* compiled from: StringLoader.java */
    /* loaded from: classes.dex */
    public static class c implements o<String, InputStream> {
        @Override // x4.o
        public n<String, InputStream> b(r rVar) {
            return new u(rVar.d(Uri.class, InputStream.class));
        }
    }

    public u(n<Uri, Data> nVar) {
        this.f36434a = nVar;
    }

    private static Uri e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return f(str);
        }
        Uri parse = Uri.parse(str);
        return parse.getScheme() == null ? f(str) : parse;
    }

    private static Uri f(String str) {
        return Uri.fromFile(new File(str));
    }

    /* renamed from: c */
    public n.a<Data> b(String str, int i10, int i11, e eVar) {
        Uri e10 = e(str);
        if (e10 == null || !this.f36434a.a(e10)) {
            return null;
        }
        return this.f36434a.b(e10, i10, i11, eVar);
    }

    /* renamed from: d */
    public boolean a(String str) {
        return true;
    }
}
