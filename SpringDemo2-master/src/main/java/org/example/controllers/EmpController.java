package org.example.controllers;

import org.example.models.dao.Empdao;
import org.example.models.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class EmpController {
    @Autowired
    Empdao empdao;
    /*@RequestMapping("getall")
    public String Extract(Model M) {
        List<Emp> list = empdao.Extract();
        M.addAttribute("Elist", list);
        return "Displayemp";
    }*/
    @RequestMapping("fetch")
    public String ExtractListbyDeptNo(@RequestParam("deptno") int deptno, Model M) {
        List<Emp> list = empdao.Extract();
        M.addAttribute("Elist", list.stream().filter(T -> T.getDeptno() == deptno));
        return "FetchDataByDeptNo";
    }
}
