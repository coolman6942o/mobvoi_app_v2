package com.mobvoi.mcuwatch.ui.customview;

import android.content.Context;
import com.mobvoi.mcuwatch.ui.customview.l;
import jc.a;
import sh.f;
import sh.k;
/* compiled from: ShowAlphaDialog.java */
/* loaded from: classes2.dex */
public class y {

    /* compiled from: ShowAlphaDialog.java */
    /* loaded from: classes2.dex */
    class a implements a.AbstractC0354a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ jc.a f19706a;

        a(jc.a aVar) {
            this.f19706a = aVar;
        }

        @Override // jc.a.AbstractC0354a
        public void a() {
            this.f19706a.dismiss();
        }

        @Override // jc.a.AbstractC0354a
        public void onCancel() {
            this.f19706a.dismiss();
        }
    }

    public static jc.a a(Context context, String str) {
        jc.a aVar = new jc.a(context);
        aVar.i(str);
        aVar.b(context.getString(17039370));
        aVar.d(new a(aVar));
        return aVar;
    }

    public static void b(int i10, Context context) {
        l.a aVar = new l.a(context);
        aVar.b().show();
        if (i10 == 1) {
            aVar.e(context.getResources().getString(k.S0));
        } else if (i10 == 2) {
            aVar.e(context.getResources().getString(k.G1));
        } else if (i10 == 10) {
            aVar.e(context.getResources().getString(k.P0));
            aVar.d(f.Q0);
        } else if (i10 == 28) {
            aVar.f(false);
            aVar.d(f.f34531a1);
        }
    }
}
