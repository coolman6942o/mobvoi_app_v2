package com.mobvoi.mcuwatch.ui.onlinedial;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import bn.m;
import bn.p;
import bn.r;
import cj.e;
import cj.g;
import com.mobvoi.android.common.utils.s;
import com.mobvoi.mcuwatch.engine.u;
import com.mobvoi.mcuwatch.ui.customview.s;
import com.mobvoi.mcuwatch.ui.customview.t;
import com.mobvoi.mcuwatch.ui.customview.y;
import com.mobvoi.mcuwatch.ui.onlinedial.a;
import com.tendcloud.tenddata.ab;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;
import com.yc.pedometer.dial.OnlineDialUtil;
import com.yc.pedometer.sdk.BluetoothLeService;
import dn.h;
import en.q;
import gn.z;
import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import nj.k;
import rx.c;
import sh.d;
import zh.n;
/* compiled from: CustomDialFragment.kt */
/* loaded from: classes2.dex */
public final class a extends Fragment implements h, s.a, t {

    /* renamed from: x  reason: collision with root package name */
    public static final C0229a f19878x = new C0229a(null);

    /* renamed from: b  reason: collision with root package name */
    private int f19880b;

    /* renamed from: d  reason: collision with root package name */
    private int f19882d;

    /* renamed from: g  reason: collision with root package name */
    private boolean f19885g;

    /* renamed from: n  reason: collision with root package name */
    private n f19892n;

    /* renamed from: p  reason: collision with root package name */
    private Bitmap f19894p;

    /* renamed from: q  reason: collision with root package name */
    private Bitmap f19895q;

    /* renamed from: r  reason: collision with root package name */
    private com.mobvoi.mcuwatch.ui.customview.n f19896r;

    /* renamed from: s  reason: collision with root package name */
    private jc.a f19897s;

    /* renamed from: t  reason: collision with root package name */
    private Uri f19898t;

    /* renamed from: u  reason: collision with root package name */
    private File f19899u;

    /* renamed from: v  reason: collision with root package name */
    private dj.a f19900v;

    /* renamed from: a  reason: collision with root package name */
    private final int[] f19879a = {d.I, d.J, d.M, d.N, d.O, d.P, d.Q, d.R, d.S, d.T, d.K, d.L};

    /* renamed from: c  reason: collision with root package name */
    private String f19881c = "";

    /* renamed from: e  reason: collision with root package name */
    private String f19883e = "2";

    /* renamed from: f  reason: collision with root package name */
    private int f19884f = 16777215;

    /* renamed from: h  reason: collision with root package name */
    private float f19886h = 2.0f;

    /* renamed from: i  reason: collision with root package name */
    private float f19887i = 2.0f;

    /* renamed from: j  reason: collision with root package name */
    private final int f19888j = 100;

    /* renamed from: k  reason: collision with root package name */
    private final int f19889k = 101;

    /* renamed from: l  reason: collision with root package name */
    private int f19890l = 240;

    /* renamed from: m  reason: collision with root package name */
    private int f19891m = 240;

    /* renamed from: o  reason: collision with root package name */
    private final s f19893o = new s(this);

    /* renamed from: w  reason: collision with root package name */
    private final BroadcastReceiver f19901w = new b();

    /* compiled from: CustomDialFragment.kt */
    /* renamed from: com.mobvoi.mcuwatch.ui.onlinedial.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0229a {
        private C0229a() {
        }

        public /* synthetic */ C0229a(f fVar) {
            this();
        }

