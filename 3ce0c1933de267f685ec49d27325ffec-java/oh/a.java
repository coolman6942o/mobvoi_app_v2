package oh;

import android.util.SparseArray;
import com.mobvoi.health.core.data.pojo.DataType;
import eg.c;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* compiled from: DataForDay.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: h  reason: collision with root package name */
    private static final DataType[] f31705h = {DataType.Step, DataType.Exercise, DataType.Active, DataType.Calorie, DataType.Distance, DataType.Temperature, DataType.Sleep};

    /* renamed from: a  reason: collision with root package name */
    private final int f31706a;

    /* renamed from: b  reason: collision with root package name */
    private String f31707b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<DataType, SparseArray<Float>> f31708c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<DataType, Float> f31709d;

    /* renamed from: e  reason: collision with root package name */
    private int f31710e;

    /* renamed from: f  reason: collision with root package name */
    private int f31711f;

    /* renamed from: g  reason: collision with root package name */
    private int f31712g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DataForDay.java */
    /* renamed from: oh.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C0422a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31713a;

        static {
            int[] iArr = new int[com.mobvoi.health.common.data.pojo.DataType.values().length];
            f31713a = iArr;
            try {
                iArr[com.mobvoi.health.common.data.pojo.DataType.DeltaCalorie.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31713a[com.mobvoi.health.common.data.pojo.DataType.DeltaDistance.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31713a[com.mobvoi.health.common.data.pojo.DataType.DeltaStep.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31713a[com.mobvoi.health.common.data.pojo.DataType.DeltaExercise.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31713a[com.mobvoi.health.common.data.pojo.DataType.Temperature.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        new a(0);
    }

    public a(int i10) {
        this.f31706a = i10;
        DataType[] dataTypeArr = f31705h;
        this.f31708c = new HashMap(dataTypeArr.length);
        this.f31709d = new HashMap(dataTypeArr.length);
    }

    private float f(SparseArray<Float> sparseArray, int i10) {
        Float f10 = sparseArray.get(i10);
        if (f10 == null) {
            return 0.0f;
        }
        return f10.floatValue();
    }

    private long j(int i10) {
        return TimeUnit.SECONDS.toMillis(i10);
    }

    private int k(long j10) {
        return (int) TimeUnit.MILLISECONDS.toSeconds(j10);
    }

    private DataType l(bg.a aVar) {
        int i10 = C0422a.f31713a[aVar.f5138a.ordinal()];
        if (i10 == 1) {
            return DataType.Calorie;
        }
        if (i10 == 2) {
            return DataType.Distance;
        }
        if (i10 == 3) {
            return DataType.Step;
        }
        if (i10 == 4) {
            return DataType.Exercise;
        }
        if (i10 != 5) {
            return null;
        }
        return DataType.Temperature;
    }

    public int a() {
        return this.f31710e;
    }

    public String b() {
        return this.f31707b;
    }

    public SparseArray<Float> c(DataType dataType) {
        SparseArray<Float> sparseArray = this.f31708c.get(dataType);
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Float> sparseArray2 = new SparseArray<>();
        this.f31708c.put(dataType, sparseArray2);
        return sparseArray2;
    }

    public int d() {
        return this.f31706a;
    }

    public int e(DataType dataType) {
        Float f10 = this.f31709d.get(dataType);
        if (f10 != null) {
            return Math.round(f10.floatValue());
        }
        return 0;
    }

    public void g(bg.a aVar) {
        DataType l10 = l(aVar);
        if (l10 != null) {
            int k10 = k(c.d(aVar.f5139b).getTimeInMillis());
            int k11 = k(c.d(aVar.f5140c).getTimeInMillis());
            int i10 = this.f31706a;
            int i11 = c.f26040a;
            if (k10 < i10 + i11 && k11 >= i10) {
                if (k10 < i10) {
                    k10 = i10;
                }
                if (k11 >= i10 + i11) {
                    k11 = (i10 + i11) - c.f26041b;
                }
                SparseArray<Float> c10 = c(l10);
                boolean z10 = l10 == DataType.Step;
                SparseArray<Float> sparseArray = null;
                if (z10) {
                    sparseArray = c(DataType.Active);
                }
                while (k10 <= k11) {
                    float f10 = f(c10, k10);
                    long j10 = j(k10);
                    int i12 = c.f26041b;
                    bg.a f11 = aVar.f(j10, j(k10 + i12));
                    if (f11 != null) {
                        f10 += f11.f5141d;
                        c10.append(k10, Float.valueOf(f10));
                    }
                    if (z10) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(j(k10));
                        int k12 = k(calendar.getTimeInMillis());
                        calendar.set(12, 0);
                        int k13 = k(calendar.getTimeInMillis());
                        int i13 = calendar.get(11);
                        if (i13 >= this.f31711f && i13 <= this.f31712g) {
                            if (k12 > k13) {
                                f10 += f(c10, k13);
                            }
                            sparseArray.append(k13, Float.valueOf(f10));
                        }
                    }
                    k10 += i12;
                }
                int k14 = k(aVar.f5140c);
                if (k14 > this.f31710e) {
                    this.f31710e = k14;
                }
            }
        }
    }

    public void h(int i10, int i11) {
        this.f31711f = i10;
        this.f31712g = i11;
    }

    public void i(String str) {
        this.f31707b = str;
    }

    public void m() {
        DataType[] dataTypeArr;
        float f10;
        for (DataType dataType : f31705h) {
            SparseArray<Float> c10 = c(dataType);
            float f11 = 0.0f;
            for (int i10 = 0; i10 < c10.size(); i10++) {
                if (dataType != DataType.Active) {
                    f10 = c10.valueAt(i10).floatValue();
                } else if (c10.valueAt(i10).floatValue() >= 100.0f) {
                    f10 = 1.0f;
                }
                f11 += f10;
            }
            this.f31709d.put(dataType, Float.valueOf(f11));
        }
    }
}
