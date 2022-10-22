package x4;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import q4.e;
import r4.d;
import x4.n;
/* compiled from: MediaStoreFileLoader.java */
/* loaded from: classes.dex */
public final class k implements n<Uri, File> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f36392a;

    /* compiled from: MediaStoreFileLoader.java */
    /* loaded from: classes.dex */
    public static final class a implements o<Uri, File> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f36393a;

        public a(Context context) {
            this.f36393a = context;
        }

        @Override // x4.o
        public n<Uri, File> b(r rVar) {
            return new k(this.f36393a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MediaStoreFileLoader.java */
    /* loaded from: classes.dex */
    public static class b implements d<File> {

        /* renamed from: c  reason: collision with root package name */
        private static final String[] f36394c = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        private final Context f36395a;

        /* renamed from: b  reason: collision with root package name */
        private final Uri f36396b;

        b(Context context, Uri uri) {
            this.f36395a = context;
            this.f36396b = uri;
        }

        @Override // r4.d
        public Class<File> a() {
            return File.class;
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
        public void e(Priority priority, d.a<? super File> aVar) {
            Cursor query = this.f36395a.getContentResolver().query(this.f36396b, f36394c, null, null, null);
            String str = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(str)) {
                aVar.d(new FileNotFoundException("Failed to find file path for: " + this.f36396b));
                return;
            }
            aVar.f(new File(str));
        }
    }

    public k(Context context) {
        this.f36392a = context;
    }

    /* renamed from: c */
    public n.a<File> b(Uri uri, int i10, int i11, e eVar) {
        return new n.a<>(new m5.b(uri), new b(this.f36392a, uri));
    }

    /* renamed from: d */
    public boolean a(Uri uri) {
        return s4.b.b(uri);
    }
}
