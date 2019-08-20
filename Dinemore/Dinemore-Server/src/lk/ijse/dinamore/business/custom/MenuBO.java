package lk.ijse.dinamore.business.custom;

import lk.ijse.dinamore.business.SuperBO;
import lk.ijse.dinemore.common.dto.MenuDTO;

import java.util.ArrayList;

public interface MenuBO extends SuperBO {

    public boolean saveMenu(MenuDTO menuDTO)throws Exception;

    public boolean updateMenu(MenuDTO menuDTO)throws Exception;

    public boolean deleteMenu(int id)throws Exception;

    public MenuDTO searchMenu(int id)throws Exception;

    public ArrayList<MenuDTO> getAllMenus()throws Exception;

    public ArrayList<String> getMenuNames()throws Exception;

    public MenuDTO searchNameMenu(String name)throws Exception;


}
