package com.nclab.jpa;

import com.nclab.jpa.dao.CarDAO;
import com.nclab.jpa.dao.OwnerDAO;
import com.nclab.jpa.entity.Car;
import com.nclab.jpa.entity.Owner;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Servlet extends HttpServlet {

    @EJB
    CarDAO carDAO;
    @EJB
    OwnerDAO ownerDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        List<Car> cars = carDAO.getAllCars();
        request.setAttribute("cars", cars);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long deletedId;
        long carId;
        long ownerId;
        try {
            deletedId = Long.parseLong(request.getParameter("deletedId"));
        } catch (NumberFormatException ex) {
            deletedId = -1;
        }
        try {
            carId = Long.parseLong(request.getParameter("carId"));
        } catch (NumberFormatException ex) {
            carId=-1;
        }
        try {
            ownerId = Long.parseLong(request.getParameter("ownerID"));
        } catch (NumberFormatException ex) {
            ownerId=-1;
        }



        if(request.getParameter("createorupdate")!=null) {
            Owner owner = null;
            if (ownerId != -1)
            owner = ownerDAO.getById(ownerId);
            Car car = new Car(
                    request.getParameter("mark"),
                    request.getParameter("model"),
                    request.getParameter("color"),
                    owner
            );
            if(carId!=-1) car.setId(carId);
            carDAO.saveOrUpdate(car);
        }



        if (request.getParameter("deleteCar")!=null&&deletedId!=-1) {
            Car delcar = carDAO.getById(deletedId);
            carDAO.delete(delcar);
        }

        doGet(request, response);
    }



}
