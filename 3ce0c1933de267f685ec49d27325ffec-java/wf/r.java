package wf;

import com.mobvoi.android.common.json.JsonBean;
import java.util.List;
/* compiled from: UserSettingResponse.java */
/* loaded from: classes2.dex */
public class r extends o {
    public List<a> list;

    /* compiled from: UserSettingResponse.java */
    /* loaded from: classes2.dex */
    public static class a implements JsonBean {
        public String type;
        public String value;

        public String toString() {
            return "UserType{type='" + this.type + "', value='" + this.value + "'}";
        }
    }
}
