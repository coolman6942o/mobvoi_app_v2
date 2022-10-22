package ud;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
/* compiled from: ClipboardUtil.java */
/* loaded from: classes2.dex */
public class d {
    public static boolean a(Context context, String str) {
        return b(context, "TicWearClipboard", str);
    }

    public static boolean b(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            str = "TicWearClipboard";
        }
        ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(str, str2));
        return true;
    }
}
