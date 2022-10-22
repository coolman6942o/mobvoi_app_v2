package com.mobvoi.android.common.ui.view.datetimepicker;

import android.view.View;
import android.view.ViewGroup;
/* compiled from: ViewUtils.java */
/* loaded from: classes2.dex */
class b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, boolean z10) {
        view.setEnabled(z10);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                a(viewGroup.getChildAt(i10), z10);
            }
        }
    }
}
