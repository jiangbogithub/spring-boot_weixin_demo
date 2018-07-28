package com.jiangbo.weixin_demo.service.sys;

import com.jiangbo.weixin_demo.entity.TbArea;

import java.util.List;

public interface AreaService {

	List<TbArea> areasList();

//	List<TbArea> areasList(int pageSize, int start, String menuId);
//
//	Integer areasSize(int pageSize, int start, String menuId);
//
	TbArea getAreaById(Integer id);

	boolean insertArea(TbArea tbArea);

	boolean updateArea(TbArea tbArea);

	boolean deleteArea(Integer id);

}
