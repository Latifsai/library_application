package com.example.library_application.serviceTests;

import com.example.library_application.dto.book.*;
import com.example.library_application.errors.Message;
import com.example.library_application.errors.exeptions.NotFoundException;
import com.example.library_application.errors.exeptions.RightsException;
import com.example.library_application.generator.DTOCreator;
import com.example.library_application.generator.EntityCreator;
import com.example.library_application.service.book.*;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    AddBookServiceImp addService;
    @Mock
    FindBookServiceImp findService;
    @Mock
    GetAllBookService getService;
    @Mock
    RemoveBookServiceImp removeService;
    @Mock
    UpdateBookServiceImp updateService;
    private Validator validator;

    @Test
    public void testAddBookFunctional() {
        var request = DTOCreator.getAddBookRequest();
        when(addService.execute(request)).thenReturn(new BookResponse(1, "Lisa", "Alexand Pushkin"));

        var expected = new BookResponse(1, "Lisa", "Alexand Pushkin");
        var actual = addService.execute(request);

        assertEquals(expected, actual);
    }

    @Test
    public void testAddBookFunctionalRightsException() {
        var request = DTOCreator.getAddBookRequestRightsException();
        when(addService.execute(request)).thenThrow(new RightsException(Message.ROOTS_NOT_ALLOWED_MESSAGE));

        assertThrows(RightsException.class, () -> addService.execute(request));
    }

    @Test
    public void testAddBookValidation() {
        var request = DTOCreator.getAddBookRequestValidation();
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        var set = validator.validate(request);

        assertEquals(2, set.size());
    }

    @Test
    public void testFindBookFunctional() {
        var request = new BookDTORequest("13434adf31", "Lisa", "Alexandr Pushkin");
        when(findService.execute(request)).thenReturn(new BookResponse(1, "Lisa", "Alexand Pushkin"));

        var expected = new BookResponse(1, "Lisa", "Alexand Pushkin");
        var actual = findService.execute(request);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindBookFunctionalNotFoundException() {
        var request = new BookDTORequest("13434adf31", "Kiska", "Alex Lin");

        when(findService.execute(request)).thenThrow(new NotFoundException(Message.BOOK_NOT_FOUND_MESSAGE));

        assertThrows(NotFoundException.class, () -> findService.execute(request));
    }

    @Test
    public void testGetAllBookFunctional() {
        when(getService.execute()).thenReturn(new GetAllBooksResponse(List.of(EntityCreator.getBook())));

        var expected = new GetAllBooksResponse(List.of(EntityCreator.getBook()));
        var actual = getService.execute();

        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveBookFunctional() {
        var request = new BookDTORequest("13434adf31", "Lisa", "Alexandr Pushkin");
        when(removeService.execute(request)).thenReturn(new DeleteBookResponse(1, "Lisa"));

        var expected = new DeleteBookResponse(1, "Lisa");
        var actual = removeService.execute(request);

        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveBookFunctionalNotFoundException() {
        var request = new BookDTORequest("13434adf31", "Kiska", "Alex Lin");

        when(removeService.execute(request)).thenThrow(new NotFoundException(Message.BOOK_NOT_FOUND_MESSAGE));

        assertThrows(NotFoundException.class, () -> removeService.execute(request));
    }

    @Test
    public void testUpdateBookFunctional() {
        var request = new UpdateBookDTORequest("13434adf31adm", "Lisa", 230, "Poem about love and peoples");
        when(updateService.execute(request)).thenReturn(new UpdateBookDTOResponse("Lisa", 230, "Poem about love and peoples"));

        var expected = new UpdateBookDTOResponse("Lisa", 230, "Poem about love and peoples");
        var actual = updateService.execute(request);

        assertEquals(expected, actual);
    }

    @Test
    public void testUpdateBookFunctionalNotFoundException() {
        var request = new UpdateBookDTORequest("13434adf31adm", "Love", 230, "Poem about love and peoples");


        when(updateService.execute(request)).thenThrow(new NotFoundException(Message.BOOK_NOT_FOUND_MESSAGE));

        assertThrows(NotFoundException.class, () -> updateService.execute(request));
    }

}
