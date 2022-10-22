package kd;

import android.content.Context;
import android.view.View;
import ce.e;
import ce.f;
import com.amap.api.services.core.AMapException;
import com.mobvoi.companion.base.ui.view.numberpicker.NumberPicker;
import com.mobvoi.companion.profile.h;
import com.mobvoi.health.common.data.pojo.DataType;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import jd.k;
/* compiled from: BirthdayChanger.java */
/* loaded from: classes2.dex */
public class a extends k<Long> {

    /* renamed from: f  reason: collision with root package name */
    protected NumberPicker f29866f;

    /* renamed from: g  reason: collision with root package name */
    protected NumberPicker f29867g;

    /* renamed from: h  reason: collision with root package name */
    protected NumberPicker f29868h;

    public a(h hVar, long j10) {
        super(hVar, Long.valueOf(j10));
    }

    private void n(NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, Context context) {
        int i10 = Calendar.getInstance().get(1);
        int i11 = (i10 - 1900) + 1;
        String[] strArr = new String[i11];
        for (int i12 = 1900; i12 <= i10; i12++) {
            strArr[i12 - 1900] = i12 + "";
        }
        String[] stringArray = context.getResources().getStringArray(ce.a.f5742a);
        String[] strArr2 = new String[31];
        int i13 = 0;
        while (i13 < 31) {
            StringBuilder sb2 = new StringBuilder();
            int i14 = i13 + 1;
            sb2.append(i14);
            sb2.append("");
            strArr2[i13] = sb2.toString();
            i13 = i14;
        }
        int[] b10 = c.b(((Long) this.f29541c).longValue() != -1 ? new SimpleDateFormat("yyyy.MM.dd", Locale.getDefault()).format(new Date(TimeUnit.SECONDS.toMillis(((Long) this.f29541c).longValue()))) : ta.a.f(), 1989, 1, 1);
        int i15 = b10[0];
        int i16 = b10[1];
        int i17 = b10[2];
        numberPicker.setPickerDividerColor(kc.a.a(this.f29539a));
        numberPicker2.setPickerDividerColor(kc.a.a(this.f29539a));
        numberPicker3.setPickerDividerColor(kc.a.a(this.f29539a));
        numberPicker.setMaxValue(i11 - 1);
        numberPicker2.setMaxValue(11);
        numberPicker3.setMaxValue(30);
        numberPicker.setMinValue(0);
        numberPicker.setValue(i15 - AMapException.CODE_AMAP_CLIENT_UNKNOWN_ERROR);
        numberPicker2.setValue(i16 - 1);
        numberPicker3.setValue(i17 - 1);
        numberPicker2.setMinValue(0);
        numberPicker3.setMinValue(0);
        numberPicker.setDisplayedValues(strArr);
        numberPicker2.setDisplayedValues(stringArray);
        numberPicker3.setDisplayedValues(strArr2);
        d.e(numberPicker, numberPicker2, numberPicker3, strArr2);
    }

    @Override // jd.k
    protected int d() {
        return f.f5827u;
    }

    @Override // jd.k
    protected int e() {
        return ce.h.D;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jd.k
    public void g(View view) {
        super.g(view);
        int[] b10 = d.b(new int[]{e.f5798r0, e.N, e.f5781j});
        this.f29866f = (NumberPicker) view.findViewById(b10[0]);
        this.f29867g = (NumberPicker) view.findViewById(b10[1]);
        NumberPicker numberPicker = (NumberPicker) view.findViewById(b10[2]);
        this.f29868h = numberPicker;
        n(this.f29866f, this.f29867g, numberPicker, this.f29539a);
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Long, E] */
    @Override // jd.k
    protected void j(View view) {
        int value = this.f29866f.getValue() + AMapException.CODE_AMAP_CLIENT_UNKNOWN_ERROR;
        int value2 = this.f29867g.getValue() + 1;
        int value3 = this.f29868h.getValue() + 1;
        String a10 = c.a(value, value2, value3);
        if (!a10.equals(ta.a.f())) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(1, value);
            calendar.set(2, value2 - 1);
            calendar.set(5, value3);
            ?? valueOf = Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(calendar.getTimeInMillis()));
            this.f29541c = valueOf;
            m(DataType.InfoBirthday, (float) ((Long) valueOf).longValue());
            k.a aVar = this.f29543e;
            if (aVar != null) {
                aVar.k(2, this.f29541c);
            }
            sa.a e10 = ta.a.e();
            e10.birthday = a10;
            this.f29540b.h(e10);
            return;
        }
        this.f29540b.h(null);
    }
}
