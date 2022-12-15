package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.Department;
import com.codegym.service.CustomerService;
import com.codegym.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final ICustomerService customerService = new CustomerService();

    @GetMapping("")
    public String index(Model model){
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model){
        List<Department> departmentList = customerService.findAllDepartment();
        model.addAttribute("departments",departmentList);
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/save")
    public String save(Customer customer,@RequestParam("departmentSelect") int id, RedirectAttributes attributes){
        customer.setId((int) (Math.random() * 10000));
        customer.setDepartment(customerService.findByIdDepartment(id));
        customerService.save(customer);
        attributes.addFlashAttribute("success", "Add customer successfully");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Customer customer,@RequestParam("departmentSelect") int id, RedirectAttributes attributes) {
        customerService.update(customer.getId(), customer);
        customer.setDepartment(customerService.findByIdDepartment(id));
        attributes.addFlashAttribute("success", "Edit customer successfully");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        customerService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "view";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "search") String search, Model model) {
        List<Customer> customers = customerService.searchByName(search);
        model.addAttribute("customers", customers);
        return "/index";
    }
}