        public final a a() {
            return new a();
        }
    }

    /* compiled from: CustomDialFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            i.f(context, "context");
            i.f(intent, "intent");
            String action = intent.getAction();
            if (i.b(action, "action_gatt_connect_daydaybandsdk")) {
                a.this.f19893o.sendEmptyMessage(10);
            } else if (i.b(action, "bluetooth.le.ACTION_GATT_FAILURE_daydaybandsdk")) {
                a.this.f19893o.sendEmptyMessage(11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(a this$0, View view) {
        i.f(this$0, "this$0");
        if (!k.f31276a) {
            this$0.J0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(a this$0, View view) {
        i.f(this$0, "this$0");
        if (!z.v(this$0.getContext()).j()) {
            this$0.O0(sh.k.S0);
        } else if (com.mobvoi.mcuwatch.engine.s.f19186a.d()) {
            this$0.O0(sh.k.J4);
        } else {
            this$0.T0();
            androidx.fragment.app.f activity = this$0.getActivity();
            com.mobvoi.mcuwatch.ui.customview.n nVar = activity == null ? null : new com.mobvoi.mcuwatch.ui.customview.n(activity, this$0.f19894p, i.b(this$0.f19883e, "1"), this$0);
            this$0.f19896r = nVar;
            if (nVar != null) {
                nVar.show();
            }
        }
    }

    private final void C0(Bitmap bitmap) {
        this.f19894p = bitmap;
        if (bitmap != null) {
            x0().f37568c.setImageBitmap(p.y().P(this.f19894p, this.f19886h, this.f19887i));
        }
    }

    private final void D0() {
        c.x(new Callable() { // from class: cj.p
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Bitmap E0;
                E0 = a.E0(a.this);
                return E0;
            }
        }).Z(cq.a.c()).H(xp.a.b()).Y(new yp.b() { // from class: cj.b
            @Override // yp.b
            public final void call(Object obj) {
                a.F0(a.this, (Bitmap) obj);
            }
        }, e.f5914a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap E0(a this$0) {
        i.f(this$0, "this$0");
        return m.o().b(this$0.getContext(), this$0.f19895q, this$0.f19885g, this$0.f19884f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(a this$0, Bitmap it) {
        i.f(this$0, "this$0");
        i.e(it, "it");
        this$0.C0(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(Throwable th2) {
        com.mobvoi.android.common.utils.k.d("CustomDialFragment", "refreshPreview failed");
    }

    private final void H0() {
        this.f19880b = 0;
        dj.a aVar = this.f19900v;
        if (aVar != null) {
            aVar.a(0);
            this.f19884f = getResources().getColor(d.I, null);
            this.f19885g = false;
            m.o().x();
            m.o().w();
            Bitmap m10 = m.o().m(getContext());
            this.f19894p = m10;
            if (m10 != null) {
                x0().f37568c.setImageBitmap(p.y().P(this.f19894p, this.f19886h, this.f19887i));
                return;
            }
            return;
        }
        i.u("mFontColorGirdAdapter");
        throw null;
    }

    private final void I0() {
        if (isAdded()) {
            k.f31276a = false;
            x0().f37570e.setTextColor(getResources().getColor(d.f34444b0, null));
            x0().f37570e.setText(sh.k.E2);
            x0().f37570e.setClickable(true);
        }
    }

    private final void J0() {
        s.a aVar = new s.a(getContext());
        aVar.h(new DialogInterface.OnClickListener() { // from class: cj.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                a.K0(a.this, dialogInterface, i10);
            }
        });
        aVar.j(new DialogInterface.OnClickListener() { // from class: cj.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                com.mobvoi.mcuwatch.ui.onlinedial.a.L0(com.mobvoi.mcuwatch.ui.onlinedial.a.this, dialogInterface, i10);
            }
        });
        aVar.i(cj.i.f5918a);
        aVar.d().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(a this$0, DialogInterface dialog, int i10) {
        i.f(this$0, "this$0");
        i.f(dialog, "dialog");
        Intent intent = new Intent("android.intent.action.GET_CONTENT", (Uri) null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        this$0.startActivityForResult(intent, this$0.f19888j);
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(a this$0, DialogInterface dialog, int i10) {
        Uri uri;
        i.f(this$0, "this$0");
        i.f(dialog, "dialog");
        Context context = this$0.getContext();
        if (context != null) {
            if (!hc.e.i(context, "android.permission.CAMERA")) {
                this$0.requestPermissions(new String[]{"android.permission.CAMERA"}, 100);
                return;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                String n10 = i.n(context.getPackageName(), ".fileProvider");
                File file = this$0.f19899u;
                if (file != null) {
                    uri = FileProvider.e(context, n10, file);
                } else {
                    i.u("outputImage");
                    throw null;
                }
            } else {
                File file2 = this$0.f19899u;
                if (file2 != null) {
                    uri = Uri.fromFile(file2);
                } else {
                    i.u("outputImage");
                    throw null;
                }
            }
            this$0.f19898t = uri;
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            intent.putExtra("output", this$0.f19898t);
            this$0.startActivityForResult(intent, this$0.f19889k);
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(DialogInterface dialog, int i10) {
        i.f(dialog, "dialog");
        dialog.dismiss();
    }

    private final void N0(String str) {
        jc.a aVar = this.f19897s;
        if (aVar != null && aVar.isShowing()) {
            aVar.dismiss();
        }
        jc.a a10 = y.a(getContext(), str);
        this.f19897s = a10;
        if (a10 != null) {
            a10.show();
        }
    }

    private final void O0(int i10) {
        if (requireActivity() != null) {
            Toast.makeText(requireActivity(), i10, 1).show();
        }
    }

    private final void P0() {
        ej.d.g().f().Y(new yp.b() { // from class: cj.d
            @Override // yp.b
            public final void call(Object obj) {
                a.Q0(a.this, (List) obj);
            }
        }, g.f5916a);
        ej.d.g().o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(a this$0, List list) {
        i.f(this$0, "this$0");
        if (list != null && (!list.isEmpty())) {
            String i10 = ((bn.d) list.get(0)).i();
            i.e(i10, "dialZipPreInfoList[0].type");
            this$0.f19883e = i10;
            String e10 = ((bn.d) list.get(0)).e();
            i.e(e10, "dialZipPreInfoList[0].folderDial");
            this$0.f19881c = e10;
            this$0.f19882d = ((bn.d) list.get(0)).h();
        }
        com.mobvoi.android.common.utils.k.c("CustomDialFragment", "dialType=%s, pathStatus=%s, ,folderDial=%s", String.valueOf(z.v(this$0.getContext()).s()), Integer.valueOf(this$0.f19882d), this$0.f19881c);
        if (i.b(this$0.f19883e, "2")) {
            this$0.x0().f37568c.setOval(true);
        } else {
            this$0.x0().f37568c.setCornerRadius(32.0f);
        }
        this$0.x0().f37570e.setEnabled(true);
        m.o().B(this$0.f19883e);
        m.o().C(this$0.f19881c);
        m.o().E(this$0.f19882d);
        this$0.H0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(Throwable th2) {
        com.mobvoi.android.common.utils.k.h("CustomDialFragment", i.n(" throwable = ", th2));
    }

    private final void S0(Uri uri) {
        androidx.fragment.app.f activity = getActivity();
        if (activity != null) {
            this.f19890l = z.v(getContext()).G();
            this.f19891m = z.v(getContext()).F();
            CropImage.a(uri).e(CropImageView.Guidelines.ON).c(this.f19890l, this.f19891m).g(this.f19890l, this.f19891m, CropImageView.RequestSizeOptions.RESIZE_EXACT).f(this.f19890l, this.f19891m).d(true).h(activity);
        }
    }

    private final void T0() {
        OnlineDialUtil.j().l(OnlineDialUtil.DialStatus.CustomDial);
        x0().f37570e.setClickable(false);
        x0().f37570e.setText(getString(sh.k.F2));
        k.f31276a = true;
        this.f19893o.sendEmptyMessageDelayed(12, ab.Y);
        com.mobvoi.mcuwatch.ui.customview.n nVar = this.f19896r;
        if (nVar != null) {
            nVar.e(0);
        }
        s0();
        q.B(getContext()).w0(new dn.n() { // from class: cj.n
            @Override // dn.n
            public final void a(int i10) {
                a.U0(a.this, i10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(a this$0, int i10) {
        i.f(this$0, "this$0");
        if (i10 > 0 && this$0.f19893o.hasMessages(12)) {
            this$0.f19893o.removeMessages(12);
        }
        com.mobvoi.mcuwatch.ui.customview.n nVar = this$0.f19896r;
        if (nVar != null) {
            nVar.e(i10);
        }
        if (i10 == 0) {
            this$0.x0().f37570e.setTextColor(-16777216);
        } else if (i10 == 100) {
            k.f31276a = false;
            this$0.x0().f37570e.setText(sh.k.C2);
            this$0.x0().f37570e.setTextColor(this$0.getResources().getColor(d.f34444b0, null));
        }
    }

    private final void p0(Bitmap bitmap) {
        if (i.b(this.f19883e, "2")) {
            bitmap = p.y().K(bitmap);
        }
        this.f19895q = bitmap;
        D0();
    }

    private final void q0(int i10) {
        this.f19884f = i10;
        this.f19885g = true;
        D0();
    }

    private final void r0() {
        if (k.f31276a) {
            k.f31276a = false;
            q.B(getContext()).x0();
        }
        if (this.f19893o.hasMessages(12)) {
            this.f19893o.removeMessages(12);
        }
        com.mobvoi.mcuwatch.ui.customview.n nVar = this.f19896r;
        if (nVar != null) {
            nVar.dismiss();
        }
    }

    private final void s0() {
        c.x(new Callable() { // from class: cj.o
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean t02;
                t02 = a.t0(a.this);
                return t02;
            }
        }).Z(cq.a.c()).H(xp.a.b()).Y(new yp.b() { // from class: cj.c
            @Override // yp.b
            public final void call(Object obj) {
                a.u0(a.this, (Boolean) obj);
            }
        }, cj.f.f5915a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean t0(a this$0) {
        i.f(this$0, "this$0");
        return Boolean.valueOf(m.o().c(this$0.getContext(), this$0.f19894p));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(a this$0, Boolean bool) {
        i.f(this$0, "this$0");
        q.B(this$0.getContext()).L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(Throwable th2) {
        com.mobvoi.android.common.utils.k.d("CustomDialFragment", "dealWithSyncDialData failed");
    }

    private final void w0() {
        jc.a aVar = this.f19897s;
        if (aVar != null && aVar.isShowing()) {
            aVar.dismiss();
        }
        this.f19897s = null;
    }

    private final n x0() {
        n nVar = this.f19892n;
        i.d(nVar);
        return nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(a this$0, AdapterView adapterView, View view, int i10, long j10) {
        i.f(this$0, "this$0");
        if (!k.f31276a) {
            this$0.f19880b = i10;
            dj.a aVar = this$0.f19900v;
            if (aVar != null) {
                aVar.a(i10);
                this$0.q0(this$0.getResources().getColor(this$0.f19879a[i10], null));
                return;
            }
            i.u("mFontColorGirdAdapter");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(a this$0, View view) {
        i.f(this$0, "this$0");
        if (!k.f31276a) {
            this$0.H0();
        }
    }

    @Override // dn.h
    public void H(int i10) {
        if (OnlineDialUtil.j().i() == OnlineDialUtil.DialStatus.CustomDial) {
            this.f19893o.sendEmptyMessage(i10);
        }
    }

    @Override // com.mobvoi.android.common.utils.s.a
    public void handleMessage(Message message) {
        Integer valueOf = message == null ? null : Integer.valueOf(message.what);
        if (valueOf != null && valueOf.intValue() == 1) {
            if (!z.v(getContext()).j()) {
                y.b(1, getContext());
            } else {
                this.f19893o.sendEmptyMessageDelayed(101, 30L);
            }
        } else if (valueOf != null && valueOf.intValue() == 2) {
            O0(sh.k.f34875u2);
            r0();
            androidx.fragment.app.f activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        } else if (valueOf != null && valueOf.intValue() == 3) {
            if (k.f31276a) {
                r0();
                O0(sh.k.f34865s2);
            }
            I0();
        } else if (valueOf != null && valueOf.intValue() == 4) {
            if (k.f31276a) {
                r0();
                O0(sh.k.f34870t2);
            }
            I0();
        } else if (valueOf != null && valueOf.intValue() == 10) {
            w0();
            I0();
        } else if (valueOf != null && valueOf.intValue() == 11) {
            if (k.f31276a) {
                r0();
            }
            String string = getString(sh.k.A3);
            i.e(string, "getString(R.string.watch_lite_connect_fail)");
            N0(string);
            I0();
        } else if (valueOf != null && valueOf.intValue() == 12) {
            O0(sh.k.D2);
            if (k.f31276a) {
                r0();
            }
            I0();
        } else if (valueOf != null && valueOf.intValue() == 101) {
            m.o().I(getContext());
        }
    }

    @Override // com.mobvoi.mcuwatch.ui.customview.t
    public void n() {
        r0();
        I0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        CropImage.ActivityResult b10;
        super.onActivityResult(i10, i11, intent);
        Uri uri = null;
        if (i10 == this.f19888j) {
            if (intent != null) {
                uri = intent.getData();
            }
            S0(uri);
        } else if (i10 == this.f19889k) {
            File file = this.f19899u;
            if (file != null) {
                S0(Uri.fromFile(file));
            } else {
                i.u("outputImage");
                throw null;
            }
        } else if (i10 == 203 && (b10 = CropImage.b(intent)) != null && b10.g() != null) {
            Uri g10 = b10.g();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            Bitmap decodeFile = BitmapFactory.decodeFile(g10.getPath(), options);
            if (decodeFile != null && decodeFile.getWidth() == this.f19890l && decodeFile.getHeight() == this.f19891m) {
                p0(decodeFile);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        i.f(inflater, "inflater");
        this.f19892n = n.d(inflater, viewGroup, false);
        RelativeLayout c10 = x0().a();
        i.e(c10, "binding.root");
        return c10;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f19892n = null;
        BluetoothLeService I = u.f19202a.I();
        if (I != null) {
            I.d1(null);
        }
        androidx.fragment.app.f activity = getActivity();
        if (activity != null) {
            activity.unregisterReceiver(this.f19901w);
        }
        org.greenrobot.eventbus.c.c().q(this);
        this.f19893o.removeCallbacksAndMessages(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i10, String[] permissions, int[] grantResults) {
        i.f(permissions, "permissions");
        i.f(grantResults, "grantResults");
        super.onRequestPermissionsResult(i10, permissions, grantResults);
        if (i10 == 100 && grantResults[0] == -1) {
            Toast.makeText(getContext(), sh.k.f34793e0, 0).show();
            requireActivity().finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.f(view, "view");
        super.onViewCreated(view, bundle);
        Context context = getContext();
        this.f19899u = new File(context == null ? null : context.getExternalCacheDir(), "dial_bg.png");
        this.f19900v = new dj.a(getContext(), this.f19879a);
        CustomDialGridView customDialGridView = x0().f37571f;
        dj.a aVar = this.f19900v;
        if (aVar != null) {
            customDialGridView.setAdapter((ListAdapter) aVar);
            dj.a aVar2 = this.f19900v;
            if (aVar2 != null) {
                aVar2.a(this.f19880b);
                x0().f37571f.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: cj.m
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view2, int i10, long j10) {
                        a.y0(a.this, adapterView, view2, i10, j10);
                    }
                });
                x0().f37567b.setOnClickListener(new View.OnClickListener() { // from class: cj.j
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        a.z0(a.this, view2);
                    }
                });
                x0().f37569d.setOnClickListener(new View.OnClickListener() { // from class: cj.k
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        a.A0(a.this, view2);
                    }
                });
                x0().f37570e.setOnClickListener(new View.OnClickListener() { // from class: cj.l
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        a.B0(a.this, view2);
                    }
                });
                org.greenrobot.eventbus.c.c().o(this);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("action_gatt_connect_daydaybandsdk");
                intentFilter.addAction("bluetooth.le.ACTION_GATT_FAILURE_daydaybandsdk");
                androidx.fragment.app.f activity = getActivity();
                if (activity != null) {
                    activity.registerReceiver(this.f19901w, intentFilter);
                }
                P0();
                return;
            }
            i.u("mFontColorGirdAdapter");
            throw null;
        }
        i.u("mFontColorGirdAdapter");
        throw null;
    }

    @org.greenrobot.eventbus.k
    public final void watch(r rVar) {
    }
}
