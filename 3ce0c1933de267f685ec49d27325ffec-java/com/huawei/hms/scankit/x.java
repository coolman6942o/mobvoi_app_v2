package com.huawei.hms.scankit;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IRemoteViewDelegateImpl.java */
/* loaded from: classes2.dex */
public class x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f15083a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(y yVar) {
        this.f15083a = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        if (view.isSelected()) {
            this.f15083a.g();
            this.f15083a.m();
            imageView3 = this.f15083a.A;
            imageView4 = this.f15083a.A;
            imageView3.setContentDescription(imageView4.getResources().getString(R.string.scankit_light));
            return;
        }
        this.f15083a.h();
        view.setSelected(true);
        textView = this.f15083a.B;
        int i10 = R.string.scankit_light_off;
        textView.setText(i10);
        imageView = this.f15083a.A;
        imageView2 = this.f15083a.A;
        imageView.setContentDescription(imageView2.getResources().getString(i10));
    }
}
