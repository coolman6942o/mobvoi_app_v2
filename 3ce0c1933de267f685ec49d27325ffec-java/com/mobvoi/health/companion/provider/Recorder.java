package com.mobvoi.health.companion.provider;

import com.mobvoi.android.common.json.JsonBean;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes2.dex */
public class Recorder implements JsonBean {
    public static final int BAD_REQUEST = -1;
    public static final int DO_NOT_RESTORE_TO_WEAR = 4;
    public static final int EMPTY_RECORDERS = 3;
    public static final int NEED_SYNC = 2;
    public static final int NOT_ONLINE = 1;
    public static final int OK = 0;
    public static final int SERVER_ERROR = -2;
    public List<Item> cals;
    public int current_step;
    public List<Item> distances;
    public List<Item> durations;
    public int endTime;
    public int err_code;
    public String err_msg;
    public int goal;
    public int health_count_goal;
    public int health_count_start;
    public int health_time_goal;
    public List<Item> heart_rates;
    public int interval;
    public long messageId;
    public List<Item> motionTypes;
    public int startTime;
    public List<Item> steps;
    public List<Item> time_list;
    public int total;

    /* loaded from: classes2.dex */
    public static class Item implements Serializable {
        public int time;
        public int value;

        public Item() {
        }

        public String toString() {
            return "Item{index =" + this.time + ", value=" + this.value + '}';
        }

        public Item(int i10, int i11) {
            this.time = i10;
            this.value = i11;
        }
    }
}
