package com.mobvoi.companion.ticpay.ui;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.d0;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.services.core.AMapException;
import com.bjleisen.iface.sdk.apdu.LeisenIfaceOperator;
import com.bjleisen.iface.sdk.bean.Applet;
import com.bjleisen.iface.sdk.bean.resp.AppletListBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.RespInfo;
import com.bjleisen.iface.sdk.enums.EnumCardAppStatus;
import com.bjleisen.iface.sdk.enums.EnumDeviceType;
import com.bjleisen.iface.sdk.enums.EnumEnvType;
import com.laser.tsm.sdk.tsm.TSMOperator;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.q;
import com.mobvoi.android.common.utils.s;
import com.mobvoi.companion.browser.BasicBrowserActivity;
import com.mobvoi.companion.setting.CompanionSetting;
import com.mobvoi.companion.ticpay.ui.b;
import com.mobvoi.wear.common.base.TicwatchModels;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.info.CapabilityHelper;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jc.a;
import qd.h;
import qd.i;
import qd.j;
import qd.m;
import qd.n;
/* compiled from: BusCardFragment.java */
/* loaded from: classes2.dex */
public class a extends Fragment implements s.a {

    /* renamed from: a  reason: collision with root package name */
    private g f17558a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f17559b;

    /* renamed from: c  reason: collision with root package name */
    private View f17560c;

    /* renamed from: d  reason: collision with root package name */
    private com.mobvoi.companion.ticpay.ui.b f17561d;

    /* renamed from: e  reason: collision with root package name */
    private ProgressDialog f17562e;

    /* renamed from: f  reason: collision with root package name */
    private Context f17563f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f17564g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f17565h;

    /* renamed from: i  reason: collision with root package name */
    private String f17566i;

    /* renamed from: j  reason: collision with root package name */
    private String f17567j;

    /* renamed from: l  reason: collision with root package name */
    private sd.b f17569l;

    /* renamed from: n  reason: collision with root package name */
    private ud.a f17571n;

    /* renamed from: o  reason: collision with root package name */
    private ud.a f17572o;

    /* renamed from: k  reason: collision with root package name */
    private boolean f17568k = false;

    /* renamed from: m  reason: collision with root package name */
    private final List<ud.a> f17570m = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    private s f17573p = new s(this);

    /* renamed from: q  reason: collision with root package name */
    private BroadcastReceiver f17574q = new C0208a();

    /* compiled from: BusCardFragment.java */
    /* renamed from: com.mobvoi.companion.ticpay.ui.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0208a extends BroadcastReceiver {
        C0208a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            k.a("BusCardFragment", "onReceive action = " + action);
            if ("action.ADD_BUS_CARD".equals(action)) {
                String stringExtra = intent.getStringExtra("card_aid");
                boolean booleanExtra = intent.getBooleanExtra("param", false);
                if (intent.hasExtra("abnormal_order")) {
                    a.this.f17564g = intent.getBooleanExtra("abnormal_order", false);
                }
                ud.a i10 = a.this.f17569l.i(stringExtra);
                int n10 = a.this.f17569l.n();
                if (booleanExtra && i10.j()) {
                    if (n10 == 1) {
                        a.this.f17568k = true;
                        a.this.J0(i10);
                    } else {
                        a.this.q0(i10);
                    }
                }
                if ("A00000000386980701".equalsIgnoreCase(i10.appAid) && booleanExtra) {
                    i10.status = EnumCardAppStatus.CARD_STATUS_OK;
                } else if ("A0000006320101050113581058000000".equalsIgnoreCase(i10.appAid) && booleanExtra) {
                    i10.applet.setDownType(1);
                }
                a.this.f17558a.f();
            } else if ("action.DELETE_BUS_CARD".equals(action)) {
                Iterator it = a.this.f17570m.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ud.a aVar = (ud.a) it.next();
                    if (aVar.j() && !aVar.isDefault) {
                        a.this.J0(aVar);
                        break;
                    }
                }
                a.this.f17558a.f();
            } else if ("action.RECHARGE_SUCCESS".equals(action)) {
                if (intent.hasExtra("abnormal_order")) {
                    a.this.f17564g = intent.getBooleanExtra("abnormal_order", false);
                }
                a.this.f17558a.f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BusCardFragment.java */
    /* loaded from: classes2.dex */
    public class b implements b.AbstractC0210b<ud.a> {
        b() {
        }

