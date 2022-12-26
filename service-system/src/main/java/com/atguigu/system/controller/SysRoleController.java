package com.atguigu.system.controller;

import com.atguigu.common.result.Result;
import com.atguigu.system.exception.SelfDefineException;
import com.atguigu.system.service.SysRoleService;
import com.atguigu.model.system.SysRole;
import com.atguigu.model.vo.SysRoleQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags="角色管理接口")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    @ApiOperation("查询所有记录")
    @GetMapping("/findAll")
    public Result findAllRole(){
        List<SysRole> list = sysRoleService.list();
        Result<List<SysRole>> result = Result.ok(list);
        return result;
    }

    @ApiOperation("逻辑删除接口")
    @DeleteMapping("/remove/{id}")
    public Result removeRole(@PathVariable Long id){
        boolean isSuccess = sysRoleService.removeById(id);
        if (isSuccess){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }


    @ApiOperation("批量删除")
    @DeleteMapping("/batchRemove")
    public Result batchRemove(@RequestBody List<Long> ids){
        boolean isSuccess = sysRoleService.removeByIds(ids);
        if (isSuccess){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }

    @ApiOperation("添加角色")
    @PostMapping("/save")
    public Result saveRole(@RequestBody SysRole sysRole){
        boolean isSuccess = sysRoleService.save(sysRole);
        if (isSuccess){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }

    @ApiOperation("根据id查询")
    @PostMapping("/findRoleById/{id}")
    public Result findRoleById(@PathVariable Long id){
        SysRole sysRole = sysRoleService.getById(id);
        return Result.ok(sysRole);
    }

    @ApiOperation("修改角色")
    @PostMapping("/update")
    public Result updateRole(@RequestBody SysRole sysRole){
        boolean isSuccess = sysRoleService.updateById(sysRole);
        if (isSuccess){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }

    @ApiOperation("条件分页查询")
    @GetMapping("{page}/{limit}")
    public Result findByPage(@PathVariable Long page,
                             @PathVariable Long limit,
                             SysRoleQueryVo sysRoleQueryVo){
        Page<SysRole> pageParam=new Page<>(page,limit);
        IPage<SysRole> pageModel = sysRoleService.selectPage(pageParam,sysRoleQueryVo);
        return Result.ok(pageModel);
    }

    @ApiOperation("模拟异常处理")
    @GetMapping("/dealException")
    public Result dealException() {
        try {
            int i = 9 / 0;
        } catch (Exception e) {
            throw new SelfDefineException(2001, "执行了自定义异常处理");
        }
        return Result.fail();
    }
}
