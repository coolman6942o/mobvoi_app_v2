package com.mobvoi.mcuwatch.ui.settings.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.mcuwatch.bean.AlarmBean;
import com.mobvoi.mcuwatch.engine.u;
import com.mobvoi.mcuwatch.ui.settings.alarm.AlarmRemindActivity;
import com.unionpay.tsmservice.data.Constant;
import ij.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import jj.f;
import sh.e;
import sh.h;
import sh.j;
import wi.b;
/* loaded from: classes2.dex */
public class AlarmRemindActivity extends wi.b {

    /* renamed from: h  reason: collision with root package name */
    View f20041h;

    /* renamed from: i  reason: collision with root package name */
    View f20042i;

    /* renamed from: j  reason: collision with root package name */
    RecyclerView f20043j;

    /* renamed from: k  reason: collision with root package name */
    FloatingActionButton f20044k;

    /* renamed from: l  reason: collision with root package name */
    TextView f20045l;

    /* renamed from: m  reason: collision with root package name */
    AlarmBean f20046m;

    /* renamed from: n  reason: collision with root package name */
    jj.b f20047n;

    /* renamed from: p  reason: collision with root package name */
    private b f20049p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f20050q;

    /* renamed from: o  reason: collision with root package name */
    private boolean f20048o = false;

    /* renamed from: r  reason: collision with root package name */
    private BroadcastReceiver f20051r = new a();

    /* loaded from: classes2.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AlarmBean alarmBean;
            String action = intent.getAction();
            k.c("AlarmRemindActivity", "onReceive %s", action);
            if ("action.UPDATE_ALARM".equals(action) && (alarmBean = (AlarmBean) intent.getParcelableExtra(Constant.KEY_PARAMS)) != null) {
                AlarmRemindActivity.this.f20047n.b(alarmBean);
                AlarmRemindActivity.this.f20049p.m(AlarmRemindActivity.this.f20047n.f());
                AlarmRemindActivity.this.n0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class c extends RecyclerView.b0 {

        /* renamed from: a  reason: collision with root package name */
        ImageView f20056a;

        /* renamed from: b  reason: collision with root package name */
        TextView f20057b;

        /* renamed from: c  reason: collision with root package name */
        TextView f20058c;

        /* renamed from: d  reason: collision with root package name */
        SwitchMaterial f20059d;

        /* renamed from: e  reason: collision with root package name */
        TextView f20060e;

