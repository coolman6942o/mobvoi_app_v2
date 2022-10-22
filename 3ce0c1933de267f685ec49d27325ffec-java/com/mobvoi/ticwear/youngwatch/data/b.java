package com.mobvoi.ticwear.youngwatch.data;

import android.text.TextUtils;
import com.google.gson.e;
import com.mobvoi.android.common.utils.q;
import com.mobvoi.ticwear.youngwatch.data.a;
import com.mobvoi.ticwear.youngwatch.data.b;
import com.mobvoi.wear.util.GeoPoint;
import com.mobvoi.wear.util.GeoUtil;
import ef.o;
import ef.p;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
/* compiled from: WorkoutSportPointSaveManager.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    private static b f20864d;

    /* renamed from: a  reason: collision with root package name */
    private final List<p> f20865a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final e f20866b = new e();

    /* renamed from: c  reason: collision with root package name */
    private int f20867c = 0;

    /* compiled from: WorkoutSportPointSaveManager.java */
    /* loaded from: classes2.dex */
    class a extends com.google.gson.reflect.a<List<com.mobvoi.ticwear.youngwatch.data.a>> {
        a(b bVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WorkoutSportPointSaveManager.java */
    /* renamed from: com.mobvoi.ticwear.youngwatch.data.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0244b extends com.google.gson.reflect.a<List<com.mobvoi.ticwear.youngwatch.data.a>> {
        C0244b(b bVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WorkoutSportPointSaveManager.java */
    /* loaded from: classes2.dex */
    public class c extends com.google.gson.reflect.a<List<com.mobvoi.ticwear.youngwatch.data.a>> {
        c(b bVar) {
        }
    }

    public static b c() {
        if (f20864d == null) {
            synchronized (b.class) {
                f20864d = new b();
            }
        }
        return f20864d;
    }

    private File d() {
        return new File(com.mobvoi.android.common.utils.b.h(null), "sport_point.txt");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object g(com.mobvoi.ticwear.youngwatch.data.a aVar) throws Exception {
        h(aVar);
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void h(com.mobvoi.ticwear.youngwatch.data.a aVar) {
        IOException e10;
        File d10;
        FileOutputStream fileOutputStream = null;
        try {
            d10 = d();
        } catch (IOException e11) {
            e10 = e11;
        }
        if (d10.exists() || d10.createNewFile()) {
            String readLine = new BufferedReader(new FileReader(d10)).readLine();
            long c10 = q.c(com.mobvoi.android.common.utils.b.e(), "sportPoint", "sport_point_sync_mills", 0L);
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(readLine)) {
                for (com.mobvoi.ticwear.youngwatch.data.a aVar2 : (List) this.f20866b.k(readLine, new C0244b(this).getType())) {
                    if (c10 <= aVar2.sportStartTime) {
                        arrayList.add(aVar2);
                    }
                }
            }
            arrayList.add(aVar);
            String t10 = this.f20866b.t(arrayList, new c(this).getType());
            FileOutputStream fileOutputStream2 = new FileOutputStream(d10);
            try {
                fileOutputStream2.write(t10.getBytes());
                fileOutputStream2.flush();
            } catch (IOException e12) {
                e10 = e12;
                fileOutputStream = fileOutputStream2;
                e10.printStackTrace();
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                }
            }
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
            }
        }
    }

    public void b() {
        this.f20865a.clear();
    }

    public int e() {
        return this.f20867c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0071, code lost:
        r10 = r2.sportPointBeanList.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007b, code lost:
        if (r10.hasNext() == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007d, code lost:
        r11 = r10.next();
        r12 = new ef.p();
        r12.f25951a = r11.time;
        r12.f25952b = r11.timestamp;
        r12.f25954d = r11.speed;
        r12.f25953c = r11.distance;
        r13 = new ef.o();
        r12.f25973w = r13;
        r13.f25947d = r11.latitude;
        r13.f25946c = r11.longitude;
        r13.f25948e = r11.accuracy;
        r11 = r11.distance;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00af, code lost:
        if (r11 <= r9.f20867c) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b1, code lost:
        r9.f20867c = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b3, code lost:
        r1.add(r12);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<p> f(long j10, long j11) {
        String readLine;
        this.f20867c = 0;
        File d10 = d();
        if (!d10.exists()) {
            return null;
        }
        long c10 = q.c(com.mobvoi.android.common.utils.b.e(), "sportPoint", "sport_point_sync_mills", 0L);
        if (c10 == 0 || c10 > j10) {
            q.g(com.mobvoi.android.common.utils.b.e(), "sportPoint", "sport_point_sync_mills", j10);
        }
        ArrayList arrayList = new ArrayList();
        try {
            readLine = new BufferedReader(new FileReader(d10)).readLine();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
        if (TextUtils.isEmpty(readLine)) {
            return null;
        }
        Iterator it = ((List) this.f20866b.k(readLine, new a(this).getType())).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.mobvoi.ticwear.youngwatch.data.a aVar = (com.mobvoi.ticwear.youngwatch.data.a) it.next();
            long j12 = aVar.sportStartTime;
            if (j12 >= j10 && j12 < j11) {
                break;
            }
        }
        return arrayList;
    }

    public List<p> i() {
        if (this.f20865a.size() == 0) {
            return this.f20865a;
        }
        final com.mobvoi.ticwear.youngwatch.data.a aVar = new com.mobvoi.ticwear.youngwatch.data.a();
        aVar.sportStartTime = this.f20865a.get(0).f25952b;
        aVar.sportPointBeanList = new ArrayList();
        for (p pVar : this.f20865a) {
            a.C0243a aVar2 = new a.C0243a();
            aVar2.time = pVar.f25951a;
            aVar2.timestamp = pVar.f25952b;
            aVar2.distance = pVar.f25953c;
            aVar2.speed = pVar.f25954d;
            if (pVar.f25973w != null) {
                if (com.mobvoi.companion.base.settings.a.isOversea()) {
                    o oVar = pVar.f25973w;
                    aVar2.latitude = oVar.f25947d;
                    aVar2.longitude = oVar.f25946c;
                } else {
                    o oVar2 = pVar.f25973w;
                    GeoPoint convertGCJToBaidu = GeoUtil.convertGCJToBaidu(new GeoPoint(oVar2.f25947d, oVar2.f25946c));
                    aVar2.latitude = convertGCJToBaidu.getLat();
                    aVar2.longitude = convertGCJToBaidu.getLng();
                }
                aVar2.accuracy = pVar.f25973w.f25948e;
            }
            aVar.sportPointBeanList.add(aVar2);
        }
        rx.c.x(new Callable() { // from class: pk.e1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Object g10;
                g10 = b.this.g(aVar);
                return g10;
            }
        }).Z(cq.a.c()).T();
        return this.f20865a;
    }

    public void j(p pVar) {
        this.f20865a.add(pVar);
    }
}
