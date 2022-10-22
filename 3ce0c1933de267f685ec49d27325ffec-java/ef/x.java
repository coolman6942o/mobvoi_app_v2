package ef;

import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.health.common.data.pojo.SportType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: UiHiitResult.java */
/* loaded from: classes2.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public final SportType f26013a;

    /* renamed from: b  reason: collision with root package name */
    public final long f26014b;

    /* renamed from: c  reason: collision with root package name */
    public final long f26015c;

    /* renamed from: d  reason: collision with root package name */
    public final long f26016d;

    /* renamed from: e  reason: collision with root package name */
    public long f26017e;

    public x(SportType sportType, long j10, long j11, long j12, long j13) {
        this.f26013a = sportType;
        this.f26016d = j10;
        this.f26014b = j11;
        this.f26015c = j12;
        this.f26017e = j13;
    }

    public static String a(List<x> list) {
        if (list != null && !list.isEmpty()) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (x xVar : list) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("type", xVar.f26013a.typeCode);
                    jSONObject.put("duration", xVar.f26015c);
                    jSONObject.put("target_duration", xVar.f26014b);
                    jSONObject.put("start_time", xVar.f26016d);
                    jSONObject.put("times", xVar.f26017e);
                    jSONArray.put(jSONObject);
                }
                return jSONArray.toString();
            } catch (JSONException e10) {
                k.r("fit.UiHiitResult", "generate hiit results error", e10, new Object[0]);
            }
        }
        return "";
    }

    public static List<x> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                int i11 = jSONObject.getInt("type");
                arrayList.add(new x(SportType.from(i11), jSONObject.getLong("start_time"), jSONObject.getLong("target_duration"), jSONObject.getLong("duration"), jSONObject.getLong("times")));
            }
        } catch (JSONException e10) {
            k.r("fit.UiHiitResult", "parse hiit results error", e10, new Object[0]);
        }
        return arrayList;
    }

    public String toString() {
        return "UiHiitResult{sportType=" + this.f26013a + ", targetDuration=" + this.f26014b + ", duration=" + this.f26015c + ", startTime=" + this.f26016d + ", times=" + this.f26017e + '}';
    }
}
