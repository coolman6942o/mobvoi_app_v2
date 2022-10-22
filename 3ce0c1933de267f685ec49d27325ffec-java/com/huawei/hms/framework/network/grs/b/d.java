package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.local.model.a;
import com.huawei.hms.framework.network.grs.local.model.b;
import com.mobvoi.wear.contacts.ContactConstant;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import com.mobvoi.wear.providers.OtaColumn;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends a {
    public d(Context context) {
        String appConfigName = GrsApp.getInstance().getAppConfigName();
        Logger.i("LocalManagerV2", "appConfigName is" + appConfigName);
        if (a(TextUtils.isEmpty(appConfigName) ? "grs_app_global_route_config.json" : appConfigName, context, true) == 0) {
            this.f13846d = true;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.b.a
    public int a(String str) {
        this.f13843a = new a();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONArray("applications").getJSONObject(0);
            this.f13843a.b(jSONObject.getString(ContactConstant.CallsRecordKeys.NAME));
            JSONArray jSONArray = jSONObject.getJSONArray(SharedWearInfoHelper.TaskInfo.KEY_SERVICES);
            if (!(jSONArray == null || jSONArray.length() == 0)) {
                if (jSONObject.has("customservices")) {
                    b(jSONObject.getJSONArray("customservices"));
                }
                return 0;
            }
            return -1;
        } catch (JSONException e10) {
            Logger.w("LocalManagerV2", "parse appbean failed maybe json style is wrong.", e10);
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0033 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034 A[Catch: JSONException -> 0x00af, TryCatch #0 {JSONException -> 0x00af, blocks: (B:3:0x0010, B:6:0x001f, B:9:0x0026, B:11:0x002d, B:14:0x0034, B:17:0x003c, B:19:0x0042, B:21:0x004d, B:23:0x0056, B:25:0x005f, B:29:0x0070, B:31:0x0076, B:33:0x007d, B:34:0x0081, B:36:0x0088, B:40:0x0090, B:42:0x0096, B:43:0x00a2), top: B:50:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0096 A[Catch: JSONException -> 0x00af, LOOP:1: B:40:0x0090->B:42:0x0096, LOOP_END, TryCatch #0 {JSONException -> 0x00af, blocks: (B:3:0x0010, B:6:0x001f, B:9:0x0026, B:11:0x002d, B:14:0x0034, B:17:0x003c, B:19:0x0042, B:21:0x004d, B:23:0x0056, B:25:0x005f, B:29:0x0070, B:31:0x0076, B:33:0x007d, B:34:0x0081, B:36:0x0088, B:40:0x0090, B:42:0x0096, B:43:0x00a2), top: B:50:0x0010 }] */
    @Override // com.huawei.hms.framework.network.grs.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int b(String str) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        HashSet hashSet;
        int i10;
        String str2 = "countryOrAreaGroups";
        this.f13844b = new ArrayList(16);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(str2)) {
                if (jSONObject.has("countryGroups")) {
                    str2 = "countryGroups";
                } else {
                    Logger.e("LocalManagerV2", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                    jSONArray = null;
                    if (jSONArray != null) {
                        return -1;
                    }
                    if (jSONArray.length() != 0) {
                        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i11);
                            b bVar = new b();
                            bVar.b(jSONObject2.getString("id"));
                            bVar.c(jSONObject2.getString(ContactConstant.CallsRecordKeys.NAME));
                            bVar.a(jSONObject2.getString(OtaColumn.COLUMN_DESCRIPTION));
                            String str3 = "countries";
                            if (jSONObject2.has("countriesOrAreas")) {
                                str3 = "countriesOrAreas";
                            } else if (!jSONObject2.has(str3)) {
                                Logger.w("LocalManagerV2", "current country or area group has not config countries or areas.");
                                jSONArray2 = null;
                                hashSet = new HashSet(16);
                                if (!(jSONArray2 == null || jSONArray2.length() == 0)) {
                                    for (i10 = 0; i10 < jSONArray2.length(); i10++) {
                                        hashSet.add((String) jSONArray2.get(i10));
                                    }
                                    bVar.a(hashSet);
                                    this.f13844b.add(bVar);
                                }
                                return -1;
                            }
                            jSONArray2 = jSONObject2.getJSONArray(str3);
                            hashSet = new HashSet(16);
                            if (jSONArray2 == null) {
                                while (i10 < jSONArray2.length()) {
                                }
                                bVar.a(hashSet);
                                this.f13844b.add(bVar);
                            }
                            return -1;
                        }
                    }
                    return 0;
                }
            }
            jSONArray = jSONObject.getJSONArray(str2);
            if (jSONArray != null) {
            }
        } catch (JSONException e10) {
            Logger.w("LocalManagerV2", "parse countrygroup failed maybe json style is wrong.", e10);
            return -1;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.b.a
    public int e(String str) {
        return d(str);
    }
}
