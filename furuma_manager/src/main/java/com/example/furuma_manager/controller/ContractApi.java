package com.example.furuma_manager.controller;

import com.example.furuma_manager.dto.ContractDto;
import com.example.furuma_manager.model.AttachFacility;
import com.example.furuma_manager.model.Contract;
import com.example.furuma_manager.model.ContractDetail;
import com.example.furuma_manager.service.IAttachFacilityService;
import com.example.furuma_manager.service.IContractDetailService;
import com.example.furuma_manager.service.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@CrossOrigin("*")
@RequestMapping("api/contract")
public class ContractApi {
    @Autowired
    private IContractService contractService;
    @Autowired
    private IAttachFacilityService attachFacilityService;
    @Autowired
    private IContractDetailService contractDetailService;

    @PostMapping("/create")
    public ResponseEntity save(@RequestBody List<ContractDto> contractDto) {

        if (contractDto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto.get(0).getContract(), contract);
        boolean check = contractService.checkDate(contract.getStartDate(), contract.getEndDate());
        if (!check) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }

        contractService.save(contract);

        for (ContractDto contractDetail :
                contractDto) {
            ContractDetail contractDetail1 = new ContractDetail();
            BeanUtils.copyProperties(contractDetail, contractDetail1);
            contractDetail1.setContract(contract);
            contractDetailService.save(contractDetail1);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity show() {
        List<AttachFacility> list = attachFacilityService.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
