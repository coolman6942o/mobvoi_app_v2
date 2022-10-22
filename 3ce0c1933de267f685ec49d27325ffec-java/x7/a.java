package x7;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import d7.b;
import i.d;
/* compiled from: MaterialThemeOverlay.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f36487a = {16842752, b.f25144a0};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f36488b = {b.H};

    private static int a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f36487a);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        return resourceId != 0 ? resourceId : resourceId2;
    }

    private static int b(Context context, AttributeSet attributeSet, int i10, int i11) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f36488b, i10, i11);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public static Context c(Context context, AttributeSet attributeSet, int i10, int i11) {
        int b10 = b(context, attributeSet, i10, i11);
        boolean z10 = (context instanceof d) && ((d) context).c() == b10;
        if (b10 == 0 || z10) {
            return context;
        }
        d dVar = new d(context, b10);
        int a10 = a(context, attributeSet);
        if (a10 != 0) {
            dVar.getTheme().applyStyle(a10, true);
        }
        return dVar;
    }
}
