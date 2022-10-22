package com.mobvoi.mcuwatch.ui.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import bn.g;
import com.mobvoi.android.common.utils.m;
import com.mobvoi.android.common.utils.s;
import com.mobvoi.apollo.client.q;
import java.io.File;
import kotlin.text.u;
import nj.k;
import rx.c;
import rx.i;
import yh.c;
/* compiled from: ApolloTransferDialog.kt */
/* loaded from: classes2.dex */
public final class j extends j0 {

    /* renamed from: m  reason: collision with root package name */
    private final String f19645m;

    /* compiled from: ApolloTransferDialog.kt */
    /* loaded from: classes2.dex */
    public static final class a implements ea.b {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i<? super Integer> f19647b;

        a(i<? super Integer> iVar) {
            this.f19647b = iVar;
        }

        @Override // ea.b
        public void a(int i10) {
            k.f31276a = false;
            this.f19647b.onNext(Integer.valueOf(i10));
            this.f19647b.onCompleted();
        }

        @Override // ea.b
        public void b(int i10) {
            j jVar = j.this;
            jVar.f19653e.setText(jVar.getContext().getString(sh.k.G2, Integer.valueOf(i10)));
            j.this.f19651c.setProgress(i10);
            if (i10 == 100) {
                k.f31276a = false;
                this.f19647b.onNext(0);
                this.f19647b.onCompleted();
            }
        }
    }

    /* compiled from: ApolloTransferDialog.kt */
    /* loaded from: classes2.dex */
    public static final class b extends ea.a {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ i<? super Integer> f19648c;

        b(i<? super Integer> iVar) {
            this.f19648c = iVar;
        }

        @Override // com.mobvoi.apollo.client.c0
        public void l(int i10) {
            this.f19648c.onNext(Integer.valueOf(i10));
            this.f19648c.onCompleted();
        }

        @Override // ea.a
        public void p() {
            this.f19648c.onNext(0);
            this.f19648c.onCompleted();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Context context, c uiFile, boolean z10, s handler, t callback) {
        super(context, uiFile, z10, handler, callback);
        int Y;
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(uiFile, "uiFile");
        kotlin.jvm.internal.i.f(handler, "handler");
        kotlin.jvm.internal.i.f(callback, "callback");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("GTW_");
        sb2.append((Object) uiFile.title);
        String str = uiFile.watchFaceDownloadUrl;
        kotlin.jvm.internal.i.e(str, "uiFile.watchFaceDownloadUrl");
        String str2 = uiFile.watchFaceDownloadUrl;
        kotlin.jvm.internal.i.e(str2, "uiFile.watchFaceDownloadUrl");
        Y = u.Y(str2, ".", 0, false, 6, null);
        String substring = str.substring(Y);
        kotlin.jvm.internal.i.e(substring, "(this as java.lang.String).substring(startIndex)");
        sb2.append(substring);
        this.f19645m = sb2.toString();
    }

