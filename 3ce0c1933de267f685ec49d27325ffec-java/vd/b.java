package vd;

import android.text.TextUtils;
import com.bjleisen.iface.sdk.enums.EnumCardAppStatus;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.setting.CompanionSetting;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kc.c;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.e;
import okhttp3.f;
import okhttp3.w;
import okhttp3.y;
import okhttp3.z;
/* compiled from: CardInfoUploader.java */
/* loaded from: classes2.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CardInfoUploader.java */
    /* loaded from: classes2.dex */
    public class a implements f {
        a() {
        }

        @Override // okhttp3.f
        public void onFailure(e eVar, IOException iOException) {
            k.b("CardInfoUploader", "onFailure", iOException);
        }

        @Override // okhttp3.f
        public void onResponse(e eVar, b0 b0Var) throws IOException {
            int n10 = b0Var.n();
            k.a("CardInfoUploader", "response code = " + n10 + ", " + b0Var.c().string());
        }
    }

    private static List<vd.a> a(List<ud.a> list, String str) {
        String wearDeviceId = CompanionSetting.getWearDeviceId(com.mobvoi.android.common.utils.b.e());
        String x10 = ta.a.x();
        ArrayList arrayList = new ArrayList(list.size());
        for (ud.a aVar : list) {
            vd.a aVar2 = new vd.a();
            aVar2.watchDeviceId = wearDeviceId;
            aVar2.wwid = x10;
            aVar2.type = "bus";
            aVar2.subtype = aVar.f();
            aVar2.cardNumber = aVar.c();
            EnumCardAppStatus enumCardAppStatus = aVar.status;
            if (enumCardAppStatus != null) {
                aVar2.status = enumCardAppStatus.name();
            }
            aVar2.f35731id = str + ":" + aVar2.type + ":" + aVar2.subtype;
            aVar2.extras.put("open_date", aVar.openDate);
            aVar2.extras.put("expire_date", aVar.expireDate);
            HashMap<String, String> hashMap = aVar2.extras;
            hashMap.put("balance", aVar.balance + "");
            arrayList.add(aVar2);
        }
        return arrayList;
    }

    private static void b(List<vd.a> list) {
        if (list.size() != 0) {
            new y().a(new z.a().p("https://ticwear-account.mobvoi.com/bind_card/").l(a0.create(w.f("application/json"), c.c(list))).b()).h(new a());
        }
    }

    public static void c(List<ud.a> list) {
        String l10 = sd.b.h().l();
        if (TextUtils.isEmpty(l10)) {
            k.q("CardInfoUploader", "seid is empty, ignore upload.");
        } else {
            b(a(list, l10));
        }
    }

    public static void d(ud.a aVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        c(arrayList);
    }
}
