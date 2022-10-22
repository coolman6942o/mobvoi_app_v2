package com.mobvoi.android.common.ui.view.datetimepicker;

import android.content.Context;
import android.support.wearable.view.WearableListView;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.android.common.ui.view.datetimepicker.a;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
/* loaded from: classes2.dex */
public class DatePicker extends com.mobvoi.android.common.ui.view.datetimepicker.a {
    private int A;
    private int B;
    private int C;
    private int D;
    private final Calendar E;

    /* renamed from: m  reason: collision with root package name */
    private f f15284m;

    /* renamed from: n  reason: collision with root package name */
    private WearableListView f15285n;

    /* renamed from: o  reason: collision with root package name */
    private WearableListView f15286o;

    /* renamed from: p  reason: collision with root package name */
    private WearableListView f15287p;

    /* renamed from: q  reason: collision with root package name */
    private g f15288q;

    /* renamed from: r  reason: collision with root package name */
    private j f15289r;

    /* renamed from: s  reason: collision with root package name */
    private l f15290s;

    /* renamed from: t  reason: collision with root package name */
    private int f15291t;

    /* renamed from: u  reason: collision with root package name */
    private View f15292u;

    /* renamed from: v  reason: collision with root package name */
    private int f15293v;

    /* renamed from: w  reason: collision with root package name */
    private int f15294w;

    /* renamed from: x  reason: collision with root package name */
    private int f15295x;

    /* renamed from: y  reason: collision with root package name */
    private int f15296y;

