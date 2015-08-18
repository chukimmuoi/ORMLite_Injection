package chukimmuoi.dhxd.model;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "SanPham")
public class SanPham implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@DatabaseField(columnName = "Id", id = true, generatedId = false)
	private String Id;
	
	@DatabaseField(columnName = "MoTa", canBeNull = false)
	private String MoTa;
	
	@DatabaseField(columnName = "Gia", canBeNull = false, defaultValue = "0.0")
	private double Gia;
	
	@DatabaseField(columnName = "SoLuong", defaultValue = "0")
	private int SoLuong;
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getMoTa() {
		return MoTa;
	}
	public void setMoTa(String moTa) {
		MoTa = moTa;
	}
	public double getGia() {
		return Gia;
	}
	public void setGia(double gia) {
		Gia = gia;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
}
