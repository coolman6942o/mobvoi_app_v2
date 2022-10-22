package com.mobvoi.companion.account;

import android.content.Context;
import android.util.AttributeSet;
import ce.h;
import com.mobvoi.companion.setting.CompanionSetting;
import com.mobvoi.companion.view.HealthDataBindView;
/* loaded from: classes2.dex */
public class ArtyBindView extends HealthDataBindView {
    public ArtyBindView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.view.HealthDataBindView
    public void d(AttributeSet attributeSet, int i10) {
        super.d(attributeSet, i10);
        r();
    }

    public boolean q() {
        return CompanionSetting.isArtyAuthorize();
    }

    public void r() {
        if (q()) {
            setValue(getContext().getString(h.f5862o));
        } else {
            setValue(getContext().getString(h.f5864p));
        }
    }
}
