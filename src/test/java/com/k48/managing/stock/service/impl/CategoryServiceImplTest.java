package com.k48.managing.stock.service.impl;

import com.k48.managing.stock.dto.CategoryDto;
import com.k48.managing.stock.exceptions.EntityNotFoundException;
import com.k48.managing.stock.exceptions.ErrorCodes;
import com.k48.managing.stock.exceptions.InvalidEntityException;
import com.k48.managing.stock.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryService service;

    @Test
    public void shouldUpdateCategoryWithSuccess() {
        // Step 1: Create & Save category
        CategoryDto category = new CategoryDto();
        category.setCode("Cat test");
        category.setDesignation("Designation test");
        category.setIdEntreprise(1);

        CategoryDto savedCategory = service.save(category);

        assertNotNull(savedCategory.getId(), "Saved category ID should not be null");

        // Step 2: Update the category
        savedCategory.setDesignation("Updated Designation");
        savedCategory.setCode("Updated Code");

        CategoryDto updatedCategory = service.save(savedCategory);

        // Step 3: Assertions
        assertNotNull(updatedCategory, "Updated category should not be null");
        assertEquals(savedCategory.getId(), updatedCategory.getId(), "ID should remain the same after update");
        assertEquals("Updated Designation", updatedCategory.getDesignation(), "Designation should be updated");
        assertEquals("Updated Code", updatedCategory.getCode(), "Code should be updated");
        assertEquals(savedCategory.getIdEntreprise(), updatedCategory.getIdEntreprise(), "Enterprise ID should not change");
    }
    @Test
    public void shouldUSaveCategoryWithSuccess() {
        // Create CategoryDto using constructor + setters
        CategoryDto expectedCategory = new CategoryDto();
        expectedCategory.setCode("Cat test");
        expectedCategory.setDesignation("Designation test");
        expectedCategory.setIdEntreprise(1);

        // Save via service
        CategoryDto savedCategory = service.save(expectedCategory);

        // Assertions
        assertNotNull(savedCategory, "Saved category should not be null");
        assertNotNull(savedCategory.getId(), "Saved category ID should not be null");
        assertEquals(expectedCategory.getCode(), savedCategory.getCode(), "Category code should match");
        assertEquals(expectedCategory.getDesignation(), savedCategory.getDesignation(), "Category designation should match");
        assertEquals(expectedCategory.getIdEntreprise(), savedCategory.getIdEntreprise(), "Category enterprise ID should match");
    }
    @Test
    public void shouldThrowInvalidEntityExceptionWhenCategoryIsInvalid() {
        // Step 1: Create invalid category (missing required fields like code/designation)
        CategoryDto invalidCategory = new CategoryDto();
        invalidCategory.setIdEntreprise(1); // only enterprise ID, missing code + designation

        // Step 2: Assert exception is thrown
        assertThrows(InvalidEntityException.class, () -> {
            service.save(invalidCategory);
        }, "Saving an invalid category should throw InvalidEntityException");
    }
    @Test
    public void shouldThrowEntityNotFoundException() {
        EntityNotFoundException expectedException = assertThrows(
                EntityNotFoundException.class,
                () -> service.findById(0)
        );

        assertEquals(ErrorCodes.CATEGORY_NOT_FOUND, expectedException.getErrorCode());
        assertEquals("Aucune category avec l'ID = 0 n' ete trouve dans la BDD", expectedException.getMessage());
    }

    @Test
    public void shouldThrowEntityNotFoundException2() {
        assertThrows(EntityNotFoundException.class, () -> service.findById(0));

        /*
        EntityNotFoundException expectedException = assertThrows(
                EntityNotFoundException.class,
                () -> service.findById(0)
        );

        assertEquals(ErrorCodes.CATEGORY_NOT_FOUND, expectedException.getErrorCode());
        assertEquals("Aucune category avec l'ID = 0 n' ete trouve dans la BDD", expectedException.getMessage());
        */
    }





}


/*
package com.k48.managing.stock.service.impl;

import com.k48.managing.stock.dto.CategoryDto;
import com.k48.managing.stock.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryService service;

    @Test
    public void shouldUpdateCategoryWithSuccess() {
        // Create CategoryDto using constructor + setters
        CategoryDto expectedCategory = new CategoryDto();
        expectedCategory.setCode("Cat test");
        expectedCategory.setDesignation("Designation test");
        expectedCategory.setIdEntreprise(1);

        // Save via service
        CategoryDto savedCategory = service.save(expectedCategory);

        // Assertions
        assertNotNull(savedCategory, "Saved category should not be null");
        assertNotNull(savedCategory.getId(), "Saved category ID should not be null");
        assertEquals(expectedCategory.getCode(), savedCategory.getCode(), "Category code should match");
        assertEquals(expectedCategory.getDesignation(), savedCategory.getDesignation(), "Category designation should match");
        assertEquals(expectedCategory.getIdEntreprise(), savedCategory.getIdEntreprise(), "Category enterprise ID should match");
    }
}


/*
package com.k48.managing.stock.service.impl;

import com.k48.managing.stock.dto.CategoryDto;
import com.k48.managing.stock.service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static jdk.internal.classfile.Classfile.build;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    // create a category service object
    @Autowired
    private CategoryService Service;
    @Test
    public  void shouldSaveCategoryWithSuccess() {
       CategoryDto expectedCategoey = CategoryDto.builder()
                .code("Cat test")
                .designation("Designation test")
                .isEntreprise(1)
                .build();
       // place this in a variable
       CategoryDto saveCategory = Service.save(expectedCategoey);
       assertNotNull(saveCategory);
       // do Thesame for id
        assertNotNull(saveCategory.getId());
        assertEquals(saveCategory.getCode(), expectedCategoey.getCode());
        assertEquals(saveCategory.getDesignation(), expectedCategoey.getDesignation());
        assertEquals(expectedCategoey.getIdEntreprise(), saveCategory.getIdEntreprise());
  // the above is test service for the Category
    }
}
*/
