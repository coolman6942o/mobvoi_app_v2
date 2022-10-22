package com.laser.tsm.sdk.apdu;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.JsonSyntaxException;
import com.google.gson.e;
import com.google.gson.reflect.a;
import com.laser.tsm.sdk.AppConfig;
import com.laser.tsm.sdk.bean.Capdu;
import com.laser.tsm.sdk.bean.Rapdu;
import com.laser.tsm.sdk.business.ApduResBean;
import com.laser.tsm.sdk.business.BaseBusinessForResp;
import com.laser.tsm.sdk.business.BaseResponse;
import com.laser.tsm.sdk.business.SsdAppStatusQueryForResp;
import com.laser.tsm.sdk.http.AsyncHttpClient;
import com.laser.tsm.sdk.http.SimpleResponseHandler;
import com.laser.tsm.sdk.oma.SmartCard;
import com.laser.tsm.sdk.tsm.IMobvoiTsmBluetoothInterface;
import com.laser.tsm.sdk.tsm.TSMOperator;
import com.laser.tsm.sdk.tsm.TSMOperatorResponse;
import com.laser.tsm.sdk.util.AppJsonUtil;
import com.laser.tsm.sdk.util.DataConvertUtil;
import com.laser.tsm.sdk.util.LogUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.entity.StringEntity;
/* loaded from: classes2.dex */
public class ApduManager extends SimpleResponseHandler {
    private static final int BUSINESS_TYPE_ACTIVATE = 35;
    private static final int BUSINESS_TYPE_APPLETOPER = 30;
    private static final int BUSINESS_TYPE_APPLET_LIST = 28;
    private static final int BUSINESS_TYPE_APPLY_PAMID = 40;
    private static final int BUSINESS_TYPE_GPACOPER = 32;
    private static final int BUSINESS_TYPE_INFOINIT = 34;
    private static final int BUSINESS_TYPE_INFOSYNC = 33;
    private static final int BUSINESS_TYPE_OPER_SESTATE = 50;
    private static final int BUSINESS_TYPE_SE_STATUS_QUERY = 37;
    private static final int BUSINESS_TYPE_SSDOPER = 31;
    private static final int BUSINESS_TYPE_STATUS_QUERY = 36;
    public static int IS_LOCAL = 0;
    public static int OPEN_AID_FALG = 0;
    public static final int SEND_TYPE_FIRST = 1;
    public static final int SEND_TYPE_NEXT = 2;
    private static final String TAG = "ApduManager";
    private ApduRequest mApduRequest;
    private AsyncHttpClient mAsyncHttpClient;
    private Context mContext;
    private String mReponseString;
    private TSMOperatorResponse mTsmOperatorResponse;
    private int mCurrentTaskIndex = 1;
    private int mBusinessType = -1;
    private boolean mIsLocalMultiExe = false;
    private Rapdu mLocalRapdu = null;
    private Error mSmartCardError = null;
    public EnumDeviceType mDeviceType = EnumDeviceType.DEVICE_TYPE_MOBILE;
    private boolean mIsCancelRequest = false;
    private boolean mIsCancelLocalMultiExe = false;
    private String mResponseString = null;
    private String mRequestUrl = "";
    private ApduResponseHandler mApduResponseHandler = new ApduResponseHandler() { // from class: com.laser.tsm.sdk.apdu.ApduManager.1
        @Override // com.laser.tsm.sdk.apdu.ApduResponseHandler
        public void OnSendNextError(int i10, List<Rapdu> list, Error error) {
            if (ApduManager.this.mIsLocalMultiExe) {
                if (list != null && list.size() > 0) {
                    ApduManager.this.mLocalRapdu = list.get(0);
                }
                ApduManager.this.mIsLocalMultiExe = false;
                return;
            }
            ApduManager.access$508(ApduManager.this);
            ApduManager.this.mSmartCardError = error;
            Rapdu rapdu = list.get(list.size() - 1);
            ApduManager.this.sendNextApdu(0, rapdu.getIndex(), rapdu.getRapdu(), rapdu.getSw());
        }

        @Override // com.laser.tsm.sdk.apdu.ApduResponseHandler
        public void onFailure(int i10, Error error) {
            ApduManager.this.clearData();
            if (ApduManager.this.mTsmOperatorResponse != null) {
                ApduManager.this.mTsmOperatorResponse.onOperFailure(i10, error);
            }
        }

        @Override // com.laser.tsm.sdk.apdu.ApduResponseHandler
        public void onSendNext(int i10, List<Rapdu> list) {
            if (ApduManager.this.mIsLocalMultiExe) {
                if (list != null && list.size() > 0 && !ApduManager.this.mIsCancelLocalMultiExe) {
                    ApduManager.this.mLocalRapdu = list.get(0);
                }
                ApduManager.this.mIsLocalMultiExe = false;
                return;
            }
            ApduManager.access$508(ApduManager.this);
            Rapdu rapdu = list.get(list.size() - 1);
            ApduManager.this.sendNextApdu(0, rapdu.getIndex(), rapdu.getRapdu(), rapdu.getSw());
        }

        @Override // com.laser.tsm.sdk.apdu.ApduResponseHandler
        public void onSuccess(Rapdu rapdu) {
            ApduManager.this.clearData();
            if (ApduManager.this.mTsmOperatorResponse != null) {
                ApduManager.this.mTsmOperatorResponse.onOperSuccess(rapdu);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.laser.tsm.sdk.apdu.ApduManager$4  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$laser$tsm$sdk$apdu$EnumDeviceType;

        static {
            int[] iArr = new int[EnumDeviceType.values().length];
            $SwitchMap$com$laser$tsm$sdk$apdu$EnumDeviceType = iArr;
            try {
                iArr[EnumDeviceType.DEVICE_TYPE_MOBILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$laser$tsm$sdk$apdu$EnumDeviceType[EnumDeviceType.DEVICE_TYPE_MULTI_BLUETOOTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$laser$tsm$sdk$apdu$EnumDeviceType[EnumDeviceType.DEVICE_TYPE_BLUETOOTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public ApduManager(Context context, EnumDeviceType enumDeviceType) {
        init(context, enumDeviceType);
    }

    static /* synthetic */ int access$508(ApduManager apduManager) {
        int i10 = apduManager.mCurrentTaskIndex;
        apduManager.mCurrentTaskIndex = i10 + 1;
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearData() {
        this.mRequestUrl = AppConfig.STREAMURL_BETA;
        this.mCurrentTaskIndex = 1;
        this.mBusinessType = -1;
        this.mResponseString = null;
        this.mIsCancelRequest = false;
        this.mIsCancelLocalMultiExe = false;
        try {
            int i10 = AnonymousClass4.$SwitchMap$com$laser$tsm$sdk$apdu$EnumDeviceType[this.mDeviceType.ordinal()];
            if (i10 == 1) {
                SmartCard.getInstance().closeService();
            } else if (i10 == 2) {
                IMobvoiTsmBluetoothInterface iMobvoiTsmBluetoothInterface = AppConfig.multiBluetoothInterfaceService;
                if (iMobvoiTsmBluetoothInterface != null) {
                    iMobvoiTsmBluetoothInterface.closeSEChannel();
                }
            } else if (i10 == 3) {
                AppConfig.singleluetoothInterfaceService.closeSEChannel();
            }
        } catch (Exception unused) {
        }
    }

    private String getSelectApdu(String str) {
        String hexString;
        return "00A40400" + ("00".substring(0, 2 - hexString.length()) + Integer.toHexString(str.length() / 2)) + str;
    }

    private void init(Context context, EnumDeviceType enumDeviceType) {
        this.mContext = context;
        this.mAsyncHttpClient = new AsyncHttpClient(true);
        setDeviceType(enumDeviceType);
    }

    private void sendApduToSE(String str) {
        BaseResponse baseResponse;
        if (this.mIsCancelRequest) {
            this.mApduResponseHandler.sendFailureMessage(-1, new Error("execute apdu interrupt"));
            this.mIsCancelRequest = false;
        } else if (this.mResponseString == null) {
            this.mApduResponseHandler.sendFailureMessage(4096, new Error("server response str is null"));
        } else {
            LogUtil.i(TAG, "response:" + this.mResponseString);
            try {
                baseResponse = (BaseResponse) new e().k(this.mResponseString, new a<BaseResponse<BaseBusinessForResp>>() { // from class: com.laser.tsm.sdk.apdu.ApduManager.2
                }.getType());
            } catch (JsonSyntaxException unused) {
                this.mApduResponseHandler.sendFailureMessage(TSMOperator.RETURN_RESPONSE_PARSE_ERROR, new Error("response data parse failure"));
                baseResponse = null;
            }
            if (baseResponse == null) {
                this.mApduResponseHandler.sendFailureMessage(4097, new Error("server response parser error, respInfo obj is null"));
                return;
            }
            int operationResult = ((BaseBusinessForResp) baseResponse.getBusiness()).getOperationResult();
            LogUtil.i(TAG, "response status:" + operationResult);
            if (100000 != operationResult) {
                Error error = this.mSmartCardError;
                if (error != null) {
                    this.mApduResponseHandler.sendFailureMessage(4098, error);
                    this.mSmartCardError = null;
                    return;
                }
                this.mApduResponseHandler.sendFailureMessage(((BaseBusinessForResp) baseResponse.getBusiness()).getOperationResult(), new Error("server requested process error"));
                return;
            }
            BaseBusinessForResp baseBusinessForResp = (BaseBusinessForResp) baseResponse.getBusiness();
            LogUtil.i(TAG, "response finishFlag:" + baseBusinessForResp.getFinishFlag());
            if (baseBusinessForResp.getFinishFlag() == 0) {
                this.mApduResponseHandler.sendSuccessMessage(null);
                return;
            }
            this.mIsLocalMultiExe = false;
            LogUtil.i(TAG, "response capdus:" + baseBusinessForResp.getCapdus());
            this.mApduRequest.setCapduList(baseBusinessForResp.getCapdus());
            this.mApduRequest.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendNextApdu(int i10, int i11, String str, String str2) {
        ApduResBean apduResBean = new ApduResBean();
        apduResBean.setIndex(i11);
        apduResBean.setApdu(str);
        apduResBean.setSw(str2);
        sendRequestToServer(AppJsonUtil.getReqNextJsonResult(this.mBusinessType, apduResBean, i10, this.mCurrentTaskIndex));
        sendApduToSE(null);
    }

    private void sendRequestToServer(String str) {
        if (str != null) {
            if (this.mIsCancelRequest) {
                this.mApduResponseHandler.sendFailureMessage(-1, new Error("request server failure"));
                this.mIsCancelRequest = false;
                return;
            }
            if (TextUtils.isEmpty(AppConfig.STREAMURL)) {
                this.mRequestUrl = AppConfig.STREAMURL_BETA;
            } else {
                this.mRequestUrl = AppConfig.STREAMURL;
            }
            LogUtil.d("request url:" + AppConfig.STREAMURL);
            LogUtil.d("reqeust content:" + str);
            try {
                this.mAsyncHttpClient.post(this.mContext, this.mRequestUrl, new StringEntity(str, "UTF-8"), "text/json", this);
            } catch (UnsupportedEncodingException unused) {
            }
        }
    }

    @Override // com.laser.tsm.sdk.http.SimpleResponseHandler
    public void OnFailure(String str, Throwable th2) {
        this.mResponseString = null;
    }

    @Override // com.laser.tsm.sdk.http.SimpleResponseHandler
    public void onSuccess(String str) {
        this.mResponseString = str;
    }

    public void requestActivateApplet(String str) {
        this.mApduRequest.isGetLocalData(true);
        String[] strArr = {AppConfig.APDU_SELECT_CRS, AppConfig.getAppletOperCommand((byte) 1, str)};
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < 2; i10++) {
            arrayList.add(new Capdu(i10, strArr[i10], new String[]{"9000"}));
        }
        this.mApduRequest.setCapduList(arrayList);
        this.mApduRequest.run();
    }

    public void requestApplyPAMID() {
        this.mBusinessType = 40;
        sendRequestToServer(AppJsonUtil.getBaseReqInfo(40));
        sendApduToSE(null);
    }

    public void requestCurrentDefaultCard(String str) {
        this.mApduRequest.isGetLocalData(true);
        String[] strArr = {AppConfig.APDU_SELECT_CRS, AppConfig.getDefaultAppletCommand(str)};
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < 2; i10++) {
            arrayList.add(new Capdu(i10, strArr[i10], new String[]{"9000"}));
        }
        this.mApduRequest.setCapduList(arrayList);
        this.mApduRequest.run();
    }

    public void requestDeactivateApplet(String str) {
        this.mApduRequest.isGetLocalData(true);
        String[] strArr = {AppConfig.APDU_SELECT_CRS, AppConfig.getAppletOperCommand((byte) 0, str)};
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < 2; i10++) {
            arrayList.add(new Capdu(i10, strArr[i10], new String[]{"9000"}));
        }
        this.mApduRequest.setCapduList(arrayList);
        this.mApduRequest.run();
    }

    public void requestEseInfoSync() {
        this.mIsCancelRequest = false;
        this.mBusinessType = 33;
        sendRequestToServer(AppJsonUtil.getBaseReqJsonResult(33, this.mCurrentTaskIndex));
        sendApduToSE(null);
    }

    public void requestGetCIN() {
        this.mApduRequest.isGetLocalData(true);
        String[] strArr = {AppConfig.APDU_SELECT, AppConfig.APDU_GETCIN};
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < 2; i10++) {
            arrayList.add(new Capdu(i10, strArr[i10], new String[]{"9000"}));
        }
        this.mApduRequest.setCapduList(arrayList);
        this.mApduRequest.run();
    }

    public void requestGetCPLC() {
        this.mApduRequest.isGetLocalData(true);
        String[] strArr = {AppConfig.APDU_SELECT, AppConfig.APDU_GETCPLC};
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < 2; i10++) {
            arrayList.add(new Capdu(i10, strArr[i10], new String[]{"9000"}));
        }
        this.mApduRequest.setCapduList(arrayList);
        this.mApduRequest.run();
    }

    public void requestGetIIN() {
        this.mApduRequest.isGetLocalData(true);
        String[] strArr = {AppConfig.APDU_SELECT, AppConfig.APDU_GETIIN};
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < 2; i10++) {
            arrayList.add(new Capdu(i10, strArr[i10], new String[]{"9000"}));
        }
        this.mApduRequest.setCapduList(arrayList);
        this.mApduRequest.run();
    }

    public void requestGetSFKBalance() {
        this.mApduRequest.isGetLocalData(true);
        String[] strArr = {AppConfig.SFK_APPLET_SELECT, AppConfig.SFK_BALANCE_COMMAND};
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < 2; i10++) {
            arrayList.add(new Capdu(i10, strArr[i10], new String[]{"9000"}));
        }
        this.mApduRequest.setCapduList(arrayList);
        this.mApduRequest.run();
    }

    public void requestInfoInit() {
        this.mIsCancelRequest = false;
        this.mBusinessType = 34;
        sendRequestToServer(AppJsonUtil.getBaseReqJsonResult(34, this.mCurrentTaskIndex));
        sendApduToSE(null);
    }

    public void requestOperApplet(int i10, String str, String str2) {
        this.mBusinessType = 30;
        sendRequestToServer(AppJsonUtil.getOperAppletJsonResult(30, i10, str, str2, this.mCurrentTaskIndex));
        sendApduToSE(null);
    }

    public void requestOperGPAC(int i10, String str) {
        this.mBusinessType = 32;
        sendRequestToServer(AppJsonUtil.getOperGPACJsonResult(32, i10, str, this.mCurrentTaskIndex));
        sendApduToSE(null);
    }

    public void requestOperSEState(int i10) {
        this.mBusinessType = 50;
        sendRequestToServer(AppJsonUtil.getSEStateOperReqInfo(50, i10));
        sendApduToSE(null);
    }

    public void requestOperSSD(int i10, String str, String str2, String str3) {
        this.mBusinessType = 31;
        sendRequestToServer(AppJsonUtil.getOperSSDJsonResult(31, i10, str, str2, str3, this.mCurrentTaskIndex));
        sendApduToSE(null);
    }

    public void requestSFKRecharge(int i10) {
        this.mApduRequest.isGetLocalData(true);
        String hexString = Integer.toHexString(i10);
        if (hexString.length() == 1) {
            hexString = "0" + hexString;
        }
        String[] strArr = {AppConfig.SFK_APPLET_SELECT, AppConfig.getRechargeCommand(DataConvertUtil.hexStringToBytes(hexString + AppConfig.getCurrentTime()))};
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < 2; i11++) {
            arrayList.add(new Capdu(i11, strArr[i11], new String[]{"9000"}));
        }
        this.mApduRequest.setCapduList(arrayList);
        this.mApduRequest.run();
    }

    public void requestSelectApplet(String str) {
        this.mApduRequest.isGetLocalData(true);
        this.mApduRequest.setCapdu(new Capdu(0, getSelectApdu(str), new String[]{"9000"}));
        this.mApduRequest.run();
    }

    public BaseResponse<SsdAppStatusQueryForResp> requestSsdOrAppStatusQuery() {
        this.mBusinessType = 36;
        sendRequestToServer(AppJsonUtil.getBaseReqInfo(36));
        if (this.mReponseString != null) {
            return (BaseResponse) new e().k(this.mReponseString, new a<BaseResponse<SsdAppStatusQueryForResp>>() { // from class: com.laser.tsm.sdk.apdu.ApduManager.3
            }.getType());
        }
        return null;
    }

    protected void setDeviceType(EnumDeviceType enumDeviceType) {
        this.mDeviceType = enumDeviceType;
        int i10 = AnonymousClass4.$SwitchMap$com$laser$tsm$sdk$apdu$EnumDeviceType[enumDeviceType.ordinal()];
        if (i10 == 1) {
            this.mApduRequest = new ApduSmartCardRequest(this.mContext, this.mApduResponseHandler);
        } else if (i10 == 2) {
            this.mApduRequest = new MultiApduBluetoothRequest(this.mContext, this.mApduResponseHandler);
        } else if (i10 == 3) {
            this.mApduRequest = new ApduBluetoothRequest(this.mContext, this.mApduResponseHandler);
        }
    }

    public void setTsmOperatorResponse(TSMOperatorResponse tSMOperatorResponse) {
        this.mTsmOperatorResponse = tSMOperatorResponse;
    }
}
