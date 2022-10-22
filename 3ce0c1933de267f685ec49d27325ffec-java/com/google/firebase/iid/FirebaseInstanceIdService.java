package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;
import c8.c;
/* loaded from: classes.dex */
public class FirebaseInstanceIdService extends c {
    @Override // c8.c
    protected final Intent c(Intent intent) {
        return l.c().f12499c.poll();
    }

    @Override // c8.c
    public final void e(Intent intent) {
        if ("com.google.firebase.iid.TOKEN_REFRESH".equals(intent.getAction())) {
            f();
            return;
        }
        String stringExtra = intent.getStringExtra("CMD");
        if (stringExtra != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(intent.getExtras());
                StringBuilder sb2 = new StringBuilder(stringExtra.length() + 21 + valueOf.length());
                sb2.append("Received command: ");
                sb2.append(stringExtra);
                sb2.append(" - ");
                sb2.append(valueOf);
                Log.d("FirebaseInstanceId", sb2.toString());
            }
            if ("RST".equals(stringExtra) || "RST_FULL".equals(stringExtra)) {
                FirebaseInstanceId.b().v();
            } else if ("SYNC".equals(stringExtra)) {
                FirebaseInstanceId.b().w();
            }
        }
    }

    public void f() {
    }
}
