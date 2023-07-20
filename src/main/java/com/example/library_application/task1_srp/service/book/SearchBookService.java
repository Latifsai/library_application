//package com.example.library_application.task1_srp.service.book;
//
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//
//import java.util.List;
//
//@Component
//@Transactional
//public class SearchBookService {
//
//
//
////    @Value("${search.ordering.enabled}")
////    private boolean orderingEnabled;
////
////    @Value("${search.paging.enabled}")
////    private boolean pagingEnabled;
//
//
//    public SearchBookResponse execute(SearchBookRequest request) {
//
//        SearchBookRequestValidator validator = new SearchBookRequestValidator
//                (new SearchBookRequestFieldValidator(), new OrderingValidator(), new PagingValidator());
//        List<CoreError> errors = validator.validate(request);
//
//        if (!errors.isEmpty()) {
//            return new SearchBookResponse(errors);
//        }
//
//        var foundBooks = database.findByTitleAndAuthor(request.getTitle(), request.getAuthor());
//        return new SearchBookResponse(converterToBook(foundBooks));
//
//    }
//
//    private Book converterToBook(List<Book> books) {
//        if (!books.isEmpty()) {
//            for (Book book : books) {
//                return book;
//            }
//        }
//        throw new IllegalArgumentException("Book is not exist");
//    }
//
////    private List<Book> ordering (List<Book> books, Ordering ordering) {
////        if (orderingEnabled && ordering != null) {
////
////        } else {
////            return books;
////        }
////    }
//
////    private List<Book> paging (List<Book> books, Paging paging) {
////        if (pagingEnabled && paging != null) {
////        }else {
////           return books;
////        }
////    }
//}
