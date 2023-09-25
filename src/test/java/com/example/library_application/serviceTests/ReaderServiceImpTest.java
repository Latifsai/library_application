package com.example.library_application.serviceTests;

import com.example.library_application.dto.reader.*;
import com.example.library_application.errors.Message;
import com.example.library_application.errors.exeptions.NotFoundException;
import com.example.library_application.errors.exeptions.RightsException;
import com.example.library_application.generator.DTOCreator;
import com.example.library_application.generator.EntityCreator;
import com.example.library_application.service.reader.*;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReaderServiceImpTest {
    @Mock
    DeleteReaderServiceImp deleteService;
    @Mock
    FindReaderServiceImp findService;
    @Mock
    GetAllReadersServiceImp getService;
    @Mock
    RegisterReaderServiceImp registerService;
    @Mock
    UpdateReaderServiceImp updateService;

    @Test
    public void testDeleteFunctional() {
        var request = new ReaderRequest(1, "32344240034adm");
        when(deleteService.execute(request)).thenReturn(new ReaderResponse("John", "Snow"));

        var expected = new ReaderResponse("John", "Snow");
        var actual = deleteService.execute(request);
        assertEquals(expected, actual);
    }

    @Test
    public void testDeleteFunctionalNotFoundException() {
        var request = new ReaderRequest(1, "32344240034adm");
        when(deleteService.execute(request)).thenThrow(new NotFoundException(Message.READER_NOT_FOUND_MESSAGE));
        assertThrows(NotFoundException.class, () -> deleteService.execute(request));
    }

    @Test
    public void testFindFunctionalForAdmin() {
        var request = new FindReaderRequest(1, "32344240034adm");
        when(findService.executeForAdmin(request))
                .thenReturn(new ReaderResponseForAdmin(1, "John", "Snow", "4374564674"));

        var expected = new ReaderResponseForAdmin(1, "John", "Snow", "4374564674");
        var actual = findService.executeForAdmin(request);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindFunctional() {
        var request = new FindReaderRequest(1, "32344240034adm");
        when(findService.execute(request)).thenReturn(new ReaderResponse("John", "Snow"));

        var expected = new ReaderResponse("John", "Snow");
        var actual = findService.execute(request);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindFunctionalNotFoundException() {
        var request = new FindReaderRequest(1, "32344240034adm");
        when(findService.execute(request)).thenThrow(new NotFoundException(Message.READER_NOT_FOUND_MESSAGE));
        assertThrows(NotFoundException.class, () -> findService.execute(request));
    }

    @Test
    public void testGetFunctionalForAdmin() {
        var request = new ReaderRequest(1, "32344240034adm");
        when(getService.execute(request))
                .thenReturn(new GetAllReaderResponseForAdmin(List.of(EntityCreator.getReader())));

        var expected = new GetAllReaderResponseForAdmin(List.of(EntityCreator.getReader()));
        var actual = getService.execute(request);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFunctionalForReader() {
        var request = new ReaderRequest(1, "32344240");
        when(getService.executeForReader(request))
                .thenReturn(new GetAllReadersForReaderResponse(List.of(DTOCreator.getResponseForUser())));

        var expected = new GetAllReadersForReaderResponse(List.of(DTOCreator.getResponseForUser()));
        var actual = getService.executeForReader(request);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFunctionalNotFoundException() {
        var request = new ReaderRequest(5, "32344240");
        when(getService.execute(request)).thenThrow(new RightsException(Message.ROOTS_NOT_ALLOWED_MESSAGE));
        assertThrows(RightsException.class, () -> getService.execute(request));
    }

    @Test
    public void testRegisterFunctional() {
        var request = new RegisterReaderDTORequest("32344240adm", "John", "Snow");

        when(registerService.execute(request))
                .thenReturn(new RegisterReaderDTOResponse(1, "John", "Snow"));

        var expected = new RegisterReaderDTOResponse(1, "John", "Snow");
        var actual = registerService.execute(request);
        assertEquals(expected, actual);
    }

    @Test
    public void testRegisterFunctionalNotFoundException() {
        var request = new RegisterReaderDTORequest("32344240", "John", "Snow");
        when(registerService.execute(request)).thenThrow(new RightsException(Message.ROOTS_NOT_ALLOWED_MESSAGE));
        assertThrows(RightsException.class, () -> registerService.execute(request));
    }

    @Test
    public void testRegisterFunctionalValidation() {
        var request = new RegisterReaderDTORequest("32344240adm", null, null);
        Validator v = Validation.buildDefaultValidatorFactory().getValidator();
        var set = v.validate(request);
       assertEquals(6, set.size());
    }


    @Test
    public void testUpdateFunctional() {
        var request = new UpdateReaderRequest(1, "32344240adm", null, "Stark");

        when(updateService.execute(request))
                .thenReturn(new UpdateReaderResponse(1, "John", "Stark"));

        var expected = new UpdateReaderResponse(1, "John", "Stark");
        var actual = updateService.execute(request);
        assertEquals(expected, actual);
    }

    @Test
    public void testUpdateFunctionalNotFoundException() {
        var request = new UpdateReaderRequest(4, "32344240adm", "John", "Snow");
        when(updateService.execute(request)).thenThrow(new NotFoundException(Message.ROOTS_NOT_ALLOWED_MESSAGE));
        assertThrows(NotFoundException.class, () -> updateService.execute(request));
    }


}
