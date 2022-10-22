package com.mobvoi.mcuwatch.ui.customview;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.f;
import bn.c;
import kotlin.jvm.internal.i;
import sh.k;
import sh.l;
import zh.m;
/* compiled from: CustomDialTransDialog.kt */
/* loaded from: classes2.dex */
public final class n extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private final f f19673a;

    /* renamed from: b  reason: collision with root package name */
    private final Bitmap f19674b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f19675c;

    /* renamed from: d  reason: collision with root package name */
    private final t f19676d;

    /* renamed from: e  reason: collision with root package name */
    private m f19677e;

    /* compiled from: CustomDialTransDialog.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(f activity, Bitmap bitmap, boolean z10, t tVar) {
        super(activity, l.a_res_0x7f150001);
        i.f(activity, "activity");
        this.f19673a = activity;
        this.f19674b = bitmap;
        this.f19675c = z10;
        this.f19676d = tVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(n this$0, View view) {
        i.f(this$0, "this$0");
        this$0.d();
    }

    private final void d() {
        t tVar = this.f19676d;
        if (tVar != null) {
            tVar.n();
        }
    }

    private final void f() {
        m mVar = this.f19677e;
        if (mVar != null) {
            mVar.f37560c.setOval(!this.f19675c);
            if (this.f19675c) {
                m mVar2 = this.f19677e;
                if (mVar2 != null) {
                    mVar2.f37560c.setCornerRadius(32.0f);
                } else {
                    i.u("binding");
                    throw null;
                }
            }
            m mVar3 = this.f19677e;
            if (mVar3 != null) {
                mVar3.f37560c.setImageBitmap(this.f19674b);
            } else {
                i.u("binding");
                throw null;
            }
        } else {
            i.u("binding");
            throw null;
        }
    }

    public final void b() {
        m d10 = m.d(LayoutInflater.from(this.f19673a));
        i.e(d10, "inflate(\n            LayoutInflater.from(\n                activity\n            )\n        )");
        this.f19677e = d10;
        if (d10 != null) {
            setContentView(d10.a());
            f();
            m mVar = this.f19677e;
            if (mVar != null) {
                mVar.f37565h.setText(k.L0);
                m mVar2 = this.f19677e;
                if (mVar2 != null) {
                    mVar2.f37559b.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.customview.m
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            n.c(n.this, view);
                        }
                    });
                } else {
                    i.u("binding");
                    throw null;
                }
            } else {
                i.u("binding");
                throw null;
            }
        } else {
            i.u("binding");
            throw null;
        }
    }

    public final void e(int i10) {
        if (i10 == 0) {
            m mVar = this.f19677e;
            if (mVar != null) {
                mVar.f37561d.setProgress(i10);
            } else {
                i.u("binding");
                throw null;
            }
        } else {
            m mVar2 = this.f19677e;
            if (mVar2 == null) {
                i.u("binding");
                throw null;
            } else if (i10 > mVar2.f37561d.getProgress()) {
                m mVar3 = this.f19677e;
                if (mVar3 != null) {
                    mVar3.f37563f.setText(this.f19673a.getString(k.G2, new Object[]{Integer.valueOf(i10)}));
                    m mVar4 = this.f19677e;
                    if (mVar4 != null) {
                        mVar4.f37561d.setProgress(i10);
                    } else {
                        i.u("binding");
                        throw null;
                    }
                } else {
                    i.u("binding");
                    throw null;
                }
            }
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = c.b(getContext()) - c.a(getContext(), 76);
            window.setAttributes(attributes);
        }
        onStart();
    }

    @Override // android.app.Dialog
    public void onStart() {
        setCancelable(false);
        m mVar = this.f19677e;
        if (mVar != null) {
            mVar.f37564g.setVisibility(8);
            m mVar2 = this.f19677e;
            if (mVar2 != null) {
                mVar2.f37562e.setVisibility(0);
                m mVar3 = this.f19677e;
                if (mVar3 != null) {
                    mVar3.f37563f.setText(this.f19673a.getString(k.F2));
                } else {
                    i.u("binding");
                    throw null;
                }
            } else {
                i.u("binding");
                throw null;
            }
        } else {
            i.u("binding");
            throw null;
        }
    }
}
