package x5;

import b6.i;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.n;
import e6.a;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    private static final a f36451c = new a("RevokeAccessOperation", new String[0]);

    /* renamed from: a  reason: collision with root package name */
    private final String f36452a;

    /* renamed from: b  reason: collision with root package name */
    private final n f36453b = new n(null);

    private c(String str) {
        i.g(str);
        this.f36452a = str;
    }

    public static e<Status> a(String str) {
        if (str == null) {
            return f.a(new Status(4), null);
        }
        c cVar = new c(str);
        new Thread(cVar).start();
        return cVar.f36453b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Status status = Status.f8445f;
        try {
            String valueOf = String.valueOf(this.f36452a);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(valueOf.length() != 0 ? "https://accounts.google.com/o/oauth2/revoke?token=".concat(valueOf) : new String("https://accounts.google.com/o/oauth2/revoke?token=")).openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                status = Status.f8444e;
            } else {
                f36451c.b("Unable to revoke access!", new Object[0]);
            }
            a aVar = f36451c;
            StringBuilder sb2 = new StringBuilder(26);
            sb2.append("Response Code: ");
            sb2.append(responseCode);
            aVar.a(sb2.toString(), new Object[0]);
        } catch (IOException e10) {
            a aVar2 = f36451c;
            String valueOf2 = String.valueOf(e10.toString());
            aVar2.b(valueOf2.length() != 0 ? "IOException when revoking access: ".concat(valueOf2) : new String("IOException when revoking access: "), new Object[0]);
        } catch (Exception e11) {
            a aVar3 = f36451c;
            String valueOf3 = String.valueOf(e11.toString());
            aVar3.b(valueOf3.length() != 0 ? "Exception when revoking access: ".concat(valueOf3) : new String("Exception when revoking access: "), new Object[0]);
        }
        this.f36453b.j(status);
    }
}
