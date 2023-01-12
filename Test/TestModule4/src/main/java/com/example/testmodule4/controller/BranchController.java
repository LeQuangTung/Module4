package com.example.testmodule4.controller;

import com.example.testmodule4.model.Branch;
import com.example.testmodule4.model.Employee;
import com.example.testmodule4.service.impl.BranchService;
import com.example.testmodule4.service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@CrossOrigin("*")
@RequestMapping("/branchs")
public class BranchController {
    @Autowired
    private BranchService branchService;

    @GetMapping
    public ResponseEntity<Iterable<Branch>> showAll() {
        return new ResponseEntity<>(branchService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Branch> creatProduct(@RequestBody Branch branch){
        return new ResponseEntity<>(branchService.save(branch), HttpStatus.CREATED);
    }



}
