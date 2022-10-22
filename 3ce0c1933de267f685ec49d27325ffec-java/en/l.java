package en;

import android.content.Context;
import com.bjleisen.iface.sdk.apdu.LeisenIfaceConfig;
import gn.j;
import gn.t;
import gn.z;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes2.dex */
public class l {

    /* renamed from: y  reason: collision with root package name */
    private static l f26165y;

    /* renamed from: u  reason: collision with root package name */
    private String f26186u;

    /* renamed from: w  reason: collision with root package name */
    private Context f26188w;

    /* renamed from: x  reason: collision with root package name */
    private int f26189x;

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<m> f26166a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<m> f26167b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<m> f26168c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<g> f26169d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private int[] f26170e = {5, 0, -4, 2, -8, 3, -4, 7, -2, 1};

    /* renamed from: f  reason: collision with root package name */
    private int[] f26171f = {1, -4, 5, -1, 4, -5, 2, -6, 5, -1};

    /* renamed from: g  reason: collision with root package name */
    private int[] f26172g = {-3, 1, -1, 5, -8, 4, -3, 5, -1, 1};

    /* renamed from: h  reason: collision with root package name */
    private int[] f26173h = {-1, 4, -5, 4, 2, -4, 3, -3, 4, -4};

    /* renamed from: i  reason: collision with root package name */
    private int[] f26174i = {3, -2, 1, -5, 0, 5, -2, 0, 3, -3};

    /* renamed from: j  reason: collision with root package name */
    private int[] f26175j = {-2, 3, -4, 6, -5, 2, -3, 4, -1, 0};

    /* renamed from: k  reason: collision with root package name */
    private int[] f26176k = {2, -7, 3, -4, 6, -5, 4, -1, 3, -1};

    /* renamed from: l  reason: collision with root package name */
    private int f26177l = 0;

    /* renamed from: m  reason: collision with root package name */
    private int f26178m = 0;

    /* renamed from: n  reason: collision with root package name */
    private int f26179n = 0;

    /* renamed from: o  reason: collision with root package name */
    private int f26180o = 0;

    /* renamed from: p  reason: collision with root package name */
    private int f26181p = 0;

    /* renamed from: q  reason: collision with root package name */
    private boolean f26182q = false;

    /* renamed from: r  reason: collision with root package name */
    private boolean f26183r = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f26184s = false;

    /* renamed from: t  reason: collision with root package name */
    private boolean f26185t = false;

    /* renamed from: v  reason: collision with root package name */
    private String f26187v = "20100101";

    private l(Context context) {
        this.f26188w = context;
    }

    private int a(String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(m(str));
        return calendar.get(7);
    }

