package com.bayd.apautomation.service.impl;


import com.bayd.apautomation.dto.*;
import com.bayd.apautomation.entity.*;
import com.bayd.apautomation.enums.Status;
import com.bayd.apautomation.exception.CustomResourceNotFoundException;
import com.bayd.apautomation.mapper.ApprovalMapper;
import com.bayd.apautomation.mapper.BillMapper;
import com.bayd.apautomation.repository.ApprovalRepo;
import com.bayd.apautomation.repository.BillRepo;
import com.bayd.apautomation.repository.UserRepo;
import com.bayd.apautomation.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


@Service
@RequiredArgsConstructor
public class BillServiceImpl implements BillService {


    private final BillRepo billRepo;
    private final UserRepo userRepo;
    private final ApprovalRepo approvalRepo;
    private final BillMapper billMapper = BillMapper.INSTANCE;

    private final ApprovalMapper approvalMapper = ApprovalMapper.INSTANCE;

    private final Path root = Paths.get("D:/images/");

    @Override
    public Optional<BillDTO> save(BillDTO businessDto, UUID userUUID) {
        return Optional.empty();
    }

    @Override
    public ApprovalDTO saveorupdate(BillReqDTO bdto, UUID userUUID) {
        Bill bill = new Bill();

        User user = new User();
        if (Objects.nonNull(bdto.getUserid())) {
            Optional<User> byId = userRepo.findById(bdto.getUserid());
            if (byId.isPresent()) {
                user = byId.get();
                bill.setBilluser(user);
            } else {
                throw new CustomResourceNotFoundException("please enter valid user details");
            }
        }
        String extension = StringUtils.getFilenameExtension(bdto.getBillfile().getOriginalFilename());
        String fileName = user.getUserid().toString() + "-" + new Date().getTime() + "." + extension;

//        List<Approval> approvals = new ArrayList<>();
        Approval approval = new Approval();
        approval.setStatus("Pending");
        approval.setApprovedBy(user.getFirstname() + " " + user.getLastname());
        approval.setApprovedOn(new Date());
        approvalMapper.prepareForCreate(approval);

//        approvals.add(approval);

        bill.setName(bdto.getName());
        bill.setBilldate(new Date());
        bill.setAmount(bdto.getAmount());
        bill.setTax(bdto.getTax());
        bill.setDeptname(bdto.getDeptname());
        bill.setFilename(fileName);

        billMapper.prepareForCreate(bill);

        try {
//            bdto.getBillfile().transferTo(new File("D:\\images\\" + "sana" + bdto.getBillfile().getOriginalFilename()));
            bdto.getBillfile().transferTo(new File("D:\\images\\" + fileName));
//            Files.copy(businessDto.getBillfile().getInputStream(), this.root.resolve(businessDto.getBillfile().getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        approval.setApprovalbill(bill);

//        Bill save = billRepo.save(bill);
        Approval save = approvalRepo.save(approval);
        return approvalMapper.convertDto(save);
    }

    @Override
    public Optional<BillDTO> get(UUID uuid) {
        Optional<Bill> byId = billRepo.findById(uuid);
        return byId.map(billMapper::convertDto);
    }

    @Override
    public Status delete(UUID uuid) {
        return null;
    }

    @Override
    public BillsDTO getAllBills() {
        List<Bill> all = billRepo.findAll();
        BillsDTO billsDTO = new BillsDTO();
        billsDTO.setBillDTOS(billMapper.convertDtos(all));
        return billsDTO;
    }
}
