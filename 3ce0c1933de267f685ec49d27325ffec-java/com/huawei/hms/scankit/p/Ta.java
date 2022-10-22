package com.huawei.hms.scankit.p;

import android.os.Bundle;
import android.util.SparseArray;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.hmsscankit.DetailRect;
import com.huawei.hms.ml.scan.HmsScan;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Timer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: HaLog60001.java */
/* loaded from: classes2.dex */
public final class Ta extends Za {

    /* renamed from: h  reason: collision with root package name */
    private volatile String f14643h;

    /* renamed from: i  reason: collision with root package name */
    private volatile String f14644i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f14645j;

    /* renamed from: k  reason: collision with root package name */
    private volatile long f14646k;

    /* renamed from: l  reason: collision with root package name */
    private b f14647l = new b(this, null);

    /* compiled from: HaLog60001.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f14648a;

        /* renamed from: b  reason: collision with root package name */
        private String f14649b;

        /* renamed from: c  reason: collision with root package name */
        private String f14650c;

        /* renamed from: d  reason: collision with root package name */
        private long f14651d;

        /* renamed from: e  reason: collision with root package name */
        private long f14652e;

        /* renamed from: f  reason: collision with root package name */
        private String f14653f;

        /* renamed from: g  reason: collision with root package name */
        private String f14654g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f14655h;

        /* renamed from: i  reason: collision with root package name */
        private int f14656i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f14657j;

        /* synthetic */ a(long j10, String str, String str2, boolean z10, int i10, int i11, Ra ra2) {
            this(j10, str, str2, z10, i10, i11);
        }

