package design.domaincreate.javatomysql;


import java.io.File;
import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;

import design.domaincreate.javatomysql.domain.MappingDomain;
import design.domaincreate.javatomysql.domain.MappingFieldDomain;
import design.domaincreate.javatomysql.domain.annotation.AutoIncrement;
import design.domaincreate.javatomysql.domain.annotation.Length;
import design.domaincreate.javatomysql.domain.annotation.NotNull;
import design.domaincreate.javatomysql.domain.annotation.PrimaryKey;
import design.util.FileUtil;
import design.util.MappingUtil;
import design.util.PathUtil;
import design.util.StringUtil;

public class JavaToMysqlDomainCreater {
	HashMap<String, String> javatypeMysqltypeMap = new HashMap<String, String>();

	public String create(Object obj) {
		MappingDomain md = createMappingDomainByObj(obj);
		String createMysqlTableDql = createMysqlTableDql(md);
		return createMysqlTableDql;
		
	}

	private String createMysqlTableDql(MappingDomain md) {
		File file = new File(PathUtil.getProjectPath() + "/template/mysql_createtable_template.txt");
		String template = FileUtil.readByFileWithEncodingWithLineBreak(file, "UTF-8");
		String tableName = md.getMysqlTableName();
		String tableFileds = createTableFieldsStr(md.getFieldList());
		String createTableSql = MessageFormat.format(template, tableName, tableFileds);
		return createTableSql;
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
}
