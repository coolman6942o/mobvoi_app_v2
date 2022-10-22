package q0;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TreeDocumentFile.java */
/* loaded from: classes.dex */
public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private Context f32906a;

    /* renamed from: b  reason: collision with root package name */
    private Uri f32907b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, Context context, Uri uri) {
        super(aVar);
        this.f32906a = context;
        this.f32907b = uri;
    }

    private static Uri d(Context context, Uri uri, String str, String str2) {
        try {
            return DocumentsContract.createDocument(context.getContentResolver(), uri, str, str2);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // q0.a
    public a a(String str, String str2) {
        Uri d10 = d(this.f32906a, this.f32907b, str, str2);
        if (d10 != null) {
            return new b(this, this.f32906a, d10);
        }
        return null;
    }

    @Override // q0.a
    public Uri c() {
        return this.f32907b;
    }
}
