package com.mobvoi.companion.ticpay.ui;

import android.app.Application;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.com.fmsh.tsm.business.enums.EnumOrderStatus;
import com.mobvoi.android.common.utils.s;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import jc.a;
import qd.f;
import qd.h;
import qd.j;
import qd.k;
import qd.m;
/* loaded from: classes2.dex */
public class AbnormalOrderActivity extends com.mobvoi.companion.ticpay.ui.c {

    /* renamed from: e  reason: collision with root package name */
    private View f17434e;

    /* renamed from: f  reason: collision with root package name */
    private View f17435f;

    /* renamed from: g  reason: collision with root package name */
    private RecyclerView f17436g;

    /* renamed from: h  reason: collision with root package name */
    private d f17437h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f17438i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f17439j;

    /* renamed from: k  reason: collision with root package name */
    private final List<sd.a> f17440k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    private s f17441l = new s(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements a.AbstractC0354a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ jc.a f17442a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f17443b;

        a(jc.a aVar, String str) {
            this.f17442a = aVar;
            this.f17443b = str;
        }

        @Override // jc.a.AbstractC0354a
        public void a() {
            this.f17442a.dismiss();
            ud.d.a(AbnormalOrderActivity.this.getApplicationContext(), this.f17443b);
        }

        @Override // jc.a.AbstractC0354a
        public void onCancel() {
            this.f17442a.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17445a;

        static {
            int[] iArr = new int[EnumOrderStatus.values().length];
            f17445a = iArr;
            try {
                iArr[EnumOrderStatus.hasPaid.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17445a[EnumOrderStatus.success.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17445a[EnumOrderStatus.failure.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17445a[EnumOrderStatus.unsettled.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17445a[EnumOrderStatus.apilyForRefund.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17445a[EnumOrderStatus.hasRefunded.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17445a[EnumOrderStatus.refundFailure.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f17445a[EnumOrderStatus.payFailure.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f17445a[EnumOrderStatus.recharging.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f17445a[EnumOrderStatus.dubious.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f17445a[EnumOrderStatus.invalid.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f17445a[EnumOrderStatus.unknown.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* loaded from: classes2.dex */
    static class c extends RecyclerView.b0 {
        public c(View view) {
            super(view);
            TextView textView = (TextView) view;
            textView.setGravity(17);
            textView.setTextColor(-921103);
            textView.setText(m.V);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d extends RecyclerView.Adapter<RecyclerView.b0> {

        /* loaded from: classes2.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AbnormalOrderActivity.this.W();
            }
        }

        /* loaded from: classes2.dex */
        class b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ sd.a f17448a;

            b(sd.a aVar) {
                this.f17448a = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!d.this.h(this.f17448a) && !this.f17448a.a()) {
                    Toast.makeText(view.getContext(), m.R, 1).show();
                } else if (!this.f17448a.a()) {
                    sd.b h10 = sd.b.h();
                    ud.a i10 = h10.i(this.f17448a.f34378a);
                    if (i10 != null) {
                        if (!i10.j() && this.f17448a.f34385h == 2) {
                            Toast.makeText(AbnormalOrderActivity.this.getApplicationContext(), AbnormalOrderActivity.this.getString(m.L0, new Object[]{i10.b()}), 0).show();
                        } else if (!i10.j() && this.f17448a.f34385h == 1 && "9156000014010001".equalsIgnoreCase(i10.appAid) && h10.i("A00000063201010510009156000014A1") != null) {
                            Toast.makeText(AbnormalOrderActivity.this.getApplicationContext(), AbnormalOrderActivity.this.getString(m.f33078l1), 0).show();
                        } else if (6 == this.f17448a.f34385h) {
                            Toast.makeText(AbnormalOrderActivity.this, m.f33046b, 1).show();
                        } else {
                            Intent intent = new Intent(AbnormalOrderActivity.this, BusCardOperateActivity.class);
                            intent.putExtra("card_aid", this.f17448a.f34378a);
                            intent.putExtra("order_id", this.f17448a.f34380c);
                            intent.putExtra("order_type", this.f17448a.f34385h);
                            intent.putExtra("pay_money", this.f17448a.f34382e);
                            intent.putExtra("order_money", this.f17448a.f34383f);
                            intent.putExtra("pay_way", this.f17448a.f34384g);
                            intent.putExtra("order_time", this.f17448a.f34381d);
                            intent.putExtra("unsettled_order", this.f17448a.f34386i);
                            intent.putExtra("abnormal_order", true);
                            AbnormalOrderActivity.this.startActivity(intent);
                            AbnormalOrderActivity.this.finish();
                        }
                    }
                } else if (!TextUtils.isEmpty(this.f17448a.f34390m)) {
                    AbnormalOrderActivity.this.b0(this.f17448a);
                } else {
                    AbnormalOrderActivity.this.Z(this.f17448a);
                }
            }
        }

        private d() {
        }

        private String d(int i10, EnumOrderStatus enumOrderStatus) {
            Application e10 = com.mobvoi.android.common.utils.b.e();
            String g10 = g(enumOrderStatus);
            return e10.getString(m.f33086o0, new DecimalFormat("#0.00").format(i10 / 100.0d), g10);
        }

        private String e(String str) {
            return com.mobvoi.android.common.utils.b.e().getString(m.f33080m0, str);
        }

        private String f(String str, int i10) {
            return str + sd.c.e(i10);
        }

        private String g(EnumOrderStatus enumOrderStatus) {
            int i10;
            switch (b.f17445a[enumOrderStatus.ordinal()]) {
                case 1:
                    i10 = m.f33094r0;
                    break;
                case 2:
                    i10 = m.f33106x0;
                    break;
                case 3:
                    i10 = m.f33077l0;
                    break;
                case 4:
                    i10 = m.C0;
                    break;
                case 5:
                    i10 = m.f33071j0;
                    break;
                case 6:
                    i10 = m.f33100u0;
                    break;
                case 7:
                    i10 = m.f33098t0;
                    break;
                case 8:
                    i10 = m.f33089p0;
                    break;
                case 9:
                    i10 = m.f33096s0;
                    break;
                case 10:
                    i10 = m.f33074k0;
                    break;
                case 11:
                    i10 = m.f33083n0;
                    break;
                case 12:
                    i10 = m.f33073k;
                    break;
                default:
                    i10 = m.f33073k;
                    break;
            }
            return com.mobvoi.android.common.utils.b.e().getString(i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean h(sd.a aVar) {
            EnumOrderStatus enumOrderStatus = aVar.f34388k;
            return enumOrderStatus == null || enumOrderStatus == EnumOrderStatus.failure || enumOrderStatus == EnumOrderStatus.unsettled;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return AbnormalOrderActivity.this.f17439j ? AbnormalOrderActivity.this.f17440k.size() + 1 : AbnormalOrderActivity.this.f17440k.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i10) {
            return i10 < AbnormalOrderActivity.this.f17440k.size() ? 0 : 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.b0 b0Var, int i10) {
            if (b0Var instanceof c) {
                b0Var.itemView.setOnClickListener(new a());
                return;
            }
            com.mobvoi.companion.ticpay.ui.d dVar = (com.mobvoi.companion.ticpay.ui.d) b0Var;
            Application e10 = com.mobvoi.android.common.utils.b.e();
            sd.a aVar = (sd.a) AbnormalOrderActivity.this.f17440k.get(i10);
            dVar.f17624b.setText(e10.getString(m.f33108y0, aVar.f34381d));
            if (AbnormalOrderActivity.this.f17438i) {
                dVar.f17623a.setText(e(aVar.f34380c));
                dVar.f17626d.setVisibility(8);
                dVar.f17625c.setVisibility(0);
                dVar.f17625c.setTextSize(2, 15.0f);
                dVar.f17625c.setTextColor(-921103);
                dVar.f17625c.setText(d(aVar.f34383f, aVar.f34388k));
            } else {
                dVar.f17623a.setText(f(aVar.f34379b, aVar.f34385h));
                dVar.f17625c.setText("");
                dVar.f17625c.setVisibility(8);
                dVar.f17625c.setTextSize(2, 17.0f);
                dVar.f17625c.setTextColor(-10757525);
                dVar.f17626d.setVisibility(0);
            }
            dVar.itemView.setOnClickListener(new b(aVar));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.b0 onCreateViewHolder(ViewGroup viewGroup, int i10) {
            if (i10 == 0) {
                return new com.mobvoi.companion.ticpay.ui.d(LayoutInflater.from(AbnormalOrderActivity.this.getApplicationContext()).inflate(k.f33040p, viewGroup, false));
            }
            return new c(LayoutInflater.from(AbnormalOrderActivity.this.getApplicationContext()).inflate(17367043, viewGroup, false));
        }

        /* synthetic */ d(AbnormalOrderActivity abnormalOrderActivity, a aVar) {
            this();
        }
    }

    private String V(String str) {
        return (!TextUtils.isEmpty(str) && str.length() > 6) ? str.substring(str.length() - 6) : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        this.f17439j = false;
        this.f17437h.notifyItemRangeRemoved(this.f17440k.size(), 1);
        a0(this.f17440k.size());
    }

    private void X(List<sd.a> list) {
        int size = list.size();
        if (this.f17438i) {
            this.f17439j = size >= 10;
            if (size == 0) {
                Toast.makeText(this, m.f33059f0, 0).show();
            }
        }
        this.f17434e.setVisibility(8);
        int size2 = this.f17440k.size();
        this.f17440k.addAll(list);
        this.f17437h.notifyItemRangeInserted(size2, size);
        if (this.f17440k.isEmpty()) {
            this.f17436g.setVisibility(8);
            this.f17435f.setVisibility(0);
            return;
        }
        this.f17436g.setVisibility(0);
        this.f17435f.setVisibility(8);
    }

    private void Y(cn.com.fmsh.tsm.business.bean.b bVar) {
        if (bVar == null) {
            Toast.makeText(this, m.O, 1).show();
            return;
        }
        String valueOf = String.valueOf(x2.c.g(bVar.a()));
        String b10 = bVar.b();
        for (sd.a aVar : this.f17440k) {
            if (aVar.f34380c.equals(valueOf)) {
                aVar.f34390m = b10;
                b0(aVar);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(sd.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putString("order_id", aVar.f34380c);
        f.q(this.f17441l, 3025, bundle);
        Toast.makeText(this, m.f33070j, 0).show();
    }

    private void a0(int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt("param", i10);
        f.q(this.f17441l, 3024, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(sd.a aVar) {
        jc.a aVar2 = new jc.a(this);
        Resources resources = getResources();
        String string = resources.getString(m.Q, V(aVar.f34380c), aVar.f34390m);
        TextView textView = new TextView(this);
        textView.setText(string);
        textView.setTextColor(-12303292);
        textView.setTextSize(2, 18.0f);
        aVar2.e(textView);
        aVar2.c(null, resources.getString(m.D));
        aVar2.setCancelable(true);
        aVar2.setCanceledOnTouchOutside(false);
        aVar2.d(new a(aVar2, string));
        aVar2.show();
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return k.f33028d;
    }

    @Override // com.mobvoi.companion.ticpay.ui.c, com.mobvoi.android.common.utils.s.a
    public void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 3013) {
            X((List) message.obj);
        } else if (i10 == 3024) {
            X((List) message.obj);
        } else if (i10 == 3025) {
            Y((cn.com.fmsh.tsm.business.bean.b) message.obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.ticpay.ui.c, com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.f17438i = intent.getBooleanExtra("charge_record", false);
        }
        this.f17434e = findViewById(j.f32984e0);
        this.f17435f = findViewById(j.E);
        RecyclerView recyclerView = (RecyclerView) findViewById(j.I);
        this.f17436g = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.f17436g.h(new ba.a(0, -3355444, getResources().getDimensionPixelSize(h.f32959c), 0));
        d dVar = new d(this, null);
        this.f17437h = dVar;
        this.f17436g.setAdapter(dVar);
        this.f17436g.setVisibility(8);
        if (this.f17438i) {
            setTitle(m.C);
            findViewById(j.f33023y).setVisibility(0);
            a0(0);
            return;
        }
        setTitle(m.f33048b1);
        f.q(this.f17441l, 3013, null);
    }
}
