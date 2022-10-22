package com.laser.tsm.sdk.tsm;

import android.content.Context;
import android.text.TextUtils;
import com.laser.tsm.sdk.AppConfig;
import com.laser.tsm.sdk.apdu.ApduManager;
import com.laser.tsm.sdk.apdu.EnumDeviceType;
import com.laser.tsm.sdk.bean.DeviceInfo;
import com.laser.tsm.sdk.bean.Rapdu;
import com.laser.tsm.sdk.business.BaseResponse;
import com.laser.tsm.sdk.business.SsdAppStatusQueryForResp;
import com.laser.tsm.sdk.http.AsyncHttpClient;
import com.laser.tsm.sdk.util.LogUtil;
import java.util.Objects;
/* loaded from: classes2.dex */
public class TSMOperator implements ITSMOperator, TSMOperatorResponse {
    private static final int RETURN_APPLETAID_IS_NULL = 100004;
    private static final int RETURN_CPLC_IS_NULL = 100001;
    public static final int RETURN_NETWORK_ERROR = 100007;
    private static final int RETURN_OPERAPPLETREQPARAMS_IS_NULL = 100002;
    public static final int RETURN_RESPONSE_PARSE_ERROR = 100009;
    public static final int RETURN_SERVER_ERROR = 100010;
    public static final int RETURN_SMARTCARD_OPER_FAILURE = 100006;
    private static final int RETURN_SSDAID_IS_NULL = 100003;
    public static final int RETURN_UNKNOW_ERROR = 100008;
    private static volatile TSMOperator sInstance;
    private static Object sLock = new Object();
    private ApduManager mApduManager;
    private int mOperatorResult = AppConfig.STATUS_SUCCESS;
    private String mResponse = null;
    private String mResSw = null;
    private final String TAG = "TSMOperator";

    private TSMOperator() {
    }

    public static TSMOperator getInstance() {
        if (sInstance == null) {
            synchronized (sLock) {
                if (sInstance == null) {
                    sInstance = new TSMOperator();
                }
            }
        }
        return sInstance;
    }

    private boolean isParamsNull() {
        return TextUtils.isEmpty(AppConfig.CPLC) || TextUtils.isEmpty(AppConfig.SEID);
    }

