package com.example.furuma_manager.dto;

import com.example.furuma_manager.model.AttachFacility;
import com.example.furuma_manager.model.Contract;

public class ContractDto {
    private Contract contract;
    private AttachFacility attachFacility;
    private int quantity;

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ContractDto() {
    }

    public ContractDto(Contract contract, AttachFacility attachFacility, int quantity) {
        this.contract = contract;
        this.attachFacility = attachFacility;
        this.quantity = quantity;
    }
}
