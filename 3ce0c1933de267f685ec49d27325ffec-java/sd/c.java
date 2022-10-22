package sd;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import cn.com.fmsh.tsm.business.exception.BusinessException;
import com.bjleisen.iface.sdk.apdu.LeisenIfaceConfig;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.f;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import qd.m;
import ta.a;
/* compiled from: BusCardUtil.java */
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<Integer, String> f34404a;

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<Integer, String> f34405b;

    /* renamed from: c  reason: collision with root package name */
    private static final HashMap<Integer, String> f34406c;

    /* renamed from: d  reason: collision with root package name */
    private static final HashMap<Integer, String> f34407d;

    /* renamed from: e  reason: collision with root package name */
    private static final HashMap<Integer, String> f34408e;

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        f34404a = hashMap;
        HashMap<Integer, String> hashMap2 = new HashMap<>();
        f34405b = hashMap2;
        HashMap<Integer, String> hashMap3 = new HashMap<>();
        f34406c = hashMap3;
        HashMap<Integer, String> hashMap4 = new HashMap<>();
        f34407d = hashMap4;
        HashMap<Integer, String> hashMap5 = new HashMap<>();
        f34408e = hashMap5;
        hashMap.put(6, "[03-6] 业务校验失败，请联系客服处理");
        hashMap.put(9, "[03-9] 业务校验失败，请联系客服处理");
        hashMap.put(21, "[03-21] 业务校验失败，请联系客服处理");
        hashMap.put(23, "[03-23] 业务校验失败，请联系客服处理");
        hashMap.put(8194, "[01(02)]开卡失败，请稍后再试");
        hashMap.put(32774, "");
        hashMap3.put(8, "[03-8]业务校验失败，请联系客服处理");
        hashMap3.put(9, "[03-9]业务校验失败，请联系客服处理");
        hashMap2.put(6, "[03-6]业务校验失败，请联系客服处理");
        hashMap2.put(16, "[03-16]业务校验失败，请联系客服处理");
        hashMap2.put(19, "[03-19]业务校验失败，请联系客服处理");
        hashMap2.put(25, "[03-25]业务校验失败，请联系客服处理");
        hashMap2.put(32, "[03-32]业务校验失败，请联系客服处理");
        hashMap2.put(33, "[03-33]业务校验失败，请联系客服处理");
        hashMap2.put(36, "[03-0024]业务校验失败，请联系客服处理");
        hashMap2.put(39, "[03-39]该用户已开卡");
        hashMap2.put(41, "[03-41]业务校验失败，请联系客服处理");
        hashMap2.put(56, "[03-56]业务校验失败，请联系客服处理");
        hashMap2.put(57, "[03-57]业务校验失败，请联系客服处理");
        hashMap4.put(6, "[03-6]业务校验失败，请联系客服处理");
        hashMap4.put(21, "[03-21]业务校验失败，请联系客服处理");
        hashMap4.put(23, "[03-23]业务校验失败，请联系客服处理");
        hashMap4.put(32769, "[02-EBLN5003]充值失败，请联系客服处理");
        hashMap4.put(32770, "[01(02)]充值失败，请稍后再试");
        hashMap4.put(32771, "[01(02)]充值失败，请稍后再试");
        hashMap4.put(32772, "[01(02)]充值失败，请稍后再试");
        hashMap4.put(32773, "[01-EHC000107]充值失败，请稍后再试");
        hashMap4.put(8193, "[01(02)]充值失败，请稍后再试");
        hashMap4.put(8194, "[01(02)]充值失败，请稍后再试");
        hashMap4.put(8195, "[01）]充值失败，请稍后再试");
        hashMap4.put(8196, "[01]充值失败，请稍后再试");
        hashMap4.put(8197, "[01(02)]充值限额，最低限额10元、最高限额1000元，且必须为10的整数倍。");
        hashMap4.put(8198, "[02]充值失败，请稍后再试");
        hashMap4.put(8199, "[01(02)]充值失败，请稍后再试");
        hashMap4.put(8200, "[01]充值失败，请稍后再试");
        hashMap4.put(8201, "[01-EHC999912）]请首次开卡成功后30秒进行充值");
        hashMap4.put(32775, "[01(02)]充值失败，请联系客服");
        hashMap5.put(1, "[03-1]业务校验失败，请联系客服处理");
        hashMap5.put(2, "[03-2]业务校验失败，请联系客服处理");
        hashMap5.put(3, "[03-3]业务校验失败，请联系客服处理");
        hashMap5.put(4, "[03-4]业务校验失败，请联系客服处理");
        hashMap5.put(7, "[03-7]业务校验失败，请联系客服处理");
        hashMap5.put(20, "[03-20]业务校验失败，请联系客服处理");
        hashMap5.put(22, "[03-22]业务校验失败，请联系客服处理");
        hashMap5.put(4096, "[03-4096]网络请求失败，请稍后再试");
        hashMap5.put(4097, "[03-4097]响应数据解析失败");
        hashMap5.put(4098, "[03-4098]SE卡操作失败");
        hashMap5.put(4369, "[03-4369]业务校验失败，请联系客服处理");
        hashMap5.put(32775, "[01(02)]开卡失败，请稍后再试");
        hashMap5.put(39320, "[03-39320]业务异常，请联系客服处理");
        hashMap5.put(39321, "[03-39321]服务器繁忙，请稍后再试");
        hashMap5.put(18, "[03-18]业务校验失败，请联系客服处理");
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return f.k(str);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String b() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public static String c(Context context, int i10, int i11) {
        if (i10 == -1) {
            return "";
        }
        if (i11 == 0) {
            HashMap<Integer, String> hashMap = f34404a;
            if (hashMap.containsKey(Integer.valueOf(i10))) {
                return hashMap.get(Integer.valueOf(i10));
            }
        }
        if (i11 == 1) {
            HashMap<Integer, String> hashMap2 = f34405b;
            if (hashMap2.containsKey(Integer.valueOf(i10))) {
                return hashMap2.get(Integer.valueOf(i10));
            }
        }
        if (i11 == 3) {
            HashMap<Integer, String> hashMap3 = f34406c;
            if (hashMap3.containsKey(Integer.valueOf(i10))) {
                return hashMap3.get(Integer.valueOf(i10));
            }
        }
        if (i11 == 2) {
            HashMap<Integer, String> hashMap4 = f34407d;
            if (hashMap4.containsKey(Integer.valueOf(i10))) {
                return hashMap4.get(Integer.valueOf(i10));
            }
        }
        HashMap<Integer, String> hashMap5 = f34408e;
        return hashMap5.containsKey(Integer.valueOf(i10)) ? hashMap5.get(Integer.valueOf(i10)) : context.getString(m.I, Integer.valueOf(i10));
    }

    public static String d(BusinessException businessException) {
        BusinessException.ErrorMessage errorMsg = businessException.getErrorMsg();
        return errorMsg == null ? businessException.getMessage() : String.format("%s %s", businessException.getMessage(), errorMsg.getId());
    }

    public static String e(int i10) {
        Application e10 = b.e();
        if (i10 == 1) {
            return e10.getString(m.A0);
        }
        if (i10 == 3) {
            return e10.getString(m.f33110z0);
        }
        if (i10 == 2) {
            return e10.getString(m.B0);
        }
        return e10.getString(m.f33073k);
    }

    public static String f(int i10) {
        Application e10 = b.e();
        if (i10 == 1) {
            return e10.getString(m.F0);
        }
        if (i10 == 2) {
            return e10.getString(m.G0);
        }
        if (i10 == 3) {
            return e10.getString(m.J0);
        }
        if (i10 == 4) {
            return e10.getString(m.I0);
        }
        return e10.getString(m.H0);
    }

    public static String g(String str) {
        if (str.length() <= 36) {
            return str;
        }
        if (str.startsWith("9f7f") || str.startsWith("9F7F")) {
            str = str.substring(6, str.length());
        }
        return str.substring(24, 36);
    }

    public static String h(String[] strArr) {
        if (strArr == null) {
            return "9000";
        }
        if (strArr.length == 1) {
            return strArr[0];
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str : strArr) {
            sb2.append(str);
        }
        return sb2.toString();
    }

    public static String i() {
        String l10 = b.h().l();
        if (TextUtils.isEmpty(l10)) {
            l10 = a.x();
        }
        return l10.length() > 16 ? l10.substring(0, 16) : l10;
    }

    public static String j(String str) {
        return a(str);
    }

    public static boolean k(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(LeisenIfaceConfig.CARD_DATE_FORMAT, Locale.CHINA);
        simpleDateFormat.setLenient(false);
        try {
            simpleDateFormat.parse(str);
            return true;
        } catch (ParseException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static String l(String str) {
        if (str == null || str.length() != 8) {
            return str;
        }
        return str.substring(0, 4) + "-" + str.substring(4, 6) + "-" + str.substring(6, 8);
    }

    public static boolean m(String[] strArr, String str) {
        if (strArr == null) {
            return str != null && str.equals("9000");
        }
        for (String str2 : strArr) {
            if (str.equalsIgnoreCase(str2)) {
                return true;
            }
        }
        return false;
    }

    public static String n(String str) {
        if (str == null || str.length() != 8) {
            return str;
        }
        return str.substring(0, 4) + "-" + str.substring(4, 6) + "-" + str.substring(6, 8);
    }

    public static String o(int i10) {
        return p(i10, true);
    }

    public static String p(int i10, boolean z10) {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z10 ? "¥" : "");
        sb2.append(decimalFormat.format(i10 / 100.0d));
        return sb2.toString();
    }

    public static String q(String str) {
        if (str == null || str.length() != 6) {
            return str;
        }
        return str.substring(0, 2) + ":" + str.substring(2, 4) + ":" + str.substring(4, 6);
    }
}
