package com.example.furuma_manager.controller;

import com.example.furuma_manager.dto.IContractDto;
import com.example.furuma_manager.model.*;
import com.example.furuma_manager.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller
@RequestMapping("contract")
public class ContractController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private IContractDetailService contractDetailService;
    @Autowired
    private IAttachFacilityService attachFacilityService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IFacilityService facilityService;
private List<ContractDetail> list=new ArrayList<>();

    @GetMapping("")
    public String showAll(Model model, @PageableDefault(size = 6, page = 0) Pageable pageable) {
        Page<IContractDto> contractDtoPage = contractService.getAllContract(pageable);
        List<AttachFacility> attachFacilities = attachFacilityService.findAll();
        List<Customer> customerList = customerService.findAllList();
        List<Facility> facilities = facilityService.findAllList();
        Contract contract = new Contract();
        ContractDetail contractDetail = new ContractDetail();

        model.addAttribute("contractDetail", contractDetail);
        model.addAttribute("list", list);
        model.addAttribute("contract", contract);
        model.addAttribute("customerList", customerList);
        model.addAttribute("facilities", facilities);
        model.addAttribute("listAttach", attachFacilities);
        model.addAttribute("contractDtoPage", contractDtoPage);
        return "contract/list";
    }

    @PostMapping("create")
    public String save(ContractDetail contractDetail, RedirectAttributes redirectAttributes) {
        boolean check = contractDetailService.save(contractDetail);
        String mess = "success";
        if (!check) {
            mess = "fail";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/contract";
    }

    @GetMapping("/show")
    public String showFacility(@RequestParam int id, @RequestParam int page, RedirectAttributes redirectAttributes, Model model) {
        List<ContractDetail> contractDetail = contractDetailService.findById(id);
        if (contractDetail != null) {
            redirectAttributes.addFlashAttribute("pass", "true");
            redirectAttributes.addFlashAttribute("contractDetailShow", contractDetail);

            return "redirect:/contract?page=" + page;
        }
        return "redirect:/contract";
    }

    @PostMapping("/createContract")
    public String saveContract(Contract contract, @RequestParam String arrayAttachFacility, RedirectAttributes redirectAttributes) {
//        boolean check = contractService.save(contract);
//        contractDetail.setContract(contract);
//        boolean flag = contractDetailService.save(contractDetail);

            System.out.println(arrayAttachFacility);

        String mess = "success";
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/contract";
    }

}
