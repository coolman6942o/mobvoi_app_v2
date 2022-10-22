package gl;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import com.realsil.sdk.core.bluetooth.scanner.ScannerParams;
import el.c;
import wk.b;
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f27487a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f27488b;

    /* renamed from: c  reason: collision with root package name */
    public BluetoothAdapter f27489c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f27490d;

    /* renamed from: e  reason: collision with root package name */
    public ScannerParams f27491e;

    /* renamed from: f  reason: collision with root package name */
    public AbstractC0292a f27492f;

    /* renamed from: gl.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface AbstractC0292a {
    }

    public a(Context context) {
        this.f27487a = false;
        this.f27488b = false;
        this.f27487a = b.f36299b;
        this.f27488b = b.f36300c;
        BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth");
        this.f27489c = bluetoothManager != null ? bluetoothManager.getAdapter() : null;
    }

    public boolean a() {
        AbstractC0292a aVar = this.f27492f;
        if (aVar != null) {
            c.a aVar2 = (c.a) aVar;
            il.b.k(c.this.f37109b, "onLeScanStop");
            c.this.a(3);
        } else {
            il.b.k(this.f27488b, "no listeners register");
        }
        this.f27490d = false;
        return true;
    }

    public boolean b(ScannerParams scannerParams) {
        BluetoothAdapter bluetoothAdapter = this.f27489c;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            il.b.l("BT Adapter is not turned ON");
            return false;
        }
        il.b.k(this.f27488b, "LeScanner--startScan");
        AbstractC0292a aVar = this.f27492f;
        if (aVar != null) {
            c.a aVar2 = (c.a) aVar;
        } else {
            il.b.k(this.f27488b, "no listeners register");
        }
        this.f27490d = true;
        this.f27491e = scannerParams;
        return true;
    }
}
