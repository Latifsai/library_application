package com.example.library_application.serviceTests;

import com.example.library_application.dto.admin.*;
import com.example.library_application.errors.Message;
import com.example.library_application.errors.exeptions.NotFoundException;
import com.example.library_application.errors.exeptions.RightsException;
import com.example.library_application.generator.DTOCreator;
import com.example.library_application.generator.EntityCreator;
import com.example.library_application.service.admin.*;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {

    @Mock
    private CreateAdminService createdService;
    @Mock
    private DeleteAdminsService deleteService;
    @Mock
    private GetAdminsService getService;
    @Mock
    private SearchAdminService searchService;
    @Mock
    private UpdateAdminService updateService;
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void testCreateAdmin() {
        var request = new CreateAdminRequest(
                "Adolf", "admin@mail.ru", 2125);
        when(createdService.execute(request)).thenReturn(DTOCreator.getCreateAdminResponse());
        var expected = DTOCreator.getCreateAdminResponse();
        var actual = createdService.execute(request);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCreateAdminValidation() {
        var request = new CreateAdminRequest("", "admin@mail.com", 2125);
        var errors = validator.validate(request);
        Assertions.assertEquals(1, errors.size());

        var messages = errors.iterator().next();
        Assertions.assertEquals("не должно быть пустым", messages.getMessage());
    }

    @Test
    public void testDeleteFunctionalIfInputIsTrue() {
        var request = new DeleteAdminRequest(1, "458457hefhiu39adm");
        when(deleteService.execute(request)).thenReturn(new DeleteAdminResponse(1, "John", "458457hefhiu39adm"));

        var expected = deleteService.execute(request);
        var actual = new DeleteAdminResponse(1, "John", "458457hefhiu39adm");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDeleteFunctionalIfRightsException() {
        var request = new DeleteAdminRequest(1, "458457hefhiu39");
        when(deleteService.execute(request)).thenThrow(new RightsException(Message.ROOTS_NOT_ALLOWED_MESSAGE));
        Assertions.assertThrows(RightsException.class, () -> deleteService.execute(request));
    }

    @Test
    public void testDeleteFunctionalIfNotFoundException() {
        var request = new DeleteAdminRequest(3, "458457hefhiu39adm");
        when(deleteService.execute(request)).thenThrow(new NotFoundException(Message.ADMIN_NOT_CREATED_MESSAGE));
        Assertions.assertThrows(NotFoundException.class, () -> deleteService.execute(request));
    }

    @Test
    public void testGetAdminsIfExist() {
        var request = new GetAllAdminsRequest("327efhf83473adm");
        var list = List.of(EntityCreator.getAdmin());
        when(getService.execute(request)).thenReturn(new GetAllAdminsResponse(list));

        var expected = new GetAllAdminsResponse(list);
        var actual = getService.execute(request);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetAdminsException() {
        var request = new GetAllAdminsRequest("327efhf834");
        when(getService.execute(request)).thenThrow(new RightsException(Message.ROOTS_NOT_ALLOWED_MESSAGE));
        Assertions.assertThrows(RightsException.class, () -> getService.execute(request));
    }

    @Test
    public void testSearchIfCorrect() {
        var request = new SearchAdminRequest("327efhf83473adm", 1);
        when(searchService.execute(request)).thenReturn(DTOCreator.getSearchAdminResponse());

        var expected = DTOCreator.getSearchAdminResponse();
        var actual = searchService.execute(request);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSearchAdminsNotFoundException() {
        var request = new SearchAdminRequest("327efhf83473adm", 1);
        when(searchService.execute(request)).thenThrow(new NotFoundException(Message.ADMIN_NOT_CREATED_MESSAGE));
        Assertions.assertThrows(NotFoundException.class, () -> searchService.execute(request));
    }


    @Test
    public void testUpdateIfCorrect() {
        var request = DTOCreator.getUpdateRequest();
        when(updateService.execute(request)).thenReturn(DTOCreator.getUpdateResponse());

        var expected = DTOCreator.getUpdateResponse();
        var actual = updateService.execute(request);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testUpdateAdminsNotFoundException() {
        var request = DTOCreator.getUpdateRequest();
        when(updateService.execute(request)).thenThrow(new NotFoundException(Message.ADMIN_NOT_CREATED_MESSAGE));
        Assertions.assertThrows(NotFoundException.class, () -> updateService.execute(request));
    }
}
