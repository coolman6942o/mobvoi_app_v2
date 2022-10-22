package jj;

import android.app.Application;
import android.text.TextUtils;
import com.google.gson.e;
import com.mobvoi.mcuwatch.bean.AlarmBean;
import com.mobvoi.mcuwatch.engine.f;
import com.mobvoi.mcuwatch.engine.n;
import com.mobvoi.mcuwatch.engine.u;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import sh.k;
/* compiled from: AlarmDataManager.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: e  reason: collision with root package name */
    private static b f29633e = new b();

    /* renamed from: a  reason: collision with root package name */
    private final List<AlarmBean> f29634a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    boolean f29635b = false;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f29636c = {1, 2, 4, 8, 16, 32, 64};

    /* renamed from: d  reason: collision with root package name */
    private Comparator<AlarmBean> f29637d = new Comparator() { // from class: jj.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int j10;
            j10 = b.this.j((AlarmBean) obj, (AlarmBean) obj2);
            return j10;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlarmDataManager.java */
    /* loaded from: classes2.dex */
    public class a extends com.google.gson.reflect.a<List<AlarmBean>> {
        a(b bVar) {
        }
    }

    private b() {
    }

    private int d(long j10, long j11) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j11);
        calendar2.set(calendar.get(1), calendar.get(2), calendar.get(5));
        return calendar.compareTo(calendar2);
    }

    public static b g() {
        return f29633e;
    }

    private int h() {
        int size = this.f29634a.size();
        if (size == 0) {
            return 1;
        }
        if (size != 1) {
            return size != 2 ? 0 : 3;
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int j(AlarmBean alarmBean, AlarmBean alarmBean2) {
        return d(alarmBean.alarmTime, alarmBean2.alarmTime);
    }

    public AlarmBean b(AlarmBean alarmBean) {
        if (this.f29634a.contains(alarmBean)) {
            int indexOf = this.f29634a.indexOf(alarmBean);
            if (indexOf > -1) {
                this.f29634a.remove(indexOf);
                this.f29634a.add(indexOf, alarmBean);
            }
        } else {
            alarmBean.whichClock = h();
            alarmBean.isOpen = true;
            this.f29634a.add(alarmBean);
        }
        Collections.sort(this.f29634a, this.f29637d);
        o(alarmBean);
        l();
        return alarmBean;
    }

    public void c() {
        this.f29634a.clear();
    }

    public int e(AlarmBean alarmBean) {
        int indexOf = this.f29634a.indexOf(alarmBean);
        this.f29634a.remove(alarmBean);
        return indexOf;
    }

    public List<AlarmBean> f() {
        return this.f29634a;
    }

    public void i(AlarmBean alarmBean, boolean z10) {
        for (AlarmBean alarmBean2 : this.f29634a) {
            if (alarmBean.whichClock == alarmBean2.whichClock) {
                if (z10) {
                    alarmBean2.isOpen = alarmBean.isOpen;
                } else {
                    alarmBean2.isOpen = !alarmBean.isOpen;
                }
            }
        }
        l();
    }

    public List<AlarmBean> k() {
        String c10 = n.f19178a.c();
        if (TextUtils.isEmpty(c10)) {
            return null;
        }
        this.f29634a.clear();
        this.f29634a.addAll(n((List) new e().k(c10, new a(this).getType())));
        Collections.sort(this.f29634a, this.f29637d);
        if (this.f29635b) {
            l();
        }
        return this.f29634a;
    }

    public void l() {
        n.f19178a.M(new e().s(this.f29634a));
    }

    public void m(AlarmBean alarmBean) {
        int i10 = 0;
        byte b10 = 0;
        while (true) {
            boolean[] zArr = alarmBean.weekChecked;
            if (i10 < zArr.length) {
                if (zArr[i10]) {
                    b10 = (byte) (b10 | this.f29636c[i10]);
                }
                i10++;
            } else {
                f.y(u.f19202a, alarmBean, b10);
                return;
            }
        }
    }

    public List<AlarmBean> n(List<AlarmBean> list) {
        ArrayList arrayList = new ArrayList();
        Calendar calendar = Calendar.getInstance();
        this.f29635b = false;
        if (list != null) {
            for (AlarmBean alarmBean : list) {
                int i10 = alarmBean.hour;
                int i11 = alarmBean.minute;
                calendar.setTime(new Date(alarmBean.alarmTime));
                int i12 = calendar.get(11);
                int i13 = calendar.get(12);
                if (i12 != i10 || i13 != i11) {
                    alarmBean.hour = i12;
                    alarmBean.minute = i13;
                    this.f29635b = true;
                }
                arrayList.add(alarmBean);
            }
        }
        return arrayList;
    }

    public void o(AlarmBean alarmBean) {
        Application e10 = com.mobvoi.android.common.utils.b.e();
        String[] stringArray = e10.getResources().getStringArray(sh.b.e_res_0x7f03000d);
        String string = e10.getString(k.b_res_0x7f140054);
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            boolean[] zArr = alarmBean.weekChecked;
            if (i10 < zArr.length) {
                if (zArr[i10]) {
                    if (i11 > 0) {
                        sb2.append(string);
                    }
                    i11++;
                    sb2.append(stringArray[i10]);
                }
                i10++;
            } else {
                alarmBean.description = sb2.toString();
                return;
            }
        }
    }
}
