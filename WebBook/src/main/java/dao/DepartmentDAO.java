package dao;

import generalClass.Department;

import java.util.List;

public interface DepartmentDAO {
    boolean insertDepartment(Department department)throws Exception;

    boolean updateDepartment(Department department)throws Exception;

    Department selectDepartmentByName(String name) throws Exception;

    List<Department> selectDepartmentByManager(String manager) throws Exception;
}
