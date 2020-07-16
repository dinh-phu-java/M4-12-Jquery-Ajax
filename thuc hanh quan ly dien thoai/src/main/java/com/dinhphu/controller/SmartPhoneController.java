package com.dinhphu.controller;

import com.dinhphu.model.SmartPhone;
import com.dinhphu.services.ISmartPhoneServices;
import com.dinhphu.services.SmartPhoneServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/smartphones")
public class SmartPhoneController {

    @Autowired
    private ISmartPhoneServices smartPhoneServices;

    @GetMapping("/create")
    public ModelAndView createSmartPhone(){
        ModelAndView modelAndView=new ModelAndView("phones/new-phone");
        modelAndView.addObject("smartPhone",new SmartPhone());
        return modelAndView;
    }

    @PostMapping("/createNewPhone")
    @ResponseBody
    public SmartPhone createSmartPhone(@RequestBody SmartPhone smartPhone){
        return smartPhoneServices.save(smartPhone);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<SmartPhone> allPhone(){
        return smartPhoneServices.findAll();
    }

    @GetMapping("")
    public ModelAndView allPhonesPage(){
        ModelAndView modelAndView=new ModelAndView("phones/all-phone");
        modelAndView.addObject("allphones",allPhone());
        return modelAndView;
    }


}
