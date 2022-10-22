package com.laser.tsm.sdk.oma;

import android.text.TextUtils;
import com.laser.tsm.sdk.util.DataConvertUtil;
import com.laser.tsm.sdk.util.LogUtil;
import java.io.IOException;
import org.simalliance.openmobileapi.Channel;
import org.simalliance.openmobileapi.Reader;
import org.simalliance.openmobileapi.SEService;
import org.simalliance.openmobileapi.Session;
/* loaded from: classes2.dex */
class SmartCardRequest implements Runnable {
    private static final String TAG = "SmartCardRequest";
    private SmartCardCallback mCallback;
    private Channel mChannel;
    private SEService mSEService;
    private Session mSession;
    private String mReuqestCommand = null;
    private EnumReaderType mEnumReaderType = EnumReaderType.READER_TYPE_ESE;

    /* JADX INFO: Access modifiers changed from: protected */
    public SmartCardRequest(SEService sEService) {
        this.mSEService = sEService;
    }

    private synchronized void executeApduCmd() throws IOException, Exception {
        if (!TextUtils.isEmpty(this.mReuqestCommand) && this.mReuqestCommand.length() >= 6) {
            if ("00A404".equalsIgnoreCase(this.mReuqestCommand.substring(0, 6))) {
                closeChannelAndSession();
                int parseInt = Integer.parseInt(this.mReuqestCommand.substring(8, 10), 16);
                String str = this.mReuqestCommand;
                if (openCurrentAvailableChannel(str.substring(str.length() - (parseInt * 2), this.mReuqestCommand.length()))) {
                    String bytesToHexString = DataConvertUtil.bytesToHexString(this.mChannel.getSelectResponse());
                    LogUtil.i(TAG, "执行APDU:" + this.mReuqestCommand + "，返回的RAPDU为：" + bytesToHexString);
                    operSuccess(bytesToHexString);
                } else {
                    operFailure("Open channal failure");
                }
                return;
            }
            byte[] hexStringToBytes = DataConvertUtil.hexStringToBytes(this.mReuqestCommand);
            Channel channel = this.mChannel;
            if (channel != null) {
                String bytesToHexString2 = DataConvertUtil.bytesToHexString(channel.transmit(hexStringToBytes));
                LogUtil.i(TAG, "执行APDU:" + this.mReuqestCommand + "，返回的RAPDU为：" + bytesToHexString2);
                operSuccess(bytesToHexString2);
            } else {
                operFailure("Channal is not open");
            }
            return;
        }
        operFailure("Command is null or length is not enough");
    }

    private Reader getCurrentAvailableReader() {
        Reader[] readers = this.mSEService.getReaders();
        if (readers == null || readers.length < 1) {
            operFailure("Your devices not support any reader");
            return null;
        }
        for (Reader reader : readers) {
            LogUtil.d(TAG, "reader name:" + reader.getName());
            if (reader.getName().startsWith(this.mEnumReaderType.getValue())) {
                return reader;
            }
        }
        return null;
    }

    private boolean openCurrentAvailableChannel(String str) throws IOException, SecurityException {
        Reader currentAvailableReader = getCurrentAvailableReader();
        if (currentAvailableReader == null) {
            LogUtil.e(TAG, "Choose reader not exist");
            return false;
        } else if (!currentAvailableReader.isSecureElementPresent()) {
            LogUtil.e(TAG, "Choose reader can not use");
            return false;
        } else {
            this.mSession = currentAvailableReader.openSession();
            byte[] hexStringToBytes = DataConvertUtil.hexStringToBytes(str);
            LogUtil.i(TAG, "打开通道的Aid：" + str);
            Session session = this.mSession;
            if (session != null) {
                this.mChannel = session.openLogicalChannel(hexStringToBytes);
            }
            return this.mChannel != null;
        }
    }

    private void operFailure(String str) {
        LogUtil.e(TAG, str);
        if (this.mCallback != null) {
            this.mCallback.onOperFailure(new Error(str));
        }
    }

    private void operSuccess(String str) {
        SmartCardCallback smartCardCallback = this.mCallback;
        if (smartCardCallback != null) {
            smartCardCallback.onOperSuccess(str);
        }
    }

    public void closeChannelAndSession() {
        try {
            Channel channel = this.mChannel;
            if (channel != null && !channel.isClosed()) {
                this.mChannel.close();
                this.mChannel = null;
                LogUtil.i(TAG, "Channel正常关闭");
            }
        } catch (Exception e10) {
            LogUtil.e(TAG, "Channel关闭异常" + e10.getMessage());
        }
        try {
            Session session = this.mSession;
            if (session != null && !session.isClosed()) {
                this.mSession.close();
                this.mSession = null;
                LogUtil.i(TAG, "Session正常关闭");
            }
        } catch (Exception e11) {
            LogUtil.e(TAG, "Session关闭异常" + e11.getMessage());
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            executeApduCmd();
        } catch (Exception e10) {
            e10.printStackTrace();
            operFailure("Execute apdu error：" + e10.getMessage());
        }
    }

    public void setReaderType(EnumReaderType enumReaderType) {
        this.mEnumReaderType = enumReaderType;
    }

    public void setRequestCommand(String str) {
        this.mReuqestCommand = str;
    }

    public void setSmartCardCallback(SmartCardCallback smartCardCallback) {
        this.mCallback = smartCardCallback;
    }
}
