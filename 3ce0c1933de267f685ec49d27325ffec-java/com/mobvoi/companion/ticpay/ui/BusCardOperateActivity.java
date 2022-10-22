package com.mobvoi.companion.ticpay.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import cn.com.fmsh.tsm.business.exception.BusinessException;
import com.bjleisen.iface.sdk.bean.Applet;
import com.bjleisen.iface.sdk.bean.resp.PayOrderStatusBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.RespInfo;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.s;
import com.mobvoi.companion.ticpay.buscard.CardInfo;
import com.mobvoi.companion.view.RoundProgressBar;
import com.unionpay.tsmservice.data.Constant;
import java.util.HashMap;
import qd.e;
import qd.f;
import qd.i;
import qd.j;
import qd.m;
/* loaded from: classes2.dex */
public class BusCardOperateActivity extends com.mobvoi.companion.ticpay.ui.c implements View.OnClickListener {
    private boolean A;
    private ObjectAnimator B;
    private ObjectAnimator C;
    private s D = new s(this);

    /* renamed from: e  reason: collision with root package name */
    private ImageView f17455e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f17456f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f17457g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f17458h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f17459i;

    /* renamed from: j  reason: collision with root package name */
    private Button f17460j;

    /* renamed from: k  reason: collision with root package name */
    private Button f17461k;

    /* renamed from: l  reason: collision with root package name */
    private Button f17462l;

    /* renamed from: m  reason: collision with root package name */
    private RoundProgressBar f17463m;

    /* renamed from: n  reason: collision with root package name */
    private ImageView f17464n;

    /* renamed from: o  reason: collision with root package name */
    private String f17465o;

    /* renamed from: p  reason: collision with root package name */
    private long f17466p;

    /* renamed from: q  reason: collision with root package name */
    private ud.a f17467q;

    /* renamed from: r  reason: collision with root package name */
    private int f17468r;

    /* renamed from: s  reason: collision with root package name */
    private int f17469s;

    /* renamed from: t  reason: collision with root package name */
    private int f17470t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f17471u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f17472v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f17473w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f17474x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f17475y;

