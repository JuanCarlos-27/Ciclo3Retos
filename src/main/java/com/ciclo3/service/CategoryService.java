package com.ciclo3.service;

import com.ciclo3.model.Category;
import com.ciclo3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategory() {
        return (List<Category>) categoryRepository.getAllCategory();
    }

    public Optional<Category> getCategoryById(Integer id) {
        return categoryRepository.getCategoryById(id);
    }

    public Category saveCategory(Category c) {
        return categoryRepository.saveCategory(c);
    }

    public boolean deleteCategory(Integer id){
        categoryRepository.deleteCategory(id);
        return true;
    }
    public Category updateCategory (Category c){
        return categoryRepository.updateCategory(c);
    }
}
