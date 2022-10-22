package cn.com.fmsh.tsm.business.bean;

import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import cn.com.fmsh.tsm.business.enums.EnumBusinessOrderLoadType;
import cn.com.fmsh.tsm.business.enums.EnumBusinessOrderType;
import cn.com.fmsh.tsm.business.enums.EnumCardAppType;
import cn.com.fmsh.tsm.business.enums.EnumCardIoType;
import cn.com.fmsh.tsm.business.enums.EnumOrderStatus;
import com.realsil.sdk.dfu.DfuException;
import f2.c;
import java.io.Serializable;
import x2.f;
import z2.a;
import z2.b;
/* loaded from: classes.dex */
public class BusinessOrder implements Serializable {
    private static final /* synthetic */ long serialVersionUID = 1;

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ String f6127a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f6128b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ byte[] f6129c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ int f6130d;

    /* renamed from: e  reason: collision with root package name */
    private /* synthetic */ EnumOrderStatus f6131e;

    /* renamed from: f  reason: collision with root package name */
    private /* synthetic */ int f6132f;

    /* renamed from: g  reason: collision with root package name */
    private /* synthetic */ byte[] f6133g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ byte[] f6134h;

    /* renamed from: i  reason: collision with root package name */
    private /* synthetic */ String f6135i;

    /* renamed from: j  reason: collision with root package name */
    private /* synthetic */ int f6136j;

    /* renamed from: k  reason: collision with root package name */
    private /* synthetic */ int f6137k;

    /* renamed from: l  reason: collision with root package name */
    private /* synthetic */ EnumCardIoType f6138l;

    /* renamed from: m  reason: collision with root package name */
    private /* synthetic */ EnumCardAppType f6139m;

    /* renamed from: n  reason: collision with root package name */
    private /* synthetic */ EnumBusinessOrderType f6140n;

    /* renamed from: o  reason: collision with root package name */
    private /* synthetic */ String f6141o;

    /* renamed from: p  reason: collision with root package name */
    private /* synthetic */ byte[] f6142p;

    /* renamed from: q  reason: collision with root package name */
    private /* synthetic */ String f6143q;

    /* renamed from: r  reason: collision with root package name */
    private /* synthetic */ byte[] f6144r;

    /* renamed from: s  reason: collision with root package name */
    private /* synthetic */ EnumBusinessOrderLoadType f6145s;

    public static BusinessOrder fromTag(c cVar) throws FMCommunicationMessageException {
        a b10 = b.a().b();
        if (cVar == null) {
            if (b10 != null) {
                b10.c(BusinessOrder.class.getName(), x2.a.b("Hz=畆戈不勷请十日～\u0005qh宷谬丶穱", 172, 31));
            }
            return null;
        }
        c[] j10 = cVar.j();
        if (j10 == null || j10.length < 1) {
            if (b10 != null) {
                b10.c(BusinessOrder.class.getName(), f.a("Nvs甎戞丑助讧南斩ｐ\r74嬀頴买稽", DfuException.ERROR_USER_NOT_ACTIVE_IMAGE_ERROR));
            }
            return null;
        }
        BusinessOrder businessOrder = new BusinessOrder();
        for (c cVar2 : j10) {
            byte id2 = cVar2.getId();
            if (id2 == -79) {
                businessOrder.setSeid(cVar2.h());
            } else if (id2 == -55) {
                businessOrder.setBusinessOrderLoadType(EnumBusinessOrderLoadType.getBusinessOrderLoadType4ID(cVar2.d()));
            } else if (id2 == 47) {
                businessOrder.setCardIoType(EnumCardIoType.getCardIoType(cVar2.d()));
            } else if (id2 != 72) {
                switch (id2) {
                    case 13:
                        businessOrder.setPayChannel(cVar2.d());
                        continue;
                    case 14:
                        businessOrder.setCardAppType(EnumCardAppType.instance(cVar2.d()));
                        continue;
                    case 15:
                        businessOrder.setCardNo(x2.c.m(cVar2.g()));
                        continue;
                    case 16:
                        businessOrder.setAmount(x2.c.e(cVar2.h()));
                        continue;
                    case 17:
                        businessOrder.setOrder(cVar2.h());
                        continue;
                    default:
                        switch (id2) {
                            case 19:
                                businessOrder.setTradeDate(cVar2.g());
                                continue;
                            case 20:
                                businessOrder.setTradeTime(cVar2.g());
                                continue;
                            case 21:
                                businessOrder.setTradeState(EnumOrderStatus.getOrderStatus4ID(cVar2.d()));
                                continue;
                            case 22:
                                businessOrder.setSerialNo(x2.c.e(cVar2.h()));
                                continue;
                            case 23:
                                businessOrder.setTerminalNo(x2.c.m(cVar2.g()));
                                continue;
                            case 24:
                                businessOrder.setInvoiceStatus(cVar2.d());
                                continue;
                            default:
                                switch (id2) {
                                    case 103:
                                        businessOrder.setProduct(cVar2.g());
                                        continue;
                                    case 104:
                                        businessOrder.setDeviceModel(cVar2.g());
                                        continue;
                                    case 105:
                                        businessOrder.setMainOrder(cVar2.h());
                                        continue;
                                        continue;
                                        continue;
                                }
                        }
                }
            } else {
                businessOrder.setBusinessOrderType(EnumBusinessOrderType.instance(cVar2.d()));
            }
        }
        return businessOrder;
    }

