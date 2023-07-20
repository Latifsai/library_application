package students.LatifSait.extraHwPro.task1_srp.service.reader;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import students.LatifSait.extraHwPro.task1_srp.dto.reader.RegisterReaderRequest;
import students.LatifSait.extraHwPro.task1_srp.dto.reader.RegisterReaderResponse;
import students.LatifSait.extraHwPro.task1_srp.entity.Reader;
import students.LatifSait.extraHwPro.task1_srp.errors.CoreError;
import students.LatifSait.extraHwPro.task1_srp.validation.reader_validation.PersonalCodeValidation;
import students.LatifSait.extraHwPro.task1_srp.validation.reader_validation.RegisterReaderValidation;

import java.util.List;

@Component
@Transactional
public class RegisterReaderService {

    @Autowired
    ReaderRepository repository;

    public RegisterReaderResponse register(RegisterReaderRequest request) {
        RegisterReaderValidation validation = new RegisterReaderValidation();
        List<CoreError> errors = validation.validate(request);

        if (!errors.isEmpty()) {
            return new RegisterReaderResponse(errors);
        }

        //add validation for code
        Reader reader = createReader(request);

        PersonalCodeValidation personalCodeValidation = new PersonalCodeValidation();
        errors.addAll(personalCodeValidation.validate(reader));

        if (!errors.isEmpty()) {
            return new RegisterReaderResponse(errors);
        }

        return new RegisterReaderResponse(reader);
    }

    private Reader createReader(RegisterReaderRequest request) {
        Reader reader = new Reader();
        reader.setForename(request.getForename());
        reader.setSurename(request.getSurname());
        reader.setPersonalCode(createPersonalCode(request));
        return reader;
    }

    private String createPersonalCode(RegisterReaderRequest request) {
        return request.getForename().hashCode() + request.getSurname().hashCode() + "";
    }

}
