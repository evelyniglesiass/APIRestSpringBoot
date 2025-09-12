package br.com.evelyniglesiass.repositories;

import br.com.evelyniglesiass.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
