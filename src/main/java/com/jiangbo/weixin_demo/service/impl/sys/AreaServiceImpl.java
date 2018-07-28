package com.jiangbo.weixin_demo.service.impl.sys;

import com.jiangbo.weixin_demo.entity.TbArea;
import com.jiangbo.weixin_demo.dao.TbAreaMapper;
import com.jiangbo.weixin_demo.service.sys.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private TbAreaMapper tbAreaMapper;


	@Override
	public List<TbArea> areasList() {

		List<TbArea> tbAreaList = tbAreaMapper.selectAll();

		return tbAreaList;
	}

	@Override
	public TbArea getAreaById(Integer id){
		return tbAreaMapper.selectByPrimaryKey(id);
	}

	@Transactional
	@Override
	public boolean insertArea(TbArea tbArea) {
		if (tbArea.getAreaName() != null && !"".equals(tbArea.getAreaName())){
			tbArea.setCreateTime(new Date());
			tbArea.setLastEditTime(new Date());

			try {
				int effectedNum = tbAreaMapper.insertSelective(tbArea);
				if (effectedNum > 0){
					return true;
				} else {
					throw new RuntimeException("插入区域信息失败！");
				}
			} catch (Exception e){
				throw new RuntimeException("插入区域信息失败: " + e.getMessage());
			}
		} else {
			throw new RuntimeException("区域信息不能为空！");
		}
	}
//
	@Override
	public boolean updateArea(TbArea tbArea) {
		if (tbArea.getAreaId() != null && tbArea.getAreaId() > 0){
			tbArea.setLastEditTime(new Date());

			try {
				int effectedNum = tbAreaMapper.updateByPrimaryKeySelective(tbArea);
				if (effectedNum > 0){
					return true;
				} else {
					throw new RuntimeException("更新区域信息失败！");
				}
			} catch (Exception e){
				throw new RuntimeException("更新区域信息失败: " + e.getMessage());
			}
		} else {
			throw new RuntimeException("区域信息不能为空！");
		}

//		return tbAreaMapper.updateByPrimaryKeySelective(tbArea);
	}

	@Override
	public boolean deleteArea(Integer id) {
//		return tbAreaMapper.deleteByPrimaryKey(id);
		if (id > 0){
			try {
				int effectedNum = tbAreaMapper.deleteByPrimaryKey(id);
				if (effectedNum > 0){
					return true;
				} else {
					throw new RuntimeException("删除区域信息失败！");
				}
			} catch (Exception e){
				throw new RuntimeException("删除区域信息失败: " + e.getMessage());
			}
		} else {
			throw new RuntimeException("区域id信息不能为空！");
		}
	}
}
