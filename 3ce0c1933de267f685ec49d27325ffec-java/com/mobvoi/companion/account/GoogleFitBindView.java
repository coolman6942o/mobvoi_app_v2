package com.mobvoi.companion.account;

import android.content.Context;
import android.util.AttributeSet;
import ce.h;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.view.HealthDataBindView;
import vc.a;
/* loaded from: classes2.dex */
public class GoogleFitBindView extends HealthDataBindView {
    public GoogleFitBindView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.view.HealthDataBindView
    public void d(AttributeSet attributeSet, int i10) {
        super.d(attributeSet, i10);
        r();
    }

    public boolean q() {
        return a.a(getContext());
    }

    public void r() {
        k.c("GoogleFitBindView", "google fit bind status: %s", Boolean.valueOf(q()));
        if (q()) {
            setValue(getContext().getString(h.f5862o));
        } else {
            setValue(getContext().getString(h.f5864p));
        }
    }
}
