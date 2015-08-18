package chukimmuoi.dhxd.ormlite_injection;

import chukimmuoi.dhxd.utils.DatabaseHelper;
import android.app.Application;

public class InitApp extends Application{

	@Override
	public void onCreate() {
		super.onCreate();
		//Tạo cơ sở dữ liệu
		new DatabaseHelper(getApplicationContext()).getWritableDatabase();
	}
	
}
