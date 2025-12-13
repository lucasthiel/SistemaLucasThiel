package dao;

import bean.LltProduto;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class ProdutosDAO extends AbstractDAO {

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
        Criteria criteria = session.createCriteria(LltProduto.class);
        criteria.add(Restrictions.eq("lltIdProduto", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    // Buscar por nome
    public Object listNome(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(LltProduto.class);
        criteria.add(Restrictions.like("lltNomeProduto", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    // Buscar por preço (valor)
    public Object listValor(double valor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(LltProduto.class);
        criteria.add(Restrictions.ge("lltPreco", valor));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    // Buscar por nome E preço
    public Object listNomeValor(String nome, double valor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(LltProduto.class);
        criteria.add(Restrictions.like("lltNomeProduto", "%" + nome + "%"));
        criteria.add(Restrictions.ge("lltPreco", valor));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(LltProduto.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public static void main(String[] args) {
        ProdutosDAO produtosDAO = new ProdutosDAO();
        produtosDAO.listAll();
    }
}
