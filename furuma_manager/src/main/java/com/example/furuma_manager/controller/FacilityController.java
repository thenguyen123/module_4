package com.example.furuma_manager.controller;

import com.example.furuma_manager.dto.FacilityDto;
import com.example.furuma_manager.model.Facility;
import com.example.furuma_manager.model.FacilityType;
import com.example.furuma_manager.model.RentType;
import com.example.furuma_manager.service.IFacilityService;
import com.example.furuma_manager.service.IFacilityTypeService;
import com.example.furuma_manager.service.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IFacilityTypeService iFacilityTypeService;
    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("")
    public String showAll(@RequestParam(defaultValue = "", required = false) String nameSearch,
                          @RequestParam(defaultValue = "", required = false) String typeSearch, Model model, @PageableDefault(size = 3, page = 0) Pageable pageable) {
        Page<Facility> facilityPage = iFacilityService.findAll(nameSearch, typeSearch, pageable);
        List<FacilityType> facilityTypeList = iFacilityTypeService.findAll();
        List<RentType> rentTypes = rentTypeService.findAll();
        model.addAttribute("pageFacility", facilityPage);
        model.addAttribute("facilityTypes", facilityTypeList);
        model.addAttribute("rentTypes", rentTypes);
        model.addAttribute("facilityDto", new FacilityDto());
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("type", typeSearch);



        return "facility/list";
    }

    @PostMapping("create")
    public String save(@Validated @ModelAttribute FacilityDto facilityDto, BindingResult bindingResult, Model model,
                       @PageableDefault(size = 3, page = 0) Pageable pageable, RedirectAttributes redirectAttributes, @RequestParam(defaultValue = "", required = false) String nameSearch,
                       @RequestParam(defaultValue = "", required = false) String typeSearch) {
        new FacilityDto().validate(facilityDto,bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("haserr", "true");
            Page<Facility> facilityPage = iFacilityService.findAll(" ", " ", pageable);
            List<FacilityType> facilityTypeList = iFacilityTypeService.findAll();
            List<RentType> rentTypes = rentTypeService.findAll();
            model.addAttribute("pageFacility", facilityPage);
            model.addAttribute("facilityTypes", facilityTypeList);
            model.addAttribute("rentTypes", rentTypes);
            model.addAttribute("facilityDto", facilityDto);
            model.addAttribute("nameSearch", nameSearch);
            model.addAttribute("type", typeSearch);
            return "facility/list";

        }
        Facility facility1 = new Facility();
        BeanUtils.copyProperties(facilityDto, facility1);
        boolean check = iFacilityService.save(facility1);
        String mess = "success";
        if (!check) {
            mess = "fail";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/facility";
    }

    @PostMapping("edit")
    public String edit(Facility facility, RedirectAttributes redirectAttributes) {
        boolean check = iFacilityService.save(facility);
        String mess = "success";
        if (!check) {
            mess = "fail";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/facility";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int idDelete, RedirectAttributes redirectAttributes) {
        boolean check = iFacilityService.delete(idDelete);
        String mess = "Success";
        if (!check) {
            mess = "fail";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/facility";
    }

}
