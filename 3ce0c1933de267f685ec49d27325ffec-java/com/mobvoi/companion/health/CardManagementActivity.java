package com.mobvoi.companion.health;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.c;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.mobvoi.companion.R;
import com.mobvoi.companion.health.CardManagementActivity;
import com.mobvoi.companion.health.viewholder.k;
import io.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import tc.j;
import tc.l;
import tc.m;
/* compiled from: CardManagementActivity.kt */
/* loaded from: classes2.dex */
public final class CardManagementActivity extends n1 {

    /* renamed from: d  reason: collision with root package name */
    private oc.a f16681d;

    /* renamed from: f  reason: collision with root package name */
    private final d f16683f;

    /* renamed from: h  reason: collision with root package name */
    private boolean f16685h;

    /* renamed from: j  reason: collision with root package name */
    public sc.b f16687j;

    /* renamed from: k  reason: collision with root package name */
    public List<k> f16688k;

    /* renamed from: l  reason: collision with root package name */
    public List<k> f16689l;

    /* renamed from: m  reason: collision with root package name */
    public g f16690m;

    /* renamed from: n  reason: collision with root package name */
    public n f16691n;

    /* renamed from: o  reason: collision with root package name */
    public u f16692o;

    /* renamed from: p  reason: collision with root package name */
    public RecyclerView.n f16693p;

    /* renamed from: e  reason: collision with root package name */
    private final dq.b f16682e = new dq.b();

    /* renamed from: g  reason: collision with root package name */
    private String f16684g = "";

    /* renamed from: i  reason: collision with root package name */
    private boolean f16686i = true;

