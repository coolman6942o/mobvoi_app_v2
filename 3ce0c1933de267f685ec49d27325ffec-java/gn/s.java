package gn;

import android.text.TextUtils;
import cn.r;
import cn.x;
import cn.y;
import cn.z;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes2.dex */
public class s {
    public static ArrayList<y> a(String str) {
        JSONArray jSONArray;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<y> arrayList = new ArrayList<>();
        try {
            jSONArray = new JSONArray(str);
        } catch (JSONException e10) {
            e10.printStackTrace();
            jSONArray = null;
        }
        if (jSONArray == null) {
            return null;
        }
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                arrayList.add(new y(Integer.valueOf((String) jSONArray.getJSONArray(i10).get(0)).intValue(), Integer.valueOf((String) jSONArray.getJSONArray(i10).get(1)).intValue(), Integer.valueOf((String) jSONArray.getJSONArray(i10).get(2)).intValue(), Integer.valueOf((String) jSONArray.getJSONArray(i10).get(3)).intValue(), Integer.valueOf((String) jSONArray.getJSONArray(i10).get(4)).intValue()));
            } catch (NumberFormatException e11) {
                e11.printStackTrace();
            } catch (JSONException e12) {
                e12.printStackTrace();
            }
        }
        return arrayList;
    }

    public static List<r> b(String str) {
        JSONArray jSONArray;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            jSONArray = new JSONArray(str);
        } catch (JSONException e10) {
            e10.printStackTrace();
            jSONArray = null;
        }
        if (jSONArray == null) {
            return null;
        }
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                arrayList.add(new r(Integer.valueOf((String) jSONArray.getJSONArray(i10).get(0)).intValue(), Integer.valueOf((String) jSONArray.getJSONArray(i10).get(1)).intValue(), Integer.valueOf((String) jSONArray.getJSONArray(i10).get(2)).intValue()));
            } catch (NumberFormatException e11) {
                e11.printStackTrace();
            } catch (JSONException e12) {
                e12.printStackTrace();
            }
        }
        return arrayList;
    }

    public static ArrayList<x> c(String str) {
        JSONArray jSONArray;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<x> arrayList = new ArrayList<>();
        try {
            jSONArray = new JSONArray(str);
        } catch (JSONException e10) {
            e10.printStackTrace();
            jSONArray = null;
        }
        if (jSONArray == null) {
            return null;
        }
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                arrayList.add(new x(Integer.valueOf((String) jSONArray.getJSONArray(i10).get(0)).intValue(), Integer.valueOf((String) jSONArray.getJSONArray(i10).get(1)).intValue()));
            } catch (NumberFormatException e11) {
                e11.printStackTrace();
            } catch (JSONException e12) {
                e12.printStackTrace();
            }
        }
        return arrayList;
    }

    public static ArrayList<z> d(String str) {
        JSONArray jSONArray;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<z> arrayList = new ArrayList<>();
        try {
            jSONArray = new JSONArray(str);
        } catch (JSONException e10) {
            e10.printStackTrace();
            jSONArray = null;
        }
        if (jSONArray == null) {
            return null;
        }
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                int intValue = Integer.valueOf((String) jSONArray.getJSONArray(i10).get(0)).intValue();
                int intValue2 = Integer.valueOf((String) jSONArray.getJSONArray(i10).get(1)).intValue();
                int intValue3 = Integer.valueOf((String) jSONArray.getJSONArray(i10).get(2)).intValue();
                int intValue4 = Integer.valueOf((String) jSONArray.getJSONArray(i10).get(3)).intValue();
                int intValue5 = Integer.valueOf((String) jSONArray.getJSONArray(i10).get(4)).intValue();
                u.a("JsonObjectUntil", "time =" + intValue + ",walkSteps =" + intValue5 + ",startWalkTime =" + intValue2 + ",endWalkTime =" + intValue3 + ",jsonString =" + str);
                arrayList.add(new z(intValue, intValue2, intValue3, intValue4, intValue5));
            } catch (NumberFormatException e11) {
                e11.printStackTrace();
            } catch (JSONException e12) {
                e12.printStackTrace();
            }
        }
        return arrayList;
    }
}
