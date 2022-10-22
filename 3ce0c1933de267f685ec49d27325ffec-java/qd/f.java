package qd;

import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import cn.com.fmsh.tsm.business.bean.BusinessOrder;
import cn.com.fmsh.tsm.business.bean.CardAppRecord;
import cn.com.fmsh.tsm.business.enums.EnumBusinessOrderType;
import cn.com.fmsh.tsm.business.enums.EnumCardAppType;
import cn.com.fmsh.tsm.business.enums.EnumOrderStatus;
import cn.com.fmsh.tsm.business.enums.EnumTradeType;
import com.amap.api.services.core.AMapException;
import com.bjleisen.iface.sdk.apdu.LeisenIfaceConfig;
import com.bjleisen.iface.sdk.apdu.LeisenIfaceOperator;
import com.bjleisen.iface.sdk.bean.Applet;
import com.bjleisen.iface.sdk.bean.BusinessOrderInfo;
import com.bjleisen.iface.sdk.bean.resp.AppletListBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.BJTCardInfo;
import com.bjleisen.iface.sdk.bean.resp.OrderListBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.RespInfo;
import com.bjleisen.iface.sdk.enums.EnumCardAppStatus;
import com.laser.tsm.sdk.AppConfig;
import com.laser.tsm.sdk.tsm.TSMOperator;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.q;
import com.mobvoi.android.common.utils.s;
import com.mobvoi.companion.ticpay.buscard.CardInfo;
import com.mobvoi.companion.ticpay.buscard.TradeInfo;
import com.mobvoi.wear.common.base.WearPath;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import sd.c;
import sd.e;
/* compiled from: PaymentHandler.java */
/* loaded from: classes2.dex */
public class f {

    /* renamed from: d  reason: collision with root package name */
    public static final SimpleDateFormat f32946d = new SimpleDateFormat(LeisenIfaceConfig.CARD_DATE_FORMAT);

    /* renamed from: e  reason: collision with root package name */
    private static final f f32947e = new f();

    /* renamed from: a  reason: collision with root package name */
    private HandlerThread f32948a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f32949b;

    /* renamed from: c  reason: collision with root package name */
    private Handler.Callback f32950c = new a();

