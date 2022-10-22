package nd;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.content.FileProvider;
import ee.c;
import ee.d;
import ee.e;
import ee.f;
import java.io.File;
/* compiled from: OverseaShareUtil.java */
/* loaded from: classes2.dex */
class b {
    private static void b(Dialog dialog, View view, Activity activity, String str, String str2, String str3, Uri uri) {
        e(dialog, view, activity, str, str2, str3, uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(Activity activity, String str, String str2, String str3, Uri uri, Dialog dialog, AdapterView adapterView, View view, int i10, long j10) {
        ResolveInfo resolveInfo = (ResolveInfo) adapterView.getAdapter().getItem(i10);
        if (resolveInfo != null) {
            d(activity, resolveInfo, str, str2, str3, "text/*", uri);
        }
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    private static void d(Activity activity, ResolveInfo resolveInfo, String str, String str2, String str3, String str4, Uri uri) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(str4);
        if (uri != null) {
            intent.putExtra("android.intent.extra.STREAM", uri);
        }
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        intent.setClassName(activityInfo.packageName, activityInfo.name);
        intent.putExtra("android.intent.extra.SUBJECT", str3);
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.putExtra("android.intent.extra.TITLE", str2);
        activity.startActivity(intent);
    }

    private static void e(final Dialog dialog, View view, final Activity activity, final String str, final String str2, final String str3, final Uri uri) {
        GridView gridView = (GridView) view.findViewById(c.c_res_0x7f0b02c6);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/*");
        gridView.setAdapter((ListAdapter) new c(activity, activity.getPackageManager().queryIntentActivities(intent, 0)));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: nd.a
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i10, long j10) {
                b.c(activity, str, str2, str3, uri, dialog, adapterView, view2, i10, j10);
            }
        });
    }

    private static void f(Activity activity, String str, String str2, String str3, Uri uri) {
        Dialog dialog = new Dialog(activity, f.b_res_0x7f150522);
        View inflate = LayoutInflater.from(activity).inflate(d.a_res_0x7f0e009d, (ViewGroup) null);
        b(dialog, inflate, activity, str, str2, str3, uri);
        dialog.setContentView(inflate);
        Window window = dialog.getWindow();
        window.setGravity(80);
        window.setWindowAnimations(f.a_res_0x7f15051d);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = activity.getResources().getDisplayMetrics().widthPixels;
        attributes.height = -2;
        attributes.alpha = 9.0f;
        window.setAttributes(attributes);
        dialog.show();
    }

    public static void g(Context context) {
        File a10 = ic.d.a(context);
        if (a10 != null) {
            Uri fromFile = Uri.fromFile(a10);
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 24) {
                fromFile = FileProvider.e(context, context.getPackageName() + ".fileProvider", a10);
            }
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", fromFile);
            intent.setType("image/*");
            Intent createChooser = Intent.createChooser(intent, context.getString(e.f25900k));
            createChooser.setFlags(268435456);
            if (i10 >= 24) {
                createChooser.setFlags(268435457);
            }
            context.startActivity(createChooser);
        }
    }

    public static void h(Activity activity, String str, String str2, String str3, int i10) {
        f(activity, str, str2, str3, null);
    }
}
