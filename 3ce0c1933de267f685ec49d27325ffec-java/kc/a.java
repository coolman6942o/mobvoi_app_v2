package kc;

import android.content.Context;
import android.content.res.TypedArray;
/* compiled from: AttrUtils.java */
/* loaded from: classes2.dex */
public class a {
    public static int a(Context context) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16842906});
        int color = obtainStyledAttributes.getColor(0, -7829368);
        obtainStyledAttributes.recycle();
        return color;
    }
}
