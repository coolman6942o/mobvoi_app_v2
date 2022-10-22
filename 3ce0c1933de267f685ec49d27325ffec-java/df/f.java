package df;

import com.alibaba.fastjson.annotation.JSONField;
import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.wear.common.base.Constants;
/* compiled from: NetTrackPoint.java */
/* loaded from: classes2.dex */
public class f implements JsonBean {
    @JSONField(name = "gps_point")
    public String GPSPoint;
    @JSONField(name = "gps_state")
    public String GPSState;
    @JSONField(name = "cumulative_distance")
    public int distance;
    @JSONField(name = "elevation")
    public float elevation;
    @JSONField(name = "heart_rate")
    public int heart;
    @JSONField(name = "resume")
    public boolean resume;
    @JSONField(name = "velocity")
    public double speed;
    @JSONField(name = "cumulative_steps")
    public int steps;
    @JSONField(name = "swim_stroke")
    public int swimStroke;
    @JSONField(name = Constants.Fitness.DATA_TRIPS)
    public float swimTrips;
    @JSONField(name = "swim_type")
    public int swimType;
    @JSONField(name = "timestamp")
    public long time;
    @JSONField(name = "wall_clock_timestamp")
    public long wallClockTimestamp;
}
