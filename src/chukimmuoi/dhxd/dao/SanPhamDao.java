package chukimmuoi.dhxd.dao;

import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Provider;

import chukimmuoi.dhxd.model.SanPham;
import chukimmuoi.dhxd.utils.DatabaseHelper;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

public class SanPhamDao implements Provider<Dao<SanPham, String>>{
	private ConnectionSource cs;
	
	@Inject
	public SanPhamDao(DatabaseHelper databaseHelper){
		cs = databaseHelper.getConnectionSource();
	}
	
	@Override
	public Dao<SanPham, String> get() {
		try {
			return DaoManager.createDao(cs, SanPham.class);
		} catch(SQLException e){
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
