package com.mobvoi.mcuwatch.ui.menstrualcycle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import com.mobvoi.companion.base.m3.d;
import com.mobvoi.health.common.data.pojo.PeriodEvent;
import com.mobvoi.mcuwatch.ui.menstrualcycle.MenstrualSettingActivity;
import com.mobvoi.mcuwatch.ui.menstrualcycle.data.c;
import java.util.Date;
import jd.k;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import zh.i;
/* compiled from: MenstrualSettingActivity.kt */
/* loaded from: classes2.dex */
public final class MenstrualSettingActivity extends d {

    /* renamed from: i  reason: collision with root package name */
    public static final a f19771i = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final int f19772a = 5;

    /* renamed from: b  reason: collision with root package name */
    private final int f19773b = 28;

    /* renamed from: c  reason: collision with root package name */
    private final int f19774c = 1;

    /* renamed from: d  reason: collision with root package name */
    private long f19775d;

    /* renamed from: e  reason: collision with root package name */
    private int f19776e;

    /* renamed from: f  reason: collision with root package name */
    private int f19777f;

    /* renamed from: g  reason: collision with root package name */
    private i f19778g;

    /* renamed from: h  reason: collision with root package name */
    private final io.d f19779h;

    /* compiled from: MenstrualSettingActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void a(Context context) {
            kotlin.jvm.internal.i.f(context, "context");
            context.startActivity(new Intent(context, MenstrualSettingActivity.class));
        }
    }

    /* compiled from: MenstrualSettingActivity.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements qo.a<bj.a> {
        b() {
            super(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(MenstrualSettingActivity this$0, int i10, Object obj) {
            kotlin.jvm.internal.i.f(this$0, "this$0");
            if (i10 == 1) {
                this$0.a0(Integer.parseInt(obj.toString()));
            } else if (i10 == 2) {
                this$0.Y(Integer.parseInt(obj.toString()));
            }
        }

        /* renamed from: b */
        public final bj.a invoke() {
            bj.a aVar = new bj.a(1);
            final MenstrualSettingActivity menstrualSettingActivity = MenstrualSettingActivity.this;
            aVar.k(new k.a() { // from class: com.mobvoi.mcuwatch.ui.menstrualcycle.p
                @Override // jd.k.a
                public final void k(int i10, Object obj) {
                    MenstrualSettingActivity.b.c(MenstrualSettingActivity.this, i10, obj);
                }
            });
            return aVar;
        }
    }

    public MenstrualSettingActivity() {
        io.d a10;
        a10 = io.f.a(new b());
        this.f19779h = a10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(View view) {
        S().o(2);
        bj.a S = S();
        if (S != null) {
            S.l(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(View view) {
        CalendarActivity.f19745i.a(this, this.f19774c, Long.valueOf(this.f19775d));
    }

    private final String Q(long j10) {
        if (this.f19775d <= 0) {
            return "";
        }
        return DateFormat.format(getString(sh.k.f34787d0), new Date(j10)).toString();
    }

    private final bj.a S() {
        return (bj.a) this.f19779h.getValue();
    }

    private final void T() {
        Z(getIntent().getLongExtra("startDate", System.currentTimeMillis()));
        a0(getIntent().getIntExtra("menstruationLength", this.f19772a));
        Y(getIntent().getIntExtra("cycleLength", this.f19773b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(View view) {
        W();
        X();
        if (getIntent().getLongExtra("startDate", -1L) < 0) {
            MenstrualDetailsActivity.f19757j.a(this);
        } else {
            Intent intent = new Intent();
            intent.putExtra("startDate", this.f19775d);
            intent.putExtra("menstruationLength", this.f19776e);
            intent.putExtra("cycleLength", this.f19777f);
            setResult(3, intent);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(View view) {
        S().o(1);
        bj.a S = S();
        if (S != null) {
            S.l(this);
        }
    }

    private final void W() {
        aj.a aVar = aj.a.f215a;
        aVar.k(this.f19775d);
        aVar.i(this.f19776e);
        aVar.h(this.f19777f);
    }

    private final void X() {
        c.a aVar = c.f19788g;
        aVar.a(this).d(new nk.b(this.f19775d, PeriodEvent.PeriodStart));
        aVar.a(this).l(this.f19776e);
        aVar.a(this).k(this.f19777f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y(int i10) {
        if (i10 > 0) {
            this.f19777f = i10;
            i iVar = this.f19778g;
            if (iVar != null) {
                iVar.f37542c.setText(getString(sh.k.f34803g0, new Object[]{Integer.valueOf(i10)}));
            } else {
                kotlin.jvm.internal.i.u("binding");
                throw null;
            }
        }
    }

    private final void Z(long j10) {
        if (j10 > 0) {
            this.f19775d = j10;
            i iVar = this.f19778g;
            if (iVar != null) {
                iVar.f37543d.setText(Q(j10));
            } else {
                kotlin.jvm.internal.i.u("binding");
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(int i10) {
        if (i10 > 0) {
            this.f19776e = i10;
            i iVar = this.f19778g;
            if (iVar != null) {
                iVar.f37544e.setText(getString(sh.k.f34803g0, new Object[]{Integer.valueOf(i10)}));
            } else {
                kotlin.jvm.internal.i.u("binding");
                throw null;
            }
        }
    }

    private final void initView() {
        setTitle(sh.k.f34890x0);
        i iVar = this.f19778g;
        if (iVar != null) {
            iVar.f37546g.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.menstrualcycle.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MenstrualSettingActivity.this.O(view);
                }
            });
            i iVar2 = this.f19778g;
            if (iVar2 != null) {
                iVar2.f37547h.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.menstrualcycle.o
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MenstrualSettingActivity.this.V(view);
                    }
                });
                i iVar3 = this.f19778g;
                if (iVar3 != null) {
                    iVar3.f37545f.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.menstrualcycle.n
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            MenstrualSettingActivity.this.N(view);
                        }
                    });
                    i iVar4 = this.f19778g;
                    if (iVar4 != null) {
                        iVar4.f37541b.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.menstrualcycle.l
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                MenstrualSettingActivity.this.U(view);
                            }
                        });
                    } else {
                        kotlin.jvm.internal.i.u("binding");
                        throw null;
                    }
                } else {
                    kotlin.jvm.internal.i.u("binding");
                    throw null;
                }
            } else {
                kotlin.jvm.internal.i.u("binding");
                throw null;
            }
        } else {
            kotlin.jvm.internal.i.u("binding");
            throw null;
        }
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return sh.i.o_res_0x7f0e0042;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i11 == -1 && i10 == this.f19774c) {
            Long valueOf = intent == null ? null : Long.valueOf(intent.getLongExtra("monthDate", -1L));
            if (valueOf != null) {
                Z(valueOf.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        i b10 = i.b(getContentView().getChildAt(0));
        kotlin.jvm.internal.i.e(b10, "bind(contentView.getChildAt(0))");
        this.f19778g = b10;
        initView();
        T();
    }
}
