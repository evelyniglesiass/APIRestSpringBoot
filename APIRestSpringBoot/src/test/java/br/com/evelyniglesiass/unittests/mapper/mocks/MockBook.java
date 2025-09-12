package br.com.evelyniglesiass.unittests.mapper.mocks;

import br.com.evelyniglesiass.data.dto.BookDTO;
import br.com.evelyniglesiass.model.Book;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockBook {


    public Book mockEntity() {
        return mockEntity(0);
    }

    public BookDTO mockDTO() {
        return mockDTO(0);
    }

    public List<Book> mockEntityList() {
        List<Book> books = new ArrayList<Book>();
        for (int i = 0; i < 14; i++) {
            books.add(mockEntity(i));
        }
        return books;
    }

    public List<BookDTO> mockDTOList() {
        List<BookDTO> books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            books.add(mockDTO(i));
        }
        return books;
    }

    public Book mockEntity(Integer number) {
        Book book = new Book();
        book.setAuthor("Author Test" + number);
        book.setLaunchDate(new Date(1735236900000L));
        book.setPrice(new BigDecimal(number));
        book.setId(number.longValue());
        book.setTitle("Title Test" + number);
        return book;
    }

    public BookDTO mockDTO(Integer number) {
        BookDTO book = new BookDTO();
        book.setAuthor("Author Test" + number);
        book.setLaunchDate(new Date(1735236900000L));
        book.setPrice(new BigDecimal(number));
        book.setId(number.longValue());
        book.setTitle("Title Test" + number);
        return book;
    }
}
