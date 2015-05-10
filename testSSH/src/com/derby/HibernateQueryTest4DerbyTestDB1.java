package com.derby;

import com.derby.pojo.FactoryEntity;
import com.derby.pojo.WorkerEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;

/**
 * Created by applec on 15/5/10.
 */
public class HibernateQueryTest4DerbyTestDB1 {
	public static void main(String[] args) {
		//第一步:读取Hibernate的配置文件  hibernamte.cfg.xml文件
		Configuration con=new Configuration().configure("./hibernate.cfg.xml");
		//第二步:创建服务注册构建器对象，通过配置对象中加载所有的配置信息
		ServiceRegistryBuilder regbulider=new ServiceRegistryBuilder().applySettings(con.getProperties());
		//创建注册服务
		ServiceRegistry reg=regbulider.buildServiceRegistry();
		//第三步:创建会话工厂
		SessionFactory sessionFactory=con.buildSessionFactory(reg);


		Session session = sessionFactory.openSession();
//		session.beginTransaction();

		Criteria criteria = session.createCriteria(FactoryEntity.class);
		criteria.add(Restrictions.like("name", "Webster%"));
		criteria.setMaxResults(10);
		List<FactoryEntity> factoryEntityList = criteria.list();
		for (FactoryEntity factoryEntity : factoryEntityList){
			System.out.println("------------ List results --------------");
			System.out.println(factoryEntity.getName());
			System.out.println("------------ List results end-----------");

			for (WorkerEntity workerEntity : factoryEntity.getWorkers()){
				System.out.println("------------ List results --------------");
				System.out.println("       " + workerEntity.getName());
				System.out.println("------------ List results end-----------");
			}
		}

	}
}
