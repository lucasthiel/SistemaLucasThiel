package dao;

import bean.LltCliente;
import bean.LltUsuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class ClientesDAO extends AbstractDAO {

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
        Criteria criteria = session.createCriteria(LltCliente.class);
        criteria.add(Restrictions.eq("lltIdCliente", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(LltCliente.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listNome(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(LltCliente.class);
        criteria.add(Restrictions.like("lltNome", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listCpf(String cpf) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(LltCliente.class);
        criteria.add(Restrictions.like("lltCpf", "%" + cpf + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listNomeCpf(String nome, String cpf) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(LltCliente.class);
        criteria.add(Restrictions.like("lltNome", "%" + nome + "%"));
        criteria.add(Restrictions.like("lltCpf", "%" + cpf + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public static void main(String[] args) {
        ClientesDAO clientesDAO = new ClientesDAO();
        clientesDAO.listAll();
        System.out.println("teste ok");
    }
}
