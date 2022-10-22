package com.mobvoi.android.common.ui.view.datetimepicker;

import android.content.Context;
import android.support.wearable.view.WearableListView;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.android.common.ui.view.datetimepicker.a;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
/* loaded from: classes2.dex */
public class TimePicker extends com.mobvoi.android.common.ui.view.datetimepicker.a {

    /* renamed from: m  reason: collision with root package name */
    private m f15312m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f15313n;

    /* renamed from: o  reason: collision with root package name */
    private WearableListView f15314o;

    /* renamed from: p  reason: collision with root package name */
    private ViewGroup f15315p;

    /* renamed from: q  reason: collision with root package name */
    private WearableListView f15316q;

    /* renamed from: r  reason: collision with root package name */
    private WearableListView f15317r;

    /* renamed from: s  reason: collision with root package name */
    private i f15318s;

    /* renamed from: t  reason: collision with root package name */
    private k f15319t;

    /* renamed from: u  reason: collision with root package name */
    private f f15320u;

    /* renamed from: v  reason: collision with root package name */
    private View f15321v;

    /* renamed from: w  reason: collision with root package name */
    private int f15322w;

    /* renamed from: x  reason: collision with root package name */
    private int f15323x;

    /* renamed from: y  reason: collision with root package name */
    private int f15324y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends View.AccessibilityDelegate {
        a() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(TimePicker.this.f15318s.f15330b, 1, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends View.AccessibilityDelegate {
        b(TimePicker timePicker) {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(60, 1, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c implements WearableListView.ClickListener {
        private c(TimePicker timePicker) {
        }

        /* synthetic */ c(TimePicker timePicker, a aVar) {
            this(timePicker);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d implements WearableListView.ClickListener {
        private d(TimePicker timePicker) {
        }

        /* synthetic */ d(TimePicker timePicker, a aVar) {
            this(timePicker);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e implements WearableListView.ClickListener {
        private e(TimePicker timePicker) {
        }

        /* synthetic */ e(TimePicker timePicker, a aVar) {
            this(timePicker);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class f extends WearableListView.Adapter {

        /* renamed from: a  reason: collision with root package name */
        private static final String[] f15326a = new DateFormatSymbols(Locale.getDefault()).getAmPmStrings();

        static {
            Locale locale = Locale.getDefault();
            int i10 = 0;
            while (true) {
                String[] strArr = f15326a;
                if (i10 < strArr.length) {
                    strArr[i10] = strArr[i10].toLowerCase(locale);
                    i10++;
                } else {
                    return;
                }
            }
        }

        protected f(Context context) {
            LayoutInflater.from(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int c(int i10) {
            return i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int d(int i10) {
            return i10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class g implements WearableListView.OnCentralPositionChangedListener {
        private g(TimePicker timePicker) {
        }

        /* synthetic */ g(TimePicker timePicker, a aVar) {
            this(timePicker);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {
        private h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TimePicker.this.f15321v.setClickable(false);
            int currentHour = TimePicker.this.getCurrentHour();
            int currentMinute = TimePicker.this.getCurrentMinute();
            if (TimePicker.this.f15312m != null) {
                TimePicker.this.f15312m.a(currentHour, currentMinute);
            }
        }

        /* synthetic */ h(TimePicker timePicker, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class i extends WearableListView.Adapter {

        /* renamed from: d  reason: collision with root package name */
        private static final String[] f15328d = new String[24];

        /* renamed from: a  reason: collision with root package name */
        private boolean f15329a;

        /* renamed from: b  reason: collision with root package name */
        private int f15330b;

        /* renamed from: c  reason: collision with root package name */
        private int f15331c;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH", Locale.getDefault());
            Calendar calendar = Calendar.getInstance();
            calendar.set(1970, 0, 1, 0, 0, 0);
            int i10 = 0;
            while (true) {
                String[] strArr = f15328d;
                if (i10 < strArr.length) {
                    calendar.set(11, i10);
                    strArr[i10] = simpleDateFormat.format(calendar.getTime());
                    i10++;
                } else {
                    return;
                }
            }
        }

        protected i(Context context) {
            LayoutInflater.from(context);
            boolean is24HourFormat = DateFormat.is24HourFormat(context);
            this.f15329a = is24HourFormat;
            if (is24HourFormat) {
                this.f15330b = 24;
                this.f15331c = 0;
                return;
            }
            this.f15330b = 12;
            this.f15331c = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int d(int i10) {
            int i11 = this.f15330b;
            return ((i10 % i11) + this.f15331c) % i11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int e(int i10) {
            int f10 = f() / 2;
            return (f10 - ((f10 % this.f15330b) + this.f15331c)) + i10;
        }

        public int f() {
            return Integer.MAX_VALUE;
        }

        void g(boolean z10) {
            this.f15329a = z10;
            if (z10) {
                this.f15330b = 24;
                this.f15331c = 0;
                return;
            }
            this.f15330b = 12;
            this.f15331c = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class j implements WearableListView.OnCentralPositionChangedListener {
        private j(TimePicker timePicker) {
        }

        /* synthetic */ j(TimePicker timePicker, a aVar) {
            this(timePicker);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class k extends WearableListView.Adapter {

        /* renamed from: a  reason: collision with root package name */
        private static final String[] f15332a = new String[60];

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm", Locale.getDefault());
            Calendar calendar = Calendar.getInstance();
            calendar.set(1970, 0, 1, 0, 0, 0);
            int i10 = 0;
            while (true) {
                String[] strArr = f15332a;
                if (i10 < strArr.length) {
                    calendar.set(12, i10);
                    strArr[i10] = simpleDateFormat.format(calendar.getTime());
                    i10++;
                } else {
                    return;
                }
            }
        }

        protected k(Context context) {
            LayoutInflater.from(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int d(int i10) {
            return i10 % f15332a.length;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int e(int i10) {
            int c10 = c() / 2;
            String[] strArr = f15332a;
            return (c10 - (c10 % strArr.length)) + (i10 % strArr.length);
        }

        public int c() {
            return Integer.MAX_VALUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class l implements WearableListView.OnCentralPositionChangedListener {
        private l(TimePicker timePicker) {
        }

        /* synthetic */ l(TimePicker timePicker, a aVar) {
            this(timePicker);
        }
    }

    /* loaded from: classes2.dex */
    public interface m {
        void a(int i10, int i11);
    }

    public TimePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [androidx.recyclerview.widget.RecyclerView$Adapter, com.mobvoi.android.common.ui.view.datetimepicker.TimePicker$k] */
    /* JADX WARN: Type inference failed for: r0v22, types: [com.mobvoi.android.common.ui.view.datetimepicker.TimePicker$f, androidx.recyclerview.widget.RecyclerView$Adapter] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.mobvoi.android.common.ui.view.datetimepicker.TimePicker$i, androidx.recyclerview.widget.RecyclerView$Adapter] */
    private void q() {
        this.f15314o = findViewById(y9.f.f36817f);
        ?? iVar = new i(getContext());
        this.f15318s = iVar;
        this.f15314o.setAdapter((RecyclerView.Adapter) iVar);
        this.f15314o.setGreedyTouchMode(true);
        this.f15314o.addOnCentralPositionChangedListener(new j(this, null));
        this.f15314o.setClickListener(new d(this, null));
        this.f15314o.setAccessibilityDelegate(new a());
        this.f15315p = (ViewGroup) findViewById(y9.f.f36818g);
        this.f15316q = findViewById(y9.f.f36819h);
        ?? kVar = new k(getContext());
        this.f15319t = kVar;
        this.f15316q.setAdapter((RecyclerView.Adapter) kVar);
        this.f15316q.setGreedyTouchMode(true);
        this.f15316q.addOnCentralPositionChangedListener(new l(this, null));
        this.f15316q.setClickListener(new e(this, null));
        this.f15316q.setAccessibilityDelegate(new b(this));
        this.f15317r = findViewById(y9.f.f36821j);
        ?? fVar = new f(getContext());
        this.f15320u = fVar;
        this.f15317r.setAdapter((RecyclerView.Adapter) fVar);
        this.f15317r.setGreedyTouchMode(true);
        this.f15317r.addOnCentralPositionChangedListener(new g(this, null));
        this.f15317r.setClickListener(new c(this, null));
        setIs24HourView(DateFormat.is24HourFormat(getContext()));
        View findViewById = findViewById(y9.f.f36814c);
        this.f15321v = findViewById;
        findViewById.setOnClickListener(new h(this, null));
        findViewById(y9.f.f36820i);
        Calendar calendar = Calendar.getInstance();
        s(calendar.get(11), calendar.get(12));
        r(0, false);
    }

    public int getCurrentHour() {
        int d10 = this.f15318s.d(this.f15322w);
        if (this.f15313n) {
            return d10;
        }
        return d10 + (this.f15320u.c(this.f15324y) == 0 ? 0 : 12);
    }

    public int getCurrentMinute() {
        return this.f15319t.d(this.f15323x);
    }

    public void r(int i10, boolean z10) {
        m(i10, z10);
    }

    public void s(int i10, int i11) {
        int i12 = i10 < 12 ? 0 : 1;
        if (this.f15313n) {
            this.f15322w = this.f15318s.e(i10);
            this.f15323x = this.f15319t.e(i11);
            this.f15314o.scrollToPosition(this.f15322w);
            this.f15316q.scrollToPosition(this.f15323x);
            return;
        }
        this.f15322w = this.f15318s.e(i10 - 12);
        this.f15323x = this.f15319t.e(i11);
        this.f15324y = this.f15320u.d(i12);
        this.f15314o.scrollToPosition(this.f15322w);
        this.f15316q.scrollToPosition(this.f15323x);
        this.f15317r.scrollToPosition(this.f15324y);
    }

    public void setCallback(m mVar) {
        this.f15312m = mVar;
    }

    public void setCurrentHour(int i10) {
        s(i10, getCurrentMinute());
    }

    public void setCurrentMinute(int i10) {
        s(getCurrentHour(), i10);
    }

    public void setIs24HourView(boolean z10) {
        if (this.f15313n != z10) {
            int currentHour = getCurrentHour();
            int currentMinute = getCurrentMinute();
            this.f15313n = z10;
            if (z10) {
                removeView(this.f15317r);
            } else {
                addView((View) this.f15317r, indexOfChild(this.f15315p) + 1);
            }
            this.f15318s.g(this.f15313n);
            s(currentHour, currentMinute);
        }
    }

    @Override // com.mobvoi.android.common.ui.view.datetimepicker.a
    public /* bridge */ /* synthetic */ void setListener(a.c cVar) {
        super.setListener(cVar);
    }

    public void setPickerBackgroundColor(int i10) {
        setBackgroundColor(i10);
    }

    public TimePicker(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        FrameLayout.inflate(getContext(), y9.h.f36833d, this);
        q();
    }
}
