# multiple-datasource
多数据源
本项目用于springboot集成druid多数据源配置
1. 连接池druid
2. orm工具mybatis
3. 使用比较原始的配置方式
   事务通过@Transaction(name="yourname")控制，无法控制两个数据库事务
