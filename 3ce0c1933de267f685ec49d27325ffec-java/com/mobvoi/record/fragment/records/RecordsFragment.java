package com.mobvoi.record.fragment.records;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.h0;
import androidx.lifecycle.x;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.companion.proto.SoundProto;
import com.mobvoi.record.RecordViewModel;
import com.mobvoi.record.h;
import com.mobvoi.record.k;
import com.mobvoi.record.utils.c;
import java.util.ArrayList;
import java.util.List;
import qj.g;
import sj.c;
import sj.j;
import sm.f;
/* loaded from: classes2.dex */
public class RecordsFragment extends com.mobvoi.record.fragment.records.a {

    /* renamed from: f  reason: collision with root package name */
    private rj.e f20524f;

    /* renamed from: g  reason: collision with root package name */
    RecordViewModel f20525g;

    /* renamed from: h  reason: collision with root package name */
    ho.a<NavController> f20526h;

    /* renamed from: i  reason: collision with root package name */
    private g f20527i;

    /* renamed from: j  reason: collision with root package name */
    private com.mobvoi.record.utils.c f20528j;

    /* renamed from: k  reason: collision with root package name */
    private String f20529k;

    /* renamed from: l  reason: collision with root package name */
    private String f20530l;

    /* renamed from: m  reason: collision with root package name */
    private int f20531m;

    /* renamed from: n  reason: collision with root package name */
    private j f20532n;

