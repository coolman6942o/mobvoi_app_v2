package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import c8.c;
import com.google.android.gms.tasks.b;
import com.google.android.gms.tasks.e;
import com.google.firebase.iid.l;
import com.google.firebase.iid.z;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
public class FirebaseMessagingService extends c {

    /* renamed from: f  reason: collision with root package name */
    private static final Queue<String> f12535f = new ArrayDeque(10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void k(Bundle bundle) {
        Iterator<String> it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next != null && next.startsWith("google.c.")) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean l(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return "1".equals(bundle.getString("google.c.a.e"));
    }

    @Override // c8.c
    protected final Intent c(Intent intent) {
        return l.c().d();
    }

    @Override // c8.c
    public final boolean d(Intent intent) {
        if (!"com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            return false;
        }
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("FirebaseMessaging", "Notification pending intent canceled");
            }
        }
        if (!l(intent.getExtras())) {
            return true;
        }
        b.c(this, intent);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c7, code lost:
        if (r2.equals("send_error") == false) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a1  */
    @Override // c8.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(Intent intent) {
        b<Void> bVar;
        boolean z10;
        String action = intent.getAction();
        if (action == null) {
            action = "";
        }
        if (!action.equals("com.google.firebase.messaging.NOTIFICATION_DISMISS")) {
            if (!action.equals("com.google.android.c2dm.intent.RECEIVE")) {
                String valueOf = String.valueOf(intent.getAction());
                Log.d("FirebaseMessaging", valueOf.length() != 0 ? "Unknown intent action: ".concat(valueOf) : new String("Unknown intent action: "));
                return;
            }
            String stringExtra = intent.getStringExtra("google.message_id");
            char c10 = 2;
            if (TextUtils.isEmpty(stringExtra)) {
                bVar = e.e(null);
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("google.message_id", stringExtra);
                bVar = z.f(this).b(2, bundle);
            }
            try {
                if (!TextUtils.isEmpty(stringExtra)) {
                    Queue<String> queue = f12535f;
                    if (queue.contains(stringExtra)) {
                        if (Log.isLoggable("FirebaseMessaging", 3)) {
                            String valueOf2 = String.valueOf(stringExtra);
                            Log.d("FirebaseMessaging", valueOf2.length() != 0 ? "Received duplicate message: ".concat(valueOf2) : new String("Received duplicate message: "));
                        }
                        z10 = true;
                        if (!z10) {
                            String stringExtra2 = intent.getStringExtra("message_type");
                            if (stringExtra2 == null) {
                                stringExtra2 = "gcm";
                            }
                            c10 = 65535;
                            switch (stringExtra2.hashCode()) {
                                case -2062414158:
                                    if (stringExtra2.equals("deleted_messages")) {
                                        c10 = 0;
                                        break;
                                    }
                                    break;
                                case 102161:
                                    if (stringExtra2.equals("gcm")) {
                                        c10 = 1;
                                        break;
                                    }
                                    break;
                                case 814694033:
                                    break;
                                case 814800675:
                                    if (stringExtra2.equals("send_event")) {
                                        c10 = 3;
                                        break;
                                    }
                                    break;
                            }
                            switch (c10) {
                                case 0:
                                    f();
                                    break;
                                case 1:
                                    if (l(intent.getExtras())) {
                                        b.b(this, intent);
                                    }
                                    Bundle extras = intent.getExtras();
                                    if (extras == null) {
                                        extras = new Bundle();
                                    }
                                    extras.remove("androidx.contentpager.content.wakelockid");
                                    if (a.j(extras)) {
                                        if (!a.h(this).l(extras)) {
                                            if (l(extras)) {
                                                b.e(this, intent);
                                            }
                                        }
                                    }
                                    g(new RemoteMessage(extras));
                                    break;
                                case 2:
                                    String stringExtra3 = intent.getStringExtra("google.message_id");
                                    if (stringExtra3 == null) {
                                        stringExtra3 = intent.getStringExtra("message_id");
                                    }
                                    j(stringExtra3, new SendException(intent.getStringExtra("error")));
                                    break;
                                case 3:
                                    i(intent.getStringExtra("google.message_id"));
                                    break;
                                default:
                                    Log.w("FirebaseMessaging", stringExtra2.length() != 0 ? "Received message with unknown type: ".concat(stringExtra2) : new String("Received message with unknown type: "));
                                    break;
                            }
                        }
                        e.b(bVar, 1L, TimeUnit.SECONDS);
                        return;
                    }
                    if (queue.size() >= 10) {
                        queue.remove();
                    }
                    queue.add(stringExtra);
                }
                e.b(bVar, 1L, TimeUnit.SECONDS);
                return;
            } catch (InterruptedException | ExecutionException | TimeoutException e10) {
                String valueOf3 = String.valueOf(e10);
                StringBuilder sb2 = new StringBuilder(valueOf3.length() + 20);
                sb2.append("Message ack failed: ");
                sb2.append(valueOf3);
                Log.w("FirebaseMessaging", sb2.toString());
                return;
            }
            z10 = false;
            if (!z10) {
            }
        } else if (l(intent.getExtras())) {
            b.d(this, intent);
        }
    }

    public void f() {
    }

    public void g(RemoteMessage remoteMessage) {
    }

    public void i(String str) {
    }

    public void j(String str, Exception exc) {
    }
}
