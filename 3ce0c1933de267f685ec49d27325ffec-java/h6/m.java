package h6;

import com.mobvoi.wear.lpa.LpaConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class m {
    public static void a(StringBuilder sb2, HashMap<String, String> hashMap) {
        sb2.append("{");
        boolean z10 = true;
        for (String str : hashMap.keySet()) {
            if (!z10) {
                sb2.append(",");
            } else {
                z10 = false;
            }
            String str2 = hashMap.get(str);
            sb2.append("\"");
            sb2.append(str);
            sb2.append("\":");
            if (str2 == null) {
                sb2.append(LpaConstants.VALUE_NULL);
            } else {
                sb2.append("\"");
                sb2.append(str2);
                sb2.append("\"");
            }
        }
        sb2.append("}");
    }
}
