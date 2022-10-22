package com.mobvoi.mcuwatch.ui.onlinedial.apollo;

import a0.h;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
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
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.s;
import com.mobvoi.apollo.client.q;
import com.mobvoi.mcuwatch.ui.customview.s;
import com.mobvoi.mcuwatch.ui.customview.t;
import com.mobvoi.mcuwatch.ui.customview.y;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;
import fa.j;
import io.f;
import java.io.File;
import kotlin.jvm.internal.Lambda;
import rx.c;
import rx.i;
import yp.g;
import zh.n;
/* compiled from: CustomDialFragment.kt */
/* loaded from: classes2.dex */
public final class p extends Fragment implements s.a, t {

    /* renamed from: a  reason: collision with root package name */
    private n f19926a;

    /* renamed from: b  reason: collision with root package name */
    private final s f19927b = new s(this, Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private final int[] f19928c = {sh.d.I, sh.d.J, sh.d.M, sh.d.N, sh.d.O, sh.d.P, sh.d.Q, sh.d.R, sh.d.S, sh.d.T, sh.d.K, sh.d.L};

    /* renamed from: d  reason: collision with root package name */
    private final io.d f19929d;

    /* renamed from: e  reason: collision with root package name */
    private int f19930e;

    /* renamed from: f  reason: collision with root package name */
    private final io.d f19931f;

    /* renamed from: g  reason: collision with root package name */
    private com.mobvoi.mcuwatch.ui.customview.n f19932g;

    /* renamed from: h  reason: collision with root package name */
    private Bitmap f19933h;

    /* renamed from: i  reason: collision with root package name */
    private final io.d f19934i;

    /* renamed from: j  reason: collision with root package name */
    private Uri f19935j;

    /* compiled from: CustomDialFragment.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements qo.a<dj.a> {
        a() {
            super(0);
        }

        /* renamed from: a */
        public final dj.a invoke() {
            return new dj.a(p.this.requireContext(), p.this.f19928c);
        }
    }

