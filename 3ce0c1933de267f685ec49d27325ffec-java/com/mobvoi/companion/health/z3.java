package com.mobvoi.companion.health;

import com.mobvoi.health.companion.system.WearDevices;
import hh.b;
import java.util.List;
/* compiled from: WearInfoBuilder.java */
/* loaded from: classes2.dex */
public class z3 {

    /* renamed from: a  reason: collision with root package name */
    private final WearDevices.a f17165a = new WearDevices.a();

    /* renamed from: b  reason: collision with root package name */
    private final b.a f17166b = new b.a();

    public void a(WearDevices.DeviceType deviceType, String str, String str2, String str3, List<String> list) {
        WearDevices.b bVar = new WearDevices.b();
        bVar.f19010a = deviceType;
        bVar.f19011b = str;
        bVar.f19012c = str2;
        bVar.f19013d = str3;
        this.f17165a.a(bVar);
        if (deviceType == WearDevices.DeviceType.Watch) {
            this.f17166b.b(str, list);
        } else if (deviceType == WearDevices.DeviceType.Band) {
            this.f17166b.a(str, list);
        }
    }

    public void b(WearDevices.DeviceType deviceType, String str, String str2, List<String> list) {
        a(deviceType, str, str2, null, list);
    }

    public b c() {
        return this.f17166b.d();
    }

    public WearDevices d() {
        return this.f17165a.b();
    }
}
