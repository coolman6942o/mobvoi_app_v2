package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.a;
import androidx.core.content.b;
import java.io.File;
import java.io.IOException;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f12501a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f12502b;

    /* renamed from: c  reason: collision with root package name */
    private final w f12503c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, x> f12504d;

    public m(Context context) {
        this(context, new w());
    }

    private m(Context context, w wVar) {
        this.f12504d = new a();
        this.f12502b = context;
        this.f12501a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.f12503c = wVar;
        File file = new File(b.h(context), "com.google.android.gms.appid-no-backup");
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !a()) {
                    Log.i("FirebaseInstanceId", "App restored, clearing state");
                    e();
                    FirebaseInstanceId.b().v();
                }
            } catch (IOException e10) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(e10.getMessage());
                    Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Error creating file in no backup dir: ".concat(valueOf) : new String("Error creating file in no backup dir: "));
                }
            }
        }
    }

    private final synchronized boolean a() {
        return this.f12501a.getAll().isEmpty();
    }

    private static String b(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb2.append(str);
        sb2.append("|T|");
        sb2.append(str2);
        sb2.append("|");
        sb2.append(str3);
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g(String str, String str2) {
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append("|S|");
        sb2.append(str2);
        return sb2.toString();
    }

    public final synchronized void c(String str, String str2, String str3, String str4, String str5) {
        String a10 = n.a(str4, str5, System.currentTimeMillis());
        if (a10 != null) {
            SharedPreferences.Editor edit = this.f12501a.edit();
            edit.putString(b(str, str2, str3), a10);
            edit.commit();
        }
    }

    public final synchronized String d() {
        String string = this.f12501a.getString("topic_operaion_queue", null);
        if (string != null) {
            String[] split = string.split(",");
            if (split.length > 1 && !TextUtils.isEmpty(split[1])) {
                return split[1];
            }
        }
        return null;
    }

    public final synchronized void e() {
        this.f12504d.clear();
        w.c(this.f12502b);
        this.f12501a.edit().clear().commit();
    }

    public final synchronized n f(String str, String str2, String str3) {
        return n.b(this.f12501a.getString(b(str, str2, str3), null));
    }

    public final synchronized boolean h(String str) {
        boolean z10;
        String string = this.f12501a.getString("topic_operaion_queue", "");
        String valueOf = String.valueOf(str);
        if (string.startsWith(valueOf.length() != 0 ? ",".concat(valueOf) : new String(","))) {
            String valueOf2 = String.valueOf(str);
            this.f12501a.edit().putString("topic_operaion_queue", string.substring((valueOf2.length() != 0 ? ",".concat(valueOf2) : new String(",")).length())).apply();
            z10 = true;
        } else {
            z10 = false;
        }
        return z10;
    }

    public final synchronized x i(String str) {
        x xVar;
        x xVar2 = this.f12504d.get(str);
        if (xVar2 != null) {
            return xVar2;
        }
        try {
            xVar = this.f12503c.h(this.f12502b, str);
        } catch (y unused) {
            Log.w("FirebaseInstanceId", "Stored data is corrupt, generating new identity");
            FirebaseInstanceId.b().v();
            xVar = this.f12503c.k(this.f12502b, str);
        }
        this.f12504d.put(str, xVar);
        return xVar;
    }

    public final synchronized void j(String str) {
        String concat = String.valueOf(str).concat("|T|");
        SharedPreferences.Editor edit = this.f12501a.edit();
        for (String str2 : this.f12501a.getAll().keySet()) {
            if (str2.startsWith(concat)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }
}
