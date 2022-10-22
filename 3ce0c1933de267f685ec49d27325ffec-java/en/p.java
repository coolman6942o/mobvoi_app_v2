package en;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import gn.q;
import gn.u;
/* loaded from: classes2.dex */
public class p extends SQLiteOpenHelper {

    /* renamed from: b  reason: collision with root package name */
    private static p f26199b;

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f26200a;

    public p(Context context) {
        this(context, "pedometer.db", null, 17);
        SharedPreferences sharedPreferences = context.getSharedPreferences(q.f27582a, 0);
        this.f26200a = sharedPreferences;
        sharedPreferences.edit();
    }

    public p(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i10) {
        super(context, str, cursorFactory, i10);
    }

    public static p c(Context context) {
        if (f26199b == null) {
            f26199b = new p(context);
        }
        return f26199b;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists step_total_table(id integer primary key,date TEXT,step integer,distance integer,sport_time integer,calories integer,hour_details_array TEXT,run_steps integer,run_calories integer,run_distance integer,run_duration integer,run_hour_details_array TEXT,walk_steps integer,walk_calories integer,walk_distance integer,walk_duration integer,walk_hour_details_array TEXT )");
        sQLiteDatabase.execSQL("create table if not exists sleep_total_table(id integer primary key,date TEXT,time integer,sleep_time_status_array TEXT )");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS filedownlog (id integer primary key autoincrement, downpath varchar(100), threadid INTEGER, downlength INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists clock_period(id integer primary key,whitch TEXT,sun integer,mon integer,tue integer,wed integer,thu integer,fri integer,sat integer )");
        sQLiteDatabase.execSQL("create table if not exists rate_all_data_table(id integer primary key,calendar TEXT,time integer,rate integer )");
        sQLiteDatabase.execSQL("create table if not exists dynamic_rate_table1(id integer primary key,date TEXT ,dynamic_current_time TEXT ,current_rate integer ,test_time integer ,average_rate integer ,max_rate integer ,min_rate integer )");
        sQLiteDatabase.execSQL("create table if not exists rate_24_hour_table_name(id integer primary key,calendar TEXT,time integer,rate integer )");
        sQLiteDatabase.execSQL("create table if not exists blood_pressure_all_data_table(id integer primary key,calendar TEXT,time integer,blood_pressure_value_high integer ,blood_pressure_value_low integer )");
        sQLiteDatabase.execSQL("create table if not exists swim_table_name(id integer primary key,calendar TEXT,start_time integer,end_time integer,use_time integer,count integer,calories integer )");
        sQLiteDatabase.execSQL("create table if not exists skip_table_name(id integer primary key,calendar TEXT,start_time integer,end_time integer,use_time integer,count integer,calories integer )");
        sQLiteDatabase.execSQL("create table if not exists air_pressure_temperature_table_name(id integer primary key,calendar TEXT,time integer,air_pressure integer,temperature integer )");
        sQLiteDatabase.execSQL("create table if not exists ride_table_name(id integer primary key,calendar TEXT,start_time integer,end_time integer,use_time integer,ver_speed integer,calories integer,distance integer )");
        sQLiteDatabase.execSQL("create table if not exists ball_sports_table_name(id integer primary key,calendar TEXT,start_time integer,end_time integer,use_time integer,calories integer,sports_type integer )");
        sQLiteDatabase.execSQL("create table if not exists sports_modes_table(id integer primary key,current_sports_modes integer,sports_modes_rate_count integer,calendar TEXT,start_date_time TEXT,end_date_time TEXT,duration integer,ble_step_count integer,ble_sports_count integer,ble_sports_calories integer,ble_sports_distance REAL,ble_average_rate integer,ble_max_rate integer,ble_min_rate integer,ble_average_pace integer,ble_time_interval integer,ble_all_rate TEXT )");
        sQLiteDatabase.execSQL("create table if not exists custom_dial_table(id integer primary key,custom_dial_id TEXT,custom_dial_type TEXT,custom_dial_dpi TEXT,custom_dial_file TEXT,custom_dial_note TEXT,custom_dial_createtime TEXT,custom_dial_folderdial TEXT,custom_dial_pathstatus integer )");
        sQLiteDatabase.execSQL("create table if not exists temperature_table(id integer primary key,type integer,calendar TEXT,StartDate TEXT,time integer,body_surface_temperature Float,body_temperature Float,ambient_temperature Float )");
        sQLiteDatabase.execSQL("create table if not exists oxygen_table(id integer primary key,calendar TEXT,StartDate TEXT,time integer,oxygen_value integer )");
        sQLiteDatabase.execSQL("create table if not exists breathe_table(id integer primary key,calendar TEXT,StartDate TEXT,time integer,breathe_value integer )");
        sQLiteDatabase.execSQL("create table if not exists body_fat_table(id integer primary key,calendar TEXT,time TEXT,month TEXT,start_time integer,body_fat REAL,body_water REAL,body_protein REAL,body_bmr REAL,body_bone_salt REAL,body_muscle REAL,body_gender integer,body_age integer,body_height integer,body_weight REAL )");
        sQLiteDatabase.execSQL("create table if not exists ecg_table(id integer primary key,calendar TEXT,time TEXT,month TEXT,start_time integer,average_rate integer,ecg_HRV integer,ecg_strength integer,ecg_risk_level integer,ecg_fatigue_index integer,ecg_sampling_data TEXT,ecg_total_count integer,ecg_duration integer,ecg_person integer,ecg_label TEXT,ecg_real_value_array TEXT )");
        sQLiteDatabase.execSQL("create table if not exists standing_time_table(id integer primary key,calendar TEXT,standing_time_start_date TEXT,standing_time_end_date TEXT,standing_time_duration integer )");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS yc_ble_devices");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS filedownlog (id integer primary key autoincrement, downpath varchar(100), threadid INTEGER, downlength INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists rate_all_data_table(id integer primary key,calendar TEXT,time integer,rate integer )");
        sQLiteDatabase.execSQL("create table if not exists dynamic_rate_table1(id integer primary key,date TEXT ,dynamic_current_time TEXT ,current_rate integer ,test_time integer ,average_rate integer ,max_rate integer ,min_rate integer )");
        u.a("getSleepInfo", "onUpgrade oldVersion =" + i10 + ",newVersion =" + i11);
        sQLiteDatabase.execSQL("create table if not exists sleep_total_table(id integer primary key,date TEXT,time integer,sleep_time_status_array TEXT )");
        if (i10 < 2) {
            u.a("getSleepInfo", "SLEEP_TOTAL_TABLE 增加列 SLEEP_TIME_STATUS_ARRAY oldVersion= " + i10 + ",newVersion =" + i11);
            sQLiteDatabase.execSQL("alter table sleep_total_table add sleep_time_status_array TEXT");
        }
        if (i10 < 16) {
            sQLiteDatabase.execSQL("alter table sports_modes_table add duration integer");
        }
        sQLiteDatabase.execSQL("create table if not exists clock_period(id integer primary key,whitch TEXT,sun integer,mon integer,tue integer,wed integer,thu integer,fri integer,sat integer )");
        sQLiteDatabase.execSQL("create table if not exists swim_table_name(id integer primary key,calendar TEXT,start_time integer,end_time integer,use_time integer,count integer,calories integer )");
        sQLiteDatabase.execSQL("create table if not exists skip_table_name(id integer primary key,calendar TEXT,start_time integer,end_time integer,use_time integer,count integer,calories integer )");
        sQLiteDatabase.execSQL("create table if not exists air_pressure_temperature_table_name(id integer primary key,calendar TEXT,time integer,air_pressure integer,temperature integer )");
        sQLiteDatabase.execSQL("create table if not exists ride_table_name(id integer primary key,calendar TEXT,start_time integer,end_time integer,use_time integer,ver_speed integer,calories integer,distance integer )");
        sQLiteDatabase.execSQL("create table if not exists ball_sports_table_name(id integer primary key,calendar TEXT,start_time integer,end_time integer,use_time integer,calories integer,sports_type integer )");
        sQLiteDatabase.execSQL("create table if not exists step_total_table(id integer primary key,date TEXT,step integer,distance integer,sport_time integer,calories integer,hour_details_array TEXT,run_steps integer,run_calories integer,run_distance integer,run_duration integer,run_hour_details_array TEXT,walk_steps integer,walk_calories integer,walk_distance integer,walk_duration integer,walk_hour_details_array TEXT )");
        if (i10 < 3) {
            sQLiteDatabase.execSQL("alter table step_total_table add hour_details_array TEXT");
            sQLiteDatabase.execSQL("alter table step_total_table add run_steps integer");
            sQLiteDatabase.execSQL("alter table step_total_table add run_calories integer");
            sQLiteDatabase.execSQL("alter table step_total_table add run_distance integer");
            sQLiteDatabase.execSQL("alter table step_total_table add run_duration integer");
            sQLiteDatabase.execSQL("alter table step_total_table add run_hour_details_array TEXT");
            sQLiteDatabase.execSQL("alter table step_total_table add walk_steps integer");
            sQLiteDatabase.execSQL("alter table step_total_table add walk_calories integer");
            sQLiteDatabase.execSQL("alter table step_total_table add walk_distance integer");
            sQLiteDatabase.execSQL("alter table step_total_table add walk_duration integer");
            sQLiteDatabase.execSQL("alter table step_total_table add walk_hour_details_array TEXT");
        }
        sQLiteDatabase.execSQL("create table if not exists rate_24_hour_table_name(id integer primary key,calendar TEXT,time integer,rate integer )");
        sQLiteDatabase.execSQL("create table if not exists blood_pressure_all_data_table(id integer primary key,calendar TEXT,time integer,blood_pressure_value_high integer ,blood_pressure_value_low integer )");
        sQLiteDatabase.execSQL("create table if not exists sports_modes_table(id integer primary key,current_sports_modes integer,sports_modes_rate_count integer,calendar TEXT,start_date_time TEXT,end_date_time TEXT,duration integer,ble_step_count integer,ble_sports_count integer,ble_sports_calories integer,ble_sports_distance REAL,ble_average_rate integer,ble_max_rate integer,ble_min_rate integer,ble_average_pace integer,ble_time_interval integer,ble_all_rate TEXT )");
        sQLiteDatabase.execSQL("create table if not exists custom_dial_table(id integer primary key,custom_dial_id TEXT,custom_dial_type TEXT,custom_dial_dpi TEXT,custom_dial_file TEXT,custom_dial_note TEXT,custom_dial_createtime TEXT,custom_dial_folderdial TEXT,custom_dial_pathstatus integer )");
        sQLiteDatabase.execSQL("create table if not exists temperature_table(id integer primary key,type integer,calendar TEXT,StartDate TEXT,time integer,body_surface_temperature Float,body_temperature Float,ambient_temperature Float )");
        sQLiteDatabase.execSQL("create table if not exists oxygen_table(id integer primary key,calendar TEXT,StartDate TEXT,time integer,oxygen_value integer )");
        sQLiteDatabase.execSQL("create table if not exists breathe_table(id integer primary key,calendar TEXT,StartDate TEXT,time integer,breathe_value integer )");
        sQLiteDatabase.execSQL("create table if not exists body_fat_table(id integer primary key,calendar TEXT,time TEXT,month TEXT,start_time integer,body_fat REAL,body_water REAL,body_protein REAL,body_bmr REAL,body_bone_salt REAL,body_muscle REAL,body_gender integer,body_age integer,body_height integer,body_weight REAL )");
        sQLiteDatabase.execSQL("create table if not exists ecg_table(id integer primary key,calendar TEXT,time TEXT,month TEXT,start_time integer,average_rate integer,ecg_HRV integer,ecg_strength integer,ecg_risk_level integer,ecg_fatigue_index integer,ecg_sampling_data TEXT,ecg_total_count integer,ecg_duration integer,ecg_person integer,ecg_label TEXT,ecg_real_value_array TEXT )");
        sQLiteDatabase.execSQL("create table if not exists standing_time_table(id integer primary key,calendar TEXT,standing_time_start_date TEXT,standing_time_end_date TEXT,standing_time_duration integer )");
    }
}
