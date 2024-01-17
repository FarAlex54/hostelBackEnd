package com.example.hostelbackend.services;


import com.example.hostelbackend.models.PackageCompany;
import com.example.hostelbackend.repository.PackageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = false)
public class PackageService {
    private final PackageRepository packageRepository;

    public PackageService(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }
    //список всех пакетов
    public List<PackageCompany> getAllPackage(){
        return packageRepository.findAll();
    }
    public PackageCompany getPackageId(int id){
        Optional<PackageCompany> optionalPackage = packageRepository.findById(id);
        return optionalPackage.orElse(null);
    }
    public void savePackage(PackageCompany packageCompany){
        packageRepository.save(packageCompany);
    }
    public void updatePackage(int id, PackageCompany packageCompany){
        packageCompany.setId(id);
        packageRepository.save(packageCompany);
    }
    public void deletePackage(int id){
        packageRepository.deleteById(id);
    }

}