package kd;

import com.amap.api.services.core.AMapException;
import com.mobvoi.android.common.utils.q;
import com.mobvoi.companion.base.ui.view.numberpicker.NumberPicker;
import com.mobvoi.wear.companion.setup.settings.SettingConstants;
/* compiled from: BirthdayViewUtils.java */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f29869a = {4, 6, 9, 11};

    /* compiled from: BirthdayViewUtils.java */
    /* loaded from: classes2.dex */
    class a implements NumberPicker.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NumberPicker f29870a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ NumberPicker f29871b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String[] f29872c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String[] f29873d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String[] f29874e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String[] f29875f;

        a(NumberPicker numberPicker, NumberPicker numberPicker2, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
            this.f29870a = numberPicker;
            this.f29871b = numberPicker2;
            this.f29872c = strArr;
            this.f29873d = strArr2;
            this.f29874e = strArr3;
            this.f29875f = strArr4;
        }

        @Override // com.mobvoi.companion.base.ui.view.numberpicker.NumberPicker.g
        public void a(NumberPicker numberPicker, int i10, int i11) {
            int i12 = i11 + 1;
            if (i12 == 2) {
                if ((this.f29870a.getValue() + AMapException.CODE_AMAP_CLIENT_UNKNOWN_ERROR) % 4 == 0) {
                    this.f29871b.setMinValue(0);
                    this.f29871b.setMaxValue(28);
                    this.f29871b.setDisplayedValues(this.f29872c);
                    return;
                }
                this.f29871b.setMinValue(0);
                this.f29871b.setMaxValue(27);
                this.f29871b.setDisplayedValues(this.f29873d);
            } else if (d.d(i12)) {
                this.f29871b.setMinValue(0);
                this.f29871b.setMaxValue(29);
                this.f29871b.setDisplayedValues(this.f29874e);
            } else {
                this.f29871b.setDisplayedValues(this.f29875f);
                this.f29871b.setMinValue(0);
                this.f29871b.setMaxValue(30);
            }
        }
    }

    /* compiled from: BirthdayViewUtils.java */
    /* loaded from: classes2.dex */
    class b implements NumberPicker.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NumberPicker f29876a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ NumberPicker f29877b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String[] f29878c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String[] f29879d;

        b(NumberPicker numberPicker, NumberPicker numberPicker2, String[] strArr, String[] strArr2) {
            this.f29876a = numberPicker;
            this.f29877b = numberPicker2;
            this.f29878c = strArr;
            this.f29879d = strArr2;
        }

        @Override // com.mobvoi.companion.base.ui.view.numberpicker.NumberPicker.g
        public void a(NumberPicker numberPicker, int i10, int i11) {
            if (this.f29876a.getValue() != 1) {
                return;
            }
            if ((i11 + AMapException.CODE_AMAP_CLIENT_UNKNOWN_ERROR) % 4 == 0) {
                this.f29877b.setMaxValue(20);
                this.f29877b.setDisplayedValues(this.f29878c);
                this.f29877b.setMinValue(0);
                this.f29877b.setMaxValue(28);
                return;
            }
            this.f29877b.setMinValue(0);
            this.f29877b.setMaxValue(27);
            this.f29877b.setDisplayedValues(this.f29879d);
        }
    }

    public static int[] b(int[] iArr) {
        int[] iArr2 = new int[3];
        String d10 = q.d(com.mobvoi.android.common.utils.b.e(), "settings", SettingConstants.DATE_FORMAT, SettingConstants.DATE_FORMAT_DEFAULT);
        if (SettingConstants.DATE_FORMAT_DEFAULT.equals(d10)) {
            return (int[]) iArr.clone();
        }
        if ("dd-MM-yyyy".equals(d10)) {
            iArr2[0] = iArr[2];
            iArr2[1] = iArr[1];
            iArr2[2] = iArr[0];
            return iArr2;
        } else if (!"MM-dd-yyyy".equals(d10)) {
            return (int[]) iArr.clone();
        } else {
            iArr2[0] = iArr[1];
            iArr2[1] = iArr[2];
            iArr2[2] = iArr[0];
            return iArr2;
        }
    }

    public static String c(String str) {
        String[] split = str.split("\\.");
        String d10 = q.d(com.mobvoi.android.common.utils.b.e(), "settings", SettingConstants.DATE_FORMAT, SettingConstants.DATE_FORMAT_DEFAULT);
        StringBuilder sb2 = new StringBuilder();
        if (SettingConstants.DATE_FORMAT_DEFAULT.equals(d10)) {
            return str;
        }
        if ("dd-MM-yyyy".equals(d10)) {
            sb2.append(split[2]);
            sb2.append(".");
            sb2.append(split[1]);
            sb2.append(".");
            sb2.append(split[0]);
            return sb2.toString();
        } else if (!"MM-dd-yyyy".equals(d10)) {
            return str;
        } else {
            sb2.append(split[1]);
            sb2.append(".");
            sb2.append(split[2]);
            sb2.append(".");
            sb2.append(split[0]);
            return sb2.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(int i10) {
        for (int i11 : f29869a) {
            if (i10 == i11) {
                return true;
            }
        }
        return false;
    }

    public static void e(NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, String[] strArr) {
        String[] strArr2 = new String[30];
        int i10 = 0;
        int i11 = 0;
        while (i11 < 30) {
            StringBuilder sb2 = new StringBuilder();
            int i12 = i11 + 1;
            sb2.append(i12);
            sb2.append("");
            strArr2[i11] = sb2.toString();
            i11 = i12;
        }
        String[] strArr3 = new String[29];
        int i13 = 0;
        while (i13 < 29) {
            StringBuilder sb3 = new StringBuilder();
            int i14 = i13 + 1;
            sb3.append(i14);
            sb3.append("");
            strArr3[i13] = sb3.toString();
            i13 = i14;
        }
        String[] strArr4 = new String[28];
        while (i10 < 28) {
            StringBuilder sb4 = new StringBuilder();
            int i15 = i10 + 1;
            sb4.append(i15);
            sb4.append("");
            strArr4[i10] = sb4.toString();
            i10 = i15;
        }
        numberPicker2.setOnValueChangedListener(new a(numberPicker, numberPicker3, strArr3, strArr4, strArr2, strArr));
        numberPicker.setOnValueChangedListener(new b(numberPicker2, numberPicker3, strArr3, strArr4));
    }
}
