package com.mobvoi.companion.aw.ui.quickcontrol;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.navigation.e;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.s;
import java.util.Map;
import kotlin.jvm.internal.i;
import od.d;
import pd.b;
/* compiled from: QuickControlFragment.kt */
/* loaded from: classes2.dex */
public final class QuickControlFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private b f16333a;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(QuickControlFragment this$0, View view) {
        i.f(this$0, "this$0");
        Map<String, e> f10 = NavHostFragment.Z(this$0).k().f();
        i.e(f10, "findNavController(this).graph.arguments");
        e eVar = f10.get("node_id_key");
        String str = null;
        Object a10 = eVar == null ? null : eVar.a();
        if (a10 instanceof String) {
            str = (String) a10;
        }
        if (str == null) {
            str = "";
        }
        s.b(this$0.requireView()).t(b.f16335a.a(str));
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        i.f(inflater, "inflater");
        b d10 = b.d(inflater, viewGroup, false);
        i.e(d10, "inflate(inflater, container, false)");
        this.f16333a = d10;
        if (d10 != null) {
            return d10.a();
        }
        i.u("binding");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.f(view, "view");
        super.onViewCreated(view, bundle);
        requireActivity().setTitle(getString(d.f31594x));
        b bVar = this.f16333a;
        if (bVar != null) {
            bVar.f32759b.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.aw.ui.quickcontrol.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QuickControlFragment.Z(QuickControlFragment.this, view2);
                }
            });
        } else {
            i.u("binding");
            throw null;
        }
    }
}
