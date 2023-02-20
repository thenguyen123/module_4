package com.example.furuma_manager.controller;

import com.example.furuma_manager.model.Facility;
import com.example.furuma_manager.model.FacilityType;
import com.example.furuma_manager.service.IFacilityService;
import com.example.furuma_manager.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IFacilityTypeService iFacilityTypeService;

    @GetMapping("")
    public  String showAll(@RequestParam(defaultValue = "",required = false) String name,
                           @RequestParam(defaultValue = "",required = false) String type, Model model,@PageableDefault(size = 3,page = 0) Pageable pageable){
        Page<Facility> facilityPage=iFacilityService.findAll(name,type,pageable);
        List<FacilityType> facilityTypeList=iFacilityTypeService.findAll();
        model.addAttribute("pageFacility",facilityPage);
        model.addAttribute("facilityTypes",facilityTypeList);
        model.addAttribute("name",name);
        model.addAttribute("type",type);
       return "facility/list";
    }
}
