package com.k48.managing.stock.controllers;

import com.k48.managing.stock.controllers.api.CategoryApi;
import com.k48.managing.stock.dto.CategoryDto;
import com.k48.managing.stock.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController implements CategoryApi {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public CategoryDto save(@RequestBody CategoryDto dto) {
        return categoryService.save(dto);
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public CategoryDto findById(Integer idCategory) {
        return categoryService.findById(idCategory);
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public CategoryDto findByCode(String codeCategory) {
        return categoryService.findByCode(codeCategory);
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(Integer id) {
        categoryService.delete(id);
    }
}
