package com.laser.tsm.sdk.apdu;

import android.content.Context;
import android.text.TextUtils;
import com.laser.tsm.sdk.bean.Capdu;
import com.laser.tsm.sdk.bean.Rapdu;
import com.laser.tsm.sdk.oma.EnumReaderType;
import com.laser.tsm.sdk.oma.SmartCard;
import com.laser.tsm.sdk.oma.SmartCardCallback;
import com.laser.tsm.sdk.util.LogUtil;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
/* loaded from: classes2.dex */
public class ApduSmartCardRequest extends ApduRequest implements SmartCardCallback {
    private static final String TAG = "ApduSmartCardRequest";
    private String mRapduTemp = null;

    public ApduSmartCardRequest(Context context, ApduResponseHandler apduResponseHandler) {
        super(context, apduResponseHandler);
    }

    @Override // com.laser.tsm.sdk.apdu.ApduRequest
    protected void executeApdu() {
        List<Capdu> list = this.mCapduList;
        if (list == null || list.size() == 0) {
            LogUtil.e("capdu list is null");
        } else if (this.mCurrentExecuteIndex >= this.mCapduList.size()) {
            LogUtil.e(TAG, "the last capdu has executed ,no more capdu need to execute");
        } else {
            Capdu capdu = this.mCapduList.get(this.mCurrentExecuteIndex);
            this.mCurrentExecuteApduBean = capdu;
            String apdu = capdu.getApdu();
            LogUtil.d(TAG, "start execute apdu index:" + this.mCurrentExecuteIndex + "==apdu:" + apdu);
            SmartCard.getInstance().setReaderType(EnumReaderType.READER_TYPE_ESE);
            SmartCard.getInstance().setSmartCardCallBack(this).execute(this.mContext, apdu);
        }
    }

    @Override // com.laser.tsm.sdk.oma.SmartCardCallback
    public void onOperFailure(Error error) {
        if (this.mIsGetLocalData) {
            sendFailureMessage(4098, error);
            return;
        }
        createRapduBean(this.mCurrentExecuteApduBean.getIndex(), "", "");
        sendErrorMessage(1, error);
    }

    @Override // com.laser.tsm.sdk.oma.SmartCardCallback
    public void onOperSuccess(String str) {
        String str2;
        LogUtil.d(TAG, "handle apdu response:" + str);
        if (str == null || str.length() <= 4) {
            str2 = "";
        } else {
            str = str.substring(str.length() - 4, str.length());
            str2 = str.substring(0, str.length() - 4).toUpperCase(Locale.getDefault());
        }
        if (str != null) {
            str = str.toUpperCase(Locale.getDefault());
        }
        LogUtil.d(TAG, "get response res_sw:" + str);
        if (str.startsWith("6C") && str.length() == 4) {
            String substring = str.substring(2, 4);
            String apdu = this.mCapduList.get(this.mCurrentExecuteIndex).getApdu();
            this.mCapduList.get(this.mCurrentExecuteIndex).setApdu(apdu.substring(0, apdu.length() - 2) + substring);
            executeApdu();
        } else if (str.startsWith("61")) {
            this.mRapduTemp += str2;
            this.mCapduList.get(this.mCurrentExecuteIndex).setApdu("00C00000" + str.substring(str.length() - 2, str.length()));
            executeApdu();
        } else {
            if (!TextUtils.isEmpty(this.mRapduTemp)) {
                str2 = this.mRapduTemp + str2;
                this.mRapduTemp = "";
            }
            createRapduBean(this.mCurrentExecuteApduBean.getIndex(), str2, str);
            String[] sw = this.mCurrentExecuteApduBean.getSw();
            if (sw == null || sw.length <= 0 || Arrays.asList(sw).contains(str)) {
                if (this.mCurrentExecuteIndex < this.mCapduList.size() - 1) {
                    this.mCurrentExecuteIndex++;
                    executeApdu();
                } else if (this.mIsGetLocalData) {
                    List<Rapdu> list = this.mRapduList;
                    sendSuccessMessage(list.get(list.size() - 1));
                } else {
                    sendMessage(0);
                }
            } else if (this.mIsGetLocalData) {
                sendFailureMessage(4098, new Error("Execute apdu failure"));
            } else {
                sendMessage(1);
            }
        }
    }
}
