package com.mobvoi.mcuwatch.artyfeed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cardiex.arty.lite.models.Pageable;
import com.cardiex.arty.lite.models.coach.Insight;
import com.cardiex.arty.lite.models.social.Badge;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.health.companion.base.HealthDetailCalendarActivity;
import com.mobvoi.mcuwatch.artyfeed.adapter.ArtyFeedAdapter;
import com.mobvoi.mcuwatch.badges.BadgesActivity;
import io.d;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import nf.j;
import nf.m;
import qo.l;
import sh.h;
import zh.e;
/* compiled from: ArtyFeedActivity.kt */
/* loaded from: classes2.dex */
public final class ArtyFeedActivity extends wi.c<e> implements View.OnClickListener {

    /* renamed from: n  reason: collision with root package name */
    public static final b f19101n = new b(null);

    /* renamed from: c  reason: collision with root package name */
    private final d f19102c;

    /* renamed from: d  reason: collision with root package name */
    private long f19103d;

    /* renamed from: f  reason: collision with root package name */
    private ArtyFeedAdapter f19105f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f19106g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f19107h;

    /* renamed from: i  reason: collision with root package name */
    private int f19108i;

    /* renamed from: k  reason: collision with root package name */
    private boolean f19110k;

    /* renamed from: m  reason: collision with root package name */
    private MenuItem f19112m;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<vh.a> f19104e = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    private final int f19109j = 10;

    /* renamed from: l  reason: collision with root package name */
    private m f19111l = new m();

    /* compiled from: ArtyFeedActivity.kt */
    /* loaded from: classes2.dex */
    /* synthetic */ class a extends FunctionReferenceImpl implements l<LayoutInflater, e> {
        public static final a INSTANCE = new a();

        a() {
            super(1, e.class, "inflate", "inflate(Landroid/view/LayoutInflater;)Lcom/mobvoi/mcuwatch/databinding/ActivityArtyFeedBinding;", 0);
        }

        /* renamed from: g */
        public final e invoke(LayoutInflater p02) {
            i.f(p02, "p0");
            return e.d(p02);
        }
    }

