package kk;

import ak.d;
import ak.e;
import ak.g;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import jk.a;
/* compiled from: TicICareFragment.java */
/* loaded from: classes2.dex */
public class k extends a {

    /* renamed from: b  reason: collision with root package name */
    RecyclerView f30013b;

    /* renamed from: c  reason: collision with root package name */
    TextView f30014c;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(ik.a aVar, Pair pair) {
        if (((Boolean) pair.first).booleanValue()) {
            Object obj = pair.second;
            if (obj == null || ((List) obj).size() <= 0) {
                this.f30014c.setText(g.j_res_0x7f1405bd);
            } else {
                aVar.e((List) pair.second);
            }
        } else {
            this.f30014c.setText(g.j_res_0x7f1405bd);
        }
    }

    @Override // jk.a
    public int Y() {
        return e.h_res_0x7f0e0191;
    }

    @Override // jk.a
    public void Z() {
    }

    @Override // jk.a
    public void a0(View view) {
        this.f30013b = (RecyclerView) view.findViewById(d.t_res_0x7f0b0577);
        this.f30014c = (TextView) view.findViewById(d.N);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(), 1, false);
        final ik.a aVar = new ik.a();
        this.f30013b.setAdapter(aVar);
        this.f30013b.setLayoutManager(linearLayoutManager);
        this.f29645a.C().i(this, new x() { // from class: kk.j
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                k.this.c0(aVar, (Pair) obj);
            }
        });
        this.f29645a.c0();
    }
}
