package com.atguigu.system.test;

import com.atguigu.system.service.SysRoleService;
import com.atguigu.model.system.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class SysRoleServiceTest {
    @Autowired
    private SysRoleService sysRoleService;

    @Test
    public void findAll(){
        List<SysRole> list = sysRoleService.list();
        System.out.println(list);
    }

    @Test
    public void add(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("运营角色");
        sysRole.setRoleCode("runManager");
        sysRole.setDescription("运营角色");
        sysRoleService.save(sysRole);
    }

    @Test
    public void update(){
        SysRole sysRole = sysRoleService.getById(3);
        sysRole.setRoleName("财务管理员");
        sysRole.setDescription("财务管理员");
        sysRole.setRoleCode("MONEY");
        Date date=new Date();
        System.out.println(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.format(date);
        sysRole.setUpdateTime(date);
        sysRoleService.updateById(sysRole);
    }
    @Test
    public void delete(){
        sysRoleService.removeById(5);
//        sysRoleService.removeByIds(Arrays.asList(1,2));
    }
}
