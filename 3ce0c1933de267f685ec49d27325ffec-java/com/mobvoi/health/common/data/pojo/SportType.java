package com.mobvoi.health.common.data.pojo;

import com.mobvoi.wear.common.base.TicwatchModels;
/* loaded from: classes2.dex */
public enum SportType {
    Unknown(-1),
    More(-2),
    OutdoorRunning(0),
    OutdoorWalk(1),
    IndoorRunning(2),
    OutdoorBike(3),
    FreeWorkout(4),
    AutoWalking(5),
    AutoRunning(6),
    BandRunning(7),
    BandAutoWalking(8),
    Swimming(9),
    AutoCycling(10),
    AutoSwimming(11),
    IndoorCycling(12),
    RowingMachine(13),
    EllipticalMachine(14),
    Yoga(15),
    BodyMechanics(16),
    Climbing(17),
    OffRoad(18),
    RopeSkipping(19),
    Gymnastics(20),
    Football(21),
    Basketball(22),
    Spinning(23),
    Hiit(24),
    Burpee(25),
    MountainClimber(26),
    HighKnees(27),
    SquatJumps(28),
    Plank(29),
    JumpingJack(30),
    TwistingMountainClimber(31),
    ReverseCrunch(32),
    SquatPunch(33),
    Bridge(34),
    Rest(35),
    GroupRest(36),
    HiitOther(37),
    Pilates(50),
    Taekwondo(51),
    Badminton(52),
    TableTennis(53),
    Skating(54),
    OpenWaterSwimming(55),
    Tennis(56),
    Baseball(57),
    Volleyball(58),
    Cricket(59),
    Rugby(60),
    Hockey(61),
    Dance(62),
    AbdominalCurl(63),
    Crawl(64),
    BendOverAndClimbTheRope(65),
    OneLegBalance(66),
    ChestExpandingExercise(67),
    WristRotation(68),
    SideStretch(69),
    SideLift(70),
    Recommend(71),
    Pingju(72),
    Strike(73),
    Swing(74),
    StraightBoxing(75),
    BowToRow(76),
    Rowing(77),
    Paddle(78),
    InclinedLowerSwingArm(79),
    HandDepression(80),
    HandDownAndBackSwing(81),
    BodyFlexionAndRotation(82),
    BendingLift(83),
    HardPull(84),
    UpperAndLowerSwingArms(85),
    OneHandedSmash(86),
    HipHighFive(87),
    PullUp(88),
    BackPullUp(89),
    HighLegRun(90),
    SittingPullDown(91),
    GoFishing(92),
    HuLaHoop(93),
    Riding(94),
    Polo(95),
    Golf(96),
    IceHockey(97),
    Squash(98),
    Archery(99),
    Weightlifting(100),
    PaddlePaddle(101),
    Sailboat(102),
    Surfing(103),
    AMartialArt(104),
    Shooting(105),
    TugOfWar(106),
    DifficultRockClimbing(107),
    FieldRockClimbing(108),
    Bouldering(109),
    RollerSkating(110),
    Fencing(111),
    OffRoadVehicle(112),
    AtvQuadFrenzy(113),
    Skydiving(114),
    BungeeJumping(115),
    Squat(116),
    Skate(117),
    TaijiBoxing(118),
    WaterPolo(119),
    BeachVolleyball(120),
    Snorkeling(121),
    InclineDumbbellPress(122),
    StandingOutsideStretch(123),
    MilitaryPress(124),
    ArnoldRecommended(125),
    ShoulderWrap(126),
    AlternatingFrontFlatLift(127),
    UpwardInclinedDumbbellCurl(128),
    FigureSkating(129),
    BattlingRopes(130),
    LegPress(131),
    TreadmillRunning(132);
    
    public final int typeCode;

    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17965a;

