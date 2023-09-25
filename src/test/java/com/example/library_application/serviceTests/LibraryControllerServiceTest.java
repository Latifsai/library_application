package com.example.library_application.serviceTests;

import com.example.library_application.dto.readerBook.*;
import com.example.library_application.errors.Message;
import com.example.library_application.errors.exeptions.BookTakeException;
import com.example.library_application.errors.exeptions.NotFoundException;
import com.example.library_application.errors.exeptions.RightsException;
import com.example.library_application.generator.DTOCreator;
import com.example.library_application.generator.EntityCreator;
import com.example.library_application.service.library_controller.*;
import jakarta.validation.Validation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LibraryControllerServiceTest {

    @Mock
    private DeleteLibraryControllerServiceImp deleteService;

    @Mock
    private GetAllControllersServiceImp getService;

    @Mock
    private ReturnBookServiceImp returnService;

    @Mock
    private SearchLibraryControllerImp searchService;

    @Mock
    private TakeBookServiceImp takeService;

    @Test
    public void testDeleteServiceIfCorrect() {
        var request = new DeleteAndSearchControllerRequest("34736435adm", 1);
        when(deleteService.execute(request)).thenReturn(new DeleteControllerResponse(1));

        var expected = new DeleteControllerResponse(1);
        var actual = deleteService.execute(request);
        assertEquals(expected, actual);
    }

    @Test
    public void testDeleteServiceIfNotFoundException() {
        var request = new DeleteAndSearchControllerRequest("34736435adm", 5);
        when(deleteService.execute(request)).thenThrow(new NotFoundException(Message.LIBRARY_CONTROLLER_NOT_FOUND_MESSAGE));
        assertThrows(NotFoundException.class, () -> deleteService.execute(request));
    }

    @Test
    public void testGetServiceIfCorrect() {
        var request = new GetLibraryControllerRequest("34736435adm");
        when(getService.execute(request)).thenReturn(new GetAllLibraryControllersResponse(List.of(EntityCreator.getLibraryController())));

        var expected = new GetAllLibraryControllersResponse(List.of(EntityCreator.getLibraryController()));
        var actual = getService.execute(request);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetServiceIfNotFoundException() {
        var request = new GetLibraryControllerRequest("34736435adm");
        when(getService.execute(request)).thenThrow(new RightsException(Message.ROOTS_NOT_ALLOWED_MESSAGE));
        assertThrows(RightsException.class, () -> getService.execute(request));
    }

    @Test
    public void testReturnServiceIfCorrect() {
        var request = new TakeAndReturnBookDTORequest("3473643", "Lolita");
        when(returnService.execute(request)).thenReturn(new ReturnBookDTOResponse("Lolita",
                "Oleg", "Legov", LocalDateTime.of(2022, 12, 30, 15, 12, 32)));

        var expected = new ReturnBookDTOResponse("Lolita",
                "Oleg", "Legov", LocalDateTime.of(2022, 12, 30, 15, 12, 32));
        var actual = returnService.execute(request);
        assertEquals(expected, actual);
    }

    @Test
    public void testReturnServiceIfNotFoundException() {
        var request = new TakeAndReturnBookDTORequest("43445453", "King");
        when(returnService.execute(request)).thenThrow(new NotFoundException(Message.BOOK_NOT_FOUND_MESSAGE));
        assertThrows(NotFoundException.class, () -> returnService.execute(request));
    }


    @Test
    public void testSearchServiceIfCorrect() {
        var request = new DeleteAndSearchControllerRequest("34736435adm", 1);
        when(searchService.execute(request)).thenReturn(DTOCreator.getSearchControllerResponse());

        var expected = DTOCreator.getSearchControllerResponse();
        var actual = searchService.execute(request);
        assertEquals(expected, actual);
    }

    @Test
    public void testSearchServiceIfNotFoundException() {
        var request = new DeleteAndSearchControllerRequest("34736435adm", 5);
        when(searchService.execute(request)).thenThrow(new NotFoundException(Message.LIBRARY_CONTROLLER_NOT_RETURNED_MESSAGE));
        assertThrows(NotFoundException.class, () -> searchService.execute(request));
    }

    @Test
    public void testTakeBookServiceIfCorrect() {
        var request = new TakeAndReturnBookDTORequest("34736435", "Lolita");
        when(takeService.execute(request)).thenReturn(new TakeBookDTOResponse("Lolita", "Oleg",
                "Legov", LocalDateTime.of(2021, 12, 13, 17, 43, 45)));

        var expected = new TakeBookDTOResponse("Lolita", "Oleg",
                "Legov", LocalDateTime.of(2021, 12, 13, 17, 43, 45));
        var actual = takeService.execute(request);
        assertEquals(expected, actual);
    }

    @Test
    public void testTakeBookServiceIfNotFoundException() {
        var request = new TakeAndReturnBookDTORequest("34736435", "Lhdgfd");
        when(takeService.execute(request)).thenThrow(new BookTakeException(Message.BOOK_NOT_RETURNED_MESSAGE));
        assertThrows(BookTakeException.class, () -> takeService.execute(request));
    }

    @Test
    public void testTakeBookServiceIfValidation() {
        var request = new TakeAndReturnBookDTORequest("34736435", "");

        var validator = Validation.buildDefaultValidatorFactory().getValidator();
        var set = validator.validate(request);
        assertEquals(2, set.size());

    }
}