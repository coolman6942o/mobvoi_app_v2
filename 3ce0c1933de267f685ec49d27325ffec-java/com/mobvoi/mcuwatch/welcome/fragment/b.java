package com.mobvoi.mcuwatch.welcome.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.h0;
import com.mobvoi.companion.profile.h;
import com.mobvoi.mcuwatch.welcome.InitialQuestionsActivity;
import com.mobvoi.wear.companion.setup.settings.SettingConstants;
import eg.c;
import io.d;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import jd.k;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.u;
import zh.o;
/* compiled from: QuestionBirthdayFragment.kt */
/* loaded from: classes2.dex */
public final class b extends com.mobvoi.mcuwatch.welcome.fragment.a implements View.OnClickListener, k.a {

    /* renamed from: g  reason: collision with root package name */
    public static final a f20293g = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private o f20294b;

    /* renamed from: c  reason: collision with root package name */
    private final d f20295c;

    /* renamed from: d  reason: collision with root package name */
    private k<Long> f20296d;

    /* renamed from: e  reason: collision with root package name */
    private h f20297e;

    /* renamed from: f  reason: collision with root package name */
    private long f20298f;

    /* compiled from: QuestionBirthdayFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final b a() {
            b bVar = new b();
            bVar.setArguments(new Bundle());
            return bVar;
        }
    }

    /* compiled from: QuestionBirthdayFragment.kt */
    /* renamed from: com.mobvoi.mcuwatch.welcome.fragment.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0233b extends Lambda implements qo.a<b> {
        C0233b() {
            super(0);
        }

        /* renamed from: a */
        public final b invoke() {
            return b.this;
        }
    }

    public b() {
        d a10;
        a10 = io.f.a(new C0233b());
        this.f20295c = a10;
    }

    private final long b0(List<String> list) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, Integer.parseInt(list.get(0)));
        calendar.set(2, Integer.parseInt(list.get(1)) - 1);
        calendar.set(5, Integer.parseInt(list.get(2)));
        return TimeUnit.MILLISECONDS.toSeconds(calendar.getTimeInMillis());
    }

    private final String c0(String str) {
        return str.length() == 1 ? i.n("0", str) : str;
    }

    private final o d0() {
        o oVar = this.f20294b;
        i.d(oVar);
        return oVar;
    }

    private final b e0() {
        return (b) this.f20295c.getValue();
    }

    private final void f0() {
        List<String> o02;
        InitialQuestionsActivity Y = Y();
        if (Y != null && !TextUtils.isEmpty(Y.V())) {
            o02 = u.o0(Y.V(), new String[]{"."}, false, 0, 6, null);
            if (o02.size() > 2) {
                this.f20298f = b0(o02);
                e0().d0().f37577f.setText(o02.get(0));
                e0().d0().f37576e.setText(c0(o02.get(1)));
                e0().d0().f37575d.setText(c0(o02.get(2)));
            }
        }
    }

    @Override // jd.k.a
    public void k(int i10, Object obj) {
        List o02;
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Long");
        Long l10 = (Long) obj;
        this.f20298f = l10.longValue();
        String str = eg.k.d(l10.longValue() * 1000, SettingConstants.DATE_FORMAT_DEFAULT);
        i.e(str, "str");
        o02 = u.o0(str, new String[]{"-"}, false, 0, 6, null);
        d0().f37577f.setText((CharSequence) o02.get(0));
        d0().f37576e.setText((CharSequence) o02.get(1));
        d0().f37575d.setText((CharSequence) o02.get(2));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CharSequence E0;
        CharSequence E02;
        CharSequence E03;
        CharSequence E04;
        CharSequence E05;
        CharSequence E06;
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        int i10 = sh.h.o0_res_0x7f0b014d;
        if (valueOf != null && valueOf.intValue() == i10) {
            k<Long> kVar = this.f20296d;
            Objects.requireNonNull(kVar, "null cannot be cast to non-null type com.mobvoi.companion.profile.changer.birthday.BirthdayQuestionChanger");
            ((kd.b) kVar).l(getActivity());
            return;
        }
        int i11 = sh.h.f34610a0;
        if (valueOf != null && valueOf.intValue() == i11) {
            Editable text = d0().f37576e.getText();
            i.e(text, "binding.mmEt.text");
            E0 = u.E0(text);
            boolean z10 = true;
            if (E0.toString().length() > 0) {
                Editable text2 = d0().f37575d.getText();
                i.e(text2, "binding.ddEt.text");
                E02 = u.E0(text2);
                if (E02.toString().length() > 0) {
                    Editable text3 = d0().f37577f.getText();
                    i.e(text3, "binding.yyEt.text");
                    E03 = u.E0(text3);
                    if (E03.toString().length() <= 0) {
                        z10 = false;
                    }
                    if (z10) {
                        if (this.f20298f * 1000 >= c.a(System.currentTimeMillis()).getTimeInMillis()) {
                            a0(sh.k.f34810h2);
                            return;
                        }
                        InitialQuestionsActivity Y = Y();
                        if (Y != null) {
                            Editable text4 = e0().d0().f37576e.getText();
                            i.e(text4, "instance.binding.mmEt.text");
                            E04 = u.E0(text4);
                            String obj = E04.toString();
                            Editable text5 = e0().d0().f37575d.getText();
                            i.e(text5, "instance.binding.ddEt.text");
                            E05 = u.E0(text5);
                            String obj2 = E05.toString();
                            Editable text6 = e0().d0().f37577f.getText();
                            i.e(text6, "instance.binding.yyEt.text");
                            E06 = u.E0(text6);
                            Y.m0(E06.toString() + '.' + obj + '.' + obj2);
                            Y.l0(this.f20298f);
                            Y.T(3);
                            return;
                        }
                        return;
                    }
                }
            }
            a0(sh.k.f34777b2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        i.f(inflater, "inflater");
        this.f20294b = o.d(inflater, viewGroup, false);
        ConstraintLayout c10 = d0().a();
        i.e(c10, "binding.root");
        return c10;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f20294b = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.f(view, "view");
        super.onViewCreated(view, bundle);
        f0();
        d0().f37574c.setOnClickListener(this);
        d0().f37573b.setOnClickListener(this);
        h hVar = (h) new h0(this).a(h.class);
        this.f20297e = hVar;
        kd.b bVar = new kd.b(hVar, this.f20298f);
        this.f20296d = bVar;
        Objects.requireNonNull(bVar, "null cannot be cast to non-null type com.mobvoi.companion.profile.changer.birthday.BirthdayQuestionChanger");
        bVar.k(e0());
    }
}
