package com.example.hostelbackend.controller;


import com.example.hostelbackend.models.PackageCompany;
import com.example.hostelbackend.repository.PackageRepository;
import com.example.hostelbackend.services.PackageService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin/package")
public class PackageController {
    private final PackageService packageService;
    private final PackageRepository packageRepository;

    public PackageController(PackageService packageService, PackageRepository packageRepository) {
        this.packageService = packageService;
        this.packageRepository = packageRepository;
    }
    @GetMapping("/add")
    public String addPackage(Model model){
        model.addAttribute("packages",new PackageCompany());
        return "Packages/addPackage";
    }
    @PostMapping("/add")
    public String addPackage(@ModelAttribute("packages") @Valid PackageCompany packageCompany, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println("Возникла ошибка в контроллере с пакетами при добавлении");
            return "Packages/addPackage";
        }
        packageService.savePackage(packageCompany);
        return "redirect:/admin";
    }
    @GetMapping("/delete/{id}")
    public String deletePackage(@PathVariable("id") int id){
        packageService.deletePackage(id);
        return "redirect:/admin";
    }
    @GetMapping("/edit/{id}")
    public String editPackage(Model model, @PathVariable("id") int id){
        model.addAttribute("packages", packageService.getPackageId(id));
        return "Packages/editPackage";
    }
    @PostMapping("/edit/{id}")
    public String editPackage(@ModelAttribute("packages") @Valid PackageCompany packageCompany, BindingResult bindingResult, @PathVariable("id") int id){
        if(bindingResult.hasErrors()){
            System.out.println("Произошла ошибка при редактировании пакета");
            return "Packages/editPackage";
        }
        packageService.updatePackage(id, packageCompany);
        return "redirect:/admin";
    }

}
