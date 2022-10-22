package com.mobvoi.companion.health.viewholder;

import com.mobvoi.companion.R;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.collections.d0;
/* compiled from: VpaCardEnum.kt */
/* loaded from: classes2.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<String, Byte> f17114a;

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<Byte, k> f17115b;

    static {
        HashMap<String, Byte> g10;
        HashMap<Byte, k> g11;
        g10 = d0.g(new Pair("CARD_AW_ACTIVITY", (byte) 1), new Pair("CARD_MCU_ACTIVITY", (byte) 1), new Pair("CARD_SPORT", (byte) 2), new Pair("CARD_SLEEP", (byte) 3), new Pair("CARD_AW_HEART_RATE", (byte) 4), new Pair("CARD_MCU_HEART_RATE", (byte) 4), new Pair("CARD_BLOOD_OXYGEN", (byte) 5), new Pair("CARD_TEMPERATION", (byte) 6), new Pair("CARD_PRESSURE", (byte) 7), new Pair("CARD_BODY_MIND_STATE", (byte) 8), new Pair("CARD_NOISE", (byte) 9), new Pair("CARD_HEART_24H_DETECT", (byte) 10));
        f17114a = g10;
        g11 = d0.g(new Pair((byte) 1, new k((byte) 1, R.string.home_tab_card_activity, null, null, false, 28, null)), new Pair((byte) 2, new k((byte) 2, R.string.home_tab_card_fitness, null, null, false, 28, null)), new Pair((byte) 3, new k((byte) 3, R.string.home_tab_card_sleep, null, null, false, 28, null)), new Pair((byte) 4, new k((byte) 4, R.string.home_tab_card_pulse, null, null, false, 28, null)), new Pair((byte) 5, new k((byte) 5, R.string.home_tab_card_blood_oxygen, null, null, false, 28, null)), new Pair((byte) 6, new k((byte) 6, R.string.home_tab_card_temperature, null, null, false, 28, null)), new Pair((byte) 7, new k((byte) 7, R.string.home_tab_card_pressure, null, null, false, 28, null)), new Pair((byte) 8, new k((byte) 8, R.string.body_mind_state_str, null, null, false, 28, null)), new Pair((byte) 9, new k((byte) 9, R.string.home_tab_card_noise, null, null, false, 28, null)), new Pair((byte) 10, new k((byte) 10, R.string.heart_health_monitoring, null, null, false, 28, null)));
        f17115b = g11;
    }

    public static final HashMap<Byte, k> a() {
        return f17115b;
    }

    public static final HashMap<String, Byte> b() {
        return f17114a;
    }
}
