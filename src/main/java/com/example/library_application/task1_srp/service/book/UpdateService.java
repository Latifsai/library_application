package com.example.library_application.task1_srp.service.book;

import com.example.library_application.task1_srp.dto.book.UpdateBookDTORequest;
import com.example.library_application.task1_srp.dto.book.UpdateBookDTOResponse;
import org.springframework.stereotype.Service;

@Service
public interface UpdateService {
    UpdateBookDTOResponse execute(UpdateBookDTORequest request);
}