    /* renamed from: z  reason: collision with root package name */
    private long f17476z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BusCardOperateActivity.this.m0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BusCardOperateActivity.this.f17463m.setProgress(BusCardOperateActivity.this.f17470t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BusCardOperateActivity.this.f17463m.setProgress(BusCardOperateActivity.this.f17470t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f17480a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f17481b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f17482c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f17483d;

        d(int i10, String str, boolean z10, String str2) {
            this.f17480a = i10;
            this.f17481b = str;
            this.f17482c = z10;
            this.f17483d = str2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            String str;
            String str2;
            HashMap hashMap = new HashMap();
            hashMap.put("is_retry", Boolean.valueOf(BusCardOperateActivity.this.f17475y));
            hashMap.put("is_abnormal_order", Boolean.valueOf(BusCardOperateActivity.this.f17472v));
            hashMap.put("error_code", Integer.valueOf(this.f17480a));
            hashMap.put("buscard_type", BusCardOperateActivity.this.f17467q.b());
            if (!TextUtils.isEmpty(this.f17481b)) {
                hashMap.put("api", this.f17481b);
            }
            String l10 = sd.b.h().l();
            if (!TextUtils.isEmpty(l10)) {
                k.a("BusCardOperateActivity", "seid = " + l10);
                hashMap.put("seid", l10);
            }
            int i10 = 0;
            if (this.f17482c) {
                BusCardOperateActivity.this.f17463m.setVisibility(8);
                BusCardOperateActivity.this.f17460j.setVisibility(0);
                BusCardOperateActivity.this.f17464n.setVisibility(0);
                BusCardOperateActivity.this.f17459i.setVisibility(8);
                BusCardOperateActivity.this.f17455e.setImageResource(i.f32968i);
                if (BusCardOperateActivity.this.f17473w) {
                    TextView textView = BusCardOperateActivity.this.f17456f;
                    int i11 = m.f33060f1;
                    textView.setText(i11);
                    BusCardOperateActivity.this.f17458h.setText(i11);
                    BusCardOperateActivity.this.f17457g.setText("");
                } else if (BusCardOperateActivity.this.f17471u) {
                    TextView textView2 = BusCardOperateActivity.this.f17456f;
                    int i12 = m.V0;
                    textView2.setText(i12);
                    BusCardOperateActivity.this.f17458h.setText(i12);
                    TextView textView3 = BusCardOperateActivity.this.f17457g;
                    BusCardOperateActivity busCardOperateActivity = BusCardOperateActivity.this;
                    textView3.setText(busCardOperateActivity.getString(m.W0, new Object[]{busCardOperateActivity.f17467q.name}));
                } else {
                    TextView textView4 = BusCardOperateActivity.this.f17456f;
                    int i13 = m.T0;
                    textView4.setText(i13);
                    BusCardOperateActivity.this.f17458h.setText(i13);
                    TextView textView5 = BusCardOperateActivity.this.f17457g;
                    BusCardOperateActivity busCardOperateActivity2 = BusCardOperateActivity.this;
                    textView5.setText(busCardOperateActivity2.getString(m.U0, new Object[]{busCardOperateActivity2.f17467q.name}));
                }
                BusCardOperateActivity.this.f17464n.setImageResource(i.f32970k);
            } else {
                BusCardOperateActivity.this.f17463m.setVisibility(8);
                BusCardOperateActivity.this.f17462l.setVisibility(0);
                BusCardOperateActivity.this.f17464n.setVisibility(0);
                BusCardOperateActivity.this.f17459i.setVisibility(0);
                if (BusCardOperateActivity.this.f17473w) {
                    TextView textView6 = BusCardOperateActivity.this.f17456f;
                    int i14 = m.f33063g1;
                    textView6.setText(i14);
                    BusCardOperateActivity.this.f17458h.setText(i14);
                } else if (BusCardOperateActivity.this.f17471u) {
                    TextView textView7 = BusCardOperateActivity.this.f17456f;
                    int i15 = m.L;
                    textView7.setText(i15);
                    BusCardOperateActivity.this.f17458h.setText(i15);
                } else {
                    TextView textView8 = BusCardOperateActivity.this.f17456f;
                    int i16 = m.K;
                    textView8.setText(i16);
                    BusCardOperateActivity.this.f17458h.setText(i16);
                }
                if (!TextUtils.isEmpty(this.f17483d)) {
                    str2 = this.f17483d;
                } else {
                    Context applicationContext = BusCardOperateActivity.this.getApplicationContext();
                    int i17 = this.f17480a;
                    if (BusCardOperateActivity.this.q0()) {
                        i10 = 2;
                    }
                    str2 = sd.c.c(applicationContext, i17, i10);
                }
                BusCardOperateActivity.this.f17457g.setText(str2);
                BusCardOperateActivity.this.f17464n.setImageResource(i.f32967h);
                if (this.f17480a == 6 || BusCardOperateActivity.this.f17473w) {
                    BusCardOperateActivity.this.f17457g.setText(m.f33046b);
                    BusCardOperateActivity.this.f17456f.setVisibility(4);
                    BusCardOperateActivity.this.f17456f.setVisibility(4);
                    BusCardOperateActivity.this.f17458h.setVisibility(4);
                }
                hashMap.put("error_message", str2);
            }
            if (this.f17482c) {
                str = BusCardOperateActivity.this.q0() ? "ticpay_bus_recharge_success" : "ticpay_bus_open_card_success";
                long uptimeMillis = SystemClock.uptimeMillis() - BusCardOperateActivity.this.f17476z;
                hashMap.put("duration", Long.valueOf(uptimeMillis));
                if (!BusCardOperateActivity.this.q0()) {
                    e.b().e(sd.b.h().m(), "bus_download_card_duration", uptimeMillis, hashMap);
                }
            } else {
                str = BusCardOperateActivity.this.q0() ? "ticpay_bus_recharge_error" : "ticpay_bus_open_card_error";
            }
            e.b().g(sd.b.h().m(), str, hashMap);
        }
    }

    private void h0() {
        f.q(this.D, 3014, null);
    }

    private void i0(boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putString("param", this.f17467q.ssdAid);
        bundle.putBoolean("recreate", z10);
        f.q(this.D, 3009, bundle);
    }

    private void j0() {
        k.c("BusCardOperateActivity", "delayWriteCard is retry %s", Boolean.valueOf(this.A));
        this.D.postDelayed(new a(), 10000L);
    }

    private void k0() {
        Applet applet = this.f17467q.applet;
        k.a("BusCardOperateActivity", "deleteApplet applet = [" + applet + "], orderId = [" + this.f17465o + "]");
        Bundle bundle = new Bundle();
        bundle.putString("order_id", this.f17465o);
        bundle.putString("card_aid", this.f17467q.appAid);
        f.q(this.D, 3020, bundle);
    }

    private void l0() {
        Bundle bundle = new Bundle();
        bundle.putString("param", this.f17467q.applet.getInstanceAid());
        bundle.putString("order_id", this.f17465o);
        bundle.putLong("main_order_id", this.f17466p);
        bundle.putString("card_aid", this.f17467q.appAid);
        bundle.putBoolean("abnormal_order", this.f17472v);
        f.q(this.D, 3023, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0() {
        this.f17476z = SystemClock.uptimeMillis();
        if (this.f17473w) {
            l0();
        } else if (this.f17471u) {
            v0();
        } else {
            u0(this.f17465o);
        }
        String str = q0() ? "ticpay_bus_begin_recharge" : "ticpay_bus_begin_open_card";
        HashMap hashMap = new HashMap();
        hashMap.put("is_retry", Boolean.valueOf(this.f17475y));
        hashMap.put("is_abnormal_order", Boolean.valueOf(this.f17472v));
        hashMap.put("buscard_type", this.f17467q.b());
        e.b().g(sd.b.h().m(), str, hashMap);
    }

    private void n0() {
        Applet applet = this.f17467q.applet;
        k.a("BusCardOperateActivity", "downloadApplet applet = [" + applet + "], orderId = [" + this.f17465o + "]");
        Bundle bundle = new Bundle();
        bundle.putString("order_id", this.f17465o);
        bundle.putString("card_aid", this.f17467q.appAid);
        f.q(this.D, 3010, bundle);
    }

    private void o0(Animator.AnimatorListener animatorListener) {
        ObjectAnimator objectAnimator = this.B;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.B.cancel();
        }
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "operateProgress", this.f17470t, 101);
        this.C = ofInt;
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        this.C.setDuration(1000L);
        this.C.addUpdateListener(new c());
        this.C.addListener(animatorListener);
        this.C.start();
    }

    private void p0() {
        Bundle bundle = new Bundle();
        bundle.putString("card_aid", this.f17467q.appAid);
        f.q(this.D, 3012, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q0() {
        return this.f17471u || this.f17473w;
    }

    private boolean r0() {
        return this.f17471u && "A0000006320101050113581058000000".equalsIgnoreCase(this.f17467q.appAid);
    }

    private void s0(int i10, String str, String str2) {
        o0(new d(i10, str2, i10 == 0, str));
    }

    private void t0() {
        Bundle bundle = new Bundle();
        bundle.putString("order_id", this.f17465o);
        bundle.putString("card_aid", this.f17467q.appAid);
        f.q(this.D, 3011, bundle);
    }

    private void u0(String str) {
        k.a("BusCardOperateActivity", "queryPayOrderStatus orderId = " + str);
        Bundle bundle = new Bundle();
        bundle.putString("order_id", str);
        f.q(this.D, 3019, bundle);
    }

    private void v0() {
        Bundle bundle = new Bundle();
        bundle.putString("param", this.f17467q.applet.getInstanceAid());
        bundle.putString("order_id", this.f17465o);
        bundle.putLong("main_order_id", this.f17466p);
        bundle.putString("card_aid", this.f17467q.appAid);
        bundle.putBoolean("abnormal_order", this.f17472v);
        f.q(this.D, 3007, bundle);
    }

    private void w0() {
        if (this.f17468r == 3) {
            v0();
        } else {
            p0();
        }
    }

    private void x0() {
        k.a("BusCardOperateActivity", "refreshAbnormalOrderIfNeeded isAbnormalOrder = " + this.f17472v);
        if (this.f17472v) {
            h0();
        } else {
            s0(0, null, null);
        }
    }

    private void y0() {
        z0();
        this.f17463m.setVisibility(0);
        this.f17464n.setVisibility(8);
        this.f17459i.setVisibility(8);
        this.f17462l.setVisibility(8);
        this.f17461k.setVisibility(8);
        this.f17456f.setText(q0() ? m.P0 : m.U);
        this.f17457g.setText(q0() ? m.O0 : m.f33068i0);
        this.f17458h.setText(m.f33104w0);
        this.f17475y = true;
        m0();
    }

    private void z0() {
        if (this.B == null) {
            ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "operateProgress", 0, 90);
            this.B = ofInt;
            ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
            this.B.setDuration(q0() ? 10000L : 100000L);
            this.B.addUpdateListener(new b());
        }
        this.B.start();
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return qd.k.f33026b;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x014f  */
    @Override // com.mobvoi.companion.ticpay.ui.c, com.mobvoi.android.common.utils.s.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleMessage(Message message) {
        String str;
        String str2;
        boolean z10;
        String str3;
        k.a("BusCardOperateActivity", "handleMessage msg.what = " + message.what);
        int i10 = message.what;
        boolean z11 = true;
        boolean z12 = false;
        if (i10 != 3007) {
            if (i10 == 3014) {
                Object obj = message.obj;
                if (obj != null) {
                    this.f17474x = ((Boolean) obj).booleanValue();
                }
                s0(0, null, null);
            } else if (i10 != 3023) {
                int i11 = -1;
                if (i10 == 3019) {
                    RespInfo respInfo = (RespInfo) message.obj;
                    if (respInfo != null) {
                        int status = respInfo.getStatus();
                        String desc = respInfo.getDesc();
                        k.c("BusCardOperateActivity", "query order status result: status = %d, desc = %s.", Integer.valueOf(status), desc);
                        if (status == 0) {
                            int orderStatus = ((PayOrderStatusBusiRespInfo) respInfo.getBusiRespInfo()).getOrderStatus();
                            k.a("BusCardOperateActivity", "orderStatus = " + orderStatus);
                            if (orderStatus != 21) {
                                if (orderStatus != 12 && orderStatus != 13) {
                                    z11 = false;
                                } else if ("A00000000386980701".equalsIgnoreCase(this.f17467q.appAid) || "D1560001360103000057485401000001".equalsIgnoreCase(this.f17467q.appAid) || "D156000015CCECB8AECDA8BFA8".equalsIgnoreCase(this.f17467q.appAid) || "535A542E57414C4C45542E454E56".equalsIgnoreCase(this.f17467q.appAid) || "A00000063201010510009156000014A1".equalsIgnoreCase(this.f17467q.appAid)) {
                                    k0();
                                    return;
                                } else if ("A0000006320101050113581058000000".equalsIgnoreCase(this.f17467q.appAid)) {
                                    t0();
                                    return;
                                }
                                i0(z11);
                            } else if ("9156000014010001".equalsIgnoreCase(this.f17467q.appAid) || "A00000063201010510009156000014A1".equalsIgnoreCase(this.f17467q.appAid) || "D1560001360103000057485401000001".equalsIgnoreCase(this.f17467q.appAid) || "D156000015CCECB8AECDA8BFA8".equalsIgnoreCase(this.f17467q.appAid) || "535A542E57414C4C45542E454E56".equalsIgnoreCase(this.f17467q.appAid) || "A00000000386980701".equalsIgnoreCase(this.f17467q.appAid) || "A0000006320101050113581058000000".equalsIgnoreCase(this.f17467q.appAid)) {
                                this.f17467q.applet.setDownType(1);
                                t0();
                            } else {
                                n0();
                            }
                        } else {
                            s0(status, desc, "queryOrderStatus");
                        }
                    } else {
                        s0(-1, "query status error.", "queryOrderStatus");
                    }
                } else if (i10 != 3020) {
                    switch (i10) {
                        case 3009:
                            int intValue = ((Integer) message.obj).intValue();
                            k.a("BusCardOperateActivity", "createSsd onPostExecute errorCode = " + intValue);
                            if (intValue != 100000) {
                                s0(intValue, null, "createSsd");
                                return;
                            } else if ("A0000006320101050113581058000000".equals(this.f17467q.appAid)) {
                                t0();
                                return;
                            } else {
                                n0();
                                return;
                            }
                        case 3010:
                            if ("A00000000386980701".equalsIgnoreCase(this.f17467q.appAid)) {
                                Object obj2 = message.obj;
                                if (obj2 instanceof BusinessException) {
                                    str3 = sd.c.d((BusinessException) obj2);
                                } else if (obj2 instanceof Boolean) {
                                    z10 = ((Boolean) obj2).booleanValue();
                                    str2 = Constant.CASH_LOAD_SUCCESS;
                                    k.a("BusCardOperateActivity", "downloadApplet onPostExecute result = " + z10);
                                    if (!z10) {
                                        this.f17467q.applet.setDownType(1);
                                        s0(0, str2, "downloadApplet");
                                        return;
                                    }
                                    s0(-1, str2, "downloadApplet");
                                    return;
                                } else {
                                    str3 = "failed";
                                }
                                str2 = str3;
                                z10 = false;
                                k.a("BusCardOperateActivity", "downloadApplet onPostExecute result = " + z10);
                                if (!z10) {
                                }
                            } else {
                                RespInfo respInfo2 = (RespInfo) message.obj;
                                int status2 = respInfo2.getStatus();
                                String desc2 = respInfo2.getDesc();
                                k.c("BusCardOperateActivity", "downloadApplet onPostExecute status = %d, desc = %s.", Integer.valueOf(status2), desc2);
                                if (status2 == 0) {
                                    this.f17467q.applet.setDownType(1);
                                    if ("9156000014010001".equalsIgnoreCase(this.f17467q.appAid) || "A00000063201010510009156000014A1".equalsIgnoreCase(this.f17467q.appAid) || "D1560001360103000057485401000001".equalsIgnoreCase(this.f17467q.appAid) || "D156000015CCECB8AECDA8BFA8".equalsIgnoreCase(this.f17467q.appAid) || "535A542E57414C4C45542E454E56".equalsIgnoreCase(this.f17467q.appAid) || "A0000006320101050113581058000000".equalsIgnoreCase(this.f17467q.appAid)) {
                                        t0();
                                        return;
                                    } else {
                                        w0();
                                        return;
                                    }
                                } else {
                                    s0(status2, desc2, "downloadApplet");
                                    return;
                                }
                            }
                            break;
                        case 3011:
                            RespInfo respInfo3 = (RespInfo) message.obj;
                            int status3 = respInfo3.getStatus();
                            String desc3 = respInfo3.getDesc();
                            k.c("BusCardOperateActivity", "personApplet onPostExecute status = %d, desc = %s.", Integer.valueOf(status3), desc3);
                            if (status3 == 0) {
                                if ("A00000063201010510009156000014A1".equalsIgnoreCase(this.f17467q.appAid)) {
                                    com.mobvoi.companion.base.settings.a.setAddBusCardStatus(this.f17467q.appAid);
                                }
                                w0();
                                return;
                            }
                            s0(status3, desc3, "personalApplet");
                            return;
                        case 3012:
                            CardInfo cardInfo = (CardInfo) message.obj;
                            k.a("BusCardOperateActivity", "onPostExecute get card info.");
                            if (cardInfo != null) {
                                this.f17467q.f35369id = cardInfo.getCardNum();
                                this.f17467q.status = cardInfo.getCardStatus();
                                this.f17467q.balance = cardInfo.getCardBalance();
                                this.f17467q.openDate = cardInfo.getStartDate();
                                this.f17467q.expireDate = cardInfo.getExpiryDate();
                                k.a("BusCardOperateActivity", "number: " + this.f17467q.f35369id + ", status: " + this.f17467q.status + ", balance: " + this.f17467q.balance + ", openDate: " + this.f17467q.openDate + ", expireDate: " + this.f17467q.expireDate);
                            }
                            x0();
                            return;
                        default:
                            return;
                    }
                } else {
                    if (qd.a.c(this.f17467q)) {
                        Object obj3 = message.obj;
                        if (obj3 instanceof BusinessException) {
                            str = sd.c.d((BusinessException) obj3);
                        } else if (obj3 instanceof Boolean) {
                            z12 = ((Boolean) obj3).booleanValue();
                            str = "delete sht failed";
                        } else {
                            str = "";
                        }
                    } else {
                        RespInfo respInfo4 = (RespInfo) message.obj;
                        i11 = respInfo4.getStatus();
                        str = respInfo4.getDesc();
                        k.c("BusCardOperateActivity", "deleteApplet onPostExecute status = %d, desc = %s.", Integer.valueOf(i11), str);
                        if (i11 != 0) {
                            z11 = false;
                        }
                        z12 = z11;
                    }
                    if (z12) {
                        n0();
                    } else {
                        s0(i11, str, "deleteApplet");
                    }
                }
            } else {
                String string = getString(m.f33046b);
                if (qd.a.c(this.f17467q)) {
                    Object obj4 = message.obj;
                    if (!(obj4 instanceof Boolean)) {
                        if (obj4 instanceof BusinessException) {
                            string = sd.c.d((BusinessException) obj4);
                        }
                        s0(2, string, "unsettled");
                    } else if (((Boolean) obj4).booleanValue()) {
                        this.f17467q.balance += this.f17469s;
                        x0();
                    } else {
                        s0(2, string, "unsettled");
                    }
                } else {
                    s0(0, string, "unsettled");
                }
            }
        } else if (qd.a.c(this.f17467q)) {
            Object obj5 = message.obj;
            if (!(obj5 instanceof Boolean)) {
                s0(2, obj5 instanceof BusinessException ? sd.c.d((BusinessException) obj5) : "recharge", "recharge");
            } else if (((Boolean) obj5).booleanValue()) {
                this.f17467q.balance += this.f17469s;
                x0();
            } else {
                s0(2, "recharge", "recharge");
            }
        } else {
            RespInfo respInfo5 = (RespInfo) message.obj;
            int status4 = respInfo5.getStatus();
            String desc4 = respInfo5.getDesc();
            k.c("BusCardOperateActivity", "onPostExecute: recharge status = %d, desc = %s", Integer.valueOf(status4), desc4);
            if (!q0()) {
                p0();
            } else if (status4 == 0) {
                this.f17467q.balance += this.f17469s;
                x0();
            } else if (this.A || !r0()) {
                s0(status4, desc4, "recharge");
            } else {
                this.A = true;
                j0();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        String str = "action.RECHARGE_SUCCESS";
        if (id2 == j.f33009r) {
            if (!q0()) {
                str = "action.ADD_BUS_CARD";
            }
            Intent intent = new Intent(str);
            intent.putExtra("card_aid", this.f17467q.appAid);
            intent.putExtra("param", true);
            if (this.f17472v) {
                intent.putExtra("abnormal_order", this.f17474x);
            }
            b1.a.b(this).d(intent);
            finish();
            if (!q0()) {
                vd.b.d(this.f17467q);
            }
        } else if (id2 == j.f32994j0) {
            y0();
        } else if (id2 == j.f32981d) {
            if (!q0()) {
                str = "action.ADD_BUS_CARD";
            }
            Intent intent2 = new Intent(str);
            intent2.putExtra("card_aid", this.f17467q.appAid);
            intent2.putExtra("abnormal_order", true);
            intent2.putExtra("param", false);
            b1.a.b(this).d(intent2);
            finish();
        } else if (id2 == j.f33007q) {
            startActivity(new Intent("android.intent.action.DIAL", Uri.fromParts("tel", getString(m.f33087o1), null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.ticpay.ui.c, com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        int i10;
        int i11;
        super.onCreate(bundle);
        K();
        Intent intent = getIntent();
        int i12 = 0;
        if (intent == null || !intent.hasExtra("card_aid")) {
            str = null;
            i11 = 0;
            i10 = 0;
        } else {
            String stringExtra = intent.getStringExtra("card_aid");
            this.f17465o = intent.getStringExtra("order_id");
            this.f17466p = intent.getLongExtra("main_order_id", 0L);
            this.f17468r = intent.getIntExtra("order_type", -1);
            this.f17469s = intent.getIntExtra("order_money", 0);
            this.f17472v = intent.getBooleanExtra("abnormal_order", false);
            this.f17473w = intent.getBooleanExtra("unsettled_order", false);
            i11 = intent.getIntExtra("pay_money", 0);
            i10 = intent.getIntExtra("pay_way", 0);
            str = intent.getStringExtra("order_time");
            this.f17467q = sd.b.h().i(stringExtra);
        }
        if (this.f17467q == null) {
            throw new IllegalArgumentException("Must have a card.");
        } else if (TextUtils.isEmpty(this.f17465o)) {
            throw new IllegalArgumentException("Invalid order id.");
        } else if (this.f17468r != -1) {
            k.a("BusCardOperateActivity", "onCreate orderId = " + this.f17465o + ", cardType = " + this.f17467q.name + ", orderType " + this.f17468r);
            this.f17471u = this.f17468r == 2;
            this.f17455e = (ImageView) findViewById(j.f32998l0);
            this.f17456f = (TextView) findViewById(j.f33000m0);
            this.f17457g = (TextView) findViewById(j.f33008q0);
            TextView textView = (TextView) findViewById(j.f32987g);
            TextView textView2 = (TextView) findViewById(j.R);
            TextView textView3 = (TextView) findViewById(j.f32976a0);
            TextView textView4 = (TextView) findViewById(j.f32991i);
            TextView textView5 = (TextView) findViewById(j.f32988g0);
            TextView textView6 = (TextView) findViewById(j.f33014t0);
            TextView textView7 = (TextView) findViewById(j.Z);
            TextView textView8 = (TextView) findViewById(j.f33002n0);
            this.f17458h = (TextView) findViewById(j.S);
            this.f17460j = (Button) findViewById(j.f33009r);
            this.f17461k = (Button) findViewById(j.f32994j0);
            this.f17462l = (Button) findViewById(j.f32981d);
            this.f17463m = (RoundProgressBar) findViewById(j.f32984e0);
            this.f17464n = (ImageView) findViewById(j.f32992i0);
            this.f17459i = (TextView) findViewById(j.f33007q);
            textView8.setText(this.f17471u ? m.N0 : m.A0);
            this.f17459i.setOnClickListener(this);
            this.f17459i.setVisibility(8);
            this.f17460j.setOnClickListener(this);
            this.f17461k.setOnClickListener(this);
            this.f17462l.setOnClickListener(this);
            this.f17460j.setVisibility(8);
            this.f17461k.setVisibility(8);
            this.f17462l.setVisibility(8);
            this.f17464n.setVisibility(8);
            if (TextUtils.isEmpty(this.f17467q.f35369id)) {
                findViewById(j.B).setVisibility(8);
            } else {
                textView.setText(this.f17467q.f35369id);
            }
            textView2.setText(this.f17465o);
            if (str != null) {
                textView7.setText(str);
            }
            Applet applet = this.f17467q.applet;
            if (applet != null) {
                i12 = applet.getCardPrice();
            }
            int i13 = this.f17471u ? this.f17469s : this.f17469s - i12;
            textView4.setText(sd.c.o(i12));
            textView5.setText(sd.c.o(i13));
            textView6.setText(sd.c.o(i11));
            textView3.setText(sd.c.f(i10));
            this.f17458h.setText(m.f33104w0);
            if (this.f17471u) {
                findViewById(j.C).setVisibility(8);
                this.f17456f.setText(m.P0);
                this.f17457g.setText(m.O0);
            }
            if (this.f17473w) {
                this.f17456f.setText(m.f33066h1);
            }
            sd.b.h().c().b();
            z0();
            if (r0()) {
                j0();
            } else {
                m0();
            }
        } else {
            throw new IllegalArgumentException("Unsupported order type " + this.f17468r);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.ticpay.ui.c, com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        qd.d c10 = sd.b.h().c();
        c10.a();
        if (com.mobvoi.companion.base.settings.a.needSyncBusCard()) {
            c10.c(com.mobvoi.companion.base.settings.a.getSyncBusCardAid());
            com.mobvoi.companion.base.settings.a.resetBusCardStatus();
        }
        super.onDestroy();
        ObjectAnimator objectAnimator = this.B;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.B.cancel();
        }
        ObjectAnimator objectAnimator2 = this.C;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.C.cancel();
        }
    }

    @Keep
    public void setOperateProgress(int i10) {
        this.f17470t = i10;
    }
}
