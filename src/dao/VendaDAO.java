/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.LltUsuario;
import bean.LltVenda;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u1845853
 */
public class VendaDAO extends AbstractDAO {

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Object list(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(LltVenda.class);
        criteria.add(Restrictions.eq("idvenda", codigo) );
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(LltVenda.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object listVendedor(String vendedor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(LltVenda.class, "v");
        criteria.createAlias("v.lltVendedor", "u");
        criteria.add(Restrictions.like("u.lltNome", vendedor, MatchMode.ANYWHERE));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }



    public Object listCliente(String cliente) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(LltVenda.class, "v");
        criteria.createAlias("v.lltCliente", "c");
        criteria.add(Restrictions.like("c.lltNome", cliente, MatchMode.ANYWHERE));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }


    public Object listVendedorCliente(String cliente, String vendedor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(LltVenda.class);
        criteria.add(Restrictions.like("u.lltNome", vendedor, MatchMode.ANYWHERE));
        criteria.add(Restrictions.like("c.lltNome", cliente, MatchMode.ANYWHERE));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public static void main(String[] args) {
        VendaDAO usuariosDAO = new VendaDAO();
        usuariosDAO.listAll();
        System.out.println("teste ok");
    }
}
