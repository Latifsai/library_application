package students.LatifSait.extraHwPro.task1_srp.service.readerBook;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import students.LatifSait.extraHwPro.task1_srp.dto.readeBook.ReturnBookDTOResponse;
import students.LatifSait.extraHwPro.task1_srp.dto.readeBook.TakeAndReturnBookDTORequest;
import students.LatifSait.extraHwPro.task1_srp.errors.CoreError;
import students.LatifSait.extraHwPro.task1_srp.service.util.Convertor;
import students.LatifSait.extraHwPro.task1_srp.validation.book_validation.FindByTitleBookValidation;
import students.LatifSait.extraHwPro.task1_srp.validation.reader_validation.FindReaderByIDValidation;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
@AllArgsConstructor
public class ReturnBookService {
    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final ReaderBookRepository readerBookRepository;
    private final Convertor convertor;

    public ReturnBookDTOResponse returnBook(TakeAndReturnBookDTORequest request) {
        var findReader = findReaderByIDValidation().validate(request, readerRepository.findAllReaders());
        var findBook = findByTitleBookValidation().validate(request, bookRepository.getLibrary());

        List<CoreError> errors = new ArrayList<>();
        errors.addAll(findReader);
        errors.addAll(findBook);

        if (!errors.isEmpty()) {
            return new ReturnBookDTOResponse(errors);
        }

        var reader = readerRepository.findByID(request.getUserId());
        var book = bookRepository.findByTitle(request.getBookTitle());
        var readerBook = convertor.convertToReadBookReturnBook(book, reader);
        readerBookRepository.save(readerBook);
        return new ReturnBookDTOResponse(reader.getForename(), reader.getSurename(), book.getTitle(), book.getId());
    }


    private FindReaderByIDValidation findReaderByIDValidation(){
        return new FindReaderByIDValidation();
    }

    private FindByTitleBookValidation findByTitleBookValidation() {
        return new FindByTitleBookValidation();
    }
}
