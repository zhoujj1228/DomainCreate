package design.DomainCreate.javatomysql.example;

import design.DomainCreate.javatomysql.JavaToMysqlDomainCreater;

public class JavaToMysqlDomainCreaterExample {
	public static void main(String[] args) {
		TestDomain td = new TestDomain();
		String create = new JavaToMysqlDomainCreater().create(td);
		System.out.println(create);
	}
}
