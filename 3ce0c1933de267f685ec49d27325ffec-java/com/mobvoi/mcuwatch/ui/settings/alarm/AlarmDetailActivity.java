package com.mobvoi.mcuwatch.ui.settings.alarm;

import android.app.TimePickerDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.mcuwatch.bean.AlarmBean;
import com.mobvoi.mcuwatch.ui.settings.alarm.AlarmDetailActivity;
import com.unionpay.tsmservice.data.Constant;
import java.util.Calendar;
import jj.d;
import nj.j;
import nj.u;
import sh.h;
import sh.i;
import sh.k;
import wi.b;
/* loaded from: classes2.dex */
public class AlarmDetailActivity extends b {

    /* renamed from: h  reason: collision with root package name */
    TextView f20027h;

    /* renamed from: i  reason: collision with root package name */
    TextView f20028i;

    /* renamed from: j  reason: collision with root package name */
    RecyclerView f20029j;

    /* renamed from: k  reason: collision with root package name */
    private AlarmBean f20030k;

    /* renamed from: l  reason: collision with root package name */
    private long f20031l;

    /* renamed from: m  reason: collision with root package name */
    private int f20032m;

    /* renamed from: n  reason: collision with root package name */
    private int f20033n;

    /* renamed from: o  reason: collision with root package name */
    private a f20034o;

    /* renamed from: p  reason: collision with root package name */
    private String[] f20035p;

    /* renamed from: q  reason: collision with root package name */
    private boolean[] f20036q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends RecyclerView.Adapter<C0231a> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f20037a;

        /* renamed from: b  reason: collision with root package name */
        private final String[] f20038b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.mobvoi.mcuwatch.ui.settings.alarm.AlarmDetailActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0231a extends RecyclerView.b0 {

            /* renamed from: a  reason: collision with root package name */
            CheckBox f20040a;

            C0231a(a aVar, View view) {
                super(view);
                this.f20040a = (CheckBox) view.findViewById(h.f34713x0);
            }
        }

        a(Context context, String[] strArr) {
            this.f20037a = context;
            this.f20038b = strArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(int i10, CompoundButton compoundButton, boolean z10) {
            AlarmDetailActivity.this.f20036q[i10] = z10;
        }

        /* renamed from: e */
        public void onBindViewHolder(C0231a aVar, final int i10) {
            aVar.f20040a.setText(this.f20038b[i10]);
            aVar.f20040a.setOnCheckedChangeListener(null);
            aVar.f20040a.setChecked(AlarmDetailActivity.this.f20036q[i10]);
            aVar.f20040a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.mobvoi.mcuwatch.ui.settings.alarm.b
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                    AlarmDetailActivity.a.this.d(i10, compoundButton, z10);
                }
            });
        }

        /* renamed from: f */
        public C0231a onCreateViewHolder(ViewGroup viewGroup, int i10) {
            return new C0231a(this, LayoutInflater.from(this.f20037a).inflate(i.D0, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            String[] strArr = this.f20038b;
            if (strArr == null) {
                return 0;
            }
            return strArr.length;
        }
    }

    private void Y() {
        if (this.f20031l == 0) {
            Toast.makeText(this, k.d_res_0x7f140057, 0).show();
            return;
        }
        if (this.f20030k == null) {
            this.f20030k = new AlarmBean();
        }
        AlarmBean alarmBean = this.f20030k;
        alarmBean.alarmTime = this.f20031l;
        alarmBean.weekChecked = this.f20036q;
        alarmBean.hour = this.f20032m;
        alarmBean.minute = this.f20033n;
        M(1, alarmBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Z(Object[] objArr) {
        jj.b.g().m(jj.b.g().b((AlarmBean) objArr[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(Calendar calendar, TimePicker timePicker, int i10, int i11) {
        calendar.set(11, i10);
        calendar.set(12, i11);
        calendar.set(13, 0);
        this.f20032m = i10;
        this.f20033n = i11;
        b0(calendar);
    }

    private void b0(Calendar calendar) {
        long timeInMillis = calendar.getTimeInMillis();
        this.f20031l = timeInMillis;
        d0(timeInMillis);
    }

    private void c0(final Calendar calendar) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, j.c(this), new TimePickerDialog.OnTimeSetListener() { // from class: jj.c
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public final void onTimeSet(TimePicker timePicker, int i10, int i11) {
                AlarmDetailActivity.this.a0(calendar, timePicker, i10, i11);
            }
        }, calendar.get(11), calendar.get(12), true);
        timePickerDialog.show();
        int b10 = j7.a.b(this, 16842806, -7829368);
        timePickerDialog.getButton(-1).setTextColor(b10);
        timePickerDialog.getButton(-2).setTextColor(b10);
    }

    private void d0(long j10) {
        if (j10 > 0) {
            this.f20027h.setText(k.Q2);
            this.f20028i.setText(u.a(j10));
            return;
        }
        this.f20027h.setText(k.c_res_0x7f140055);
        this.f20028i.setText("");
    }

    private void e0() {
        AlarmBean alarmBean = this.f20030k;
        if (alarmBean != null) {
            long j10 = alarmBean.alarmTime;
            this.f20031l = j10;
            d0(j10);
            AlarmBean alarmBean2 = this.f20030k;
            boolean[] zArr = alarmBean2.weekChecked;
            if (zArr != null) {
                this.f20036q = zArr;
            }
            this.f20032m = alarmBean2.hour;
            this.f20033n = alarmBean2.minute;
        }
        if (this.f20036q == null) {
            this.f20036q = new boolean[7];
        }
        String[] stringArray = getResources().getStringArray(sh.b.e_res_0x7f03000d);
        this.f20035p = stringArray;
        this.f20034o = new a(this, stringArray);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.B2(0);
        this.f20029j.setLayoutManager(linearLayoutManager);
        this.f20029j.setAdapter(this.f20034o);
    }

    @Override // wi.e
    protected Class<ij.i> I() {
        return ij.i.class;
    }

    @Override // wi.b
    protected void N() {
        if (this.f36241d == 1) {
            T();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // wi.b
    public void Q() {
        super.Q();
        this.f36242e.put(1, d.f29640a);
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return i.f34756u;
    }

    @Override // wi.b
    protected void initView() {
        if (getIntent() != null) {
            this.f20030k = (AlarmBean) getIntent().getParcelableExtra(Constant.KEY_PARAMS);
        }
        this.f20027h = (TextView) findViewById(h.f34654j3);
        this.f20028i = (TextView) findViewById(h.f34650i3);
        this.f20029j = (RecyclerView) findViewById(h.D2);
        findViewById(h.O1).setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.alarm.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlarmDetailActivity.this.onClick(view);
            }
        });
        setTitle(k.a_res_0x7f140052);
        e0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onClick(View view) {
        if (view.getId() == h.O1) {
            Calendar calendar = Calendar.getInstance();
            long j10 = this.f20031l;
            if (j10 > 0) {
                calendar.setTimeInMillis(j10);
            }
            c0(calendar);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(sh.j.f34768c, menu);
        menu.findItem(h.f34615b).setTitle(k.f34850p2);
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != h.f34615b) {
            return super.onOptionsItemSelected(menuItem);
        }
        Y();
        return true;
    }

    @Override // com.mobvoi.mcuwatch.engine.m
    public void p() {
        if (this.f36241d == 1) {
            T();
            finish();
        }
    }
}
