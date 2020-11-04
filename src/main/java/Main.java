import lombok.extern.slf4j.Slf4j;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

@Slf4j
public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) {
        final Session session = getSession();
        try {
            log.info("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                log.info("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    log.info("  " + o);
                }
            }
        } catch(QueryException e) {
            log.error("Query Error", e);
        }
        catch(SessionException e) {
            log.error("Session Error", e);
        }
        finally {
            session.close();
        }
    }
}