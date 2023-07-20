package students.LatifSait.extraHwPro.task1_srp.service.readerBook;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import students.LatifSait.extraHwPro.task1_srp.dto.readeBook.TakeAndReturnBookDTORequest;
import students.LatifSait.extraHwPro.task1_srp.dto.readeBook.TakeBookDTOResponse;
import students.LatifSait.extraHwPro.task1_srp.errors.CoreError;
import students.LatifSait.extraHwPro.task1_srp.service.util.Convertor;
import students.LatifSait.extraHwPro.task1_srp.validation.book_validation.FindByTitleBookValidation;
import students.LatifSait.extraHwPro.task1_srp.validation.reader_validation.FindReaderByIDValidation;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
@AllArgsConstructor
public class TakeBookService {
    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final ReaderBookRepository readerBookRepository;
    private final Convertor convertor;

    public TakeBookDTOResponse takeBook(TakeAndReturnBookDTORequest request) {
        FindReaderByIDValidation findReaderByIDValidation = new FindReaderByIDValidation();
        var findReader = findReaderByIDValidation.validate(request, readerRepository.findAllReaders());

        FindByTitleBookValidation findByTitleBookValidation = new FindByTitleBookValidation();
        var findBook = findByTitleBookValidation.validate(request, bookRepository.getLibrary());

        List<CoreError> errors = new ArrayList<>();
        errors.addAll(findReader);
        errors.addAll(findBook);

        if (!errors.isEmpty()) {
            return new TakeBookDTOResponse(errors);
        }

        var reader = readerRepository.findByID(request.getUserId());
        var book = bookRepository.findByTitle(request.getBookTitle());
        var readerBook = convertor.convertToReadBookTakeBook(book, reader); //to add to db
        if (readerBook.getBookReturnDate() == null ) {
            readerBookRepository.save(readerBook);
            return new TakeBookDTOResponse(reader.getForename(), reader.getSurename(), book.getTitle(), readerBook.getBookOutDate());
        }else {
            throw new AddToReaderBookDatabaseException("Book is not in library!");
        }
    }


}
