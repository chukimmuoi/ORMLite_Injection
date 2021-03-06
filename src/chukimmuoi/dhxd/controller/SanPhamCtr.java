package chukimmuoi.dhxd.controller;

import java.sql.SQLException;
import java.util.List;
import com.google.inject.Inject;
import android.content.Context;
import com.j256.ormlite.dao.Dao;
import chukimmuoi.dhxd.dao.SanPhamDao;
import chukimmuoi.dhxd.model.SanPham;
import chukimmuoi.dhxd.myinterface.ISanPham;

public class SanPhamCtr implements ISanPham{
	private Dao<SanPham, String> sanphamDao;
	
	@Inject
	public SanPhamCtr(Context context, SanPhamDao sanphamDao){
		this.sanphamDao = sanphamDao.get();
	}
	@Override
	public List<SanPham> selectSanPham() throws SQLException {
		return this.sanphamDao.queryForAll();
	}

	@Override
	public SanPham selectSanPham(String Id) throws SQLException {
		return this.sanphamDao.queryForId(Id);
	}

	@Override
	public void deleteSanPham(SanPham delete) throws SQLException {
		this.sanphamDao.delete(delete);
	}

	@Override
	public void insertSanPham(SanPham insert) throws SQLException {
		this.sanphamDao.create(insert);
		
//		TransactionManager.callInTransaction(sanphamDao.getConnectionSource(), new java.util.concurrent.Callable<SanPhamDao>() {
//			@Override
//			public SanPhamDao call() throws Exception {
//				SanPham obj = new SanPham();
//				obj.setGia(60000);
//				obj.setMoTa("Tiền");
//				obj.setSoLuong(1);
//				long start = System.currentTimeMillis();
//				for (int i = 0; i < 1000; i++) {
//					obj.setGia(i);
//					sanphamDao.create(obj);
//				}
//				long end = System.currentTimeMillis();
//				System.out.println("MMMMMMMMMMMMMMMMMMMM: " + (end - start));
//				return null;
//			}
//		});
//		this.sanphamDao.create(insert);
	}

	@Override
	public void updateSanPham(SanPham update) throws SQLException {
		this.sanphamDao.update(update);
	}

}
