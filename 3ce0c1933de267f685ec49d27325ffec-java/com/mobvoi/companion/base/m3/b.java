package com.mobvoi.companion.base.m3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.c;
import androidx.fragment.app.Fragment;
import gc.d;
import gc.e;
import kotlin.jvm.internal.i;
/* compiled from: BaseLoadingFragment.kt */
/* loaded from: classes2.dex */
public class b extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private c f16570a;

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Y() {
        c cVar = this.f16570a;
        if (cVar != null) {
            i.d(cVar);
            if (cVar.isShowing()) {
                c cVar2 = this.f16570a;
                i.d(cVar2);
                cVar2.dismiss();
                this.f16570a = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Z(String text) {
        i.f(text, "text");
        Y();
        View inflate = LayoutInflater.from(requireActivity()).inflate(e.f27357d, (ViewGroup) null);
        ((TextView) inflate.findViewById(d.f27345p)).setText(text);
        c a10 = new k7.b(requireActivity()).s(inflate).d(false).a();
        this.f16570a = a10;
        i.d(a10);
        a10.show();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Y();
    }
}