    public int getAmount() {
        return this.f6130d;
    }

    public EnumBusinessOrderLoadType getBusinessOrderLoadType() {
        return this.f6145s;
    }

    public EnumBusinessOrderType getBusinessOrderType() {
        return this.f6140n;
    }

    public EnumCardAppType getCardAppType() {
        return this.f6139m;
    }

    public EnumCardIoType getCardIoType() {
        return this.f6138l;
    }

    public byte[] getCardNo() {
        return this.f6133g;
    }

    public String getDeviceModel() {
        return this.f6143q;
    }

    public int getInvoiceStatus() {
        return this.f6136j;
    }

    public byte[] getMainOrder() {
        return this.f6144r;
    }

    public byte[] getOrder() {
        return this.f6129c;
    }

    public int getPayChannel() {
        return this.f6137k;
    }

    public String getProduct() {
        return this.f6141o;
    }

    public byte[] getSeid() {
        return this.f6142p;
    }

    public int getSerialNo() {
        return this.f6132f;
    }

    public String getTac() {
        return this.f6135i;
    }

    public byte[] getTerminalNo() {
        return this.f6134h;
    }

    public String getTradeDate() {
        return this.f6127a;
    }

    public EnumOrderStatus getTradeState() {
        return this.f6131e;
    }

    public String getTradeTime() {
        return this.f6128b;
    }

    public void setAmount(int i10) {
        this.f6130d = i10;
    }

    public void setBusinessOrderLoadType(EnumBusinessOrderLoadType enumBusinessOrderLoadType) {
        this.f6145s = enumBusinessOrderLoadType;
    }

    public void setBusinessOrderType(EnumBusinessOrderType enumBusinessOrderType) {
        this.f6140n = enumBusinessOrderType;
    }

    public void setCardAppType(EnumCardAppType enumCardAppType) {
        this.f6139m = enumCardAppType;
    }

    public void setCardIoType(EnumCardIoType enumCardIoType) {
        this.f6138l = enumCardIoType;
    }

    public void setCardNo(byte[] bArr) {
        this.f6133g = bArr;
    }

    public void setDeviceModel(String str) {
        this.f6143q = str;
    }

    public void setInvoiceStatus(int i10) {
        this.f6136j = i10;
    }

    public void setMainOrder(byte[] bArr) {
        this.f6144r = bArr;
    }

    public void setOrder(byte[] bArr) {
        this.f6129c = bArr;
    }

    public void setPayChannel(int i10) {
        this.f6137k = i10;
    }

    public void setProduct(String str) {
        this.f6141o = str;
    }

    public void setSeid(byte[] bArr) {
        this.f6142p = bArr;
    }

    public void setSerialNo(int i10) {
        this.f6132f = i10;
    }

    public void setTac(String str) {
        this.f6135i = str;
    }

    public void setTerminalNo(byte[] bArr) {
        this.f6134h = bArr;
    }

    public void setTradeDate(String str) {
        this.f6127a = str;
    }

    public void setTradeState(EnumOrderStatus enumOrderStatus) {
        this.f6131e = enumOrderStatus;
    }

    public void setTradeTime(String str) {
        this.f6128b = str;
    }
}
