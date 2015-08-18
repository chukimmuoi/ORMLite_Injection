package chukimmuoi.dhxd.myinterface;

import java.sql.SQLException;
import java.util.List;

import chukimmuoi.dhxd.model.SanPham;

public interface ISanPham {
	public List<SanPham> selectSanPham() throws SQLException;
	public SanPham selectSanPham(String Id) throws SQLException;
	public void deleteSanPham(SanPham delete) throws SQLException;
	public void insertSanPham(SanPham insert) throws SQLException;
	public void updateSanPham(SanPham update) throws SQLException;
}
