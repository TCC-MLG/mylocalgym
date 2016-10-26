package br.com.gym.mylocalgym.repository.impl;

import br.com.gym.mylocalgym.configuration.HibernateUtil;
import br.com.gym.mylocalgym.entities.Cliente;
import br.com.gym.mylocalgym.repository.ClienteRepository;
import org.hibernate.Session;

/**
 * @author Matheus
 */
public class ClienteRepositoryImpl implements ClienteRepository {

    Session session;

    @Override
    public Boolean cadastrarCliente(Cliente cliente) {

        this.session = HibernateUtil.session();

        try {

            Integer id = (Integer) this.session.save(cliente);

            this.session.getTransaction().commit();
            this.session.close();

            return id != null;

        } catch (Exception e) {

            return false;
        }
    }

    @Override
    public boolean alterarCliente(Integer clienteId, Cliente cliente) {

        this.session = HibernateUtil.session();
        try {

            cliente.setId(clienteId);

            StringBuilder sql = new StringBuilder();

            sql.append(" UPDATE mylocalgym.cliente ")
                    .append(" SET nome = :nome, ")
                    .append(" apelido = :apelido, ")
                    .append(" telefone = :telefone, ")
                    .append(" estado = :estado, ")
                    .append(" cidade = :cidade, ")
                    .append(" endereco = :endereco, ")
                    .append(" senha = :senha ")
                    .append(" WHERE id = :id ");

            Integer updated = this.session.createSQLQuery(sql.toString())
                    .setParameter("nome", cliente.getNome())
                    .setParameter("apelido", cliente.getApelido())
                    .setParameter("telefone", cliente.getTelefone())
                    .setParameter("estado", cliente.getEstado())
                    .setParameter("cidade", cliente.getCidade())
                    .setParameter("endereco", cliente.getEndereco())
                    .setParameter("senha", cliente.getSenha())
                    .setParameter("id", cliente.getId())
                    .executeUpdate();

            this.session.getTransaction().commit();
            this.session.close();

            return updated > 0;
        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public Cliente buscarClientePorId(Integer clienteId) {

        this.session = HibernateUtil.session();

        try {
            Cliente cliente = (Cliente) this.session.createQuery("FROM Cliente c WHERE c.id = :id ")
                    .setParameter("id", clienteId)
                    .uniqueResult();

            return cliente;
        } catch (Exception e) {
        }
        return null;
    }

}
