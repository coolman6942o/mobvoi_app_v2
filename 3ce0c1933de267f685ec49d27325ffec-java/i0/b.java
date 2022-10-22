package i0;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
/* compiled from: HtmlCompat.java */
@SuppressLint({"InlinedApi"})
/* loaded from: classes.dex */
public final class b {
    public static Spanned a(String str, int i10) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Html.fromHtml(str, i10);
        }
        return Html.fromHtml(str);
    }
}
