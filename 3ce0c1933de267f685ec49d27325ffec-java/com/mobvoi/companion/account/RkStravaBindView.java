package com.mobvoi.companion.account;

import android.content.Context;
import android.util.AttributeSet;
import ce.h;
import com.mobvoi.companion.view.HealthDataBindView;
import vc.a;
/* loaded from: classes2.dex */
public class RkStravaBindView extends HealthDataBindView {

    /* renamed from: o  reason: collision with root package name */
    private String f16128o;

    public RkStravaBindView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.view.HealthDataBindView
    public void d(AttributeSet attributeSet, int i10) {
        super.d(attributeSet, i10);
        r();
    }

    public boolean q() {
        if ("runkeeper".equals(this.f16128o)) {
            return a.b(getContext());
        }
        if ("strava".equals(this.f16128o)) {
            return a.c(getContext());
        }
        return false;
    }

    public void r() {
        if (q()) {
            setValue(getContext().getString(h.f5862o));
        } else {
            setValue(getContext().getString(h.f5864p));
        }
    }

    public void setBindType(String str) {
        this.f16128o = str;
        r();
    }
}
