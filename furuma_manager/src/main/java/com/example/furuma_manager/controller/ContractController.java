package com.example.furuma_manager.controller;

import com.example.furuma_manager.dto.IContractDto;
import com.example.furuma_manager.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("contract")
public class ContractController {
@Autowired
    private IContractService contractService;
@GetMapping("")
    public String showAll(Model model,@PageableDefault(size = 4,page = 0) Pageable pageable){
    Page<IContractDto> contractDtoPage=contractService.getAllContract(pageable);
    model.addAttribute("contractDtoPage",contractDtoPage);
    return "contract/list";
}
}
