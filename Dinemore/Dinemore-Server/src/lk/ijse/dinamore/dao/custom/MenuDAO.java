package lk.ijse.dinamore.dao.custom;

import lk.ijse.dinamore.dao.CrudDAO;
import lk.ijse.dinamore.entity.Menu;

public interface MenuDAO extends CrudDAO<Menu , Integer> {
    public Menu searchByName(String name)throws Exception;
}