        private a(long j10, String str, String str2, boolean z10, int i10, int i11) {
            this.f14651d = j10;
            this.f14649b = str;
            this.f14650c = str2;
            this.f14655h = z10;
            this.f14656i = i10;
            this.f14648a = i11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a b(String str) {
            this.f14654g = str;
            return this;
        }

        public a a(int i10) {
            this.f14648a = i10;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a a(long j10) {
            this.f14652e = j10;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a a(boolean z10) {
            this.f14657j = z10;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a a(String str) {
            this.f14653f = str;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HaLog60001.java */
    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        private String f14658a;

        /* renamed from: b  reason: collision with root package name */
        private Timer f14659b;

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f14660c;

        /* renamed from: d  reason: collision with root package name */
        private List<a> f14661d;

        /* renamed from: e  reason: collision with root package name */
        private List<a> f14662e;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: HaLog60001.java */
        /* loaded from: classes2.dex */
        public class a {

            /* renamed from: a  reason: collision with root package name */
            private StringBuilder f14664a;

            /* renamed from: b  reason: collision with root package name */
            private AtomicInteger[] f14665b;

            /* renamed from: c  reason: collision with root package name */
            private String[] f14666c;

            /* renamed from: d  reason: collision with root package name */
            private long[] f14667d;

            private a() {
                this.f14664a = new StringBuilder(100);
                this.f14665b = new AtomicInteger[]{new AtomicInteger(), new AtomicInteger(), new AtomicInteger(), new AtomicInteger(), new AtomicInteger(), new AtomicInteger(), new AtomicInteger()};
                this.f14666c = new String[]{"lt10K:", "lt100K:", "lt1M:", "lt3M:", "lt10M:", "lt40M:", "gt40M:"};
                this.f14667d = new long[]{10240, 102400, 1048576, 3145728, 10485760, 41943040, Long.MAX_VALUE};
            }

            /* JADX INFO: Access modifiers changed from: private */
            public String a() {
                StringBuilder sb2 = this.f14664a;
                sb2.delete(0, sb2.length());
                this.f14664a.append("{");
                for (int i10 = 0; i10 < this.f14665b.length; i10++) {
                    this.f14664a.append(this.f14666c[i10]);
                    this.f14664a.append(this.f14665b[i10]);
                    this.f14664a.append(",");
                }
                StringBuilder sb3 = this.f14664a;
                sb3.replace(sb3.length() - 1, this.f14664a.length(), "}");
                return this.f14664a.toString();
            }

            /* synthetic */ a(b bVar, Ra ra2) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a(int i10) {
                int i11 = 0;
                while (true) {
                    AtomicInteger[] atomicIntegerArr = this.f14665b;
                    if (i11 >= atomicIntegerArr.length) {
                        return;
                    }
                    if (i10 <= this.f14667d[i11]) {
                        atomicIntegerArr[i11].addAndGet(1);
                        return;
                    }
                    i11++;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: HaLog60001.java */
        /* renamed from: com.huawei.hms.scankit.p.Ta$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0181b {

            /* renamed from: a  reason: collision with root package name */
            private StringBuilder f14669a;

            /* renamed from: b  reason: collision with root package name */
            private SparseArray<AtomicInteger> f14670b;

            private C0181b() {
                this.f14669a = new StringBuilder(60);
                this.f14670b = new Va(this);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a(int i10) {
                if (this.f14670b.get(i10) == null) {
                    this.f14670b.put(i10, new Wa(this));
                } else {
                    this.f14670b.get(i10).addAndGet(1);
                }
            }

            /* synthetic */ C0181b(b bVar, Ra ra2) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public String a() {
                StringBuilder sb2 = this.f14669a;
                sb2.delete(0, sb2.length());
                this.f14669a.append("{");
                for (int i10 = 0; i10 < this.f14670b.size(); i10++) {
                    this.f14669a.append(this.f14670b.keyAt(i10));
                    this.f14669a.append(":");
                    this.f14669a.append(this.f14670b.valueAt(i10));
                    this.f14669a.append(",");
                }
                StringBuilder sb3 = this.f14669a;
                sb3.replace(sb3.length() - 1, this.f14669a.length(), "}");
                return this.f14669a.toString();
            }
        }

        private b() {
            this.f14658a = b.class.getSimpleName();
            this.f14659b = new Timer();
            this.f14660c = true;
            this.f14661d = new ArrayList(10);
            this.f14662e = new ArrayList(10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(a aVar) {
            if (this.f14661d.size() <= 100) {
                synchronized (this) {
                    this.f14661d.add(aVar);
                    if (this.f14660c) {
                        this.f14660c = false;
                        this.f14659b.schedule(new Ua(this), 1000L);
                    }
                }
            }
        }

        /* synthetic */ b(Ta ta2, Ra ra2) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (this.f14661d.size() > 0) {
                synchronized (this) {
                    List<a> list = this.f14661d;
                    List<a> list2 = this.f14662e;
                    this.f14661d = list2;
                    this.f14662e = list;
                    list2.clear();
                }
                a(this.f14662e);
            }
        }

        private void a(List<a> list) {
            HashSet<String> hashSet = new HashSet();
            for (a aVar : list) {
                hashSet.add(aVar.f14650c);
            }
            for (String str : hashSet) {
                Boolean bool = null;
                C0181b bVar = new C0181b(this, null);
                a aVar2 = new a(this, null);
                long j10 = Long.MAX_VALUE;
                long j11 = Long.MIN_VALUE;
                String str2 = "";
                String str3 = str2;
                String str4 = str3;
                long j12 = 0;
                long j13 = 0;
                long j14 = 0;
                long j15 = 0;
                for (a aVar3 : list) {
                    str2 = aVar3.f14649b;
                    str3 = aVar3.f14653f;
                    str4 = aVar3.f14654g;
                    bool = Boolean.valueOf(aVar3.f14655h);
                    j13 += aVar3.f14652e - aVar3.f14651d;
                    bVar.a(aVar3.f14648a);
                    aVar2.a(aVar3.f14656i);
                    j12++;
                    if (aVar3.f14657j) {
                        j15++;
                    }
                    if (aVar3.f14648a != 0) {
                        j14++;
                    }
                    if (aVar3.f14652e - aVar3.f14651d < j10) {
                        j10 = aVar3.f14652e - aVar3.f14651d;
                    }
                    if (aVar3.f14652e - aVar3.f14651d > j11) {
                        j11 = aVar3.f14652e - aVar3.f14651d;
                    }
                }
                LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
                linkedHashMap.putAll(Ta.this.f14727f);
                linkedHashMap.put("result", bVar.a());
                linkedHashMap.put("imgSizeHistogram", aVar2.a());
                linkedHashMap.put("callTime", str2);
                linkedHashMap.put("transId", str);
                if (j12 != 0) {
                    j13 /= j12;
                }
                linkedHashMap.put("costTime", String.valueOf(j13));
                linkedHashMap.put("allCnt", String.valueOf(j12));
                linkedHashMap.put("failCnt", String.valueOf(j14));
                linkedHashMap.put("codeCnt", String.valueOf(j15));
                linkedHashMap.put("scanType", str3);
                linkedHashMap.put("sceneType", str4);
                linkedHashMap.put("min", String.valueOf(j10));
                linkedHashMap.put("max", String.valueOf(j11));
                linkedHashMap.put("algPhotoMode", String.valueOf(bool));
                C0569bb.a().a("60001", linkedHashMap);
            }
        }
    }

    public Ta(Bundle bundle, String str) {
        super(bundle, DynamicModuleInitializer.getContext());
        this.f14645j = false;
        this.f14727f.put("apiName", str);
        if (DetailRect.PHOTO_MODE.equals(str)) {
            this.f14645j = true;
        }
    }

    public void a(String str) {
        this.f14727f.put("algapi", str);
    }

    public a a(boolean z10, int i10) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                if (this.f14645j) {
                    new a(currentTimeMillis, new Ra(this, "yyyyMMddHHmmss.SSS").format(Long.valueOf(currentTimeMillis)), UUID.randomUUID().toString(), z10, i10, 0, null);
                    return new a(currentTimeMillis, this.f14643h, this.f14644i, z10, i10, 0, null);
                }
                if (currentTimeMillis - this.f14646k > 1500) {
                    String format = new Sa(this, "yyyyMMddHHmmss.SSS").format(Long.valueOf(currentTimeMillis));
                    String uuid = UUID.randomUUID().toString();
                    if (currentTimeMillis - this.f14646k > 1500) {
                        this.f14643h = format;
                        this.f14644i = uuid;
                        this.f14646k = currentTimeMillis;
                    }
                }
                new a(currentTimeMillis, this.f14643h, this.f14644i, z10, i10, 0, null);
                return new a(currentTimeMillis, this.f14643h, this.f14644i, z10, i10, 0, null);
            } catch (Exception unused) {
                com.huawei.hms.scankit.util.a.b("HaLog6001", "exception happens");
                return new a(currentTimeMillis, this.f14643h, this.f14644i, z10, i10, 0, null);
            }
        } catch (Throwable unused2) {
            return new a(currentTimeMillis, this.f14643h, this.f14644i, z10, i10, 0, null);
        }
    }

    public void a(HmsScan[] hmsScanArr, a aVar) {
        try {
            String str = Za.f14722a;
            String str2 = Za.f14723b;
            if (a()) {
                boolean z10 = false;
                z10 = false;
                if (hmsScanArr != null && hmsScanArr.length > 0) {
                    for (HmsScan hmsScan : hmsScanArr) {
                        str = Za.a(hmsScan.scanType);
                        str2 = Za.b(hmsScan.scanTypeForm);
                    }
                    z10 = true;
                }
                this.f14647l.a(aVar.a(System.currentTimeMillis()).a(z10).a(str).b(str2));
                this.f14646k = aVar.f14652e;
            }
        } catch (NullPointerException unused) {
            com.huawei.hms.scankit.util.a.b("HaLog60001", "nullPoint");
        } catch (Exception unused2) {
            com.huawei.hms.scankit.util.a.b("HaLog60001", "logEnd Exception");
        }
    }
}
