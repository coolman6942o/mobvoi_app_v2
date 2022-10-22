package tc;

import android.text.TextUtils;
import com.mobvoi.android.common.json.JsonBean;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.text.u;
/* compiled from: HeartHealthCardResp.kt */
/* loaded from: classes2.dex */
public final class c extends tc.a {
    @h8.c("obj")
    private Map<String, ? extends List<a>> heartHealthMap;
    @h8.c("switchType")
    private Map<String, String> switchType;

    /* compiled from: HeartHealthCardResp.kt */
    /* loaded from: classes2.dex */
    public static final class a implements JsonBean {
        @h8.c("data_type")
        private String dataType;
        @h8.c("end_time_millis")
        private long endTime;
        @h8.c("start_time_millis")
        private long startTime;
        @h8.c("string_val")
        private String values;

        public final long a() {
            return this.startTime;
        }

        public final float[] b() {
            List o02;
            if (TextUtils.isEmpty(this.values)) {
                return null;
            }
            o02 = u.o0(this.values, new String[]{","}, false, 0, 6, null);
            int i10 = 0;
            Object[] array = o02.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            String[] strArr = (String[]) array;
            float[] fArr = new float[strArr.length];
            int length = strArr.length - 1;
            if (length >= 0) {
                while (true) {
                    int i11 = i10 + 1;
                    fArr[i10] = Float.parseFloat(strArr[i10]);
                    if (i11 > length) {
                        break;
                    }
                    i10 = i11;
                }
            }
            return fArr;
        }
    }

    public final Map<String, List<a>> b() {
        return this.heartHealthMap;
    }

    public final Map<String, String> c() {
        return this.switchType;
    }
}