        /* renamed from: b */
        public void a(ud.a aVar, ud.a aVar2) {
            a.this.F0(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BusCardFragment.java */
    /* loaded from: classes2.dex */
    public class c implements a.AbstractC0354a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ jc.a f17577a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ud.a f17578b;

        c(jc.a aVar, ud.a aVar2) {
            this.f17577a = aVar;
            this.f17578b = aVar2;
        }

        @Override // jc.a.AbstractC0354a
        public void a() {
            this.f17577a.dismiss();
            a.this.F0(this.f17578b);
        }

        @Override // jc.a.AbstractC0354a
        public void onCancel() {
            this.f17577a.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BusCardFragment.java */
    /* loaded from: classes2.dex */
    public class d implements a.AbstractC0354a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ jc.a f17580a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ud.a f17581b;

        d(jc.a aVar, ud.a aVar2) {
            this.f17580a = aVar;
            this.f17581b = aVar2;
        }

        @Override // jc.a.AbstractC0354a
        public void a() {
            this.f17580a.dismiss();
            a aVar = a.this;
            aVar.O0(aVar.getString(m.Z0));
            a.this.J0(this.f17581b);
        }

        @Override // jc.a.AbstractC0354a
        public void onCancel() {
            this.f17580a.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BusCardFragment.java */
    /* loaded from: classes2.dex */
    public class e implements a.AbstractC0354a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ jc.a f17583a;

        e(a aVar, jc.a aVar2) {
            this.f17583a = aVar2;
        }

        @Override // jc.a.AbstractC0354a
        public void a() {
            this.f17583a.dismiss();
        }

        @Override // jc.a.AbstractC0354a
        public void onCancel() {
            this.f17583a.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BusCardFragment.java */
    /* loaded from: classes2.dex */
    public static class f extends RecyclerView.b0 {

        /* renamed from: a  reason: collision with root package name */
        private TextView f17584a;

        /* renamed from: b  reason: collision with root package name */
        private ImageView f17585b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f17586c;

        /* renamed from: d  reason: collision with root package name */
        private TextView f17587d;

        /* renamed from: e  reason: collision with root package name */
        private TextView f17588e;

        f(View view, int i10) {
            super(view);
            if (i10 == 1) {
                this.f17584a = (TextView) view.findViewById(j.f32987g);
            }
            if (i10 == 2) {
                this.f17585b = (ImageView) view.findViewById(j.f32978b0);
                this.f17587d = (TextView) view.findViewById(j.f32977b);
                this.f17586c = (TextView) view.findViewById(j.f33024z);
                this.f17588e = (TextView) view.findViewById(j.Q);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BusCardFragment.java */
    /* loaded from: classes2.dex */
    public class g extends RecyclerView.Adapter<f> {

        /* renamed from: a  reason: collision with root package name */
        private final List<ud.a> f17589a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: BusCardFragment.java */
        /* renamed from: com.mobvoi.companion.ticpay.ui.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class View$OnClickListenerC0209a implements View.OnClickListener {
            View$OnClickListenerC0209a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.M0();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: BusCardFragment.java */
        /* loaded from: classes2.dex */
        public class b implements View.OnClickListener {
            b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.N0();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: BusCardFragment.java */
        /* loaded from: classes2.dex */
        public class c implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ud.a f17593a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ boolean f17594b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f17595c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ String f17596d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ String f17597e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ f f17598f;

            c(ud.a aVar, boolean z10, String str, String str2, String str3, f fVar) {
                this.f17593a = aVar;
                this.f17594b = z10;
                this.f17595c = str;
                this.f17596d = str2;
                this.f17597e = str3;
                this.f17598f = fVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent;
                androidx.fragment.app.f activity = a.this.getActivity();
                if (activity != null) {
                    if (a.this.D0(this.f17593a)) {
                        a.this.Q0();
                        return;
                    }
                    EnumCardAppStatus enumCardAppStatus = this.f17593a.status;
                    if (enumCardAppStatus != EnumCardAppStatus.CARD_STATUS_BLACKLIST && enumCardAppStatus != EnumCardAppStatus.CARD_STATUS_WALLET_ERROR && enumCardAppStatus != EnumCardAppStatus.CARD_STATUS_DISABLE) {
                        if (this.f17594b) {
                            intent = new Intent(activity, BusCardInfoActivity.class);
                        } else {
                            intent = new Intent(activity, BusCardRechargeActivity.class);
                            intent.putExtra("order_type", 1);
                        }
                        intent.putExtra("card_aid", this.f17593a.appAid);
                        intent.putExtra("image", this.f17595c);
                        intent.putExtra("text1", this.f17596d);
                        intent.putExtra("text2", this.f17597e);
                        a.this.startActivity(intent, androidx.core.app.b.a(activity, new j0.d(this.f17598f.f17585b, this.f17595c), new j0.d(this.f17598f.f17588e, this.f17596d), new j0.d(this.f17598f.f17587d, this.f17597e)).b());
                    } else if (a.this.isAdded() && (activity instanceof com.mobvoi.companion.ticpay.ui.c)) {
                        ((com.mobvoi.companion.ticpay.ui.c) activity).L(this.f17593a.g());
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: BusCardFragment.java */
        /* loaded from: classes2.dex */
        public class d implements View.OnLongClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ud.a f17600a;

            d(ud.a aVar) {
                this.f17600a = aVar;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                Intent intent = new Intent(a.this.getActivity(), BusCardInfoActivity.class);
                intent.putExtra("card_aid", this.f17600a.appAid);
                a.this.startActivity(intent);
                return false;
            }
        }

        g(List<ud.a> list) {
            ArrayList arrayList = new ArrayList();
            this.f17589a = arrayList;
            arrayList.addAll(list);
            Collections.sort(arrayList);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [int, boolean] */
        private int c() {
            ?? r02 = a.this.f17564g;
            return a.this.f17565h ? r02 + 1 : r02 == true ? 1 : 0;
        }

        /* renamed from: d */
        public void onBindViewHolder(f fVar, int i10) {
            int itemViewType = getItemViewType(i10);
            if (itemViewType == 0) {
                fVar.itemView.setOnClickListener(new View$OnClickListenerC0209a());
            } else if (itemViewType == 1) {
                Iterator<ud.a> it = this.f17589a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ud.a next = it.next();
                    if (next.isDefault) {
                        fVar.f17584a.setText(next.name);
                        break;
                    }
                }
                fVar.itemView.setOnClickListener(new b());
            } else {
                String str = "pv" + i10;
                String str2 = "ov" + i10;
                String str3 = "bv" + i10;
                d0.M0(fVar.f17585b, str);
                d0.M0(fVar.f17588e, str2);
                d0.M0(fVar.f17587d, str3);
                ud.a aVar = this.f17589a.get(i10 - c());
                boolean i11 = aVar.i();
                String str4 = "";
                if (i11) {
                    String str5 = aVar.f35369id;
                    if (str5 != null) {
                        str4 = str5;
                    }
                    fVar.f17588e.setText(str4);
                    fVar.f17587d.setVisibility(0);
                    fVar.f17587d.setText(sd.c.o(aVar.balance));
                    if (!aVar.j()) {
                        fVar.f17586c.setVisibility(0);
                        fVar.f17586c.setText(m.f33109z);
                    } else if (aVar.isDefault) {
                        fVar.f17586c.setVisibility(0);
                        fVar.f17586c.setText(m.E);
                    } else {
                        fVar.f17586c.setVisibility(8);
                    }
                } else {
                    fVar.f17588e.setText(m.f33065h0);
                    fVar.f17587d.setText(str4);
                    fVar.f17587d.setVisibility(8);
                    fVar.f17586c.setVisibility(8);
                }
                fVar.f17585b.setOnClickListener(new c(aVar, i11, str, str2, str3, fVar));
                fVar.f17585b.setImageResource(aVar.iconRes);
                if (a.this.f17569l.o()) {
                    fVar.f17585b.setOnLongClickListener(new d(aVar));
                }
                if (i10 == getItemCount() - 1) {
                    ((ViewGroup.MarginLayoutParams) ((RecyclerView.o) fVar.itemView.getLayoutParams())).bottomMargin = a.this.getResources().getDimensionPixelSize(h.f32957a);
                }
            }
        }

        /* renamed from: e */
        public f onCreateViewHolder(ViewGroup viewGroup, int i10) {
            int i11;
            k.a("BusCardFragment", "onCreateViewHolder " + i10);
            if (i10 == 0) {
                i11 = qd.k.f33034j;
            } else if (i10 == 1) {
                i11 = qd.k.f33036l;
            } else {
                i11 = qd.k.f33037m;
            }
            return new f(LayoutInflater.from(a.this.f17563f).inflate(i11, viewGroup, false), i10);
        }

        public void f() {
            Iterator<ud.a> it = this.f17589a.iterator();
            while (it.hasNext()) {
                if (it.next().applet == null) {
                    it.remove();
                }
            }
            Collections.sort(this.f17589a);
            boolean z10 = false;
            int i10 = 0;
            for (ud.a aVar : this.f17589a) {
                if (aVar.j()) {
                    i10++;
                }
            }
            a aVar2 = a.this;
            if (i10 > 1) {
                z10 = true;
            }
            aVar2.f17565h = z10;
            notifyDataSetChanged();
        }

        public void g(List<ud.a> list) {
            this.f17589a.clear();
            this.f17589a.addAll(list);
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f17589a.size() + c();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i10) {
            if (i10 == 0 && a.this.f17564g) {
                return 0;
            }
            if (a.this.f17565h) {
                return (i10 == 0 || (i10 == 1 && a.this.f17564g)) ? 1 : 2;
            }
            return 2;
        }
    }

    private void A0() {
        H0(AMapException.CODE_AMAP_ROUTE_NO_ROADS_NEARBY);
    }

    private void B0() {
        String p10 = ta.a.p();
        if (TextUtils.isEmpty(p10)) {
            k.a("BusCardFragment", "Must bind phone number first.");
            E0(getString(m.H));
            return;
        }
        sd.d dVar = new sd.d(this.f17563f);
        LeisenIfaceOperator leisenIfaceOperator = LeisenIfaceOperator.getInstance();
        leisenIfaceOperator.init(this.f17563f, EnumDeviceType.DEVICE_TYPE_MULTI_BLUETOOTH, "20160810", BasicBrowserActivity.DEFAULT_DELAYED_MILLIS);
        leisenIfaceOperator.setIMultiBluetoothInterfaceService(dVar);
        leisenIfaceOperator.setSeTsmId("20160810");
        leisenIfaceOperator.setMsisdn(p10);
        String i10 = sd.c.i();
        k.a("BusCardFragment", "setUserId: " + i10);
        leisenIfaceOperator.setUserId(i10);
        leisenIfaceOperator.setDeviceOSVersion("5.1.1");
        TSMOperator tSMOperator = TSMOperator.getInstance();
        tSMOperator.setReuqestTimeOut(BasicBrowserActivity.DEFAULT_DELAYED_MILLIS);
        tSMOperator.setIMobvoiTsmBluetoothInterfaceService(new sd.f(this.f17563f));
        tSMOperator.init(this.f17563f, com.laser.tsm.sdk.apdu.EnumDeviceType.DEVICE_TYPE_MULTI_BLUETOOTH);
        if (!this.f17569l.o()) {
            k.a("BusCardFragment", "env product");
            leisenIfaceOperator.switchEnv(EnumEnvType.ENV_PRD);
            tSMOperator.setRequestUrl("https://www.opentsm.cn:12001/apkp/TSMServer/applicationBusiness.action");
        } else {
            k.a("BusCardFragment", "env beta");
            leisenIfaceOperator.switchEnv(EnumEnvType.ENV_BETA);
            tSMOperator.setRequestUrl("https://demo.bjleisen.com/wwapkp/TSMServer/applicationBusiness.action");
        }
        A0();
    }

    private boolean C0() {
        return "TicWatch AW".equals(sd.b.h().f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean D0(ud.a aVar) {
        if ("D1560001360103000057485401000001".equalsIgnoreCase(aVar.appAid)) {
            if (!T0(m.f33058f)) {
                return true;
            }
        } else if ("D156000015CCECB8AECDA8BFA8".equalsIgnoreCase(aVar.appAid)) {
            if (!T0(m.f33052d)) {
                return true;
            }
        } else if ("A00000000386980701".equalsIgnoreCase(aVar.appAid)) {
            if (!T0(m.f33055e)) {
                return true;
            }
        } else if ("A00000063201010510009156000014A1".equalsIgnoreCase(aVar.appAid)) {
            if (!sd.b.h().c().f() && !T0(m.f33049c)) {
                return true;
            }
        } else if ("A0000006320101050113581058000000".equalsIgnoreCase(aVar.appAid) && !T0(m.f33061g)) {
            return true;
        }
        return false;
    }

    private void E0(String str) {
        this.f17567j = str;
        S0();
        HashMap hashMap = new HashMap();
        hashMap.put("error_message", str);
        qd.e.b().g(this.f17569l.m(), "ticpay_bus_error_card_list", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(ud.a aVar) {
        if (L0(aVar)) {
            P0(aVar);
            return;
        }
        O0(getString(m.Z0));
        J0(aVar);
    }

    private void G0() {
        k.a("BusCardFragment", "onInitSuccess");
        y0();
        this.f17558a.f();
        qd.e.b().g(this.f17569l.m(), "ticpay_bus_page_card_list", null);
    }

    private void H0(int i10) {
        I0(i10, null);
    }

    private void I0(int i10, Bundle bundle) {
        qd.f.q(this.f17573p, i10, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(ud.a aVar) {
        String str = aVar.appAid;
        k.a("BusCardFragment", "setDefaultCard aid = " + str);
        if (!TextUtils.isEmpty(str)) {
            Bundle bundle = new Bundle();
            bundle.putString("param", str);
            I0(3015, bundle);
        }
    }

    private void K0() {
        H0(3021);
    }

    private boolean L0(ud.a aVar) {
        if (C0()) {
            return false;
        }
        return ("9156000014010001".equalsIgnoreCase(aVar.appAid) && !WearPath.TicPay.BEIJING.equals(this.f17566i)) || ("A00000063201010510009156000014A1".equalsIgnoreCase(aVar.appAid) && !WearPath.TicPay.BEIJING.equals(this.f17566i)) || (("535A542E57414C4C45542E454E56".equalsIgnoreCase(aVar.appAid) && !WearPath.TicPay.SHENZHEN.equals(this.f17566i)) || (("D1560001360103000057485401000001".equalsIgnoreCase(aVar.appAid) && !WearPath.TicPay.BEIJING.equals(this.f17566i)) || (("D156000015CCECB8AECDA8BFA8".equalsIgnoreCase(aVar.appAid) && !WearPath.TicPay.BEIJING.equals(this.f17566i)) || (("A00000000386980701".equalsIgnoreCase(aVar.appAid) && !WearPath.TicPay.BEIJING.equals(this.f17566i)) || ("A0000006320101050113581058000000".equalsIgnoreCase(aVar.appAid) && !WearPath.TicPay.BEIJING.equals(this.f17566i))))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0() {
        startActivity(new Intent(getActivity(), AbnormalOrderActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0() {
        if (this.f17561d == null) {
            this.f17561d = new com.mobvoi.companion.ticpay.ui.b(getActivity(), n.f33111a);
        }
        ArrayList arrayList = new ArrayList();
        for (ud.a aVar : this.f17570m) {
            if (aVar.j()) {
                arrayList.add(aVar);
            }
        }
        Collections.sort(arrayList);
        this.f17561d.k(arrayList);
        this.f17561d.j(new b());
        this.f17561d.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(String str) {
        if (this.f17562e == null) {
            ProgressDialog progressDialog = new ProgressDialog(getActivity());
            this.f17562e = progressDialog;
            progressDialog.setCancelable(false);
            this.f17562e.setCanceledOnTouchOutside(false);
        }
        this.f17562e.setMessage(str);
        this.f17562e.show();
    }

    private void P0(ud.a aVar) {
        jc.a aVar2 = new jc.a(getActivity());
        aVar2.i(getString(m.f33053d0));
        aVar2.c(getString(m.f33064h), getString(m.Y0));
        aVar2.d(new d(aVar2, aVar));
        aVar2.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0() {
        jc.a aVar = new jc.a(getActivity());
        aVar.h(m.f33072j1, m.f33069i1);
        aVar.b(getString(m.f33043a));
        aVar.d(new e(this, aVar));
        aVar.show();
    }

    private void R0() {
        k.a("BusCardFragment", "tryChooseDefaultCard");
        HashMap hashMap = new HashMap();
        ud.a aVar = null;
        for (ud.a aVar2 : this.f17570m) {
            if (aVar2.j()) {
                hashMap.put(aVar2.cityLabel, aVar2);
                aVar = aVar == null ? aVar2 : w0(aVar, aVar2);
            }
        }
        int size = hashMap.size();
        if (size != 0) {
            if (size > 1) {
                aVar = (ud.a) hashMap.get(0);
            }
            if (aVar != null) {
                J0(aVar);
            }
        }
    }

    private void S0() {
        if (!TextUtils.isEmpty(this.f17567j) && getActivity() != null) {
            y0();
            androidx.fragment.app.f activity = getActivity();
            if (activity != null && isAdded() && (activity instanceof com.mobvoi.companion.ticpay.ui.c)) {
                ((com.mobvoi.companion.ticpay.ui.c) activity).M(this.f17567j, false);
            }
        }
    }

    private boolean T0(int i10) {
        String wearCapabilities = CompanionSetting.getWearCapabilities();
        List<String> parseCapabilities = CapabilityHelper.parseCapabilities(wearCapabilities);
        String string = this.f17563f.getString(i10);
        k.c("BusCardFragment", "WearCapabilities %s", wearCapabilities);
        boolean contains = parseCapabilities.contains(string);
        if (contains || !this.f17569l.o()) {
            return contains;
        }
        Context context = this.f17563f;
        Toast.makeText(context, "请检查Capability,显示不支持" + string, 1).show();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T p0(Object obj) {
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(ud.a aVar) {
        jc.a aVar2 = new jc.a(getActivity());
        aVar2.i(getString(m.R0, aVar.name));
        aVar2.c(getResources().getString(m.f33064h), getResources().getString(m.f33062g0));
        aVar2.setCancelable(true);
        aVar2.setCanceledOnTouchOutside(false);
        aVar2.d(new c(aVar2, aVar));
        aVar2.show();
    }

    private void r0() {
        ProgressDialog progressDialog = this.f17562e;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f17562e.dismiss();
        }
    }

    private void s0() {
        H0(AMapException.CODE_AMAP_ROUTE_FAIL);
    }

    private void t0() {
        H0(AMapException.CODE_AMAP_OVER_DIRECTION_RANGE);
    }

    private void u0() {
        H0(3300);
    }

    private void v0() {
        String d10 = q.d(com.mobvoi.android.common.utils.b.e(), WearPath.TicPay.PAY, "default_bus_aid", null);
        k.a("BusCardFragment", "default bus card aid = " + d10);
        if (TextUtils.isEmpty(d10)) {
            H0(3017);
            return;
        }
        MessageProxyClient.getInstance().sendMessage(WearPath.TicPay.DEFAULT_BUS_AID, d10.getBytes());
        Iterator<ud.a> it = this.f17570m.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ud.a next = it.next();
            if (d10.equals(next.appAid)) {
                next.isDefault = true;
                break;
            }
        }
        G0();
    }

    private ud.a w0(ud.a aVar, ud.a aVar2) {
        String str = aVar.openDate;
        if (str == null) {
            return aVar2;
        }
        String str2 = aVar2.openDate;
        return (str2 != null && str.compareTo(str2) == -1) ? aVar2 : aVar;
    }

    private void x0() {
        H0(3018);
    }

    private void y0() {
        this.f17560c.setVisibility(8);
        this.f17559b.setVisibility(0);
    }

    private void z0() {
        ud.a aVar = new ud.a("535A542E57414C4C45542E454E56");
        aVar.name = getString(m.Z);
        aVar.ssdAid = "F0000000000191452F02230000000081";
        aVar.cityLabel = "深圳";
        aVar.iconRes = i.f32971l;
        ud.a aVar2 = new ud.a("9156000014010001");
        this.f17572o = aVar2;
        aVar2.name = getString(m.X);
        ud.a aVar3 = this.f17572o;
        aVar3.ssdAid = "F0000000000190777F02010000000081";
        aVar3.cityLabel = "北京";
        aVar3.iconRes = i.f32966g;
        ud.a aVar4 = new ud.a("A00000063201010510009156000014A1");
        this.f17571n = aVar4;
        aVar4.name = getString(m.W);
        ud.a aVar5 = this.f17571n;
        aVar5.ssdAid = "A00000063203000011011000FF000000";
        aVar5.cityLabel = "北京";
        aVar5.iconRes = i.f32965f;
        ud.a aVar6 = new ud.a("D1560001360103000057485401000001");
        aVar6.name = getString(m.f33047b0);
        aVar6.ssdAid = "D1560001360101008888888800000001";
        aVar6.cityLabel = "武汉";
        aVar6.iconRes = i.f32973n;
        ud.a aVar7 = new ud.a("D156000015CCECB8AECDA8BFA8");
        aVar7.name = getString(m.f33044a0);
        aVar7.ssdAid = "D1560001360101008888888800000001";
        aVar7.cityLabel = "成都";
        aVar7.iconRes = i.f32972m;
        ud.a aVar8 = new ud.a("A00000000386980701");
        aVar8.name = getString(m.Y);
        aVar8.ssdAid = "A000000003464D534854534D";
        aVar8.cityLabel = "上海";
        aVar8.iconRes = i.f32969j;
        ud.a aVar9 = new ud.a("A0000006320101050113581058000000");
        aVar9.name = getString(m.f33050c0);
        aVar9.ssdAid = "D1560001360101008888888800000001";
        aVar9.cityLabel = "羊城";
        aVar9.iconRes = i.f32974o;
        sd.b h10 = sd.b.h();
        this.f17569l = h10;
        h10.p();
        this.f17569l.a(this.f17571n);
        this.f17569l.a(this.f17572o);
        this.f17569l.a(aVar);
        this.f17569l.a(aVar6);
        this.f17569l.a(aVar9);
        this.f17570m.add(this.f17571n);
        this.f17570m.add(this.f17572o);
        this.f17570m.add(aVar);
        this.f17570m.add(aVar6);
        this.f17570m.add(aVar9);
        if (!TicwatchModels.TICWATCH2_NFC.equals(CompanionSetting.getWearModel())) {
            this.f17569l.a(aVar8);
            this.f17570m.add(aVar8);
        }
    }

    /*  JADX ERROR: IF instruction can be used only in fallback mode
        jadx.core.utils.exceptions.CodegenException: IF instruction can be used only in fallback mode
        	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:657)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:515)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:243)
        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:174)
        	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:167)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
        	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:266)
        	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:79)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:122)
        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:155)
        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:132)
        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:155)
        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:132)
        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:155)
        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:132)
        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:122)
        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:286)
        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:265)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:270)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0164 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01a5  */
    @Override // com.mobvoi.android.common.utils.s.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleMessage(android.os.Message r11) {
        /*
            Method dump skipped, instructions count: 726
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobvoi.companion.ticpay.ui.a.handleMessage(android.os.Message):void");
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f17563f = com.mobvoi.android.common.utils.b.e();
        z0();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action.ADD_BUS_CARD");
        intentFilter.addAction("action.DELETE_BUS_CARD");
        intentFilter.addAction("action.RECHARGE_SUCCESS");
        b1.a.b(this.f17563f).c(this.f17574q, intentFilter);
        u0();
        qd.e.b().g(this.f17569l.m(), "ticpay_bus_start", null);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.a("BusCardFragment", "onCreateView");
        return layoutInflater.inflate(qd.k.f33033i, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        k.a("BusCardFragment", "onDestroy");
        K0();
        String l10 = this.f17569l.l();
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(l10)) {
            hashMap.put("seid", l10);
        }
        qd.e.b().g(this.f17569l.m(), "ticpay_bus_end", hashMap);
        this.f17569l.q();
        b1.a.b(this.f17563f).e(this.f17574q);
        com.mobvoi.companion.ticpay.ui.b bVar = this.f17561d;
        if (bVar != null) {
            bVar.dismiss();
        }
        r0();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        k.a("BusCardFragment", "onViewCreated");
        RecyclerView recyclerView = (RecyclerView) view.findViewById(j.f32985f);
        this.f17559b = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f17559b.setHasFixedSize(true);
        g gVar = new g(this.f17570m);
        this.f17558a = gVar;
        this.f17559b.setAdapter(gVar);
        this.f17559b.setVisibility(8);
        this.f17560c = view.findViewById(j.G);
    }
}
