package com.huawei.hianalytics.mn.rs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.mn.no.op.mn.mn;
import com.huawei.hianalytics.mn.no.op.mn.qr;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public class op {

    /* renamed from: mn  reason: collision with root package name */
    public qr f13647mn;

    /* renamed from: no  reason: collision with root package name */
    private String f13648no;

    public op(String str) {
        this.f13648no = str;
        this.f13647mn = new qr(str);
        mn.mn().mn(this.f13648no, this.f13647mn);
    }

    private com.huawei.hianalytics.mn.no.op.mn.op no(int i10) {
        if (i10 == 0) {
            return this.f13647mn.no();
        }
        if (i10 == 1) {
            return this.f13647mn.mn();
        }
        if (i10 == 2) {
            return this.f13647mn.op();
        }
        if (i10 != 3) {
            return null;
        }
        return this.f13647mn.pq();
    }

    private boolean op(int i10) {
        String concat;
        if (i10 != 2) {
            com.huawei.hianalytics.mn.no.op.mn.op no2 = no(i10);
            if (no2 != null && !TextUtils.isEmpty(no2.tu())) {
                return true;
            }
            concat = "verifyURL(): URL check failed. type: ".concat(String.valueOf(i10));
        } else if ("_default_config_tag".equals(this.f13648no)) {
            return true;
        } else {
            concat = "verifyURL(): type: preins. Only default config can report Pre-install data.";
        }
        com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", concat);
        return false;
    }

    public void mn(int i10) {
        com.huawei.hianalytics.mn.no.qr.mn.mn("hmsSdk", "HiAnalyticsInstance.onReport() is execute.TAG: %s,TYPE: %d", this.f13648no, Integer.valueOf(i10));
        no.mn().mn(this.f13648no, i10);
    }

    public void mn(int i10, com.huawei.hianalytics.mn.no.op.mn.op opVar) {
        com.huawei.hianalytics.mn.no.op.mn.op opVar2;
        if (opVar == null) {
            com.huawei.hianalytics.mn.no.qr.mn.mn("hmsSdk", "HiAnalyticsInstanceImpl.refresh(). Parameter config is null.TAG : %s , TYPE : %d", this.f13648no, Integer.valueOf(i10));
            opVar2 = null;
        } else {
            opVar2 = new com.huawei.hianalytics.mn.no.op.mn.op(opVar);
        }
        com.huawei.hianalytics.mn.no.qr.mn.mn("hmsSdk", "HiAnalyticsInstanceImpl.refresh() is executed.TAG : %s , TYPE : %d", this.f13648no, Integer.valueOf(i10));
        if (i10 == 0) {
            op(opVar2);
            com.huawei.hianalytics.mn.no.tu.mn.mn().mn(this.f13648no);
        } else if (i10 == 1) {
            mn(opVar2);
        } else if (i10 == 2) {
            pq(opVar2);
        } else if (i10 != 3) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "refresh(): HiAnalyticsType can only be OPERATION ,MAINTAIN or DIFF_PRIVACY.");
        } else {
            no(opVar2);
        }
    }

    public void mn(int i10, String str) {
        com.huawei.hianalytics.mn.no.qr.mn.no("hmsSdk", "HiAnalyticsInstanceImpl.setUpid() is executed.TAG : " + this.f13648no);
        com.huawei.hianalytics.mn.no.op.mn.op no2 = no(i10);
        if (no2 == null) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "setUpid(): No related config found.type : ".concat(String.valueOf(i10)));
            return;
        }
        if (!com.huawei.hianalytics.mn.no.b.op.mn("upid", str, 4096)) {
            str = "";
        }
        no2.rs(str);
    }

    public void mn(int i10, String str, LinkedHashMap<String, String> linkedHashMap) {
        com.huawei.hianalytics.mn.no.qr.mn.mn("hmsSdk", "HiAnalyticsInstance.onEvent(int type, String eventId, Map<String, String> mapValue) is execute.TAG: %s,TYPE: %d", this.f13648no, Integer.valueOf(i10));
        if (com.huawei.hianalytics.mn.no.b.op.mn(str) || !op(i10)) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f13648no + ", TYPE: " + i10);
            return;
        }
        if (!com.huawei.hianalytics.mn.no.b.op.mn(linkedHashMap)) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "onEvent() parameter mapValue will be cleared.TAG: " + this.f13648no + ", TYPE: " + i10);
            linkedHashMap = null;
        }
        no.mn().mn(this.f13648no, i10, str, linkedHashMap);
    }

    public void mn(int i10, boolean z10) {
        com.huawei.hianalytics.mn.no.qr.mn.mn("hmsSdk", "HiAnalyticsInstanceImpl.setOAIDTrackingFlag() is executed.TAG : %s , TYPE : %d", this.f13648no, Integer.valueOf(i10));
        com.huawei.hianalytics.mn.no.op.mn.op no2 = no(i10);
        if (no2 == null) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "setOAIDTrackingFlag(): No related config found.type : ".concat(String.valueOf(i10)));
        } else {
            no2.pq(z10 ? "true" : "false");
        }
    }

    public void mn(Context context) {
        com.huawei.hianalytics.mn.no.qr.mn.no("hmsSdk", "HiAnalyticsInstance.onPause() is execute.TAG: " + this.f13648no);
        if (context == null) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "context is null in onPause! Nothing will be recorded.TAG: " + this.f13648no);
        } else if (!op(0)) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "onResume() URL check fail. Nothing will be recorded.TAG: " + this.f13648no);
        } else {
            no.mn().mn(this.f13648no, context);
        }
    }

    public void mn(Context context, int i10) {
        com.huawei.hianalytics.mn.no.qr.mn.mn("hmsSdk", "HiAnalyticsInstance.onReport(Context context) is execute.TAG: %s,TYPE: %d", this.f13648no, Integer.valueOf(i10));
        if (context == null) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "context is null in onReport!");
        } else {
            no.mn().mn(this.f13648no, i10);
        }
    }

    public void mn(Context context, String str, String str2) {
        com.huawei.hianalytics.mn.no.qr.mn.no("hmsSdk", "HiAnalyticsInstance.onEvent(eventId, mapValue) is execute.TAG : " + this.f13648no);
        if (context == null) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "context is null in onevent ");
        } else if (com.huawei.hianalytics.mn.no.b.op.mn(str) || !op(0)) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f13648no);
        } else {
            if (!com.huawei.hianalytics.mn.no.b.op.mn(HealthDataProviderContracts.NAME_VALUE, str2, (int) WXMediaMessage.THUMB_LENGTH_LIMIT)) {
                com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "onEvent() parameter VALUE is overlong, content will be cleared.TAG: " + this.f13648no);
                str2 = "";
            }
            no.mn().mn(this.f13648no, context, str, str2);
        }
    }

    public void mn(Context context, LinkedHashMap<String, String> linkedHashMap) {
        com.huawei.hianalytics.mn.no.qr.mn.no("hmsSdk", "HiAnalyticsInstance.onPause(context,map) is execute.TAG: " + this.f13648no);
        if (context == null) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "context is null in onPause! Nothing will be recorded.");
        } else if (!op(0)) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "onResume() URL check fail. Nothing will be recorded.TAG: " + this.f13648no);
        } else {
            if (!com.huawei.hianalytics.mn.no.b.op.mn(linkedHashMap)) {
                com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "onPause() parameter mapValue will be cleared.TAG: " + this.f13648no);
                linkedHashMap = null;
            }
            no.mn().mn(this.f13648no, context, linkedHashMap);
        }
    }

    public void mn(com.huawei.hianalytics.mn.no.op.mn.op opVar) {
        com.huawei.hianalytics.mn.no.qr.mn.no("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf() is executed.TAG : " + this.f13648no);
        if (opVar == null) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf(): config for maint is null!");
            this.f13647mn.mn((com.huawei.hianalytics.mn.no.op.mn.op) null);
            return;
        }
        this.f13647mn.mn(opVar);
    }

    public void mn(String str, LinkedHashMap<String, String> linkedHashMap) {
        com.huawei.hianalytics.mn.no.qr.mn.no("hmsSdk", "HiAnalyticsInstance.onPause(viewName,map) is execute.TAG: " + this.f13648no);
        if (!op(0)) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "onPause() URL check fail. Nothing will be recorded.TAG: " + this.f13648no);
        } else if (TextUtils.isEmpty(str) || !com.huawei.hianalytics.mn.no.b.op.mn("viewName", str, "[a-zA-Z_][a-zA-Z0-9. _-]{0,255}")) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "onPause() parameter viewName verify failed. Nothing will be recorded.TAG: " + this.f13648no);
        } else {
            if (!com.huawei.hianalytics.mn.no.b.op.mn(linkedHashMap)) {
                com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "onPause() parameter mapValue will be cleared.TAG: " + this.f13648no);
                linkedHashMap = null;
            }
            no.mn().mn(this.f13648no, str, linkedHashMap);
        }
    }

    public void no(int i10, String str) {
        com.huawei.hianalytics.mn.no.qr.mn.no("hmsSdk", "HiAnalyticsInstanceImpl.setStrOAID() is executed.TAG : " + this.f13648no);
        com.huawei.hianalytics.mn.no.op.mn.op no2 = no(i10);
        if (no2 == null) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "setOAID(): No related config found.type : ".concat(String.valueOf(i10)));
            return;
        }
        if (!com.huawei.hianalytics.mn.no.b.op.mn("oaid", str, 4096)) {
            str = "";
        }
        no2.op(str);
    }

    public void no(int i10, String str, LinkedHashMap<String, String> linkedHashMap) {
        com.huawei.hianalytics.mn.no.qr.mn.mn("hmsSdk", "HiAnalyticsInstance.onStreamEvent() is execute.TAG: %s,TYPE: %d", this.f13648no, Integer.valueOf(i10));
        if (com.huawei.hianalytics.mn.no.b.op.mn(str) || !op(i10)) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "onStreamEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f13648no + ", TYPE: " + i10);
            return;
        }
        if (!com.huawei.hianalytics.mn.no.b.op.mn(linkedHashMap)) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "onStreamEvent() parameter mapValue will be cleared.TAG: " + this.f13648no + ", TYPE: " + i10);
            linkedHashMap = null;
        }
        no.mn().no(this.f13648no, i10, str, linkedHashMap);
    }

    public void no(Context context) {
        com.huawei.hianalytics.mn.no.qr.mn.no("hmsSdk", "HiAnalyticsInstance.onResume() is execute.TAG: " + this.f13648no);
        if (context == null) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "context is null in onResume! Nothing will be recorded.");
        } else if (!op(0)) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "onResume() URL check fail. Nothing will be recorded.TAG: " + this.f13648no);
        } else {
            no.mn().no(this.f13648no, context);
        }
    }

    public void no(Context context, LinkedHashMap<String, String> linkedHashMap) {
        com.huawei.hianalytics.mn.no.qr.mn.no("hmsSdk", "HiAnalyticsInstance.onResume(context,map) is execute.TAG: " + this.f13648no);
        if (context == null) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "context is null in onResume! Nothing will be recorded.");
        } else if (!op(0)) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "onResume() URL check fail. Nothing will be recorded.TAG: " + this.f13648no);
        } else {
            if (!com.huawei.hianalytics.mn.no.b.op.mn(linkedHashMap)) {
                com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "onResume() parameter mapValue will be cleared.TAG: " + this.f13648no);
                linkedHashMap = null;
            }
            no.mn().no(this.f13648no, context, linkedHashMap);
        }
    }

    public void no(com.huawei.hianalytics.mn.no.op.mn.op opVar) {
        com.huawei.hianalytics.mn.no.qr.mn.no("hmsSdk", "HiAnalyticsInstanceImpl.setDiffConf() is executed.TAG : " + this.f13648no);
        if (opVar == null) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "HiAnalyticsInstanceImpl.setDiffConf(): config for diffPrivacy is null!");
            this.f13647mn.pq(null);
            return;
        }
        this.f13647mn.pq(opVar);
    }

    public void no(String str, LinkedHashMap<String, String> linkedHashMap) {
        com.huawei.hianalytics.mn.no.qr.mn.no("hmsSdk", "HiAnalyticsInstance.onResume(viewname,map) is execute.TAG: " + this.f13648no);
        if (!op(0)) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "onResume() URL check fail. Nothing will be recorded.TAG: " + this.f13648no);
        } else if (TextUtils.isEmpty(str) || !com.huawei.hianalytics.mn.no.b.op.mn("viewName", str, "[a-zA-Z_][a-zA-Z0-9. _-]{0,255}")) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "onResume() parameter viewName verify failed. Nothing will be recorded.TAG: " + this.f13648no);
        } else {
            if (!com.huawei.hianalytics.mn.no.b.op.mn(linkedHashMap)) {
                com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "onResume() parameter mapValue will be cleared.TAG: " + this.f13648no);
                linkedHashMap = null;
            }
            no.mn().no(this.f13648no, str, linkedHashMap);
        }
    }

    public void op(com.huawei.hianalytics.mn.no.op.mn.op opVar) {
        com.huawei.hianalytics.mn.no.qr.mn.no("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf() is executed.TAG: " + this.f13648no);
        if (opVar == null) {
            this.f13647mn.no(null);
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf(): config for oper is null!");
            return;
        }
        this.f13647mn.no(opVar);
    }

    public void pq(com.huawei.hianalytics.mn.no.op.mn.op opVar) {
        com.huawei.hianalytics.mn.no.qr.mn.no("hmsSdk", "HiAnalyticsInstanceImpl.setPreInstallConf() is executed.TAG: " + this.f13648no);
        if (opVar == null) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "HiAnalyticsInstanceImpl.setPreInstallConf(): config for PRE-INSTALL is null!");
            this.f13647mn.op(null);
            return;
        }
        this.f13647mn.op(opVar);
    }
}
