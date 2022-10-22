package c2;

import android.util.TypedValue;
import android.view.View;
/* compiled from: Utils.java */
/* loaded from: classes.dex */
public final class a {
    static {
        new TypedValue();
    }

    public static <T> T a(View view, int i10, String str, Class<T> cls) {
        try {
            return cls.cast(view);
        } catch (ClassCastException e10) {
            String d10 = d(view, i10);
            throw new IllegalStateException("View '" + d10 + "' with ID " + i10 + " for " + str + " was of the wrong type. See cause for more info.", e10);
        }
    }

    public static View b(View view, int i10, String str) {
        View findViewById = view.findViewById(i10);
        if (findViewById != null) {
            return findViewById;
        }
        String d10 = d(view, i10);
        throw new IllegalStateException("Required view '" + d10 + "' with ID " + i10 + " for " + str + " was not found. If this view is optional add '@Nullable' (fields) or '@Optional' (methods) annotation.");
    }

    public static <T> T c(View view, int i10, String str, Class<T> cls) {
        return (T) a(b(view, i10, str), i10, str, cls);
    }

    private static String d(View view, int i10) {
        return view.isInEditMode() ? "<unavailable while editing>" : view.getContext().getResources().getResourceEntryName(i10);
    }
}
