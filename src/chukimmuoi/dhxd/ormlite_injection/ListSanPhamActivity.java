package chukimmuoi.dhxd.ormlite_injection;

import java.sql.SQLException;
import java.util.List;

import com.google.inject.Inject;
import chukimmuoi.dhxd.module.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import chukimmuoi.dhxd.adapter.SanPhamAdapter;
import chukimmuoi.dhxd.model.SanPham;
import chukimmuoi.dhxd.myinterface.ISanPham;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.list_sanpham)
public class ListSanPhamActivity extends RoboActivity {
	@Inject
	private ISanPham iSanPham;

	@InjectView(R.id.list_sanpham_lv)
	private ListView listview;

	@InjectView(R.id.list_sanpham_btn_new)
	private Button btnNew;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		try {
			List<SanPham> listSanPham = iSanPham.selectSanPham();
			SanPhamAdapter adapter = new SanPhamAdapter(
					getApplicationContext(), listSanPham);
			listview.setAdapter(adapter);

			btnNew.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(ListSanPhamActivity.this,
							EditSanPhamActicity.class);
					intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					startActivityForResult(intent, 0);
					finish();
				}
			});
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
