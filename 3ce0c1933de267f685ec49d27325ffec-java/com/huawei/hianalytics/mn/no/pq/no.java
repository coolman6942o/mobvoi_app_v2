package com.huawei.hianalytics.mn.no.pq;

import android.text.TextUtils;
import com.huawei.agconnect.exception.AGCServerException;
import com.huawei.hianalytics.mn.mn.op;
import com.huawei.hianalytics.mn.no.op.no.pq;
import com.huawei.hianalytics.mn.no.qr.mn;
import com.mobvoi.wear.util.LogCleaner;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/* loaded from: classes.dex */
public class no {

    /* renamed from: mn  reason: collision with root package name */
    private List<pq> f13594mn;

    /* renamed from: no  reason: collision with root package name */
    private String f13595no;

    /* renamed from: op  reason: collision with root package name */
    private String f13596op;
    private String pq;

    public no(List<pq> list, String str, String str2, String str3) {
        this.f13594mn = list;
        this.f13595no = str;
        this.f13596op = str2;
        this.pq = str3;
    }

    private void mn(List<pq> list, String str, String str2) {
        if (!list.isEmpty()) {
            int size = (list.size() / AGCServerException.UNKNOW_EXCEPTION) + 1;
            for (int i10 = 0; i10 < size; i10++) {
                int i11 = i10 * AGCServerException.UNKNOW_EXCEPTION;
                List<pq> subList = list.subList(i11, Math.min(list.size(), i11 + AGCServerException.UNKNOW_EXCEPTION));
                String replace = UUID.randomUUID().toString().replace("-", "");
                long currentTimeMillis = System.currentTimeMillis();
                long st = op.st(str2, str) * LogCleaner.ONE_DAY;
                ArrayList arrayList = new ArrayList();
                for (pq pqVar : subList) {
                    if (!com.huawei.hianalytics.mn.no.b.no.mn(pqVar.no(), currentTimeMillis, st)) {
                        arrayList.add(pqVar);
                    }
                }
                if (arrayList.size() > 0) {
                    new op(str2, str, this.pq, arrayList, replace).mn();
                } else {
                    mn.op("DataOrganizeHandler", "No data to report handler");
                }
            }
        }
    }

    public void mn() {
        if ("_default_config_tag".equals(this.f13596op)) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (pq pqVar : this.f13594mn) {
                String mn2 = pqVar.mn();
                if (TextUtils.isEmpty(mn2) || "oper".equals(mn2)) {
                    arrayList4.add(pqVar);
                } else if ("maint".equals(mn2)) {
                    arrayList.add(pqVar);
                } else if ("preins".equals(mn2)) {
                    arrayList2.add(pqVar);
                } else if ("diffprivacy".equals(mn2)) {
                    arrayList3.add(pqVar);
                }
            }
            mn(arrayList4, "oper", "_default_config_tag");
            mn(arrayList, "maint", "_default_config_tag");
            mn(arrayList2, "preins", "_default_config_tag");
            mn(arrayList3, "diffprivacy", "_default_config_tag");
            return;
        }
        mn(this.f13594mn, this.f13596op, this.f13595no);
    }
}