        c(View view) {
            super(view);
            this.f20056a = (ImageView) view.findViewById(h.f34644h1);
            this.f20057b = (TextView) view.findViewById(h.f34666m3);
            this.f20058c = (TextView) view.findViewById(h.Z2);
            this.f20059d = (SwitchMaterial) view.findViewById(h.Y2);
            this.f20060e = (TextView) view.findViewById(h.f34665m2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(final AlarmBean alarmBean) {
        new k7.b(this).h(alarmBean == null ? sh.k.A0 : sh.k.f34900z0).d(false).j(sh.k.f34848p0, f.f29643a).m(sh.k.f34853q0, new DialogInterface.OnClickListener() { // from class: jj.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                AlarmRemindActivity.this.h0(alarmBean, dialogInterface, i10);
            }
        }).t();
    }

    private void e0(AlarmBean alarmBean) {
        int e10 = this.f20047n.e(alarmBean);
        if (e10 >= 0) {
            this.f20049p.notifyItemRemoved(e10);
        }
        b1.a.b(this).d(new Intent("action.UPDATE_ALARM"));
        if (this.f20047n.f().isEmpty()) {
            m0();
            k0(false);
        }
    }

    private void f0() {
        this.f20047n.c();
        b1.a.b(this).d(new Intent("action.DELETE_ALL_ALARM"));
        b1.a.b(this).d(new Intent("action.UPDATE_ALARM"));
        m0();
        k0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(AlarmBean alarmBean, DialogInterface dialogInterface, int i10) {
        if (alarmBean == null) {
            f0();
        } else {
            e0(alarmBean);
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(Object[] objArr) {
        this.f20047n.m((AlarmBean) objArr[0]);
    }

    private void j0() {
        this.f20047n.k();
        this.f20049p.m(this.f20047n.f());
    }

    private void k0(boolean z10) {
        this.f20050q = z10;
        invalidateOptionsMenu();
        if (this.f20050q) {
            this.f20044k.k();
        } else {
            this.f20044k.s();
        }
        this.f20045l.setVisibility(this.f20050q ? 0 : 8);
        this.f20049p.m(this.f20047n.f());
    }

    private void l0() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action.UPDATE_ALARM");
        b1.a.b(this).c(this.f20051r, intentFilter);
        this.f20048o = true;
    }

    private void m0() {
        this.f20042i.setVisibility(8);
        if (this.f20047n.f().isEmpty()) {
            this.f20041h.setVisibility(0);
            this.f20043j.setVisibility(8);
            this.f20044k.s();
            return;
        }
        this.f20041h.setVisibility(8);
        this.f20043j.setVisibility(0);
        if (this.f20047n.f().size() >= 3) {
            this.f20044k.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        m0();
        invalidateOptionsMenu();
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, AlarmRemindActivity.class));
    }

    @Override // wi.e
    protected Class<i> I() {
        return i.class;
    }

    @Override // wi.b
    protected void N() {
        if (this.f36241d == 1) {
            T();
            this.f20047n.i(this.f20046m, false);
            this.f20049p.m(this.f20047n.f());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // wi.b
    public void Q() {
        this.f36243f = false;
        this.f36242e.put(1, new b.a() { // from class: jj.g
            @Override // wi.b.a
            public final void a(Object[] objArr) {
                AlarmRemindActivity.this.i0(objArr);
            }
        });
        this.f20047n = jj.b.g();
        super.Q();
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return sh.i.a_res_0x7f0e001f;
    }

    @Override // wi.b
    protected void initView() {
        setTitle(sh.k.f34778b3);
        this.f20041h = findViewById(h.R0);
        this.f20042i = findViewById(h.f34621c2);
        this.f20043j = (RecyclerView) findViewById(h.Z1);
        this.f20044k = (FloatingActionButton) findViewById(h.f34624d);
        this.f20045l = (TextView) findViewById(h.M0);
        this.f20044k.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.alarm.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlarmRemindActivity.this.onClick(view);
            }
        });
        this.f20045l.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.alarm.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlarmRemindActivity.this.onClick(view);
            }
        });
        this.f20043j.setLayoutManager(new LinearLayoutManager(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.f34467a);
        this.f20043j.h(new ba.a(0, androidx.core.content.b.c(this, 17170445), dimensionPixelSize, 0));
        b bVar = new b(this, null);
        this.f20049p = bVar;
        this.f20043j.setAdapter(bVar);
        j0();
        l0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == h.f34624d) {
            startActivity(new Intent(this, AlarmDetailActivity.class));
        } else if (id2 == h.M0) {
            d0(null);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(j.f34768c, menu);
        MenuItem findItem = menu.findItem(h.f34615b);
        findItem.setTitle(this.f20050q ? sh.k.f34873u0 : sh.k.f34868t0);
        findItem.setVisible(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // wi.b, wi.e, com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f20048o) {
            b1.a.b(this).e(this.f20051r);
        }
        this.f20048o = false;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != h.f34615b) {
            return super.onOptionsItemSelected(menuItem);
        }
        k0(!this.f20050q);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        u.f19202a.i0(new WeakReference<>(this));
        n0();
        this.f20049p.m(this.f20047n.f());
    }

    @Override // com.mobvoi.mcuwatch.engine.m
    public void p() {
        if (this.f36241d == 1) {
            T();
            this.f20047n.i(this.f20046m, true);
            this.f20049p.m(this.f20047n.f());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends RecyclerView.Adapter<c> {

        /* renamed from: a  reason: collision with root package name */
        private boolean f20053a;

        /* renamed from: b  reason: collision with root package name */
        private List<AlarmBean> f20054b;

        private b() {
            this.f20054b = new ArrayList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(AlarmBean alarmBean, View view) {
            AlarmRemindActivity.this.d0(alarmBean);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(AlarmBean alarmBean, View view) {
            Intent intent = new Intent(AlarmRemindActivity.this, AlarmDetailActivity.class);
            intent.putExtra(Constant.KEY_PARAMS, alarmBean);
            AlarmRemindActivity.this.startActivity(intent);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(AlarmBean alarmBean, CompoundButton compoundButton, boolean z10) {
            if (!this.f20053a) {
                AlarmRemindActivity alarmRemindActivity = AlarmRemindActivity.this;
                alarmRemindActivity.f20046m = alarmBean;
                alarmBean.isOpen = z10;
                alarmRemindActivity.M(1, alarmBean);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j() {
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f20054b.size();
        }

        /* renamed from: k */
        public void onBindViewHolder(c cVar, int i10) {
            this.f20053a = true;
            final AlarmBean alarmBean = this.f20054b.get(i10);
            if (!alarmBean.isOpen) {
                cVar.f20059d.setChecked(false);
            } else {
                cVar.f20059d.setChecked(true);
            }
            cVar.f20057b.setText(nj.u.a(alarmBean.alarmTime));
            cVar.f20058c.setText(alarmBean.description);
            if (AlarmRemindActivity.this.f20050q) {
                cVar.f20056a.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.alarm.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AlarmRemindActivity.b.this.g(alarmBean, view);
                    }
                });
                cVar.f20059d.setVisibility(8);
                cVar.f20060e.setVisibility(0);
                cVar.itemView.setOnLongClickListener(null);
                cVar.f20056a.setVisibility(0);
            } else {
                cVar.f20056a.setVisibility(8);
                cVar.f20056a.setOnClickListener(null);
                cVar.f20059d.setVisibility(0);
                cVar.f20060e.setVisibility(8);
            }
            cVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.alarm.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AlarmRemindActivity.b.this.h(alarmBean, view);
                }
            });
            cVar.f20059d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.mobvoi.mcuwatch.ui.settings.alarm.f
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                    AlarmRemindActivity.b.this.i(alarmBean, compoundButton, z10);
                }
            });
            this.f20053a = false;
        }

        /* renamed from: l */
        public c onCreateViewHolder(ViewGroup viewGroup, int i10) {
            return new c(LayoutInflater.from(viewGroup.getContext()).inflate(sh.i.f34746o0, viewGroup, false));
        }

        public void m(List<AlarmBean> list) {
            this.f20054b.clear();
            this.f20054b.addAll(list);
            AlarmRemindActivity.this.runOnUiThread(new Runnable() { // from class: com.mobvoi.mcuwatch.ui.settings.alarm.g
                @Override // java.lang.Runnable
                public final void run() {
                    AlarmRemindActivity.b.this.j();
                }
            });
        }

        /* synthetic */ b(AlarmRemindActivity alarmRemindActivity, a aVar) {
            this();
        }
    }
}
