package g4;

import java.text.SimpleDateFormat;
import java.util.Calendar;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f27247a;

    /* renamed from: b  reason: collision with root package name */
    public String f27248b;

    /* renamed from: c  reason: collision with root package name */
    public String f27249c;

    /* renamed from: d  reason: collision with root package name */
    public String f27250d;

    /* renamed from: e  reason: collision with root package name */
    public String f27251e;

    /* renamed from: f  reason: collision with root package name */
    public String f27252f;

    /* renamed from: g  reason: collision with root package name */
    public String f27253g;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f27247a = str;
        this.f27248b = str2;
        this.f27249c = str3;
        this.f27250d = str4;
        this.f27251e = str5;
        this.f27252f = str6;
        this.f27253g = str7;
    }

    public final String toString() {
        String str;
        StringBuilder sb2;
        String str2;
        StringBuilder sb3;
        String str3;
        StringBuilder sb4;
        StringBuffer stringBuffer = new StringBuffer(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime()));
        stringBuffer.append("," + this.f27247a);
        stringBuffer.append("," + this.f27248b);
        stringBuffer.append("," + this.f27249c);
        stringBuffer.append("," + this.f27250d);
        if (c4.a.d(this.f27251e) || this.f27251e.length() < 20) {
            sb2 = new StringBuilder(",");
            str = this.f27251e;
        } else {
            sb2 = new StringBuilder(",");
            str = this.f27251e.substring(0, 20);
        }
        sb2.append(str);
        stringBuffer.append(sb2.toString());
        if (c4.a.d(this.f27252f) || this.f27252f.length() < 20) {
            sb3 = new StringBuilder(",");
            str2 = this.f27252f;
        } else {
            sb3 = new StringBuilder(",");
            str2 = this.f27252f.substring(0, 20);
        }
        sb3.append(str2);
        stringBuffer.append(sb3.toString());
        if (c4.a.d(this.f27253g) || this.f27253g.length() < 20) {
            sb4 = new StringBuilder(",");
            str3 = this.f27253g;
        } else {
            sb4 = new StringBuilder(",");
            str3 = this.f27253g.substring(0, 20);
        }
        sb4.append(str3);
        stringBuffer.append(sb4.toString());
        return stringBuffer.toString();
    }
}
