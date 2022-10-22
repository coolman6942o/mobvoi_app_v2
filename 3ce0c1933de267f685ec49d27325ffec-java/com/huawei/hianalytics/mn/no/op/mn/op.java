package com.huawei.hianalytics.mn.no.op.mn;

import java.util.Map;
/* loaded from: classes.dex */
public class op {

    /* renamed from: a  reason: collision with root package name */
    private String f13552a;

    /* renamed from: b  reason: collision with root package name */
    private int f13553b;

    /* renamed from: c  reason: collision with root package name */
    private int f13554c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f13555d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f13556e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f13557f;

    /* renamed from: g  reason: collision with root package name */
    private String f13558g;

    /* renamed from: h  reason: collision with root package name */
    private long f13559h;

    /* renamed from: mn  reason: collision with root package name */
    private boolean f13560mn;

    /* renamed from: no  reason: collision with root package name */
    private boolean f13561no;

    /* renamed from: op  reason: collision with root package name */
    private String f13562op;
    private String pq;
    private String qr;
    private String rs;
    private no st;
    private String tu;
    private Map<String, String> uv;

    public op() {
        this.qr = "";
        this.rs = "";
        this.st = new no();
        this.tu = "";
        this.f13552a = "";
        this.f13553b = 10;
        this.f13554c = 7;
        this.f13555d = true;
        this.f13556e = true;
        this.f13557f = false;
        this.f13559h = 0L;
    }

    public op(op opVar) {
        this.qr = "";
        this.rs = "";
        this.st = new no();
        this.tu = "";
        this.f13552a = "";
        this.f13553b = 10;
        this.f13554c = 7;
        this.f13555d = true;
        this.f13556e = true;
        this.f13557f = false;
        this.f13559h = 0L;
        this.st = opVar.st;
        no(opVar.f13560mn);
        mn(opVar.f13562op);
        no(opVar.pq);
        op(opVar.qr);
        pq(opVar.rs);
        qr(opVar.tu);
        rs(opVar.f13552a);
        mn(opVar.f13561no);
        no(opVar.f13553b);
        mn(opVar.f13554c);
        op(opVar.f13555d);
        pq(opVar.f13556e);
        qr(opVar.f13557f);
        mn(opVar.uv);
        st(opVar.f13558g);
        mn(opVar.f13559h);
    }

    public String a() {
        return this.rs;
    }

    public String b() {
        return this.tu;
    }

    public String c() {
        return this.f13552a;
    }

    public boolean d() {
        return this.f13555d;
    }

    public boolean e() {
        return this.f13556e;
    }

    public boolean f() {
        return this.f13557f;
    }

    public String g() {
        return this.f13558g;
    }

    public long h() {
        return this.f13559h;
    }

    public Map<String, String> mn() {
        return this.uv;
    }

    public void mn(int i10) {
        this.f13554c = i10;
    }

    public void mn(long j10) {
        this.f13559h = j10;
    }

    public void mn(String str) {
        this.f13562op = str;
    }

    public void mn(Map<String, String> map) {
        this.uv = map;
    }

    public void mn(boolean z10) {
        this.f13561no = z10;
    }

    public no no() {
        return this.st;
    }

    public void no(int i10) {
        this.f13553b = i10;
    }

    public void no(String str) {
        this.pq = str;
    }

    public void no(boolean z10) {
        this.f13560mn = z10;
    }

    public int op() {
        return this.f13554c;
    }

    public void op(String str) {
        this.qr = str;
    }

    public void op(boolean z10) {
        this.f13555d = z10;
    }

    public int pq() {
        return this.f13553b;
    }

    public void pq(String str) {
        this.rs = str;
    }

    public void pq(boolean z10) {
        this.f13556e = z10;
    }

    public void qr(String str) {
        this.tu = str;
    }

    public void qr(boolean z10) {
        this.f13557f = z10;
    }

    public boolean qr() {
        return this.f13561no;
    }

    public void rs(String str) {
        this.f13552a = str;
    }

    public boolean rs() {
        return this.f13560mn;
    }

    public String st() {
        return this.f13562op;
    }

    public void st(String str) {
        this.f13558g = str;
    }

    public String tu() {
        return this.pq;
    }

    public String uv() {
        return this.qr;
    }
}
