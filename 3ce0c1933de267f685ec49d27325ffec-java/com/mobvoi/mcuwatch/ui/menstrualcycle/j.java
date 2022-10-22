package com.mobvoi.mcuwatch.ui.menstrualcycle;

import android.widget.CompoundButton;
import com.mobvoi.mcuwatch.ui.menstrualcycle.MenstrualDetailsActivity;
/* loaded from: classes2.dex */
public final /* synthetic */ class j implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ j f19809a = new j();

    private /* synthetic */ j() {
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        MenstrualDetailsActivity.b.m(compoundButton, z10);
    }
}