    /* compiled from: CustomDialFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b implements ea.b {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i<? super Integer> f19937b;

        b(i<? super Integer> iVar) {
            this.f19937b = iVar;
        }

        @Override // ea.b
        public void a(int i10) {
            this.f19937b.onNext(Integer.valueOf(i10));
            this.f19937b.onCompleted();
        }

        @Override // ea.b
        public void b(int i10) {
            com.mobvoi.mcuwatch.ui.customview.n nVar = p.this.f19932g;
            if (nVar != null) {
                nVar.e(i10);
            }
            if (i10 == 0) {
                p.this.t0().f37570e.setTextColor(-16777216);
            } else if (i10 == 100) {
                this.f19937b.onNext(0);
                this.f19937b.onCompleted();
            }
        }
    }

    /* compiled from: CustomDialFragment.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements qo.a<File> {
        c() {
            super(0);
        }

        /* renamed from: a */
        public final File invoke() {
            Context context = p.this.getContext();
            return new File(context == null ? null : context.getExternalCacheDir(), "dial_bg.png");
        }
    }

    /* compiled from: CustomDialFragment.kt */
    /* loaded from: classes2.dex */
    static final class d extends Lambda implements qo.a<j> {
        d() {
            super(0);
        }

        /* renamed from: a */
        public final j invoke() {
            Context requireContext = p.this.requireContext();
            kotlin.jvm.internal.i.e(requireContext, "requireContext()");
            return new j(requireContext);
        }
    }

    /* compiled from: CustomDialFragment.kt */
    /* loaded from: classes2.dex */
    public static final class e extends ea.a {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ i<? super Integer> f19938c;

        e(i<? super Integer> iVar) {
            this.f19938c = iVar;
        }

        @Override // com.mobvoi.apollo.client.c0
        public void l(int i10) {
            this.f19938c.onNext(Integer.valueOf(i10));
            this.f19938c.onCompleted();
        }

        @Override // ea.a
        public void p() {
            this.f19938c.onNext(0);
            this.f19938c.onCompleted();
        }
    }

    public p() {
        io.d a10;
        io.d a11;
        io.d a12;
        a10 = f.a(new a());
        this.f19929d = a10;
        a11 = f.a(new c());
        this.f19931f = a11;
        a12 = f.a(new d());
        this.f19934i = a12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(p this$0, AdapterView adapterView, View view, int i10, long j10) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.f19930e = i10;
        this$0.u0().a(i10);
        this$0.w0().k(h.d(this$0.getResources(), this$0.f19928c[i10], null));
        this$0.D0();
    }

    private final rx.c<Integer> B0(final int i10) {
        rx.c<Integer> i02 = rx.c.i0(new c.a() { // from class: com.mobvoi.mcuwatch.ui.onlinedial.apollo.m
            @Override // yp.b
            public final void call(Object obj) {
                p.C0(i10, (i) obj);
            }
        });
        kotlin.jvm.internal.i.e(i02, "unsafeCreate {\n            ApolloHandler.prepareChangeDial(fileSize, object : OnDialPrepareChange() {\n                override fun onPrepareChange() {\n                    it.onNext(0)\n                    it.onCompleted()\n                }\n\n                override fun onFail(state: Int) {\n                    it.onNext(state)\n                    it.onCompleted()\n                }\n            })\n        }");
        return i02;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(int i10, i iVar) {
        q.f15504a.C(i10, new e(iVar));
    }

    private final void D0() {
        rx.c.i0(new c.a() { // from class: com.mobvoi.mcuwatch.ui.onlinedial.apollo.n
            @Override // yp.b
            public final void call(Object obj) {
                p.E0(p.this, (i) obj);
            }
        }).Z(cq.a.c()).H(xp.a.b()).Y(new yp.b() { // from class: com.mobvoi.mcuwatch.ui.onlinedial.apollo.b
            @Override // yp.b
            public final void call(Object obj) {
                p.F0(p.this, (Bitmap) obj);
            }
        }, com.mobvoi.mcuwatch.ui.onlinedial.apollo.e.f19913a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(p this$0, i iVar) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        long currentTimeMillis = System.currentTimeMillis();
        this$0.f19933h = this$0.w0().g();
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        k.a("CustomDialFragment", " 预览耗时" + currentTimeMillis2 + " 豪秒");
        iVar.onNext(this$0.f19933h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(p this$0, Bitmap bitmap) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (bitmap != null) {
            this$0.t0().f37568c.setImageBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(Throwable th2) {
        k.a("CustomDialFragment", "refreshPreview failed");
        th2.printStackTrace();
    }

    private final void H0() {
        this.f19930e = 0;
        u0().a(this.f19930e);
        w0().h();
        w0().k(h.d(getResources(), this.f19928c[0], null));
        D0();
    }

    private final void I0() {
        if (isAdded()) {
            nj.k.f31276a = false;
            t0().f37570e.setTextColor(getResources().getColor(sh.d.f34444b0, null));
            t0().f37570e.setText(sh.k.E2);
            t0().f37570e.setClickable(true);
        }
    }

    private final void J0() {
        s.a aVar = new s.a(getContext());
        aVar.h(new DialogInterface.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.onlinedial.apollo.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                p.K0(p.this, dialogInterface, i10);
            }
        });
        aVar.j(new DialogInterface.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.onlinedial.apollo.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                p.L0(p.this, dialogInterface, i10);
            }
        });
        aVar.i(h.f19917a);
        aVar.d().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(p this$0, DialogInterface dialog, int i10) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(dialog, "dialog");
        Intent intent = new Intent("android.intent.action.GET_CONTENT", (Uri) null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        this$0.startActivityForResult(intent, 100);
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(p this$0, DialogInterface dialog, int i10) {
        Uri uri;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(dialog, "dialog");
        Context context = this$0.getContext();
        if (context != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                uri = FileProvider.e(context, kotlin.jvm.internal.i.n(context.getPackageName(), ".fileProvider"), this$0.v0());
                kotlin.jvm.internal.i.e(uri, "{\n                    FileProvider.getUriForFile(\n                        it,\n                        it.packageName + \".fileProvider\", outputImage\n                    )\n                }");
            } else {
                uri = Uri.fromFile(this$0.v0());
                kotlin.jvm.internal.i.e(uri, "{\n                    Uri.fromFile(outputImage)\n                }");
            }
            this$0.f19935j = uri;
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            Uri uri2 = this$0.f19935j;
            if (uri2 != null) {
                intent.putExtra("output", uri2);
                this$0.startActivityForResult(intent, 101);
                dialog.dismiss();
                return;
            }
            kotlin.jvm.internal.i.u("imageUri");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(DialogInterface dialog, int i10) {
        kotlin.jvm.internal.i.f(dialog, "dialog");
        dialog.dismiss();
    }

    private final void N0(int i10) {
        if (requireActivity() != null) {
            Toast.makeText(requireActivity(), i10, 0).show();
        }
    }

    private final void O0(Uri uri) {
        androidx.fragment.app.f activity = getActivity();
        if (activity != null) {
            CropImage.a(uri).e(CropImageView.Guidelines.ON).c(360, 360).g(360, 360, CropImageView.RequestSizeOptions.RESIZE_EXACT).f(360, 360).d(true).h(activity);
        }
    }

    private final void P0() {
        t0().f37570e.setClickable(false);
        t0().f37570e.setText(getString(sh.k.F2));
        nj.k.f31276a = true;
        final byte[] a10 = w0().a();
        B0(a10.length).v(new g() { // from class: com.mobvoi.mcuwatch.ui.onlinedial.apollo.f
            @Override // yp.g
            public final Object call(Object obj) {
                c Q0;
                Q0 = p.Q0(p.this, a10, (Integer) obj);
                return Q0;
            }
        }).X(new yp.b() { // from class: com.mobvoi.mcuwatch.ui.onlinedial.apollo.d
            @Override // yp.b
            public final void call(Object obj) {
                p.S0(p.this, (Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final rx.c Q0(final p this$0, byte[] dialData, Integer num) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(dialData, "$dialData");
        if (num != null && num.intValue() == 0) {
            return this$0.r0(dialData).p(new yp.b() { // from class: com.mobvoi.mcuwatch.ui.onlinedial.apollo.c
                @Override // yp.b
                public final void call(Object obj) {
                    p.R0(p.this, (Integer) obj);
                }
            });
        }
        if (num != null && num.intValue() == 1) {
            this$0.f19927b.sendEmptyMessage(13);
        } else if (num != null && num.intValue() == 255) {
            this$0.f19927b.sendEmptyMessage(12);
        }
        return rx.c.A(num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(p this$0, Integer num) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (num != null && num.intValue() == 1) {
            this$0.f19927b.sendEmptyMessage(14);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(p this$0, Integer num) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (num != null && num.intValue() == 0) {
            this$0.f19927b.sendEmptyMessage(0);
        } else if (num != null && num.intValue() == -1) {
            this$0.f19927b.sendEmptyMessage(10);
        } else if (num != null && num.intValue() == -3) {
            this$0.f19927b.sendEmptyMessage(11);
        }
    }

    private final void q0() {
        com.mobvoi.mcuwatch.ui.customview.n nVar = this.f19932g;
        if (nVar != null) {
            nVar.dismiss();
        }
    }

    private final rx.c<Integer> r0(final byte[] bArr) {
        rx.c<Integer> i02 = rx.c.i0(new c.a() { // from class: com.mobvoi.mcuwatch.ui.onlinedial.apollo.o
            @Override // yp.b
            public final void call(Object obj) {
                p.s0(bArr, this, (i) obj);
            }
        });
        kotlin.jvm.internal.i.e(i02, "unsafeCreate {\n            ApolloHandler.changeDial(file, object : OnDialTransferListener {\n                override fun onProcess(percent: Int) {\n                    picUpgradeSetDialog?.setProgress(percent)\n                    if (percent == 0) {\n                        binding.syncToWatch.setTextColor(Color.BLACK)\n                    } else if (percent == 100) {\n                        it.onNext(0)\n                        it.onCompleted()\n                    }\n                }\n\n                override fun onFail(code: Int) {\n                    it.onNext(code)\n                    it.onCompleted()\n                }\n            })\n        }");
        return i02;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(byte[] file, p this$0, i iVar) {
        kotlin.jvm.internal.i.f(file, "$file");
        kotlin.jvm.internal.i.f(this$0, "this$0");
        q.f15504a.l(file, new b(iVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n t0() {
        n nVar = this.f19926a;
        kotlin.jvm.internal.i.d(nVar);
        return nVar;
    }

    private final dj.a u0() {
        return (dj.a) this.f19929d.getValue();
    }

    private final File v0() {
        return (File) this.f19931f.getValue();
    }

    private final j w0() {
        return (j) this.f19934i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(p this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.J0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(p this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.H0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(p this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (!q.f15504a.B()) {
            y.b(1, this$0.getContext());
            return;
        }
        this$0.P0();
        androidx.fragment.app.f activity = this$0.getActivity();
        com.mobvoi.mcuwatch.ui.customview.n nVar = activity == null ? null : new com.mobvoi.mcuwatch.ui.customview.n(activity, this$0.f19933h, false, this$0);
        this$0.f19932g = nVar;
        if (nVar != null) {
            nVar.show();
        }
    }

    @Override // com.mobvoi.android.common.utils.s.a
    public void handleMessage(Message message) {
        Integer valueOf = message == null ? null : Integer.valueOf(message.what);
        if (valueOf != null && valueOf.intValue() == 0) {
            nj.k.f31276a = false;
            t0().f37570e.setText(sh.k.C2);
            t0().f37570e.setTextColor(getResources().getColor(sh.d.f34444b0));
            N0(sh.k.f34875u2);
            q0();
            androidx.fragment.app.f activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        } else if (valueOf != null && valueOf.intValue() == 10) {
            q0();
            N0(sh.k.A3);
            I0();
        } else if (valueOf != null && valueOf.intValue() == 11) {
            q0();
            I0();
            N0(sh.k.S3);
        } else if (valueOf != null && valueOf.intValue() == 12) {
            q0();
            I0();
            N0(sh.k.O3);
        } else if (valueOf != null && valueOf.intValue() == 13) {
            q0();
            I0();
            N0(sh.k.R3);
        } else if (valueOf != null && valueOf.intValue() == 14) {
            q0();
            I0();
            N0(sh.k.Q3);
        }
    }

    @Override // com.mobvoi.mcuwatch.ui.customview.t
    public void n() {
        q0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        CropImage.ActivityResult b10;
        super.onActivityResult(i10, i11, intent);
        k.a("CustomDialFragment", kotlin.jvm.internal.i.n("requestCode=", Integer.valueOf(i10)));
        if (i10 == 100) {
            O0(intent == null ? null : intent.getData());
        } else if (i10 == 101) {
            O0(Uri.fromFile(v0()));
        } else if (i10 == 203 && (b10 = CropImage.b(intent)) != null && b10.g() != null) {
            Uri g10 = b10.g();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            Bitmap decodeFile = BitmapFactory.decodeFile(g10.getPath(), options);
            if (decodeFile != null) {
                k.a("CustomDialFragment", "自定义裁剪工具  bm.size= " + decodeFile.getWidth() + '*' + decodeFile.getHeight());
                w0().j(w0().i(decodeFile));
                D0();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.i.f(inflater, "inflater");
        this.f19926a = n.d(inflater, viewGroup, false);
        RelativeLayout c10 = t0().a();
        kotlin.jvm.internal.i.e(c10, "binding.root");
        return c10;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f19926a = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.i.f(view, "view");
        super.onViewCreated(view, bundle);
        t0().f37569d.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.onlinedial.apollo.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                p.x0(p.this, view2);
            }
        });
        t0().f37567b.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.onlinedial.apollo.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                p.y0(p.this, view2);
            }
        });
        t0().f37570e.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.onlinedial.apollo.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                p.z0(p.this, view2);
            }
        });
        t0().f37571f.setAdapter((ListAdapter) u0());
        u0().a(this.f19930e);
        t0().f37571f.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.mobvoi.mcuwatch.ui.onlinedial.apollo.l
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i10, long j10) {
                p.A0(p.this, adapterView, view2, i10, j10);
            }
        });
        H0();
    }
}