    /* compiled from: ArtyFeedActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }

        public final void a(Context context) {
            i.f(context, "context");
            context.startActivity(new Intent(context, ArtyFeedActivity.class));
        }
    }

    /* compiled from: ArtyFeedActivity.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements qo.a<ArtyFeedActivity> {
        c() {
            super(0);
        }

        /* renamed from: a */
        public final ArtyFeedActivity invoke() {
            return ArtyFeedActivity.this;
        }
    }

    public ArtyFeedActivity() {
        super(a.INSTANCE);
        d a10;
        a10 = io.f.a(new c());
        this.f19102c = a10;
    }

    private final void Q(boolean z10) {
        if (!this.f19110k) {
            this.f19110k = true;
            if (z10) {
                this.f19108i = 0;
                ArtyFeedAdapter artyFeedAdapter = this.f19105f;
                if (artyFeedAdapter != null) {
                    artyFeedAdapter.setEnableLoadMore(true);
                    H().f37532c.setRefreshing(true);
                    this.f19104e.clear();
                    ArtyFeedAdapter artyFeedAdapter2 = this.f19105f;
                    if (artyFeedAdapter2 != null) {
                        artyFeedAdapter2.notifyDataSetChanged();
                        c0();
                    } else {
                        i.u("adapter");
                        throw null;
                    }
                } else {
                    i.u("adapter");
                    throw null;
                }
            } else {
                this.f19108i++;
            }
            ad.a.f168a.f(new Pageable(this.f19108i, this.f19109j, "asc"), new Date(this.f19103d));
        }
    }

    private final ArtyFeedActivity S() {
        return (ArtyFeedActivity) this.f19102c.getValue();
    }

    private final void T(Badge[] badgeArr) {
        List D;
        boolean z10;
        D = kotlin.collections.i.D(badgeArr);
        Iterator it = D.iterator();
        while (true) {
            if (!it.hasNext()) {
                z10 = false;
                break;
            }
            Badge badge = (Badge) it.next();
            if (badge.isEarned() && !badge.isSeen()) {
                z10 = true;
                break;
            }
        }
        if (z10) {
            MenuItem menuItem = this.f19112m;
            if (menuItem != null) {
                menuItem.setIcon(getDrawable(sh.f.H0));
            } else {
                i.u("mMenuItem");
                throw null;
            }
        }
    }

    private final void U(Insight[] insightArr) {
        List<Insight> D;
        if (insightArr.length == 0) {
            ArtyFeedAdapter artyFeedAdapter = this.f19105f;
            if (artyFeedAdapter != null) {
                artyFeedAdapter.setEnableLoadMore(false);
            } else {
                i.u("adapter");
                throw null;
            }
        } else {
            if (insightArr.length < this.f19109j) {
                ArtyFeedAdapter artyFeedAdapter2 = this.f19105f;
                if (artyFeedAdapter2 != null) {
                    artyFeedAdapter2.setEnableLoadMore(false);
                } else {
                    i.u("adapter");
                    throw null;
                }
            }
            D = kotlin.collections.i.D(insightArr);
            for (Insight insight : D) {
                this.f19104e.add(new vh.a(insight.getAdvice(), insight.getArticle(), insight.getBadgeSummary(), insight.getTimestamp(), insight.getType()));
            }
            ArtyFeedAdapter artyFeedAdapter3 = this.f19105f;
            if (artyFeedAdapter3 != null) {
                artyFeedAdapter3.notifyDataSetChanged();
            } else {
                i.u("adapter");
                throw null;
            }
        }
    }

    private final void V() {
        this.f19110k = false;
        if (H().f37532c.i()) {
            H().f37532c.setRefreshing(false);
        }
    }

    private final void W() {
        this.f19111l.clear();
        m mVar = this.f19111l;
        ad.a aVar = ad.a.f168a;
        mVar.a(j.b(aVar.d(), new j.a() { // from class: com.mobvoi.mcuwatch.artyfeed.e
            @Override // nf.j.a
            public final void call(Object obj) {
                ArtyFeedActivity.X(ArtyFeedActivity.this, (Badge[]) obj);
            }
        }));
        this.f19111l.a(j.b(aVar.i(), new j.a() { // from class: com.mobvoi.mcuwatch.artyfeed.c
            @Override // nf.j.a
            public final void call(Object obj) {
                ArtyFeedActivity.Y(ArtyFeedActivity.this, (Boolean) obj);
            }
        }));
        this.f19111l.a(j.b(aVar.g(), new j.a() { // from class: com.mobvoi.mcuwatch.artyfeed.d
            @Override // nf.j.a
            public final void call(Object obj) {
                ArtyFeedActivity.Z(ArtyFeedActivity.this, (Insight[]) obj);
            }
        }));
        this.f19103d = eg.c.a(System.currentTimeMillis()).getTimeInMillis();
        d0();
        Q(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(ArtyFeedActivity this$0, Badge[] data) {
        i.f(this$0, "this$0");
        i.f(data, "data");
        if (!(data.length == 0)) {
            k.a("BadgesActivity", i.n("badges:", Integer.valueOf(data.length)));
            this$0.T(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(ArtyFeedActivity this$0, Boolean data) {
        i.f(this$0, "this$0");
        i.e(data, "data");
        if (data.booleanValue()) {
            ArtyFeedAdapter artyFeedAdapter = this$0.f19105f;
            if (artyFeedAdapter != null) {
                artyFeedAdapter.loadMoreFail();
                this$0.V();
                this$0.J(sh.k.f34798f0);
                return;
            }
            i.u("adapter");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(ArtyFeedActivity this$0, Insight[] data) {
        i.f(this$0, "this$0");
        k.a("ArtyFeedActivity", i.n("insights:", Integer.valueOf(data.length)));
        i.e(data, "data");
        this$0.U(data);
        this$0.V();
        ArtyFeedAdapter artyFeedAdapter = this$0.f19105f;
        if (artyFeedAdapter != null) {
            artyFeedAdapter.loadMoreComplete();
        } else {
            i.u("adapter");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(ArtyFeedActivity this$0) {
        i.f(this$0, "this$0");
        this$0.Q(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(ArtyFeedActivity this$0) {
        i.f(this$0, "this$0");
        this$0.Q(false);
    }

    private final void c0() {
        ad.a.f168a.m(new Date(this.f19103d));
    }

    private final void d0() {
        TextView textView = this.f19106g;
        if (textView != null) {
            textView.setText(DateFormat.format(getString(sh.k.f34787d0), this.f19103d).toString());
        } else {
            i.u("dateTv");
            throw null;
        }
    }

    private final void initView() {
        setTitle(getString(sh.k.A_res_0x7f14010a));
        H().f37532c.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.mobvoi.mcuwatch.artyfeed.a
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
            public final void y() {
                ArtyFeedActivity.a0(ArtyFeedActivity.this);
            }
        });
        H().f37531b.setLayoutManager(new LinearLayoutManager(S()));
        ArtyFeedAdapter artyFeedAdapter = new ArtyFeedAdapter(S(), this.f19104e);
        this.f19105f = artyFeedAdapter;
        artyFeedAdapter.bindToRecyclerView(H().f37531b);
        View inflate = LayoutInflater.from(S()).inflate(sh.i.f34761w0, (ViewGroup) null);
        ArtyFeedAdapter artyFeedAdapter2 = this.f19105f;
        if (artyFeedAdapter2 != null) {
            artyFeedAdapter2.addHeaderView(inflate);
            View findViewById = inflate.findViewById(h.K0);
            i.e(findViewById, "headView.findViewById(R.id.date_tv)");
            this.f19106g = (TextView) findViewById;
            View findViewById2 = inflate.findViewById(h.f34677p0);
            i.e(findViewById2, "headView.findViewById(R.id.calendar_select_icon)");
            ImageView imageView = (ImageView) findViewById2;
            this.f19107h = imageView;
            if (imageView != null) {
                imageView.setOnClickListener(S());
                ArtyFeedAdapter artyFeedAdapter3 = this.f19105f;
                if (artyFeedAdapter3 != null) {
                    artyFeedAdapter3.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.mobvoi.mcuwatch.artyfeed.b
                        @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
                        public final void onLoadMoreRequested() {
                            ArtyFeedActivity.b0(ArtyFeedActivity.this);
                        }
                    }, H().f37531b);
                } else {
                    i.u("adapter");
                    throw null;
                }
            } else {
                i.u("calendarSelectIcon");
                throw null;
            }
        } else {
            i.u("adapter");
            throw null;
        }
    }

    public static final void start(Context context) {
        f19101n.a(context);
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return sh.i.i_res_0x7f0e0027;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i11 == -1 && intent != null) {
            long longExtra = intent.getLongExtra("monthDate", -1L);
            if (this.f19103d != longExtra) {
                this.f19103d = longExtra;
                d0();
                Q(true);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        int i10 = h.f34677p0;
        if (valueOf != null && valueOf.intValue() == i10) {
            Intent intent = new Intent(S(), HealthDetailCalendarActivity.class);
            intent.putExtra("data_type", 11);
            intent.putExtra("date_mills", this.f19103d);
            startActivityForResult(intent, 10001);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        W();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        i.f(menu, "menu");
        getMenuInflater().inflate(sh.j.b_res_0x7f0f000b, menu);
        MenuItem findItem = menu.findItem(h.f34645h2);
        i.e(findItem, "menu.findItem(R.id.menu_badges)");
        this.f19112m = findItem;
        return super.onCreateOptionsMenu(menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (!this.f19111l.d()) {
            this.f19111l.clear();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        i.f(item, "item");
        if (item.getItemId() != h.f34645h2) {
            return super.onOptionsItemSelected(item);
        }
        BadgesActivity.f19119h.a(S());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        ad.a.f168a.c();
    }
}
