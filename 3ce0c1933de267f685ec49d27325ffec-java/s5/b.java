package s5;

import android.net.Uri;
import android.util.Log;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
/* loaded from: classes.dex */
final class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Map f34323a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, Map map) {
        this.f34323a = map;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String message;
        StringBuilder sb2;
        String str;
        Exception exc;
        Exception e10;
        new d();
        Map map = this.f34323a;
        Uri.Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        for (String str2 : map.keySet()) {
            buildUpon.appendQueryParameter(str2, (String) map.get(str2));
        }
        String uri = buildUpon.build().toString();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri).openConnection();
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode < 200 || responseCode >= 300) {
                    StringBuilder sb3 = new StringBuilder(String.valueOf(uri).length() + 65);
                    sb3.append("Received non-success response code ");
                    sb3.append(responseCode);
                    sb3.append(" from pinging URL: ");
                    sb3.append(uri);
                    Log.w("HttpUrlPinger", sb3.toString());
                }
            } finally {
                httpURLConnection.disconnect();
            }
        } catch (IOException e11) {
            e10 = e11;
            message = e10.getMessage();
            sb2 = new StringBuilder(String.valueOf(uri).length() + 27 + String.valueOf(message).length());
            str = "Error while pinging URL: ";
            exc = e10;
            sb2.append(str);
            sb2.append(uri);
            sb2.append(". ");
            sb2.append(message);
            Log.w("HttpUrlPinger", sb2.toString(), exc);
        } catch (IndexOutOfBoundsException e12) {
            message = e12.getMessage();
            sb2 = new StringBuilder(String.valueOf(uri).length() + 32 + String.valueOf(message).length());
            str = "Error while parsing ping URL: ";
            exc = e12;
            sb2.append(str);
            sb2.append(uri);
            sb2.append(". ");
            sb2.append(message);
            Log.w("HttpUrlPinger", sb2.toString(), exc);
        } catch (RuntimeException e13) {
            e10 = e13;
            message = e10.getMessage();
            sb2 = new StringBuilder(String.valueOf(uri).length() + 27 + String.valueOf(message).length());
            str = "Error while pinging URL: ";
            exc = e10;
            sb2.append(str);
            sb2.append(uri);
            sb2.append(". ");
            sb2.append(message);
            Log.w("HttpUrlPinger", sb2.toString(), exc);
        }
    }
}
