package com.huawei.hianalytics.mn.no.pq;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.hianalytics.mn.no.op.no.qr;
import com.huawei.hianalytics.mn.no.qr.mn;
import com.huawei.hianalytics.mn.qr.no;
import com.huawei.hianalytics.mn.qr.op;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class pq {
    public static qr mn() {
        mn.no("hmsSdk", "generate UploadData");
        st.mn().no();
        if (!TextUtils.isEmpty(st.mn().pq())) {
            return new qr(st.mn().op());
        }
        mn.op("hmsSdk", "event chifer is empty");
        return null;
    }

    public static com.huawei.hianalytics.mn.qr.mn mn(String str, String str2) {
        com.huawei.hianalytics.mn.qr.mn mnVar = new com.huawei.hianalytics.mn.qr.mn();
        mnVar.mn(com.huawei.hianalytics.mn.op.no.mn.mn().pq(str, str2));
        return mnVar;
    }

    public static no mn(String str, String str2, String str3, String str4) {
        no noVar = new no();
        noVar.rs(str);
        noVar.mn(com.huawei.hianalytics.mn.mn.no.qr());
        noVar.op(str2);
        noVar.qr(str4);
        StringBuffer stringBuffer = new StringBuffer("hmshi");
        stringBuffer.append(str3);
        stringBuffer.append("qrt");
        noVar.pq(stringBuffer.toString());
        return noVar;
    }

    public static op mn(String str, String str2, String str3) {
        op opVar = new op();
        opVar.mn(com.huawei.hianalytics.mn.mn.no.no());
        opVar.no(com.huawei.hianalytics.mn.mn.no.pq());
        opVar.op(str3);
        opVar.pq(com.huawei.hianalytics.mn.op.no.mn.mn().qr(str2, str));
        return opVar;
    }

    public static Map<String, String> no(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("App-Id", com.huawei.hianalytics.mn.mn.no.qr());
        hashMap.put("App-Ver", com.huawei.hianalytics.mn.mn.no.rs());
        hashMap.put("Sdk-Name", "hianalytics");
        hashMap.put("Sdk-Ver", "2.2.0.304");
        hashMap.put("Device-Type", Build.MODEL);
        hashMap.put("servicetag", str);
        mn.mn("hmsSdk", "sendData RequestId : %s", str2);
        hashMap.put("Request-Id", str2);
        return hashMap;
    }
}
