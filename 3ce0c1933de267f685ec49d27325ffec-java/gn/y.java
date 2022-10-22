package gn;

import android.content.Context;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class y {

    /* renamed from: b  reason: collision with root package name */
    private static y f27609b;

    /* renamed from: a  reason: collision with root package name */
    private Context f27610a;

    private y(Context context) {
        this.f27610a = context;
        context.getSharedPreferences(q.f27582a, 0);
    }

    private boolean a(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static y h(Context context) {
        if (f27609b == null) {
            f27609b = new y(context);
        }
        return f27609b;
    }

    public float b(int i10, int i11) {
        double d10;
        String str;
        float parseFloat;
        float parseFloat2;
        StringBuilder sb2;
        String B;
        float parseFloat3;
        boolean A;
        double d11;
        float f10;
        StringBuilder sb3;
        String str2;
        double d12;
        double d13;
        float f11;
        if (p.f(this.f27610a, 4096)) {
            if (i11 == 1) {
                B = z.v(this.f27610a).B();
                float parseFloat4 = Float.parseFloat(B);
                parseFloat3 = Float.parseFloat(z.v(this.f27610a).D());
                A = z.v(this.f27610a).A();
                if (A) {
                    f11 = parseFloat4 * 0.5461055f;
                    d13 = parseFloat3;
                    d12 = 0.9288487d;
                } else {
                    f11 = parseFloat4 * 0.5047813f;
                    d13 = parseFloat3;
                    d12 = 1.23493d;
                }
                d10 = (((d13 * d12) * f11) * i10) / 100000.0d;
                sb3 = new StringBuilder();
                str2 = "跑步步数 =";
            } else {
                if (!(i11 == 2 || i11 == 3 || i11 == 4)) {
                    B = z.v(this.f27610a).B();
                    float parseFloat5 = Float.parseFloat(B);
                    parseFloat3 = Float.parseFloat(z.v(this.f27610a).D());
                    A = z.v(this.f27610a).A();
                    if (A) {
                        f10 = parseFloat5 * 0.410267f;
                        d11 = parseFloat3 * 0.5907296d;
                    } else {
                        f10 = parseFloat5 * 0.4151582f;
                        d11 = parseFloat3 * 0.7918928d;
                    }
                    d10 = ((d11 * f10) * i10) / 100000.0d;
                    sb3 = new StringBuilder();
                    str2 = "走路步数 =";
                }
                d10 = 0.0d;
            }
            sb3.append(str2);
            sb3.append(i10);
            sb3.append(",卡路里 =");
            sb3.append(d10);
            sb3.append(",性别 =");
            sb3.append(A);
            sb3.append(",身高 =");
            sb3.append(B);
            sb3.append(",体重 =");
            sb3.append(parseFloat3);
            str = sb3.toString();
            u.a("calculateCalories", str);
        } else {
            if (i11 == 1) {
                String C = z.v(this.f27610a).C();
                String D = z.v(this.f27610a).D();
                parseFloat = Float.parseFloat(C);
                parseFloat2 = Float.parseFloat(D);
                d10 = (((parseFloat2 * 0.708d) * parseFloat) * i10) / 100000.0d;
                sb2 = new StringBuilder();
            } else {
                if (!(i11 == 2 || i11 == 3 || i11 == 4)) {
                    String C2 = z.v(this.f27610a).C();
                    String D2 = z.v(this.f27610a).D();
                    parseFloat = Float.parseFloat(C2);
                    parseFloat2 = Float.parseFloat(D2);
                    d10 = (((parseFloat2 * 0.708d) * parseFloat) * i10) / 100000.0d;
                    sb2 = new StringBuilder();
                }
                d10 = 0.0d;
            }
            sb2.append("常规步数 =");
            sb2.append(i10);
            sb2.append(",卡路里 =");
            sb2.append(d10);
            sb2.append(",Length =");
            sb2.append(parseFloat);
            sb2.append(",体重 =");
            sb2.append(parseFloat2);
            str = sb2.toString();
            u.a("calculateCalories", str);
        }
        return (float) d10;
    }

    public float c(int i10, int i11) {
        double d10;
        double d11;
        double d12;
        float parseFloat = Float.parseFloat(z.v(this.f27610a).D());
        if (i11 == 0) {
            d12 = parseFloat;
            d11 = 0.708d;
        } else if (i11 != 1) {
            d10 = i11 != 2 ? 0.0d : (((parseFloat * 1.05d) * i10) / 1000.0d) / 4.0d;
            return (float) d10;
        } else {
            d12 = parseFloat;
            d11 = 1.036d;
        }
        d10 = ((d12 * d11) * i10) / 1000.0d;
        return (float) d10;
    }

    public float d(int i10, int i11) {
        String str;
        float f10;
        float f11;
        StringBuilder sb2;
        float f12;
        String str2;
        StringBuilder sb3;
        boolean z10;
        if (p.f(this.f27610a, 4096)) {
            if (i11 == 1) {
                f12 = Float.parseFloat(z.v(this.f27610a).B());
                z10 = z.v(this.f27610a).A();
                f10 = (i10 * ((z10 ? 0.5461055f : 0.5047813f) * f12)) / 100000.0f;
                sb3 = new StringBuilder();
                str2 = "跑步步数 =";
            } else {
                f12 = Float.parseFloat(z.v(this.f27610a).B());
                z10 = z.v(this.f27610a).A();
                f10 = (i10 * ((z10 ? 0.410267f : 0.4151582f) * f12)) / 100000.0f;
                sb3 = new StringBuilder();
                str2 = "走路步数 =";
            }
            sb3.append(str2);
            sb3.append(i10);
            sb3.append(",路程=");
            sb3.append(f10);
            sb3.append(",性别 =");
            sb3.append(z10);
            sb3.append(",身高 =");
            sb3.append(f12);
            str = sb3.toString();
        } else {
            if (i11 == 1) {
                f11 = Float.parseFloat(z.v(this.f27610a).C());
                f10 = (i10 * f11) / 100000.0f;
                sb2 = new StringBuilder();
            } else {
                f11 = Float.parseFloat(z.v(this.f27610a).C());
                f10 = (i10 * f11) / 100000.0f;
                sb2 = new StringBuilder();
            }
            sb2.append("常规步数 =");
            sb2.append(i10);
            sb2.append(",路程=");
            sb2.append(f10);
            sb2.append(",Length =");
            sb2.append(f11);
            str = sb2.toString();
        }
        u.a("calculateDistance", str);
        return f10;
    }

    public float e(int i10) {
        return (i10 / 60.0f) * 9.72f;
    }

    public float f(int i10, int i11) {
        String D = z.v(this.f27610a).D();
        return (a(D) ? Integer.parseInt(D) : 60) * i11 * 0.001202714f;
    }

    public float g(int i10, int i11) {
        String D = z.v(this.f27610a).D();
        return (a(D) ? Integer.parseInt(D) : 60) * i11 * 0.005581349f;
    }
}
