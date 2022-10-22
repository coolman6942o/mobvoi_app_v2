package androidx.core.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;
import g0.c;
/* compiled from: ContentResolverCompat.java */
/* loaded from: classes.dex */
public final class a {
    public static Cursor a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, c cVar) {
        Object b10;
        if (Build.VERSION.SDK_INT >= 16) {
            if (cVar != null) {
                try {
                    b10 = cVar.b();
                } catch (Exception e10) {
                    if (e10 instanceof OperationCanceledException) {
                        throw new androidx.core.os.OperationCanceledException();
                    }
                    throw e10;
                }
            } else {
                b10 = null;
            }
            return contentResolver.query(uri, strArr, str, strArr2, str2, (CancellationSignal) b10);
        }
        if (cVar != null) {
            cVar.e();
        }
        return contentResolver.query(uri, strArr, str, strArr2, str2);
    }
}
