package com.mobvoi.mcuwatch.badges;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import androidx.fragment.app.w;
import androidx.recyclerview.widget.GridLayoutManager;
import com.cardiex.arty.lite.models.social.Badge;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.mcuwatch.badges.adapter.BadgeAdapter;
import com.mobvoi.mcuwatch.badges.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.i;
import nf.j;
import nf.m;
import qo.l;
import wi.c;
import zh.f;
/* compiled from: BadgesActivity.kt */
/* loaded from: classes2.dex */
public final class BadgesActivity extends c<f> {

    /* renamed from: h  reason: collision with root package name */
    public static final b f19119h = new b(null);

    /* renamed from: e  reason: collision with root package name */
    private c f19122e;

    /* renamed from: f  reason: collision with root package name */
    private BadgeAdapter f19123f;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<wh.a> f19120c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<Badge> f19121d = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private m f19124g = new m();

    /* compiled from: BadgesActivity.kt */
    /* loaded from: classes2.dex */
    /* synthetic */ class a extends FunctionReferenceImpl implements l<LayoutInflater, f> {
        public static final a INSTANCE = new a();

        a() {
            super(1, f.class, "inflate", "inflate(Landroid/view/LayoutInflater;)Lcom/mobvoi/mcuwatch/databinding/ActivityBadgesBinding;", 0);
        }

        /* renamed from: g */
        public final f invoke(LayoutInflater p02) {
            i.f(p02, "p0");
            return f.d(p02);
        }
    }

    /* compiled from: BadgesActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final void a(Context context) {
            i.f(context, "context");
            context.startActivity(new Intent(context, BadgesActivity.class));
        }
    }

    public BadgesActivity() {
        super(a.INSTANCE);
    }

    private final boolean N(String str, String str2, Badge badge) {
        return this.f19120c.add(new wh.a(str, str2, badge.isSeen(), badge.isEarned(), true));
    }

    private final void Q(Badge[] badgeArr) {
        List<Badge> D;
        this.f19120c.clear();
        D = kotlin.collections.i.D(badgeArr);
        String str = "";
        for (Badge badge : D) {
            String category = badge.getCategory();
            String name = badge.getName();
            String str2 = name == null ? "" : name;
            if (category != null) {
                if (!i.b(str, category)) {
                    this.f19120c.add(new wh.a(category, null, false, false, false, 14, null));
                    N(category, str2, badge);
                    str = category;
                } else {
                    N(category, str2, badge);
                }
            }
            if (badge.isEarned() && !badge.isSeen()) {
                this.f19121d.add(badge);
            }
        }
        BadgeAdapter badgeAdapter = this.f19123f;
        if (badgeAdapter != null) {
            badgeAdapter.notifyDataSetChanged();
        } else {
            i.u("adapter");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(BadgesActivity this$0, Badge[] data) {
        i.f(this$0, "this$0");
        i.f(data, "data");
        this$0.hideLoading();
        if (!(data.length == 0)) {
            k.a("BadgesActivity", i.n("badges:", Integer.valueOf(data.length)));
            this$0.Q(data);
            this$0.X();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(BadgesActivity this$0, Boolean data) {
        i.f(this$0, "this$0");
        i.e(data, "data");
        if (data.booleanValue()) {
            this$0.hideLoading();
            this$0.J(sh.k.f34798f0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int V(BadgesActivity this$0, GridLayoutManager gridLayoutManager, int i10) {
        i.f(this$0, "this$0");
        BadgeAdapter badgeAdapter = this$0.f19123f;
        if (badgeAdapter == null) {
            i.u("adapter");
            throw null;
        } else if (badgeAdapter.getItemViewType(i10) == 0) {
            return gridLayoutManager.W2();
        } else {
            return 1;
        }
    }

    private final void X() {
        if (this.f19121d.size() > 0) {
            Badge badge = this.f19121d.get(0);
            i.e(badge, "badgesNeedToShow[0]");
            Badge badge2 = badge;
            if (!TextUtils.isEmpty(badge2.getCategory()) && !TextUtils.isEmpty(badge2.getName())) {
                c.a aVar = c.f19127a;
                String category = badge2.getCategory();
                i.d(category);
                String name = badge2.getName();
                i.d(name);
                String id2 = badge2.getId();
                i.d(id2);
                this.f19122e = aVar.a(category, name, id2);
                w u10 = getSupportFragmentManager().l().u(sh.a.f34429b, sh.a.f34428a);
                c cVar = this.f19122e;
                i.d(cVar);
                u10.b(16908290, cVar).j();
                this.f19121d.remove(0);
            }
        }
    }

    public final void O() {
        c cVar = this.f19122e;
        if (cVar != null) {
            getSupportFragmentManager().l().r(cVar).j();
        }
    }

    public final void S() {
        this.f19124g.clear();
        m mVar = this.f19124g;
        ad.a aVar = ad.a.f168a;
        mVar.a(j.b(aVar.d(), new j.a() { // from class: com.mobvoi.mcuwatch.badges.f
            @Override // nf.j.a
            public final void call(Object obj) {
                BadgesActivity.T(BadgesActivity.this, (Badge[]) obj);
            }
        }));
        this.f19124g.a(j.b(aVar.h(), new j.a() { // from class: com.mobvoi.mcuwatch.badges.e
            @Override // nf.j.a
            public final void call(Object obj) {
                BadgesActivity.U(BadgesActivity.this, (Boolean) obj);
            }
        }));
        showLoading("");
        aVar.c();
    }

    public final void W() {
        O();
        X();
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return sh.i.k_res_0x7f0e0029;
    }

    public final void initView() {
        setTitle(getString(sh.k.P));
        BadgeAdapter badgeAdapter = new BadgeAdapter(this.f19120c);
        this.f19123f = badgeAdapter;
        badgeAdapter.bindToRecyclerView(H().f37534b);
        BadgeAdapter badgeAdapter2 = this.f19123f;
        if (badgeAdapter2 != null) {
            badgeAdapter2.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() { // from class: com.mobvoi.mcuwatch.badges.d
                @Override // com.chad.library.adapter.base.BaseQuickAdapter.SpanSizeLookup
                public final int getSpanSize(GridLayoutManager gridLayoutManager, int i10) {
                    int V;
                    V = BadgesActivity.V(BadgesActivity.this, gridLayoutManager, i10);
                    return V;
                }
            });
        } else {
            i.u("adapter");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        S();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        hideLoading();
        super.onDestroy();
        if (!this.f19124g.d()) {
            this.f19124g.clear();
        }
    }
}