    private final rx.c<Integer> A(final byte[] bArr) {
        k.f31276a = true;
        rx.c<Integer> i02 = rx.c.i0(new c.a() { // from class: com.mobvoi.mcuwatch.ui.customview.b
            @Override // yp.b
            public final void call(Object obj) {
                j.B(bArr, this, (i) obj);
            }
        });
        kotlin.jvm.internal.i.e(i02, "unsafeCreate {\n            ApolloHandler.changeDial(file, object : OnDialTransferListener {\n                override fun onProcess(percent: Int) {\n                    tvProgress.text = context.getString(R.string.syncing_format, percent)\n                    progressBar.progress = percent\n                    if (percent == 100) {\n                        McuStringUtil.SYNC_WATCHFACE_ING = false\n                        it.onNext(0)\n                        it.onCompleted()\n                    }\n                }\n\n                override fun onFail(code: Int) {\n                    McuStringUtil.SYNC_WATCHFACE_ING = false\n                    it.onNext(code)\n                    it.onCompleted()\n                }\n            })\n        }");
        return i02;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(byte[] file, j this$0, i iVar) {
        kotlin.jvm.internal.i.f(file, "$file");
        kotlin.jvm.internal.i.f(this$0, "this$0");
        q.f15504a.l(file, new a(iVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer C(j this$0, Integer num) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        return Integer.valueOf(g.a(this$0.f19657i.watchFaceDownloadUrl, kotlin.jvm.internal.i.n(this$0.getContext().getCacheDir().getPath(), File.separator), this$0.f19645m));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(j this$0, int i10) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (i10 == 0) {
            this$0.f19653e.setText(this$0.getContext().getString(sh.k.F2));
            this$0.G();
            return;
        }
        this$0.setCancelable(true);
        this$0.o();
        Toast.makeText(this$0.getContext(), sh.k.M0, 0).show();
    }

    private final rx.c<Integer> E(final int i10) {
        rx.c<Integer> i02 = rx.c.i0(new c.a() { // from class: com.mobvoi.mcuwatch.ui.customview.a
            @Override // yp.b
            public final void call(Object obj) {
                j.F(i10, (i) obj);
            }
        });
        kotlin.jvm.internal.i.e(i02, "unsafeCreate {\n            ApolloHandler.prepareChangeDial(fileSize, object : OnDialPrepareChange() {\n                override fun onPrepareChange() {\n                    it.onNext(0)\n                    it.onCompleted()\n                }\n\n                override fun onFail(state: Int) {\n                    it.onNext(state)\n                    it.onCompleted()\n                }\n            })\n        }");
        return i02;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(int i10, i iVar) {
        q.f15504a.C(i10, new b(iVar));
    }

    private final void G() {
        rx.c.A(getContext().getCacheDir().getPath() + ((Object) File.separator) + this.f19645m).D(i.f19643a).Z(cq.a.c()).H(xp.a.b()).v(new yp.g() { // from class: com.mobvoi.mcuwatch.ui.customview.g
            @Override // yp.g
            public final Object call(Object obj) {
                rx.c I;
                I = j.I(j.this, (byte[]) obj);
                return I;
            }
        }).X(new yp.b() { // from class: com.mobvoi.mcuwatch.ui.customview.e
            @Override // yp.b
            public final void call(Object obj) {
                j.L(j.this, (Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] H(String str) {
        byte[] a10;
        a10 = oo.g.a(new File(str));
        return a10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final rx.c I(final j this$0, final byte[] bArr) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (this$0.isShowing()) {
            return this$0.E(bArr.length).v(new yp.g() { // from class: com.mobvoi.mcuwatch.ui.customview.h
                @Override // yp.g
                public final Object call(Object obj) {
                    rx.c J;
                    J = j.J(j.this, bArr, (Integer) obj);
                    return J;
                }
            });
        }
        return rx.c.A(15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final rx.c J(final j this$0, byte[] byteArray, Integer num) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (num != null && num.intValue() == 0) {
            kotlin.jvm.internal.i.e(byteArray, "byteArray");
            return this$0.A(byteArray).p(new yp.b() { // from class: com.mobvoi.mcuwatch.ui.customview.d
                @Override // yp.b
                public final void call(Object obj) {
                    j.K(j.this, (Integer) obj);
                }
            });
        }
        if (num != null && num.intValue() == 1) {
            this$0.f19658j.sendEmptyMessage(13);
        } else if (num != null && num.intValue() == 255) {
            this$0.f19658j.sendEmptyMessage(12);
        }
        return rx.c.A(num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(j this$0, Integer num) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (num != null && num.intValue() == 1) {
            this$0.f19658j.sendEmptyMessage(14);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(j this$0, Integer code) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (code != null && code.intValue() == 0) {
            this$0.f19658j.sendEmptyMessage(0);
        } else if (code != null && code.intValue() == -1) {
            this$0.f19658j.sendEmptyMessage(10);
        } else if (code != null && code.intValue() == -3) {
            this$0.f19658j.sendEmptyMessage(11);
        } else {
            Handler handler = this$0.f19658j;
            kotlin.jvm.internal.i.e(code, "code");
            handler.sendEmptyMessage(code.intValue());
        }
    }

    @Override // com.mobvoi.mcuwatch.ui.customview.j0
    @SuppressLint({"MissingPermission"})
    public void n() {
        if (!m.b(getContext())) {
            Toast.makeText(getContext(), sh.k.M0, 0).show();
        } else if (!q.f15504a.B()) {
            Toast.makeText(getContext(), sh.k.S0, 0).show();
        } else {
            setCancelable(false);
            this.f19652d.setVisibility(8);
            this.f19654f.setVisibility(0);
            this.f19653e.setText(getContext().getString(sh.k.W2));
            rx.c.A(0).D(new yp.g() { // from class: com.mobvoi.mcuwatch.ui.customview.f
                @Override // yp.g
                public final Object call(Object obj) {
                    Integer C;
                    C = j.C(j.this, (Integer) obj);
                    return C;
                }
            }).Z(cq.a.c()).H(xp.a.b()).X(new yp.b() { // from class: com.mobvoi.mcuwatch.ui.customview.c
                @Override // yp.b
                public final void call(Object obj) {
                    j.D(j.this, ((Integer) obj).intValue());
                }
            });
        }
    }
}
