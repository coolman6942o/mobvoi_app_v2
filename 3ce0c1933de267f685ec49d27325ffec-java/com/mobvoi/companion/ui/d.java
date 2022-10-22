package com.mobvoi.companion.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ce.e;
import ce.f;
import com.mobvoi.android.common.ui.widget.BatteryIconView;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.WearableUiUtils;
import com.mobvoi.wear.info.WearInfo;
import java.util.ArrayList;
import java.util.List;
import pc.d;
import zd.b;
/* compiled from: McuBaseWearableCardFragment.java */
/* loaded from: classes2.dex */
public abstract class d extends b {

    /* renamed from: d  reason: collision with root package name */
    protected final List<e> f17633d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    protected ImageView f17634e;

    /* renamed from: f  reason: collision with root package name */
    protected TextView f17635f;

    /* renamed from: g  reason: collision with root package name */
    protected ImageView f17636g;

    /* renamed from: h  reason: collision with root package name */
    protected TextView f17637h;

    /* renamed from: i  reason: collision with root package name */
    protected BatteryIconView f17638i;

    /* renamed from: j  reason: collision with root package name */
    protected TextView f17639j;

    /* renamed from: k  reason: collision with root package name */
    protected View f17640k;

    /* renamed from: l  reason: collision with root package name */
    protected TextView f17641l;

    /* renamed from: m  reason: collision with root package name */
    protected RecyclerView f17642m;

    /* renamed from: n  reason: collision with root package name */
    protected GridLayoutManager f17643n;

    /* renamed from: o  reason: collision with root package name */
    protected ae.d f17644o;

    /* compiled from: McuBaseWearableCardFragment.java */
    /* loaded from: classes2.dex */
    class a extends GridLayoutManager.c {
        a() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanSize(int i10) {
            return (d.this.f17633d.size() <= i10 || !d.this.f17633d.get(i10).isWatchFace) ? 1 : 2;
        }
    }

    private void e0() {
        if (!WearableUiUtils.isHealthChecked() && !WearableUiUtils.isHealthDataValid()) {
            k.a("McuBaseWearFrag", "check health data invalid!");
            WearableUiUtils.showHealthSettingDialog(getActivity(), null);
            WearableUiUtils.saveHealthChecked();
        }
    }

    @Override // com.mobvoi.companion.ui.a
    public int Y() {
        return f.f5825s;
    }

    @Override // com.mobvoi.companion.ui.a
    protected void Z(View view) {
        this.f17642m = (RecyclerView) view.findViewById(e.J);
        this.f17634e = (ImageView) view.findViewById(e.f5797r);
        this.f17635f = (TextView) view.findViewById(e.f5787m);
        view.findViewById(e.G);
        this.f17636g = (ImageView) view.findViewById(e.f5805y);
        this.f17637h = (TextView) view.findViewById(e.f5768c0);
        this.f17638i = (BatteryIconView) view.findViewById(e.f5765b);
        this.f17639j = (TextView) view.findViewById(e.f5767c);
        this.f17640k = view.findViewById(e.H);
        this.f17641l = (TextView) view.findViewById(e.f5792o0);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 2);
        this.f17643n = gridLayoutManager;
        this.f17642m.setLayoutManager(gridLayoutManager);
        this.f17642m.setAdapter(this.f17644o);
        this.f17643n.e3(new a());
    }

    public abstract pc.d c0();

    protected String d0() {
        WearInfo e10 = com.mobvoi.companion.wear.a.f().e();
        return e10 == null ? "" : e10.wearType;
    }

    protected void g0() {
    }

    public void h0() {
        final pc.d c02 = c0();
        if (c02 != null) {
            k.c("McuBaseWearFrag", "deviceData connetion status is: %s", Integer.valueOf(c02.j()));
            String h10 = c02.h();
            if (c02.j() == 3) {
                this.f17640k.setVisibility(0);
                this.f17640k.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.ui.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        d.this.d();
                    }
                });
            } else if (TextUtils.isEmpty(h10) || 1 == c02.j()) {
                this.f17640k.setVisibility(8);
            } else {
                this.f17640k.setVisibility(0);
            }
            if (!TextUtils.isEmpty(h10)) {
                this.f17641l.setText(h10);
            }
        }
    }

    @Override // com.mobvoi.companion.ui.a, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f17644o = new ae.d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getUserVisibleHint()) {
            e0();
        }
        h0();
        g0();
        b.a(d0(), getActivity());
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z10) {
        super.setUserVisibleHint(z10);
        k.a("McuBaseWearFrag", "setUserVisibleHint: " + z10);
        if (z10) {
            fg.f.b(com.mobvoi.android.common.utils.b.e());
            k.a("McuBaseWearFrag", "update device data: onPageSelected()" + d0());
            b.a(d0(), getActivity());
            return;
        }
        b.a("", getActivity());
    }
}
