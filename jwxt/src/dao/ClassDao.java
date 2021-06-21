package dao;

import java.util.List;

import entity.Class;

/**
 * �༶��DAO��ӿ�
 * @author RushMMC
 * @date 2021/06/21
 *
 */
public interface ClassDao {
	
    List<Class> queryAllClass();
    Class queryClassByClaNo(String no);
    boolean addClass(Class cla);
    boolean updateClass(Class cla);
	boolean deleteClassByClaNo(String no);
    
}
