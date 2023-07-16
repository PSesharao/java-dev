package com.mindtree.carproject.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mindtree.carproject.dto.BookDto;
import com.mindtree.carproject.entity.Book;

@Component
public class BookConverter {
	public BookDto entityToDto( Book book) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(book, BookDto.class);
	}

	public  Book dtoToEntity(BookDto bookDto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(bookDto,  Book.class);

	}
}
