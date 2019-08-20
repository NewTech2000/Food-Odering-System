package lk.ijse.dinamore.startup;

import lk.ijse.dinamore.service.impl.*;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StartServer {
    public static void main(String[] args) {
        try{
            System.setProperty("java.rmi.server.hostname","localhost");
            Registry registry = LocateRegistry.createRegistry(8080);

            registry.bind("reciption",new ReciptionServiceImpl());
            registry.bind("menu",new MenuServiceImpl());
            registry.bind("chef",new ChefServiceImpl());
            registry.bind("delivery",new DeliveryServiceImpl());
            registry.bind("userAccount",new UserAccountServiceServiceImpl());
            registry.bind("placeorder",new OrderServiceImpl());
            registry.bind("customer",new CustomerServiceImpl());
            registry.bind("orderDel",new OrderDetailsServiceImpl());

            System.out.println("Server Has been Started");

        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        } catch (AccessException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