    /* renamed from: z  reason: collision with root package name */
    private int f15297z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends View.AccessibilityDelegate {
        a() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(DatePicker.this.f15288q.f15303c, 1, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends View.AccessibilityDelegate {
        b() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(DatePicker.this.f15289r.f15306a, 1, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c implements WearableListView.ClickListener {
        private c(DatePicker datePicker) {
        }

        /* synthetic */ c(DatePicker datePicker, a aVar) {
            this(datePicker);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d implements WearableListView.ClickListener {
        private d(DatePicker datePicker) {
        }

        /* synthetic */ d(DatePicker datePicker, a aVar) {
            this(datePicker);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e implements WearableListView.ClickListener {
        private e(DatePicker datePicker) {
        }

        /* synthetic */ e(DatePicker datePicker, a aVar) {
            this(datePicker);
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a(int i10, int i11, int i12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class g extends WearableListView.Adapter {

        /* renamed from: d  reason: collision with root package name */
        private static final String[] f15300d = new String[31];

        /* renamed from: b  reason: collision with root package name */
        private int f15302b = 1;

        /* renamed from: a  reason: collision with root package name */
        private int f15301a = 31;

        /* renamed from: c  reason: collision with root package name */
        private int f15303c = (31 - 1) + 1;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd", Locale.getDefault());
            Calendar calendar = Calendar.getInstance();
            calendar.set(1970, 0, 1, 0, 0, 0);
            int i10 = 0;
            while (true) {
                String[] strArr = f15300d;
                if (i10 < strArr.length) {
                    int i11 = i10 + 1;
                    calendar.set(5, i11);
                    strArr[i10] = simpleDateFormat.format(calendar.getTime());
                    i10 = i11;
                } else {
                    return;
                }
            }
        }

        protected g(Context context) {
            LayoutInflater.from(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int g(int i10) {
            return Math.min(Math.max(i10, this.f15302b), this.f15301a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int h(int i10) {
            return (i10 % this.f15303c) + this.f15302b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int i(int i10) {
            int j10 = j() / 2;
            return ((j10 - (j10 % this.f15303c)) + i10) - this.f15302b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(int i10) {
            n(this.f15302b, i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l(int i10) {
            n(i10, this.f15301a);
        }

        private void m() {
            this.f15303c = (this.f15301a - this.f15302b) + 1;
            notifyDataSetChanged();
        }

        private void n(int i10, int i11) {
            this.f15302b = i10;
            this.f15301a = i11;
            m();
        }

        public int j() {
            return Integer.MAX_VALUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class h implements WearableListView.OnCentralPositionChangedListener {
        private h(DatePicker datePicker) {
        }

        /* synthetic */ h(DatePicker datePicker, a aVar) {
            this(datePicker);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class i implements View.OnClickListener {
        private i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DatePicker.this.f15292u.setClickable(false);
            int i10 = DatePicker.this.f15289r.i(DatePicker.this.f15293v);
            int h10 = DatePicker.this.f15288q.h(DatePicker.this.f15294w);
            int g10 = DatePicker.this.f15290s.g(DatePicker.this.f15295x);
            if (DatePicker.this.f15284m != null) {
                DatePicker.this.f15284m.a(g10, i10, h10);
            }
        }

        /* synthetic */ i(DatePicker datePicker, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class j extends WearableListView.Adapter {

        /* renamed from: d  reason: collision with root package name */
        private static final String[] f15305d = new DateFormatSymbols(Locale.getDefault()).getShortMonths();

        /* renamed from: a  reason: collision with root package name */
        private int f15306a;

        /* renamed from: b  reason: collision with root package name */
        private int f15307b = 0;

        /* renamed from: c  reason: collision with root package name */
        private int f15308c;

        static {
            int i10 = 0;
            while (true) {
                String[] strArr = f15305d;
                if (i10 < strArr.length) {
                    strArr[i10] = strArr[i10].toUpperCase(Locale.getDefault());
                    i10++;
                } else {
                    return;
                }
            }
        }

        protected j(Context context) {
            LayoutInflater.from(context);
            int length = f15305d.length - 1;
            this.f15308c = length;
            this.f15306a = (length - 0) + 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int g(int i10) {
            return Math.min(Math.max(i10, this.f15307b), this.f15308c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int i(int i10) {
            return (i10 % this.f15306a) + this.f15307b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int j(int i10) {
            int h10 = h() / 2;
            return ((h10 - (h10 % this.f15306a)) + i10) - this.f15307b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(int i10) {
            n(this.f15307b, i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l(int i10) {
            n(i10, this.f15308c);
        }

        private void m() {
            this.f15306a = (this.f15308c - this.f15307b) + 1;
            notifyDataSetChanged();
        }

        private void n(int i10, int i11) {
            this.f15307b = i10;
            this.f15308c = i11;
            m();
        }

        public int h() {
            return Integer.MAX_VALUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class k implements WearableListView.OnCentralPositionChangedListener {
        private k(DatePicker datePicker) {
        }

        /* synthetic */ k(DatePicker datePicker, a aVar) {
            this(datePicker);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class l extends WearableListView.Adapter {

        /* renamed from: a  reason: collision with root package name */
        private int f15309a;

        /* renamed from: b  reason: collision with root package name */
        private int f15310b;

        /* renamed from: c  reason: collision with root package name */
        private final Calendar f15311c;

        static {
            new SimpleDateFormat("yyyy", Locale.getDefault());
        }

        protected l(Context context) {
            LayoutInflater.from(context);
            int i10 = Calendar.getInstance().get(1);
            k(i10 - 100, i10);
            Calendar calendar = Calendar.getInstance();
            this.f15311c = calendar;
            calendar.set(1970, 0, 1, 0, 0, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int f(int i10) {
            return DatePicker.w(i10, this.f15309a, this.f15310b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int g(int i10) {
            return i10 + this.f15309a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int h(int i10) {
            return i10 - this.f15309a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(int i10) {
            k(this.f15309a, i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(int i10) {
            k(i10, this.f15310b);
        }

        private void k(int i10, int i11) {
            this.f15309a = i10;
            this.f15310b = i11;
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class m implements WearableListView.OnCentralPositionChangedListener {
        private m(DatePicker datePicker) {
        }

        /* synthetic */ m(DatePicker datePicker, a aVar) {
            this(datePicker);
        }
    }

    public DatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void A(int i10) {
        int f10 = this.f15290s.f(i10);
        if (this.f15295x != this.f15290s.h(f10)) {
            int h10 = this.f15290s.h(f10);
            this.f15295x = h10;
            this.f15287p.scrollToPosition(h10);
        }
        int i11 = this.f15289r.i(this.f15293v);
        if (f10 == this.f15296y) {
            this.f15289r.l(this.f15297z);
        } else {
            this.f15289r.l(0);
        }
        if (f10 == this.B) {
            this.f15289r.k(this.C);
        } else {
            this.f15289r.k(11);
        }
        z(i11);
    }

    private void B(int i10, int i11, int i12, boolean z10) {
        this.B = i10;
        this.C = i11;
        this.D = i12;
        int year = getYear();
        int month = getMonth();
        int dayOfMonth = getDayOfMonth();
        this.f15290s.i(i10);
        if (z10) {
            E(year, month, dayOfMonth);
        }
    }

    private void C(int i10, int i11, int i12, boolean z10) {
        this.f15296y = i10;
        this.f15297z = i11;
        this.A = i12;
        int year = getYear();
        int month = getMonth();
        int dayOfMonth = getDayOfMonth();
        this.f15290s.j(i10);
        if (z10) {
            E(year, month, dayOfMonth);
        }
    }

    private void D(char[] cArr, int i10, WearableListView wearableListView) {
        char c10 = cArr[i10];
        if (c10 == 'M') {
            setupMonthPicker(wearableListView);
            this.f15291t = i10;
        } else if (c10 == 'd') {
            setupDayPicker(wearableListView);
        } else if (c10 == 'y') {
            setupYearPicker(wearableListView);
        }
    }

    private int getNumDaysInCurrentMonth() {
        this.E.set(this.f15290s.g(this.f15295x), this.f15289r.i(this.f15293v), 1);
        return this.E.getActualMaximum(5);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.recyclerview.widget.RecyclerView$Adapter, com.mobvoi.android.common.ui.view.datetimepicker.DatePicker$g] */
    private void setupDayPicker(WearableListView wearableListView) {
        this.f15285n = wearableListView;
        ?? gVar = new g(getContext());
        this.f15288q = gVar;
        this.f15285n.setAdapter((RecyclerView.Adapter) gVar);
        this.f15285n.setGreedyTouchMode(true);
        this.f15285n.addOnCentralPositionChangedListener(new h(this, null));
        this.f15285n.setClickListener(new c(this, null));
        this.f15285n.setAccessibilityDelegate(new a());
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.mobvoi.android.common.ui.view.datetimepicker.DatePicker$j, androidx.recyclerview.widget.RecyclerView$Adapter] */
    private void setupMonthPicker(WearableListView wearableListView) {
        this.f15286o = wearableListView;
        ?? jVar = new j(getContext());
        this.f15289r = jVar;
        this.f15286o.setAdapter((RecyclerView.Adapter) jVar);
        this.f15286o.setGreedyTouchMode(true);
        this.f15286o.addOnCentralPositionChangedListener(new k(this, null));
        this.f15286o.setClickListener(new d(this, null));
        this.f15286o.setAccessibilityDelegate(new b());
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.mobvoi.android.common.ui.view.datetimepicker.DatePicker$l, androidx.recyclerview.widget.RecyclerView$Adapter] */
    private void setupYearPicker(WearableListView wearableListView) {
        this.f15287p = wearableListView;
        ?? lVar = new l(getContext());
        this.f15290s = lVar;
        this.f15287p.setAdapter((RecyclerView.Adapter) lVar);
        this.f15287p.setGreedyTouchMode(true);
        this.f15287p.addOnCentralPositionChangedListener(new m(this, null));
        this.f15287p.setClickListener(new e(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int w(int i10, int i11, int i12) {
        return Math.min(Math.max(i10, i11), i12);
    }

    private void x() {
        char[] dateFormatOrder = DateFormat.getDateFormatOrder(getContext());
        D(dateFormatOrder, 0, (WearableListView) findViewById(y9.f.f36816e));
        D(dateFormatOrder, 1, (WearableListView) findViewById(y9.f.f36821j));
        D(dateFormatOrder, 2, (WearableListView) findViewById(y9.f.f36823l));
        View findViewById = findViewById(y9.f.f36814c);
        this.f15292u = findViewById;
        findViewById.setOnClickListener(new i(this, null));
        Calendar calendar = Calendar.getInstance();
        int i10 = calendar.get(1);
        int i11 = calendar.get(2);
        int i12 = calendar.get(5);
        C(2000, 0, 1, false);
        B(2099, 11, 31, false);
        E(i10, i11, i12);
        m(0, false);
        this.f15284m = null;
    }

    private void y(int i10) {
        int g10 = this.f15288q.g(i10);
        if (g10 != this.f15288q.h(this.f15294w)) {
            int i11 = this.f15288q.i(g10);
            this.f15294w = i11;
            this.f15285n.scrollToPosition(i11);
        }
    }

    private void z(int i10) {
        int g10 = this.f15289r.g(i10);
        if (g10 != this.f15289r.i(this.f15293v)) {
            this.f15293v = this.f15289r.j(g10);
            this.f15286o.scrollToPosition(this.f15289r.j(g10));
        }
        int g11 = this.f15290s.g(this.f15295x);
        int h10 = this.f15288q.h(this.f15294w);
        if (g11 == this.f15296y && g10 == this.f15297z) {
            this.f15288q.l(this.A);
        } else {
            this.f15288q.l(1);
        }
        this.E.set(g11, i10, 1);
        if (g11 == this.B && g10 == this.C) {
            this.f15288q.k(Math.min(this.D, getNumDaysInCurrentMonth()));
        } else {
            this.f15288q.k(getNumDaysInCurrentMonth());
        }
        y(h10);
    }

    public void E(int i10, int i11, int i12) {
        A(i10);
        z(i11);
        y(i12);
    }

    public int getDayOfMonth() {
        return this.f15288q.h(this.f15294w);
    }

    public int getMonth() {
        return this.f15289r.i(this.f15293v);
    }

    public int getYear() {
        return this.f15290s.g(this.f15295x);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.android.common.ui.view.datetimepicker.a
    public float i(int i10, boolean z10) {
        if (i10 == this.f15291t) {
            return z10 ? 1.0f : 0.85f;
        }
        return super.i(i10, z10);
    }

    public void setCallback(f fVar) {
        this.f15284m = fVar;
    }

    @Override // com.mobvoi.android.common.ui.view.datetimepicker.a
    public /* bridge */ /* synthetic */ void setListener(a.c cVar) {
        super.setListener(cVar);
    }

    public void setMaxDay(int i10) {
        B(this.B, this.C, i10, true);
    }

    public void setMaxMonth(int i10) {
        B(this.B, i10, this.D, true);
    }

    public void setMaxYear(int i10) {
        B(i10, this.C, this.D, true);
    }

    public void setMinDay(int i10) {
        C(this.f15296y, this.f15297z, i10, true);
    }

    public void setMinMonth(int i10) {
        C(this.f15296y, i10, this.A, true);
    }

    public void setMinYear(int i10) {
        C(i10, this.f15297z, this.A, true);
    }

    public DatePicker(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.E = new GregorianCalendar();
        FrameLayout.inflate(getContext(), y9.h.f36830a, this);
        x();
    }
}
