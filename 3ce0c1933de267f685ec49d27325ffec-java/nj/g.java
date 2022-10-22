package nj;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.n;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.f;
import androidx.lifecycle.w;
import androidx.lifecycle.x;
import bd.a;
import com.mobvoi.wear.common.base.TicwatchModels;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import java.util.ArrayList;
import k7.b;
import kc.d;
import kotlin.jvm.internal.i;
import kotlin.text.t;
import kotlin.text.u;
import sh.k;
/* compiled from: ApolloDevicePageUiHelper.kt */
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f31271a = new g();

    /* renamed from: b  reason: collision with root package name */
    private static final w<Boolean> f31272b = new w<>(Boolean.FALSE);

    static {
        new ArrayList();
    }

    private g() {
    }

    public static final void f(final Fragment fragment) {
        i.f(fragment, "fragment");
        f31272b.i(fragment.getViewLifecycleOwner(), new x() { // from class: nj.f
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                g.g(Fragment.this, ((Boolean) obj).booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(final Fragment fragment, boolean z10) {
        i.f(fragment, "$fragment");
        if (z10 && q.g().l() == 5) {
            if (!d.a(fragment.requireContext())) {
                final f requireActivity = fragment.requireActivity();
                i.e(requireActivity, "fragment.requireActivity()");
                new b(requireActivity).h(k.O1).d(false).j(k.M1, new DialogInterface.OnClickListener() { // from class: nj.c
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) {
                        g.h(Fragment.this, dialogInterface, i10);
                    }
                }).m(k.N1, new DialogInterface.OnClickListener() { // from class: nj.d
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) {
                        g.i(f.this, fragment, dialogInterface, i10);
                    }
                }).t();
            }
            f31272b.o(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Fragment fragment, DialogInterface dialog, int i10) {
        i.f(fragment, "$fragment");
        i.f(dialog, "dialog");
        dialog.dismiss();
        Context requireContext = fragment.requireContext();
        i.e(requireContext, "fragment.requireContext()");
        k(requireContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(f activity, Fragment fragment, DialogInterface dialog, int i10) {
        i.f(activity, "$activity");
        i.f(fragment, "$fragment");
        i.f(dialog, "dialog");
        dialog.dismiss();
        activity.startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
        Context requireContext = fragment.requireContext();
        i.e(requireContext, "fragment.requireContext()");
        k(requireContext);
    }

    public static final String j(String str) {
        boolean I;
        String z10;
        if (str == null || str.length() == 0) {
            return TicwatchModels.TICWATCH_GTW_eSIM;
        }
        I = u.I(str, "eSIM", false, 2, null);
        if (I) {
            return str;
        }
        z10 = t.z(str, "TicWatch GTW", TicwatchModels.TICWATCH_GTW_eSIM, false, 4, null);
        return z10;
    }

    public static final void k(final Context context) {
        i.f(context, "context");
        if (Build.VERSION.SDK_INT >= 29 && !n.f(context).a()) {
            aa.b.f163a.e(context, SharedWearInfoHelper.TaskInfo.TABLE);
            Activity h10 = a.g().h();
            if (h10 != null) {
                new b(h10).h(k.Q1).d(false).j(k.M1, e.f31269a).m(k.N1, new DialogInterface.OnClickListener() { // from class: nj.b
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) {
                        g.m(context, dialogInterface, i10);
                    }
                }).t();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(DialogInterface dialog, int i10) {
        i.f(dialog, "dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Context context, DialogInterface dialog, int i10) {
        i.f(context, "$context");
        i.f(dialog, "dialog");
        dialog.dismiss();
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
        intent.putExtra("android.provider.extra.CHANNEL_ID", SharedWearInfoHelper.TaskInfo.TABLE);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static final void n(boolean z10) {
        f31272b.m(Boolean.valueOf(z10));
        Application context = com.mobvoi.android.common.utils.b.e();
        if (z10 && d.a(context)) {
            i.e(context, "context");
            k(context);
        }
    }
}
