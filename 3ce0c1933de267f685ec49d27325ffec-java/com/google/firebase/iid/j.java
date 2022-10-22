package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.f;
import c8.b;
import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.e;
import com.google.firebase.iid.zzi;
import com.mobvoi.wear.providers.OtaColumn;
import com.tendcloud.tenddata.ab;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: g  reason: collision with root package name */
    private static int f12487g;

    /* renamed from: h  reason: collision with root package name */
    private static PendingIntent f12488h;

    /* renamed from: b  reason: collision with root package name */
    private final Context f12490b;

    /* renamed from: c  reason: collision with root package name */
    private final b f12491c;

    /* renamed from: e  reason: collision with root package name */
    private Messenger f12493e;

    /* renamed from: f  reason: collision with root package name */
    private zzi f12494f;

    /* renamed from: a  reason: collision with root package name */
    private final f<String, c<Bundle>> f12489a = new f<>();

    /* renamed from: d  reason: collision with root package name */
    private Messenger f12492d = new Messenger(new k(this, Looper.getMainLooper()));

    public j(Context context, b bVar) {
        this.f12490b = context;
        this.f12491c = bVar;
    }

    private static synchronized void a(Context context, Intent intent) {
        synchronized (j.class) {
            if (f12488h == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                f12488h = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra(OtaColumn.COLUMN_APP, f12488h);
        }
    }

    private final void c(String str, Bundle bundle) {
        synchronized (this.f12489a) {
            c<Bundle> remove = this.f12489a.remove(str);
            if (remove == null) {
                String valueOf = String.valueOf(str);
                Log.w("FirebaseInstanceId", valueOf.length() != 0 ? "Missing callback for ".concat(valueOf) : new String("Missing callback for "));
                return;
            }
            remove.c(bundle);
        }
    }

    private static synchronized String d() {
        String num;
        synchronized (j.class) {
            int i10 = f12487g;
            f12487g = i10 + 1;
            num = Integer.toString(i10);
        }
        return num;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(Message message) {
        String str;
        String str2;
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new zzi.a());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof zzi) {
                        this.f12494f = (zzi) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.f12493e = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                if ("com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                    String stringExtra = intent2.getStringExtra("registration_id");
                    if (stringExtra == null) {
                        stringExtra = intent2.getStringExtra("unregistered");
                    }
                    if (stringExtra == null) {
                        String stringExtra2 = intent2.getStringExtra("error");
                        if (stringExtra2 == null) {
                            String valueOf = String.valueOf(intent2.getExtras());
                            StringBuilder sb2 = new StringBuilder(valueOf.length() + 49);
                            sb2.append("Unexpected response, no error or registration id ");
                            sb2.append(valueOf);
                            Log.w("FirebaseInstanceId", sb2.toString());
                            return;
                        }
                        if (Log.isLoggable("FirebaseInstanceId", 3)) {
                            Log.d("FirebaseInstanceId", stringExtra2.length() != 0 ? "Received InstanceID error ".concat(stringExtra2) : new String("Received InstanceID error "));
                        }
                        if (stringExtra2.startsWith("|")) {
                            String[] split = stringExtra2.split("\\|");
                            if (split.length <= 2 || !"ID".equals(split[1])) {
                                str = "FirebaseInstanceId";
                                str2 = stringExtra2.length() != 0 ? "Unexpected structured response ".concat(stringExtra2) : new String("Unexpected structured response ");
                                Log.w(str, str2);
                            }
                            String str3 = split[2];
                            String str4 = split[3];
                            if (str4.startsWith(":")) {
                                str4 = str4.substring(1);
                            }
                            c(str3, intent2.putExtra("error", str4).getExtras());
                            return;
                        }
                        synchronized (this.f12489a) {
                            for (int i10 = 0; i10 < this.f12489a.size(); i10++) {
                                c(this.f12489a.j(i10), intent2.getExtras());
                            }
                        }
                        return;
                    }
                    Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
                    if (matcher.matches()) {
                        String group = matcher.group(1);
                        String group2 = matcher.group(2);
                        Bundle extras = intent2.getExtras();
                        extras.putString("registration_id", group2);
                        c(group, extras);
                        return;
                    } else if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        Log.d("FirebaseInstanceId", stringExtra.length() != 0 ? "Unexpected response string: ".concat(stringExtra) : new String("Unexpected response string: "));
                        return;
                    } else {
                        return;
                    }
                } else if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf2 = String.valueOf(action);
                    Log.d("FirebaseInstanceId", valueOf2.length() != 0 ? "Unexpected response action: ".concat(valueOf2) : new String("Unexpected response action: "));
                    return;
                } else {
                    return;
                }
            }
        }
        str = "FirebaseInstanceId";
        str2 = "Dropping invalid message";
        Log.w(str, str2);
    }

    private final Bundle g(Bundle bundle) throws IOException {
        Bundle h10 = h(bundle);
        if (h10 == null || !h10.containsKey("google.messenger")) {
            return h10;
        }
        Bundle h11 = h(bundle);
        if (h11 == null || !h11.containsKey("google.messenger")) {
            return h11;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Bundle h(Bundle bundle) throws IOException {
        String d10 = d();
        c<Bundle> cVar = new c<>();
        synchronized (this.f12489a) {
            this.f12489a.put(d10, cVar);
        }
        if (this.f12491c.f() != 0) {
            Intent intent = new Intent();
            intent.setPackage("com.google.android.gms");
            intent.setAction(this.f12491c.f() == 2 ? "com.google.iid.TOKEN_REQUEST" : "com.google.android.c2dm.intent.REGISTER");
            intent.putExtras(bundle);
            a(this.f12490b, intent);
            StringBuilder sb2 = new StringBuilder(String.valueOf(d10).length() + 5);
            sb2.append("|ID|");
            sb2.append(d10);
            sb2.append("|");
            intent.putExtra("kid", sb2.toString());
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(intent.getExtras());
                StringBuilder sb3 = new StringBuilder(valueOf.length() + 8);
                sb3.append("Sending ");
                sb3.append(valueOf);
                Log.d("FirebaseInstanceId", sb3.toString());
            }
            intent.putExtra("google.messenger", this.f12492d);
            try {
                try {
                    if (!(this.f12493e == null && this.f12494f == null)) {
                        Message obtain = Message.obtain();
                        obtain.obj = intent;
                        try {
                            Messenger messenger = this.f12493e;
                            if (messenger != null) {
                                messenger.send(obtain);
                            } else {
                                this.f12494f.b(obtain);
                            }
                        } catch (RemoteException unused) {
                            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                                Log.d("FirebaseInstanceId", "Messenger failed, fallback to startService");
                            }
                        }
                        Bundle bundle2 = (Bundle) e.b(cVar.a(), ab.Y, TimeUnit.MILLISECONDS);
                        synchronized (this.f12489a) {
                            this.f12489a.remove(d10);
                        }
                        return bundle2;
                    }
                    Bundle bundle22 = (Bundle) e.b(cVar.a(), ab.Y, TimeUnit.MILLISECONDS);
                    synchronized (this.f12489a) {
                    }
                } catch (InterruptedException | TimeoutException unused2) {
                    Log.w("FirebaseInstanceId", "No response");
                    throw new IOException("TIMEOUT");
                } catch (ExecutionException e10) {
                    throw new IOException(e10);
                }
            } catch (Throwable th2) {
                synchronized (this.f12489a) {
                    this.f12489a.remove(d10);
                    throw th2;
                }
            }
            if (this.f12491c.f() == 2) {
                this.f12490b.sendBroadcast(intent);
            } else {
                this.f12490b.startService(intent);
            }
        } else {
            throw new IOException("MISSING_INSTANCEID_SERVICE");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle f(Bundle bundle) throws IOException {
        if (this.f12491c.c() < 12000000) {
            return g(bundle);
        }
        try {
            return (Bundle) e.a(z.f(this.f12490b).d(1, bundle));
        } catch (InterruptedException | ExecutionException e10) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e10);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 22);
                sb2.append("Error making request: ");
                sb2.append(valueOf);
                Log.d("FirebaseInstanceId", sb2.toString());
            }
            if (!(e10.getCause() instanceof zzac) || ((zzac) e10.getCause()).getErrorCode() != 4) {
                return null;
            }
            return g(bundle);
        }
    }
}
