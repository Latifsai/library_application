package students.LatifSait.extraHwPro.task1_srp.service.reader;



import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import students.LatifSait.extraHwPro.task1_srp.dto.reader.GetAllReadersResponse;
import students.LatifSait.extraHwPro.task1_srp.validation.reader_validation.GetAllReadersValidation;

@Component
@Transactional

public class GetAllReadersService {
    private final ReaderRepository readerRepository;

    public GetAllReadersService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    public GetAllReadersResponse getAllReaders(){
        GetAllReadersValidation validation = new GetAllReadersValidation();

        var users = readerRepository.findAllReaders();
        validation.validate(users);
        return new GetAllReadersResponse(users);
    }
}
