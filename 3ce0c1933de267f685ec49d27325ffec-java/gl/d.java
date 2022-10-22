package gl;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.Build;
import com.realsil.sdk.core.bluetooth.scanner.ScannerParams;
import com.realsil.sdk.core.bluetooth.scanner.compat.CompatScanFilter;
import el.c;
import gl.a;
import il.b;
import java.util.ArrayList;
import java.util.List;
@TargetApi(21)
/* loaded from: classes2.dex */
public class d extends gl.a {

    /* renamed from: g  reason: collision with root package name */
    public BluetoothLeScanner f27496g;

    /* renamed from: h  reason: collision with root package name */
    public ScanCallback f27497h = new a();

    /* loaded from: classes2.dex */
    public class a extends ScanCallback {
        public a() {
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List<ScanResult> list) {
            super.onBatchScanResults(list);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int i10) {
            super.onScanFailed(i10);
            boolean z10 = d.this.f27487a;
            b.d(z10, "scan failed with " + i10);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i10, ScanResult scanResult) {
            super.onScanResult(i10, scanResult);
            if (d.this.f27487a) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ScanResult{");
                sb2.append("\n\tdevice=");
                sb2.append(fl.a.c(scanResult.getDevice().getAddress(), true));
                sb2.append("\n\tscanRecord=");
                sb2.append(scanResult.getScanRecord());
                sb2.append("\n\trssi=");
                sb2.append(scanResult.getRssi());
                sb2.append("\n\ttimestampNanos=");
                sb2.append(scanResult.getTimestampNanos());
                sb2.append("\n\teventType=");
                sb2.append(scanResult.getDevice());
                if (Build.VERSION.SDK_INT >= 26) {
                    sb2.append("\n\tprimaryPhy=");
                    sb2.append(scanResult.getPrimaryPhy());
                    sb2.append("\n\tsecondaryPhy=");
                    sb2.append(scanResult.getSecondaryPhy());
                    sb2.append("\n\tadvertisingSid=");
                    sb2.append(scanResult.getAdvertisingSid());
                    sb2.append("\n\ttxPower=");
                    sb2.append(scanResult.getTxPower());
                    sb2.append("\n\tperiodicAdvertisingInterval=");
                    sb2.append(scanResult.getPeriodicAdvertisingInterval());
                }
                sb2.append("\n}");
                b.j(sb2.toString());
            }
            d dVar = d.this;
            if (!dVar.f27490d) {
                b.j(String.format("scan procedure has already been stopped, ignore.", new Object[0]));
                return;
            }
            ScannerParams scannerParams = dVar.f27491e;
            if (scannerParams == null || !scannerParams.m() || Build.VERSION.SDK_INT < 26 || scanResult.isConnectable()) {
                ScanRecord scanRecord = scanResult.getScanRecord();
                d dVar2 = d.this;
                BluetoothDevice device = scanResult.getDevice();
                int rssi = scanResult.getRssi();
                byte[] bytes = scanRecord != null ? scanRecord.getBytes() : new byte[0];
                a.AbstractC0292a aVar = dVar2.f27492f;
                if (aVar != null) {
                    c.this.e(device, rssi, bytes);
                } else {
                    b.k(dVar2.f27488b, "no listeners register");
                }
            } else if (d.this.f27488b) {
                b.j("ignore noconnectable device");
            }
        }
    }

    public d(Context context) {
        super(context);
        b.k(this.f27488b, "LeScannerV21 init");
        BluetoothAdapter bluetoothAdapter = this.f27489c;
        if (bluetoothAdapter != null) {
            this.f27496g = bluetoothAdapter.getBluetoothLeScanner();
        }
        if (this.f27496g == null) {
            b.c("mBluetoothLeScanner == null");
        }
    }

    @Override // gl.a
    public boolean a() {
        String str;
        super.a();
        BluetoothAdapter bluetoothAdapter = this.f27489c;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            str = "BT Adapter is not turned ON";
        } else {
            BluetoothLeScanner bluetoothLeScanner = this.f27496g;
            if (bluetoothLeScanner == null) {
                str = "BluetoothLeScanner has not been initialized";
            } else {
                try {
                    bluetoothLeScanner.stopScan(this.f27497h);
                    return true;
                } catch (Exception e10) {
                    str = e10.toString();
                }
            }
        }
        b.l(str);
        return false;
    }

    @Override // gl.a
    public boolean b(ScannerParams scannerParams) {
        if (!super.b(scannerParams)) {
            b.l("startScan failed");
            return false;
        }
        if (this.f27496g == null) {
            b.c("getBluetoothLeScanner...");
            this.f27496g = this.f27489c.getBluetoothLeScanner();
        }
        if (this.f27496g == null) {
            b.l("mBluetoothLeScanner is null");
            a();
            return false;
        }
        ArrayList arrayList = new ArrayList();
        List<CompatScanFilter> h10 = scannerParams.h();
        if (h10 != null && h10.size() > 0) {
            boolean z10 = this.f27488b;
            b.k(z10, "contains " + h10.size() + " filters");
            for (CompatScanFilter compatScanFilter : h10) {
                ScanFilter.Builder builder = new ScanFilter.Builder();
                builder.setServiceUuid(compatScanFilter.i()).setDeviceAddress(compatScanFilter.a()).setDeviceName(compatScanFilter.b()).setManufacturerData(compatScanFilter.e(), compatScanFilter.c(), compatScanFilter.d());
                if (compatScanFilter.g() != null) {
                    builder.setServiceData(compatScanFilter.g(), compatScanFilter.f());
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    builder.setServiceSolicitationUuid(compatScanFilter.h());
                }
                arrayList.add(builder.build());
                b.k(this.f27488b, compatScanFilter.toString());
            }
        }
        ScanSettings.Builder scanMode = new ScanSettings.Builder().setScanMode(2);
        if (Build.VERSION.SDK_INT >= 26) {
            scanMode.setPhy(scannerParams.f()).setLegacy(false);
        }
        try {
            this.f27496g.startScan(arrayList, scanMode.build(), this.f27497h);
            return true;
        } catch (Exception e10) {
            b.l(e10.toString());
            return false;
        }
    }
}
