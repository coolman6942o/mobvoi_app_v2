package com.mobvoi.record.fragment.convert;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.lifecycle.h0;
import androidx.lifecycle.x;
import androidx.navigation.NavController;
import com.mobvoi.companion.proto.AccountProto;
import com.mobvoi.companion.proto.SoundProto;
import com.mobvoi.record.RecordViewModel;
import com.mobvoi.record.fragment.pay.PayActivity;
/* loaded from: classes2.dex */
public class RecordConvertFragment extends com.mobvoi.record.fragment.convert.a {

    /* renamed from: f  reason: collision with root package name */
    private rj.c f20412f;

    /* renamed from: g  reason: collision with root package name */
    RecordViewModel f20413g;

    /* renamed from: h  reason: collision with root package name */
    ho.a<NavController> f20414h;

    /* renamed from: i  reason: collision with root package name */
    private SoundProto.SoundFile f20415i;

    /* renamed from: j  reason: collision with root package name */
    private String f20416j;

    /* renamed from: k  reason: collision with root package name */
    private int f20417k = 1;

    /* renamed from: l  reason: collision with root package name */
    private int f20418l = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RecordConvertFragment.this.f20412f.f33546k.setSelected(false);
            RecordConvertFragment.this.f20412f.f33545j.setSelected(false);
            RecordConvertFragment.this.f20412f.f33544i.setSelected(false);
            RecordConvertFragment.this.f20412f.f33543h.setSelected(true);
            RecordConvertFragment.this.f20418l = 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RecordConvertFragment recordConvertFragment = RecordConvertFragment.this;
            recordConvertFragment.f20413g.O(recordConvertFragment.f20415i.getFileId(), RecordConvertFragment.this.f20417k, RecordConvertFragment.this.f20418l, RecordConvertFragment.this.f20416j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RecordConvertFragment.this.startActivity(new Intent(RecordConvertFragment.this.getContext(), PayActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements AdapterView.OnItemSelectedListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            if (i10 == 0) {
                RecordConvertFragment.this.f20416j = "zh-CN";
                RecordConvertFragment.this.f20412f.f33539d.setVisibility(0);
                return;
            }
            RecordConvertFragment.this.f20416j = "en-US";
            RecordConvertFragment.this.f20412f.f33539d.setVisibility(8);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements x<AccountProto.SoundAccountResp> {
        e() {
        }

        /* renamed from: b */
        public void a(AccountProto.SoundAccountResp soundAccountResp) {
            RecordConvertFragment.this.f20412f.f33549n.setText(String.format(RecordConvertFragment.this.getString(com.mobvoi.record.k.f20663g), com.mobvoi.record.utils.d.a(soundAccountResp.getSoundAccount().getPaymentTime())));
            if (soundAccountResp.getSoundAccount().getPaymentTime() < RecordConvertFragment.this.f20415i.getDuration()) {
                RecordConvertFragment.this.f20412f.f33537b.setEnabled(false);
                RecordConvertFragment.this.f20412f.f33537b.setBackground(androidx.core.content.b.e(RecordConvertFragment.this.requireActivity(), com.mobvoi.record.g.f20570g));
                RecordConvertFragment.this.f20412f.f33547l.setVisibility(0);
                return;
            }
            RecordConvertFragment.this.f20412f.f33537b.setEnabled(true);
            RecordConvertFragment.this.f20412f.f33537b.setBackground(androidx.core.content.b.e(RecordConvertFragment.this.requireActivity(), com.mobvoi.record.g.f20569f));
            RecordConvertFragment.this.f20412f.f33547l.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements x<String> {
        f() {
        }

        /* renamed from: b */
        public void a(String str) {
            RecordConvertFragment.this.f20414h.get().o(com.mobvoi.record.h.f20577b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RecordConvertFragment.this.f20412f.f33551p.setSelected(true);
            RecordConvertFragment.this.f20412f.f33553r.setSelected(false);
            RecordConvertFragment.this.f20412f.f33552q.setSelected(false);
            RecordConvertFragment.this.f20412f.f33550o.setSelected(false);
            RecordConvertFragment.this.f20417k = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RecordConvertFragment.this.f20412f.f33551p.setSelected(false);
            RecordConvertFragment.this.f20412f.f33553r.setSelected(true);
            RecordConvertFragment.this.f20412f.f33552q.setSelected(false);
            RecordConvertFragment.this.f20412f.f33550o.setSelected(false);
            RecordConvertFragment.this.f20417k = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RecordConvertFragment.this.f20412f.f33551p.setSelected(false);
            RecordConvertFragment.this.f20412f.f33553r.setSelected(false);
            RecordConvertFragment.this.f20412f.f33552q.setSelected(true);
            RecordConvertFragment.this.f20412f.f33550o.setSelected(false);
            RecordConvertFragment.this.f20417k = 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RecordConvertFragment.this.f20412f.f33553r.setSelected(false);
            RecordConvertFragment.this.f20412f.f33551p.setSelected(false);
            RecordConvertFragment.this.f20412f.f33552q.setSelected(false);
            RecordConvertFragment.this.f20412f.f33550o.setSelected(true);
            RecordConvertFragment.this.f20417k = 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RecordConvertFragment.this.f20412f.f33544i.setSelected(true);
            RecordConvertFragment.this.f20412f.f33546k.setSelected(false);
            RecordConvertFragment.this.f20412f.f33545j.setSelected(false);
            RecordConvertFragment.this.f20412f.f33543h.setSelected(false);
            RecordConvertFragment.this.f20418l = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RecordConvertFragment.this.f20412f.f33546k.setSelected(true);
            RecordConvertFragment.this.f20412f.f33545j.setSelected(false);
            RecordConvertFragment.this.f20412f.f33544i.setSelected(false);
            RecordConvertFragment.this.f20412f.f33543h.setSelected(false);
            RecordConvertFragment.this.f20418l = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RecordConvertFragment.this.f20412f.f33546k.setSelected(false);
            RecordConvertFragment.this.f20412f.f33545j.setSelected(true);
            RecordConvertFragment.this.f20412f.f33544i.setSelected(false);
            RecordConvertFragment.this.f20412f.f33543h.setSelected(false);
            RecordConvertFragment.this.f20418l = 3;
        }
    }

    private void l0() {
        this.f20413g.r().i(requireActivity(), new e());
        this.f20413g.u().i(requireActivity(), new f());
    }

    private void m0() {
    }

    private void n0() {
        this.f20412f.f33554s.setText(com.mobvoi.record.k.f20664h);
        this.f20412f.f33540e.setNavigationIcon(com.mobvoi.record.g.f20564a);
        this.f20412f.f33540e.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.record.fragment.convert.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecordConvertFragment.this.o0(view);
            }
        });
        if (getArguments() != null) {
            SoundProto.SoundFile soundFile = (SoundProto.SoundFile) getArguments().getSerializable("soundFile");
            this.f20415i = soundFile;
            this.f20412f.f33542g.setText(soundFile.getFileName());
            this.f20412f.f33541f.setText(com.mobvoi.record.utils.d.a(this.f20415i.getDuration()));
            this.f20412f.f33548m.setText(String.format(getResources().getString(com.mobvoi.record.k.f20662f), com.mobvoi.record.utils.d.a(this.f20415i.getDuration())));
        }
        this.f20412f.f33551p.setOnClickListener(new g());
        this.f20412f.f33553r.setOnClickListener(new h());
        this.f20412f.f33552q.setOnClickListener(new i());
        this.f20412f.f33550o.setOnClickListener(new j());
        this.f20412f.f33544i.setOnClickListener(new k());
        this.f20412f.f33546k.setOnClickListener(new l());
        this.f20412f.f33545j.setOnClickListener(new m());
        this.f20412f.f33543h.setOnClickListener(new a());
        this.f20412f.f33537b.setOnClickListener(new b());
        this.f20412f.f33547l.setOnClickListener(new c());
        this.f20413g.q();
        if (com.mobvoi.companion.base.settings.a.isOversea()) {
            this.f20412f.f33538c.setSelection(1);
            this.f20416j = "en-US";
        } else {
            this.f20412f.f33538c.setSelection(0);
            this.f20416j = "zh-CN";
        }
        this.f20412f.f33538c.setOnItemSelectedListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(View view) {
        this.f20414h.get().u();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f20412f = rj.c.d(layoutInflater, viewGroup, false);
        this.f20413g = (RecordViewModel) new h0(this).a(RecordViewModel.class);
        if (getArguments() != null) {
            this.f20415i = (SoundProto.SoundFile) getArguments().getSerializable("soundFile");
        }
        m0();
        n0();
        l0();
        this.f20413g.q();
        return this.f20412f.a();
    }
}
