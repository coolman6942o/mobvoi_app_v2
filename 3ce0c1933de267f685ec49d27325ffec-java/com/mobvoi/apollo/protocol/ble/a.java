package com.mobvoi.apollo.protocol.ble;

import android.bluetooth.BluetoothGattCharacteristic;
import java.util.UUID;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: BleCharacteristicInfo.kt */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final C0194a f15579d = new C0194a(null);

    /* renamed from: a  reason: collision with root package name */
    private final UUID f15580a;

    /* renamed from: b  reason: collision with root package name */
    private final int f15581b;

    /* renamed from: c  reason: collision with root package name */
    private final c f15582c;

    /* compiled from: BleCharacteristicInfo.kt */
    /* renamed from: com.mobvoi.apollo.protocol.ble.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0194a {
        private C0194a() {
        }

        public /* synthetic */ C0194a(f fVar) {
            this();
        }

        public final a a(BluetoothGattCharacteristic characteristic) {
            i.f(characteristic, "characteristic");
            UUID uuid = characteristic.getUuid();
            i.e(uuid, "characteristic.uuid");
            int instanceId = characteristic.getInstanceId();
            UUID uuid2 = characteristic.getService().getUuid();
            i.e(uuid2, "characteristic.service.uuid");
            return new a(uuid, instanceId, new c(uuid2, characteristic.getService().getInstanceId()));
        }
    }

    public a(UUID uuid, int i10, c serviceInfo) {
        i.f(uuid, "uuid");
        i.f(serviceInfo, "serviceInfo");
        this.f15580a = uuid;
        this.f15581b = i10;
        this.f15582c = serviceInfo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return i.b(this.f15580a, aVar.f15580a) && this.f15581b == aVar.f15581b && i.b(this.f15582c, aVar.f15582c);
    }

    public int hashCode() {
        return (((this.f15580a.hashCode() * 31) + this.f15581b) * 31) + this.f15582c.hashCode();
    }

    public String toString() {
        return "BleCharacteristicInfo(uuid=" + this.f15580a + ", instanceId=" + this.f15581b + ", serviceInfo=" + this.f15582c + ')';
    }
}
