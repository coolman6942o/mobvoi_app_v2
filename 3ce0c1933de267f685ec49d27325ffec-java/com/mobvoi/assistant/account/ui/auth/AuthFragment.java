package com.mobvoi.assistant.account.ui.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mobvoi.assistant.account.AccountHomeActivity;
import com.mobvoi.companion.base.m3.b;
import hb.a;
import hb.c;
import kotlin.jvm.internal.i;
import pa.f;
/* compiled from: AuthFragment.kt */
/* loaded from: classes2.dex */
public final class AuthFragment extends b implements c {

    /* renamed from: b  reason: collision with root package name */
    private AccountHomeActivity f15686b;

    /* renamed from: c  reason: collision with root package name */
    private hb.b f15687c;

    @Override // hb.c
    public void C() {
        AccountHomeActivity accountHomeActivity = this.f15686b;
        i.d(accountHomeActivity);
        accountHomeActivity.finish();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        hb.b bVar = this.f15687c;
        if (bVar != null) {
            bVar.a(i10, i11, intent);
            String string = getString(pa.i.f32705o);
            i.e(string, "getString(R.string.bind_third_party_bing)");
            Z(string);
            return;
        }
        i.u("mLoginPresenter");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        i.f(context, "context");
        super.onAttach(context);
        if (context instanceof AccountHomeActivity) {
            this.f15686b = (AccountHomeActivity) context;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        i.f(inflater, "inflater");
        return inflater.inflate(f.f32679c, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        hb.b bVar = this.f15687c;
        if (bVar != null) {
            bVar.unsubscribe();
        } else {
            i.u("mLoginPresenter");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.f(view, "view");
        super.onViewCreated(view, bundle);
        a aVar = new a(this, this);
        this.f15687c = aVar;
        aVar.c("qq");
    }
}
