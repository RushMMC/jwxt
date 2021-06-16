package dao;

import java.util.List;

import entity.Class;

public interface ClassDao {
	
    List<Class> queryAllClass();
    Class queryClassByClaNo(String no);
    boolean addClass(Class cla);
    boolean updateClass(Class cla);
	boolean deleteClassByClaNo(String no);
    
}
