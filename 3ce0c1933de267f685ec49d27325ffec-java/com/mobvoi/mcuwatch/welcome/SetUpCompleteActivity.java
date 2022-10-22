package com.mobvoi.mcuwatch.welcome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import com.mobvoi.companion.setting.CompanionSetting;
import com.mobvoi.mcuwatch.ui.arty.ArtyCenterActivity;
import com.mobvoi.mcuwatch.ui.learnmore.LearnMoreActivity;
import java.util.Objects;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import qo.l;
import sh.h;
import wi.d;
import zh.k;
/* compiled from: SetUpCompleteActivity.kt */
/* loaded from: classes2.dex */
public final class SetUpCompleteActivity extends d<k> implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public static final b f20282e = new b(null);

    /* renamed from: d  reason: collision with root package name */
    private final io.d f20283d;

    /* compiled from: SetUpCompleteActivity.kt */
    /* loaded from: classes2.dex */
    /* synthetic */ class a extends FunctionReferenceImpl implements l<LayoutInflater, k> {
        public static final a INSTANCE = new a();

        a() {
            super(1, k.class, "inflate", "inflate(Landroid/view/LayoutInflater;)Lcom/mobvoi/mcuwatch/databinding/ActivitySetUpCompleteBinding;", 0);
        }

        /* renamed from: g */
        public final k invoke(LayoutInflater p02) {
            i.f(p02, "p0");
            return k.d(p02);
        }
    }

    /* compiled from: SetUpCompleteActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }

        public final void a(Context context) {
            i.f(context, "context");
            context.startActivity(new Intent(context, SetUpCompleteActivity.class));
        }
    }

    /* compiled from: SetUpCompleteActivity.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements qo.a<SetUpCompleteActivity> {
        c() {
            super(0);
        }

        /* renamed from: a */
        public final SetUpCompleteActivity invoke() {
            return SetUpCompleteActivity.this;
        }
    }

    public SetUpCompleteActivity() {
        super(a.INSTANCE);
        io.d a10;
        a10 = io.f.a(new c());
        this.f20283d = a10;
    }

    private final SetUpCompleteActivity S() {
        return (SetUpCompleteActivity) this.f20283d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(SetUpCompleteActivity this$0) {
        i.f(this$0, "this$0");
        int height = (this$0.H().f37553d.getHeight() - this$0.H().f37555f.getHeight()) - aa.d.a(24.0f);
        ViewGroup.LayoutParams layoutParams = this$0.H().f37554e.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.height = height;
        marginLayoutParams.width = (int) (height * 0.7183908f);
        marginLayoutParams.topMargin = aa.d.a(24.0f);
        this$0.H().f37554e.setLayoutParams(marginLayoutParams);
    }

    @Override // wi.d
    protected boolean J() {
        return true;
    }

    public final void T() {
    }

    public final void U() {
        b1.a.b(this).d(new Intent("action.UPDATE_MCU_WATCH_DATA"));
        CompanionSetting.setArtyGuidePageShowFinish(true);
    }

    public final void V() {
        H().f37553d.post(new Runnable() { // from class: com.mobvoi.mcuwatch.welcome.c
            @Override // java.lang.Runnable
            public final void run() {
                SetUpCompleteActivity.W(SetUpCompleteActivity.this);
            }
        });
        H().f37554e.setImageResource(sh.f.f34563l0);
        H().f37555f.setText(i0.b.a(getResources().getString(sh.k.f34881v2), 0));
        H().f37552c.setOnClickListener(this);
        H().f37551b.setOnClickListener(this);
    }

    public final void initView() {
        Toolbar toolbar = (Toolbar) findViewById(h.I0);
        toolbar.setNavigationIcon(sh.f.f34586t);
        setSupportActionBar(toolbar);
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.t(true);
            supportActionBar.u(false);
        }
        V();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        int i10 = h.f34610a0;
        if (valueOf != null && valueOf.intValue() == i10) {
            startActivity(new Intent(S(), ArtyCenterActivity.class));
            U();
            finish();
            return;
        }
        int i11 = h.Z;
        if (valueOf != null && valueOf.intValue() == i11) {
            LearnMoreActivity.f19722d.a(S());
            U();
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // wi.d, com.mobvoi.companion.base.m3.a, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        T();
        initView();
    }
}
