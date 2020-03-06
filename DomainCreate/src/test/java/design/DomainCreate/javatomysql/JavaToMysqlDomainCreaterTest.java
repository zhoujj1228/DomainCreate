package design.DomainCreate.javatomysql;

import static org.junit.Assert.*;

import org.junit.Test;

import design.DomainCreate.example.TestDomain;

public class JavaToMysqlDomainCreaterTest {

	@Test
	public void test() {
		TestDomain td = new TestDomain();
		new JavaToMysqlDomainCreater().create(td);
	}

}
