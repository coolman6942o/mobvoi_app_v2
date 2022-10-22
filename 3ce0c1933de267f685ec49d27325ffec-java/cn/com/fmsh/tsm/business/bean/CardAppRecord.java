package cn.com.fmsh.tsm.business.bean;

import cn.com.fmsh.tsm.business.enums.EnumTradeType;
import java.io.Serializable;
/* loaded from: classes.dex */
public class CardAppRecord implements Serializable {
    private static final /* synthetic */ long serialVersionUID = 1;

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ EnumTradeType f6146a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ byte f6147b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ byte f6148c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ int f6149d;

    /* renamed from: e  reason: collision with root package name */
    private /* synthetic */ int f6150e;

    /* renamed from: f  reason: collision with root package name */
    private /* synthetic */ int f6151f;

    /* renamed from: g  reason: collision with root package name */
    private /* synthetic */ String f6152g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ String f6153h;

    /* renamed from: i  reason: collision with root package name */
    private /* synthetic */ String f6154i;

    /* renamed from: j  reason: collision with root package name */
    private /* synthetic */ int f6155j;

    public int getAmount() {
        return this.f6149d;
    }

    public int getBalance() {
        return this.f6150e;
    }

    public byte getOriTradeType() {
        return this.f6148c;
    }

    public int getOverdraft() {
        return this.f6155j;
    }

    public byte getTerminalTradeType() {
        return this.f6147b;
    }

    public String getTradeDate() {
        return this.f6152g;
    }

    public String getTradeDevice() {
        return this.f6154i;
    }

    public int getTradeNo() {
        return this.f6151f;
    }

    public String getTradeTime() {
        return this.f6153h;
    }

    public EnumTradeType getTradeType() {
        return this.f6146a;
    }

    public void setAmount(int i10) {
        this.f6149d = i10;
    }

    public void setBalance(int i10) {
        this.f6150e = i10;
    }

    public void setOriTradeType(byte b10) {
        this.f6148c = b10;
    }

    public void setOverdraft(int i10) {
        this.f6155j = i10;
    }

    public void setTerminalTradeType(byte b10) {
        this.f6147b = b10;
    }

    public void setTradeDate(String str) {
        this.f6152g = str;
    }

    public void setTradeDevice(String str) {
        this.f6154i = str;
    }

    public void setTradeNo(int i10) {
        this.f6151f = i10;
    }

    public void setTradeTime(String str) {
        this.f6153h = str;
    }

    public void setTradeType(EnumTradeType enumTradeType) {
        this.f6146a = enumTradeType;
    }
}
