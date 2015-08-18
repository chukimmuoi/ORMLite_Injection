package chukimmuoi.dhxd.utils;

import java.sql.SQLException;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import chukimmuoi.dhxd.model.SanPham;
import com.google.inject.Inject;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper{
	private final static String DATABASE_NAME = "test.db";
	private final static int DATABASE_VERSION = 1;
	
	@Inject
	public DatabaseHelper(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase sd, ConnectionSource cs) {
		try {
			TableUtils.createTableIfNotExists(cs, SanPham.class);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase sd, ConnectionSource cs, int oldVersion,
			int newVersion) {
		try {
			TableUtils.dropTable(cs, SanPham.class, true);
			onCreate(sd, cs);
		} catch (SQLException e){
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void close() {
		super.close();
	}
}
