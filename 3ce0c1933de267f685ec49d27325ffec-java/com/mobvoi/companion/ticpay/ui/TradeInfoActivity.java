package com.mobvoi.companion.ticpay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.s;
import com.mobvoi.companion.ticpay.buscard.TradeInfo;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import qd.f;
import qd.h;
import qd.j;
import qd.m;
import sd.c;
/* loaded from: classes2.dex */
public class TradeInfoActivity extends c {

    /* renamed from: e  reason: collision with root package name */
    private View f17550e;

    /* renamed from: f  reason: collision with root package name */
    private View f17551f;

    /* renamed from: g  reason: collision with root package name */
    private RecyclerView f17552g;

    /* renamed from: h  reason: collision with root package name */
    private b f17553h;

    /* renamed from: i  reason: collision with root package name */
    private String f17554i;

    /* renamed from: j  reason: collision with root package name */
    private final List<TradeInfo> f17555j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    private s f17556k = new s(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends RecyclerView.Adapter<d> {
        private b() {
        }

        private String c(int i10, int i11) {
            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
            String str = i11 == 0 ? "-" : "+";
            return str + decimalFormat.format(i10 / 100.0d);
        }

        private String d(int i10) {
            if (i10 == 0) {
                return TradeInfoActivity.this.getString(m.f33054d1);
            }
            if (i10 == 1) {
                return TradeInfoActivity.this.getString(m.f33057e1);
            }
            k.a("TradeInfoActivity", "The trade info is not supported yet, type = " + i10);
            return "";
        }

        /* renamed from: e */
        public void onBindViewHolder(d dVar, int i10) {
            dVar.f17626d.setVisibility(8);
            TradeInfo tradeInfo = (TradeInfo) TradeInfoActivity.this.f17555j.get(i10);
            int intTradeType = tradeInfo.intTradeType();
            TextView textView = dVar.f17624b;
            textView.setText(c.n(tradeInfo.getTradeDate()) + " " + c.q(tradeInfo.getTradeTime()));
            dVar.f17623a.setText(d(intTradeType));
            dVar.f17625c.setText(c(tradeInfo.getTradeAmount(), intTradeType));
            dVar.f17625c.setTextColor(intTradeType == 0 ? -49023 : -10757525);
        }

        /* renamed from: f */
        public d onCreateViewHolder(ViewGroup viewGroup, int i10) {
            return new d(LayoutInflater.from(TradeInfoActivity.this.getApplicationContext()).inflate(qd.k.f33040p, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return TradeInfoActivity.this.f17555j.size();
        }
    }

    private void O(List<TradeInfo> list) {
        this.f17550e.setVisibility(8);
        this.f17555j.clear();
        if (list == null || list.isEmpty()) {
            this.f17552g.setVisibility(8);
            this.f17551f.setVisibility(0);
            return;
        }
        for (TradeInfo tradeInfo : list) {
            if (tradeInfo.getTradeAmount() > 0) {
                this.f17555j.add(tradeInfo);
            }
        }
        this.f17553h.notifyDataSetChanged();
        this.f17552g.setVisibility(0);
        this.f17551f.setVisibility(8);
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return qd.k.f33028d;
    }

    @Override // com.mobvoi.companion.ticpay.ui.c, com.mobvoi.android.common.utils.s.a
    public void handleMessage(Message message) {
        if (message.what == 3016) {
            O((List) message.obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.ticpay.ui.c, com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(m.f33051c1);
        this.f17550e = findViewById(j.f32984e0);
        this.f17551f = findViewById(j.E);
        RecyclerView recyclerView = (RecyclerView) findViewById(j.I);
        this.f17552g = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.f17552g.h(new ba.a(0, -3355444, getResources().getDimensionPixelSize(h.f32959c), 0));
        b bVar = new b();
        this.f17553h = bVar;
        this.f17552g.setAdapter(bVar);
        this.f17552g.setVisibility(8);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("card_aid")) {
            this.f17554i = intent.getStringExtra("card_aid");
        }
        if (this.f17554i != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("card_aid", this.f17554i);
            f.q(this.f17556k, 3016, bundle2);
            return;
        }
        throw new IllegalArgumentException("Card aid should not be null.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.ticpay.ui.c, com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        f.g().removeMessages(3016);
        super.onDestroy();
    }
}
