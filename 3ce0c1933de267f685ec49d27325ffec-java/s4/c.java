package s4;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import r4.d;
import r4.g;
/* compiled from: ThumbFetcher.java */
/* loaded from: classes.dex */
public class c implements d<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f34296a;

    /* renamed from: b  reason: collision with root package name */
    private final e f34297b;

    /* renamed from: c  reason: collision with root package name */
    private InputStream f34298c;

    /* compiled from: ThumbFetcher.java */
    /* loaded from: classes.dex */
    static class a implements d {

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f34299b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f34300a;

        a(ContentResolver contentResolver) {
            this.f34300a = contentResolver;
        }

        @Override // s4.d
        public Cursor a(Uri uri) {
            return this.f34300a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f34299b, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* compiled from: ThumbFetcher.java */
    /* loaded from: classes.dex */
    static class b implements d {

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f34301b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f34302a;

        b(ContentResolver contentResolver) {
            this.f34302a = contentResolver;
        }

        @Override // s4.d
        public Cursor a(Uri uri) {
            return this.f34302a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f34301b, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    c(Uri uri, e eVar) {
        this.f34296a = uri;
        this.f34297b = eVar;
    }

    private static c d(Context context, Uri uri, d dVar) {
        return new c(uri, new e(com.bumptech.glide.c.c(context).j().g(), dVar, com.bumptech.glide.c.c(context).e(), context.getContentResolver()));
    }

    public static c f(Context context, Uri uri) {
        return d(context, uri, new a(context.getContentResolver()));
    }

    public static c g(Context context, Uri uri) {
        return d(context, uri, new b(context.getContentResolver()));
    }

    private InputStream h() throws FileNotFoundException {
        InputStream d10 = this.f34297b.d(this.f34296a);
        int a10 = d10 != null ? this.f34297b.a(this.f34296a) : -1;
        return a10 != -1 ? new g(d10, a10) : d10;
    }

    @Override // r4.d
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // r4.d
    public DataSource b() {
        return DataSource.LOCAL;
    }

    @Override // r4.d
    public void c() {
        InputStream inputStream = this.f34298c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // r4.d
    public void cancel() {
    }

    @Override // r4.d
    public void e(Priority priority, d.a<? super InputStream> aVar) {
        try {
            InputStream h10 = h();
            this.f34298c = h10;
            aVar.f(h10);
        } catch (FileNotFoundException e10) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e10);
            }
            aVar.d(e10);
        }
    }
}
