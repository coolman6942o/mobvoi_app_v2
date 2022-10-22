package el;

import android.bluetooth.BluetoothDevice;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BluetoothDevice f26107a;

    /* renamed from: b  reason: collision with root package name */
    public String f26108b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f26109c;

    /* renamed from: d  reason: collision with root package name */
    public e f26110d;

    public b(BluetoothDevice bluetoothDevice, String str, int i10, boolean z10, boolean z11, byte[] bArr) {
        this.f26107a = bluetoothDevice;
        this.f26108b = str;
        d(bArr);
    }

    public BluetoothDevice a() {
        return this.f26107a;
    }

    public String b() {
        return this.f26108b;
    }

    public byte[] c() {
        return this.f26109c;
    }

    public void d(byte[] bArr) {
        this.f26109c = bArr;
        e e10 = e.e(bArr);
        this.f26110d = e10;
        if (e10 != null && e10.d() != null) {
            this.f26110d.d().contains(fl.b.f27080a);
        }
    }

    public boolean equals(Object obj) {
        return obj instanceof b ? this.f26107a.getAddress().equals(((b) obj).f26107a.getAddress()) : super.equals(obj);
    }
}
