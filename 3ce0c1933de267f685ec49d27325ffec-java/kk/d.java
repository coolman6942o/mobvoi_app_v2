package kk;

import ak.e;
import ak.g;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.ticcare.common.model.bean.TicCareDeviceInfo;
import ik.b;
import java.util.List;
/* compiled from: TicCareMeFragment.java */
/* loaded from: classes2.dex */
public class d extends jk.a {

    /* renamed from: b  reason: collision with root package name */
    RecyclerView f30002b;

    /* renamed from: c  reason: collision with root package name */
    TextView f30003c;

    /* compiled from: TicCareMeFragment.java */
    /* loaded from: classes2.dex */
    class a implements b.AbstractC0317b {
        a() {
        }

        @Override // ik.b.AbstractC0317b
        public void a() {
            d.this.f30003c.setText(g.i_res_0x7f1405bb);
        }

        @Override // ik.b.AbstractC0317b
        public void b(TicCareDeviceInfo ticCareDeviceInfo) {
            ((jk.a) d.this).f29645a.v(ticCareDeviceInfo.wwid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(b bVar, Pair pair) {
        if (((Boolean) pair.first).booleanValue()) {
            Object obj = pair.second;
            if (obj == null || ((List) obj).size() <= 0) {
                this.f30003c.setText(g.i_res_0x7f1405bb);
            } else {
                bVar.g((List) pair.second);
            }
        } else {
            this.f30003c.setText(g.i_res_0x7f1405bb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f0(b bVar, Pair pair) {
        if (((Boolean) pair.first).booleanValue() && !TextUtils.isEmpty((CharSequence) pair.second)) {
            bVar.d((String) pair.second);
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
        this.f30002b = (RecyclerView) view.findViewById(ak.d.t_res_0x7f0b0577);
        this.f30003c = (TextView) view.findViewById(ak.d.N);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(), 1, false);
        final b bVar = new b();
        this.f30002b.setAdapter(bVar);
        this.f30002b.setLayoutManager(linearLayoutManager);
        this.f29645a.z().i(this, new x() { // from class: kk.c
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                d.this.e0(bVar, (Pair) obj);
            }
        });
        this.f29645a.A().i(this, new x() { // from class: kk.b
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                d.f0(ik.b.this, (Pair) obj);
            }
        });
        this.f29645a.a0();
        bVar.h(new a());
    }
}
