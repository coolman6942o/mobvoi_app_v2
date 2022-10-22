package g4;

import com.bjleisen.iface.sdk.apdu.LeisenIfaceConfig;
import j4.a;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public File f27254a;

    /* renamed from: b  reason: collision with root package name */
    public a f27255b;

    public b(String str, a aVar) {
        this.f27254a = null;
        this.f27255b = null;
        this.f27254a = new File(str);
        this.f27255b = aVar;
    }

    public static String a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "id");
            jSONObject.put("error", str);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        File file = this.f27254a;
        if (file != null) {
            if (file.exists() && this.f27254a.isDirectory() && this.f27254a.list().length != 0) {
                ArrayList arrayList = new ArrayList();
                for (String str : this.f27254a.list()) {
                    arrayList.add(str);
                }
                Collections.sort(arrayList);
                String str2 = (String) arrayList.get(arrayList.size() - 1);
                int size = arrayList.size();
                if (str2.equals(new SimpleDateFormat(LeisenIfaceConfig.CARD_DATE_FORMAT).format(Calendar.getInstance().getTime()) + ".log")) {
                    if (arrayList.size() >= 2) {
                        str2 = (String) arrayList.get(arrayList.size() - 2);
                        size--;
                    } else {
                        return;
                    }
                }
                if (!this.f27255b.logCollect(a(c4.b.a(this.f27254a.getAbsolutePath(), str2)))) {
                    size--;
                }
                for (int i10 = 0; i10 < size; i10++) {
                    new File(this.f27254a, (String) arrayList.get(i10)).delete();
                }
            }
        }
    }

    public final void b() {
        new Thread(new c(this)).start();
    }
}
