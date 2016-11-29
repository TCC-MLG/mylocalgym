package br.com.gym.mylocalgym.repository.impl;

import br.com.gym.mylocalgym.configuration.HibernateUtil;
import br.com.gym.mylocalgym.entities.Cliente;
import br.com.gym.mylocalgym.repository.ClienteRepository;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;
import org.hibernate.Query;
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
            
            cliente.setId(id);

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

            sql.append(" UPDATE mylocalgym.cliente ");
            sql.append(" SET nome = :nome ");
            sql.append(" , apelido = :apelido ");
            sql.append(" , telefone = :telefone ");
            sql.append(" , estado = :estado ");
            sql.append(" , cidade = :cidade ");
            sql.append(" , endereco = :endereco ");

            if (cliente.getSenha() != null) {
                sql.append(" , senha = :senha ");
            }

            if (cliente.getExameMedico() != null) {
                sql.append(" , exame_medico = :exame ");
            }

            if (cliente.getFoto() != null) {
                sql.append(" , foto = :foto ");
            }

            sql.append(" WHERE id = :id ");

            Query hql = this.session.createSQLQuery(sql.toString());

            hql.setParameter("nome", cliente.getNome());
            hql.setParameter("apelido", cliente.getApelido());
            hql.setParameter("telefone", cliente.getTelefone());
            hql.setParameter("estado", cliente.getEstado());
            hql.setParameter("cidade", cliente.getCidade());
            hql.setParameter("endereco", cliente.getEndereco());

            if (cliente.getSenha() != null) {
                hql.setParameter("senha", cliente.getSenha());
            }

            if (cliente.getExameMedico() != null) {
                hql.setBinary("exame", cliente.getExameMedico());
            }

            if (cliente.getFoto() != null) {
                hql.setBinary("foto", cliente.getFoto());
            }

            hql.setParameter("id", cliente.getId());

            Integer updated = hql.executeUpdate();

            this.session.getTransaction().commit();
            this.session.close();

            return updated > 0;
        } catch (Exception e) {
            printStackTrace(e);
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

            this.session.getTransaction().commit();
            this.session.close();

            return cliente;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public boolean atualizarExame(Integer clienteId, Cliente cliente) {

        Integer result = 0;

        if (clienteId != null && cliente != null) {
            try {
                this.session = HibernateUtil.session();

                this.session.update(cliente);

                this.session.getTransaction().commit();
                this.session.close();
                
                result = 1;
            } catch (Exception e) {

            }
        }

        return result > 0;
    }

    @Override
    public byte[] buscarExame(Integer clienteId) {

        Cliente cliente = null;
        if (clienteId != null) {
            try {
                this.session = HibernateUtil.session();

                cliente = (Cliente) this.session.createQuery("FROM Cliente c where c.id = :clienteId")
                        .setParameter("clienteId", clienteId)
                        .uniqueResult();

                this.session.getTransaction().commit();
                this.session.close();
            } catch (Exception e) {

            }
        }

        return cliente != null ? cliente.getExameMedico() : null;
    }

    public byte[] stringToByteArray(String array) {

        byte[] bytes = array.getBytes();
        return bytes;
    }

    public String byteArrayToString(byte[] bs) {

        String s = new String(bs);
        return s;
    }

}
