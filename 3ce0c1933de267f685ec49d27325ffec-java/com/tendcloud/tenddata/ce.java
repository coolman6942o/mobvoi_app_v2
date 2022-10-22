package com.tendcloud.tenddata;

import com.mobvoi.wear.contacts.ContactConstant;
import java.util.Map;
import org.json.JSONObject;
/* compiled from: td */
/* loaded from: classes2.dex */
public class ce extends ch {
    public ce(String str, String str2) {
        a("domain", str);
        a(ContactConstant.CallsRecordKeys.NAME, str2);
    }

    public void setData(Map<String, Object> map) {
        if (map != null) {
            a("data", (Object) new JSONObject(map));
        }
    }
}
