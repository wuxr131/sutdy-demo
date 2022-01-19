package cn.wuxr.h2db.service;

import cn.wuxr.h2db.dao.StudentDao;
import cn.wuxr.h2db.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public List<Student> findAll(){
        return studentDao.findAll();
    }

}
