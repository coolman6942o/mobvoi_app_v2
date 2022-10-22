package zg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.c;
import fg.s;
import fg.t;
/* compiled from: HealthNoHeartRateValueTipsDialog.java */
/* loaded from: classes2.dex */
public class b extends c {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(View view) {
        b0();
    }

    public static void s0(FragmentManager fragmentManager) {
        new b().p0(fragmentManager, "fragment_heartrate_no_value");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(t.f26832f, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.findViewById(s.L).setOnClickListener(new View.OnClickListener() { // from class: zg.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b.this.r0(view2);
            }
        });
    }
}
