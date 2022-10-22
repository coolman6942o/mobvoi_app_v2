package com.mobvoi.companion.profile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Toast;
import androidx.lifecycle.h0;
import androidx.lifecycle.x;
import ce.e;
import ce.f;
import com.bjleisen.iface.sdk.apdu.LeisenIfaceConfig;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.base.m3.d;
import com.mobvoi.companion.view.HealthDataBindView;
import com.mobvoi.health.common.data.pojo.DataType;
import com.unionpay.tsmservice.mi.data.Constant;
import eg.c;
import ig.b;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import jd.h;
import jd.k;
import sa.a;
/* loaded from: classes2.dex */
public class MainHealthInfoActivity extends d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private HealthDataBindView f17307a;

    /* renamed from: b  reason: collision with root package name */
    private HealthDataBindView f17308b;

    /* renamed from: c  reason: collision with root package name */
    private HealthDataBindView f17309c;

    /* renamed from: d  reason: collision with root package name */
    private HealthDataBindView f17310d;

    /* renamed from: e  reason: collision with root package name */
    private HealthDataBindView f17311e;

    /* renamed from: f  reason: collision with root package name */
    private HealthDataBindView f17312f;

    /* renamed from: g  reason: collision with root package name */
    private HealthDataBindView f17313g;

    /* renamed from: h  reason: collision with root package name */
    private HealthDataBindView f17314h;

    /* renamed from: i  reason: collision with root package name */
    private String f17315i;

    /* renamed from: j  reason: collision with root package name */
    private int f17316j = -1;

    /* renamed from: k  reason: collision with root package name */
    private long f17317k = -1;

    /* renamed from: l  reason: collision with root package name */
    private float f17318l = -1.0f;

    /* renamed from: m  reason: collision with root package name */
    private float f17319m = -1.0f;

    /* renamed from: n  reason: collision with root package name */
    private int f17320n = -1;

    /* renamed from: o  reason: collision with root package name */
    private int f17321o = -1;

    /* renamed from: p  reason: collision with root package name */
    private int f17322p = -1;

    /* renamed from: q  reason: collision with root package name */
    protected h f17323q;

    /* renamed from: r  reason: collision with root package name */
    protected h f17324r;

    /* renamed from: s  reason: collision with root package name */
    private a f17325s;

    private int N(long j10) {
        k.c("MainHealthInfoActivity", "timestamp:%d", Long.valueOf(j10));
        String d10 = eg.k.d(j10, LeisenIfaceConfig.CARD_DATE_FORMAT);
        int M = M(d10);
        k.c("MainHealthInfoActivity", "birthdayString:%s", d10);
        k.c("MainHealthInfoActivity", "age:%d", Integer.valueOf(M));
        return M;
    }

    private void O() {
        Date date;
        try {
            date = new SimpleDateFormat("yyyy.MM.dd", Locale.getDefault()).parse(this.f17325s.birthday);
        } catch (ParseException e10) {
            e10.printStackTrace();
            Calendar calendar = Calendar.getInstance();
            calendar.add(1, -21);
            date = calendar.getTime();
        }
        this.f17316j = this.f17325s.sex == 1 ? 0 : 1;
        this.f17317k = TimeUnit.MILLISECONDS.toSeconds(date.getTime());
        try {
            this.f17318l = Float.parseFloat(this.f17325s.height);
            this.f17319m = Float.parseFloat(this.f17325s.weight);
        } catch (NumberFormatException unused) {
            a aVar = this.f17325s;
            k.c("MainHealthInfoActivity", "height %s, weight %s", aVar.height, aVar.weight);
            this.f17318l = 170.0f;
            this.f17319m = 70.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(Pair pair) {
        hideLoading();
        k.h("MainHealthInfoActivity", " accountInfoPair.first = " + pair.first);
        if (((Boolean) pair.first).booleanValue()) {
            k.h("MainHealthInfoActivity", " accountInfoPair.second = " + pair.second);
            ta.a.E((a) pair.second);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(Boolean bool) {
        hideLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(int i10, Object obj) {
        String valueOf = String.valueOf(obj);
        switch (i10) {
            case 0:
                String n10 = ta.a.n();
                this.f17315i = n10;
                this.f17307a.c(0, n10);
                return;
            case 1:
                this.f17316j = Integer.parseInt(valueOf);
                Y();
                k.c("MainHealthInfoActivity", "性别是：%d", Integer.valueOf(this.f17316j));
                this.f17308b.c(1, obj);
                return;
            case 2:
                this.f17317k = Long.parseLong(valueOf);
                if (this.f17317k * 1000 >= c.a(System.currentTimeMillis()).getTimeInMillis()) {
                    Toast.makeText(this, getString(ce.h.W), 0).show();
                    return;
                }
                Y();
                k.c("MainHealthInfoActivity", "生日是：%d", Long.valueOf(this.f17317k));
                this.f17309c.c(2, obj);
                return;
            case 3:
                this.f17319m = Float.parseFloat(valueOf);
                Y();
                this.f17311e.c(3, obj);
                return;
            case 4:
                this.f17318l = Float.parseFloat(valueOf);
                Y();
                this.f17310d.c(4, obj);
                return;
            case 5:
                this.f17320n = Integer.parseInt(valueOf);
                this.f17312f.c(5, obj);
                k.c("MainHealthInfoActivity", "MainHealthActivity中更新步数了：%d", obj);
                Y();
                return;
            case 6:
                this.f17321o = Integer.parseInt(valueOf);
                this.f17313g.c(6, obj);
                return;
            case 7:
                this.f17322p = Integer.parseInt(valueOf);
                this.f17314h.c(7, obj);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W() {
        com.mobvoi.health.common.data.db.a z10 = b.J().z();
        qf.a D = z10.D(null, DataType.InfoGender);
        if (D != null) {
            this.f17316j = (int) D.e();
        } else {
            a0();
        }
        qf.a D2 = z10.D(null, DataType.InfoBirthday);
        if (D2 != null) {
            this.f17317k = D2.e();
        }
        qf.a D3 = z10.D(null, DataType.InfoHeight);
        if (D3 != null) {
            this.f17318l = D3.e();
        }
        qf.a D4 = z10.D(null, DataType.InfoWeight);
        if (D4 != null) {
            this.f17319m = D4.e();
        }
        qf.a D5 = z10.D(null, DataType.GoalTodayStep);
        if (D5 != null) {
            this.f17320n = (int) D5.e();
        }
        qf.a D6 = z10.D(null, DataType.GoalTodayExercise);
        if (D6 != null) {
            this.f17321o = (int) TimeUnit.SECONDS.toMinutes((int) D6.e());
        }
        qf.a D7 = z10.D(null, DataType.GoalTodayActive);
        if (D7 != null) {
            this.f17322p = (int) D7.e();
        }
        this.f17315i = this.f17325s.nickName;
        b.J().j().post(new Runnable() { // from class: com.mobvoi.companion.profile.k
            @Override // java.lang.Runnable
            public final void run() {
                MainHealthInfoActivity.this.V();
            }
        });
    }

    private void Y() {
        k.a("MainHealthInfoActivity", "MainHealthActivity发送广播");
        Intent intent = new Intent("com.mobvoi.ticpod.service.ACTION_UPDATE_USER_SETTING_GOAL");
        intent.putExtra("gender", this.f17316j);
        intent.putExtra(Constant.KEY_HEIGHT, (int) this.f17318l);
        intent.putExtra("weight", (int) this.f17319m);
        long j10 = this.f17317k * 1000;
        k.c("MainHealthInfoActivity", "birthdayTimestamp:%d", Long.valueOf(j10));
        intent.putExtra("age", N(j10));
        intent.putExtra("step_goal", this.f17320n);
        sendBroadcast(intent);
    }

    private void Z() {
        k.a("MainHealthInfoActivity", "MainHealthActivity发送广播 sendUpdateUnitMessage");
        Intent intent = new Intent("com.mobvoi.ticpod.service.ACTION_UPDATE_USER_SETTING_UNIT");
        intent.putExtra("distance_unit", !com.mobvoi.companion.base.settings.a.isUnitMetric(getApplication()) ? 2 : 1);
        sendBroadcast(intent);
    }

    private void a0() {
        b.J().n(DataType.InfoGender, this.f17316j);
        b.J().n(DataType.InfoBirthday, (float) this.f17317k);
        b.J().n(DataType.InfoHeight, this.f17318l);
        b.J().n(DataType.InfoWeight, this.f17319m);
        b.J().A();
        Y();
        Z();
    }

    @SuppressLint({"SimpleDateFormat"})
    public int M(String str) {
        try {
            long time = new SimpleDateFormat(LeisenIfaceConfig.CARD_DATE_FORMAT).parse(str.trim().replace("-", "").replace(" ", "").replace("_", "").replace("/", "").replace("\\", "").substring(0, 8)).getTime();
            long time2 = new Date().getTime();
            if (time2 > time) {
                return (int) ((((((time2 - time) / 1000) / 60) / 60) / 24) / 365);
            }
            return 0;
        } catch (ParseException e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    protected void Q() {
        this.f17324r.d().i(this, new x() { // from class: com.mobvoi.companion.profile.i
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                MainHealthInfoActivity.this.S((Pair) obj);
            }
        });
        this.f17324r.e().i(this, new x() { // from class: com.mobvoi.companion.profile.j
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                MainHealthInfoActivity.this.T((Boolean) obj);
            }
        });
        this.f17324r.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: X */
    public void V() {
        this.f17307a.c(0, this.f17315i);
        this.f17308b.c(1, Integer.valueOf(this.f17316j));
        this.f17309c.c(2, Long.valueOf(this.f17317k));
        this.f17310d.c(4, Float.valueOf(this.f17318l));
        this.f17311e.c(3, Float.valueOf(this.f17319m));
        this.f17312f.c(5, Integer.valueOf(this.f17320n));
        this.f17313g.c(6, Integer.valueOf(this.f17321o));
        this.f17314h.c(7, Integer.valueOf(this.f17322p));
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return f.f5808b;
    }

    protected void initView() {
        setTitle(ce.h.f5834a);
        HealthDataBindView healthDataBindView = (HealthDataBindView) findViewById(e.P);
        this.f17307a = healthDataBindView;
        healthDataBindView.b(this);
        this.f17307a.c(0, this.f17315i);
        HealthDataBindView healthDataBindView2 = (HealthDataBindView) findViewById(e.f5795q);
        this.f17308b = healthDataBindView2;
        healthDataBindView2.b(this);
        this.f17308b.c(1, Integer.valueOf(this.f17316j));
        HealthDataBindView healthDataBindView3 = (HealthDataBindView) findViewById(e.f5771e);
        this.f17309c = healthDataBindView3;
        healthDataBindView3.b(this);
        this.f17309c.c(2, Long.valueOf(this.f17317k));
        HealthDataBindView healthDataBindView4 = (HealthDataBindView) findViewById(e.f5802v);
        this.f17310d = healthDataBindView4;
        healthDataBindView4.b(this);
        this.f17310d.c(4, Float.valueOf(this.f17318l));
        HealthDataBindView healthDataBindView5 = (HealthDataBindView) findViewById(e.f5794p0);
        this.f17311e = healthDataBindView5;
        healthDataBindView5.b(this);
        this.f17311e.c(3, Float.valueOf(this.f17319m));
        HealthDataBindView healthDataBindView6 = (HealthDataBindView) findViewById(e.f5766b0);
        this.f17312f = healthDataBindView6;
        healthDataBindView6.b(this);
        this.f17312f.c(5, Integer.valueOf(this.f17320n));
        HealthDataBindView healthDataBindView7 = (HealthDataBindView) findViewById(e.f5791o);
        this.f17313g = healthDataBindView7;
        healthDataBindView7.b(this);
        this.f17313g.c(6, Integer.valueOf(this.f17321o));
        HealthDataBindView healthDataBindView8 = (HealthDataBindView) findViewById(e.f5763a);
        this.f17314h = healthDataBindView8;
        healthDataBindView8.b(this);
        this.f17314h.c(7, Integer.valueOf(this.f17322p));
        h hVar = (h) new h0(this).a(h.class);
        this.f17324r = hVar;
        this.f17323q = new jd.d(this, hVar, new k.a() { // from class: com.mobvoi.companion.profile.m
            @Override // jd.k.a
            public final void k(int i10, Object obj) {
                MainHealthInfoActivity.this.U(i10, obj);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == e.P) {
            this.f17323q.a(this.f17315i);
        } else if (id2 == e.f5795q) {
            this.f17323q.h(this.f17316j);
        } else if (id2 == e.f5771e) {
            this.f17323q.c(this.f17317k);
        } else if (id2 == e.f5802v) {
            this.f17323q.d(this.f17318l);
        } else if (id2 == e.f5794p0) {
            this.f17323q.k(this.f17319m);
        } else if (id2 == e.f5766b0) {
            this.f17323q.b(this.f17320n);
        } else if (id2 == e.f5763a) {
            this.f17323q.f(this.f17322p);
        } else if (id2 == e.f5791o) {
            this.f17323q.i(this.f17321o);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f17325s = ta.a.e();
        initView();
        Q();
        O();
        b.J().m().post(new Runnable() { // from class: com.mobvoi.companion.profile.l
            @Override // java.lang.Runnable
            public final void run() {
                MainHealthInfoActivity.this.W();
            }
        });
    }
}
