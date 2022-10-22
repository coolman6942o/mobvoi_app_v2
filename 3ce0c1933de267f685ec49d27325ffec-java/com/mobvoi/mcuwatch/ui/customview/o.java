package com.mobvoi.mcuwatch.ui.customview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.mobvoi.companion.ui.e;
import sh.h;
import sh.i;
/* compiled from: DeviceLanguageItemView.java */
/* loaded from: classes2.dex */
public class o extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    Context f19678a;

    /* renamed from: b  reason: collision with root package name */
    private View f19679b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f19680c;

    public o(Context context) {
        super(context);
        this.f19678a = context;
        b();
    }

    private void b() {
        View inflate = LayoutInflater.from(this.f19678a).inflate(i.f34767z0, (ViewGroup) this, true);
        this.f19679b = inflate;
        this.f19680c = (TextView) inflate.findViewById(h.f34666m3);
    }

    public void a(e eVar) {
        this.f19680c.setText(eVar.titleResId);
        setOnClickListener(eVar.onClickListener);
    }
}