    private int b(String str, String str2, String str3) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd HH:mm", Locale.US);
        try {
            long time = (!str.equals("") ? simpleDateFormat.parse(str) : simpleDateFormat.parse("30001212 01:01")).getTime();
            long time2 = (!str2.equals("") ? simpleDateFormat.parse(str2) : simpleDateFormat.parse("30001212 01:01")).getTime();
            long time3 = (!str3.equals("") ? simpleDateFormat.parse(str3) : simpleDateFormat.parse("30001212 01:01")).getTime();
            long j10 = time > time2 ? time2 : time;
            if (j10 <= time3) {
                time3 = j10;
            }
            if (time3 == time) {
                return 100;
            }
            return time3 == time2 ? 101 : 102;
        } catch (Exception unused) {
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00dc A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ArrayList<m> c(ArrayList<m> arrayList) {
        int i10;
        int i11;
        ArrayList<m> arrayList2 = new ArrayList<>();
        int i12 = 0;
        String a10 = arrayList.get(0).a();
        int[] k10 = k(a10);
        int i13 = 0;
        int i14 = 0;
        while (i12 < arrayList.size()) {
            int i15 = k10[i12 % 10];
            int b10 = arrayList.get(i12).b();
            int d10 = arrayList.get(i12).d();
            if (i12 == 0) {
                i10 = b10 - 15;
                i11 = b10 + i13;
            } else if (i12 == arrayList.size() - 1) {
                int b11 = arrayList.get(i12).b() - arrayList.get(i12 - 1).b();
                if (b11 < 0) {
                    b11 += 1440;
                }
                i10 = b11 < 15 ? (b10 + i13) - b11 : (b10 + i13) - 15;
                if (arrayList2.size() > 0) {
                    String a11 = arrayList2.get(arrayList2.size() - 1).a();
                    int d11 = arrayList2.get(arrayList2.size() - 1).d();
                    int e10 = arrayList2.get(arrayList2.size() - 1).e();
                    if (arrayList2.get(arrayList2.size() - 1).b() > b10) {
                        i14 = b10 - 1;
                        arrayList2.remove(arrayList2.size() - 1);
                        arrayList2.add(new m(a11, e10, i14, d11));
                    }
                }
                if (b10 < 0) {
                    b10 += 1440;
                }
                if (i10 >= 0) {
                    i10 += 1440;
                } else if (i10 >= b10) {
                    i10 = i14;
                }
                if (i10 < i14) {
                    i14 = i10;
                }
                arrayList2.add(new m(a10, i14, b10, d10));
                t.a("sleep_data", "sleepDataConfusion,calendar=" + a10 + ",newStartTime=" + i14 + "," + (i14 / 60) + ":" + (i14 % 60) + ",newEndTime=" + b10 + "," + (b10 / 60) + ":" + (b10 % 60) + ",last_diff_sum=" + i13 + ",current_diff=" + i15);
                i13 += i15;
                i12++;
                i14 = b10;
            } else {
                i11 = b10 + i13;
                i10 = i11 - 15;
            }
            b10 = i11 + i15;
            if (b10 < 0) {
            }
            if (i10 >= 0) {
            }
            if (i10 < i14) {
            }
            arrayList2.add(new m(a10, i14, b10, d10));
            t.a("sleep_data", "sleepDataConfusion,calendar=" + a10 + ",newStartTime=" + i14 + "," + (i14 / 60) + ":" + (i14 % 60) + ",newEndTime=" + b10 + "," + (b10 / 60) + ":" + (b10 % 60) + ",last_diff_sum=" + i13 + ",current_diff=" + i15);
            i13 += i15;
            i12++;
            i14 = b10;
        }
        return arrayList2;
    }

    private void d() {
        this.f26166a = new ArrayList<>();
        this.f26177l = 0;
        this.f26167b = new ArrayList<>();
        this.f26168c = new ArrayList<>();
        this.f26178m = 0;
        this.f26180o = 0;
        this.f26179n = 0;
        this.f26181p = 0;
        this.f26182q = false;
        this.f26183r = false;
    }

    private void e(int i10) {
        if (i10 == 100) {
            int size = this.f26166a.size();
            for (int i11 = size - 11; i11 < size; i11 = i11 + (-1) + 1) {
                t.a("sleep_data", "len=" + size + ";i=" + i11 + ";删除元素：" + this.f26166a.get(i11).b());
                this.f26166a.remove(i11);
                size += -1;
            }
        } else if (i10 == 102) {
            int size2 = this.f26168c.size();
            for (int i12 = size2 - 3; i12 < size2; i12 = i12 + (-1) + 1) {
                t.a("sleep_data", "len=" + size2 + ";i=" + i12 + ";删除元素：" + this.f26168c.get(i12).b());
                this.f26168c.remove(i12);
                size2 += -1;
            }
        }
    }

    private void f(int i10, m mVar) {
        if (i10 == 102) {
            ArrayList<m> arrayList = this.f26168c;
            if (arrayList.get(arrayList.size() - 1).d() >= 150) {
                ArrayList<m> arrayList2 = this.f26168c;
                if (arrayList2.get(arrayList2.size() - 2).d() >= 150) {
                    ArrayList<m> arrayList3 = this.f26168c;
                    if (arrayList3.get(arrayList3.size() - 3).d() >= 150) {
                        if (mVar.b() <= 60 || mVar.b() >= 1080) {
                            t.a("sleep_data", "连续，连续3次>=150，而且在18:00~01:00内全删");
                            g(mVar);
                            this.f26180o = 1;
                        }
                        if (i10 == 100 && mVar.b() > 360 && mVar.b() < 1080) {
                            this.f26184s = true;
                            return;
                        }
                        return;
                    }
                }
            }
        }
        e(i10);
        t.a("sleep_data", "删除连续部分");
        if (i10 != 100 || this.f26166a.size() + this.f26167b.size() > 8) {
            if (i10 == 102) {
                this.f26168c.add(mVar);
                this.f26179n = 0;
                this.f26180o = 1;
                this.f26178m = 1;
            }
        } else if (mVar.b() <= 60 || mVar.b() >= 1080 || (mVar.b() > 60 && mVar.b() < 1080 && this.f26166a.size() + this.f26167b.size() <= 4)) {
            t.a("sleep_data", "连续，剩余深睡+浅睡<2小时 或者1点后深睡+浅睡<1小时，全部删除，time=" + mVar.b());
            g(mVar);
        }
        if (i10 == 100) {
        }
    }

    private void g(m mVar) {
        String str;
        StringBuilder sb2;
        this.f26166a = new ArrayList<>();
        this.f26177l = 0;
        this.f26167b = new ArrayList<>();
        this.f26168c = new ArrayList<>();
        this.f26178m = 0;
        this.f26180o = 0;
        this.f26179n = 0;
        this.f26181p = 0;
        if (mVar.d() > 3 && mVar.d() <= 40) {
            this.f26167b.add(mVar);
        } else if (mVar.d() <= 40) {
            if (mVar.b() <= 60 || mVar.b() >= 1080) {
                this.f26182q = true;
                sb2 = new StringBuilder();
                str = "1点前，则删除当前深睡，**sleepStateInfo.getTime()=";
            } else if (this.f26182q) {
                sb2 = new StringBuilder();
                str = "连续深睡，不保存当前深睡，**sleepStateInfo.getTime()=";
            } else {
                this.f26166a.add(mVar);
                this.f26177l++;
                t.a("sleep_data", "不是连续深睡，大于1点，是深睡也要插入");
            }
            sb2.append(str);
            sb2.append(mVar.b());
            t.a("sleep_data", sb2.toString());
            this.f26183r = false;
        } else if (mVar.d() < 150 || (mVar.b() > 60 && mVar.b() < 1080)) {
            this.f26168c.add(mVar);
            this.f26178m++;
            this.f26182q = false;
            return;
        } else {
            return;
        }
        this.f26182q = false;
        this.f26183r = false;
    }

    private boolean h(String str, String str2, String str3, int i10) {
        Date date;
        String str4;
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd HH:mm", locale);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(LeisenIfaceConfig.CARD_DATE_FORMAT, locale);
        try {
            date = simpleDateFormat.parse(str);
        } catch (Exception e10) {
            e10.printStackTrace();
            date = null;
        }
        if (date == null) {
            return true;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(12, i10);
        this.f26186u = simpleDateFormat2.format(calendar.getTime());
        if (!str3.equals("")) {
            if (this.f26186u.equals(str2) && str3.equals(str2)) {
                this.f26185t = false;
            } else if (!this.f26186u.equals(str2)) {
                if (!str3.equals(str2)) {
                    str4 = "18点后，刚来的相邻数据不是同一天，属于newday";
                } else if (!this.f26185t) {
                    str4 = "18点后，同一天连续来数据只用第一条判断为新一天的数据，属于newday";
                }
                t.a("sleep_data", str4);
            } else if (!str3.equals(str2) && !this.f26187v.equals(str2)) {
                t.a("sleep_data", "不同一天的两条数据，并且与上一条加上360分钟后，还不是同一天，属于newday");
                this.f26185t = false;
                this.f26187v = this.f26186u;
                return true;
            }
            this.f26187v = this.f26186u;
            return false;
        }
        this.f26185t = true;
        this.f26187v = this.f26186u;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0132 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ArrayList<g> i() {
        ArrayList<m> arrayList;
        int b10;
        m mVar;
        int i10;
        int i11;
        StringBuilder sb2;
        ArrayList<g> arrayList2 = new ArrayList<>();
        if (this.f26169d.size() != 0) {
            String str = "";
            for (int i12 = 0; i12 < this.f26169d.size(); i12++) {
                g gVar = this.f26169d.get(i12);
                ArrayList<m> b11 = gVar.b();
                ArrayList<m> c10 = gVar.c();
                ArrayList<m> a10 = gVar.a();
                t.a("caicai", "day=" + i12 + ",deepSleepArray.size()=" + b11.size() + ",lightSleepArray.size()=" + c10.size() + ",awakeSleepArray.size()=" + a10.size());
                if (b11.size() != 0) {
                    str = b11.get(0).a();
                    int b12 = b11.get(0).b();
                    if (j(b12)) {
                        i10 = b12 / 60;
                        i11 = b12 % 60;
                        sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(" ");
                        sb2.append(i10);
                        sb2.append(":");
                        sb2.append(i11);
                        str = q(sb2.toString(), 360);
                    }
                    arrayList = new ArrayList<>();
                    while (true) {
                        if (b11.size() != 0 && c10.size() == 0 && a10.size() == 0) {
                            break;
                        }
                        b10 = b(b11.size() != 0 ? b11.get(0).a() + " " + (b11.get(0).b() / 60) + ":" + (b11.get(0).b() % 60) : "", c10.size() != 0 ? c10.get(0).a() + " " + (c10.get(0).b() / 60) + ":" + (c10.get(0).b() % 60) : "", a10.size() != 0 ? a10.get(0).a() + " " + (a10.get(0).b() / 60) + ":" + (a10.get(0).b() % 60) : "");
                        if (b10 == 100) {
                            mVar = new m(str, b11.get(0).b(), b11.get(0).d());
                            b11.remove(0);
                        } else if (b10 == 101) {
                            mVar = new m(str, c10.get(0).b(), c10.get(0).d());
                            c10.remove(0);
                        } else {
                            mVar = new m(str, a10.get(0).b(), a10.get(0).d());
                            a10.remove(0);
                        }
                        arrayList.add(mVar);
                    }
                    if (arrayList.size() != 0) {
                        new ArrayList();
                        arrayList2.add(new g(c(arrayList)));
                    }
                } else if (c10.size() != 0) {
                    str = c10.get(0).a();
                    int b13 = c10.get(0).b();
                    if (j(b13)) {
                        i10 = b13 / 60;
                        i11 = b13 % 60;
                        sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(" ");
                        sb2.append(i10);
                        sb2.append(":");
                        sb2.append(i11);
                        str = q(sb2.toString(), 360);
                    }
                    arrayList = new ArrayList<>();
                    while (true) {
                        if (b11.size() != 0) {
                        }
                        if (b11.size() != 0) {
                        }
                        if (c10.size() != 0) {
                        }
                        if (a10.size() != 0) {
                        }
                        b10 = b(b11.size() != 0 ? b11.get(0).a() + " " + (b11.get(0).b() / 60) + ":" + (b11.get(0).b() % 60) : "", c10.size() != 0 ? c10.get(0).a() + " " + (c10.get(0).b() / 60) + ":" + (c10.get(0).b() % 60) : "", a10.size() != 0 ? a10.get(0).a() + " " + (a10.get(0).b() / 60) + ":" + (a10.get(0).b() % 60) : "");
                        if (b10 == 100) {
                        }
                        arrayList.add(mVar);
                    }
                    if (arrayList.size() != 0) {
                    }
                } else {
                    if (a10.size() != 0) {
                        str = a10.get(0).a();
                        int b14 = a10.get(0).b();
                        if (j(b14)) {
                            i10 = b14 / 60;
                            i11 = b14 % 60;
                            sb2 = new StringBuilder();
                            sb2.append(str);
                            sb2.append(" ");
                            sb2.append(i10);
                            sb2.append(":");
                            sb2.append(i11);
                            str = q(sb2.toString(), 360);
                        }
                    }
                    arrayList = new ArrayList<>();
                    while (true) {
                        if (b11.size() != 0) {
                        }
                        if (b11.size() != 0) {
                        }
                        if (c10.size() != 0) {
                        }
                        if (a10.size() != 0) {
                        }
                        b10 = b(b11.size() != 0 ? b11.get(0).a() + " " + (b11.get(0).b() / 60) + ":" + (b11.get(0).b() % 60) : "", c10.size() != 0 ? c10.get(0).a() + " " + (c10.get(0).b() / 60) + ":" + (c10.get(0).b() % 60) : "", a10.size() != 0 ? a10.get(0).a() + " " + (a10.get(0).b() / 60) + ":" + (a10.get(0).b() % 60) : "");
                        if (b10 == 100) {
                        }
                        arrayList.add(mVar);
                    }
                    if (arrayList.size() != 0) {
                    }
                }
            }
        }
        return arrayList2;
    }

    private boolean j(int i10) {
        return i10 + 360 >= 1440;
    }

    private int[] k(String str) {
        int[] iArr = new int[10];
        switch (a(str)) {
            case 1:
                return this.f26176k;
            case 2:
                return this.f26170e;
            case 3:
                return this.f26171f;
            case 4:
                return this.f26172g;
            case 5:
                return this.f26173h;
            case 6:
                return this.f26174i;
            case 7:
                return this.f26175j;
            default:
                return iArr;
        }
    }

    private int l() {
        int i10;
        int i11;
        int i12;
        ArrayList<m> arrayList;
        ArrayList<m> arrayList2;
        ArrayList<m> arrayList3;
        int i13 = -1;
        if (this.f26166a.size() != 0) {
            i10 = this.f26166a.get(arrayList3.size() - 1).b();
        } else {
            i10 = -1;
        }
        if (this.f26167b.size() != 0) {
            i11 = this.f26167b.get(arrayList2.size() - 1).b();
        } else {
            i11 = -1;
        }
        if (this.f26168c.size() != 0) {
            i12 = this.f26168c.get(arrayList.size() - 1).b();
        } else {
            i12 = -1;
        }
        if (j(i10)) {
            i10 = -1;
        }
        if (j(i11)) {
            i11 = -1;
        }
        if (!j(i12)) {
            i13 = i12;
        }
        if (i10 <= i11) {
            i10 = i11;
        }
        return i10 < i13 ? i13 : i10;
    }

    private Date m(String str) {
        return new SimpleDateFormat(LeisenIfaceConfig.CARD_DATE_FORMAT, Locale.US).parse(str, new ParsePosition(0));
    }

    public static l p(Context context) {
        if (f26165y == null) {
            f26165y = new l(context);
        }
        return f26165y;
    }

    /* JADX WARN: Removed duplicated region for block: B:271:0x072a  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0774  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0834  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x085a  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0879  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n(String str, int i10, int i11, String str2, int i12) {
        int i13;
        int i14;
        boolean z10;
        int i15;
        int i16;
        ArrayList<m> arrayList;
        int i17;
        int i18;
        this.f26189x = z.v(this.f26188w).z();
        t.a("sleep_data", "Age=" + this.f26189x + ", macAddress=" + z.v(this.f26188w).w());
        int i19 = i10 - i12;
        if (i19 < 0) {
            i19 += 1440;
        }
        int i20 = i19;
        int i21 = -1;
        try {
            i21 = j.a(str, str2);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        m mVar = new m(str, i10, i11);
        String str3 = str + " " + (i10 / 60) + ":" + (i10 % 60);
        boolean h10 = h(str3, str, str2, 360);
        t.a("sleep_data", "isNewDay=" + h10 + ",day=" + str3 + ",calendar=" + str + ",lastCalendar =" + str2 + ",isGetUpFlag =" + this.f26184s);
        if (h10) {
            t.a("sleep_data", "LastCalendarSleepData,mDeepSleepArrayInfo.size()=" + this.f26166a.size() + ",mLightSleepArrayInfo.size()=" + this.f26167b.size() + ",mAwakeSleepArrayInfo.size()=" + this.f26168c.size());
            t.a("sleep_data", "maybeNewCalendar=" + this.f26186u + ",lastNewCalendar=" + this.f26187v + ",calendar=" + str + ",lastCalendar=" + str2 + ",time=" + i10 + ",lastTime=" + i12);
            this.f26184s = false;
            if (this.f26166a.size() + this.f26167b.size() < 8) {
                t.a("sleep_data", "新一天准备保存数据时，发现剩余深睡+浅睡<2小时，全部删除，time=" + i10);
                g(mVar);
                if (i10 > 480 && i10 < 1080) {
                    this.f26184s = true;
                }
            } else if (this.f26167b.size() == 0 && this.f26168c.size() == 0) {
                t.a("sleep_data", "新一天准备保存数据时，发现剩余全是深睡，全部删除，time=" + i10);
                g(mVar);
                if (i10 > 480 && i10 < 1080) {
                    this.f26184s = true;
                }
            } else if (l() < 210) {
                t.a("sleep_data", "新一天准备保存数据时，发现没有睡眠超过3点半，全部删除，time=" + i10);
                g(mVar);
                if (i10 > 480 && i10 < 1080) {
                    this.f26184s = true;
                }
            } else {
                g gVar = new g(this.f26166a, this.f26167b, this.f26168c);
                t.a("sleep_data", "添加当天睡眠数据到大数组前1 ");
                this.f26169d.add(gVar);
                ArrayList<m> arrayList2 = this.f26166a;
                if (!(arrayList2 == null || arrayList2.size() == 0)) {
                    t.a("sleep_data", "添加当天睡眠数据到大数组1 后" + this.f26166a.get(0).a());
                }
                t.a("sleep_data", "newcalendar,SaveAllSleeppArray,calendar=" + str + ",time=" + i10 + ",deepSleepArray.size()=" + this.f26166a.size() + ",lightSleepArray.size()=" + this.f26167b.size() + ",awakeSleepArray.size()=" + this.f26168c.size());
                d();
                if (i10 <= 480 || i10 >= 1080) {
                    if (i11 <= 3) {
                        this.f26166a.add(mVar);
                        i18 = 0;
                    } else {
                        i18 = 0;
                        if (i11 <= 40) {
                            this.f26167b.add(mVar);
                        } else if (i11 < 110) {
                            this.f26168c.add(mVar);
                            this.f26180o++;
                            return;
                        } else {
                            return;
                        }
                    }
                    this.f26180o = i18;
                    this.f26179n = i18;
                    return;
                }
                this.f26184s = true;
            }
        } else if (!this.f26184s) {
            if (i11 <= 3) {
                this.f26166a.add(mVar);
                i17 = 0;
            } else {
                i17 = 0;
                if (i11 <= 40) {
                    this.f26167b.add(mVar);
                } else {
                    this.f26168c.add(mVar);
                    this.f26180o++;
                    if (this.f26179n >= 1 || this.f26180o < 3) {
                        if (i20 != 15 || (Math.abs(i20) == 1425 && i21 == 1)) {
                            this.f26181p = 0;
                            if (i11 > 3) {
                                if (this.f26182q) {
                                    t.a("sleep_data", "连续，刚已进行连续删除2小时45分深睡，再来立马删，time=" + i10);
                                    ArrayList<m> arrayList3 = this.f26166a;
                                    arrayList3.remove(arrayList3.size() - 1);
                                    if (i10 > 360 && i10 < 1080) {
                                        t.a("sleep_data", "发生连续深睡时，time > 360，将isGetUpFlag = true，后续数据不在接收" + i10);
                                        this.f26184s = true;
                                    }
                                } else {
                                    this.f26177l++;
                                }
                                z10 = false;
                                this.f26178m = 0;
                            } else {
                                z10 = false;
                                if (i11 <= 40) {
                                    this.f26177l = 0;
                                    this.f26178m = 0;
                                    this.f26182q = false;
                                } else {
                                    if (this.f26183r) {
                                        t.a("sleep_data", "连续，刚已进行连续删除45分钟清醒，再来立马删前一条清醒，而保留最新清醒time=" + i10);
                                        if (this.f26178m >= 1) {
                                            ArrayList<m> arrayList4 = this.f26168c;
                                            arrayList4.remove(arrayList4.size() - 2);
                                        }
                                    } else if (i10 < 420 || i10 >= 1080 || i11 >= 62) {
                                        this.f26178m++;
                                    }
                                    if (this.f26178m >= 2 && ((i10 >= 420 && i10 < 1080) || (i10 > 300 && i10 < 420 && this.f26189x >= 55))) {
                                        ArrayList<m> arrayList5 = this.f26168c;
                                        if (arrayList5.get(arrayList5.size() - 1).d() >= 110) {
                                            ArrayList<m> arrayList6 = this.f26168c;
                                            if (arrayList6.get(arrayList6.size() - 2).d() >= 110) {
                                                this.f26184s = true;
                                                t.a("sleep_data", " 连续两条清醒>=110，已是早上7点，已起床，time=" + i10);
                                                ArrayList<m> arrayList7 = this.f26168c;
                                                arrayList7.remove(arrayList7.size() - 1);
                                                ArrayList<m> arrayList8 = this.f26168c;
                                                arrayList8.remove(arrayList8.size() - 1);
                                                this.f26178m -= 2;
                                            }
                                        }
                                    }
                                    this.f26177l = 0;
                                    this.f26182q = false;
                                    i13 = this.f26177l;
                                    if (i13 >= 6 || i10 < 1080) {
                                        if (i13 >= 11) {
                                            this.f26177l = 0;
                                            this.f26182q = true;
                                            t.a("sleep_data", "连续，连续深睡>=11次，2h45m，time=" + i10);
                                            i14 = 100;
                                        } else {
                                            int i22 = this.f26178m;
                                            if (i22 >= 3) {
                                                if (i10 <= 60 || i10 >= 1080 || i11 > 150) {
                                                    this.f26178m = 0;
                                                    this.f26183r = true;
                                                    t.a("sleep_data", "连续，连续清醒>=3次，45min，time=" + i10);
                                                    i14 = 102;
                                                } else {
                                                    return;
                                                }
                                            } else if (i22 == 2) {
                                                ArrayList<m> arrayList9 = this.f26168c;
                                                if (arrayList9.get(arrayList9.size() - 1).d() >= 110) {
                                                    ArrayList<m> arrayList10 = this.f26168c;
                                                    if (arrayList10.get(arrayList10.size() - 2).d() >= 110 && this.f26166a.size() + this.f26167b.size() <= 9) {
                                                        if ((i10 <= 60 || i10 >= 1080) && this.f26166a.size() == 0) {
                                                            t.a("sleep_data", "连续两次翻身次数>=110，剩余深睡+浅睡<2小时 或者1点后深睡+浅睡<1小时，全部删除，time=" + i10);
                                                            g(mVar);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            } else {
                                                return;
                                            }
                                        }
                                        f(i14, mVar);
                                    }
                                    t.a("sleep_data", "连续，24点前连续深睡>=6次，1h30m，time=" + i10);
                                    this.f26177l = 0;
                                    this.f26182q = true;
                                    g(mVar);
                                    return;
                                }
                            }
                            this.f26183r = z10;
                            i13 = this.f26177l;
                            if (i13 >= 6) {
                            }
                            if (i13 >= 11) {
                            }
                            f(i14, mVar);
                        }
                        t.a("sleep_data", "间断end，***time=" + i10 + ",mDeepSleepArrayInfo.size()+mLightSleepArrayInfo.size() = " + (this.f26166a.size() + this.f26167b.size()) + ",diffTime=" + i20 + ",time=" + i10 + ",lastTime=" + i12);
                        if ((i10 > 360 && i10 < 1080) || (i10 > 300 && i10 <= 360 && this.f26189x >= 55)) {
                            this.f26181p++;
                        }
                        int i23 = this.f26181p;
                        if (i23 < 2 || i20 < 20) {
                            i16 = 3;
                            if (i23 < 3) {
                                if (i11 > 40) {
                                    this.f26179n++;
                                } else {
                                    this.f26179n = 0;
                                }
                                if (!this.f26182q || i11 > 3) {
                                    this.f26182q = false;
                                } else {
                                    t.a("sleep_data", "间断，之前进行连续深睡删除，再来立马删，time=" + i10);
                                    ArrayList<m> arrayList11 = this.f26166a;
                                    arrayList11.remove(arrayList11.size() - 1);
                                }
                                if (!this.f26183r || i11 <= 40) {
                                    this.f26183r = false;
                                } else {
                                    t.a("sleep_data", "间断，之前进行连续清醒删除，再来立马删上一条，保留本次数据，time=" + i10);
                                    ArrayList<m> arrayList12 = this.f26168c;
                                    arrayList12.remove(arrayList12.size() - 2);
                                }
                                if (this.f26166a.size() + this.f26167b.size() <= 9 && (i10 <= 60 || i10 >= 1080)) {
                                    t.a("sleep_data", "间断，剩余深睡+浅睡<2小时 或者1点后深睡+浅睡<1小时，time=" + i10 + ",rollCount=" + i11 + ",mDeepSleepArrayInfo.size()=" + this.f26166a.size() + ",mAwakeSleepArrayInfo.size()=" + this.f26168c.size());
                                    if ((i10 >= 1080 && i10 <= 1320) || (i12 >= 1080 && i12 <= 1320)) {
                                        t.a("sleep_data", "22点前，全部删除");
                                        g(mVar);
                                        return;
                                    } else if (((i10 > 1320 && i10 < 1440) || (i12 > 1320 && i12 < 1440)) && i20 >= 40) {
                                        t.a("sleep_data", "24点前，间断>40分钟, 全部删除");
                                        g(mVar);
                                        return;
                                    } else if (i10 <= 60 && i20 >= 50) {
                                        t.a("sleep_data", "1点前，间断>50分钟, 全部删除");
                                        g(mVar);
                                        return;
                                    } else if (i11 > 3 ? this.f26166a.size() == 0 : this.f26166a.size() == 1) {
                                        if (i10 < 1440) {
                                            t.a("sleep_data", "此前未出现过深睡，且发生在24点前，全部删除");
                                            g(mVar);
                                            return;
                                        }
                                    }
                                } else if (i20 > 25) {
                                    t.a("sleep_data", "间断，diffTime=" + i20 + ",time=" + i10 + ",lastTime=" + i12);
                                    if (i10 <= 60 || i10 >= 1080 || i12 <= 60 || i12 >= 1080) {
                                        t.a("sleep_data", "间断，diffTime > 25，同时18:00~01:00，time=" + i10 + ",rollCount=" + i11 + ",mDeepSleepArrayInfo.size()=" + this.f26166a.size());
                                        if ((i10 >= 1080 && i10 <= 1320) || (i12 >= 1080 && i12 <= 1320)) {
                                            t.a("sleep_data", "22:00前，全部删除");
                                            g(mVar);
                                            return;
                                        } else if (((i10 > 1320 && i10 < 1440) || (i12 > 1320 && i12 < 1440)) && i20 >= 40) {
                                            t.a("sleep_data", "22:00~24:00,diffTime >= 40，全部删除");
                                            g(mVar);
                                            return;
                                        } else if (i10 < 0 || i10 > 60 || i20 < 45) {
                                            int i24 = 3;
                                            int size = this.f26166a.size();
                                            if (i11 > 3 ? size == 0 : size == 1) {
                                                if (i11 <= 3 || i11 > 40 ? this.f26167b.size() != 0 : this.f26167b.size() != 1) {
                                                    i24 = 3;
                                                } else {
                                                    t.a("sleep_data", "中断>10min，此前全身清醒，全部删除");
                                                    g(mVar);
                                                    return;
                                                }
                                            }
                                            if (i11 > i24 ? this.f26166a.size() == 0 : this.f26166a.size() == 1) {
                                                t.a("sleep_data", "此前未出现过深睡，全部删除");
                                                g(mVar);
                                                return;
                                            }
                                        } else {
                                            t.a("sleep_data", "00:00~1:00,diffTime >= 45，全部删除");
                                            g(mVar);
                                            return;
                                        }
                                    } else if (((i10 > 360 && i10 < 1080) || (i10 > 300 && i10 <= 360 && this.f26189x >= 55)) && i20 >= 45 && i11 > 40) {
                                        t.a("sleep_data", "间断，大于6点，而且diffTime >= 45，直接清认为起床,并删除刚才插入的数据time=" + i10 + ",同时isGetUpFlag = true;后面同一天的数据将不再接收");
                                        this.f26184s = true;
                                        ArrayList<m> arrayList13 = i11 <= 3 ? this.f26166a : i11 <= 40 ? this.f26167b : this.f26168c;
                                        arrayList13.remove(arrayList13.size() - 1);
                                    }
                                }
                                i15 = 0;
                                this.f26177l = i15;
                                this.f26178m = i15;
                                return;
                            }
                        } else {
                            i16 = 3;
                        }
                        t.a("sleep_data", "早上连续间断>=2次，isGetUpFlag = true，time=" + i10);
                        this.f26184s = true;
                        if (i11 <= i16) {
                            ArrayList<m> arrayList14 = this.f26166a;
                            arrayList14.remove(arrayList14.size() - 1);
                            if (this.f26181p >= i16) {
                                arrayList = this.f26166a;
                                arrayList.remove(arrayList.size() - 1);
                            }
                            i15 = 0;
                            this.f26181p = 0;
                        } else if (i11 > 40) {
                            ArrayList<m> arrayList15 = this.f26168c;
                            arrayList15.remove(arrayList15.size() - 1);
                            if (this.f26181p >= 3) {
                                arrayList = this.f26168c;
                                arrayList.remove(arrayList.size() - 1);
                            }
                            i15 = 0;
                            this.f26181p = 0;
                        } else {
                            ArrayList<m> arrayList16 = this.f26167b;
                            arrayList16.remove(arrayList16.size() - 1);
                            if (this.f26181p >= 3) {
                                arrayList = this.f26167b;
                                arrayList.remove(arrayList.size() - 1);
                            }
                            i15 = 0;
                            this.f26181p = 0;
                        }
                        this.f26177l = i15;
                        this.f26178m = i15;
                        return;
                    } else if ((i10 <= 60 || i10 >= 1080) && this.f26166a.size() + this.f26167b.size() < 8) {
                        t.a("sleep_data", "清醒+中断，18:00~01:00，全部删除，time=" + i10);
                        g(mVar);
                        return;
                    } else if ((i10 < 420 || i10 >= 1080) && (i10 <= 300 || i10 >= 420 || this.f26189x < 55)) {
                        ArrayList<m> arrayList17 = this.f26168c;
                        if (arrayList17.get(arrayList17.size() - 1).d() >= 150) {
                            ArrayList<m> arrayList18 = this.f26168c;
                            if (arrayList18.get(arrayList18.size() - 2).d() >= 150) {
                                ArrayList<m> arrayList19 = this.f26168c;
                                if (arrayList19.get(arrayList19.size() - 3).d() >= 150 && (this.f26166a.size() + this.f26167b.size() < 8 || i10 <= 60 || i10 >= 1080)) {
                                    t.a("sleep_data", "连续三条清醒>=150，全删，time=" + i10);
                                    g(mVar);
                                    return;
                                }
                            }
                        }
                        t.a("sleep_data", "清醒+中断，删除后面两条插入的清醒，保留后一条数据，time=" + i10);
                        if (this.f26168c.size() - 2 >= 0) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("清醒+中断，删除后面两条插入的清醒，保留后一条数据time1=");
                            ArrayList<m> arrayList20 = this.f26168c;
                            sb2.append(arrayList20.get(arrayList20.size() - 2).b());
                            t.a("sleep_data", sb2.toString());
                            ArrayList<m> arrayList21 = this.f26168c;
                            arrayList21.remove(arrayList21.size() - 2);
                            if (this.f26168c.size() - 2 >= 0) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("清醒+中断，删除后面两条插入的清醒，保留后一条数据time2=");
                                ArrayList<m> arrayList22 = this.f26168c;
                                sb3.append(arrayList22.get(arrayList22.size() - 2).b());
                                t.a("sleep_data", sb3.toString());
                                ArrayList<m> arrayList23 = this.f26168c;
                                arrayList23.remove(arrayList23.size() - 2);
                            }
                        }
                        this.f26183r = true;
                        this.f26177l = 0;
                        this.f26182q = false;
                        this.f26179n = 0;
                        this.f26180o = 0;
                        return;
                    } else {
                        this.f26184s = true;
                        t.a("sleep_data", "清醒+中断，已是早上7点，已起床，time=" + i10);
                        ArrayList<m> arrayList24 = this.f26168c;
                        arrayList24.remove(arrayList24.size() - 1);
                        ArrayList<m> arrayList25 = this.f26168c;
                        arrayList25.remove(arrayList25.size() - 1);
                        return;
                    }
                }
            }
            this.f26180o = i17;
            this.f26179n = i17;
            if (this.f26179n >= 1) {
            }
            if (i20 != 15) {
            }
            this.f26181p = 0;
            if (i11 > 3) {
            }
            this.f26183r = z10;
            i13 = this.f26177l;
            if (i13 >= 6) {
            }
            if (i13 >= 11) {
            }
            f(i14, mVar);
        }
    }

    public ArrayList<g> o() {
        return i();
    }

    public String q(String str, int i10) {
        Date date;
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd HH:mm", locale);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(LeisenIfaceConfig.CARD_DATE_FORMAT, locale);
        try {
            date = simpleDateFormat.parse(str);
        } catch (Exception e10) {
            e10.printStackTrace();
            date = null;
        }
        if (date == null) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(12, i10);
        return simpleDateFormat2.format(calendar.getTime());
    }

    public void r() {
        String str;
        this.f26184s = false;
        if (this.f26166a.size() + this.f26167b.size() < 8) {
            str = "新一天准备保存数据时，发现剩余深睡+浅睡<2小时，全部删除";
        } else if (this.f26167b.size() == 0 && this.f26168c.size() == 0) {
            str = "新一天准备保存数据时，发现剩余全是深睡，全部删除";
        } else if (l() < 210) {
            str = "新一天准备保存数据时，发现没有睡眠超过3点半，全部删除";
        } else {
            g gVar = new g(this.f26166a, this.f26167b, this.f26168c);
            t.a("sleep_data", "saveTheLastSleepData, mDeepSleepArrayInfo.size()=" + this.f26166a.size() + ";mLightSleepArrayInfo.size()=" + this.f26167b.size() + ";mAwakeSleepArrayInfo.size()=" + this.f26168c.size());
            t.a("sleep_data", "添加当天睡眠数据到大数组前 ");
            this.f26169d.add(gVar);
            ArrayList<m> arrayList = this.f26166a;
            if (!(arrayList == null || arrayList.size() == 0)) {
                str = "添加当天睡眠数据到大数组 后" + this.f26166a.get(0).a();
            }
            d();
        }
        t.a("sleep_data", str);
        d();
    }
}
