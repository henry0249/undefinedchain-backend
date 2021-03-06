package com.undefinedchain.project.controller;
import com.undefinedchain.project.core.Result;
import com.undefinedchain.project.core.ResultGenerator;
import com.undefinedchain.project.model.FinancebillStateDim;
import com.undefinedchain.project.service.FinancebillStateDimService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2020/03/12.
*/
@RestController
@RequestMapping("/financebill/state/dim")
public class FinancebillStateDimController {
    @Resource
    private FinancebillStateDimService financebillStateDimService;

    @PostMapping("/add")
    public Result add(FinancebillStateDim financebillStateDim) {
        financebillStateDimService.save(financebillStateDim);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        financebillStateDimService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(FinancebillStateDim financebillStateDim) {
        financebillStateDimService.update(financebillStateDim);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        FinancebillStateDim financebillStateDim = financebillStateDimService.findById(id);
        return ResultGenerator.genSuccessResult(financebillStateDim);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<FinancebillStateDim> list = financebillStateDimService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
