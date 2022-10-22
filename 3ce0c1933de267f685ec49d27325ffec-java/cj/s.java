package cj;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.f;
import bn.p;
import cj.s;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.s;
import com.mobvoi.mcuwatch.ui.customview.OnlineDialGridView;
import com.mobvoi.mcuwatch.ui.customview.j0;
import com.mobvoi.mcuwatch.ui.customview.t;
import com.mobvoi.mcuwatch.ui.customview.y;
import com.yc.pedometer.dial.OnlineDialUtil;
import dn.h;
import en.q;
import gn.z;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import ki.d;
import rx.g;
import sh.i;
/* compiled from: WatchCenterFragment.java */
/* loaded from: classes2.dex */
public class s extends Fragment implements h, s.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f5928a;

    /* renamed from: b  reason: collision with root package name */
    private List<yh.c> f5929b;

    /* renamed from: c  reason: collision with root package name */
    private yh.c f5930c;

    /* renamed from: d  reason: collision with root package name */
    private Context f5931d;

    /* renamed from: e  reason: collision with root package name */
    private GridView f5932e;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f5933f;

    /* renamed from: g  reason: collision with root package name */
    private dq.b f5934g;

    /* renamed from: h  reason: collision with root package name */
    private j0 f5935h;

    /* renamed from: i  reason: collision with root package name */
    private com.mobvoi.android.common.utils.s f5936i;

    /* renamed from: j  reason: collision with root package name */
    private b f5937j;

    /* renamed from: k  reason: collision with root package name */
    private BroadcastReceiver f5938k;

    /* compiled from: WatchCenterFragment.java */
    /* loaded from: classes2.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.i("stringBuilder", "action=" + action);
            if (action.equals("action_gatt_connect_daydaybandsdk")) {
                s.this.f5936i.sendEmptyMessage(10);
            } else if (action.equals("bluetooth.le.ACTION_GATT_FAILURE_daydaybandsdk")) {
                s.this.f5936i.sendEmptyMessage(11);
            }
        }
    }

    /* compiled from: WatchCenterFragment.java */
    /* loaded from: classes2.dex */
    public class b extends BaseAdapter implements t {

        /* renamed from: a  reason: collision with root package name */
        private Context f5940a;

        /* renamed from: b  reason: collision with root package name */
        private int f5941b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f5942c;

        /* compiled from: WatchCenterFragment.java */
        /* loaded from: classes2.dex */
        class a {

            /* renamed from: a  reason: collision with root package name */
            ImageView f5944a;

            /* renamed from: b  reason: collision with root package name */
            TextView f5945b;

            a(b bVar, View view) {
                this.f5944a = (ImageView) view.findViewById(sh.h.f34669n1);
                this.f5945b = (TextView) view.findViewById(sh.h.f34676o4);
            }
        }

        public b(Context context, boolean z10) {
            this.f5941b = i.f34735d1;
            this.f5940a = context;
            this.f5942c = z10;
            if (z10) {
                this.f5941b = i.f34759v0;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(yh.c cVar, View view) {
            if (!z.v(this.f5940a).j()) {
                y.b(1, this.f5940a);
                return;
            }
            s.this.f5935h = new j0(s.this.getActivity(), cVar, this.f5942c, s.this.f5936i, this);
            s.this.f5930c = cVar;
            OnlineDialUtil.b("mUIFile 赋值 " + s.this.f5930c + "，mUIFile.getTitle() T=" + s.this.f5930c.title);
            if (!s.this.f5935h.isShowing()) {
                s.this.f5935h.show();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return s.this.f5929b.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            return s.this.f5929b.get(i10);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            a aVar;
            final yh.c cVar = (yh.c) s.this.f5929b.get(i10);
            if (view == null) {
                view = LayoutInflater.from(this.f5940a).inflate(this.f5941b, (ViewGroup) null);
                aVar = new a(this, view);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            if (((OnlineDialGridView) viewGroup).f19586a) {
                return view;
            }
            k.h("WatchCenterFragment", " viewHolder.tvTitle = " + aVar.f5945b);
            aVar.f5945b.setText(cVar.title);
            com.bumptech.glide.c.u(s.this.getContext()).r(cVar.watchFaceUrl).u0(aVar.f5944a);
            aVar.f5944a.setOnClickListener(new View.OnClickListener() { // from class: cj.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    s.b.this.b(cVar, view2);
                }
            });
            return view;
        }

        @Override // com.mobvoi.mcuwatch.ui.customview.t
        public void n() {
            s.this.g0();
        }
    }

    /* compiled from: WatchCenterFragment.java */
    /* loaded from: classes2.dex */
    public static class c extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        private byte[] f5946a = null;

        /* renamed from: b  reason: collision with root package name */
        private long f5947b = 0;

        /* renamed from: c  reason: collision with root package name */
        private Context f5948c;

        /* renamed from: d  reason: collision with root package name */
        private yh.c f5949d;

        /* renamed from: e  reason: collision with root package name */
        private j0 f5950e;

        public c(Context context, yh.c cVar, j0 j0Var) {
            this.f5948c = context;
            this.f5949d = cVar;
            this.f5950e = j0Var;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public Boolean doInBackground(Void... voidArr) {
            this.f5947b = System.currentTimeMillis();
            this.f5946a = p.y().I(this.f5948c, com.mobvoi.android.common.utils.b.h(Environment.DIRECTORY_DOWNLOADS).getPath() + File.separator + this.f5949d.title + ".bin");
            try {
                Thread.sleep(30L);
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
            return Boolean.FALSE;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            j0 j0Var;
            OnlineDialUtil.b(" 耗时" + (System.currentTimeMillis() - this.f5947b) + " 豪秒");
            byte[] bArr = this.f5946a;
            if (bArr != null && bArr.length > 0 && z.v(this.f5948c).j() && (j0Var = this.f5950e) != null && j0Var.isShowing()) {
                nj.k.f31276a = true;
                q.B(this.f5948c).a0(this.f5946a);
            }
        }
    }

    public s() {
        this.f5928a = yd.b.c(com.mobvoi.android.common.utils.b.e()) ? "en" : "cn";
        this.f5929b = new ArrayList();
        this.f5934g = new dq.b();
        this.f5936i = new com.mobvoi.android.common.utils.s(this);
        this.f5938k = new a();
    }

    private g<List<yh.c>> h0(int i10) {
        int i11;
        int i12 = 240;
        if (nj.q.g().r()) {
            i11 = 240;
        } else {
            i12 = 320;
            i11 = 360;
        }
        return d.f29985b.g().a(ta.a.s(), 0, 200, i12, i11, i10, this.f5928a);
    }

    public static s i0() {
        return new s();
    }

    private void j0() {
        List<yh.c> list = this.f5929b;
        if (list == null || list.size() == 0) {
            RelativeLayout relativeLayout = this.f5933f;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
                return;
            }
            return;
        }
        RelativeLayout relativeLayout2 = this.f5933f;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(List list) {
        if (list != null) {
            this.f5929b = list;
            b bVar = this.f5937j;
            if (bVar != null) {
                bVar.notifyDataSetChanged();
                j0();
            }
            k.c("WatchCenterFragment", "size %d", Integer.valueOf(this.f5929b.size()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(Throwable th2) {
        Toast.makeText(getContext(), sh.k.G1, 0).show();
        k.e("WatchCenterFragment", "fetch face list error %s", th2);
    }

    private void m0(int i10) {
        this.f5934g.b();
        this.f5934g.a(h0(i10).e(cq.a.c()).b(xp.a.b()).d(new yp.b() { // from class: cj.r
            @Override // yp.b
            public final void call(Object obj) {
                s.this.k0((List) obj);
            }
        }, new yp.b() { // from class: cj.q
            @Override // yp.b
            public final void call(Object obj) {
                s.this.l0((Throwable) obj);
            }
        }));
    }

    @Override // dn.h
    public void H(int i10) {
        if (OnlineDialUtil.j().i() == OnlineDialUtil.DialStatus.RegularDial) {
            OnlineDialUtil.b("onlineDialStatus  status =" + i10);
            this.f5936i.sendEmptyMessage(i10);
        }
    }

    public void g0() {
        if (nj.k.f31276a) {
            nj.k.f31276a = false;
            q.B(this.f5931d).x0();
        }
        if (this.f5936i.hasMessages(12)) {
            this.f5936i.removeMessages(12);
        }
        j0 j0Var = this.f5935h;
        if (j0Var != null && j0Var.isShowing() && getActivity() != null && !getActivity().isDestroyed()) {
            this.f5935h.dismiss();
        }
    }

    @Override // com.mobvoi.android.common.utils.s.a
    public void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 0) {
            k.a("WatchCenterFragment", "获取手环的表盘配置ok");
            m0(0);
        } else if (i10 == 1) {
            k.a("WatchCenterFragment", "准备发送表盘数据");
            if (this.f5930c != null) {
                new c(this.f5931d, this.f5930c, this.f5935h).execute(new Void[0]);
            }
        } else if (i10 == 2) {
            k.a("OnlineDialUtil", "handler onlineDialStatus:2");
            g0();
            Context context = this.f5931d;
            Toast.makeText(context, context.getResources().getString(sh.k.f34875u2), 0).show();
        } else if (i10 != 3) {
            if (i10 == 4) {
                if (nj.k.f31276a) {
                    g0();
                }
                Context context2 = this.f5931d;
                Toast.makeText(context2, context2.getResources().getString(sh.k.f34870t2), 0).show();
            } else if (i10 == 11) {
                g0();
                Context context3 = this.f5931d;
                Toast.makeText(context3, context3.getResources().getString(sh.k.A3), 0).show();
            } else if (i10 == 12) {
                g0();
                Toast.makeText(this.f5931d, sh.k.D2, 0);
            }
        } else if (nj.k.f31276a) {
            g0();
            Context context4 = this.f5931d;
            Toast.makeText(context4, context4.getResources().getString(sh.k.f34865s2), 0).show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(i.V, (ViewGroup) null);
        f activity = getActivity();
        this.f5931d = activity;
        q.B(activity).O();
        this.f5932e = (GridView) inflate.findViewById(sh.h.D4);
        this.f5933f = (RelativeLayout) inflate.findViewById(sh.h.f34670n2);
        b bVar = new b(getContext(), nj.q.g().s());
        this.f5937j = bVar;
        this.f5932e.setAdapter((ListAdapter) bVar);
        j0();
        m0(0);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_gatt_connect_daydaybandsdk");
        intentFilter.addAction("bluetooth.le.ACTION_GATT_FAILURE_daydaybandsdk");
        this.f5931d.registerReceiver(this.f5938k, intentFilter);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        g0();
        this.f5931d.unregisterReceiver(this.f5938k);
        this.f5934g.b();
        this.f5936i.removeCallbacksAndMessages(null);
    }
}
