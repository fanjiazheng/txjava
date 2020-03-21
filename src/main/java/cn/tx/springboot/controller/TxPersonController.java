package cn.tx.springboot.controller;

import cn.tx.springboot.model.TxPerson;
import cn.tx.springboot.service.TxPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TxPersonController {

    @Autowired
    TxPersonService personService;

    @GetMapping("/main")
    public String findAll(Model model){
        List<TxPerson> personList = personService.selectPersons();
        model.addAttribute("pList",personList);
        return "main";
    }

    @GetMapping("/getPerson")
    public String getPerson(int pid,Model model){
        TxPerson p = personService.getPeronById(pid);
        model.addAttribute("p",p);
        return "update";
    }

    @PostMapping("/update")
    public String update(TxPerson txPerson){
        personService.updatePerson(txPerson);
        //这里的重定向刷新界面
        return "redirect:main";
    }

    @PostMapping("/save")
    public String save(TxPerson txPerson){
        personService.insert(txPerson);
        return "redirect:main";
    }

    @GetMapping("/delete")
    public String delete(int pid){
        personService.delete(pid);
        return "redirect:main";
    }

    @PostMapping("/login")
    public String loging(TxPerson txPerson, Model model, HttpSession session){
        TxPerson person = personService.getPeronByUsername(txPerson.getUsername());
        String password = person.getPassword();

        if (password.equals(txPerson.getPassword())){
            session.setAttribute("user",txPerson);
            return "redirect:index";
        }
        model.addAttribute("tip","用户名或者密码错误！");
        return "login";
    }

}
