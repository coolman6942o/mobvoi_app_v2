package com.mobvoi.ticcare.ui.adapter;

import ak.d;
import ak.g;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.Group;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.TicAppConstants;
import com.mobvoi.health.common.data.pojo.DataType;
import com.mobvoi.health.common.ui.view.ProgressView;
import com.mobvoi.ticcare.common.model.bean.TicCareDeviceInfo;
import com.mobvoi.ticcare.ui.adapter.WearableHealthProView;
import eg.c;
import fg.e;
import ig.b;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kh.n;
import kotlin.jvm.internal.i;
import pc.f;
/* compiled from: WearableHealthProView.kt */
/* loaded from: classes2.dex */
public final class WearableHealthProView extends FrameLayout implements e {

    /* renamed from: g  reason: collision with root package name */
    private boolean f20810g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f20811h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f20812i;

    /* renamed from: l  reason: collision with root package name */
    private TextView f20815l;

    /* renamed from: m  reason: collision with root package name */
    private Group f20816m;

    /* renamed from: n  reason: collision with root package name */
    private ProgressView f20817n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f20818o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f20819p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f20820q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f20821r;

    /* renamed from: a  reason: collision with root package name */
    private final String f20804a = "WearableHealthProView";

    /* renamed from: b  reason: collision with root package name */
    private int f20805b = 10000;

    /* renamed from: c  reason: collision with root package name */
    private int f20806c = 30;

    /* renamed from: d  reason: collision with root package name */
    private int f20807d = 10;

    /* renamed from: e  reason: collision with root package name */
    private String f20808e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f20809f = "";

    /* renamed from: j  reason: collision with root package name */
    private String f20813j = "";

    /* renamed from: k  reason: collision with root package name */
    private String f20814k = "";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WearableHealthProView(Context context, AttributeSet attrs) {
        super(context, attrs);
        i.f(context, "context");
        i.f(attrs, "attrs");
    }

    private final void d() {
        f.g().b(this);
    }

