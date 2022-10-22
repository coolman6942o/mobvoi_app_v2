package com.laser.tsm.sdk.apdu;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.laser.tsm.sdk.AppConfig;
import com.laser.tsm.sdk.bean.Capdu;
import com.laser.tsm.sdk.bean.DeviceInfo;
import com.laser.tsm.sdk.bean.Rapdu;
import com.laser.tsm.sdk.tsm.IMobvoiTsmSingleTransBluetoothInterface;
import com.laser.tsm.sdk.util.DataConvertUtil;
import com.laser.tsm.sdk.util.LogUtil;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
/* loaded from: classes2.dex */
public class ApduBluetoothRequest extends ApduRequest {
    private final String TAG = "ApduBluetoothRequest";

    public ApduBluetoothRequest(Context context, ApduResponseHandler apduResponseHandler) {
        super(context, apduResponseHandler);
    }

    private void transiveAPDU(IMobvoiTsmSingleTransBluetoothInterface iMobvoiTsmSingleTransBluetoothInterface) throws RemoteException, Exception {
        byte[] bArr;
        String str;
        String str2 = "";
        while (this.mCurrentExecuteIndex < this.mCapduList.size()) {
            if (this.mMayInterruptIfRunning) {
                sendFailureMessage(-1, new Error("execute apdu interrupt"));
                return;
            }
            Capdu capdu = this.mCapduList.get(this.mCurrentExecuteIndex);
            this.mCurrentExecuteApduBean = capdu;
            String apdu = capdu.getApdu();
            LogUtil.d("start get apdu index:" + this.mCurrentExecuteIndex + "==apdu:" + apdu);
            byte[] hexStringToBytes = DataConvertUtil.hexStringToBytes(apdu);
            if (this.mMayInterruptIfRunning) {
                sendFailureMessage(-1, new Error("execute apdu interrupt"));
                return;
            }
            String str3 = null;
            try {
                bArr = iMobvoiTsmSingleTransBluetoothInterface.transiveAPDU(hexStringToBytes);
            } catch (Exception unused) {
                bArr = null;
            }
            if (bArr != null) {
                str3 = DataConvertUtil.bytesToHexString(bArr);
            }
            LogUtil.d("handle apdu response:" + str3);
            boolean z10 = this.mMayInterruptIfRunning;
            if (z10) {
                sendFailureMessage(-1, new Error("execute apdu interrupt"));
                return;
            } else if (str3 == null) {
                createRapduBean(this.mCurrentExecuteApduBean.getIndex(), "", "");
                if (this.mIsGetLocalData) {
                    sendFailureMessage(-1, new Error("execute apdu failure: " + this.mCurrentExecuteApduBean.getApdu()));
                    return;
                }
                sendMessage(1);
                return;
            } else if (z10) {
                sendFailureMessage(-1, new Error("execute apdu interrupt"));
                return;
            } else {
                if (str3.length() > 4) {
                    str3 = str3.substring(str3.length() - 4, str3.length());
                    str = str3.substring(0, str3.length() - 4).toUpperCase(Locale.getDefault());
                } else {
                    str = "";
                }
                if (str3 != null) {
                    str3 = str3.toUpperCase(Locale.getDefault());
                }
                LogUtil.d("get response res_sw:" + str3);
                if (str3.startsWith("6C") && str3.length() == 4) {
                    String substring = str3.substring(2, 4);
                    String apdu2 = this.mCapduList.get(this.mCurrentExecuteIndex).getApdu();
                    this.mCapduList.get(this.mCurrentExecuteIndex).setApdu(apdu2.substring(0, apdu2.length() - 2) + substring);
                } else if (str3.startsWith("61")) {
                    str2 = str2 + str;
                    this.mCapduList.get(this.mCurrentExecuteIndex).setApdu("00C00000" + str3.substring(str3.length() - 2, str3.length()));
                } else {
                    if (!TextUtils.isEmpty(str2)) {
                        str = str2 + str;
                        str2 = "";
                    }
                    createRapduBean(this.mCurrentExecuteApduBean.getIndex(), str, str3);
                    String[] sw = this.mCurrentExecuteApduBean.getSw();
                    if (sw == null || sw.length <= 0 || Arrays.asList(sw).contains(str3)) {
                        this.mCurrentExecuteIndex++;
                    } else if (this.mIsGetLocalData) {
                        sendFailureMessage(-1, new Error("return sw error: " + str3));
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

    @Override // com.laser.tsm.sdk.apdu.ApduRequest
    protected void executeApdu() {
        this.mMayInterruptIfRunning = false;
        List<Capdu> list = this.mCapduList;
        if (list == null || list.size() == 0) {
            LogUtil.e("capdu list is null");
        } else if (this.mCurrentExecuteIndex == this.mCapduList.size()) {
            LogUtil.e("the last capdu has executed ,no more capdu need to execute");
        } else {
            IMobvoiTsmSingleTransBluetoothInterface iMobvoiTsmSingleTransBluetoothInterface = AppConfig.singleluetoothInterfaceService;
            if (iMobvoiTsmSingleTransBluetoothInterface == null) {
                LogUtil.e("bluetoothInterfaceService is null");
                return;
            }
            try {
                LogUtil.d("ApduBluetoothRequest", "IBluetoothInterfaceService status:" + iMobvoiTsmSingleTransBluetoothInterface.queryBluetoothState());
                if (this.mMayInterruptIfRunning) {
                    sendFailureMessage(-1, new Error("execute apdu interrupt"));
                    return;
                }
                if (!iMobvoiTsmSingleTransBluetoothInterface.queryBluetoothState()) {
                    DeviceInfo deviceInfo = AppConfig.deviceInfo;
                    if (deviceInfo == null) {
                        sendFailureMessage(4100, new Error("connect bluetooth device failure"));
                        return;
                    }
                    LogUtil.d("ApduBluetoothRequest", "DeviceInfo:" + deviceInfo.getDeviceMac());
                    if (iMobvoiTsmSingleTransBluetoothInterface.connectBluetoothDevice(deviceInfo) != 0) {
                        sendFailureMessage(4100, new Error("connect bluetooth device failure"));
                        return;
                    }
                }
                if (this.mMayInterruptIfRunning) {
                    sendFailureMessage(-1, new Error("execute apdu interrupt"));
                } else {
                    transiveAPDU(iMobvoiTsmSingleTransBluetoothInterface);
                }
            } catch (RemoteException e10) {
                sendFailureMessage(4099, new Error("bind server error: " + e10.getMessage()));
            } catch (Exception e11) {
                sendFailureMessage(-1, new Error("bind server error: " + e11.getMessage()));
            }
        }
    }
}
