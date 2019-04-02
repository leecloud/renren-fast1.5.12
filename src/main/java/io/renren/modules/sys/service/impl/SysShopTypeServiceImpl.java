package io.renren.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.Query;
import io.renren.modules.sys.dao.SysShopTypeDao;
import io.renren.modules.sys.entity.SysShopTypeEntity;
import io.renren.modules.sys.service.SysShopTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("shopTypeService")
public class SysShopTypeServiceImpl extends ServiceImpl<SysShopTypeDao, SysShopTypeEntity> implements SysShopTypeService {

    public List<SysShopTypeEntity> queryByPid(){
        EntityWrapper<SysShopTypeEntity> wrapper = new EntityWrapper<>(new SysShopTypeEntity());
        wrapper.eq("pid",0L);
        return baseMapper.selectList(wrapper);
    }


    public List<SysShopTypeEntity> getByPid(Long pid){
        EntityWrapper<SysShopTypeEntity> wrapper = new EntityWrapper<>(new SysShopTypeEntity());
        wrapper.eq("pid",pid);
        return this.selectList(wrapper);
    }
}
