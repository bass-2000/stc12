package ru.innopolis.stc12.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.innopolis.stc12.hibernate.service.MobileService;

@Controller
public class MobileController {
    MobileService mobileService;

    @Autowired
    public void setMobileService(MobileService mobileService) {
        this.mobileService = mobileService;
    }

    @RequestMapping(value = "/phoneList", method = RequestMethod.GET)
    public String showPhoneList(Model model) {
        model.addAttribute("phones", mobileService.getMobileList());
        return "phoneList";
    }

    @RequestMapping(value = "/addPhone", method = RequestMethod.GET)
    public String addPhone(Model model) {
        mobileService.addPhone(1L, "Some phone3", 114000);
        return showPhoneList(model);
    }
}
