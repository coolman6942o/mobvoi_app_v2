package com.mobvoi.record.fragment.redeem;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.h0;
import androidx.lifecycle.x;
import androidx.navigation.NavController;
import com.mobvoi.companion.proto.AccountProto;
import com.mobvoi.record.RecordViewModel;
import com.mobvoi.record.g;
import com.mobvoi.record.k;
import rj.f;
/* loaded from: classes2.dex */
public class RedeemCodeFragment extends com.mobvoi.record.fragment.redeem.a {

    /* renamed from: f  reason: collision with root package name */
    private f f20552f;

    /* renamed from: g  reason: collision with root package name */
    RecordViewModel f20553g;

    /* renamed from: h  reason: collision with root package name */
    ho.a<NavController> f20554h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements x<AccountProto.SoundAccountResp> {
        a() {
        }

        /* renamed from: b */
        public void a(AccountProto.SoundAccountResp soundAccountResp) {
            if (soundAccountResp.getErrCode() == 0) {
                RedeemCodeFragment.this.f20552f.f33582d.f33604b.setVisibility(0);
            } else {
                RedeemCodeFragment.this.f20552f.f33585g.setText(soundAccountResp.getErrMsg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RedeemCodeFragment redeemCodeFragment = RedeemCodeFragment.this;
            redeemCodeFragment.f20553g.o(redeemCodeFragment.f20552f.f33581c.getText().toString().trim());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            RedeemCodeFragment.this.f20552f.f33585g.setText("");
        }
    }

    private void e0() {
        this.f20553g.r().i(requireActivity(), new a());
    }

    private void f0() {
        this.f20552f.f33586h.setText(k.L);
        this.f20552f.f33583e.setNavigationIcon(g.f20564a);
        this.f20552f.f33583e.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.record.fragment.redeem.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RedeemCodeFragment.this.g0(view);
            }
        });
        this.f20552f.f33584f.setText(getString(k.K, ta.a.e().phoneNumber));
        this.f20552f.f33580b.setOnClickListener(new b());
        this.f20552f.f33581c.addTextChangedListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(View view) {
        this.f20554h.get().u();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f20552f = f.d(layoutInflater, viewGroup, false);
        this.f20553g = (RecordViewModel) new h0(this).a(RecordViewModel.class);
        f0();
        e0();
        return this.f20552f.a();
    }
}
