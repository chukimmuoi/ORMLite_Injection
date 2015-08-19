package chukimmuoi.dhxd.ormlite_injection;

import java.sql.SQLException;

import com.google.inject.Inject;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import chukimmuoi.dhxd.model.SanPham;
import chukimmuoi.dhxd.myinterface.ISanPham;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import chukimmuoi.dhxd.module.R;

@ContentView(R.layout.edit_sanpham)
public class EditSanPhamActicity extends RoboActivity{
	@Inject
	private ISanPham iSanPham;
	
	@InjectView(R.id.edit_sanpham_etId)
	private EditText etId;
	
	@InjectView(R.id.edit_sanpham_etMoTa)
	private EditText etMoTa;
	
	@InjectView(R.id.edit_sanpham_etGia)
	private EditText etGia;
	
	@InjectView(R.id.edit_sanpham_etSoLuong)
	private EditText etSoLuong;
	
	@InjectView(R.id.edit_sanpham_btnSave)
	private Button btnSave;
	
	@InjectView(R.id.edit_sanpham_btnDelete)
	private Button btnDelete;
	
	private SanPham sanpham;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sanpham = (SanPham) (getIntent().getSerializableExtra("SanPham"));
		loadSelectedProduct(sanpham);
		
		btnSave.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
                try {
                    if (sanpham == null) {
 
                        SanPham product = new SanPham();
 
                        product.setId(etId.getText()
                                .toString());
 
                        product.setMoTa(etMoTa
                                .getText().toString());
                        product.setGia(Double
                                .parseDouble(etGia.getText()
                                        .toString()));
                        product.setSoLuong(Integer.parseInt(etSoLuong
                                .getText().toString()));
 
                        iSanPham.insertSanPham(product);
 
                    } else {
 
                    	sanpham
                                .setMoTa(etMoTa
                                        .getText().toString());
                    	sanpham.setGia(Double
                                .parseDouble(etGia.getText()
                                        .toString()));
                    	sanpham.setSoLuong(Integer
                                .parseInt(etSoLuong.getText()
                                        .toString()));
 
                    	iSanPham.updateSanPham(sanpham);
 
                    }
 
                    Intent intent = new Intent(EditSanPhamActicity.this,
                            ListSanPhamActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivityForResult(intent, 0);
                    finish();
 
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
 
            
			}
		});
		
		btnDelete.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
                if (sanpham != null) {
 
                    try {
 
                        iSanPham.deleteSanPham(sanpham);
                        Intent intent = new Intent(EditSanPhamActicity.this,
                                ListSanPhamActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivityForResult(intent, 0);
                        finish();
 
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
 
            
			}
		});
	}
	
	private void loadSelectedProduct(SanPham selectedProduct) {
		 
        if (selectedProduct != null) {
            etId.setText(selectedProduct.getId());
            etId.setEnabled(false);
            etMoTa.setText(selectedProduct.getMoTa());
            etGia.setText(String.valueOf(selectedProduct.getGia()));
            etSoLuong.setText(String.valueOf(selectedProduct.getSoLuong()));
        }
 
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
	}
	
	
}
