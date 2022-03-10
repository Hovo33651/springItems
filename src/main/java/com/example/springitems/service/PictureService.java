package com.example.springitems.service;

import com.example.springitems.repository.EmployeeRepository;
import com.example.springitems.repository.PictureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PictureService {

    private final PictureRepository pictureRepository;


}
