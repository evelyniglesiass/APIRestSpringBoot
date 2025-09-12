package br.com.evelyniglesiass.services;

import br.com.evelyniglesiass.controllers.BookController;
import br.com.evelyniglesiass.controllers.TestLogController;
import br.com.evelyniglesiass.data.dto.BookDTO;
import br.com.evelyniglesiass.exception.RequiredObjectIsNullException;
import br.com.evelyniglesiass.exception.ResourceNotFoundException;
import br.com.evelyniglesiass.model.Book;
import br.com.evelyniglesiass.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static br.com.evelyniglesiass.mapper.ObjectMapper.parseListObjects;
import static br.com.evelyniglesiass.mapper.ObjectMapper.parseObject;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BookService {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    BookRepository repository;

    private Logger logger = LoggerFactory.getLogger(TestLogController.class.getName());

    public List<BookDTO> findAll() {
        logger.info("Finding All Books!");

        var books = parseListObjects(repository.findAll(), BookDTO.class);
        books.forEach(this::addHateoasLinks);

        return books;
    }

    public BookDTO findById(Long id) {
        logger.info("Finding one Book!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        var dto = parseObject(entity, BookDTO.class);
        addHateoasLinks(dto);

        return dto;
    }

    public BookDTO create(BookDTO book) {
        if (book == null) throw  new RequiredObjectIsNullException();

        logger.info("Creating one Book!");

        var entity = parseObject(book, Book.class);

        var dto = parseObject(repository.save(entity), BookDTO.class);
        addHateoasLinks(dto);

        return dto;
    }

    public BookDTO update(BookDTO book) {

        if (book == null) throw  new RequiredObjectIsNullException();

        logger.info("Updating one Book!");

        Book entity = repository.findById(book.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setAuthor(book.getAuthor());
        entity.setLaunchDate(book.getLaunchDate());
        entity.setPrice(book.getPrice());
        entity.setTitle(book.getTitle());

        var dto = parseObject(repository.save(entity), BookDTO.class);
        addHateoasLinks(dto);

        return dto;
    }

    public void delete(Long id) {
        logger.info("Deleting one Book!");

        Book entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        repository.delete(entity);
    }

    private void addHateoasLinks(BookDTO dto) {
        dto.add(linkTo(methodOn(BookController.class).findById(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(BookController.class).findAll()).withRel("findAll").withType("GET"));
        dto.add(linkTo(methodOn(BookController.class).create(dto)).withRel("create").withType("POST"));
        dto.add(linkTo(methodOn(BookController.class).update(dto)).withRel("update").withType("PUT"));
        dto.add(linkTo(methodOn(BookController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));
    }
}
