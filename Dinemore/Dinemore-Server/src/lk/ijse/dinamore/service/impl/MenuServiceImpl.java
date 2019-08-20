package lk.ijse.dinamore.service.impl;

import lk.ijse.dinamore.business.custom.MenuBO;
import lk.ijse.dinamore.business.custom.impl.MenuBOImpl;
import lk.ijse.dinemore.common.dto.MenuDTO;
import lk.ijse.dinemore.common.service.custom.MenuService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class MenuServiceImpl extends UnicastRemoteObject implements MenuService {

    public MenuBO menuBO;

    public MenuServiceImpl()throws RemoteException {
        menuBO = new MenuBOImpl();
    }

    @Override
    public boolean saveMenu(MenuDTO menuDTO) throws Exception {
        return menuBO.saveMenu(menuDTO);
    }

    @Override
    public boolean updateMenu(MenuDTO menuDTO) throws Exception {
        return menuBO.updateMenu(menuDTO);
    }

    @Override
    public boolean deleteMenu(int id) throws Exception {
        return menuBO.deleteMenu(id);
    }

    @Override
    public MenuDTO searchMenu(int id) throws Exception {
        return menuBO.searchMenu(id);
    }

    @Override
    public ArrayList<MenuDTO> getAllMenus() throws Exception {
        return menuBO.getAllMenus();
    }

    @Override
    public ArrayList <String> getMenuNames() throws Exception {
        return menuBO.getMenuNames();
    }

    @Override
    public MenuDTO searchMenuName(String name) throws Exception {
        return menuBO.searchNameMenu(name);
    }
}
