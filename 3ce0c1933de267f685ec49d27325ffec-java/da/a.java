package da;

import android.bluetooth.BluetoothDevice;
import kotlin.jvm.internal.i;
/* compiled from: AdvertisePayload.kt */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final BluetoothDevice f25571a;

    /* renamed from: b  reason: collision with root package name */
    private final byte f25572b;

    /* renamed from: c  reason: collision with root package name */
    private final short f25573c;

    /* renamed from: d  reason: collision with root package name */
    private final String f25574d;

    public a(BluetoothDevice device, byte b10, short s10, String macAddress) {
        i.f(device, "device");
        i.f(macAddress, "macAddress");
        this.f25571a = device;
        this.f25572b = b10;
        this.f25573c = s10;
        this.f25574d = macAddress;
    }

    public final String a() {
        return this.f25574d;
    }

    public final short b() {
        return this.f25573c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return i.b(this.f25571a, aVar.f25571a) && this.f25572b == aVar.f25572b && this.f25573c == aVar.f25573c && i.b(this.f25574d, aVar.f25574d);
    }

    public int hashCode() {
        return (((((this.f25571a.hashCode() * 31) + this.f25572b) * 31) + this.f25573c) * 31) + this.f25574d.hashCode();
    }

    public String toString() {
        return "AdvertisePayload(device=" + this.f25571a + ", version=" + ((int) this.f25572b) + ", model=" + ((int) this.f25573c) + ", macAddress=" + this.f25574d + ')';
    }
}
