package chukimmuoi.dhxd.module;


import chukimmuoi.dhxd.controller.SanPhamCtr;
import chukimmuoi.dhxd.myinterface.ISanPham;

import com.google.inject.AbstractModule;

public class BaseModule extends AbstractModule{
	@Override
	protected void configure() {
		//Ràng buộc
		bind(ISanPham.class).to(SanPhamCtr.class);
	}
}
