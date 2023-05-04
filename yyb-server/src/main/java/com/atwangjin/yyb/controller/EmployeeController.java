package com.atwangjin.yyb.controller;

import com.atwangjin.yyb.pojo.*;
import com.atwangjin.yyb.result.R;
import com.atwangjin.yyb.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * @author WangJin
 * @create 2023-03-08 14:44
 */
@RestController
@RequestMapping("system/employee")
public class EmployeeController {




    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private JoblevelService joblevelService;


    @Autowired
    private PoliticsStatusService politicsStatusService;

    @Autowired
    private NationService nationService;


    @GetMapping
    @ApiOperation("分页查询所有员工")
    public PageResult getAllEmp(@RequestParam(defaultValue = "1") Integer pageNum,
                                @RequestParam(defaultValue = "10") Integer pageSize,
                                Employee employee,
                                LocalDate[] localDates) {
         return     employeeService.getAllEmp(employee,localDates,pageNum,pageSize);
    }


    @ApiOperation("获取所有职称")
    @GetMapping("joblevels")
    public List<Joblevel> getJoblevels(){
        List<Joblevel> joblevels = joblevelService.getJob();

        return joblevels;
    }



    @ApiOperation("获取所有职位")
    @GetMapping("positions")
    public List<Position> getPositions(){
        List<Position> positions = positionService.getPos();

        return positions;
    }

    @ApiOperation("获取所有政治面貌")
    @GetMapping("politicsStatus")
    public List<PoliticsStatus> getPoliticsStatus(){
        List<PoliticsStatus> positionList = politicsStatusService.getPoliticsStatus();

        return positionList;
    }

    @ApiOperation("获取所有民族")
    @GetMapping("nation")
    public List<Nation> getNation(){
        List<Nation> nationList = nationService.getNation();

        return nationList;
    }


    @ApiOperation("获取最大工号")
    @GetMapping("maxWorkId")
    public R maxWorkId(){
       String workId =  employeeService.getMaxWorkId();

       if (!StringUtils.isEmpty(workId)) {
           return R.success("", workId);
       } else {
           return R.error("获取失败");
       }
    }

}
