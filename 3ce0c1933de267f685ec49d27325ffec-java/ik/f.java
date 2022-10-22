package ik;

import ak.d;
import ak.e;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.c;
import com.bumptech.glide.g;
import com.mobvoi.android.common.ui.widget.BatteryIconView;
import com.mobvoi.ticcare.common.model.bean.TicCareDeviceInfo;
import com.mobvoi.ticcare.ui.TicCareSettingDeviceActivity;
import com.mobvoi.ticcare.ui.adapter.WearableHealthProView;
import com.mobvoi.ticcare.ui.adapter.WearableSportView;
import ik.f;
import java.util.ArrayList;
import java.util.List;
/* compiled from: TiccareDeviceAdapter.java */
/* loaded from: classes2.dex */
public class f extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    private List<TicCareDeviceInfo> f28315a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TiccareDeviceAdapter.java */
    /* loaded from: classes2.dex */
    public static class a extends RecyclerView.b0 {

        /* renamed from: a  reason: collision with root package name */
        ImageView f28316a;

        /* renamed from: b  reason: collision with root package name */
        TextView f28317b;

        /* renamed from: c  reason: collision with root package name */
        ImageView f28318c;

        /* renamed from: d  reason: collision with root package name */
        BatteryIconView f28319d;

        /* renamed from: e  reason: collision with root package name */
        TextView f28320e;

        /* renamed from: f  reason: collision with root package name */
        WearableHealthProView f28321f;

        /* renamed from: g  reason: collision with root package name */
        WearableSportView f28322g;

        public a(View view) {
            super(view);
            this.f28316a = (ImageView) view.findViewById(d.f226k);
            this.f28317b = (TextView) view.findViewById(d.f225h);
            this.f28318c = (ImageView) view.findViewById(d.g_res_0x7f0b0215);
            this.f28319d = (BatteryIconView) view.findViewById(d.f222a);
            this.f28320e = (TextView) view.findViewById(d.f223b);
            this.f28321f = (WearableHealthProView) view.findViewById(d.m_res_0x7f0b02e4);
            this.f28322g = (WearableSportView) view.findViewById(d.D_res_0x7f0b06a1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(a aVar, int i10, View view) {
        Intent intent = new Intent(aVar.itemView.getContext(), TicCareSettingDeviceActivity.class);
        intent.putExtra("extra.device_info", this.f28315a.get(i10));
        aVar.itemView.getContext().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(a aVar, View view) {
        aVar.f28321f.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(a aVar, View view) {
        aVar.f28322g.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f28315a.size();
    }

    /* renamed from: i */
    public void onBindViewHolder(final a aVar, final int i10) {
        TicCareDeviceInfo ticCareDeviceInfo = this.f28315a.get(i10);
        if (TextUtils.isEmpty(ticCareDeviceInfo.remarkName)) {
            aVar.f28317b.setText(ticCareDeviceInfo.deviceName);
        } else {
            aVar.f28317b.setText(ticCareDeviceInfo.remarkName + "(" + ticCareDeviceInfo.deviceName + ")");
        }
        aVar.f28320e.setVisibility(8);
        aVar.f28319d.setVisibility(8);
        aVar.f28318c.setOnClickListener(new View.OnClickListener() { // from class: ik.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.this.f(aVar, i10, view);
            }
        });
        aVar.f28321f.setTiccareDeviceInfo(ticCareDeviceInfo);
        aVar.f28322g.setTiccareDeviceInfo(ticCareDeviceInfo);
        aVar.f28321f.setOnClickListener(new View.OnClickListener() { // from class: ik.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.g(f.a.this, view);
            }
        });
        aVar.f28322g.setOnClickListener(new View.OnClickListener() { // from class: ik.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.h(f.a.this, view);
            }
        });
        g<Drawable> k02 = c.u(aVar.itemView.getContext()).r(ticCareDeviceInfo.headImgUrl).a(j5.c.j0(new a5.g()));
        int i11 = ak.c.f221b;
        k02.U(i11).j(i11).u0(aVar.f28316a);
    }

    /* renamed from: j */
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(e.n_res_0x7f0e0239, viewGroup, false));
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void k(List<TicCareDeviceInfo> list) {
        this.f28315a.clear();
        this.f28315a.addAll(list);
        notifyDataSetChanged();
    }
}
