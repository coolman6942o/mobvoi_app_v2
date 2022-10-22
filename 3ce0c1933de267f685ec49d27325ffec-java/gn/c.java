package gn;

import an.a;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import en.q;
import java.util.Locale;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static c f27521c;

    /* renamed from: d  reason: collision with root package name */
    private static Context f27522d;

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f27523a;

    /* renamed from: b  reason: collision with root package name */
    private String[] f27524b;

    public c(Context context) {
        f27522d = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences(q.f27582a, 0);
        this.f27523a = sharedPreferences;
        sharedPreferences.edit();
    }

    public static c b(Context context) {
        if (f27521c == null) {
            f27521c = new c(context);
        }
        return f27521c;
    }

    public static boolean c(int i10) {
        int d10 = z.v(f27522d).d();
        boolean z10 = (d10 & i10) == i10;
        Log.d("isBandLanguageDisplay", "isSupport1 =" + z10 + ",functionType =" + i10 + ",function=" + d10);
        return z10;
    }

    public static boolean d(int i10) {
        int e10 = z.v(f27522d).e();
        boolean z10 = (e10 & i10) == i10;
        Log.d("isBandLanguageDisplay", "isSupport2 =" + z10 + ",functionType =" + i10 + ",function=" + e10);
        return z10;
    }

    public static boolean e(int i10) {
        int f10 = z.v(f27522d).f();
        boolean z10 = (f10 & i10) == i10;
        Log.d("isBandLanguageDisplay", "isSupport3 =" + z10 + ",functionType =" + i10 + ",function=" + f10);
        return z10;
    }

    public static boolean f(int i10) {
        int g10 = z.v(f27522d).g();
        boolean z10 = (g10 & i10) == i10;
        Log.d("isBandLanguageDisplay", "isSupport4 =" + z10 + ",functionType =" + i10 + ",function=" + g10);
        return z10;
    }

    public static boolean g(int i10) {
        int h10 = z.v(f27522d).h();
        boolean z10 = (h10 & i10) == i10;
        Log.d("isBandLanguageDisplay", "isSupport5 =" + z10 + ",functionType =" + i10 + ",function=" + h10);
        return z10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:521:0x07ac, code lost:
        if (r1.contains("cs") != false) goto L522;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String[] a(int i10) {
        int i11 = i10;
        if (i11 <= 0 || i11 > 101) {
            String locale = Locale.getDefault().toString();
            if (p.d(f27522d, 256)) {
                if (!locale.contains("zh_CN") || !c(1)) {
                    if ((!locale.contains("zh_TW") && !locale.contains("zh_MO") && !locale.contains("zh_HK")) || !c(4194304)) {
                        if (!locale.contains("ko") || !c(4)) {
                            if (!locale.contains("ja") || !c(8)) {
                                if (!locale.contains("de") || !c(16)) {
                                    if (!locale.contains("es") || !c(32)) {
                                        if (!locale.contains("fr") || !c(64)) {
                                            if (!locale.contains("it") || !c(128)) {
                                                if (!locale.contains("pt") || !c(256)) {
                                                    if (!locale.contains("ar") || !c(512)) {
                                                        if (!locale.contains("ru") || !c(8192)) {
                                                            if (!locale.contains("nl") || !c(16384)) {
                                                                if (!locale.contains("hi") || !c(2048)) {
                                                                    if (!locale.contains("pl") || !c(4096)) {
                                                                        if (!locale.contains("tr") || !c(32768)) {
                                                                            if (locale.contains("bn") && c(WXMediaMessage.THUMB_LENGTH_LIMIT)) {
                                                                                i11 = 17;
                                                                            } else if (!locale.contains("uk") || !c(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT)) {
                                                                                if (!locale.contains("in") || !c(262144)) {
                                                                                    if (!locale.contains("pa") || !c(524288)) {
                                                                                        if (!locale.contains("cs") || !c(2097152)) {
                                                                                            if (locale.contains("iw") && c(8388608)) {
                                                                                                i11 = 24;
                                                                                            } else if (locale.contains("sk") && d(1)) {
                                                                                                i11 = 25;
                                                                                            } else if (locale.contains("hu") && d(2)) {
                                                                                                i11 = 26;
                                                                                            } else if (locale.contains("ro") && d(4)) {
                                                                                                i11 = 27;
                                                                                            } else if (locale.contains("th") && c(1048576)) {
                                                                                                i11 = 21;
                                                                                            } else if (locale.contains("be") && d(8)) {
                                                                                                i11 = 28;
                                                                                            } else if (locale.contains("sq") && d(16)) {
                                                                                                i11 = 29;
                                                                                            } else if (locale.contains("am") && d(64)) {
                                                                                                i11 = 31;
                                                                                            } else if (locale.contains("az") && d(128)) {
                                                                                                i11 = 32;
                                                                                            } else if (locale.contains("ga") && d(256)) {
                                                                                                i11 = 33;
                                                                                            } else if (locale.contains("oc") && d(512)) {
                                                                                                i11 = 34;
                                                                                            } else if (locale.contains("or") && d(1024)) {
                                                                                                i11 = 35;
                                                                                            } else if (locale.contains("om") && d(2048)) {
                                                                                                i11 = 36;
                                                                                            } else if (locale.contains("eu") && d(4096)) {
                                                                                                i11 = 37;
                                                                                            } else if (locale.contains("bg") && d(8192)) {
                                                                                                i11 = 38;
                                                                                            } else if (locale.contains("bs") && d(16384)) {
                                                                                                i11 = 39;
                                                                                            } else if (locale.contains("fa") && d(32768)) {
                                                                                                i11 = 40;
                                                                                            } else if (locale.contains("fil") && d(WXMediaMessage.THUMB_LENGTH_LIMIT)) {
                                                                                                i11 = 41;
                                                                                            } else if (locale.contains("km") && d(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT)) {
                                                                                                i11 = 42;
                                                                                            } else if (locale.contains("gu") && d(262144)) {
                                                                                                i11 = 43;
                                                                                            } else if (locale.contains("kk") && d(524288)) {
                                                                                                i11 = 44;
                                                                                            } else if (locale.contains("ht") && d(1048576)) {
                                                                                                i11 = 45;
                                                                                            } else if (locale.contains("ha") && d(2097152)) {
                                                                                                i11 = 46;
                                                                                            } else if (locale.contains("ca") && d(8388608)) {
                                                                                                i11 = 48;
                                                                                            } else if (locale.contains("kn") && e(1)) {
                                                                                                i11 = 49;
                                                                                            } else if (locale.contains("xh") && e(2)) {
                                                                                                i11 = 50;
                                                                                            } else if (locale.contains("hr") && e(4)) {
                                                                                                i11 = 51;
                                                                                            } else if (locale.contains("qu") && e(8)) {
                                                                                                i11 = 52;
                                                                                            } else if (locale.contains("ku") && e(16)) {
                                                                                                i11 = 53;
                                                                                            } else if (locale.contains("la") && e(32)) {
                                                                                                i11 = 54;
                                                                                            } else if (locale.contains("lb") && e(64)) {
                                                                                                i11 = 55;
                                                                                            } else if (locale.contains("rw") && e(128)) {
                                                                                                i11 = 56;
                                                                                            } else if (locale.contains("da") && e(256)) {
                                                                                                i11 = 57;
                                                                                            } else if (locale.contains("rm") && e(1024)) {
                                                                                                i11 = 59;
                                                                                            } else if (locale.contains("mg") && e(2048)) {
                                                                                                i11 = 60;
                                                                                            } else if (locale.contains("mr") && e(4096)) {
                                                                                                i11 = 61;
                                                                                            } else if (locale.contains("ml") && e(16384)) {
                                                                                                i11 = 63;
                                                                                            } else if (locale.contains("ms") && e(32768)) {
                                                                                                i11 = 64;
                                                                                            } else if (locale.contains("mk") && e(WXMediaMessage.THUMB_LENGTH_LIMIT)) {
                                                                                                i11 = 65;
                                                                                            } else if (locale.contains("mai") && e(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT)) {
                                                                                                i11 = 66;
                                                                                            } else if (locale.contains("gv") && e(262144)) {
                                                                                                i11 = 67;
                                                                                            } else if (locale.contains("my") && e(524288)) {
                                                                                                i11 = 68;
                                                                                            } else if (locale.contains("nap") && e(1048576)) {
                                                                                                i11 = 69;
                                                                                            } else if (locale.contains("ne") && e(2097152)) {
                                                                                                i11 = 70;
                                                                                            } else if ((locale.contains("no") || locale.contains("nb")) && e(4194304)) {
                                                                                                i11 = 71;
                                                                                            } else if (locale.contains("ps") && e(8388608)) {
                                                                                                i11 = 72;
                                                                                            } else if (locale.contains("ny") && f(1)) {
                                                                                                i11 = 73;
                                                                                            } else if (locale.contains("sv") && f(2)) {
                                                                                                i11 = 74;
                                                                                            } else if (locale.contains("sr") && f(4)) {
                                                                                                i11 = 75;
                                                                                            } else if (locale.contains("si") && f(8)) {
                                                                                                i11 = 76;
                                                                                            } else if (locale.contains("sl") && f(16)) {
                                                                                                i11 = 77;
                                                                                            } else if (locale.contains("sw") && f(32)) {
                                                                                                i11 = 78;
                                                                                            } else if (locale.contains("ceb") && f(64)) {
                                                                                                i11 = 79;
                                                                                            } else if (locale.contains("so") && f(128)) {
                                                                                                i11 = 80;
                                                                                            } else if (locale.contains("sm") && f(256)) {
                                                                                                i11 = 81;
                                                                                            } else if (locale.contains("tl") && f(512)) {
                                                                                                i11 = 82;
                                                                                            } else if (locale.contains("tg") && f(1024)) {
                                                                                                i11 = 83;
                                                                                            } else if (locale.contains("te") && f(2048)) {
                                                                                                i11 = 84;
                                                                                            } else if (locale.contains("ta") && f(4096)) {
                                                                                                i11 = 85;
                                                                                            } else if (locale.contains("ti") && f(8192)) {
                                                                                                i11 = 86;
                                                                                            } else if (locale.contains("tk") && f(16384)) {
                                                                                                i11 = 87;
                                                                                            } else if (locale.contains("uk") && f(32768)) {
                                                                                                i11 = 88;
                                                                                            } else if (locale.contains("uz") && f(WXMediaMessage.THUMB_LENGTH_LIMIT)) {
                                                                                                i11 = 89;
                                                                                            } else if (locale.contains("el") && f(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT)) {
                                                                                                i11 = 90;
                                                                                            } else if (locale.contains("sd") && f(262144)) {
                                                                                                i11 = 91;
                                                                                            } else if (locale.contains("syr") && f(1048576)) {
                                                                                                i11 = 93;
                                                                                            } else if (locale.contains("ig") && f(2097152)) {
                                                                                                i11 = 94;
                                                                                            } else if (locale.contains("ilo") && f(4194304)) {
                                                                                                i11 = 95;
                                                                                            } else if (locale.contains("id") && f(8388608)) {
                                                                                                i11 = 96;
                                                                                            } else if (locale.contains("yo") && g(1)) {
                                                                                                i11 = 97;
                                                                                            } else if (locale.contains("fi") && !locale.contains("fil") && g(2)) {
                                                                                                i11 = 98;
                                                                                            } else if (locale.contains("vi") && g(4)) {
                                                                                                i11 = 99;
                                                                                            } else if (!locale.contains("zu") || !g(8)) {
                                                                                                if (locale.contains("mn") && g(16)) {
                                                                                                    i11 = 101;
                                                                                                }
                                                                                                i11 = 2;
                                                                                            } else {
                                                                                                i11 = 100;
                                                                                            }
                                                                                        }
                                                                                        i11 = 22;
                                                                                    } else {
                                                                                        i11 = 20;
                                                                                    }
                                                                                }
                                                                                i11 = 19;
                                                                            } else {
                                                                                i11 = 18;
                                                                            }
                                                                        }
                                                                        i11 = 16;
                                                                    }
                                                                    i11 = 13;
                                                                }
                                                                i11 = 12;
                                                            }
                                                            i11 = 15;
                                                        }
                                                        i11 = 14;
                                                    }
                                                    i11 = 10;
                                                }
                                                i11 = 9;
                                            }
                                            i11 = 8;
                                        }
                                        i11 = 7;
                                    }
                                    i11 = 6;
                                }
                                i11 = 5;
                            }
                            i11 = 4;
                        }
                        i11 = 3;
                    }
                    i11 = 23;
                }
                i11 = 1;
            } else {
                if (!locale.contains("zh_CN")) {
                    if (!locale.contains("zh_TW") && !locale.contains("zh_MO") && !locale.contains("zh_HK")) {
                        if (!locale.contains("ko")) {
                            if (!locale.contains("ja")) {
                                if (!locale.contains("de")) {
                                    if (!locale.contains("es")) {
                                        if (!locale.contains("fr")) {
                                            if (!locale.contains("it")) {
                                                if (!locale.contains("pt")) {
                                                    if (!locale.contains("ar")) {
                                                        if (!locale.contains("ru")) {
                                                            if (!locale.contains("nl")) {
                                                                if (!locale.contains("hi")) {
                                                                    if (!locale.contains("pl")) {
                                                                        if (!locale.contains("tr")) {
                                                                            if (!locale.contains("in")) {
                                                                            }
                                                                            i11 = 19;
                                                                        }
                                                                        i11 = 16;
                                                                    }
                                                                    i11 = 13;
                                                                }
                                                                i11 = 12;
                                                            }
                                                            i11 = 15;
                                                        }
                                                        i11 = 14;
                                                    }
                                                    i11 = 10;
                                                }
                                                i11 = 9;
                                            }
                                            i11 = 8;
                                        }
                                        i11 = 7;
                                    }
                                    i11 = 6;
                                }
                                i11 = 5;
                            }
                            i11 = 4;
                        }
                        i11 = 3;
                    }
                    i11 = 23;
                }
                i11 = 1;
            }
        }
        z.v(f27522d).T(i11);
        if (p.e(f27522d, 1048576)) {
            q.B(f27522d).R(i11);
            return null;
        }
        switch (i11) {
            case 1:
                this.f27524b = f27522d.getResources().getStringArray(a.b_res_0x7f03001b);
                break;
            case 2:
                this.f27524b = f27522d.getResources().getStringArray(a.e_res_0x7f030020);
                break;
            case 3:
                this.f27524b = f27522d.getResources().getStringArray(a.o_res_0x7f03002f);
                break;
            case 4:
                this.f27524b = f27522d.getResources().getStringArray(a.n_res_0x7f03002e);
                break;
            case 5:
                this.f27524b = f27522d.getResources().getStringArray(a.d_res_0x7f03001e);
                break;
            case 6:
                this.f27524b = f27522d.getResources().getStringArray(a.f_res_0x7f030022);
                break;
            case 7:
                this.f27524b = f27522d.getResources().getStringArray(a.g_res_0x7f030024);
                break;
            case 8:
                this.f27524b = f27522d.getResources().getStringArray(a.l_res_0x7f03002c);
                break;
            case 9:
                this.f27524b = f27522d.getResources().getStringArray(a.r_res_0x7f03003b);
                break;
            case 10:
                this.f27524b = f27522d.getResources().getStringArray(a.a_res_0x7f030002);
                break;
            case 11:
            case 17:
            case 18:
            case 20:
            case 21:
            default:
                z.v(f27522d).T(2);
                this.f27524b = f27522d.getResources().getStringArray(a.e_res_0x7f030020);
                break;
            case 12:
                this.f27524b = f27522d.getResources().getStringArray(a.h_res_0x7f030028);
                break;
            case 13:
                this.f27524b = f27522d.getResources().getStringArray(a.q_res_0x7f03003a);
                break;
            case 14:
                this.f27524b = f27522d.getResources().getStringArray(a.f289t);
                break;
            case 15:
                this.f27524b = f27522d.getResources().getStringArray(a.p_res_0x7f030039);
                break;
            case 16:
                this.f27524b = f27522d.getResources().getStringArray(a.v_res_0x7f030049);
                break;
            case 19:
                this.f27524b = f27522d.getResources().getStringArray(a.k_res_0x7f03002b);
                break;
            case 22:
                this.f27524b = f27522d.getResources().getStringArray(a.c_res_0x7f03001d);
                break;
            case 23:
                this.f27524b = f27522d.getResources().getStringArray(a.i_res_0x7f030029);
                break;
            case 24:
                this.f27524b = f27522d.getResources().getStringArray(a.m_res_0x7f03002d);
                break;
            case 25:
                this.f27524b = f27522d.getResources().getStringArray(a.u_res_0x7f030044);
                break;
            case 26:
                this.f27524b = f27522d.getResources().getStringArray(a.j_res_0x7f03002a);
                break;
            case 27:
                this.f27524b = f27522d.getResources().getStringArray(a.s_res_0x7f030041);
                break;
        }
        return this.f27524b;
    }
}