    private void setCplc(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.endsWith("9000")) {
                str = str.substring(0, str.length() - 4);
            }
            if (str.startsWith("9f7f") || str.startsWith("9F7F")) {
                str = str.substring(6, str.length());
            }
            AppConfig.CPLC = str;
            AppConfig.SEID = str.substring(24, 36);
        }
    }

    public boolean activateApplet(String str) {
        this.mApduManager.requestActivateApplet(str);
        return !TextUtils.isEmpty(this.mResSw) && this.mResSw.equalsIgnoreCase("9000");
    }

    @Override // com.laser.tsm.sdk.tsm.ITSMOperator
    public int addGPAC(String str) {
        if (isParamsNull()) {
            return 100001;
        }
        if (str == null) {
            return RETURN_APPLETAID_IS_NULL;
        }
        this.mApduManager.requestOperGPAC(1, str);
        return this.mOperatorResult;
    }

    @Override // com.laser.tsm.sdk.tsm.ITSMOperator
    public int applyPAMID() {
        if (isParamsNull()) {
            return 100001;
        }
        this.mApduManager.requestApplyPAMID();
        return this.mOperatorResult;
    }

    @Override // com.laser.tsm.sdk.tsm.ITSMOperator
    public int cascadingDeleteSSD(String str) {
        if (isParamsNull()) {
            return 100001;
        }
        if (str == null) {
            return RETURN_SSDAID_IS_NULL;
        }
        this.mApduManager.requestOperSSD(5, str, null, null);
        return this.mOperatorResult;
    }

    public void clearDeviceData() {
        AppConfig.clearDeviceData();
        this.mOperatorResult = AppConfig.STATUS_SUCCESS;
        this.mResponse = null;
        this.mResSw = null;
    }

    @Override // com.laser.tsm.sdk.tsm.ITSMOperator
    public int createSSD(String str, String str2, String str3) {
        if (isParamsNull()) {
            return 100001;
        }
        if (str == null) {
            return RETURN_SSDAID_IS_NULL;
        }
        this.mApduManager.requestOperSSD(1, str, str2, str3);
        return this.mOperatorResult;
    }

    public boolean deactivateApplet(String str) {
        this.mApduManager.requestDeactivateApplet(str);
        return !TextUtils.isEmpty(this.mResSw) && this.mResSw.equalsIgnoreCase("9000");
    }

    @Override // com.laser.tsm.sdk.tsm.ITSMOperator
    public int deleteApplet(String str, String str2) {
        if (isParamsNull()) {
            return 100001;
        }
        this.mApduManager.requestOperApplet(2, str, str2);
        return this.mOperatorResult;
    }

    @Override // com.laser.tsm.sdk.tsm.ITSMOperator
    public int deleteGPAC(String str) {
        if (isParamsNull()) {
            return 100001;
        }
        if (str == null) {
            return RETURN_APPLETAID_IS_NULL;
        }
        this.mApduManager.requestOperGPAC(2, str);
        return this.mOperatorResult;
    }

    @Override // com.laser.tsm.sdk.tsm.ITSMOperator
    public int deleteSSD(String str) {
        if (isParamsNull()) {
            return 100001;
        }
        if (str == null) {
            return RETURN_SSDAID_IS_NULL;
        }
        this.mApduManager.requestOperSSD(2, str, null, null);
        return this.mOperatorResult;
    }

    @Override // com.laser.tsm.sdk.tsm.ITSMOperator
    public String getCIN() {
        this.mApduManager.requestGetCIN();
        if (!TextUtils.isEmpty(this.mResponse)) {
            this.mResponse.substring(0, 2);
            this.mResponse = this.mResponse.substring(4, (Integer.parseInt(this.mResponse.substring(2, 4), 16) * 2) + 4);
        }
        return this.mResponse;
    }

    @Override // com.laser.tsm.sdk.tsm.ITSMOperator
    public String getCPLC() {
        if (isParamsNull()) {
            this.mApduManager.requestGetCPLC();
            setCplc(this.mResponse);
        }
        return AppConfig.CPLC;
    }

    @Override // com.laser.tsm.sdk.tsm.ITSMOperator
    public String getIIN() {
        this.mApduManager.requestGetIIN();
        if (!TextUtils.isEmpty(this.mResponse)) {
            this.mResponse.substring(0, 2);
            this.mResponse = this.mResponse.substring(4, (Integer.parseInt(this.mResponse.substring(2, 4), 16) * 2) + 4);
        }
        return this.mResponse;
    }

    @Override // com.laser.tsm.sdk.tsm.ITSMOperator
    public String getSEID() {
        if (isParamsNull()) {
            this.mApduManager.requestGetCPLC();
            setCplc(this.mResponse);
        }
        return AppConfig.SEID;
    }

    public Integer getSFKBalance() {
        this.mApduManager.requestGetSFKBalance();
        if (TextUtils.isEmpty(this.mResSw) || !this.mResSw.equals("9000")) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(this.mResponse, 16));
    }

    public void init(Context context, EnumDeviceType enumDeviceType) {
        AppConfig.init(context);
        ApduManager apduManager = new ApduManager(context, enumDeviceType);
        this.mApduManager = apduManager;
        apduManager.setTsmOperatorResponse(this);
    }

    public int initBluetoothDeviceInfo() {
        if (AppConfig.multiBluetoothInterfaceService != null) {
            DeviceInfo deviceInfo = new DeviceInfo();
            int deviceInfo2 = AppConfig.multiBluetoothInterfaceService.getDeviceInfo(deviceInfo);
            String deviceModel = deviceInfo.getDeviceModel();
            AppConfig.MOBILETYPE = deviceModel;
            if (deviceInfo2 == 0 && !TextUtils.isEmpty(deviceModel)) {
                AppConfig.deviceInfo = deviceInfo;
                return AppConfig.STATUS_SUCCESS;
            }
        }
        if (AppConfig.singleluetoothInterfaceService == null) {
            return 4102;
        }
        DeviceInfo deviceInfo3 = new DeviceInfo();
        int deviceInfo4 = AppConfig.singleluetoothInterfaceService.getDeviceInfo(deviceInfo3);
        String deviceModel2 = deviceInfo3.getDeviceModel();
        AppConfig.MOBILETYPE = deviceModel2;
        if (deviceInfo4 != 0 || TextUtils.isEmpty(deviceModel2)) {
            return 4102;
        }
        AppConfig.deviceInfo = deviceInfo3;
        return AppConfig.STATUS_SUCCESS;
    }

    @Override // com.laser.tsm.sdk.tsm.ITSMOperator
    public int installApplet(String str, String str2) {
        if (isParamsNull()) {
            return 100001;
        }
        this.mApduManager.requestOperApplet(1, str, str2);
        return this.mOperatorResult;
    }

    public boolean isDefaultCard(String str) {
        this.mApduManager.requestCurrentDefaultCard(str);
        if (TextUtils.isEmpty(this.mResponse) || TextUtils.isEmpty(this.mResSw) || !this.mResSw.equalsIgnoreCase("9000")) {
            return false;
        }
        String str2 = this.mResponse;
        String substring = str2.substring(str2.length() - 2, this.mResponse.length());
        LogUtil.d("TSMOperator", "flag:" + substring);
        return substring.equalsIgnoreCase("01");
    }

    @Override // com.laser.tsm.sdk.tsm.ITSMOperator
    public int keyUpdate(String str) {
        if (isParamsNull()) {
            return 100001;
        }
        if (str == null) {
            return RETURN_SSDAID_IS_NULL;
        }
        this.mApduManager.requestOperSSD(7, str, null, null);
        return this.mOperatorResult;
    }

    @Override // com.laser.tsm.sdk.tsm.ITSMOperator
    public int keyUpdateISD(String str) {
        if (isParamsNull()) {
            return 100001;
        }
        if (str == null) {
            return RETURN_SSDAID_IS_NULL;
        }
        this.mApduManager.requestOperSSD(9, str, null, null);
        return this.mOperatorResult;
    }

    @Override // com.laser.tsm.sdk.tsm.ITSMOperator
    public int lockApplet(String str, String str2) {
        if (isParamsNull()) {
            return 100001;
        }
        this.mApduManager.requestOperApplet(3, str, str2);
        return this.mOperatorResult;
    }

    @Override // com.laser.tsm.sdk.tsm.ITSMOperator
    public int lockISD(String str) {
        if (isParamsNull()) {
            return 100001;
        }
        if (str == null) {
            return RETURN_SSDAID_IS_NULL;
        }
        this.mApduManager.requestOperSSD(5, str, null, null);
        return this.mOperatorResult;
    }

    @Override // com.laser.tsm.sdk.tsm.ITSMOperator
    public int lockSE() {
        if (isParamsNull()) {
            return 100001;
        }
        this.mApduManager.requestOperSEState(51);
        return this.mOperatorResult;
    }

    @Override // com.laser.tsm.sdk.tsm.ITSMOperator
    public int lockSSD(String str) {
        if (isParamsNull()) {
            return 100001;
        }
        if (str == null) {
            return RETURN_SSDAID_IS_NULL;
        }
        this.mApduManager.requestOperSSD(3, str, null, null);
        return this.mOperatorResult;
    }

    @Override // com.laser.tsm.sdk.tsm.ITSMOperator
    public int notifyEseInfoSync() {
        if (isParamsNull()) {
            return 100001;
        }
        this.mApduManager.requestEseInfoSync();
        return this.mOperatorResult;
    }

    @Override // com.laser.tsm.sdk.tsm.ITSMOperator
    public int notifyInfoInit() {
        if (isParamsNull()) {
            return 100001;
        }
        this.mApduManager.requestInfoInit();
        return this.mOperatorResult;
    }

    @Override // com.laser.tsm.sdk.tsm.TSMOperatorResponse
    public void onOperFailure(int i10, Error error) {
        LogUtil.d("TSMOperator", "onOperFailure:" + error.getMessage());
        this.mResponse = null;
        this.mResSw = null;
        this.mOperatorResult = i10;
    }

    @Override // com.laser.tsm.sdk.tsm.TSMOperatorResponse
    public void onOperSuccess(Rapdu rapdu) {
        LogUtil.d("TSMOperator", "onOperSuccess");
        this.mOperatorResult = AppConfig.STATUS_SUCCESS;
        if (rapdu != null) {
            this.mResponse = rapdu.getRapdu();
            this.mResSw = rapdu.getSw();
            LogUtil.d("TSMOperator", "onOperSuccess:" + this.mResponse + ",sw:" + this.mResSw);
        }
    }

    @Override // com.laser.tsm.sdk.tsm.ITSMOperator
    public int personalApplet(String str, String str2) {
        if (isParamsNull()) {
            return 100001;
        }
        this.mApduManager.requestOperApplet(5, str, str2);
        return this.mOperatorResult;
    }

    public int requestSFKRecharge(int i10) {
        this.mApduManager.requestSFKRecharge(i10);
        if (TextUtils.isEmpty(this.mResSw) || !this.mResSw.equals("9000")) {
            return -1;
        }
        return AppConfig.STATUS_SUCCESS;
    }

    @Override // com.laser.tsm.sdk.tsm.ITSMOperator
    public boolean selectApplet(String str) {
        this.mApduManager.requestSelectApplet(str);
        return !TextUtils.isEmpty(this.mResSw) && "9000".equals(this.mResSw);
    }

    public void setIMobvoiTsmBluetoothInterfaceService(IMobvoiTsmBluetoothInterface iMobvoiTsmBluetoothInterface) {
        Objects.requireNonNull(iMobvoiTsmBluetoothInterface, "bluetoothInterfaceService is null");
        AppConfig.multiBluetoothInterfaceService = iMobvoiTsmBluetoothInterface;
    }

    public void setIMobvoiTsmSingleTransBluetoothInterfaceService(IMobvoiTsmSingleTransBluetoothInterface iMobvoiTsmSingleTransBluetoothInterface) {
        Objects.requireNonNull(iMobvoiTsmSingleTransBluetoothInterface, "bluetoothInterfaceService is null");
        AppConfig.singleluetoothInterfaceService = iMobvoiTsmSingleTransBluetoothInterface;
    }

    public void setRequestUrl(String str) {
        AppConfig.STREAMURL = str;
    }

    public void setReuqestTimeOut(int i10) {
        AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT = i10;
    }

    @Override // com.laser.tsm.sdk.tsm.ITSMOperator
    public BaseResponse<SsdAppStatusQueryForResp> ssdOrAppStatusQuery() {
        if (!isParamsNull()) {
            return this.mApduManager.requestSsdOrAppStatusQuery();
        }
        LogUtil.e("cplc is null");
        return null;
    }

    @Override // com.laser.tsm.sdk.tsm.ITSMOperator
    public int stopSE() {
        if (isParamsNull()) {
            return 100001;
        }
        this.mApduManager.requestOperSEState(55);
        return this.mOperatorResult;
    }

    @Override // com.laser.tsm.sdk.tsm.ITSMOperator
    public int unlockApplet(String str, String str2) {
        if (isParamsNull()) {
            return 100001;
        }
        this.mApduManager.requestOperApplet(4, str, str2);
        return this.mOperatorResult;
    }

    @Override // com.laser.tsm.sdk.tsm.ITSMOperator
    public int unlockISD(String str) {
        if (isParamsNull()) {
            return 100001;
        }
        if (str == null) {
            return RETURN_SSDAID_IS_NULL;
        }
        this.mApduManager.requestOperSSD(6, str, null, null);
        return this.mOperatorResult;
    }

    @Override // com.laser.tsm.sdk.tsm.ITSMOperator
    public int unlockISD_Q(String str) {
        if (isParamsNull()) {
            return 100001;
        }
        if (str == null) {
            return RETURN_SSDAID_IS_NULL;
        }
        this.mApduManager.requestOperSSD(8, str, null, null);
        return this.mOperatorResult;
    }

    @Override // com.laser.tsm.sdk.tsm.ITSMOperator
    public int unlockSE() {
        if (isParamsNull()) {
            return 100001;
        }
        this.mApduManager.requestOperSEState(52);
        return this.mOperatorResult;
    }

    @Override // com.laser.tsm.sdk.tsm.ITSMOperator
    public int unlockSSD(String str) {
        if (isParamsNull()) {
            return 100001;
        }
        if (str == null) {
            return RETURN_SSDAID_IS_NULL;
        }
        this.mApduManager.requestOperSSD(4, str, null, null);
        return this.mOperatorResult;
    }
}
