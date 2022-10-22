package com.google.android.material.internal;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
/* compiled from: ToolbarUtils.java */
/* loaded from: classes.dex */
public class l {
    public static TextView a(Toolbar toolbar) {
        return b(toolbar, toolbar.getSubtitle());
    }

    private static TextView b(Toolbar toolbar, CharSequence charSequence) {
        for (int i10 = 0; i10 < toolbar.getChildCount(); i10++) {
            View childAt = toolbar.getChildAt(i10);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    return textView;
                }
            }
        }
        return null;
    }

    public static TextView c(Toolbar toolbar) {
        return b(toolbar, toolbar.getTitle());
    }
}
