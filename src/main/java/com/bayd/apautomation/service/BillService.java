package com.bayd.apautomation.service;

import com.bayd.apautomation.dto.*;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

public interface BillService extends AbstractService<BillDTO, UUID> {

    BillsDTO getAllBills();

    ApprovalDTO saveorupdate(BillReqDTO billReqDTO, UUID userUUID) throws IOException;
}
