package com.example.spring5webfluxrest.bootstrap;

import com.example.spring5webfluxrest.domain.Category;
import com.example.spring5webfluxrest.domain.Vendor;
import com.example.spring5webfluxrest.repositories.CategoryRepository;
import com.example.spring5webfluxrest.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrap implements CommandLineRunner {

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        loadVendors();
    }

    private void loadVendors() {
        if (categoryRepository.count().block() == 0) {
            System.out.println("Loading Category Data");
            categoryRepository.save(Category.builder().description("Fruits").build()).block();
            categoryRepository.save(Category.builder().description("Nuts").build()).block();
            categoryRepository.save(Category.builder().description("Breads").build()).block();
            categoryRepository.save(Category.builder().description("Meats").build()).block();
            categoryRepository.save(Category.builder().description("Eggs").build()).block();
        }

        System.out.println("categoryRepository.count().block() = " + categoryRepository.count().block());


        if (vendorRepository.count().block() == 0) {
            System.out.println("Loading Vendor Data");
            vendorRepository.save(Vendor.builder().firstName("John").lastName("Doe").build()).block();
            vendorRepository.save(Vendor.builder().firstName("Jane").lastName("Austin").build()).block();
        }
        System.out.println("vendorRepository.count().block() = " + vendorRepository.count().block());

    }
}
