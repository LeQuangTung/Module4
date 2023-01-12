package com.example.testmodule4.service.impl;

import com.example.testmodule4.model.Branch;
import com.example.testmodule4.repository.IBranchRepository;
import com.example.testmodule4.service.IBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BranchService implements IBranchService {
    @Autowired
    IBranchRepository iBranchRepository;
    @Override
    public Iterable<Branch> findAll() {
        return iBranchRepository.findAll();
    }

    @Override
    public Optional<Branch> findById(Long id) {
        return iBranchRepository.findById(id);
    }

    @Override
    public Branch save(Branch branch) {
        return iBranchRepository.save(branch);
    }

    @Override
    public void deleteById(Long id) {
        iBranchRepository.deleteById(id);
    }

    @Override
    public Iterable<Branch> sortByAge() {
        return null;
    }
}
