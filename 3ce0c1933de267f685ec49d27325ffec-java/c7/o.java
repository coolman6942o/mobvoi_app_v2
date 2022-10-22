package c7;

import a6.d;
import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.f;
import com.google.android.gms.wearable.g;
import com.mobvoi.wear.lpa.LpaConstants;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class o extends d implements f {

    /* renamed from: d  reason: collision with root package name */
    private final int f5591d;

    public o(DataHolder dataHolder, int i10, int i11) {
        super(dataHolder, i10);
        this.f5591d = i11;
    }

    public final Map<String, g> e() {
        HashMap hashMap = new HashMap(this.f5591d);
        for (int i10 = 0; i10 < this.f5591d; i10++) {
            n nVar = new n(this.f105a, this.f106b + i10);
            if (nVar.i() != null) {
                hashMap.put(nVar.i(), nVar);
            }
        }
        return hashMap;
    }

    public final byte[] f() {
        return a("data");
    }

    public final Uri g() {
        return Uri.parse(c("path"));
    }

    public final String toString() {
        boolean isLoggable = Log.isLoggable("DataItem", 3);
        byte[] f10 = f();
        Map<String, g> e10 = e();
        StringBuilder sb2 = new StringBuilder("DataItemRef{ ");
        String valueOf = String.valueOf(g());
        StringBuilder sb3 = new StringBuilder(valueOf.length() + 4);
        sb3.append("uri=");
        sb3.append(valueOf);
        sb2.append(sb3.toString());
        String valueOf2 = String.valueOf(f10 == null ? LpaConstants.VALUE_NULL : Integer.valueOf(f10.length));
        StringBuilder sb4 = new StringBuilder(valueOf2.length() + 9);
        sb4.append(", dataSz=");
        sb4.append(valueOf2);
        sb2.append(sb4.toString());
        int size = e10.size();
        StringBuilder sb5 = new StringBuilder(23);
        sb5.append(", numAssets=");
        sb5.append(size);
        sb2.append(sb5.toString());
        if (isLoggable && !e10.isEmpty()) {
            sb2.append(", assets=[");
            String str = "";
            for (Map.Entry<String, g> entry : e10.entrySet()) {
                String key = entry.getKey();
                String id2 = entry.getValue().getId();
                StringBuilder sb6 = new StringBuilder(str.length() + 2 + String.valueOf(key).length() + String.valueOf(id2).length());
                sb6.append(str);
                sb6.append(key);
                sb6.append(": ");
                sb6.append(id2);
                sb2.append(sb6.toString());
                str = ", ";
            }
            sb2.append("]");
        }
        sb2.append(" }");
        return sb2.toString();
    }
}
