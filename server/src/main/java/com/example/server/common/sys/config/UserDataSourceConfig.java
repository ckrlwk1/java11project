package com.example.server.common.sys.config;
import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class UserDataSourceConfig {

	@Bean(destroyMethod="")
	@ConfigurationProperties(prefix="spring.db1.datasource")
	public DataSource dataSource() throws Exception {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}
//	@Bean
//    @ConfigurationProperties(prefix = "spring.datasource.hikari")
//    public HikariConfig hikariConfig() {
//        return new HikariConfig();
//    }
	
//	@Primary
//	@Bean
//	public DataSourceTransactionManager transactionManager() throws Exception {
//		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
//		transactionManager.setDataSource(dataSource());
//		return transactionManager;
//	}	
//	
//	@Primary
//	@SuppressWarnings("deprecation")
//	@Bean
//	public TransactionInterceptor transactionAdvice()throws Exception {
//		NameMatchTransactionAttributeSource txAttributeSource = new NameMatchTransactionAttributeSource();
//		RuleBasedTransactionAttribute txAttribute = new RuleBasedTransactionAttribute();
//		
//		txAttribute.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
//		txAttribute.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
//		
//		HashMap<String, TransactionAttribute> txMethods = new HashMap<String, TransactionAttribute>();
//		txMethods.put("*", txAttribute);
//		txAttributeSource.setNameMap(txMethods);
//
//		return new TransactionInterceptor(transactionManager(), txAttributeSource);		
//	}
//
//	@Primary
//	@Bean
//	public Advisor transactionAdvisor()throws Exception {
//		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
//		pointcut.setExpression("execution(* com.skt.tx..*Controller.*(..))");
//		return new DefaultPointcutAdvisor(pointcut, transactionAdvice());
//	}
	
}
