package lk.ijse.dinemore.common.service.custom;

import lk.ijse.dinemore.common.dto.MenuDTO;

import java.rmi.Remote;
import java.util.ArrayList;

public interface MenuService extends Remote {

    public boolean saveMenu(MenuDTO menuDTO)throws Exception;

    public boolean updateMenu(MenuDTO menuDTO)throws Exception;

    public boolean deleteMenu(int id)throws Exception;

    public MenuDTO searchMenu(int name)throws Exception;

    public ArrayList<MenuDTO> getAllMenus()throws Exception;

    public ArrayList<String> getMenuNames() throws Exception;

    public MenuDTO searchMenuName(String name)throws Exception;
}
