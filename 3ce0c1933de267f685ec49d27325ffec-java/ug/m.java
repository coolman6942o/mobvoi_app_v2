package ug;

import android.content.Context;
import com.mobvoi.companion.base.settings.a;
import com.mobvoi.health.common.data.pojo.SportType;
import java.util.ArrayList;
import java.util.List;
/* compiled from: SportTypeStateful.java */
/* loaded from: classes2.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public SportType f35434a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f35435b;

    /* renamed from: c  reason: collision with root package name */
    public String f35436c;

    public m() {
    }

    public static List<SportType> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SportType.OutdoorRunning);
        arrayList.add(SportType.OutdoorWalk);
        arrayList.add(SportType.OutdoorBike);
        arrayList.add(SportType.AutoRunning);
        arrayList.add(SportType.AutoWalking);
        arrayList.add(SportType.AutoCycling);
        arrayList.add(SportType.IndoorRunning);
        arrayList.add(SportType.Swimming);
        arrayList.add(SportType.OffRoad);
        arrayList.add(SportType.IndoorCycling);
        arrayList.add(SportType.Spinning);
        arrayList.add(SportType.FreeWorkout);
        arrayList.add(SportType.Hiit);
        arrayList.add(SportType.Climbing);
        arrayList.add(SportType.Football);
        arrayList.add(SportType.Basketball);
        arrayList.add(SportType.Badminton);
        arrayList.add(SportType.TableTennis);
        arrayList.add(SportType.RowingMachine);
        arrayList.add(SportType.EllipticalMachine);
        arrayList.add(SportType.RopeSkipping);
        arrayList.add(SportType.Skating);
        arrayList.add(SportType.Yoga);
        arrayList.add(SportType.BodyMechanics);
        arrayList.add(SportType.Gymnastics);
        arrayList.add(SportType.Pilates);
        arrayList.add(SportType.Taekwondo);
        arrayList.add(SportType.Burpee);
        arrayList.add(SportType.MountainClimber);
        arrayList.add(SportType.HighKnees);
        arrayList.add(SportType.SquatJumps);
        arrayList.add(SportType.Plank);
        arrayList.add(SportType.TwistingMountainClimber);
        arrayList.add(SportType.ReverseCrunch);
        arrayList.add(SportType.SquatPunch);
        arrayList.add(SportType.Bridge);
        arrayList.add(SportType.JumpingJack);
        arrayList.add(SportType.Tennis);
        arrayList.add(SportType.Baseball);
        arrayList.add(SportType.Volleyball);
        arrayList.add(SportType.Cricket);
        arrayList.add(SportType.Rugby);
        arrayList.add(SportType.Hockey);
        arrayList.add(SportType.Dance);
        arrayList.add(SportType.AbdominalCurl);
        arrayList.add(SportType.Crawl);
        arrayList.add(SportType.BendOverAndClimbTheRope);
        arrayList.add(SportType.OneLegBalance);
        arrayList.add(SportType.ChestExpandingExercise);
        arrayList.add(SportType.WristRotation);
        arrayList.add(SportType.SideStretch);
        arrayList.add(SportType.SideLift);
        arrayList.add(SportType.Recommend);
        arrayList.add(SportType.Pingju);
        arrayList.add(SportType.Strike);
        arrayList.add(SportType.Swing);
        arrayList.add(SportType.StraightBoxing);
        arrayList.add(SportType.BowToRow);
        arrayList.add(SportType.Rowing);
        arrayList.add(SportType.FigureSkating);
        arrayList.add(SportType.LegPress);
        arrayList.add(SportType.HandDepression);
        arrayList.add(SportType.BattlingRopes);
        arrayList.add(SportType.BodyFlexionAndRotation);
        arrayList.add(SportType.BendingLift);
        arrayList.add(SportType.HardPull);
        arrayList.add(SportType.UpperAndLowerSwingArms);
        arrayList.add(SportType.OneHandedSmash);
        arrayList.add(SportType.HipHighFive);
        arrayList.add(SportType.PullUp);
        arrayList.add(SportType.BackPullUp);
        arrayList.add(SportType.HighLegRun);
        arrayList.add(SportType.SittingPullDown);
        arrayList.add(SportType.GoFishing);
        arrayList.add(SportType.HuLaHoop);
        arrayList.add(SportType.Riding);
        arrayList.add(SportType.Polo);
        arrayList.add(SportType.Golf);
        arrayList.add(SportType.IceHockey);
        arrayList.add(SportType.Squash);
        arrayList.add(SportType.Archery);
        arrayList.add(SportType.Weightlifting);
        arrayList.add(SportType.PaddlePaddle);
        arrayList.add(SportType.Sailboat);
        arrayList.add(SportType.Surfing);
        arrayList.add(SportType.AMartialArt);
        arrayList.add(SportType.Shooting);
        arrayList.add(SportType.TugOfWar);
        arrayList.add(SportType.DifficultRockClimbing);
        arrayList.add(SportType.FieldRockClimbing);
        arrayList.add(SportType.Bouldering);
        arrayList.add(SportType.RollerSkating);
        arrayList.add(SportType.Fencing);
        arrayList.add(SportType.OffRoadVehicle);
        arrayList.add(SportType.AtvQuadFrenzy);
        arrayList.add(SportType.Skydiving);
        arrayList.add(SportType.BungeeJumping);
        arrayList.add(SportType.Squat);
        arrayList.add(SportType.Skate);
        arrayList.add(SportType.TaijiBoxing);
        arrayList.add(SportType.WaterPolo);
        arrayList.add(SportType.BeachVolleyball);
        arrayList.add(SportType.Snorkeling);
        arrayList.add(SportType.InclineDumbbellPress);
        arrayList.add(SportType.StandingOutsideStretch);
        arrayList.add(SportType.MilitaryPress);
        arrayList.add(SportType.ArnoldRecommended);
        arrayList.add(SportType.ShoulderWrap);
        arrayList.add(SportType.AlternatingFrontFlatLift);
        arrayList.add(SportType.UpwardInclinedDumbbellCurl);
        if (a.isOversea()) {
            arrayList.add(SportType.TreadmillRunning);
        }
        return arrayList;
    }

    public String toString() {
        return "SportTypeStateful2{sportType=" + this.f35434a + ", isSelect=" + this.f35435b + '}';
    }

    public m(Context context, SportType sportType, boolean z10) {
        this.f35434a = sportType;
        this.f35435b = z10;
        this.f35436c = context.getResources().getString(com.mobvoi.health.companion.sport.view.a.d().e(sportType).f18994c);
    }
}
