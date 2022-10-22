package com.mobvoi.mcuwatch.ui.settings.apollo;

import android.widget.CompoundButton;
import com.mobvoi.mcuwatch.ui.settings.apollo.NotificationSettingActivity;
/* loaded from: classes2.dex */
public final /* synthetic */ class r implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ r f20106a = new r();

    private /* synthetic */ r() {
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        NotificationSettingActivity.c.g(compoundButton, z10);
    }
}