    /* compiled from: CardManagementActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: CardManagementActivity.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements qo.a<c> {
        b() {
            super(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(CardManagementActivity this$0, DialogInterface dialogInterface, int i10) {
            i.f(this$0, "this$0");
            dialogInterface.dismiss();
            this$0.finish();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(CardManagementActivity this$0, DialogInterface dialogInterface, int i10) {
            i.f(this$0, "this$0");
            dialogInterface.dismiss();
            ArrayList arrayList = new ArrayList();
            for (k kVar : this$0.a0()) {
                String c10 = kVar.c();
                if (c10 != null) {
                    arrayList.add(c10);
                }
            }
            this$0.j0(arrayList);
        }

        /* renamed from: c */
        public final c invoke() {
            k7.b y10 = new k7.b(CardManagementActivity.this).h(R.string.home_tab_card_mgr_confirm_text).d(false);
            int i10 = R.string.common_no;
            final CardManagementActivity cardManagementActivity = CardManagementActivity.this;
            k7.b E = y10.j(i10, new DialogInterface.OnClickListener() { // from class: com.mobvoi.companion.health.h
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i11) {
                    CardManagementActivity.b.d(CardManagementActivity.this, dialogInterface, i11);
                }
            });
            int i11 = R.string.common_yes;
            final CardManagementActivity cardManagementActivity2 = CardManagementActivity.this;
            c a10 = E.m(i11, new DialogInterface.OnClickListener() { // from class: com.mobvoi.companion.health.i
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i12) {
                    CardManagementActivity.b.g(CardManagementActivity.this, dialogInterface, i12);
                }
            }).a();
            i.e(a10, "MaterialAlertDialogBuilder(this)\n            .setMessage(R.string.home_tab_card_mgr_confirm_text)\n            .setCancelable(false)\n            .setNegativeButton(R.string.common_no){ dialog, which ->\n                dialog.dismiss()\n                finish()\n            }\n            .setPositiveButton(R.string.common_yes) { dialog, which ->\n                dialog.dismiss()\n                val cardTypeList = ArrayList<String>()\n                for (vpaCard in cardsAddedList) {\n                    vpaCard.card?.let {\n                        cardTypeList.add(it)\n                    }\n                }\n                updateCardsList(cardTypeList)\n            }.create()");
            return a10;
        }
    }

    static {
        new a(null);
    }

    public CardManagementActivity() {
        d a10;
        a10 = io.f.a(new b());
        this.f16683f = a10;
    }

    private final void U() {
        this.f16685h = true;
        boolean c10 = yd.b.c(this);
        sc.b c02 = c0();
        String x10 = ta.a.x();
        i.e(x10, "getWwid()");
        this.f16682e.a(c02.a(x10, c10).Z(cq.a.c()).H(xp.a.b()).r(new yp.a() { // from class: com.mobvoi.companion.health.c
            @Override // yp.a
            public final void call() {
                CardManagementActivity.X(CardManagementActivity.this);
            }
        }).Y(new yp.b() { // from class: com.mobvoi.companion.health.e
            @Override // yp.b
            public final void call(Object obj) {
                CardManagementActivity.V(CardManagementActivity.this, (m) obj);
            }
        }, new yp.b() { // from class: com.mobvoi.companion.health.f
            @Override // yp.b
            public final void call(Object obj) {
                CardManagementActivity.W(CardManagementActivity.this, (Throwable) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(CardManagementActivity this$0, m mVar) {
        k kVar;
        k kVar2;
        i.f(this$0, "this$0");
        if (mVar != null && mVar.a()) {
            this$0.f16686i = true;
            this$0.invalidateOptionsMenu();
            oc.a aVar = this$0.f16681d;
            if (aVar != null) {
                aVar.f31495e.setVisibility(8);
                oc.a aVar2 = this$0.f16681d;
                if (aVar2 != null) {
                    aVar2.f31494d.setVisibility(8);
                    oc.a aVar3 = this$0.f16681d;
                    if (aVar3 != null) {
                        aVar3.f31493c.setVisibility(0);
                        l b10 = mVar.b();
                        if (b10 != null) {
                            List<tc.k> a10 = b10.a();
                            if (a10 != null) {
                                StringBuilder sb2 = new StringBuilder();
                                for (tc.k kVar3 : a10) {
                                    String a11 = kVar3.a();
                                    if (!(a11 == null || (kVar2 = com.mobvoi.companion.health.viewholder.l.a().get(com.mobvoi.companion.health.viewholder.l.b().get(a11))) == null)) {
                                        k b11 = k.b(kVar2, (byte) 0, 0, null, null, false, 31, null);
                                        b11.h(kVar3.b());
                                        b11.g(kVar3.a());
                                        b11.i(true);
                                        this$0.a0().add(b11);
                                        sb2.append(b11.c());
                                    }
                                }
                                this$0.f16684g = sb2.toString();
                            }
                            List<tc.k> b12 = b10.b();
                            if (b12 != null) {
                                for (tc.k kVar4 : b12) {
                                    String a12 = kVar4.a();
                                    if (!(a12 == null || (kVar = com.mobvoi.companion.health.viewholder.l.a().get(com.mobvoi.companion.health.viewholder.l.b().get(a12))) == null)) {
                                        k b13 = k.b(kVar, (byte) 0, 0, null, null, false, 31, null);
                                        b13.h(kVar4.b());
                                        b13.g(kVar4.a());
                                        Boolean c10 = kVar4.c();
                                        b13.i(c10 == null ? false : c10.booleanValue());
                                        this$0.b0().add(b13);
                                    }
                                }
                            }
                            oc.a aVar4 = this$0.f16681d;
                            if (aVar4 != null) {
                                RecyclerView.Adapter adapter = aVar4.f31492b.getAdapter();
                                if (adapter != null) {
                                    adapter.notifyDataSetChanged();
                                }
                                oc.a aVar5 = this$0.f16681d;
                                if (aVar5 != null) {
                                    SwipeRefreshLayout swipeRefreshLayout = aVar5.f31493c;
                                    swipeRefreshLayout.setRefreshing(false);
                                    swipeRefreshLayout.setEnabled(false);
                                    return;
                                }
                                i.u("viewBinding");
                                throw null;
                            }
                            i.u("viewBinding");
                            throw null;
                        }
                        return;
                    }
                    i.u("viewBinding");
                    throw null;
                }
                i.u("viewBinding");
                throw null;
            }
            i.u("viewBinding");
            throw null;
        }
        this$0.h0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(CardManagementActivity this$0, Throwable th2) {
        i.f(this$0, "this$0");
        com.mobvoi.android.common.utils.k.d("CardManagementActivity", th2.getMessage());
        oc.a aVar = this$0.f16681d;
        if (aVar != null) {
            SwipeRefreshLayout swipeRefreshLayout = aVar.f31493c;
            swipeRefreshLayout.setRefreshing(false);
            swipeRefreshLayout.setEnabled(false);
            this$0.h0();
            return;
        }
        i.u("viewBinding");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(CardManagementActivity this$0) {
        i.f(this$0, "this$0");
        this$0.f16685h = false;
    }

    private final c f0() {
        return (c) this.f16683f.getValue();
    }

    private final void g0() {
        oc.a aVar = this.f16681d;
        if (aVar != null) {
            RecyclerView recyclerView = aVar.f31492b;
            recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
            recyclerView.h(d0());
            e0().j(recyclerView);
            recyclerView.setAdapter(Y());
            Z().a(Y());
            return;
        }
        i.u("viewBinding");
        throw null;
    }

    private final void h0() {
        this.f16686i = false;
        invalidateOptionsMenu();
        oc.a aVar = this.f16681d;
        if (aVar != null) {
            aVar.f31493c.setVisibility(8);
            oc.a aVar2 = this.f16681d;
            if (aVar2 != null) {
                aVar2.f31495e.setVisibility(0);
                oc.a aVar3 = this.f16681d;
                if (aVar3 != null) {
                    aVar3.f31494d.setVisibility(0);
                    oc.a aVar4 = this.f16681d;
                    if (aVar4 != null) {
                        aVar4.f31495e.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.health.b
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                CardManagementActivity.i0(CardManagementActivity.this, view);
                            }
                        });
                    } else {
                        i.u("viewBinding");
                        throw null;
                    }
                } else {
                    i.u("viewBinding");
                    throw null;
                }
            } else {
                i.u("viewBinding");
                throw null;
            }
        } else {
            i.u("viewBinding");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(CardManagementActivity this$0, View view) {
        i.f(this$0, "this$0");
        if (!com.mobvoi.android.common.utils.m.b(this$0)) {
            Toast.makeText(this$0, R.string.error_code_network_error, 0).show();
        } else if (!this$0.f16685h) {
            this$0.U();
        }
    }

    private final void initView() {
        g0();
        oc.a aVar = this.f16681d;
        if (aVar != null) {
            aVar.f31493c.setRefreshing(true);
        } else {
            i.u("viewBinding");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(List<String> list) {
        this.f16682e.a(c0().f(list).Z(cq.a.c()).H(xp.a.b()).Y(new yp.b() { // from class: com.mobvoi.companion.health.d
            @Override // yp.b
            public final void call(Object obj) {
                CardManagementActivity.k0(CardManagementActivity.this, (j) obj);
            }
        }, new yp.b() { // from class: com.mobvoi.companion.health.g
            @Override // yp.b
            public final void call(Object obj) {
                CardManagementActivity.l0(CardManagementActivity.this, (Throwable) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(CardManagementActivity this$0, j jVar) {
        i.f(this$0, "this$0");
        com.mobvoi.android.common.utils.k.a("CardManagementActivity", i.n("Update vpa card setting: ", jVar == null ? null : Boolean.valueOf(jVar.a())));
        boolean z10 = true;
        if (jVar == null || !jVar.a()) {
            z10 = false;
        }
        if (z10) {
            b1.a.b(this$0).d(new Intent("com.mobvoi.compainion.ACTION_UPDATE_CARD_FINISH"));
            Toast.makeText(this$0, R.string.update_success, 0).show();
            this$0.finish();
            return;
        }
        Toast.makeText(this$0, R.string.update_failed, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(CardManagementActivity this$0, Throwable th2) {
        i.f(this$0, "this$0");
        com.mobvoi.android.common.utils.k.d("CardManagementActivity", th2.getMessage());
        Toast.makeText(this$0, R.string.update_failed, 0).show();
    }

    public final n Y() {
        n nVar = this.f16691n;
        if (nVar != null) {
            return nVar;
        }
        i.u("cardMgrAdapter");
        throw null;
    }

    public final u Z() {
        u uVar = this.f16692o;
        if (uVar != null) {
            return uVar;
        }
        i.u("cardMgrDragCallback");
        throw null;
    }

    public final List<k> a0() {
        List<k> list = this.f16688k;
        if (list != null) {
            return list;
        }
        i.u("cardsAddedList");
        throw null;
    }

    public final List<k> b0() {
        List<k> list = this.f16689l;
        if (list != null) {
            return list;
        }
        i.u("cardsPendingList");
        throw null;
    }

    public final sc.b c0() {
        sc.b bVar = this.f16687j;
        if (bVar != null) {
            return bVar;
        }
        i.u("healthDataApiHelper");
        throw null;
    }

    public final RecyclerView.n d0() {
        RecyclerView.n nVar = this.f16693p;
        if (nVar != null) {
            return nVar;
        }
        i.u("itemDecoration");
        throw null;
    }

    public final g e0() {
        g gVar = this.f16690m;
        if (gVar != null) {
            return gVar;
        }
        i.u("itemTouchHelper");
        throw null;
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return R.layout.activity_card_management;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        StringBuilder sb2 = new StringBuilder();
        for (k kVar : a0()) {
            String c10 = kVar.c();
            if (c10 != null) {
                sb2.append(c10);
            }
        }
        if (!i.b(sb2.toString(), this.f16684g)) {
            f0().show();
        } else {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        oc.a b10 = oc.a.b(getContentView().getChildAt(0));
        i.e(b10, "bind(contentView.getChildAt(0))");
        this.f16681d = b10;
        setTitle(R.string.home_tab_card_management);
        initView();
        U();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        i.f(menu, "menu");
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f16682e.b();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        i.f(item, "item");
        if (item.getItemId() != R.id.save) {
            return super.onOptionsItemSelected(item);
        }
        ArrayList arrayList = new ArrayList();
        for (k kVar : a0()) {
            String c10 = kVar.c();
            if (c10 != null) {
                arrayList.add(c10);
            }
        }
        j0(arrayList);
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem findItem = menu == null ? null : menu.findItem(R.id.save);
        if (findItem != null) {
            findItem.setVisible(this.f16686i);
        }
        return super.onPrepareOptionsMenu(menu);
    }
}