    private final void e() {
        b.J().m().post(new Runnable() { // from class: ik.h
            @Override // java.lang.Runnable
            public final void run() {
                WearableHealthProView.f(WearableHealthProView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final WearableHealthProView this$0) {
        i.f(this$0, "this$0");
        long b10 = c.b(System.currentTimeMillis());
        if (b10 > 0) {
            n nVar = new n();
            long j10 = b10 + 86400000;
            this$0.f20805b = eg.b.a(nVar.V(DataType.GoalTodayStep, 0L, j10), 10000);
            this$0.f20806c = eg.b.a(nVar.V(DataType.GoalTodayExercise, 0L, j10) / 60, 30);
            this$0.f20807d = eg.b.a(nVar.V(DataType.GoalTodayActive, 0L, j10), 10);
            b.J().j().post(new Runnable() { // from class: ik.g
                @Override // java.lang.Runnable
                public final void run() {
                    WearableHealthProView.g(WearableHealthProView.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(WearableHealthProView this$0) {
        i.f(this$0, "this$0");
        this$0.h();
    }

    private final void h() {
        f.g().l(this.f20808e, this.f20809f);
    }

    private final void i() {
        k.h(this.f20804a, i.n(" mWwid = ", this.f20808e));
        j(f.g().i(this.f20808e), f.g().k(this.f20808e), f.g().f(this.f20808e), f.g().d(this.f20808e));
    }

    private final void j(long j10, int i10, int i11, int i12) {
        float f10 = i10 / this.f20805b;
        float f11 = i11 / this.f20806c;
        float f12 = i12 / this.f20807d;
        ProgressView progressView = this.f20817n;
        if (progressView != null) {
            String str = "";
            progressView.g(0, f10, str);
            ProgressView progressView2 = this.f20817n;
            if (progressView2 != null) {
                progressView2.g(2, f12, str);
                ProgressView progressView3 = this.f20817n;
                if (progressView3 != null) {
                    progressView3.g(1, f11, str);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
                    if (j10 > 0) {
                        str = getContext().getString(g.f243n, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(j10))));
                    }
                    i.e(str, "if (time > 0) {\n            context.getString(\n                R.string.health_update_at,\n                format.format(Date(TimeUnit.SECONDS.toMillis(time)))\n            )\n        } else {\n            \"\"\n        }");
                    TextView textView = this.f20818o;
                    if (textView != null) {
                        textView.setText(str);
                        TextView textView2 = this.f20819p;
                        if (textView2 != null) {
                            textView2.setText(String.valueOf(i11));
                            TextView textView3 = this.f20820q;
                            if (textView3 != null) {
                                textView3.setText(String.valueOf(i12));
                                TextView textView4 = this.f20821r;
                                if (textView4 != null) {
                                    textView4.setText(String.valueOf(i10));
                                } else {
                                    i.u("tvStepNum");
                                    throw null;
                                }
                            } else {
                                i.u("tvActiveHour");
                                throw null;
                            }
                        } else {
                            i.u("tvActivityMinute");
                            throw null;
                        }
                    } else {
                        i.u("tvHealthUpdateDate");
                        throw null;
                    }
                } else {
                    i.u("progressView");
                    throw null;
                }
            } else {
                i.u("progressView");
                throw null;
            }
        } else {
            i.u("progressView");
            throw null;
        }
    }

    private final void k() {
        if (this.f20811h) {
            TextView textView = this.f20815l;
            if (textView != null) {
                textView.setVisibility(8);
                Group group = this.f20816m;
                if (group != null) {
                    group.setVisibility(0);
                    e();
                    return;
                }
                i.u("healthViewGroup");
                throw null;
            }
            i.u("tvNoShareData");
            throw null;
        }
        TextView textView2 = this.f20815l;
        if (textView2 != null) {
            textView2.setVisibility(0);
            Group group2 = this.f20816m;
            if (group2 != null) {
                group2.setVisibility(8);
            } else {
                i.u("healthViewGroup");
                throw null;
            }
        } else {
            i.u("tvNoShareData");
            throw null;
        }
    }

    public final void c() {
        if (!this.f20811h) {
            Toast.makeText(getContext(), g.f241l, 0).show();
            return;
        }
        com.mobvoi.health.companion.system.c.a().j(this.f20808e, this.f20809f, this.f20810g);
        Intent intent = new Intent("com.mobvoi.companion.action.CARE_HEALTH");
        intent.putExtra(TicAppConstants.CARE_REMARK_NAME, this.f20813j);
        intent.putExtra(TicAppConstants.CARE_DEVICE_NAME, this.f20814k);
        intent.putExtra(TicAppConstants.CARE_SHOW_SPORT_DATA, this.f20812i);
        intent.addFlags(268435456);
        intent.setPackage(getContext().getPackageName());
        getContext().startActivity(intent);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(getContext()).inflate(ak.e.k_res_0x7f0e0232, (ViewGroup) this, true);
        View findViewById = findViewById(d.K_res_0x7f0b07a9);
        i.e(findViewById, "findViewById(R.id.tvNoShareData)");
        this.f20815l = (TextView) findViewById;
        View findViewById2 = findViewById(d.l_res_0x7f0b02d9);
        i.e(findViewById2, "findViewById(R.id.healthViewGroup)");
        this.f20816m = (Group) findViewById2;
        View findViewById3 = findViewById(d.r_res_0x7f0b055e);
        i.e(findViewById3, "findViewById(R.id.progressView)");
        this.f20817n = (ProgressView) findViewById3;
        View findViewById4 = findViewById(d.J_res_0x7f0b07a7);
        i.e(findViewById4, "findViewById(R.id.tvHealthUpdateDate)");
        this.f20818o = (TextView) findViewById4;
        View findViewById5 = findViewById(d.I_res_0x7f0b0795);
        i.e(findViewById5, "findViewById(R.id.tvActivityMinute)");
        this.f20819p = (TextView) findViewById5;
        View findViewById6 = findViewById(d.H_res_0x7f0b0793);
        i.e(findViewById6, "findViewById(R.id.tvActiveHour)");
        this.f20820q = (TextView) findViewById6;
        View findViewById7 = findViewById(d.M_res_0x7f0b07b3);
        i.e(findViewById7, "findViewById(R.id.tvStepNum)");
        this.f20821r = (TextView) findViewById7;
        ProgressView progressView = this.f20817n;
        if (progressView != null) {
            progressView.g(0, 0.2f, "");
            ProgressView progressView2 = this.f20817n;
            if (progressView2 != null) {
                progressView2.g(2, 0.9999f, "");
                ProgressView progressView3 = this.f20817n;
                if (progressView3 != null) {
                    progressView3.g(1, 0.3f, "");
                    d();
                    return;
                }
                i.u("progressView");
                throw null;
            }
            i.u("progressView");
            throw null;
        }
        i.u("progressView");
        throw null;
    }

    @Override // fg.e
    public void setLoadingIndicator(boolean z10) {
        if (this.f20811h) {
            TextView textView = this.f20815l;
            if (textView != null) {
                textView.setVisibility(8);
                Group group = this.f20816m;
                if (group != null) {
                    group.setVisibility(0);
                    i();
                    return;
                }
                i.u("healthViewGroup");
                throw null;
            }
            i.u("tvNoShareData");
            throw null;
        }
    }

    public final void setTiccareDeviceInfo(TicCareDeviceInfo ticCareDeviceInfo) {
        i.f(ticCareDeviceInfo, "ticCareDeviceInfo");
        String str = ticCareDeviceInfo.wwid;
        i.e(str, "ticCareDeviceInfo.wwid");
        this.f20808e = str;
        String str2 = ticCareDeviceInfo.accountId;
        i.e(str2, "ticCareDeviceInfo.accountId");
        this.f20809f = str2;
        this.f20810g = true;
        this.f20811h = ticCareDeviceInfo.isShowHealthData;
        this.f20812i = ticCareDeviceInfo.isShowSportData;
        String str3 = ticCareDeviceInfo.remarkName;
        i.e(str3, "ticCareDeviceInfo.remarkName");
        this.f20813j = str3;
        String str4 = ticCareDeviceInfo.deviceName;
        i.e(str4, "ticCareDeviceInfo.deviceName");
        this.f20814k = str4;
        k();
    }
}
