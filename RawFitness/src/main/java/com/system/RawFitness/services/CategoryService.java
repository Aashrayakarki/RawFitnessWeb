package com.system.RawFitness.services;

import com.system.RawFitness.Entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> fetchAll();
    Category fetchById(Integer id);
}
