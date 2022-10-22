package com.laser.tsm.sdk.apdu;

import android.content.Context;
import android.os.RemoteException;
import com.laser.tsm.sdk.AppConfig;
import com.laser.tsm.sdk.bean.Capdu;
import com.laser.tsm.sdk.bean.DeviceInfo;
import com.laser.tsm.sdk.bean.Rapdu;
import com.laser.tsm.sdk.tsm.IMobvoiTsmBluetoothInterface;
import com.laser.tsm.sdk.util.LogUtil;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
/* loaded from: classes2.dex */
public class MultiApduBluetoothRequest extends ApduRequest {
    private final String TAG = "MultiApduBluetoothRequest";

    public MultiApduBluetoothRequest(Context context, ApduResponseHandler apduResponseHandler) {
        super(context, apduResponseHandler);
    }

    private void transiveAPDU(IMobvoiTsmBluetoothInterface iMobvoiTsmBluetoothInterface) throws RemoteException, Exception {
        List<Rapdu> transiveAPDU = iMobvoiTsmBluetoothInterface.transiveAPDU(this.mCapduList);
        LogUtil.d("MultiApduBluetoothRequest", "rapduList:" + transiveAPDU);
        if (transiveAPDU == null || transiveAPDU.size() <= 0) {
            createRapduBean(this.mCapduList.get(0).getIndex(), "", "");
            if (this.mIsGetLocalData) {
                sendFailureMessage(-1, new Error("execute apdu failure"));
            } else {
                sendMessage(1);
            }
        } else {
            for (int i10 = 0; i10 < transiveAPDU.size(); i10++) {
                Rapdu rapdu = transiveAPDU.get(i10);
                if (rapdu == null) {
                    createRapduBean(this.mCapduList.get(i10).getIndex(), "", "");
                    if (this.mIsGetLocalData) {
                        sendFailureMessage(-1, new Error("execute apdu failure: " + this.mCapduList.get(i10).getApdu()));
                        return;
                    }
                    sendMessage(1);
                    return;
                } else if (this.mMayInterruptIfRunning) {
                    sendFailureMessage(-1, new Error("execute apdu interrupt"));
                    return;
                } else {
                    String sw = rapdu.getSw();
                    if (sw != null) {
                        sw = sw.toUpperCase(Locale.getDefault());
                    }
                    createRapduBean(rapdu.getIndex(), rapdu.getRapdu(), sw);
                    String[] sw2 = this.mCapduList.get(i10).getSw();
                    if (sw2 != null && sw2.length > 0 && !Arrays.asList(sw2).contains(sw)) {
                        if (this.mIsGetLocalData) {
                            sendFailureMessage(-1, new Error("return sw error: " + rapdu.getSw()));
                            return;
                        } else {
                            sendMessage(1);
                            return;
                        }
                    }
                }
            }
            if (this.mIsGetLocalData) {
                List<Rapdu> list = this.mRapduList;
                sendSuccessMessage(list.get(list.size() - 1));
                return;
            }
            sendMessage(0);
        }
    }

    @Override // com.laser.tsm.sdk.apdu.ApduRequest
    protected void executeApdu() {
        this.mMayInterruptIfRunning = false;
        List<Capdu> list = this.mCapduList;
        if (list == null || list.size() == 0) {
            LogUtil.e("MultiApduBluetoothRequest", "capdu list is null");
            return;
        }
        IMobvoiTsmBluetoothInterface iMobvoiTsmBluetoothInterface = AppConfig.multiBluetoothInterfaceService;
        if (iMobvoiTsmBluetoothInterface == null) {
            LogUtil.e("MultiApduBluetoothRequest", "bluetooth service is null");
            return;
        }
        try {
            LogUtil.d("MultiApduBluetoothRequest", "status:" + iMobvoiTsmBluetoothInterface.queryBluetoothState());
            if (this.mMayInterruptIfRunning) {
                sendFailureMessage(-1, new Error("execute apdu interrupt"));
                return;
            }
            if (!iMobvoiTsmBluetoothInterface.queryBluetoothState()) {
                DeviceInfo deviceInfo = AppConfig.deviceInfo;
                if (deviceInfo == null) {
                    sendFailureMessage(4100, new Error("connect bluetooth device failure"));
                    return;
                } else if (iMobvoiTsmBluetoothInterface.connectBluetoothDevice(deviceInfo) != 0) {
                    sendFailureMessage(4100, new Error("connect bluetooth device failure"));
                    return;
                }
            }
            if (this.mMayInterruptIfRunning) {
                sendFailureMessage(-1, new Error("execute apdu interrupt"));
            } else {
                transiveAPDU(iMobvoiTsmBluetoothInterface);
            }
        } catch (RemoteException e10) {
            sendFailureMessage(4099, new Error("bind server error: " + e10.getMessage()));
        } catch (Exception e11) {
            sendFailureMessage(-1, new Error("bind server error: " + e11.getMessage()));
        }
    }
}
