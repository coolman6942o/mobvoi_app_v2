package i4;

import c4.a;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    public static DataReportRequest a(d dVar) {
        DataReportRequest dataReportRequest = new DataReportRequest();
        if (dVar == null) {
            return null;
        }
        dataReportRequest.os = dVar.f28074a;
        dataReportRequest.rpcVersion = dVar.f28080g;
        dataReportRequest.bizType = "1";
        HashMap hashMap = new HashMap();
        dataReportRequest.bizData = hashMap;
        hashMap.put("apdid", dVar.f28075b);
        dataReportRequest.bizData.put("apdidToken", dVar.f28076c);
        dataReportRequest.bizData.put("umidToken", dVar.f28077d);
        dataReportRequest.bizData.put("dynamicKey", dVar.f28078e);
        dataReportRequest.deviceData = dVar.f28079f;
        return dataReportRequest;
    }

    public static c b(DataReportResult dataReportResult) {
        c cVar = new c();
        if (dataReportResult == null) {
            return null;
        }
        cVar.f28063a = dataReportResult.success;
        cVar.f28064b = dataReportResult.resultCode;
        Map<String, String> map = dataReportResult.resultData;
        if (map != null) {
            cVar.f28065c = map.get("apdid");
            cVar.f28066d = map.get("apdidToken");
            cVar.f28069g = map.get("dynamicKey");
            cVar.f28070h = map.get("timeInterval");
            cVar.f28071i = map.get("webrtcUrl");
            cVar.f28072j = "";
            String str = map.get("drmSwitch");
            if (a.g(str)) {
                if (str.length() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str.charAt(0));
                    cVar.f28067e = sb2.toString();
                }
                if (str.length() >= 3) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str.charAt(2));
                    cVar.f28068f = sb3.toString();
                }
            }
            if (map.containsKey("apse_degrade")) {
                cVar.f28073k = map.get("apse_degrade");
            }
        }
        return cVar;
    }
}
