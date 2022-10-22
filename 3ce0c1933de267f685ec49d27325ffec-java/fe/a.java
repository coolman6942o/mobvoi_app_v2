package fe;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.huawei.hms.hmsscankit.ScanUtil;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: IntentIntegrator.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: i  reason: collision with root package name */
    private static final String f26401i = "a";

    /* renamed from: j  reason: collision with root package name */
    public static final Collection<String> f26402j = k("UPC_A", "UPC_E", "EAN_8", "EAN_13", "RSS_14");

    /* renamed from: k  reason: collision with root package name */
    public static final Collection<String> f26403k = k("UPC_A", "UPC_E", "EAN_8", "EAN_13", "CODE_39", "CODE_93", "CODE_128", "ITF", "RSS_14", "RSS_EXPANDED");

    /* renamed from: l  reason: collision with root package name */
    public static final Collection<String> f26404l = Collections.singleton("QR_CODE");

    /* renamed from: m  reason: collision with root package name */
    public static final List<String> f26405m = Collections.singletonList("com.google.zxing.client.android");

    /* renamed from: n  reason: collision with root package name */
    public static final List<String> f26406n = k("com.srowen.bs.android", "com.srowen.bs.android.simple", "com.google.zxing.client.android");

    /* renamed from: a  reason: collision with root package name */
    private final Activity f26407a;

    /* renamed from: c  reason: collision with root package name */
    private String f26409c;

    /* renamed from: d  reason: collision with root package name */
    private String f26410d;

    /* renamed from: e  reason: collision with root package name */
    private String f26411e;

    /* renamed from: f  reason: collision with root package name */
    private String f26412f;

    /* renamed from: g  reason: collision with root package name */
    private List<String> f26413g;

    /* renamed from: h  reason: collision with root package name */
    private final Map<String, Object> f26414h = new HashMap(3);

    /* renamed from: b  reason: collision with root package name */
    private final Fragment f26408b = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IntentIntegrator.java */
    /* renamed from: fe.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class DialogInterface$OnClickListenerC0286a implements DialogInterface.OnClickListener {
        DialogInterface$OnClickListenerC0286a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            String str = "com.google.zxing.client.android";
            if (!a.this.f26413g.contains(str)) {
                str = (String) a.this.f26413g.get(0);
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
            try {
                if (a.this.f26408b == null) {
                    a.this.f26407a.startActivity(intent);
                } else {
                    a.this.f26408b.startActivity(intent);
                }
            } catch (ActivityNotFoundException unused) {
                String str2 = a.f26401i;
                Log.w(str2, "Google Play is not installed; cannot install " + str);
            }
        }
    }

    static {
        Collections.singleton("DATA_MATRIX");
    }

    public a(Activity activity) {
        this.f26407a = activity;
        h();
    }

    private void e(Intent intent) {
        for (Map.Entry<String, Object> entry : this.f26414h.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Integer) {
                intent.putExtra(key, (Integer) value);
            } else if (value instanceof Long) {
                intent.putExtra(key, (Long) value);
            } else if (value instanceof Boolean) {
                intent.putExtra(key, (Boolean) value);
            } else if (value instanceof Double) {
                intent.putExtra(key, (Double) value);
            } else if (value instanceof Float) {
                intent.putExtra(key, (Float) value);
            } else if (value instanceof Bundle) {
                intent.putExtra(key, (Bundle) value);
            } else {
                intent.putExtra(key, value.toString());
            }
        }
    }

    private static boolean f(Iterable<ResolveInfo> iterable, String str) {
        for (ResolveInfo resolveInfo : iterable) {
            if (str.equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
        }
        return false;
    }

    private String g(Intent intent) {
        List<ResolveInfo> queryIntentActivities = this.f26407a.getPackageManager().queryIntentActivities(intent, WXMediaMessage.THUMB_LENGTH_LIMIT);
        if (queryIntentActivities == null) {
            return null;
        }
        for (String str : this.f26413g) {
            if (f(queryIntentActivities, str)) {
                return str;
            }
        }
        return null;
    }

    private void h() {
        this.f26409c = "Install Barcode Scanner?";
        this.f26410d = "This application requires Barcode Scanner. Would you like to install it?";
        this.f26411e = "Yes";
        this.f26412f = "No";
        this.f26413g = f26406n;
    }

    private static List<String> k(String... strArr) {
        return Collections.unmodifiableList(Arrays.asList(strArr));
    }

    public static b l(int i10, int i11, Intent intent) {
        Integer num = null;
        if (i10 != 49374) {
            return null;
        }
        if (i11 != -1) {
            return new b();
        }
        String stringExtra = intent.getStringExtra(ScanUtil.RESULT);
        String stringExtra2 = intent.getStringExtra("SCAN_RESULT_FORMAT");
        byte[] byteArrayExtra = intent.getByteArrayExtra("SCAN_RESULT_BYTES");
        int intExtra = intent.getIntExtra("SCAN_RESULT_ORIENTATION", Integer.MIN_VALUE);
        if (intExtra != Integer.MIN_VALUE) {
            num = Integer.valueOf(intExtra);
        }
        return new b(stringExtra, stringExtra2, byteArrayExtra, num, intent.getStringExtra("SCAN_RESULT_ERROR_CORRECTION_LEVEL"));
    }

    private AlertDialog m() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f26407a);
        builder.setTitle(this.f26409c);
        builder.setMessage(this.f26410d);
        builder.setPositiveButton(this.f26411e, new DialogInterface$OnClickListenerC0286a());
        builder.setNegativeButton(this.f26412f, (DialogInterface.OnClickListener) null);
        builder.setCancelable(true);
        return builder.show();
    }

    public final AlertDialog i(Collection<String> collection) {
        return j(collection, -1);
    }

    public final AlertDialog j(Collection<String> collection, int i10) {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.addCategory("android.intent.category.DEFAULT");
        if (collection != null) {
            StringBuilder sb2 = new StringBuilder();
            for (String str : collection) {
                if (sb2.length() > 0) {
                    sb2.append(',');
                }
                sb2.append(str);
            }
            intent.putExtra("SCAN_FORMATS", sb2.toString());
        }
        if (i10 >= 0) {
            intent.putExtra("SCAN_CAMERA_ID", i10);
        }
        String g10 = g(intent);
        if (g10 == null) {
            return m();
        }
        intent.setPackage(g10);
        intent.addFlags(67108864);
        intent.addFlags(524288);
        e(intent);
        n(intent, 49374);
        return null;
    }

    protected void n(Intent intent, int i10) {
        Fragment fragment = this.f26408b;
        if (fragment == null) {
            this.f26407a.startActivityForResult(intent, i10);
        } else {
            fragment.startActivityForResult(intent, i10);
        }
    }
}
