package com.sk.services;

import com.sk.dtos.CategoryDto;
import com.sk.dtos.PageableResponse;

public interface CategoryService {

	
	
	//create
	CategoryDto create(CategoryDto categoryDto);
	
	
	//update
	
	CategoryDto update(CategoryDto categoryDto,String categoryId);
	
	//delete
	void delete(String categoryId);
	
	
	//get-all
	PageableResponse<CategoryDto> getAll(int pageNumber,int pageSize,String sortBy,String sortDir);
	
	
	//single category detail
	
	CategoryDto get(String categoryId);
	
	//search
	
	
}
