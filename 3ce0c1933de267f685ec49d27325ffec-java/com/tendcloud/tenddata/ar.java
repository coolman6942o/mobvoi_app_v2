package com.tendcloud.tenddata;
/* compiled from: td */
/* loaded from: classes2.dex */
public class ar {

    /* renamed from: a  reason: collision with root package name */
    private String f22637a;

    /* renamed from: b  reason: collision with root package name */
    private String f22638b;

    /* renamed from: c  reason: collision with root package name */
    private byte f22639c;

    /* renamed from: d  reason: collision with root package name */
    private byte f22640d;

    /* renamed from: e  reason: collision with root package name */
    private byte f22641e;

    public ar() {
        this.f22637a = "";
        this.f22638b = "00:00:00:00:00:00";
        this.f22639c = (byte) -127;
        this.f22640d = (byte) 1;
        this.f22641e = (byte) 1;
    }

    public String a() {
        return this.f22637a;
    }

    public String b() {
        return this.f22638b;
    }

    public byte c() {
        return this.f22639c;
    }

    public byte d() {
        return this.f22640d;
    }

    public byte e() {
        return this.f22641e;
    }

    public ar f() {
        return new ar(this.f22637a, this.f22638b, this.f22639c, this.f22640d, this.f22641e);
    }

    public void setBand(byte b10) {
        this.f22640d = b10;
    }

    public void setBssid(String str) {
        this.f22638b = str;
    }

    public void setChannel(byte b10) {
        this.f22641e = b10;
    }

    public void setRssi(byte b10) {
        this.f22639c = b10;
    }

    public void setSsid(String str) {
        this.f22637a = str;
    }

    public ar(String str, String str2, byte b10, byte b11, byte b12) {
        this.f22637a = str;
        this.f22638b = str2;
        this.f22639c = b10;
        this.f22640d = b11;
        this.f22641e = b12;
    }
}
