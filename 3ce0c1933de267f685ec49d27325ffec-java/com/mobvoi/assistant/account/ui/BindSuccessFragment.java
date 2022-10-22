package com.mobvoi.assistant.account.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.app.d;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.assistant.account.AccountHomeActivity;
import com.mobvoi.assistant.account.data.AccountManager;
import java.util.Arrays;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.n;
import pa.e;
import ra.h;
import rx.i;
import rx.j;
import sa.g;
import sa.l;
/* compiled from: BindSuccessFragment.kt */
/* loaded from: classes2.dex */
public final class BindSuccessFragment extends com.mobvoi.companion.base.m3.b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private dq.b f15672b;

    /* renamed from: c  reason: collision with root package name */
    private String f15673c;

    /* renamed from: d  reason: collision with root package name */
    private String f15674d;

    /* compiled from: BindSuccessFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: BindSuccessFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b extends i<g> {
        b() {
        }

        /* renamed from: b */
        public void onNext(g loginResponse) {
            kotlin.jvm.internal.i.f(loginResponse, "loginResponse");
            BindSuccessFragment.this.Y();
            if (loginResponse.b()) {
                ta.a.E(sa.a.a(loginResponse.result));
                AccountHomeActivity accountHomeActivity = (AccountHomeActivity) BindSuccessFragment.this.getActivity();
                kotlin.jvm.internal.i.d(accountHomeActivity);
                accountHomeActivity.H();
                AccountManager.h().l();
                androidx.fragment.app.f activity = BindSuccessFragment.this.getActivity();
                kotlin.jvm.internal.i.d(activity);
                activity.finish();
                return;
            }
            Toast.makeText(BindSuccessFragment.this.getActivity(), loginResponse.errorMsg, 0).show();
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable e10) {
            kotlin.jvm.internal.i.f(e10, "e");
            k.a("BindSuccessFragment", kotlin.jvm.internal.i.n("login fail: ", e10.getMessage()));
            BindSuccessFragment.this.Y();
            Toast.makeText(BindSuccessFragment.this.getActivity(), pa.i.K, 0).show();
        }
    }

    static {
        new a(null);
    }

    private final void b0(String str) {
        androidx.appcompat.app.a supportActionBar = ((d) requireActivity()).getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.z(str);
        }
    }

    private final void c0() {
        String string = getString(pa.i.D);
        kotlin.jvm.internal.i.e(string, "getString(R.string.logining)");
        Z(string);
        l lVar = new l();
        lVar.uid = this.f15674d;
        lVar.type = this.f15673c;
        ra.b b10 = h.b();
        ua.a a10 = h.a();
        j V = b10.g(lVar).Z(a10.b()).H(a10.a()).V(new b());
        dq.b bVar = this.f15672b;
        kotlin.jvm.internal.i.d(bVar);
        bVar.a(V);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v10) {
        kotlin.jvm.internal.i.f(v10, "v");
        if (v10.getId() == e.f32659r) {
            c0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f15672b = new dq.b();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.i.f(inflater, "inflater");
        return inflater.inflate(pa.f.f32680d, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        dq.b bVar = this.f15672b;
        kotlin.jvm.internal.i.d(bVar);
        bVar.unsubscribe();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.i.f(view, "view");
        super.onViewCreated(view, bundle);
        n nVar = n.f30086a;
        String string = getString(pa.i.f32704n);
        kotlin.jvm.internal.i.e(string, "getString(R.string.bind_account_title)");
        String format = String.format(string, Arrays.copyOf(new Object[]{""}, 1));
        kotlin.jvm.internal.i.e(format, "java.lang.String.format(format, *args)");
        b0(format);
        view.findViewById(e.f32659r).setOnClickListener(this);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            kotlin.jvm.internal.i.d(arguments);
            if (arguments.containsKey("extra_third_party_type")) {
                Bundle arguments2 = getArguments();
                kotlin.jvm.internal.i.d(arguments2);
                this.f15673c = arguments2.getString("extra_third_party_type");
            }
            Bundle arguments3 = getArguments();
            kotlin.jvm.internal.i.d(arguments3);
            if (arguments3.containsKey("extra_third_party_uid")) {
                Bundle arguments4 = getArguments();
                kotlin.jvm.internal.i.d(arguments4);
                this.f15674d = arguments4.getString("extra_third_party_uid");
            }
        }
    }
}
