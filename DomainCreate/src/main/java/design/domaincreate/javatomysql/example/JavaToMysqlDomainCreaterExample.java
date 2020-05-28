package design.domaincreate.javatomysql.example;

import design.domaincreate.javatomysql.JavaToMysqlDomainCreater;

public class JavaToMysqlDomainCreaterExample {
	public static void main(String[] args) {
		TestDomain td = new TestDomain();
		String create = new JavaToMysqlDomainCreater().create(td);
		System.out.println(create);
	}
}
