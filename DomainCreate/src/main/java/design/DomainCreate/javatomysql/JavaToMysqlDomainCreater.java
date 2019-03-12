package design.DomainCreate.javatomysql;


import java.io.File;
import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Spliterator;

import javax.swing.JToolBar.Separator;

import org.junit.Test;

import design.DomainCreate.domain.AutoIncrement;
import design.DomainCreate.domain.Length;
import design.DomainCreate.domain.MappingDomain;
import design.DomainCreate.domain.MappingFieldDomain;
import design.DomainCreate.domain.NotNull;
import design.DomainCreate.domain.PrimaryKey;
import design.DomainCreate.javatomysql.createdomain.TestDomain;
import design.DomainCreate.util.FileUtil;
import design.DomainCreate.util.MappingUtil;
import design.DomainCreate.util.PathUtil;
import design.DomainCreate.util.StringUtil;

public class JavaToMysqlDomainCreater {
	HashMap<String, String> javatypeMysqltypeMap = new HashMap<String, String>();
	@Test
	public void test() throws Exception {
		TestDomain td = new TestDomain();
		create(td);
	}
	
	public void create(Object obj){
		init();
		call(obj);
	}

	private void call(Object obj) {
		MappingDomain md = createMappingDomainByObj(obj);
		createMysqlTableDql(md);
		
		
	}

	private void createMysqlTableDql(MappingDomain md) {
		File file = new File(PathUtil.getProjectPath() + "/template/mysql_createtable_template.txt");
		String template = FileUtil.readByFileWithEncodingWithLineBreak(file, "UTF-8");
		String tableName = md.getMysqlTableName();
		String tableFileds = createTableFieldsStr(md.getFieldList());
		String createTableSql = MessageFormat.format(template, tableName, tableFileds);
		System.out.println(createTableSql);
	}

	private String createTableFieldsStr(List<MappingFieldDomain> fieldList) {
		StringBuilder sb = new StringBuilder();
		String off = "    ";
		for(int i = 0; i < fieldList.size(); i++){
			MappingFieldDomain mfd = fieldList.get(i);
			String mysqlName = mfd.getMysqlName();
			sb.append(off + mysqlName + " ");
			
			String mysqlType = mfd.getMysqlType();
			String mysqlLength = mfd.getMysqlLength();
			
			if(isNeedLength(mysqlType) && mysqlLength != null){
				sb.append(mysqlType + "(" + mysqlLength + ") ");
				
			}else{
				sb.append(mysqlType + " ");
			}
			
			if(mfd.isMysqlNotNull()){
				sb.append("NOT NULL ");
			}
			if(mfd.isMysqlPrimaryKey()){
				sb.append("PRIMARY KEY ");
			}
			if(mfd.isMysqlAutoIncrement()){
				sb.append("AUTO_INCREMENT ");
			}
			if(i != fieldList.size() - 1){
				sb.append(",\n");
			}
			
		}
		return sb.toString();
	}

	private boolean isNeedLength(String mysqlType) {
		if(mysqlType.equals("VARCHAR")){
			return true;
		}
		if(mysqlType.equals("DOUBLE")){
			return true;
		}
		if(mysqlType.equals("FLOAT")){
			return true;
		}
		if(mysqlType.equals("INT")){
			return true;
		}
		return false;
	}

	private MappingDomain createMappingDomainByObj(Object obj) {
		String javaClassName = obj.getClass().getSimpleName();
		String mysqlTableName = StringUtil.changeCamelStrToDBStr(javaClassName);
		MappingDomain md = new MappingDomain();
		md.setJavaClassName(javaClassName);
		md.setMysqlTableName(mysqlTableName);

		Field[] fields = obj.getClass().getDeclaredFields();
		
		for (int i = 0; i < fields.length; i++) {
			MappingFieldDomain mfd = createMappingFieldDomainByField(fields[i]);
			md.getFieldList().add(mfd);
		}
		return md;
		
	}

	private MappingFieldDomain createMappingFieldDomainByField(Field field) {
		String javaName = field.getName();
		String javaType = field.getType().getSimpleName();
		String length = null;
		Length lengthAnnotation = field.getAnnotation(Length.class);
		if(lengthAnnotation != null){
			length = lengthAnnotation.value();
		}
		String mysqlName = StringUtil.changeCamelStrToDBStr(javaName);
		String mysqlType = MappingUtil.changeJavaTypeToMysqlType(javaType);
		String mysqlLength = length;
		MappingFieldDomain mfd = new MappingFieldDomain(javaName, javaType, length, mysqlName, mysqlType, mysqlLength);
		
		NotNull notNullAnnotation = field.getAnnotation(NotNull.class);
		PrimaryKey primaryKeyAnnotation = field.getAnnotation(PrimaryKey.class);
		AutoIncrement autoIncrementAnnotation = field.getAnnotation(AutoIncrement.class);
		if(notNullAnnotation != null){
			mfd.setMysqlNotNull(true);
		}
		if(primaryKeyAnnotation != null){
			mfd.setMysqlPrimaryKey(true);
		}
		if(autoIncrementAnnotation != null){
			mfd.setMysqlAutoIncrement(true);
		}
		
		return mfd;
	}

	private void init() {
		
	}
}
