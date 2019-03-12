package design.DomainCreate.domain;

import java.util.LinkedList;
import java.util.List;

public class MappingDomain {
	String javaClassName;
	String mysqlTableName;
	List<MappingFieldDomain> fieldList = new LinkedList<>();
	public String getJavaClassName() {
		return javaClassName;
	}
	public void setJavaClassName(String javaClassName) {
		this.javaClassName = javaClassName;
	}
	public String getMysqlTableName() {
		return mysqlTableName;
	}
	public void setMysqlTableName(String mysqlTableName) {
		this.mysqlTableName = mysqlTableName;
	}
	public List<MappingFieldDomain> getFieldList() {
		return fieldList;
	}
	public void setFieldList(List<MappingFieldDomain> fieldList) {
		this.fieldList = fieldList;
	}
}
