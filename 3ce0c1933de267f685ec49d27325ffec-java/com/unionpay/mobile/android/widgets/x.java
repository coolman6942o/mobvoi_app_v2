package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.widget.ImageView;
import com.unionpay.mobile.android.widgets.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class x implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ u f24463a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(u uVar) {
        this.f24463a = uVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z10) {
        u.b bVar;
        u.a aVar;
        u.a aVar2;
        u.b bVar2;
        ImageView imageView;
        int i10;
        ImageView imageView2;
        ImageView imageView3;
        boolean b10 = u.b(this.f24463a);
        if (z10) {
            if (b10) {
                imageView3 = this.f24463a.f24450c;
                if (imageView3 != null) {
                    imageView = this.f24463a.f24450c;
                    i10 = 0;
                    imageView.setVisibility(i10);
                }
            }
        } else if (b10) {
            imageView2 = this.f24463a.f24450c;
            if (imageView2 != null) {
                imageView = this.f24463a.f24450c;
                i10 = 8;
                imageView.setVisibility(i10);
            }
        }
        bVar = this.f24463a.f24452e;
        if (bVar != null) {
            bVar2 = this.f24463a.f24452e;
            bVar2.a(z10);
        }
        aVar = this.f24463a.f24453f;
        if (aVar != null) {
            aVar2 = this.f24463a.f24453f;
            aVar2.a(z10);
        }
        this.f24463a.invalidate();
    }
}