    /* compiled from: PaymentHandler.java */
    /* loaded from: classes2.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.arg1;
            if (i10 == 1) {
                f.this.m(message);
            } else if (i10 == 2) {
                f.this.l(message);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PaymentHandler.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32952a;

        static {
            int[] iArr = new int[EnumTradeType.values().length];
            f32952a = iArr;
            try {
                iArr[EnumTradeType.recharge.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32952a[EnumTradeType.onlineRecharge.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private f() {
    }

    private void c(LeisenIfaceOperator leisenIfaceOperator, sd.b bVar, List<sd.a> list, String str) {
        List<BusinessOrderInfo> orderInfoList;
        RespInfo<OrderListBusiRespInfo> queryBusinessOrderLists = leisenIfaceOperator.queryBusinessOrderLists(str, 2, 1000, 1);
        if (queryBusinessOrderLists != null) {
            k.c("PaymentHandler", "query %s abnormal order status = %d, desc = %s", str, Integer.valueOf(queryBusinessOrderLists.getStatus()), queryBusinessOrderLists.getDesc());
            OrderListBusiRespInfo busiRespInfo = queryBusinessOrderLists.getBusiRespInfo();
            if (!(busiRespInfo == null || (orderInfoList = busiRespInfo.getOrderInfoList()) == null)) {
                for (BusinessOrderInfo businessOrderInfo : orderInfoList) {
                    sd.a aVar = new sd.a();
                    aVar.f34378a = str;
                    aVar.f34379b = bVar.e(str);
                    aVar.f34381d = businessOrderInfo.getOrderTime();
                    aVar.f34385h = businessOrderInfo.getOrderType();
                    aVar.f34380c = businessOrderInfo.getOrderId();
                    aVar.f34382e = businessOrderInfo.getPayMoney();
                    aVar.f34383f = businessOrderInfo.getOrderMoney();
                    aVar.f34384g = businessOrderInfo.getPayWay();
                    list.add(aVar);
                    k.a("PaymentHandler", String.valueOf(aVar));
                }
            }
        }
    }

    private CardInfo d(LeisenIfaceOperator leisenIfaceOperator, CardInfo cardInfo, String str) {
        String str2 = null;
        if (cardInfo == null) {
            return null;
        }
        String cardNum = cardInfo.getCardNum();
        if (TextUtils.isEmpty(cardNum)) {
            k.a("PaymentHandler", "card is invalid.");
            return cardInfo;
        } else if (cardNum.length() == 20) {
            k.a("PaymentHandler", "The card number no need to convert.");
            return cardInfo;
        } else {
            sd.b h10 = sd.b.h();
            Application e10 = com.mobvoi.android.common.utils.b.e();
            String d10 = q.d(e10, WearPath.TicPay.PAY, h10.d(str), null);
            if (TextUtils.isEmpty(d10) || !d10.startsWith(cardNum)) {
                RespInfo<BJTCardInfo> queryBJTCardNum = leisenIfaceOperator.queryBJTCardNum(str);
                if (!(queryBJTCardNum == null || queryBJTCardNum.getBusiRespInfo() == null)) {
                    str2 = queryBJTCardNum.getBusiRespInfo().getCardNo();
                }
                if (TextUtils.isEmpty(str2)) {
                    k.a("PaymentHandler", "get bjt or bjht card number error.");
                    return cardInfo;
                }
                cardInfo.setCardNum(str2);
                q.h(e10, WearPath.TicPay.PAY, h10.d(str), str2);
                return cardInfo;
            }
            cardInfo.setCardNum(d10);
            k.a("PaymentHandler", "Bjt card number is already save in local storage, no need to query again.");
            return cardInfo;
        }
    }

    private static boolean e(Object obj) {
        if ((obj instanceof Handler) || (obj instanceof s.a)) {
            return true;
        }
        throw new IllegalArgumentException("obj param of the message is invalid type.");
    }

    private EnumCardAppStatus f(String str, CardInfo cardInfo) {
        EnumCardAppStatus enumCardAppStatus = EnumCardAppStatus.CARD_STATUS_DISABLE;
        if ("9156000014010001".equalsIgnoreCase(str)) {
            if (CardInfo.BLACK_LIST_BJT.equals(cardInfo.getBlackList())) {
                enumCardAppStatus = EnumCardAppStatus.CARD_STATUS_BLACKLIST;
            } else if ("02".equals(cardInfo.getEnableFlag())) {
                enumCardAppStatus = EnumCardAppStatus.CARD_STATUS_OK;
            }
        } else if ("A00000063201010510009156000014A1".equalsIgnoreCase(str)) {
            String blackList = cardInfo.getBlackList();
            if (CardInfo.BLACK_LIST_BJHT1.equals(blackList) || CardInfo.BLACK_LIST_BJHT2.equals(blackList)) {
                enumCardAppStatus = EnumCardAppStatus.CARD_STATUS_BLACKLIST;
            } else if ("01".equals(cardInfo.getEnableFlag())) {
                enumCardAppStatus = EnumCardAppStatus.CARD_STATUS_OK;
            }
        } else if ("535A542E57414C4C45542E454E56".equalsIgnoreCase(str)) {
            if ("03".equals(cardInfo.getEnableFlag())) {
                enumCardAppStatus = EnumCardAppStatus.CARD_STATUS_OK;
            }
        } else if ("D1560001360103000057485401000001".equalsIgnoreCase(str)) {
            if ("01".equals(cardInfo.getEnableFlag())) {
                enumCardAppStatus = EnumCardAppStatus.CARD_STATUS_OK;
            }
        } else if ("D156000015CCECB8AECDA8BFA8".equalsIgnoreCase(str)) {
            if ("01".equals(cardInfo.getEnableFlag())) {
                enumCardAppStatus = EnumCardAppStatus.CARD_STATUS_OK;
            }
        } else if ("A0000006320101050113581058000000".equalsIgnoreCase(str)) {
            enumCardAppStatus = EnumCardAppStatus.CARD_STATUS_OK;
        }
        if (enumCardAppStatus == EnumCardAppStatus.CARD_STATUS_BLACKLIST) {
            return enumCardAppStatus;
        }
        String startDate = cardInfo.getStartDate();
        String expiryDate = cardInfo.getExpiryDate();
        if (!c.k(startDate) || !c.k(expiryDate)) {
            return EnumCardAppStatus.CARD_STATUS_INVALID_DATE;
        }
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            Date time = calendar.getTime();
            SimpleDateFormat simpleDateFormat = f32946d;
            if (simpleDateFormat.parse(startDate).after(time)) {
                return EnumCardAppStatus.CARD_STATUS_UNENABLED_DATE;
            }
            return simpleDateFormat.parse(expiryDate).before(time) ? EnumCardAppStatus.CARD_STATUS_OUT_DATE : enumCardAppStatus;
        } catch (ParseException e10) {
            k.r("PaymentHandler", "bus card date error ", e10, new Object[0]);
            return EnumCardAppStatus.CARD_STATUS_INVALID_DATE;
        }
    }

    public static synchronized Handler g() {
        Handler handler;
        synchronized (f.class) {
            f fVar = f32947e;
            if (fVar.f32948a == null) {
                HandlerThread handlerThread = new HandlerThread("Tic-Pay");
                fVar.f32948a = handlerThread;
                handlerThread.start();
                fVar.f32949b = new Handler(fVar.f32948a.getLooper(), fVar.f32950c);
            }
            handler = fVar.f32949b;
        }
        return handler;
    }

    private List<sd.a> h() {
        sd.b h10;
        List<BusinessOrder> u10;
        ArrayList arrayList = new ArrayList();
        try {
            EnumCardAppType enumCardAppType = EnumCardAppType.CARD_APP_TYPE_SH_TOUR;
            r();
            h10 = sd.b.h();
            i2.a j10 = h10.j();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(EnumOrderStatus.hasPaid);
            arrayList2.add(EnumOrderStatus.failure);
            arrayList2.add(EnumOrderStatus.unsettled);
            u10 = j10.u(0, 10, enumCardAppType, EnumBusinessOrderType.ORDER_TYPE_RECHARGE, arrayList2);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (u10 != null && !u10.isEmpty()) {
            for (BusinessOrder businessOrder : u10) {
                long g10 = x2.c.g(businessOrder.getOrder());
                sd.a aVar = new sd.a();
                aVar.f34381d = String.format("%s %s", c.n(businessOrder.getTradeDate()), c.q(businessOrder.getTradeTime()));
                aVar.f34378a = "A00000000386980701";
                aVar.f34379b = h10.e("A00000000386980701");
                aVar.f34387j = 1;
                aVar.f34385h = 2;
                aVar.f34380c = String.valueOf(g10);
                aVar.f34382e = businessOrder.getAmount();
                aVar.f34383f = businessOrder.getAmount();
                aVar.f34384g = 4;
                aVar.f34386i = EnumOrderStatus.unsettled.equals(businessOrder.getTradeState());
                k.a("PaymentHandler", String.valueOf(aVar));
                arrayList.add(aVar);
            }
            return arrayList;
        }
        return arrayList;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:2|(4:18|3|(1:5)|6)|(2:11|17)|19|12|17) */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x00a9, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00aa, code lost:
        r0.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private CardInfo i() {
        String q5;
        List<BusinessOrder> u10;
        EnumCardAppType enumCardAppType = EnumCardAppType.CARD_APP_TYPE_SH_TOUR;
        i2.a j10 = sd.b.h().j();
        r();
        EnumCardAppStatus enumCardAppStatus = EnumCardAppStatus.CARD_STATUS_UNKNOWN;
        CardInfo cardInfo = new CardInfo();
        try {
            if (j10.t(enumCardAppType) == cn.com.fmsh.tsm.business.enums.EnumCardAppStatus.STATUS_ACTIVATE) {
                enumCardAppStatus = EnumCardAppStatus.CARD_STATUS_OK;
            }
            cardInfo.setCardStatus(enumCardAppStatus);
            cardInfo.setCardBalance(j10.c(enumCardAppType).intValue());
            cardInfo.setCardNum(j10.h(enumCardAppType));
            q5 = j10.q(enumCardAppType);
            cardInfo.setExpiryDate(q5);
            k.c("PaymentHandler", "shanghaitong app number %s", mk.b.a(j10.g(enumCardAppType)));
            ArrayList arrayList = new ArrayList();
            arrayList.add(EnumOrderStatus.hasPaid);
            arrayList.add(EnumOrderStatus.success);
            u10 = j10.u(0, 10, enumCardAppType, EnumBusinessOrderType.ORDER_TYPE_ISSUE, arrayList);
        } catch (Exception e10) {
            e10.printStackTrace();
            cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_APPLET_NO_EXIST);
        }
        if (u10 != null && !u10.isEmpty()) {
            cardInfo.setStartDate(u10.get(0).getTradeDate());
            return cardInfo;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(LeisenIfaceConfig.CARD_DATE_FORMAT, Locale.getDefault());
        Date parse = simpleDateFormat.parse(q5);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parse);
        calendar.set(1, calendar.get(1) - 5);
        cardInfo.setStartDate(simpleDateFormat.format(calendar.getTime()));
        return cardInfo;
    }

    private List<sd.a> j(int i10) {
        sd.b h10;
        List<BusinessOrder> u10;
        ArrayList arrayList = new ArrayList();
        try {
            EnumCardAppType enumCardAppType = EnumCardAppType.CARD_APP_TYPE_SH_TOUR;
            r();
            h10 = sd.b.h();
            i2.a j10 = h10.j();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(EnumOrderStatus.hasPaid);
            arrayList2.add(EnumOrderStatus.success);
            arrayList2.add(EnumOrderStatus.failure);
            arrayList2.add(EnumOrderStatus.unsettled);
            arrayList2.add(EnumOrderStatus.apilyForRefund);
            arrayList2.add(EnumOrderStatus.hasRefunded);
            arrayList2.add(EnumOrderStatus.refundFailure);
            arrayList2.add(EnumOrderStatus.payFailure);
            arrayList2.add(EnumOrderStatus.recharging);
            arrayList2.add(EnumOrderStatus.dubious);
            arrayList2.add(EnumOrderStatus.invalid);
            arrayList2.add(EnumOrderStatus.unknown);
            u10 = j10.u(i10, 10, enumCardAppType, EnumBusinessOrderType.ORDER_TYPE_RECHARGE, arrayList2);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (u10 != null && !u10.isEmpty()) {
            for (BusinessOrder businessOrder : u10) {
                long g10 = x2.c.g(businessOrder.getOrder());
                sd.a aVar = new sd.a();
                aVar.f34381d = String.format("%s %s", c.n(businessOrder.getTradeDate()), c.q(businessOrder.getTradeTime()));
                aVar.f34378a = "A00000000386980701";
                aVar.f34379b = h10.e("A00000000386980701");
                aVar.f34387j = 1;
                aVar.f34385h = 2;
                aVar.f34380c = String.valueOf(g10);
                aVar.f34389l = businessOrder.getInvoiceStatus();
                aVar.f34382e = businessOrder.getAmount();
                aVar.f34383f = businessOrder.getAmount();
                aVar.f34384g = 4;
                aVar.f34386i = EnumOrderStatus.unsettled.equals(businessOrder.getTradeState());
                aVar.f34388k = businessOrder.getTradeState();
                k.a("PaymentHandler", String.valueOf(aVar));
                arrayList.add(aVar);
            }
            return arrayList;
        }
        return arrayList;
    }

    private cn.com.fmsh.tsm.business.bean.b k(String str) {
        try {
            r();
            byte[] t10 = x2.c.t(Long.parseLong(str), 8);
            String f10 = sd.b.h().j().f(t10);
            cn.com.fmsh.tsm.business.bean.b bVar = new cn.com.fmsh.tsm.business.bean.b();
            bVar.c(t10);
            bVar.d(f10);
            return bVar;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Message message) {
        k.a("PaymentHandler", "start process bank command msg " + message.what);
        Application e10 = com.mobvoi.android.common.utils.b.e();
        if (o(message.obj) == null) {
            k.d("PaymentHandler", "handle is null, please pay attention.");
        }
        Toast.makeText(e10, "出错了，请联系客服！", 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x03e2, code lost:
        if ("A00000063201010510009156000014A1".equalsIgnoreCase(r4) != false) goto L101;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v103, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v112, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v114, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r0v66, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r0v72, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r0v77, types: [com.mobvoi.companion.ticpay.buscard.CardInfo] */
    /* JADX WARN: Type inference failed for: r0v87 */
    /* JADX WARN: Type inference failed for: r0v88, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v93, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v94, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v10, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r14v11, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v15, types: [com.bjleisen.iface.sdk.bean.resp.RespInfo] */
    /* JADX WARN: Type inference failed for: r14v16, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r14v17, types: [cn.com.fmsh.tsm.business.bean.d] */
    /* JADX WARN: Type inference failed for: r14v20, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r14v21, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r14v22, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r14v23, types: [com.bjleisen.iface.sdk.bean.resp.RespInfo] */
    /* JADX WARN: Type inference failed for: r14v24 */
    /* JADX WARN: Type inference failed for: r14v25, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r14v26, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r14v27, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r14v28, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r14v29, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r14v30, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r14v31, types: [com.bjleisen.iface.sdk.bean.resp.RespInfo] */
    /* JADX WARN: Type inference failed for: r14v34, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r14v35, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r14v36, types: [com.bjleisen.iface.sdk.bean.resp.RespInfo] */
    /* JADX WARN: Type inference failed for: r14v37, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r14v38, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r14v39 */
    /* JADX WARN: Type inference failed for: r14v4, types: [com.bjleisen.iface.sdk.bean.resp.RespInfo] */
    /* JADX WARN: Type inference failed for: r14v40, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v41, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v42, types: [com.bjleisen.iface.sdk.bean.resp.RespInfo] */
    /* JADX WARN: Type inference failed for: r14v43, types: [com.bjleisen.iface.sdk.bean.resp.RespInfo] */
    /* JADX WARN: Type inference failed for: r14v44 */
    /* JADX WARN: Type inference failed for: r14v46, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r14v47, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r14v48, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r14v49, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r14v5, types: [com.bjleisen.iface.sdk.bean.resp.RespInfo] */
    /* JADX WARN: Type inference failed for: r14v50, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r14v51, types: [cn.com.fmsh.tsm.business.bean.b] */
    /* JADX WARN: Type inference failed for: r14v52 */
    /* JADX WARN: Type inference failed for: r14v53 */
    /* JADX WARN: Type inference failed for: r14v54 */
    /* JADX WARN: Type inference failed for: r14v55 */
    /* JADX WARN: Type inference failed for: r14v56 */
    /* JADX WARN: Type inference failed for: r14v57 */
    /* JADX WARN: Type inference failed for: r14v6, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r14v7, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r14v8, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r14v9, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r24v0, types: [qd.f] */
    /* JADX WARN: Type inference failed for: r3v113 */
    /* JADX WARN: Type inference failed for: r3v114 */
    /* JADX WARN: Type inference failed for: r3v24, types: [com.bjleisen.iface.sdk.bean.BusinessOrderInfo] */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v66, types: [com.mobvoi.companion.ticpay.buscard.CardInfo] */
    /* JADX WARN: Type inference failed for: r3v71, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v86, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m(Message message) {
        int i10;
        Handler handler;
        ?? e10;
        AppletListBusiRespInfo appletListBusiRespInfo;
        ud.a i11;
        List<BusinessOrderInfo> orderInfoList;
        byte[] bArr;
        i2.a j10;
        String l10;
        byte[] b10;
        byte[] bArr2;
        k.a("PaymentHandler", "start process bus command.");
        Handler o10 = o(message.obj);
        int i12 = message.what;
        LeisenIfaceOperator leisenIfaceOperator = LeisenIfaceOperator.getInstance();
        sd.b h10 = sd.b.h();
        Bundle data = message.getData();
        EnumCardAppType enumCardAppType = EnumCardAppType.CARD_APP_TYPE_SH_TOUR;
        if (i12 != 3300) {
            handler = o10;
            i10 = i12;
            switch (i10) {
                case AMapException.CODE_AMAP_ROUTE_NO_ROADS_NEARBY /* 3001 */:
                    d c10 = sd.b.h().c();
                    String l11 = h10.l();
                    k.a("PaymentHandler", "execute register seid = " + l11);
                    e10 = leisenIfaceOperator.registerNew();
                    String i13 = c.i();
                    String j11 = c.j(i13);
                    if (c10.e()) {
                        i2.a j12 = h10.j();
                        j12.k(new e());
                        try {
                            cn.com.fmsh.tsm.business.bean.c m10 = j12.m(i13, j11);
                            if (m10.a() != 0) {
                                int o11 = j12.o(i13, j11);
                                cn.com.fmsh.tsm.business.bean.c m11 = j12.m(i13, j11);
                                k.c("PaymentHandler", "sht register result %s", Integer.valueOf(o11));
                                m10 = m11;
                            }
                            k.c("PaymentHandler", "sht login result %s", Integer.valueOf(m10.a()));
                            break;
                        } catch (Exception e11) {
                            e11.printStackTrace();
                            break;
                        }
                    }
                    break;
                case AMapException.CODE_AMAP_ROUTE_FAIL /* 3002 */:
                    k.a("PaymentHandler", "execute get app list");
                    e10 = leisenIfaceOperator.getAppletList();
                    if (e10.getStatus() == 0 && (appletListBusiRespInfo = (AppletListBusiRespInfo) e10.getBusiRespInfo()) != null && appletListBusiRespInfo.getIsHaveErrorOrder() == 0 && s()) {
                        appletListBusiRespInfo.setIsHaveErrorOrder(1);
                        break;
                    }
                    break;
                case AMapException.CODE_AMAP_OVER_DIRECTION_RANGE /* 3003 */:
                    k.a("PaymentHandler", "execute get card info.");
                    e10 = new HashMap();
                    p(e10, h10, leisenIfaceOperator, "535A542E57414C4C45542E454E56");
                    p(e10, h10, leisenIfaceOperator, "9156000014010001");
                    p(e10, h10, leisenIfaceOperator, "A00000063201010510009156000014A1");
                    p(e10, h10, leisenIfaceOperator, "D1560001360103000057485401000001");
                    p(e10, h10, leisenIfaceOperator, "D156000015CCECB8AECDA8BFA8");
                    p(e10, h10, leisenIfaceOperator, "A0000006320101050113581058000000");
                    if (sd.b.h().c().e() && (i11 = h10.i("A00000000386980701")) != null && i11.i()) {
                        e10.put("A00000000386980701", i());
                        break;
                    }
                    break;
                case 3004:
                    k.a("PaymentHandler", "execute delete ssd.");
                    String string = data.getString("param");
                    if (TextUtils.isEmpty(string)) {
                        k.a("PaymentHandler", "aid is invalid.");
                        e10 = -1;
                        break;
                    } else {
                        TSMOperator tSMOperator = TSMOperator.getInstance();
                        int initBluetoothDeviceInfo = tSMOperator.initBluetoothDeviceInfo();
                        k.a("PaymentHandler", "initBluetoothDeviceInfo, status = " + initBluetoothDeviceInfo);
                        if (initBluetoothDeviceInfo != 100000) {
                            e10 = Integer.valueOf(initBluetoothDeviceInfo);
                            break;
                        } else {
                            String cplc = tSMOperator.getCPLC();
                            k.a("PaymentHandler", "get cplc, cplc = " + cplc);
                            int notifyInfoInit = tSMOperator.notifyInfoInit();
                            k.a("PaymentHandler", "notifyInfoInit status = " + notifyInfoInit);
                            if (notifyInfoInit != 100000) {
                                e10 = Integer.valueOf(notifyInfoInit);
                                break;
                            } else {
                                int notifyEseInfoSync = tSMOperator.notifyEseInfoSync();
                                k.a("PaymentHandler", "notifyEseInfoSync status = " + notifyEseInfoSync);
                                if (notifyEseInfoSync != 100000) {
                                    e10 = Integer.valueOf(notifyEseInfoSync);
                                    break;
                                } else {
                                    int cascadingDeleteSSD = tSMOperator.cascadingDeleteSSD(string);
                                    k.a("PaymentHandler", "cascadingDeleteSSD status = " + cascadingDeleteSSD);
                                    e10 = Integer.valueOf(cascadingDeleteSSD);
                                    break;
                                }
                            }
                        }
                    }
                case 3005:
                    e10 = 0;
                    e10 = 0;
                    e10 = 0;
                    e10 = 0;
                    e10 = 0;
                    e10 = 0;
                    e10 = 0;
                    String string2 = data.getString("card_aid");
                    k.c("PaymentHandler", "query abnormal order. aid %s", string2);
                    if ("A00000000386980701".equalsIgnoreCase(string2)) {
                        try {
                            r();
                            i2.a j13 = h10.j();
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(EnumOrderStatus.hasPaid);
                            arrayList.add(EnumOrderStatus.failure);
                            arrayList.add(EnumOrderStatus.unsettled);
                            List<BusinessOrder> u10 = j13.u(0, 10, enumCardAppType, EnumBusinessOrderType.ORDER_TYPE_RECHARGE, arrayList);
                            if (u10 != null && !u10.isEmpty()) {
                                e10 = u10.get(0);
                                break;
                            }
                        } catch (Exception e12) {
                            e12.printStackTrace();
                            break;
                        }
                    } else {
                        RespInfo<OrderListBusiRespInfo> queryBusinessOrderLists = leisenIfaceOperator.queryBusinessOrderLists(string2, 2, 1000, 1);
                        if (queryBusinessOrderLists != null) {
                            k.c("PaymentHandler", "status = %d, desc = %s", Integer.valueOf(queryBusinessOrderLists.getStatus()), queryBusinessOrderLists.getDesc());
                            if (!(queryBusinessOrderLists.getBusiRespInfo() == null || (orderInfoList = queryBusinessOrderLists.getBusiRespInfo().getOrderInfoList()) == null)) {
                                for (BusinessOrderInfo businessOrderInfo : orderInfoList) {
                                    int orderType = businessOrderInfo.getOrderType();
                                    if (orderType != 1) {
                                        if (orderType == 3) {
                                        }
                                    }
                                    e10 = businessOrderInfo;
                                    break;
                                }
                                break;
                            }
                        }
                    }
                    break;
                case 3006:
                    String string3 = data.getString("card_aid");
                    int i14 = data.getInt("order_money");
                    int i15 = data.getInt("order_type");
                    int i16 = data.getInt("pay_way");
                    ud.a i17 = h10.i(string3);
                    Applet applet = i17.applet;
                    k.c("PaymentHandler", "generateNewOrder aid = %s, money = %d, orderType = %d", string3, Integer.valueOf(i14), Integer.valueOf(i15));
                    int k10 = i16 == -1 ? h10.k() : i16;
                    if (!qd.a.c(i17) || i15 != 2) {
                        e10 = leisenIfaceOperator.getPayOrder(applet.getInstanceAid(), i17.f35369id, i14, i15, null, k10, 1);
                        break;
                    } else {
                        try {
                            r();
                            i2.a j14 = h10.j();
                            e10 = j14.n(i14, 3, j14.g(enumCardAppType), enumCardAppType);
                            break;
                        } catch (Exception e13) {
                            e10 = e13;
                            e10.printStackTrace();
                            break;
                        }
                    }
                case 3007:
                    String string4 = data.getString("param");
                    String string5 = data.getString("order_id");
                    long j15 = data.getLong("main_order_id", 0L);
                    data.getBoolean("abnormal_order");
                    String string6 = data.getString("card_aid");
                    k.c("PaymentHandler", "recharge execute orderId = %s", string5);
                    ud.a i18 = h10.i(string6);
                    k.c("PaymentHandler", "rechage execute aid = %s, orderId = %s", string4, string5);
                    if (qd.a.c(i18)) {
                        try {
                            r();
                            i2.a j16 = h10.j();
                            if (j15 > 0) {
                                BusinessOrder[] d10 = j16.e(x2.c.t(j15, 8)).d();
                                if (!(d10 == null || d10.length == 0)) {
                                    bArr = d10[0].getOrder();
                                    d10[0].getTradeState();
                                }
                                e10 = Boolean.FALSE;
                            } else {
                                bArr = x2.c.t(Long.parseLong(string5), 8);
                            }
                            e10 = Boolean.valueOf(j16.r(bArr, j16.g(enumCardAppType)));
                            break;
                        } catch (Exception e14) {
                            e10 = e14;
                            e10.printStackTrace();
                            break;
                        }
                    } else {
                        e10 = leisenIfaceOperator.recharge(string5);
                        break;
                    }
                    break;
                default:
                    switch (i10) {
                        case 3009:
                            boolean z10 = data.getBoolean("recreate");
                            String string7 = data.getString("param");
                            k.a("PaymentHandler", "createSsd execute ssdAid = " + string7 + ", recreated = " + z10);
                            TSMOperator tSMOperator2 = TSMOperator.getInstance();
                            int initBluetoothDeviceInfo2 = tSMOperator2.initBluetoothDeviceInfo();
                            k.a("PaymentHandler", "initBluetoothDeviceInfo, status = " + initBluetoothDeviceInfo2);
                            if (initBluetoothDeviceInfo2 != 100000) {
                                e10 = Integer.valueOf(initBluetoothDeviceInfo2);
                                break;
                            } else {
                                String cplc2 = tSMOperator2.getCPLC();
                                k.a("PaymentHandler", "get cplc, cplc = " + cplc2);
                                int notifyInfoInit2 = tSMOperator2.notifyInfoInit();
                                k.a("PaymentHandler", "notifyInfoInit status = " + notifyInfoInit2);
                                if (notifyInfoInit2 != 100000) {
                                    e10 = Integer.valueOf(notifyInfoInit2);
                                    break;
                                } else {
                                    int notifyEseInfoSync2 = tSMOperator2.notifyEseInfoSync();
                                    k.a("PaymentHandler", "notifyEseInfoSync status = " + notifyEseInfoSync2);
                                    if (notifyEseInfoSync2 != 100000) {
                                        e10 = Integer.valueOf(notifyEseInfoSync2);
                                        break;
                                    } else {
                                        if (z10) {
                                            int cascadingDeleteSSD2 = TSMOperator.getInstance().cascadingDeleteSSD(string7);
                                            k.a("PaymentHandler", "cascadingDeleteSsd status = " + cascadingDeleteSSD2);
                                            if (cascadingDeleteSSD2 != 100000) {
                                                e10 = Integer.valueOf(cascadingDeleteSSD2);
                                                break;
                                            }
                                        }
                                        int createSSD = tSMOperator2.createSSD(string7, tSMOperator2.getCIN(), tSMOperator2.getIIN());
                                        k.a("PaymentHandler", "createSsd status = " + createSSD);
                                        if (createSSD != 100000) {
                                            e10 = Integer.valueOf(createSSD);
                                            break;
                                        } else {
                                            e10 = Integer.valueOf((int) AppConfig.STATUS_SUCCESS);
                                            break;
                                        }
                                    }
                                }
                            }
                        case 3010:
                            String string8 = data.getString("order_id");
                            String string9 = data.getString("card_aid");
                            k.c("PaymentHandler", "downloadApplet execute orderId = %s", string8);
                            ud.a i19 = h10.i(string9);
                            Applet applet2 = i19.applet;
                            if (!qd.a.c(i19)) {
                                e10 = leisenIfaceOperator.installApplet(applet2.getInstanceAid(), applet2.getAppletVersion(), string8);
                                break;
                            } else {
                                byte[] d11 = o.k(com.mobvoi.android.common.utils.b.e()).d(WearPath.TicPay.DEACTIVATE_ALL, new byte[]{0});
                                Object[] objArr = new Object[1];
                                objArr[0] = d11 == null ? "" : new String(d11);
                                k.c("PaymentHandler", "deactivate: %s", objArr);
                                try {
                                    r();
                                    j10 = h10.j();
                                    l10 = h10.l();
                                    b10 = mk.b.b(l10);
                                } catch (Exception e15) {
                                    e = e15;
                                    e.printStackTrace();
                                }
                                if (!j10.l(b10, "WE11078", "002", null)) {
                                    e10 = Boolean.FALSE;
                                    break;
                                } else {
                                    BusinessOrder[] d12 = j10.s(enumCardAppType, 0, b10, 0, "WE11078", qd.a.a(l10, string8)).d();
                                    if (!(d12 == null || d12.length == 0)) {
                                        e = Boolean.valueOf(j10.p(d12[0].getOrder(), b10));
                                        e10 = e;
                                    }
                                    e10 = Boolean.FALSE;
                                }
                            }
                            break;
                        case 3011:
                            String string10 = data.getString("order_id");
                            String string11 = data.getString("card_aid");
                            k.c("PaymentHandler", "personal applet orderId = %s", string10);
                            if ("A0000006320101050113581058000000".equals(string11)) {
                                byte[] d13 = o.k(com.mobvoi.android.common.utils.b.e()).d(WearPath.TicPay.DEACTIVATE_ALL, new byte[]{0});
                                Object[] objArr2 = new Object[1];
                                objArr2[0] = d13 == null ? "" : new String(d13);
                                k.c("PaymentHandler", "deactivate: %s", objArr2);
                            }
                            Applet applet3 = h10.i(string11).applet;
                            e10 = leisenIfaceOperator.personalApplet(applet3.getInstanceAid(), applet3.getAppletVersion(), string10);
                            break;
                        case 3012:
                            String string12 = data.getString("card_aid");
                            k.c("PaymentHandler", "execute get card info aid = %s", string12);
                            if (!"A00000000386980701".equalsIgnoreCase(string12)) {
                                String cardInfo = leisenIfaceOperator.getCardInfo(string12);
                                k.c("PaymentHandler", "CardInfo %s", cardInfo);
                                CardInfo cardInfo2 = (CardInfo) kc.c.b(cardInfo, CardInfo.class);
                                if (!"9156000014010001".equalsIgnoreCase(string12)) {
                                    businessOrderInfo = cardInfo2;
                                    break;
                                }
                                businessOrderInfo = d(leisenIfaceOperator, cardInfo2, string12);
                                if (businessOrderInfo != 0) {
                                    businessOrderInfo.setCardStatus(f(string12, businessOrderInfo));
                                }
                                e10 = businessOrderInfo;
                                break;
                            } else {
                                e = i();
                                e10 = e;
                            }
                        case 3013:
                            e10 = new ArrayList();
                            c(leisenIfaceOperator, h10, e10, "9156000014010001");
                            c(leisenIfaceOperator, h10, e10, "535A542E57414C4C45542E454E56");
                            c(leisenIfaceOperator, h10, e10, "D1560001360103000057485401000001");
                            c(leisenIfaceOperator, h10, e10, "D156000015CCECB8AECDA8BFA8");
                            c(leisenIfaceOperator, h10, e10, "A00000000386980701");
                            c(leisenIfaceOperator, h10, e10, "A00000063201010510009156000014A1");
                            c(leisenIfaceOperator, h10, e10, "A0000006320101050113581058000000");
                            if (sd.b.h().c().e()) {
                                e10.addAll(h());
                                break;
                            }
                            break;
                        case 3014:
                            RespInfo<AppletListBusiRespInfo> appletList = leisenIfaceOperator.getAppletList();
                            if (appletList != null) {
                                k.c("PaymentHandler", "check abnormal order status = %d, desc = %s", Integer.valueOf(appletList.getStatus()), appletList.getDesc());
                                boolean z11 = appletList.getBusiRespInfo() != null && appletList.getBusiRespInfo().getIsHaveErrorOrder() > 0;
                                if (!z11) {
                                    z11 = s();
                                }
                                e10 = Boolean.valueOf(z11);
                                break;
                            }
                            e10 = 0;
                            break;
                        case 3015:
                            e = data.getString("param");
                            k.a("PaymentHandler", "activate applet aid = " + e);
                            if (!TextUtils.isEmpty(e)) {
                                d c11 = sd.b.h().c();
                                if (!Arrays.equals(c11.d(WearPath.TicPay.SET_DEFAULT_APP, e.getBytes()), mk.a.f30836a)) {
                                    k.a("PaymentHandler", "activate applet fail.");
                                } else {
                                    q.h(com.mobvoi.android.common.utils.b.e(), WearPath.TicPay.PAY, "default_bus_aid", e);
                                    boolean equals = Arrays.equals(c11.d(WearPath.TicPay.DEFAULT_BUS_AID, e.getBytes()), WearPath.TicPay.REBOOT.getBytes());
                                    k.a("PaymentHandler", "needReboot = " + equals);
                                    data.putBoolean("need_reboot", equals);
                                    e10 = e;
                                }
                            }
                            e10 = 0;
                            break;
                        case 3016:
                            String string13 = data.getString("card_aid");
                            try {
                                if ("A00000000386980701".equalsIgnoreCase(string13)) {
                                    e = new ArrayList();
                                    List<CardAppRecord> i20 = h10.j().i(enumCardAppType);
                                    if (i20 != null && !i20.isEmpty()) {
                                        for (CardAppRecord cardAppRecord : i20) {
                                            TradeInfo tradeInfo = new TradeInfo();
                                            tradeInfo.setTradeNo(String.valueOf(cardAppRecord.getTradeNo()));
                                            tradeInfo.setTradeDate(cardAppRecord.getTradeDate());
                                            tradeInfo.setTradeTime(cardAppRecord.getTradeTime());
                                            tradeInfo.setTradeAmount(cardAppRecord.getAmount());
                                            tradeInfo.setPosNo(cardAppRecord.getTradeDevice());
                                            int i21 = b.f32952a[cardAppRecord.getTradeType().ordinal()];
                                            tradeInfo.setTradeType((i21 == 1 || i21 == 2) ? "02" : "06");
                                            e.add(tradeInfo);
                                        }
                                    }
                                } else {
                                    e = kc.c.a(leisenIfaceOperator.getTradeInfo(string13), TradeInfo.class);
                                }
                                e10 = e;
                            } catch (Exception e16) {
                                e16.printStackTrace();
                                break;
                            }
                            break;
                        case 3017:
                            k.a("PaymentHandler", "execute get default bus card");
                            d c12 = sd.b.h().c();
                            byte[] d14 = c12.d(WearPath.TicPay.GET_DEFAULT_APP, new byte[0]);
                            if (!Arrays.equals(d14, mk.a.f30837b)) {
                                e10 = mk.b.a(d14);
                                k.a("PaymentHandler", "default bus card is " + e10);
                                q.h(com.mobvoi.android.common.utils.b.e(), WearPath.TicPay.PAY, "default_bus_aid", e10);
                                c12.d(WearPath.TicPay.DEFAULT_BUS_AID, e10.getBytes());
                                k.a("PaymentHandler", "success send default bus aid to watch.");
                                break;
                            }
                            e10 = 0;
                            break;
                        case 3018:
                            k.a("PaymentHandler", "execute get nfc bus property");
                            byte[] d15 = sd.b.h().c().d(WearPath.TicPay.NFC_BUS_PROPERTY, new byte[0]);
                            if (d15 != null) {
                                e10 = new String(d15);
                                k.a("PaymentHandler", "nfc bus property is " + e10);
                                break;
                            }
                            e10 = 0;
                            break;
                        case 3019:
                            String string14 = data.getString("order_id");
                            k.a("PaymentHandler", "query order status orderId = " + string14);
                            if (!TextUtils.isEmpty(string14)) {
                                e10 = leisenIfaceOperator.queryPayOrderStatus(string14);
                                break;
                            }
                            e10 = 0;
                            break;
                        case 3020:
                            String string15 = data.getString("order_id");
                            String string16 = data.getString("card_aid");
                            k.c("PaymentHandler", "deleteApplet execute orderId = %s", string15);
                            ud.a i22 = h10.i(string16);
                            Applet applet4 = i22.applet;
                            if (!qd.a.c(i22)) {
                                e10 = leisenIfaceOperator.deleteApplet(applet4.getInstanceAid(), applet4.getAppletVersion());
                                break;
                            } else {
                                r();
                                i2.a j17 = h10.j();
                                byte[] bArr3 = new byte[128];
                                Arrays.fill(bArr3, (byte) 1);
                                try {
                                    k.c("PaymentHandler", "delete sht %s", j17.d(bArr3, enumCardAppType, mk.b.b(h10.l()), "WE11078"));
                                    e = Boolean.TRUE;
                                } catch (Exception e17) {
                                    e = e17;
                                    e.printStackTrace();
                                }
                                e10 = e;
                            }
                        case 3021:
                            if (sd.b.h().c().e()) {
                                try {
                                    h10.j().b();
                                } catch (Exception e18) {
                                    e18.printStackTrace();
                                }
                            }
                            e10 = 0;
                            break;
                        default:
                            switch (i10) {
                                case 3023:
                                    String string17 = data.getString("param");
                                    String string18 = data.getString("order_id");
                                    long j18 = data.getLong("main_order_id", 0L);
                                    data.getBoolean("abnormal_order");
                                    String string19 = data.getString("card_aid");
                                    k.c("PaymentHandler", "unsettled execute orderId = %s", string18);
                                    ud.a i23 = h10.i(string19);
                                    k.c("PaymentHandler", "unsettled execute aid = %s, orderId = %s", string17, string18);
                                    if (qd.a.c(i23)) {
                                        try {
                                            r();
                                            i2.a j19 = h10.j();
                                            if (j18 > 0) {
                                                BusinessOrder[] d16 = j19.e(x2.c.t(j18, 8)).d();
                                                if (!(d16 == null || d16.length == 0)) {
                                                    bArr2 = d16[0].getOrder();
                                                    d16[0].getTradeState();
                                                }
                                                e10 = Boolean.FALSE;
                                            } else {
                                                bArr2 = x2.c.t(Long.parseLong(string18), 8);
                                            }
                                            int a10 = j19.a(bArr2, j19.g(enumCardAppType));
                                            k.f("PaymentHandler", "unsettled execute result %s", Integer.valueOf(a10));
                                            e10 = Boolean.valueOf(a10 == 0);
                                            break;
                                        } catch (Exception e19) {
                                            e10 = e19;
                                            e10.printStackTrace();
                                            break;
                                        }
                                    } else {
                                        e10 = Boolean.TRUE;
                                        break;
                                    }
                                    break;
                                case 3024:
                                    e10 = j(data.getInt("param"));
                                    break;
                                case 3025:
                                    e10 = k(data.getString("order_id"));
                                    break;
                                default:
                                    e10 = 0;
                                    break;
                            }
                    }
                    break;
            }
        } else {
            handler = o10;
            i10 = i12;
            e10 = mk.b.a(sd.b.h().c().d(WearPath.TicPay.CPLC, new byte[]{0}));
            k.c("PaymentHandler", "execute get cplc = %s", new Object[]{e10});
        }
        Message obtain = Message.obtain();
        obtain.what = i10;
        obtain.obj = e10;
        if (data != null) {
            obtain.setData(data);
        }
        obtain.setTarget(handler);
        obtain.sendToTarget();
        k.a("PaymentHandler", "end process bus command.");
    }

    public static Message n(int i10, Object obj) {
        e(obj);
        Message obtain = Message.obtain();
        obtain.what = i10;
        obtain.arg1 = 1;
        obtain.obj = obj;
        obtain.setTarget(g());
        return obtain;
    }

    private Handler o(Object obj) {
        if (obj instanceof Handler) {
            return (Handler) obj;
        }
        if (obj instanceof s.a) {
            return new s((s.a) obj, Looper.getMainLooper());
        }
        throw new IllegalArgumentException("obj param of the message is invalid type.");
    }

    private void p(HashMap<String, CardInfo> hashMap, sd.b bVar, LeisenIfaceOperator leisenIfaceOperator, String str) {
        ud.a i10 = bVar.i(str);
        if (i10 != null && i10.i()) {
            String cardInfo = leisenIfaceOperator.getCardInfo(i10.appAid);
            k.c("PaymentHandler", "CardInfo %s %s", i10.appAid, cardInfo);
            CardInfo cardInfo2 = (CardInfo) kc.c.b(cardInfo, CardInfo.class);
            if ("9156000014010001".equalsIgnoreCase(i10.appAid) || "A00000063201010510009156000014A1".equalsIgnoreCase(i10.appAid)) {
                cardInfo2 = d(leisenIfaceOperator, cardInfo2, i10.appAid);
            }
            if (cardInfo2 != null) {
                EnumCardAppStatus f10 = f(i10.appAid, cardInfo2);
                k.c("PaymentHandler", "CardStatus %s %s", i10.appAid, f10);
                cardInfo2.setCardStatus(f10);
            }
            if (cardInfo2 == null) {
                cardInfo2 = new CardInfo();
                cardInfo2.setCardStatus(EnumCardAppStatus.CARD_STATUS_WALLET_ERROR);
            }
            hashMap.put(str, cardInfo2);
        }
    }

    public static void q(Handler handler, int i10, Bundle bundle) {
        Message n10 = n(i10, handler);
        if (bundle != null) {
            n10.setData(bundle);
        }
        n10.sendToTarget();
    }

    private void r() {
        String i10 = c.i();
        String j10 = c.j(i10);
        i2.a j11 = sd.b.h().j();
        try {
            j11.b();
        } catch (Exception e10) {
            k.e("PaymentHandler", "sht logout error ", e10);
        }
        try {
            k.c("PaymentHandler", "sht login result %s", Integer.valueOf(j11.m(i10, j10).a()));
        } catch (Exception e11) {
            k.e("PaymentHandler", "sht login error ", e11);
        }
    }

    private boolean s() {
        sd.b h10 = sd.b.h();
        EnumCardAppType enumCardAppType = EnumCardAppType.CARD_APP_TYPE_SH_TOUR;
        try {
            r();
            i2.a j10 = h10.j();
            ArrayList arrayList = new ArrayList();
            arrayList.add(EnumOrderStatus.hasPaid);
            arrayList.add(EnumOrderStatus.failure);
            arrayList.add(EnumOrderStatus.unsettled);
            List<BusinessOrder> j11 = j10.j(0, 10, enumCardAppType, EnumBusinessOrderType.ORDER_TYPE_RECHARGE, arrayList, j10.g(enumCardAppType));
            k.i("PaymentHandler", "shanghai error order %s", j11);
            if (j11 != null) {
                return !j11.isEmpty();
            }
            return false;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }
}