        static {
            int[] iArr = new int[SportType.values().length];
            f17965a = iArr;
            try {
                iArr[SportType.OutdoorWalk.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17965a[SportType.OutdoorRunning.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17965a[SportType.OutdoorBike.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17965a[SportType.AutoWalking.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17965a[SportType.AutoRunning.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17965a[SportType.AutoCycling.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17965a[SportType.BandRunning.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f17965a[SportType.Climbing.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f17965a[SportType.OffRoad.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f17965a[SportType.Skating.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f17965a[SportType.Golf.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f17965a[SportType.AutoSwimming.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    SportType(int i10) {
        this.typeCode = i10;
    }

    public static SportType from(int i10) {
        SportType[] values;
        for (SportType sportType : values()) {
            if (sportType.typeCode == i10) {
                return sportType;
            }
        }
        return Unknown;
    }

    public long getMinRecordDuration() {
        int i10 = a.f17965a[ordinal()];
        if (i10 == 4) {
            return pf.a.f32766a;
        }
        if (i10 == 5) {
            return pf.a.f32767b;
        }
        if (i10 == 6) {
            return pf.a.f32768c;
        }
        if (i10 != 12) {
            return pf.a.f32772g;
        }
        return pf.a.f32769d;
    }

    public long getMotionDelayTime(boolean z10) {
        if (a.f17965a[ordinal()] == 5 && z10) {
            return pf.a.f32770e;
        }
        return pf.a.f32771f;
    }

    public boolean isAutoSport() {
        return this == AutoWalking || this == AutoCycling || this == AutoRunning || this == AutoSwimming || this == BandAutoWalking;
    }

    public boolean isCountType() {
        return this == Burpee || this == SquatJumps || this == JumpingJack || this == RopeSkipping || this == AbdominalCurl;
    }

    public boolean isRunning() {
        return this == AutoRunning || this == OutdoorRunning || this == IndoorRunning;
    }

    public boolean isSupportCount() {
        return supportCountModel() && isCountType();
    }

    public boolean isSwimming() {
        return this == AutoSwimming || this == Swimming;
    }

    public boolean onlyHaveCalorie() {
        return this == IndoorCycling || this == EllipticalMachine || this == Yoga || this == BodyMechanics || this == RowingMachine || this == Football || this == Basketball || this == Pilates || this == Taekwondo || this == Badminton || this == TableTennis || this == OpenWaterSwimming || this == Tennis || this == Baseball || this == Volleyball || this == Cricket || this == Rugby || this == Hockey || this == Dance || this == AbdominalCurl || this == Crawl || this == BendOverAndClimbTheRope || this == OneLegBalance || this == ChestExpandingExercise || this == WristRotation || this == SideStretch || this == SideLift || this == Recommend || this == Pingju || this == Strike || this == Swing || this == StraightBoxing || this == BowToRow || this == Rowing || this == FigureSkating || this == LegPress || this == HandDepression || this == BattlingRopes || this == BodyFlexionAndRotation || this == BendingLift || this == HardPull || this == UpperAndLowerSwingArms || this == OneHandedSmash || this == HipHighFive || this == PullUp || this == BackPullUp || this == HighLegRun || this == SittingPullDown || this == GoFishing || this == HuLaHoop || this == Riding || this == Polo || this == Golf || this == IceHockey || this == Squash || this == Archery || this == Weightlifting || this == PaddlePaddle || this == Sailboat || this == Surfing || this == AMartialArt || this == Shooting || this == TugOfWar || this == DifficultRockClimbing || this == FieldRockClimbing || this == Bouldering || this == RollerSkating || this == Fencing || this == OffRoadVehicle || this == AtvQuadFrenzy || this == Skydiving || this == BungeeJumping || this == Squat || this == Skate || this == TaijiBoxing || this == WaterPolo || this == BeachVolleyball || this == Snorkeling || this == InclineDumbbellPress || this == StandingOutsideStretch || this == MilitaryPress || this == ArnoldRecommended || this == ShoulderWrap || this == AlternatingFrontFlatLift || this == UpwardInclinedDumbbellCurl || this == Burpee || this == MountainClimber || this == HighKnees || this == SquatJumps || this == Plank || this == JumpingJack || this == TwistingMountainClimber || this == ReverseCrunch || this == SquatPunch || this == Bridge || this == Skating;
    }

    public boolean supportCountModel() {
        return TicwatchModels.isE3() || TicwatchModels.isRover() || TicwatchModels.isRoverU() || TicwatchModels.isRover3X();
    }

    public boolean supportGps() {
        switch (a.f17965a[ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                return true;
            default:
                return false;
        }
    }

    public boolean supportHiitTimes() {
        return this == Burpee || this == JumpingJack || this == SquatJumps;
    }

    public boolean supportLap() {
        return this == AutoRunning || this == OutdoorRunning || this == AutoCycling || this == OutdoorBike || this == OffRoad || this == AutoWalking || this == OutdoorWalk;
    }

    public boolean supportPause() {
        return this == OutdoorRunning || this == OutdoorWalk || this == IndoorRunning || this == OutdoorBike || this == AutoWalking || this == AutoRunning || this == Swimming || this == AutoCycling || this == AutoSwimming || this == IndoorCycling || this == Climbing || this == OffRoad;
    }

    public static SportType from(String str) {
        try {
            return valueOf(str);
        } catch (Exception unused) {
            if ("hiit".equals(str)) {
                return Hiit;
            }
            return Unknown;
        }
    }
}
