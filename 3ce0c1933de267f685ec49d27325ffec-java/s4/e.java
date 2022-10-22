package s4;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import u4.b;
/* compiled from: ThumbnailStreamOpener.java */
/* loaded from: classes.dex */
class e {

    /* renamed from: f  reason: collision with root package name */
    private static final a f34303f = new a();

    /* renamed from: a  reason: collision with root package name */
    private final a f34304a;

    /* renamed from: b  reason: collision with root package name */
    private final d f34305b;

    /* renamed from: c  reason: collision with root package name */
    private final b f34306c;

    /* renamed from: d  reason: collision with root package name */
    private final ContentResolver f34307d;

    /* renamed from: e  reason: collision with root package name */
    private final List<ImageHeaderParser> f34308e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(List<ImageHeaderParser> list, d dVar, b bVar, ContentResolver contentResolver) {
        this(list, f34303f, dVar, bVar, contentResolver);
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0048: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:25:0x0048 */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String b(Uri uri) {
        Throwable th2;
        SecurityException e10;
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            try {
                cursor = this.f34305b.a(uri);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            String string = cursor.getString(0);
                            cursor.close();
                            return string;
                        }
                    } catch (SecurityException e11) {
                        e10 = e11;
                        if (Log.isLoggable("ThumbStreamOpener", 3)) {
                            Log.d("ThumbStreamOpener", "Failed to query for thumbnail for Uri: " + uri, e10);
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th2 = th3;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th2;
            }
        } catch (SecurityException e12) {
            e10 = e12;
            cursor = null;
        } catch (Throwable th4) {
            th2 = th4;
            if (cursor2 != null) {
            }
            throw th2;
        }
    }

    private boolean c(File file) {
        return this.f34304a.a(file) && 0 < this.f34304a.c(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(Uri uri) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = this.f34307d.openInputStream(uri);
                return a.a(this.f34308e, inputStream, this.f34306c);
            } finally {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
            }
        } catch (IOException | NullPointerException e10) {
            if (Log.isLoggable("ThumbStreamOpener", 3)) {
                Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e10);
            }
            if (inputStream == null) {
                return -1;
            }
            try {
                inputStream.close();
                return -1;
            } catch (IOException unused2) {
                return -1;
            }
        }
    }

    public InputStream d(Uri uri) throws FileNotFoundException {
        String b10 = b(uri);
        if (TextUtils.isEmpty(b10)) {
            return null;
        }
        File b11 = this.f34304a.b(b10);
        if (!c(b11)) {
            return null;
        }
        Uri fromFile = Uri.fromFile(b11);
        try {
            return this.f34307d.openInputStream(fromFile);
        } catch (NullPointerException e10) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e10));
        }
    }

    e(List<ImageHeaderParser> list, a aVar, d dVar, b bVar, ContentResolver contentResolver) {
        this.f34304a = aVar;
        this.f34305b = dVar;
        this.f34306c = bVar;
        this.f34307d = contentResolver;
        this.f34308e = list;
    }
}
