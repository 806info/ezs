package com.gpt806.ezs.config;

import com.baomidou.mybatisplus.annotation.FieldFill;


import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.gpt806.ezs.base.BaseEntity;

import java.sql.Types;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MpGenerator {
    public static void main(String[] args) {
        // 获取项目根目录路径
        String projectPath = System.getProperty("user.dir");

        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3310/ezs?useSSL=false&useUnicode=true&characterEncoding=utf-8", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("Herb") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(projectPath + "/src/main/java"); // 指定输出目录
                })
                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                    if (typeCode == Types.SMALLINT) {
                        // 自定义类型转换
                        return DbColumnType.INTEGER;
                    }
                    return typeRegistry.getColumnType(metaInfo);
                }))
                .packageConfig(builder -> {
                    builder.parent("com.gpt806") // 设置父包名
                            .moduleName("ezs") // 设置父包模块名
                            .mapper("dao.sys")
                            .entity("entity.sys") // 设置实体类包名
                            .service("service.sys") // 设置Service接口包名
                            .serviceImpl("service.impl.sys") // 设置Service实现类包名
                            .controller("controller.sys") // 设置Controller类的包名为controller.sys
                            .pathInfo(Collections.singletonMap(OutputFile.xml, projectPath + "/src/main/resources/mapper/sys")); // 设置mapperXml生成路径
                })
                
                .strategyConfig(builder -> {
                    builder.addInclude("s_sys_permission","s_sys_role","s_sys_role_permission","s_sys_user","s_sys_user_role") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_", "s_")
                            .entityBuilder()
                            .enableTableFieldAnnotation()
                            .enableLombok()
                            .naming(NamingStrategy.underline_to_camel)
                            .columnNaming(NamingStrategy.underline_to_camel)
                            .superClass(BaseEntity.class)
                            .addSuperEntityColumns("id","create_by","create_time","update_by","update_time","uid","is_delete")
                            .logicDeleteColumnName("is_delete")
                            .mapperBuilder()
                            .enableMapperAnnotation()
                            .formatMapperFileName("%sDao")

                    ; // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
