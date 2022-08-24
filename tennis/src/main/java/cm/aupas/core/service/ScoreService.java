package cm.aupas.core.service;

import cm.aupas.core.HibernateUtil;
import cm.aupas.core.repository.ScoreRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ScoreService {
    private ScoreRepositoryImpl scoreRepository;
   public ScoreService(){
       scoreRepository=new ScoreRepositoryImpl();
   }

   public void  deleteScore(Long id){
       Session session=null;
       Transaction tx=null;
       try {
           session= HibernateUtil.getSessionFactory().getCurrentSession();
           tx=session.beginTransaction();
           scoreRepository.delete(id);
           tx.commit();

       } catch (Exception e){
           e.printStackTrace();
       } finally {
           if(session!=null){
               session.close();
           }
       }
   }

}
