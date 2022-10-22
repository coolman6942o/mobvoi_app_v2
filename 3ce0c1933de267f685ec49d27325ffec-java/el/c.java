package el;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.realsil.sdk.core.bluetooth.scanner.ScannerParams;
import gl.a;
import gl.b;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class c extends yk.a {

    /* renamed from: p  reason: collision with root package name */
    public b f26111p;

    /* renamed from: q  reason: collision with root package name */
    public a.AbstractC0292a f26112q;

    /* loaded from: classes2.dex */
    public class a implements a.AbstractC0292a {
        public a() {
        }
    }

    public c(Context context, Handler handler, ScannerParams scannerParams, d dVar) {
        this.f26112q = new a();
        this.f37110c = context.getApplicationContext();
        this.f37113f = handler;
        this.f37111d = scannerParams;
        this.f37112e = dVar;
        c();
    }

    public c(Context context, ScannerParams scannerParams, d dVar) {
        this(context, null, scannerParams, dVar);
    }

    @Override // yk.a
    public boolean c() {
        if (!super.c()) {
            return false;
        }
        this.f26111p = new b(this.f37110c, Build.VERSION.SDK_INT);
        return true;
    }

    @Override // yk.a
    public boolean d(BluetoothDevice bluetoothDevice) {
        if (Build.VERSION.SDK_INT >= 18) {
            if (this.f37111d.j() == 18) {
                if (bluetoothDevice.getType() != 2) {
                    if (this.f37109b) {
                        il.b.j(String.format(Locale.US, "filter, invalid type: %d, expect type is %d", Integer.valueOf(bluetoothDevice.getType()), 2));
                    }
                    return false;
                }
            } else if (!(this.f37111d.j() != 17 || bluetoothDevice.getType() == 2 || bluetoothDevice.getType() == 3 || bluetoothDevice.getType() == 0)) {
                if (this.f37109b) {
                    il.b.j(String.format(Locale.US, "filter, invalid type: %d, expect type is %d/%d/%d", Integer.valueOf(bluetoothDevice.getType()), 0, 2, 3));
                }
                return false;
            }
        }
        if (!TextUtils.isEmpty(this.f37111d.e())) {
            if (!jl.a.c(this.f37111d.e(), bluetoothDevice.getName())) {
                if (!this.f37111d.o()) {
                    if (this.f37108a) {
                        il.b.j(String.format("conflict name: %s", bluetoothDevice.getName()));
                    }
                    return false;
                } else if (bluetoothDevice.getName() == null || !bluetoothDevice.getName().contains(this.f37111d.e())) {
                    if (this.f37108a) {
                        il.b.j(String.format("conflict name: %s", bluetoothDevice.getName()));
                    }
                    return false;
                }
            }
        } else if (!this.f37111d.p() && TextUtils.isEmpty(bluetoothDevice.getName())) {
            if (this.f37109b) {
                il.b.j("name is null, ignore");
            }
            return false;
        }
        if (TextUtils.isEmpty(this.f37111d.a()) || jl.a.c(this.f37111d.a(), bluetoothDevice.getAddress())) {
            return true;
        }
        if (this.f37109b) {
            il.b.j("address not match:" + fl.a.c(bluetoothDevice.getAddress(), true));
        }
        return false;
    }

    @Override // yk.a
    public boolean f(b bVar) {
        return true;
    }

    @Override // yk.a
    public boolean j() {
        i();
        b bVar = this.f26111p;
        synchronized (bVar) {
            gl.a aVar = bVar.f27493a;
            if (aVar != null) {
                aVar.f27492f = null;
            }
        }
        if (this.f26111p.f27493a.f27490d) {
            il.b.k(this.f37109b, "stop the le scan");
            if (!this.f26111p.b(null, false)) {
                il.b.c("scanLeDevice failed");
                return false;
            }
        }
        a(0);
        return true;
    }

    @Override // yk.a
    public boolean n() {
        if (!h()) {
            return true;
        }
        il.b.j("start le scan for " + this.f37111d.k() + "ms");
        b bVar = this.f26111p;
        a.AbstractC0292a aVar = this.f26112q;
        synchronized (bVar) {
            gl.a aVar2 = bVar.f27493a;
            if (aVar2 != null) {
                aVar2.f27492f = aVar;
            }
        }
        if (!this.f26111p.b(this.f37111d, true)) {
            il.b.j("scanLeDevice failed");
            o();
            return false;
        }
        g();
        return true;
    }

    @Override // yk.a
    public boolean o() {
        this.f37121n = false;
        return j();
    }
}