    /* renamed from: o  reason: collision with root package name */
    private sj.c f20533o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends com.mobvoi.record.utils.c {

        /* renamed from: com.mobvoi.record.fragment.records.RecordsFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0238a implements c.e {
            C0238a() {
            }

            @Override // com.mobvoi.record.utils.c.e
            public void a(int i10) {
                RecordsFragment recordsFragment = RecordsFragment.this;
                recordsFragment.f20529k = recordsFragment.f20527i.i(i10).getFileId();
                if (RecordsFragment.this.f20533o != null) {
                    RecordsFragment.this.f20533o.show();
                }
            }
        }

        /* loaded from: classes2.dex */
        class b implements c.e {
            b() {
            }

            @Override // com.mobvoi.record.utils.c.e
            public void a(int i10) {
                RecordsFragment recordsFragment = RecordsFragment.this;
                recordsFragment.f20529k = recordsFragment.f20527i.i(i10).getFileId();
                if (RecordsFragment.this.f20532n != null) {
                    RecordsFragment.this.f20532n.show();
                    RecordsFragment.this.f20532n.j(RecordsFragment.this.f20527i.i(i10).getFileName());
                }
            }
        }

        a(Context context) {
            super(context);
        }

        @Override // com.mobvoi.record.utils.c
        public void l(RecyclerView.b0 b0Var, List<c.d> list) {
            list.add(new c.d(RecordsFragment.this.getString(k.f20659c), androidx.core.content.b.c(RecordsFragment.this.requireContext(), com.mobvoi.record.e.f20409f), new C0238a()));
            list.add(new c.d(RecordsFragment.this.getString(k.f20675s), androidx.core.content.b.c(RecordsFragment.this.requireContext(), com.mobvoi.record.e.f20404a), new b()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements g.b {
        b() {
        }

        @Override // qj.g.b
        public void a(SoundProto.SoundFile soundFile) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("soundFile", soundFile);
            RecordsFragment.this.f20526h.get().p(h.f20589f, bundle);
        }

        @Override // qj.g.b
        public void b(SoundProto.SoundFile soundFile) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("soundFile", soundFile);
            RecordsFragment.this.f20526h.get().p(h.f20586e, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements x<String> {
        c() {
        }

        /* renamed from: b */
        public void a(String str) {
            RecordsFragment.this.f20527i.n(RecordsFragment.this.f20529k, RecordsFragment.this.f20530l);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements x<String> {
        d() {
        }

        /* renamed from: b */
        public void a(String str) {
            RecordsFragment.this.f20527i.m(RecordsFragment.this.f20529k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements j.c {
        e() {
        }

        @Override // sj.j.c
        public void a(String str) {
            RecordsFragment recordsFragment = RecordsFragment.this;
            recordsFragment.f20525g.M(recordsFragment.f20529k, str);
            RecordsFragment.this.f20530l = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RecordsFragment recordsFragment = RecordsFragment.this;
            recordsFragment.f20525g.p(recordsFragment.f20529k);
        }
    }

    private void o0() {
        this.f20525g.C().i(getViewLifecycleOwner(), new x() { // from class: com.mobvoi.record.fragment.records.d
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                RecordsFragment.this.r0((List) obj);
            }
        });
        this.f20525g.E().i(getViewLifecycleOwner(), new c());
        this.f20525g.B().i(getViewLifecycleOwner(), new d());
    }

    private void p0() {
        j.b f10 = new j.b(requireActivity()).f(k.f20672p);
        int i10 = k.f20658b;
        j.b c10 = f10.c(i10);
        int i11 = k.f20657a;
        this.f20532n = c10.b(i11).e(new e()).a();
        this.f20533o = new c.b(requireActivity()).f(k.f20669m).d(k.f20668l).c(i10).b(i11).e(new f()).a();
    }

    private void q0() {
        this.f20524f.f33578f.setText(k.T);
        this.f20524f.f33577e.setNavigationIcon(com.mobvoi.record.g.f20564a);
        this.f20524f.f33577e.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.record.fragment.records.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecordsFragment.this.s0(view);
            }
        });
        this.f20531m = 1;
        this.f20524f.f33576d.J(new vm.g() { // from class: com.mobvoi.record.fragment.records.f
            @Override // vm.g
            public final void c(sm.f fVar) {
                RecordsFragment.this.t0(fVar);
            }
        });
        this.f20524f.f33576d.I(new vm.e() { // from class: com.mobvoi.record.fragment.records.e
            @Override // vm.e
            public final void a(f fVar) {
                RecordsFragment.this.u0(fVar);
            }
        });
        this.f20524f.f33574b.setVisibility(0);
        this.f20524f.f33574b.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.record.fragment.records.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecordsFragment.this.v0(view);
            }
        });
        this.f20524f.f33575c.setLayoutManager(new LinearLayoutManager(requireActivity()));
        androidx.recyclerview.widget.d dVar = new androidx.recyclerview.widget.d(requireActivity(), 1);
        Drawable e10 = androidx.core.content.b.e(requireActivity(), com.mobvoi.record.g.f20573j);
        if (e10 != null) {
            dVar.k(e10);
            this.f20524f.f33575c.h(dVar);
        }
        a aVar = new a(requireActivity());
        this.f20528j = aVar;
        aVar.j(this.f20524f.f33575c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(List list) {
        if (this.f20531m == 1) {
            g gVar = new g();
            this.f20527i = gVar;
            gVar.q(new ArrayList(list));
            this.f20524f.f33575c.setAdapter(this.f20527i);
            this.f20527i.r(new b());
        } else if (this.f20527i != null && list.size() > 0) {
            this.f20527i.f(list);
        }
        this.f20524f.f33576d.u();
        this.f20524f.f33576d.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(View view) {
        requireActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(sm.f fVar) {
        this.f20531m = 1;
        this.f20525g.D(1, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(sm.f fVar) {
        int i10 = this.f20531m + 1;
        this.f20531m = i10;
        this.f20525g.D(i10, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(View view) {
        this.f20526h.get().o(h.f20583d);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f20524f = rj.e.d(layoutInflater, viewGroup, false);
        this.f20525g = (RecordViewModel) new h0(this).a(RecordViewModel.class);
        p0();
        q0();
        o0();
        this.f20525g.D(this.f20531m, 10);
        return this.f20524f.a();
    }
}
