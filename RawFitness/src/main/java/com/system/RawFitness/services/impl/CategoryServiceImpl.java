package com.system.RawFitness.services.impl;

import com.system.RawFitness.Entity.Category;
import com.system.RawFitness.repo.CategoryRepo;
import com.system.RawFitness.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;

    @Override
    public List<Category> fetchAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category fetchById(Integer id) {
        return categoryRepo.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
    }
}
