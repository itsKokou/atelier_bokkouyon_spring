package ism.spring.services.impl;

import ism.spring.data.entities.Course;
import ism.spring.data.repositories.CourseRepository;
import ism.spring.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }
}
