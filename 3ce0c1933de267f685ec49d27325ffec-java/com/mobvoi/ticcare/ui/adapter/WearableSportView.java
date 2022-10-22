package com.mobvoi.ticcare.ui.adapter;

import ak.d;
import ak.g;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.b;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.health.companion.HealthSportDetailsActivity;
import com.mobvoi.health.companion.sport.SportDetailActivity;
import com.mobvoi.health.companion.sport.view.a;
import com.mobvoi.health.companion.system.c;
import com.mobvoi.ticcare.common.model.bean.TicCareDeviceInfo;
import com.mobvoi.ticcare.ui.adapter.WearableSportView;
import com.mobvoi.wear.util.LogCleaner;
import fg.e;
import fg.q;
import fg.u;
import hf.o;
import ik.j;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import pc.f;
/* loaded from: classes2.dex */
public class WearableSportView extends FrameLayout implements e {

    /* renamed from: a  reason: collision with root package name */
    private TextView f20822a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f20823b;

    /* renamed from: c  reason: collision with root package name */
    private a f20824c;

    /* renamed from: d  reason: collision with root package name */
    private Context f20825d;

    /* renamed from: e  reason: collision with root package name */
    TextView f20826e;

    /* renamed from: f  reason: collision with root package name */
    private String f20827f;

    /* renamed from: g  reason: collision with root package name */
    private String f20828g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f20829h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f20830i;

    /* renamed from: j  reason: collision with root package name */
    private Comparator<ug.e> f20831j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f20832k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends BaseQuickAdapter<ug.e, BaseViewHolder> {
        public a(List<ug.e> list) {
            super(ak.e.f234m, list);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(ug.e eVar, View view) {
            c.a().j(WearableSportView.this.f20827f, WearableSportView.this.f20828g, WearableSportView.this.f20829h);
            Context context = view.getContext();
            if (eVar != null) {
                Intent intent = new Intent(context, HealthSportDetailsActivity.class);
                intent.putExtra("sportId", eVar.f35417a);
                intent.putExtra("type", eVar.f35419c);
                intent.putExtra("devicePage", true);
                context.startActivity(intent);
            }
        }

        /* renamed from: d */
        public void convert(BaseViewHolder baseViewHolder, final ug.e eVar) {
            TextView textView = (TextView) baseViewHolder.getView(d.f233z);
            TextView textView2 = (TextView) baseViewHolder.getView(d.f224f);
            ImageView imageView = (ImageView) baseViewHolder.getView(d.C);
            baseViewHolder.getView(d.f230w).setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.ticcare.ui.adapter.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WearableSportView.a.this.e(eVar, view);
                }
            });
            Context context = WearableSportView.this.getContext();
            Resources resources = WearableSportView.this.getResources();
            a.C0219a c10 = com.mobvoi.health.companion.sport.view.a.d().c(eVar.f35419c);
            textView2.setText(resources.getString(u.f26979u4, Long.valueOf(lf.c.c(eVar.f35422f)), resources.getString(c10.f18994c)));
            textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, eVar.f35419c.isAutoSport() ? q.f26576i : 0, 0);
            imageView.setImageDrawable(b.e(context, c10.f18992a));
            imageView.setImageTintList(ColorStateList.valueOf(WearableSportView.this.f20832k ? -16777216 : -1));
            textView.setText(String.format("%1$s - %2$s", zj.d.c(context, eVar.f35420d), zj.d.a(context, eVar.f35421e.getTime())));
        }
    }

    public WearableSportView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void h(View view) {
        this.f20826e = (TextView) view.findViewById(d.L_res_0x7f0b07b1);
        this.f20822a = (TextView) view.findViewById(d.A_res_0x7f0b0694);
        this.f20823b = (RecyclerView) view.findViewById(d.B_res_0x7f0b0696);
        this.f20824c = new a(null);
        this.f20823b.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.f20824c.bindToRecyclerView(this.f20823b);
        this.f20823b.setNestedScrollingEnabled(false);
        f.g().b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int i(ug.e eVar, ug.e eVar2) {
        return -eVar.f35420d.compareTo(eVar2.f35420d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(long j10, long j11, Collection collection, Throwable th2) {
        List<ug.e> arrayList = new ArrayList<>();
        k.h("WearableSportView", " querySportGoal currentSports = " + collection);
        if (collection != null) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                ef.u uVar = (ef.u) it.next();
                k.h("WearableSportView", " querySportGoal summary = " + uVar);
                long j12 = uVar.f25989h;
                long j13 = uVar.f25990i;
                if (j12 >= j10 && j12 < j11) {
                    float c10 = uVar.c();
                    arrayList.add(new ug.e(uVar.f25984c, uVar.f25985d, new Date(j12), new Date(j13), uVar.f25991j, c10 < 0.0f ? 0 : (int) c10));
                }
            }
        }
        Collections.sort(arrayList, this.f20831j);
        if (arrayList.size() > 3) {
            arrayList = arrayList.subList(0, 3);
        }
        l(arrayList);
    }

    private void k() {
        k.h("WearableSportView", " mAccountId = " + this.f20827f);
        k.h("WearableSportView", " currentWwid = " + c.a().a(this.f20825d));
        if (!this.f20830i) {
            this.f20826e.setVisibility(8);
            setNoDataTextView(g.f242m);
            return;
        }
        this.f20826e.setVisibility(0);
        final long b10 = eg.c.b(System.currentTimeMillis());
        final long j10 = b10 + LogCleaner.ONE_DAY;
        yg.f.X().G(new Date(j10), new Date(b10), -1, this.f20828g, new o() { // from class: ik.i
            @Override // hf.o
            public final void a(Object obj, Throwable th2) {
                WearableSportView.this.j(b10, j10, (Collection) obj, th2);
            }
        });
    }

    private void setNoDataTextView(int i10) {
        this.f20822a.setText(i10);
        this.f20822a.setVisibility(0);
        this.f20823b.setVisibility(8);
    }

    public void g() {
        if (this.f20830i) {
            c.a().j(this.f20827f, this.f20828g, this.f20829h);
            SportDetailActivity.R0(this.f20825d, true);
            return;
        }
        Toast.makeText(this.f20825d, g.f242m, 0).show();
    }

    public void l(List<ug.e> list) {
        if (list == null || list.size() == 0) {
            setNoDataTextView(g.f240k);
        } else {
            this.f20823b.setVisibility(0);
            this.f20822a.setVisibility(8);
            this.f20824c.setNewData(list);
        }
        long i10 = f.g().i(this.f20827f);
        this.f20826e.setText(i10 > 0 ? this.f20825d.getString(g.f243n, new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(TimeUnit.SECONDS.toMillis(i10)))) : "");
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        h(LayoutInflater.from(getContext()).inflate(ak.e.l_res_0x7f0e0234, (ViewGroup) this, true));
    }

    @Override // fg.e
    public void setLoadingIndicator(boolean z10) {
        k();
    }

    public void setTiccareDeviceInfo(TicCareDeviceInfo ticCareDeviceInfo) {
        this.f20827f = ticCareDeviceInfo.wwid;
        this.f20828g = ticCareDeviceInfo.accountId;
        this.f20830i = ticCareDeviceInfo.isShowSportData;
        this.f20829h = true;
        k();
    }

    public WearableSportView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f20827f = "";
        this.f20831j = j.f28328a;
        this.f20825d = context;
        this.f20832k = j7.a.f(j7.a.e(this, 16842801, -1));
    }
}
