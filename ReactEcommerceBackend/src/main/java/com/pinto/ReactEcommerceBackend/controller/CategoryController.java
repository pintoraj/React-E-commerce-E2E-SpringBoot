package com.pinto.ReactEcommerceBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinto.ReactEcommerceBackend.dto.request.CategoryRequest;
import com.pinto.ReactEcommerceBackend.dto.response.CategoryResponse;
import com.pinto.ReactEcommerceBackend.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest request){
		CategoryResponse createdCategory = categoryService.createCategory(request);
		return new ResponseEntity<>(createdCategory,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryResponse> getCategory(
			@Valid @PathVariable Integer id){
		CategoryResponse category = categoryService.getCategoryByID(id);
		return ResponseEntity.ok(category);
	} 
	
	@GetMapping
	public ResponseEntity<List<CategoryResponse>> getAllCategories(){
		List<CategoryResponse> categories = categoryService.getAllCategories();
		return ResponseEntity.ok(categories);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoryResponse> updateCategory(
			@Valid @PathVariable Integer id,
			@Valid @RequestBody CategoryRequest request){
		
		CategoryResponse updatedCategory = categoryService.updateCategory(id, request);
		return ResponseEntity.ok(updatedCategory);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategory(@Valid @PathVariable Integer id){
		categoryService.deleteCategory(id);
		return ResponseEntity.noContent().build();	
	}
	
	
	
}
