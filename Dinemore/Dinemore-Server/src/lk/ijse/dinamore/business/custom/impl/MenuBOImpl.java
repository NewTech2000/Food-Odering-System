package lk.ijse.dinamore.business.custom.impl;

import lk.ijse.dinamore.business.custom.MenuBO;
import lk.ijse.dinamore.dao.custom.MenuDAO;
import lk.ijse.dinamore.dao.custom.impl.MenuDAOImpl;
import lk.ijse.dinamore.entity.Menu;
import lk.ijse.dinamore.util.HibernateUtil;
import lk.ijse.dinemore.common.dto.MenuDTO;
import lk.ijse.dinemore.common.service.custom.MenuService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MenuBOImpl implements MenuBO {

    private SessionFactory sessionFactory;

    private MenuDAO menuDAO;
    public  MenuBOImpl(){
        menuDAO=new MenuDAOImpl();
        sessionFactory= HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean saveMenu(MenuDTO menuDTO) throws Exception {
        return menuDAO.Save(new Menu(menuDTO.getFood_id(),menuDTO.getFoodName(),menuDTO.getCategory(),menuDTO.getUnitprice()));
    }

    @Override
    public boolean updateMenu(MenuDTO menuDTO) throws Exception {
        return menuDAO.Update(new Menu(menuDTO.getFood_id(),menuDTO.getFoodName(),menuDTO.getCategory(),menuDTO.getUnitprice()));
    }

    @Override
    public boolean deleteMenu(int id) throws Exception {
      return menuDAO.delete(id);
    }

    @Override
    public MenuDTO searchMenu(int id) throws Exception {
        Menu menu = menuDAO.Search(id);
        if(menu!=null){
            return new MenuDTO(menu.getId(),menu.getFoodName(),menu.getCategory(),menu.getUnitprice());
        }
        return null;
    }

    @Override
    public ArrayList<MenuDTO> getAllMenus() throws Exception {
        List<Menu> menus = menuDAO.getAll();
        ArrayList<MenuDTO> menuDTOS = new ArrayList <>();
        for (Menu menu : menus){
            menuDTOS.add(new MenuDTO(menu.getId(),menu.getFoodName(),menu.getCategory(),menu.getUnitprice()));
        }
        return menuDTOS;
    }

    @Override
    public ArrayList <String> getMenuNames() throws Exception {
        List<Menu> menus = menuDAO.getAll();
        ArrayList<String> ids = new ArrayList <>();
        for (Menu menu : menus){
            ids.add(menu.getFoodName());
        }
        return ids;
    }

    @Override
    public MenuDTO searchNameMenu(String name) throws Exception {
       Menu menu = menuDAO.searchByName(name);
       if(menu!=null){
           return new MenuDTO(menu.getId(),menu.getFoodName(),menu.getCategory(),menu.getUnitprice());

       }
       return null;

    }
}
