package oa;

import com.huawei.agconnect.exception.AGCServerException;
import com.realsil.sdk.dfu.DfuException;
/* compiled from: CommandUtil.kt */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f31487a = new d();

    private d() {
    }

    public final String a(int i10) {
        if (i10 == 1) {
            return "短消息测试";
        }
        if (i10 == 2) {
            return "长消息测试";
        }
        if (i10 == 3) {
            return "eSIM专用请求网络数据";
        }
        if (i10 == 4) {
            return "eSIM专用返回网络数据";
        }
        if (i10 == 16) {
            return "返回AGPS请求结果";
        }
        if (i10 == 17) {
            return "同步经纬度";
        }
        if (i10 == 320) {
            return "找手机开始";
        }
        if (i10 == 321) {
            return "找手机停止";
        }
        if (i10 == 336) {
            return "请求EID";
        }
        if (i10 == 337) {
            return "开始下载Profile";
        }
        if (i10 == 352) {
            return "同步VPA信息";
        }
        if (i10 == 353) {
            return "同步dataSource";
        }
        switch (i10) {
            case 6:
                return "打开经典蓝牙";
            case 7:
                return "请求网络数据";
            case 8:
                return "返回网络数据";
            case 9:
                return "请求AGPS数据";
            default:
                switch (i10) {
                    case 33:
                        return "验证BLE连接结果";
                    case DfuException.ERROR_READ_PATCH_INFO_ERROR /* 272 */:
                        return "发送通知";
                    case 304:
                        return "请求电量";
                    case 368:
                        return "查询手表版本号";
                    case 377:
                        return "手表请求天气";
                    case AGCServerException.AUTHENTICATION_INVALID /* 400 */:
                        return "准备OTA包信息";
                    case AGCServerException.TOKEN_INVALID /* 401 */:
                        return "已接收OTA信息";
                    case 402:
                        return "发送OTA包文件";
                    case AGCServerException.AUTHENTICATION_FAILED /* 403 */:
                        return "反馈OTA接收进度";
                    case 404:
                        return "手表开始升级";
                    case 516:
                        return "添加联系人";
                    case 528:
                        return "手表请求同步运动数据";
                    case 530:
                        return "同步运动数据";
                    case 532:
                        return "运动数据校验结果";
                    case 560:
                        return "同步健康数据";
                    case 561:
                        return "同步健康数据响应";
                    case 1280:
                        return "获取设备信息";
                    case 1281:
                        return "执行单条 APDU 命令";
                    case 1282:
                        return "获取安全芯片的 CPLC";
                    case 1283:
                        return "激活安全芯片中的 applet";
                    case 1284:
                        return "获取当前激活的 applet 的 id";
                    case 1285:
                        return "同步门禁卡数据";
                    case 1286:
                        return "读取要复制的门禁卡信息";
                    case 1287:
                        return "接收手表返回读门禁卡信息";
                    case 1288:
                        return "手表拉取门禁卡";
                    case 1296:
                        return "执行多条 APDU 命令";
                    case 1297:
                        return "进入开卡操作界面";
                    case 1298:
                        return "退出开卡操作界面";
                    default:
                        switch (i10) {
                            case 256:
                                return "准备切换表盘";
                            case DfuException.ERROR_FILE_IO_EXCEPTION /* 257 */:
                                return "手表是否进入切表盘状态";
                            case DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED /* 258 */:
                                return "发送表盘数据";
                            case DfuException.ERROR_LOCK_WAIT_INTERRUPTED /* 259 */:
                                return "手表已接收表盘数据";
                            default:
                                switch (i10) {
                                    case 288:
                                        return "开始/暂停播放";
                                    case 289:
                                        return "停止播放";
                                    case 290:
                                        return "上一首";
                                    case 291:
                                        return "下一首";
                                    default:
                                        switch (i10) {
                                            case 384:
                                                return "同步天气";
                                            case 385:
                                                return "发送短信";
                                            case 386:
                                                return "回复短信";
                                            case 387:
                                                return "短信 新消息";
                                            default:
                                                return "未知";
                                        }
                                }
                        }
                }
        }
    }
}
