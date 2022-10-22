package com.tendcloud.tenddata;

import org.json.JSONObject;
/* compiled from: td */
/* loaded from: classes2.dex */
public class TalkingDataProfile extends JSONObject {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22491a = "name";

    /* renamed from: b  reason: collision with root package name */
    private static final String f22492b = "type";

    /* renamed from: c  reason: collision with root package name */
    private static final String f22493c = "gender";

    /* renamed from: d  reason: collision with root package name */
    private static final String f22494d = "age";

    /* renamed from: e  reason: collision with root package name */
    private static final String f22495e = "property1";

    /* renamed from: f  reason: collision with root package name */
    private static final String f22496f = "property2";

    /* renamed from: g  reason: collision with root package name */
    private static final String f22497g = "property3";

    /* renamed from: h  reason: collision with root package name */
    private static final String f22498h = "property4";

    /* renamed from: i  reason: collision with root package name */
    private static final String f22499i = "property5";

    /* renamed from: j  reason: collision with root package name */
    private static final String f22500j = "property6";

    /* renamed from: k  reason: collision with root package name */
    private static final String f22501k = "property7";

    /* renamed from: l  reason: collision with root package name */
    private static final String f22502l = "property8";

    /* renamed from: m  reason: collision with root package name */
    private static final String f22503m = "property9";

    /* renamed from: n  reason: collision with root package name */
    private static final String f22504n = "property10";

    private TalkingDataProfile() {
    }

    public static TalkingDataProfile createProfile() {
        return new TalkingDataProfile();
    }

    public TalkingDataProfile setAge(int i10) {
        try {
            put(f22494d, i10);
        } catch (Throwable th2) {
            g.a("set age error ", th2);
        }
        return this;
    }

    public TalkingDataProfile setGender(TalkingDataGender talkingDataGender) {
        try {
            put(f22493c, talkingDataGender.index());
        } catch (Throwable th2) {
            g.a("set gender error ", th2);
        }
        return this;
    }

    public TalkingDataProfile setName(String str) {
        try {
            put("name", str);
        } catch (Throwable th2) {
            g.a("set name error ", th2);
        }
        return this;
    }

    public TalkingDataProfile setProperty1(Object obj) {
        try {
            if ((obj instanceof String) || (obj instanceof Number)) {
                put(f22495e, obj);
            }
        } catch (Throwable th2) {
            g.a("set property1 error ", th2);
        }
        return this;
    }

    public TalkingDataProfile setProperty10(Object obj) {
        try {
            if ((obj instanceof String) || (obj instanceof Number)) {
                put(f22504n, obj);
            }
        } catch (Throwable th2) {
            g.a("set property10 error ", th2);
        }
        return this;
    }

    public TalkingDataProfile setProperty2(Object obj) {
        try {
            if ((obj instanceof String) || (obj instanceof Number)) {
                put(f22496f, obj);
            }
        } catch (Throwable th2) {
            g.a("set property2 error ", th2);
        }
        return this;
    }

    public TalkingDataProfile setProperty3(Object obj) {
        try {
            if ((obj instanceof String) || (obj instanceof Number)) {
                put(f22497g, obj);
            }
        } catch (Throwable th2) {
            g.a("set property3 error ", th2);
        }
        return this;
    }

    public TalkingDataProfile setProperty4(Object obj) {
        try {
            if ((obj instanceof String) || (obj instanceof Number)) {
                put(f22498h, obj);
            }
        } catch (Throwable th2) {
            g.a("set property4 error ", th2);
        }
        return this;
    }

    public TalkingDataProfile setProperty5(Object obj) {
        try {
            if ((obj instanceof String) || (obj instanceof Number)) {
                put(f22499i, obj);
            }
        } catch (Throwable th2) {
            g.a("set property5 error ", th2);
        }
        return this;
    }

    public TalkingDataProfile setProperty6(Object obj) {
        try {
            if ((obj instanceof String) || (obj instanceof Number)) {
                put(f22500j, obj);
            }
        } catch (Throwable th2) {
            g.a("set property6 error ", th2);
        }
        return this;
    }

    public TalkingDataProfile setProperty7(Object obj) {
        try {
            if ((obj instanceof String) || (obj instanceof Number)) {
                put(f22501k, obj);
            }
        } catch (Throwable th2) {
            g.a("set property7 error ", th2);
        }
        return this;
    }

    public TalkingDataProfile setProperty8(Object obj) {
        try {
            if ((obj instanceof String) || (obj instanceof Number)) {
                put(f22502l, obj);
            }
        } catch (Throwable th2) {
            g.a("set property8 error ", th2);
        }
        return this;
    }

    public TalkingDataProfile setProperty9(Object obj) {
        try {
            if ((obj instanceof String) || (obj instanceof Number)) {
                put(f22503m, obj);
            }
        } catch (Throwable th2) {
            g.a("set property9 error ", th2);
        }
        return this;
    }

    public TalkingDataProfile setType(TalkingDataProfileType talkingDataProfileType) {
        try {
            put("type", talkingDataProfileType.index());
        } catch (Throwable th2) {
            g.a("set type error ", th2);
        }
        return this;
    }
}
