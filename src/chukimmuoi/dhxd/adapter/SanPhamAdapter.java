package chukimmuoi.dhxd.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import chukimmuoi.dhxd.model.SanPham;
import chukimmuoi.dhxd.module.R;

public class SanPhamAdapter extends BaseAdapter{
	private List<SanPham> sanphamList;
    private Context context;
 
    public SanPhamAdapter(Context context, List<SanPham> sanphamList) {
        this.context = context;
        this.sanphamList = sanphamList;
    }
 
    static class ViewHolder {
        protected TextView tvId;
        protected TextView tvMoTa;
        protected TextView tvGia;
    }
 
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
 
        ViewHolder holder = null;
        LayoutInflater inflater = LayoutInflater.from(this.context);
 
        if (convertView == null) {
 
            convertView = inflater.inflate(R.layout.custom_row_sanpham, parent, false);
            holder = new ViewHolder();
 
            holder.tvId = (TextView) convertView
                    .findViewById(R.id.custom_row_sanpham_tvId);
            holder.tvMoTa = (TextView) convertView
                    .findViewById(R.id.custom_row_sanpham_tvMoTa);
            holder.tvGia = (TextView) convertView
                    .findViewById(R.id.custom_row_sanpham_tvGia);
 
            convertView.setTag(holder);
 
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
 
        SanPham sanpham = sanphamList.get(position);
 
        if (sanpham != null) {
            try {
 
                holder.tvId.setText(String.format(context
                        .getString(R.string.list_product_code_format,
                        		sanpham.getId())));
                holder.tvMoTa.setText(String
                        .format(context.getString(
                                R.string.list_product_description_format,
                                sanpham.getMoTa())));
                holder.tvGia.setText(String.format(context
                        .getString(R.string.list_product_price_format,
                                String.valueOf(sanpham.getGia()))));
 
            } catch (Exception e) {
                e.printStackTrace();
            }
 
        }
 
        return convertView;
    }
 
    @Override
    public int getCount() {
        return sanphamList.size();
    }
 
    @Override
    public Object getItem(int pos) {
        return sanphamList.get(pos);
    }
 
    @Override
    public long getItemId(int pos) {
        return pos;
    }
}
