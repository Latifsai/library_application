package students.LatifSait.extraHwPro.task1_srp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import students.LatifSait.extraHwPro.task1_srp.dto.TakeBookDTORequest;
import students.LatifSait.extraHwPro.task1_srp.dto.TakeBookDTOResponse;
import students.LatifSait.extraHwPro.task1_srp.validation.reader_validation.FindByIDReadeValidation;

@Component
@Transactional
@AllArgsConstructor
public class TakeBookService {
    private final ReaderBookRepository readerBookRepository;
    private final OrmBookRepositoryImpl bookRepository;
    private final ReaderRepository readerRepository;

    public TakeBookDTOResponse takeBook(TakeBookDTORequest request) {
        FindByIDReadeValidation findByIDReadeValidation = new FindByIDReadeValidation();
        findByIDReadeValidation.validate(request, readerRepository.findAllReaders());

        var reader = readerRepository.findByID(request.getUserId());
        var book = bookRepository.findByTitle(request.getBookTitle());
        return null;
    }
}
