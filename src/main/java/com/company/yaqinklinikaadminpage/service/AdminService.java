package com.company.yaqinklinikaadminpage.service;

import com.company.yaqinklinikaadminpage.entity.AdminEntity;
import com.company.yaqinklinikaadminpage.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;
    public boolean checkAdmin(AdminEntity admin){
        Optional<AdminEntity> result = adminRepository.findByLogin(admin.getLogin());
        if(result.isPresent() && admin.getParol().equals(result.get().getParol())){
            return true;
        }
        return false;

    }
}
