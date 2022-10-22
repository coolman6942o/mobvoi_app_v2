package com.unionpay.mobile.android.pro.views;

import android.nfc.NfcAdapter;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.unionpay.mobile.android.widgets.ay;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class m implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f23951a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ k f23952b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, boolean z10) {
        this.f23952b = kVar;
        this.f23951a = z10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FrameLayout frameLayout;
        LinearLayout linearLayout;
        ay ayVar;
        ay ayVar2;
        NfcAdapter nfcAdapter;
        this.f23952b.i();
        if (this.f23951a) {
            this.f23952b.j();
            return;
        }
        this.f23952b.M = true;
        frameLayout = this.f23952b.S;
        frameLayout.removeAllViews();
        linearLayout = this.f23952b.A;
        linearLayout.removeAllViews();
        ayVar = this.f23952b.F;
        ayVar.setBackgroundColor(-16686660);
        ayVar2 = this.f23952b.F;
        ayVar2.a(0);
        this.f23952b.c();
        k kVar = this.f23952b;
        nfcAdapter = kVar.R;
        kVar.a(nfcAdapter);
    }
}
