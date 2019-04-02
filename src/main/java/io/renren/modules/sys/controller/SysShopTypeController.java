package io.renren.modules.sys.controller;

import io.renren.common.utils.R;
import io.renren.modules.sys.entity.SysShopTypeEntity;
import io.renren.modules.sys.service.impl.SysShopTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sys/tree")
public class SysShopTypeController extends AbstractController {


    @Autowired
    private SysShopTypeServiceImpl sysShopTypeServiceImpl;
    @RequestMapping("/firstTree")
    public R firstTree(){
        List<SysShopTypeEntity> list = sysShopTypeServiceImpl.queryByPid();
        list.stream().forEach(s->{
            List<SysShopTypeEntity> entityList = sysShopTypeServiceImpl.getByPid(s.getId());
            if (entityList.size() > 0 && entityList != null){
                //有字节点
                s.setIsIndex(1L);
            }else {
                // 没有子节点
                s.setIsIndex(0L);
            }
        });
        return R.ok().put("data",list);
    }


    @RequestMapping("/getByPid/{pid}")
    public R getByPid(@PathVariable("pid")Long pid){
       return R.ok().put("data",sysShopTypeServiceImpl.getByPid(pid));
    }
}
