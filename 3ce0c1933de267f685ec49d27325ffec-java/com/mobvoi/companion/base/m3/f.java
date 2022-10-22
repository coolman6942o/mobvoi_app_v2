package com.mobvoi.companion.base.m3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.c;
import gc.d;
import gc.e;
import k7.b;
import kotlin.jvm.internal.i;
/* compiled from: DialogUtils.kt */
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f16573a = new f();

    private f() {
    }

    public final c a(Context context, int i10) {
        i.f(context, "context");
        String string = context.getString(i10);
        i.e(string, "context.getString(resId)");
        return b(context, string);
    }

    public final c b(Context context, CharSequence text) {
        i.f(context, "context");
        i.f(text, "text");
        View inflate = LayoutInflater.from(context).inflate(e.f27357d, (ViewGroup) null);
        ((TextView) inflate.findViewById(d.f27345p)).setText(text);
        c a10 = new b(context).s(inflate).d(false).a();
        i.e(a10, "MaterialAlertDialogBuilder(context)\n            .setView(progress)\n            .setCancelable(false)\n            .create()");
        return a10;
    }
}
