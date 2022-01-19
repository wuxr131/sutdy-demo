package cn.wuxr.h2db.dao;

import cn.wuxr.h2db.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, Integer> {

}
