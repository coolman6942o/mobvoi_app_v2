package bp;

import android.bluetooth.BluetoothGatt;
import android.content.Intent;
import java.io.InputStream;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;
/* compiled from: DfuService.java */
/* loaded from: classes3.dex */
interface l extends h {
    boolean f(Intent intent, BluetoothGatt bluetoothGatt) throws DfuException, DeviceDisconnectedException, UploadAbortedException;

    boolean g(Intent intent, BluetoothGatt bluetoothGatt, int i10, InputStream inputStream, InputStream inputStream2) throws DfuException, DeviceDisconnectedException, UploadAbortedException;

    void h(Intent intent) throws DfuException, DeviceDisconnectedException, UploadAbortedException;

    void release();
}
