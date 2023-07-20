package students.LatifSait.extraHwPro.task1_srp.service.util;

import org.springframework.stereotype.Component;
import students.LatifSait.extraHwPro.task1_srp.entity.Book;
import students.LatifSait.extraHwPro.task1_srp.entity.Reader;
import students.LatifSait.extraHwPro.task1_srp.entity.ReaderBook;

import java.time.LocalDateTime;

@Component
public class Convertor {
    public ReaderBook convertToReadBookTakeBook(Book book, Reader reader) {
        ReaderBook readerBook = new ReaderBook();
        readerBook.setBook(book);
        readerBook.setReader(reader);
        readerBook.setBookOutDate(LocalDateTime.now());
        return  readerBook;
    }

    public ReaderBook convertToReadBookReturnBook(Book book, Reader reader) {
        ReaderBook readerBook = new ReaderBook();
        readerBook.setBook(book);
        readerBook.setReader(reader);
        readerBook.setBookReturnDate(LocalDateTime.now());
        return readerBook;
    }

}
