package com.atwangjin.yyb.controller;

import com.atwangjin.yyb.pojo.Joblevel;
import com.atwangjin.yyb.result.R;
import com.atwangjin.yyb.service.JoblevelService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author WangJin
 * @create 2023-03-01 10:19
 */
@RestController
@RequestMapping("/system/basic")
public class JoblevelController {


    @Autowired
    private JoblevelService joblevelService;




    @ApiOperation("获取所有职称")
    @GetMapping("/joblevel")
    public List<Joblevel> getJob(){


        List<Joblevel> joblevels= joblevelService.getJob();

        return joblevels;
    }

    @ApiOperation("添加职称")
    @PostMapping("/joblevel")
    public R addJob(@RequestBody  Joblevel joblevel){


        Boolean result= joblevelService.addJob(joblevel);

        if (result==true){
            return R.success("添加成功");
        }

        return null;
    }

    @ApiOperation("删除职称")
    @DeleteMapping("/joblevel/{id}")
    public R deleteJob(@PathVariable Integer id){


        Boolean result= joblevelService.deleteJob(id);

        if (result==true){
            return R.success("删除成功");
        }

        return null;
    }

    @ApiOperation("修改职称")
    @PutMapping("/joblevel")
    public R updateJob(@RequestBody Joblevel joblevel){


        Boolean result= joblevelService.updateJob(joblevel);

        if (result==true){
            return R.success("修改成功");
        }

        return null;
    }


    @ApiOperation("批量删除职称信息")
    @DeleteMapping("/joblevel")
    public  R deleteManyJos(@RequestParam Integer[]  ids){


        boolean result= joblevelService.deleteManyJos(ids);


        if (result==true){
            return R.success("删除成功");

        }else {
            return R.error("删除失败");
        }

    }

}
