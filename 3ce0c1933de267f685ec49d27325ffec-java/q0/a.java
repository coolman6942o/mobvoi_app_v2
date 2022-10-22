package q0;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
/* compiled from: DocumentFile.java */
/* loaded from: classes.dex */
public abstract class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(a aVar) {
    }

    public static a b(Context context, Uri uri) {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        String treeDocumentId = DocumentsContract.getTreeDocumentId(uri);
        if (DocumentsContract.isDocumentUri(context, uri)) {
            treeDocumentId = DocumentsContract.getDocumentId(uri);
        }
        return new b(null, context, DocumentsContract.buildDocumentUriUsingTree(uri, treeDocumentId));
    }

    public abstract a a(String str, String str2);

    public abstract Uri c();
}
