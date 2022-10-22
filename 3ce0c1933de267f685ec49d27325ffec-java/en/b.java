package en;

import android.content.Context;
import android.text.TextUtils;
import gn.p;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private static b f26132b;

    /* renamed from: a  reason: collision with root package name */
    private Context f26133a;

    private b(Context context) {
        this.f26133a = context;
    }

    private String a(String str) {
        Date date;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmm", Locale.US);
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e10) {
            e10.printStackTrace();
            date = null;
        }
        calendar.setTime(date);
        calendar.add(5, -1);
        return simpleDateFormat.format(calendar.getTime());
    }

    private byte[] b(int i10, String str) {
        byte[] bArr = new byte[0];
        if (TextUtils.isEmpty(str) || str.length() != 12 || !p.e(this.f26133a, 8192)) {
            return bArr;
        }
        int parseInt = Integer.parseInt(str.substring(0, 4));
        int parseInt2 = Integer.parseInt(str.substring(4, 6));
        int parseInt3 = Integer.parseInt(str.substring(6, 8));
        int parseInt4 = Integer.parseInt(str.substring(8, 10));
        int parseInt5 = Integer.parseInt(str.substring(10, 12));
        if (i10 == 1 || i10 == 9) {
            parseInt5 = 0;
        } else {
            if (i10 == 2) {
                String a10 = a(str);
                if (TextUtils.isEmpty(a10) || a10.length() != 12) {
                    parseInt = 0;
                    parseInt2 = 0;
                    parseInt3 = 0;
                    parseInt5 = 0;
                } else {
                    parseInt = Integer.parseInt(a10.substring(0, 4));
                    parseInt2 = Integer.parseInt(a10.substring(4, 6));
                    parseInt3 = Integer.parseInt(a10.substring(6, 8));
                    parseInt4 = 18;
                    parseInt5 = 0;
                }
            }
            return new byte[]{(byte) ((65280 & parseInt) >> 8), (byte) (parseInt & 255), (byte) (parseInt2 & 255), (byte) (parseInt3 & 255), (byte) (parseInt4 & 255), (byte) (parseInt5 & 255)};
        }
        parseInt4 = parseInt5;
        return new byte[]{(byte) ((65280 & parseInt) >> 8), (byte) (parseInt & 255), (byte) (parseInt2 & 255), (byte) (parseInt3 & 255), (byte) (parseInt4 & 255), (byte) (parseInt5 & 255)};
    }

    public static b d(Context context) {
        if (f26132b == null) {
            f26132b = new b(context);
        }
        return f26132b;
    }

    public byte[] c(int i10, String str) {
        byte[] bArr;
        byte[] b10 = b(i10, str);
        if (b10 == null || b10.length != 6) {
            bArr = new byte[2];
        } else {
            bArr = new byte[8];
            System.arraycopy(b10, 0, bArr, 2, b10.length);
        }
        switch (i10) {
            case 1:
                bArr[0] = -78;
                bArr[1] = -6;
                return bArr;
            case 2:
                if (p.e(this.f26133a, 262144)) {
                    return new byte[]{49, 1};
                }
                bArr[0] = -77;
                bArr[1] = -6;
                return bArr;
            case 3:
                if (p.f(this.f26133a, 16384)) {
                    bArr[0] = -9;
                } else {
                    bArr[0] = -26;
                }
                bArr[1] = -6;
                return bArr;
            case 4:
                bArr[0] = -56;
                bArr[1] = -6;
                return bArr;
            case 5:
                bArr[0] = -73;
                bArr[1] = -6;
                return bArr;
            case 6:
                bArr[0] = -71;
                bArr[1] = -6;
                return bArr;
            case 7:
                bArr[0] = -13;
                bArr[1] = -6;
                return bArr;
            case 8:
                bArr[0] = -12;
                bArr[1] = -6;
                return bArr;
            case 9:
                bArr[0] = -3;
                bArr[1] = -6;
                return bArr;
            case 10:
                bArr[0] = -23;
                bArr[1] = -6;
                return bArr;
            case 11:
                bArr[0] = 59;
                bArr[1] = -6;
                return bArr;
            default:
                return bArr;
        }
    }
}
