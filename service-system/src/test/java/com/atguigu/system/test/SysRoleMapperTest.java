package com.atguigu.system.test;
//如果是导入org.junit.Test，要配合@RunWith注解才能正常运行;
import com.atguigu.system.mapper.SysRoleMapper;
import com.atguigu.model.system.SysRole;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class SysRoleMapperTest {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Test
    public void findAll(){
        List<SysRole> list = sysRoleMapper.selectList(null);
        for (SysRole sysRole:list) {
            System.out.println(sysRole);

        }
    }

    @Test
    public void add(){
        SysRole sysRole=new SysRole();
        sysRole.setRoleName("测试角色");
        sysRole.setRoleCode("testManager");
        sysRole.setDescription("测试角色");
        int rows = sysRoleMapper.insert(sysRole);
        System.out.println(rows);
    }

    @Test
    public void update(){
        SysRole sysRole = sysRoleMapper.selectById(3);
        sysRole.setRoleName("pancras");
        sysRole.setDescription("wpz");
        sysRole.setRoleCode("SUPER");
        Date date=new Date();
        System.out.println(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.format(date);
        sysRole.setUpdateTime(date);
        sysRoleMapper.updateById(sysRole);
    }

    @Test
    public void delete(){
        sysRoleMapper.deleteById(4);
        sysRoleMapper.deleteBatchIds(Arrays.asList(1,2));
    }

    @Test
    public void testWrapperSelect(){
        QueryWrapper<SysRole> queryWrapper=new QueryWrapper<>();
        queryWrapper.likeLeft("role_name","角色");
        List<SysRole> sysRoles = sysRoleMapper.selectList(queryWrapper);
        for (SysRole sysRole:sysRoles) {
            System.out.println(sysRole);
        }
    }

    @Test
    public void testWrapperDelete(){
        QueryWrapper<SysRole> queryWrapper=new QueryWrapper<>();
        queryWrapper.likeLeft("role_name","角色");
        sysRoleMapper.delete(queryWrapper);

    }


}
