package com.kunyao.jvm.jvm_classloader;

/**
 * @ClassName: ClassStructureAnalyze
 * @Author: kunyao
 * @Description: Class文件结构分析
 * @Date: 2020/5/29 9:49
 * @Version: 1.0
 */
public class ClassStructureAnalyze {

    private int m;

    public int inc(){
        return m + 1;
    }

    /**
     *
     *
     * * 每个Class文件的头4个字节被称为魔数,Class文件的魔数值为：0xCAFEBABE
     * * 第5和第6个字节是次版本号（Minor Version）： 0x0000
     * * 第7和第8个字节是主版本号（Major Version）： 0x0034（java8）
     * * 常量池的入口放置一项u2类型的数据，代表常量池容量计数值（constant_pool_count） 0x0016（22）代表常量池中有21项常量
     * * 常量池的第一项常量，标志位是0x0A（10）对应着CONSTANT_Methodref_info
     *   0x0004 指向常量池中一个CONSTANT_Class_info类型
     *   0x0012 指向常量池中一个CONSTANT_NameAndType_info类型
     *   0x09 常量池中的第二个常量，对应着CONSTANT_Fieldref_info
     *   0x0003 指向常量池中一个CONSTANT_Class_info类型
     *   0x0013 指向常量池中一个CONSTANT_NameAndType_info类型
     *   0x07 表示第三个常量的类型 为CONSTANT_Class_info类型
     *   0x0014 指向常量池中索引为20的CONSTANT_Utf8_info类型
     */
}
