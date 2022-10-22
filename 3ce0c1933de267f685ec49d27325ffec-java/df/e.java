package df;

import com.alibaba.fastjson.annotation.JSONField;
import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.wear.common.base.Constants;
import java.util.ArrayList;
import java.util.List;
/* compiled from: NetSportRecord.java */
/* loaded from: classes2.dex */
public class e implements JsonBean {
    @JSONField(name = "avg_heart_rate")
    public int avgHeartRate;
    @JSONField(name = "cumulative_down")
    public float cumulativeDown;
    @JSONField(name = "cumulative_up")
    public float cumulativeUp;
    @JSONField(name = "device_id")
    public String deviceId;
    @JSONField(name = "end_at")
    public long endAt;
    @JSONField(name = "newTypeObj")
    public String extra;
    @JSONField(name = "groups")
    public String groups;
    @JSONField(name = "max_elevation")
    public float maxElevation;
    @JSONField(name = "min_elevation")
    public float minElevation;
    @JSONField(name = "id")
    public String motionId;
    @JSONField(name = "type")
    public String motionType;
    @JSONField(name = "objective")
    public double objective;
    @JSONField(name = "obj_type")
    public String objectiveType;
    @JSONField(name = "score")
    public float score;
    @JSONField(name = "session_mode")
    public Integer sessionMode;
    @JSONField(name = "start_at")
    public long startAt;
    @JSONField(name = "swim_distance")
    public int swimDistance;
    @JSONField(name = "swim_pool_length")
    public int swimPoolLength;
    @JSONField(name = "swim_stroke")
    public int swimStroke;
    @JSONField(name = Constants.Fitness.DATA_TRIPS)
    public float swimTrips;
    @JSONField(name = "timestamp")
    @Deprecated
    public long timestamp;
    @JSONField(name = "total_calorie")
    public int totalCalorie;
    @JSONField(name = "total_distance")
    public int totalDistance;
    @JSONField(name = "total_motion_time")
    public long totalMotionTime;
    @JSONField(name = "total_steps")
    public int totalSteps;
    @JSONField(name = "pause_time_ranges")
    @Deprecated
    public List<String> pauseTimeRanges = new ArrayList();
    @JSONField(name = "track_points")
    public List<f> trackPoints = new ArrayList();
}
